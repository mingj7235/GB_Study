package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.FilesDAO;
import com.koreait.app.board.vo.BoardVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		BoardVO b_vo = new BoardVO();
		BoardDAO b_dao = new BoardDAO();
		FilesDAO f_dao = new FilesDAO();
		ActionForward forward = null;
		
		String saveFolder = "/Users/joshua/Desktop/JoshuaStudy/jsp/workspace/board_mvc2/WebContent/app/upload";
		
		int fileSize = 5 * 1024 * 1024; //5M
		
		MultipartRequest multi = null;
		
		//DefaultFileRenamePolicy : 파일 업로드 및 다운로드 정책(같은 이름이 존재하면 자동으로 이름이 변경되도록 한다).
		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		b_vo.setBoardTitle(multi.getParameter("boardTitle"));
		b_vo.setBoardId(multi.getParameter("boardId"));
		b_vo.setBoardContent(multi.getParameter("boardContent"));
		
		if(b_dao.insertBoard(b_vo)) {
			if(f_dao.insertFiles(b_dao.getBoardNum(), multi)) {
				//첨부파일 추가
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath(req.getContextPath() + "/board/BoardList.bo");
			}
		}
		return forward;
	}
}


















