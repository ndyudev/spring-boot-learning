package com.ndyudev.lab8.service;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class UploadService {
	@Autowired
	ServletContext app;
	
	public File save(MultipartFile file,String folder) {
		File dir = new File(app.getRealPath(folder));
		if (!dir.exists())  dir.mkdir();
		try {
			File saveFile = new File(dir,file.getOriginalFilename());
			file.transferTo(saveFile);
			return saveFile;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
