package com.joshua.domain;

import com.joshua.domain.Criteria;

public class PageDTO {
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean next, prev;
	private int total;
	private Criteria cri; //기준점 즉, 현재 페이지
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage =(int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		
		this.startPage = endPage - 9;
		
		this.realEnd = (int) (Math.ceil((total * 1.0)/ cri.getAmount()));
		
		if(realEnd< this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEnd;
	}
}
