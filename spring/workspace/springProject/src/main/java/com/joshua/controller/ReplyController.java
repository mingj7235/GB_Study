package com.joshua.controller;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joshua.domain.Criteria;
import com.joshua.domain.ReplyVO;
import com.joshua.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RequestMapping ("/replies/")
@RestController
@Log4j
public class ReplyController {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyService service;
	
	//댓글 등록
	
	@PostMapping (value ="/new", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> register (@RequestBody ReplyVO reply){
		
		return service.register(reply) == 1 ? new ResponseEntity<String> ("success", HttpStatus.OK)
				: new ResponseEntity<String> (HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//댓글 조회
	@GetMapping (value = "/register/{bno}/{page}", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList (@Param("bno") long bno, @Param("page") int page) {
		
		Criteria cri = new Criteria(page, 5);
		
		return new ResponseEntity<List<ReplyVO>> (service.getListWithPaging(cri, bno), HttpStatus.OK);
		
	}
	
	
}


















