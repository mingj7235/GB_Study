package com.koreait.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.domain.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller //자동으로 스프링의 객체(Bean)로 등록된다.
@RequestMapping("/sample/*") //루트경로에서 sample이라는 요청이오면 다 여기로 들어와! 라는 의미임
	//현재 클래스의 모든 메소드들의 기본 경로 설정 (예: /sample/aaa, /sample/bbb등 상위경로인 sample을 설정한것임)
	//SampleController라는 클래스에와서, 하위 경로는 메소드에 @RequestMapping("") 어노테이션 매개변수에 하위경로를 설정하는것임
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
	public String ex01(SampleDTO dto, Model model) {
		log.info(dto);
		//addAtrribute(object value) 를 사용하면 해당 객체의 클래스 타입에서 앞글자가 소문자로 바뀐 단어가 Key가 된다.
		//model.addAttribute(dto);
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02 (@RequestParam("data1") String name, @RequestParam("data2") int age, Model model) {
		log.info("name : " + name);
		log.info("age : " + age);
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "ex02";
		//url 파라미터가 다를때는 매개변수 앞에 어노테이션 @requestparam을 사용하여 받는다. 
		//기본자료형은 Model을 통해서 addAttribute를 사용하여 jsp로 넘겨주어야한다. (jsp에서는 el문으로 받는다)
	}
	
	@GetMapping ("/ex03")
	public String ex03(@RequestParam("data") ArrayList<String> datas, Model model) {
		log.info("datas : " + datas);
		model.addAttribute("datas", datas);
		return "ex03";
	}
	
	//배열에 파라미터 담기
	@GetMapping ("/ex04")
	public String ex04(@RequestParam("word") String[] words, Model model) {
		log.info("words : " + words);
		for (int i = 0; i < words.length; i++) {
			log.info("word" + i + ": " + words[i]);
		}
		
		model.addAttribute("words" , words);
		return "ex04";
	}
	

	@GetMapping ("/ex05")
	public String ex05(@RequestParam("data") String[] datas) {
		log.info("datas : " + Arrays.toString(datas));
		return "ex05";
	}
	
	@GetMapping("/ex06")
	public /*String*/ void ex06 (SampleDTO dto, @ModelAttribute("gender") String gender) {
									//이렇게 하면 기본타입인 string만 model로 jsp로 넘어가게된다. 
		log.info(dto);
		log.info("gender:" + gender);
		//return "sample/ex06";
	}
	//리턴값이 있을 필요가없다 왜냐하면 사용자가 요청한 경로(url)로 그대로 들어가니까 
	//경로가 똑같잖슴. sample/ex06은 위에서 설정한 sample 경로를 거쳐서 있는거라 이미 void로 해도된다.!!
	//위의 ex01~05는 바로 views에서 꽂히는 애들이라 sample폴더안에있는게아님. 그래서 return이 필요하다. 
	
}

