package com.koreait.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.domain.ReplyVO;
import com.koreait.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController //restcontroller는 자동으로 view resolver로 가지 않는다.즉, return을 내마음대로 할수 있다.
				//각 메소드의 리턴은 ViewResolver로 가지 않으므로 매소드의 return값을 그대로 리턴한다. (뒤에 .jsp가 붙지않는다.)
@Log4j
public class ReplyController {
	@Setter (onMethod_ = @Autowired)
	private ReplyService service;
	
	//댓글 등록
	//브라우저에서 JSON타입으로 데이터를 전송하고(consumes) 서버에서는 댓글의 처리 결과에 따라 문자열로 결과를 리턴한다 (produces).
	//consumes : Ajax를 통해 전달 받은 데이터의 타입
	//produces : Ajax의 success:function(result)에 있는 result로 전달할 데이터의 타입! 
	
	@PostMapping(value="/new", consumes="application/json", produces = {MediaType.TEXT_PLAIN_VALUE})
								//consumes :외부에서 전달받을 데이터	//produces 는 제공을 하겠다.! 즉 응답할 타입이다.
			//REST이기때문에 기존서버가 아니라 다른 서버에서 운영함. 데이터만 가져올것이기때문에 Ajax를 사용한다. 
			//data를 json으로 
	
	//responseentity는 응답할 값과 상태코드를 보내주는 것이다.
	//ResponseEntity : 서버의 상태코드, 응답 메세지등을 담을 수 있는 타입. TEXT로 응답하므로 String으로 리턴한다. (TEXT_PLAIN_VALUE)
	//@RequestBody 를 적용하여 JSON데이터를 ReplyVO타입으로 변환하도록 지정한다. 
	public ResponseEntity<String> create (@RequestBody ReplyVO reply) { //@RequestBody는 외부에서 전달받은 json을 ReplyVO로 파싱해주는것이다.
		int insertCnt = 0;
		log.info("ReplyVO:" + reply);
		insertCnt = service.register(reply);
		log.info("reply insert count : " + insertCnt);
		
													
		return insertCnt == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : //성공했을때 즉 200 ok! ajax로 응답하는것이다.
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); //500 서버에러 !! 즉, insert가 안되었을 때 
		
		
		 /* RestController라는 어노테이션을 사용했기에 return이 그대로 return이 되는 것이다. (viewresolver를 통해 .jsp가 붙지않는다.)
		 * json으로 요청을 받고, text로 응답하는 것이다. 
		 * 응답할 데이터 타입을, 즉 리턴 제네릭을 String으로 했고, 받는 json데이터를 파싱하기 위해 @RequestBody를 사용하여 reply로 파싱한다. 
		 * 리턴은 httpstatus를 통해 성공과 에러를 보내준다. 
		 * 
		 * => uri를 요청하면 바로 인서트가 된다. 페이지 이동이 필요없다. 데이터만 전송되고 ajax를 사용하기때문에 !
		 * uri 즉, 인터넷만 되면 바로 바로 접근이 가능하다. 접근이 매우 좋다!
		 * 테스트는 브라우저로 테스트한다. 
		 */
	}
}




/*package com.koreait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.domain.ReplyVO;
import com.koreait.service.ReplyService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController   //각 메소드의 리턴은 ViewResolver로 가지 않는다.
@Log4j
public class ReplyController {
   @Setter(onMethod_=@Autowired)
   private ReplyService service;
   
   //댓글 등록
   //브라우저에서 JSON타입으로 데이터를 전송하고 서버에서는 댓글의 처리 결과에 따라 문자열로 결과를 리턴한다.
   //consumes : Ajax를 통해 전달받은 데이터의 타입
   //produces : Ajax의 success:function(result)에 있는 result로 전달할 데이터의 타입
   @PostMapping(value="/new", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
   //ResponseEntity : 서버의 상태코드, 응답 메세지등을 담을 수 있는 타입.
   //@RequestBody를 적용하여 JSON데이터를 ReplyVO타입으로 변환하도록 지정한다.
   public ResponseEntity<String> create(@RequestBody ReplyVO reply){
      int insertCnt = 0;
      log.info("ReplyVO : " + reply);
      insertCnt = service.register(reply);
      log.info("Reply INSERT COUNT : " + insertCnt);
      return insertCnt == 1 ? new ResponseEntity<>("success", HttpStatus.OK) 200 OK:
         new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 500 Server Error
   }
}*/











































