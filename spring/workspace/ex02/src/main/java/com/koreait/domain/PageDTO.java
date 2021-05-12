package com.koreait.domain;

import lombok.Getter;
import lombok.ToString;

@Getter	//setter는 안필요하므로 게터 넣음
@ToString //tostring도 있으면좋으니까 넣음
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean next, prev;
	private int total;
	private Criteria cri; //현재 페이지 
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10; //마지막 페이지 구하는법 (페이지에서 보이는 마지막 페이지)
						//ceil을 통해서 올림을 해준다. 0.1, 0.2 ~~ 1 까지 모두 올림해주서 다 10을 만드는것임
		this.startPage = endPage - 9;
		
		this.realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
								/*실수로 바꿔주기위해 1.0을 곱해준다.*/
							//이렇게해주는 이유는 152번째글이있으면 15페이지 + 나머지를 위한 1페이지를 위해서다. 
		if(realEnd< this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.realEnd;
		
	}
}
