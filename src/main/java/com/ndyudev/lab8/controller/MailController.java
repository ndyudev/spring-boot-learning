package com.ndyudev.lab8.controller;

import com.ndyudev.lab8.model.MailModel;
import com.ndyudev.lab8.service.MailService;
import com.ndyudev.lab8.service.UploadService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Controller
//@SessionAttributes(names = {"mailService"})
public class MailController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	MailService mailService;

	@Autowired
	UploadService uploadService;

	@GetMapping("/mail/test")
	public String test(Model model) {
		String result = null;
		MailModel mail = new MailModel();
		mail.setFrom("vythaianh2021@gmail.com");
		mail.setTo("thaianhvy@gmail.com");
		mail.setSubject("Test mail in Spring");
		mail.setBody("Hello World !");
		File f = new File("d:/myfile.pdf");
		mail.getFiles().add(f);
		mail.getCc().add("vythaianh2023@gmail.com");
		result = mailService.sendMail(mail);
		model.addAttribute("result", result);
		return "/lab8/mailResult";
	}

	@GetMapping("/mail/show")
	public String showMailForm(MailModel mail) {
		return "/lab8/mailForm";
	}


	@PostMapping("/mail/send")
	public String sendMail(Model model) {
		MailModel mail = new MailModel();
		mail.setFrom(request.getParameter("from"));
		mail.setTo(request.getParameter("to"));
		mail.setSubject(request.getParameter("subject"));
		mail.setBody(request.getParameter("body"));

		String cc = request.getParameter("cc");
		if (!cc.isBlank()) {
			List<String> lcc = Arrays.asList(cc.split(";"));
			mail.setCc(lcc);
		}

		String bcc = request.getParameter("bcc");
		if (!bcc.isBlank()) {
			List<String> lBcc = Arrays.asList(bcc.split(";"));
			mail.setBcc(lBcc);
		}

		String attachs = request.getParameter("attachs");
		if (!attachs.isBlank()) {
			String[] fns = attachs.split(";");
			List<File> lf = mail.getFiles();
			for (String fn:fns) {
				String path = request.getServletContext().getRealPath("temps");
				File f = new File(path + "/" +  fn);
				lf.add(f);
			}
		}
		String result = mailService.sendMail(mail);
		model.addAttribute("result", result);
		return "/lab8/mailForm";
	}

	@PostMapping("/mail/upload")
	public String sendFileWithMail(MultipartFile[] loads,Model model) {
		String s = "";
		for (MultipartFile f : loads) {
			uploadService.save(f, "temps");
			if (!s.isEmpty()) s += ";";
			s += f.getOriginalFilename();
		}
		System.out.println(s);
		model.addAttribute("filenames",s);
		return "/lab8/mailForm";
	}

	@GetMapping("/mail/automail")
	@ResponseBody
	public void autoMail() {
		mailService.getQueue().clear();
		mailService.push("thaianhvy@gmail.com", "Auto Mail", "Hello World !");
		mailService.push("vythaianh2023@gmail.com", "Auto Mail", "Hello World !");
	}


}
