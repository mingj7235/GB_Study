package com.koreait.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

//Criteria : 검색의 기준
@Data
@AllArgsConstructor
public class Criteria {
	private int pageNum;
	private int amount;
	
	//디폴트 값이다. 이걸 기본으로 하는것이고 AllArgsContstructor를 통해서 다음이 넘겨진다.
	public Criteria() {
		this(1, 10);
	}
}
