package com.koreait.app.board;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionForward;
import com.koreait.app.board.dao.BoardDAO;
import com.koreait.app.board.dao.FilesDAO;
import com.koreait.app.board.vo.BoardVO;
import com.koreait.app.board.vo.FilesVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardModifyOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		BoardDAO b_dao = new BoardDAO();
		FilesDAO f_dao = new FilesDAO();
		
		MultipartRequest multi = null;
		
		String saveFolder = "/Users/joshua/Desktop/JoshuaStudy/jsp/workspace/board_mvc2/WebContent/app/upload";
		int fileSize = 5 * 1024 * 1024;
		
		try {
			BoardVO b_vo = new BoardVO();
			multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			
			int page = Integer.parseInt(multi.getParameter("page"));
			int boardNum = Integer.parseInt(multi.getParameter("boardNum"));
			
			//업로드 경로 파일 삭제
			for(FilesVO file : f_dao.getFileList(boardNum)) {
				File f = new File(saveFolder, file.getFileName());
				if(f.exists()) {
					f.delete();
				}
			}
			
			//DB 삭제
			f_dao.deleteFile(boardNum);
			
			//새롭게 추가한 첨부파일 DB에 추가
			f_dao.insertFiles(boardNum, multi);
			
			b_vo.setBoardNum(boardNum);
			b_vo.setBoardTitle(multi.getParameter("boardTitle"));
			b_vo.setBoardContent(multi.getParameter("boardContent"));
			
			b_dao.updateBoard(b_vo);
			
			forward.setRedirect(true);
			//기본 제공 프로퍼티는 req로 접근한다.
			forward.setPath(req.getContextPath() + "/board/BoardView.bo?boardNum=" + b_vo.getBoardNum() + "&page="+page);
			
		} catch (Exception e) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=UTF-8");
			out.println("<script>");
			out.println("alert('게시글 수정 실패. 다시 시도해주세요.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
			return null;
		}
		return forward;
	}

}














