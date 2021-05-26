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
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form");
	}
	
	@PostMapping ("/uploadFormAction")
	public void uploadFormPost (MultipartFile[] uploadFile) { //여러개를 파일을 받으므로 multipartfile의 배열 형태로 받는다
															//객체 명은 jsp에서 날아오는 name과 같다. uploadFile의 파라미터가 여러개가 날아오기때문에			
															//배열로 받는 것이다. 
		
		String uploadFolder = "/Users/joshua/upload";

		for(MultipartFile multipartFile : uploadFile) {
			log.info("=======");
			log.info("업로드 파일 명 : "  + multipartFile.getOriginalFilename());
			log.info("업로드 파일 크기 " + multipartFile.getSize());
			
			//파일을 업로드하기위해서 File 타입의 객체를 선언해야한다. 
			//경로와, 파일의 이름을 File 객체에 담아주고, 
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			try {
				//transferTo 메소드를 통해 전달하여 파일을 해당 경로에 넣어준다. 
				multipartFile.transferTo(saveFile);//전달받은 파일의 바이트를 다 쪼개서 해당 경로에 넣어준다. 얘가 다 해준다. 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}










