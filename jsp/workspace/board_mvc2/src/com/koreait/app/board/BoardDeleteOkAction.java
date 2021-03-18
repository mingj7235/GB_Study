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
		
		String saveFolder = "D:\\0900_gb_kmj\\jsp\\workspace\\board_mvc2\\WebContent\\app\\upload";
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		int page = Integer.parseInt(req.getParameter("page"));
		
		//파일 삭제(2개 로직 작성)
//		김사원~ 게시글에 첨부파일 업데이트 되었으니까
//		게시글 삭제 부분 첨부파일 삭제부분 추가해서 업데이트 좀 해줘~
//		네 알겠습니다.
		
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











