package com.koreait.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.ibatis.javassist.compiler.ast.InstanceOfExpr;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.domain.AllFileDTO;
import com.koreait.domain.AttachFileDTO;

import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

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
	
	//첨부파일을할때는 자동으로 multipartfile로 들어가기때문에 consumes가 필요없다. 
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<AllFileDTO> uploadAjaxAction (MultipartFile[] uploadFile) {
		log.info("upload ajax post.....");
		String uploadFolder = "/Users/joshua/upload";
		
		//폴더를 만들기위해서 쓰는 것이다. 
		//사용자가 업로드를 한 시간인 년, 월, 일을 디렉토리로 만드는 getFolder()를 사용한다.
		String uploadFolderPath = getFolder(); //연월일을 만든것임 
		
		File uploadPath = new File(uploadFolder, uploadFolderPath);
		
		AllFileDTO allFile = new AllFileDTO();
		List<AttachFileDTO> succeedlist = new ArrayList<AttachFileDTO>();
		List<AttachFileDTO> failurelist = new ArrayList<AttachFileDTO>();
		
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
			
			AttachFileDTO attachDTO = new AttachFileDTO();
			
			String uploadFileName = multipartFile.getOriginalFilename();
			//IE에서는 파일 이름만 가져오지 않고 전체 경로를 가져오기 때문에 마지막에 위치한 파일 이름만 가져오도록 한다.
			//IE이외의 브라우저에서는 \\가 없기 때문에 -1 + 1 로 연산되어 0번째, 즉 파일이름을 의미한다. 
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("/")+1);
			
			log.info("실제 파일 명 : " + uploadFileName);
			
			//모델객체에 파일이름을 담기
			attachDTO.setFileName(uploadFileName);
			
			//랜덤한 UUID를 담아 놓는다.
			UUID uuid = UUID.randomUUID(); //340간개... 개많음 ㅋㅋㅋㅋㅋㅋㅋ
			
			//파일이름이 중복되더라도 이름 앞에 UUID를 붙여주기 때문에 중복될 가능성이 희박하다.
			//덮어씌워지는 것을 방지한다. 
			uploadFileName = uuid.toString() + "_" + uploadFileName; //중복을 피하기 위해 파일 이름앞에 uuid를 붙인다. 
			
			try {
				File saveFile = new File(uploadPath, uploadFileName);//원본파일
				multipartFile.transferTo(saveFile); //업로드 하게되면 이 이미지를 다시 가져와서 바이트로 변경시켜준다 뭘 통해서 ? inputStream !! 이걸 통해서 썸네일을 만드는것이다. 
				InputStream in = new FileInputStream(saveFile); //썸네일에 넣기위해 업로드된 파일을 가져옴
				
				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);
				
				//파일이 이미지인지 검사 
				if(checkImg(saveFile)) {
					
					
					attachDTO.setImage(true); //이미지 인것을 확인하기위해 
					
					//Stream은 파일을 통신할 때 byte가 이동할 경로이다. 
					
					//이미지라면 섬네일 만들기 ! 
					FileOutputStream thumbnail = new FileOutputStream(new File (uploadPath, "s_" + uploadFileName)); //얘도 바이트로 다시 전달하는 통
					
					//사용자가 첨부한 파일은 multipart에 담겨있으므로 이걸 통해서 가져오고, (첫번째 매개변수)
					//원하는 w, h를 지정한 후 변경된 이미지 파일을 FileOutPutStream 객체를 통해 (thumbnail) 업로드한다. (두번째 매개변수)
					//Thumbnailator는 중간관리의 역할을 한다.
					//스트림이 통로가 되어서 바이트가 이동한다.
					
					Thumbnailator.createThumbnail(in, thumbnail, 100, 100);
					thumbnail.close();
				}
				succeedlist.add(attachDTO);
				
			} catch (Exception e) {
				failurelist.add(attachDTO);
				e.printStackTrace();
			} 
		}
		allFile.setSucceedList(succeedlist);
		allFile.setFailureList(failurelist);
		return new ResponseEntity<AllFileDTO> (allFile, HttpStatus.OK);
	}
	
	@GetMapping("/display")
	@ResponseBody //REST 방식 
	public ResponseEntity<byte[]> getFile (String fileName) {
		log.info("fileName :"  + fileName);
		File file = new File ("/Users/joshua/upload/" + fileName);
		log.info("file : " + file);
		
		ResponseEntity<byte[]> result = null;
		HttpHeaders header = new HttpHeaders();
		
		try {
			//헤더에 적절한 파일의타입을 probeContentType을 통하여 포함시킨다. 
			header.add("Content-Type", Files.probeContentType(file.toPath())); //content-type을 mime 타입으로 담는다. 
			result = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file) ,header ,HttpStatus.OK); //이미지 파일 자체가 날아간다. 
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
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
		//MIME 
		return Files.probeContentType(file.toPath()).startsWith("image"); //이미지라면 true. 즉 섬네일을 만들야한다.  
	}
	
}










