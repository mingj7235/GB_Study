package com.koreait.controller;

import java.io.File;
import java.io.IOException;

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
	public void uploadAjaxActionReview () {
		
	}
	
}










