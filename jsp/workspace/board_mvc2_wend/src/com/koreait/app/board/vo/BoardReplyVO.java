package com.koreait.app.board.vo;

//REPLYNUM NUMBER(10),
//BOARDNUM NUMBER(10),
//MEMBERID VARCHAR2(100),
//REPLYCONTENT VARCHAR2(4000),

public class BoardReplyVO {
	private int replyNum;
	private int boardNum;
	private String memberId;
	private String replyContent;
	
	public BoardReplyVO() {;}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
}
