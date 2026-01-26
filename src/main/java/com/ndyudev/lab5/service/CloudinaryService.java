package com.ndyudev.lab5.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService() {
        Dotenv dotenv = Dotenv.load();

        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", dotenv.get("CLOUDINARY_NAME"),
                "api_key",    dotenv.get("CLOUDINARY_KEY"),
                "api_secret", dotenv.get("CLOUDINARY_SECRET"),
                "secure", true));
    }

    public String upload(MultipartFile file) {
        try {
            Map r = this.cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));

            return (String) r.get("secure_url");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}