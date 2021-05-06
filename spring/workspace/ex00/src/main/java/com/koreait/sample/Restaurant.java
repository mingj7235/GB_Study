package com.koreait.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

//②
@Component
@Data
public class Restaurant {
	
	// ③
	
//	private Chef chef = new Chef(); 이렇게 안하기 위해서 의존성 주입을 한다. 
	//onMethod : 이 메소드에(setter메소드) Autowired라는 어노테이션을 붙여라 라는 의미임
	//autowired를 통해 붙어서 오는것임
	//*onMethod 속성은 생성되는 setChef에 @Autowired 어노테이션을 추가하도록 할 때 사용된다.
	//버전에 따라 onMethod 혹은 onMethod_ 를 사용하게된다. 
	
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
}
