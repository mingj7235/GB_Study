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
	public void uploadForm () {
		log.info("upload form");
	}
	
	@PostMapping ("/uploadFormAction") //jsp에서 uri 로 요청
	public void uploadFormPost (MultipartFile[] uploadFile) {
		for (MultipartFile multipartFile : uploadFile) {
			
			String fileName = multipartFile.getOriginalFilename();
			Long fileSize = multipartFile.getSize();
			
			log.info("filename : " + fileName);
			log.info("filesize : " + fileSize);
			
			File saveFile = new File(uploadFolder, fileName);
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	
}
