package com.koreait.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
public class UploadController {
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form");
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}
	
	
	
	@PostMapping ("/uploadFormAction")
	//외부에서 여러개의 파일이 전달될 수 있으므로 배열로 받는다. 
	public void uploadFormPost (MultipartFile[] uploadFile) { //여러개를 파일을 받으므로 multipartfile의 배열 형태로 받는다
															//객체 명은 jsp에서 날아오는 name과 같다. uploadFile의 파라미터가 여러개가 날아오기때문에			
															//배열로 받는 것이다. 
		
		//업로드 할 경로 
		String uploadFolder = "/Users/joshua/upload";

		//각 multipart 객체를 순서대로 가져온 후 
		for(MultipartFile multipartFile : uploadFile) {
			//원하는 데이터를 메소드로 가져온다. 
			log.info("=======");
			log.info("업로드 파일 명 : "  + multipartFile.getOriginalFilename());
			log.info("업로드 파일 크기 " + multipartFile.getSize());
			
			//파일을 업로드하기위해서 File 타입의 객체를 선언해야한다. 
			//경로와, 파일의 이름을 File 객체에 담아주고,
			//전체 경로를 File 객체에 담아준다. 
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			try {
				//transferTo 메소드를 통해 전달하여 파일을 해당 경로에 넣어준다.
				//해당 경로에 파일을 업로드 해준다.
				multipartFile.transferTo(saveFile);//전달받은 파일의 바이트를 다 쪼개서 해당 경로에 넣어준다. 얘가 다 해준다. 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	@PostMapping("/uploadAjaxAction")
	public void uploadAjaxAction (MultipartFile[] uploadFile) {
		log.info("upload ajax post.....");
		String uploadFolder = "/Users/joshua/upload";
		
		//폴더를 만들기위해서 쓰는 것이다. 
		//사용자가 업로드를 한 시간인 년, 월, 일을 디렉토리로 만드는 getFolder()를 사용한다.  
		File uploadPath = new File(uploadFolder, getFolder());
		
		//만약 해당 디렉토리가 존재하지 않으면 
		if(!uploadPath.exists()) {
			//존재하지 않을경우 mkdirs() 메소드를 통해 만들어준다. 
			uploadPath.mkdirs(); //존재하지 않을 경우에 이렇게 해주라는 것임 
							//즉, 년,월,일 폴더가 만들어진다 
		}
		
		for(MultipartFile multipartFile : uploadFile) {
			log.info("=======");
			log.info("업로드 파일 명 : "  + multipartFile.getOriginalFilename());
			log.info("업로드 파일 크기 " + multipartFile.getSize());	
			
			String uploadFileName = multipartFile.getOriginalFilename();
			//IE에서는 파일 이름만 가져오지 않고 전체 경로를 가져오기 때문에 마지막에 위치한 파일 이름만 가져오도록 한다.
			//IE이외의 브라우저에서는 \\가 없기 때문에 -1 + 1 로 연산되어 0번째, 즉 파일이름을 의미한다. 
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("/")+1);
			
			log.info("실제 파일 명 : " + uploadFileName);
			
			//랜덤한 UUID를 담아 놓는다.
			UUID uuid = UUID.randomUUID(); //340간개... 개많음 ㅋㅋㅋㅋㅋㅋㅋ
			
			//파일이름이 중복되더라도 이름 앞에 UUID를 붙여주기 때문에 중복될 가능성이 희박하다.
			//덮어씌워지는 것을 방지한다. 
			uploadFileName = uuid.toString() + "_" + uploadFileName; //중복을 피하기 위해 파일 이름앞에 uuid를 붙인다. 
			
			File saveFile = new File(uploadPath, uploadFileName);
			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	//파일경로를 날짜별로 변경하기 위해 만드는 내부에서 쓰이는 메소드
	private String getFolder () {
		//현재 날짜에서 -를 \\로 변경해준다. 즉, separator를 통해 파일의 디렉토리를 구분하는 것으로 변경해주는 것이다. 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator); //separator : 파일의 경로를 나눠주는 구분점. 즉, 가져온 날짜의 - 를 구분점으로 경로를 지정 ! 
	}
	
	//이미지 파일인지 아닌지 검사하는것(썸네일을 위해서 만든느것임)
	private boolean checkImg(File file) throws IOException{
		//앞에 헤더에 img파일이면 image라고 나온다. (내부적) 그걸 검사해면된다. 즉, file의 content타입
		
		//즉, 파일을 전달한것의 타입이 무엇이니1? 물어보는것인데, 이게 image니!? 라고 물어보는 것임 
		
		//사용자가 업로드한 파일의 타입 중앞부분이 image로 시작한다면 이미지 파일이다. 
		return Files.probeContentType(file.toPath()).startsWith("image"); 
	}
	
}










