package com.koreait.app.board;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.FilesDAO;
import com.koreait.app.board.vo.FilesVO;

public class BoardDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		BoardDAO b_dao = new BoardDAO();
		FilesDAO f_dao = new FilesDAO();
		ActionForward forward = new ActionForward();

		//리눅스 서버로 출시 후 서비스 제공 시 업로드 경로는 아래와 같이 사용하여 작업한다. 
		//req.getServletContext().getRealPath("/")
		
		String saveFolder = "/Users/joshua/Desktop/JoshuaStudy/jsp/workspace/board_mvc2/WebContent/app/upload";
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		//파일 삭제(2개 로직 작성)
		
		for(FilesVO file : f_dao.getFileList(boardNum)) {
			File f = new File(saveFolder, file.getFileName());
			if(f.exists()) {
				f.delete();
			}
		}
		
		
		
		f_dao.deleteFile(boardNum);
		
		b_dao.deleteBoard(boardNum);
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath() + "/board/BoardList.bo?page=" + page);
		
		return forward;
	}

}











