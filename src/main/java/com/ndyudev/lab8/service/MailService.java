package com.ndyudev.lab8.service;

import com.ndyudev.lab8.model.MailModel;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MailService {

	@Autowired
	JavaMailSender sender;

	// ✅ Dùng synchronizedList để tránh lỗi khi vừa thêm vừa xóa cùng lúc
	List<MimeMessage> queue = Collections.synchronizedList(new ArrayList<>());

	public List<MimeMessage> getQueue() {
		return queue;
	}

	// Helper tạo MimeMessage chuẩn
	private MimeMessage createMimeMessage(MailModel mail) {
		try {
			MimeMessage msg = sender.createMimeMessage();
			// true = multipart (để đính kèm file)
			MimeMessageHelper helper = new MimeMessageHelper(msg, true, "utf-8");

			helper.setFrom(mail.getFrom() != null ? mail.getFrom() : "noreply@system.com");
			helper.setTo(mail.getTo());
			helper.setSubject(mail.getSubject());
			helper.setText(mail.getBody(), true); // true = cho phép HTML

			if (mail.getCc() != null) {
				for (String cc : mail.getCc()) helper.addCc(cc);
			}
			if (mail.getBcc() != null) {
				for (String bcc : mail.getBcc()) helper.addBcc(bcc);
			}
			if (mail.getFiles() != null) {
				for (File f : mail.getFiles()) helper.addAttachment(f.getName(), f);
			}
			return msg;
		} catch (MessagingException e) {
			e.printStackTrace();
			return null;
		}
	}

	// 1. Đẩy vào hàng đợi (Dùng cho Scheduler)
	public void push(MailModel mail) {
		MimeMessage msg = createMimeMessage(mail);
		if (msg != null) {
			queue.add(msg);
		}
	}

	// Overload hàm push cho tiện
	public void push(String to, String subject, String body) {
		MailModel mail = new MailModel();
		mail.setFrom("vythaianh2021@gmail.com"); // Set mặc định hoặc lấy từ config
		mail.setTo(to);
		mail.setSubject(subject);
		mail.setBody(body);
		this.push(mail);
	}

	// 2. Scheduler: Chạy ngầm để quét hàng đợi
	// initialDelay: Chờ 2s sau khi web chạy mới bắt đầu quét
	// fixedDelay: Quét xong, nghỉ 1s rồi quét tiếp (An toàn hơn fixedRate)
	@Scheduled(fixedDelay = 1000, initialDelay = 2000)
	public void run() {
		// Chỉ chạy khi có mail để đỡ tốn tài nguyên
		if (queue.isEmpty()) return;

		int success = 0, errors = 0;
		int currentSize = queue.size();

		System.out.println("Dang xu ly hang doi: " + currentSize + " mails...");

		while (!queue.isEmpty()) {
			// Lấy ra và xóa khỏi hàng đợi (First In First Out)
			MimeMessage msg = queue.remove(0);
			try {
				sender.send(msg);
				success++;
			} catch (Exception e) {
				errors++;
				System.err.println("Loi gui mail: " + e.getMessage());
			}
		}
		System.out.printf("Ket qua Scheduler -> Success: %d, Errors: %d\n", success, errors);
	}

	// 3. Gửi trực tiếp (Không qua hàng đợi)
	public String sendMail(MailModel mail) {
		MimeMessage msg = createMimeMessage(mail);
		if (msg != null) {
			try {
				sender.send(msg);
				return "Gửi mail thành công!";
			} catch (Exception e) {
				return "Lỗi gửi mail: " + e.getMessage();
			}
		}
		return "Lỗi tạo mail!";
	}

	// Demo Async
	@Async
	public void task1() throws InterruptedException {
		char c = 'A';
		while (c < 'Z') {
			System.out.println(c++);
			Thread.sleep(300);
		}
	}
}