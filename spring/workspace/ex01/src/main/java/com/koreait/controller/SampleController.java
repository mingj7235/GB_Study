package com.koreait.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller //자동으로 스프링의 객체(Bean)로 등록된다.
@RequestMapping("/sample/*") //루트경로에서 sample이라는 요청이오면 다 여기로 들어와! 라는 의미임
@Log4j
public class SampleController {
	@RequestMapping("") //GET, POST 상관없이 Controller 로직을 수행한다면 method 옵션을 사용하지 않는다. 
	public void basic() {
		log.info("basic.......");
	}
	
	
	//requestmapping을 쓰는 이유는 get, post방식 둘다 쓸때 사용한다. 
	//보통은 method를 선택하여 @GetMapping 이나 @PostMapping을 쓴다. 
	@RequestMapping(value="/basic", method= {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic get .................");
	}
	
	@GetMapping ("/basicOnlyGet")
	public void basicGet2 () {
		log.info("basic get only get....");
	}
	
	//Controller는 파라미터 타입에 따라 자동으로 매핑된다. 
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info(dto);
		return "ex01";
	}
	
}
