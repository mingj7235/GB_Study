package com.koreait.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

/*
 * 댓글 목록을 구현할 때 페이징처리도 해야 한다.
 * 페이징 처리를 하기 위해서는 해당 게시글의 전체 개수가 필요하므로 
 * ReplyPageDTO객체를 선언하여 두 가지 데이터를 필드로 구현해 놓는다. 
 * 
 * */
public class ReplyPageDTO {
	private int replyCnt; //해당 게시글의 총 댓글 수 
	private List<ReplyVO> list; // 해당 게시글에서 페이지에 맞는 댓글 목록 (amount는 10이다. fix해놓았다)
	
}
