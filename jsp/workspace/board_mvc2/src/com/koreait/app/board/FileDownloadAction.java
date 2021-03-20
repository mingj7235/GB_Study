package com.koreait.app.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

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
		String savePath = "/Users/joshua/Desktop/JoshuaStudy/jsp/workspace/board_mvc2/WebContent/app/upload";
		
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
			//file = new File(savePath + "\\" + fileName);
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
		resp.setContentType("application/octet-stream");	//파일 다운로드 타입 설정
		resp.setHeader("Content-Description", "JSP Generated Data");	//컨텐츠 설명 수정
		
		if(check) {
			try {
				//출력할 파일의 인코딩 설정
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
				
				//IE
//			if(client.contains("MSIE")) {
				if(client.indexOf("MSIE") != -1) {
					resp.setHeader("Content-Disposition", "attachment;filename="+fileName);
				}else {
					resp.setHeader("Content-Disposition", "attachment;filename=\""+fileName + "\"");
					resp.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
				}
				resp.setHeader("Content-Length", "" + file.length());
				
				//충돌이 발생할 수 있는 공유 공간을 비워준다.
				writer.flush();
				
				out = resp.getOutputStream();
				
				//읽어온 바이트를 담아줄 배열
				byte[] b = new byte[(int)file.length()];
				
				//바이트 데이터(내용)을 저장할 변수
				int len = 0;
				while((len = in.read(b)) > 0) {
					//전체 내용에서(b) 첫번째 바이트부터(offset:0) 읽어온 내용(len)을 순차적으로 출력한다.
					out.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(in != null) {
						in.close();
					}
					if(out != null) {
						out.close();
					}
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
			}
		}
		return null;
	}
}












