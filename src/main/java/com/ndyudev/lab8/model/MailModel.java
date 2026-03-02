package com.ndyudev.lab8.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailModel {
	
	String from = "chauunhatduyyit@gmail.com";
	String to;
	String subject;
	String body;
	List<String> cc = new ArrayList<>();
	List<String> bcc = new ArrayList<>();
	List<File> files = new ArrayList<>();
	
	public MailModel(String to, String subject, String body) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	
}
