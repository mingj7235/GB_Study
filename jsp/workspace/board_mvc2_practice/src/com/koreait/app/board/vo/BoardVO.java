package com.koreait.app.board.vo;
/*BOARDNUM NUMBER(10),
BOARDTITLE VARCHAR2(1000),
BOARDCONTENT VARCHAR2(3000),
BOARDID VARCHAR2(100),
BOARDDATE DATE,
CONSTRAINT BOARD_PK PRIMARY KEY(BOARDNUM),
CONSTRAINT BOARD_FK FOREIGN KEY(BOARDID) REFERENCES TABLE_MEMBER(MEMBERID)*/
public class BoardVO {
	
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardId;
	private String boardDate;
	
	public BoardVO() {;}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}


	
	
}
