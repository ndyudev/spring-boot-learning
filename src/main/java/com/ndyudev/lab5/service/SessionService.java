package com.ndyudev.lab5.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
    @Autowired
    HttpSession session;

    /**
     * Đọc giá trị từ session
     * @param name tên của biến trong session
     * @return giá trị đọc được hoặc null nếu không tồn tại
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) session.getAttribute(name);
    }

    /**
     * Đọc giá trị từ session (Có giá trị mặc định)
     * Giúp code Controller an toàn hơn
     */
    public <T> T get(String name, T defaultValue) {
        T value = get(name);
        return value != null ? value : defaultValue;
    }

    /**
     * Thay đổi giá trị vào session
     * @param name tên của biến trong session
     * @param value giá trị cần lưu
     */
    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    /**
     * Xóa attribute trong session
     * @param name tên của biến trong session
     */
    public void remove(String name) {
        session.removeAttribute(name);
    }

    /**
     * Xóa toàn bộ session (Dùng khi Đăng xuất)
     */
    public void clear() {
        session.invalidate();
    }
}