package com.koreait.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

//Criteria : 검색의 기준
@Data
@AllArgsConstructor
public class Criteria {
	private int pageNum;
	private int amount;
	
	//[1] 
	//외부에서 사용자가 선택한 카테고리를 대표하는 문자열을 type으로 전달받는다 (예: 제목 또는 내용 선택시 "TC" 전달됨)
	//사용자가 검색하고 싶은 키워드를 keyword로 전달 받는다. 
	private String type;
	private String keyword;
	
	//디폴트 값이다. 이걸 기본으로 하는것이고 AllArgsContstructor를 통해서 다음이 넘겨진다.
	public Criteria() {
		this(1, 10);
	}
	
	//default를 위해 오버라이딩으로 생성자를 만들어줌.
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//[2]
	//사용자가 다중 항목을 선택했을 경우 각 항목을 분리해야 하기 때문에,
	//단일 항목들을 문자열 타입으로 리턴해준다.
	//MyBatis에서는 getter를 찾아서 실행하므로, typeArr변수 선언 없이 getter만 선언한다. 
	public String[] getTypeArr() { //xml에 있는 동적쿼리의 foreach에들어갈 typearr는 메소드로 인식한다. 그렇기에 여기서 바로 만들어준다.
		return type == null ? new String[] {} : type.split("");
		//type을 배열로 split을 통해서 배열로만들어주는것이다. 
		
	}
	
	public String getListLink() {
		//쿼리스트링을 만들어주는 라이브러리 즉, jsp에있는 get형식 뒤에 붙는 쿼리스트링을 이걸로 끝낸다!
		//?가 앞에 붙는다.
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount)
				.queryParam("keyword", this.getKeyword())
				.queryParam("type", this.getType());
		
		return builder.toUriString();
						
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
