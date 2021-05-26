package com.koreait.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class UploadController_review {
	
	String uploadFolder = "/Users/joshua/upload";
	
	@GetMapping ("/uploadFormReview")
	public void uploadFormReview () {
		log.info("upload form...");
	}
	
	@PostMapping ("/uploadFormActionReview")
	public void uploadFormPostReview (MultipartFile[] uploadFiles) {
		
		for (MultipartFile multipartFile : uploadFiles) {
			
			String fileName = multipartFile.getOriginalFilename();
			Long fileSize = multipartFile.getSize();
			
			log.info("fileName : " + fileName);
			log.info("fileSize : " + fileSize);
			
			File saveFile = new File(uploadFolder, fileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@GetMapping ("/uploadAjaxReview")
	public void uploadAjaxReview () {
		log.info("upload Ajax review...");
	}
	
	@PostMapping ("/uploadAjaxActionReview")
	public void uploadAjaxActionReview (MultipartFile[] uploadFiles) {
		log.info("upload ajax post....");
		
		File uploadPath = new File(uploadFolder, getFolder());
		
		if (!uploadPath.exists()) {
			uploadPath.mkdir();
		}
				
		
		for (MultipartFile multipartFile : uploadFiles) {
			
			String fileName = multipartFile.getOriginalFilename();
			Long fileSize = multipartFile.getSize();
			UUID uuid = UUID.randomUUID();
			
			fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
			fileName = uuid.toString() + "_" + fileName;
			
			File saveFile = new File(uploadFolder, fileName);
			
			try {
				multipartFile.transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}
	
}






















