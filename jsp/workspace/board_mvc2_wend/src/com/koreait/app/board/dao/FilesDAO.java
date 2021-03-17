package com.koreait.app.board.dao;

import java.util.Enumeration;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.app.board.vo.FilesVO;
import com.koreait.mybatis.config.SqlMapConfig;
import com.oreilly.servlet.MultipartRequest;

public class FilesDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession session;
	
	public FilesDAO() {
		session = sessionf.openSession(true);
	}
	
	public boolean insertFiles(int boardNum, MultipartRequest multi) {
		boolean check = true;
		FilesVO vo = new FilesVO();
		//사용자가 업로드한 원본 파일명
		Enumeration<String> files = multi.getFileNames();
		
		while(files.hasMoreElements()) {
			String data = files.nextElement();
			//사용자가 업로드한 파일명을 통해서 중복이 없도록 변경된 시스템 파일명을 가져온다.
			String systemName = multi.getFilesystemName(data);
			if(systemName == null) {continue;}
			
			vo.setFileName(systemName);
			vo.setBoardNum(boardNum);
			
			if(session.insert("Files.insertFile", vo) != 1) {
				check = false;
				break;
			}
		}
		return check;
	}
	
	public List<FilesVO> getFileList(int boardNum) {
		return session.selectList("Files.getFileList", boardNum);
	}
	
	public void deleteFile(int boardNum) {
		session.delete("Files.deleteFile", boardNum);
	}
}













