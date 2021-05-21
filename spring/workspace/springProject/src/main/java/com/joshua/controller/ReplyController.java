package com.joshua.controller;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//댓글 모든 목록 
	@GetMapping (value = "/register/{bno}/{page}", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ReplyVO>> getList (@PathVariable("bno") long bno, @PathVariable ("page") int page) {
		
		Criteria cri = new Criteria(page, 5);
		
		return new ResponseEntity<List<ReplyVO>> (service.getListWithPaging(cri, bno), HttpStatus.OK);
		
	}
	
	//댓글 하나 조회
	
	@GetMapping(value="/{rno}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_ATOM_XML_VALUE})
	public ResponseEntity<ReplyVO> get (@PathVariable("rno") long rno) {
		
		return new ResponseEntity<ReplyVO> (service.getReply(rno), HttpStatus.OK);
	}
	
	//댓글 수정
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value="{/rno}", consumes = "application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> update (@RequestBody ReplyVO reply, @PathVariable ("rno") long rno) {
		
		return service.update(reply) == 1 ? new ResponseEntity<String> ("success", HttpStatus.OK) 
				: new ResponseEntity<String> (HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//댓글 삭제
	@DeleteMapping(value="/rno", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> delete (@PathVariable ("rno") long rno) {
		return service.delete(rno) == 1 ? new ResponseEntity<String> ("success", HttpStatus.OK)
				: new ResponseEntity<String> (HttpStatus.INTERNAL_SERVER_ERROR); 
			
	}
	
	
	
	
	
}


















