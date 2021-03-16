package com.koreait.app.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;

public class FileDownloadAction implements Action {

	
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		//요청된 파일이 저장되어 있는 경로
		String savePath="D:\\0900_gb_kmj\\jsp\\workspace\\board_mvc2\\WebContent\\app\\upload";
		
		//사용자가 다운로드를 요청한 파일의 이름을 전달받는다.
		String fileName = req.getParameter("fileName");
		
		//Stream을 사용하기 때문에 충돌방지를 위해 사전에 객체 생성
		PrintWriter writer = resp.getWriter();		
		
		//파일 불러오기
		InputStream in = null;
		
		//다운로드 출력
		OutputStream out = null;
		
		//해당 파일의 정보를 담을 객체
		File file = null;
		
		boolean check = true;
		
		try {
			//file = new File(savePath + "\\" + filename);
			file = new File(savePath, fileName);
			
			//해당 파일을 byte로 읽어 온다.
			in = new FileInputStream(file);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
			check = false;
			e.printStackTrace();
		}
		
		
		//브라우저 정보를 가져온다.
		String client = req.getHeader("User-Agent");
		
		resp.reset();
		resp.setContentType("application/octet-stream"); //파일 다운로드 타입 설정
		resp.setHeader("Content-Description", "JSP Generated Data"); //컨텐트 설명 수정
		
		if(check) {
			//바이트로 변환해도 한글이 깨지지 않게끔 하는 방법 
			//출력할 파일의 인코딩 설정
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			
			//IE인지 아닌지 따져야한다.
			//if(client.contains("MSIE"))
			if(client.indexOf("MSIE") != -1) { //MSIE를 가지고 있는지 아닌지 검사하는것임
				//IE라는 말임
				resp.setHeader("Content-Dispostion", "attachment;filename="+fileName);
			} else {
				//IE가 아닌경우 (다른브라우저)
				resp.setHeader("Content-Dispostion", "attachment;filename=\""+fileName+"\"");
				resp.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
			}
			resp.setHeader("Content-Length", "" + file.length());
			
			//충돌이 발생할 수 있는 공유 공간을 비워준다.
			writer.flush();
			
			out = resp.getOutputStream();
			
			byte[] b = new byte[(int)file.length()];
			
			int len = 0;
			while((len = in.read(b)) > 0) {
				out.write(b, 0, len);
			}
		}
		
		
		
		return null;
	}

}















