package com.ndyudev.lab5.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamService {
    @Autowired
    HttpServletRequest request;

    /**
     * Đọc chuỗi giá trị của tham số
     *
     * @param name         của param
     * @param defaultValue
     * @return
     */
    public String getString(String name, String defaultValue) {
        String value = request.getParameter(name);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        return value;
    }

    /**
     * Đọc số nguyên của tham số
     *
     * @param name         của param
     * @param defaultValue
     * @return integer value
     */
    public int getInt(String name, int defaultValue) {
        String value = request.getParameter(name);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        return Integer.parseInt(value);
    }

    /**
     * Đọc số thực của tham số
     *
     * @param name         của param
     * @param defaultValue
     * @return double value
     */
    public Double getDouble(String name, Double defaultValue) {
        String value = request.getParameter(name);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        }
        return Double.parseDouble(value);
    }

    ;

    /**
     * Đọc giá trị boolean của tham số
     *
     * @param name
     * @param defaultValue
     * @return
     */
    public Boolean getBoolean(String name, Boolean defaultValue) {
        String value = request.getParameter(name);
        if (value == null || value.isEmpty()) {
            return defaultValue;
        } else {
            return Boolean.parseBoolean(value);
        }
    }

    /**
     * Đọc giá trị ngày tháng của tham số
     *
     * @param name
     * @param pattern định dạng ngày tháng (VD: "dd/MM/yyyy")
     * @return Date value
     */
    public Date getDate(String name, String pattern) {
        String value = request.getParameter(name);
        if (value == null || value.isEmpty()) {
            return null;
        }
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("Loi dinh dang ngay thang!");
        }
    }

    /**
     * Lưu file upload từ client lên server
     *
     * @param file MultipartFile
     * @param path đường dẫn lưu file trên server
     * @return File đã lưu
     */
    public File save(MultipartFile file, String path) {
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File savedFile = new File(dir, file.getOriginalFilename());
            file.transferTo(savedFile);
            return savedFile;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
