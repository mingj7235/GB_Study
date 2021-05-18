package com.koreait.controller;


import java.util.List;

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

import com.koreait.domain.Criteria;
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
	//@ResponseBody : @Controller에서 Body를 응답하기 위해서는 (viewResolver를 가지 않게 하기 위해서 ) 사용된다. 
	//	즉, 내맘대로 이제 return 값을 조율할 수있다. Restcontroller 대신 controller를 사용하고 메소드의 리턴값을 그대로사용하고 싶을 때
		//ResponseBody 어노테이션을 붙여서 사용한다. 
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
	
	//게시글 댓글 전체 조회
	//consumes은 필요없다. get방식으로 보내기때문에 json으로 받을 필요가 없다. 
	//produces를 xml로 하기
	@GetMapping (value="/pages/{bno}/{page}", produces= {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
					//해당 게시글의 댓글 페이지가 나오는 것이다. JSON파일로! 이게 REST방식이다
	public ResponseEntity<List<ReplyVO>> getList (@PathVariable("bno") Long bno, @PathVariable("page") int page) { //해당 게시글의 전체 댓글을 불러오기 위해 하는것임
											//bno, page는 uri로 받는 것이다. uri에 중괄호를 쳐놓은건 변수의 선언이다.
											//@GetMapping (value="/pages/{bno}/{page}" -> 변수의 선언!!
											//이 path에 있는 변수를 넣는 것이다. 그래서 @PathVariable를 사용하여 꽂아주는 것이다.
		log.info("getList....");
		Criteria cri = new Criteria(page, 10); //왜 여기서 왜 주입을 안하고 다시 선언해주는가? 
									//메소드 안이거나 어떤 필드안에서는 new 해줘야한다.
		
		log.info(cri);
		
		return new ResponseEntity<List<ReplyVO>>(service.getListWithPaging(cri, bno), HttpStatus.OK);
	}
	
	//댓글조회
/*	@GetMapping (value="/{rno}", produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get (@PathVariable("rno") Long rno) {
		return new ResponseEntity<ReplyVO> (service.get(rno), HttpStatus.OK);
	}*/
	@GetMapping (value="/{rno}", produces= {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get (@PathVariable("rno") Long rno) {
		log.info("get : " + rno);
		return new ResponseEntity<ReplyVO> (service.get(rno), HttpStatus.OK);
	}
	
	//댓글 수정
	//PUT : 자원 전체 수정, 자원 내 모든 필드를 전달해야 한다. 일부만 전달할 경우 전달 되지 않은 필드는 모두 초기화 처리가 된다. 
	//PATCH : 자원 일부 수정, 수정할 필드만 전송한다. 전송하지 않은 필드는 그대로 유지된다. 
	//일반적으로 PATCH방법을 많이쓴다. 왜냐하면 PUT은 전달하지 않을때 null이 되므로! 
	
	//여러개의 메소드(전달방식)를 한번에 받을 때 requestmapping을 하는것
	//즉, put과 patch 방식 모두를 받기 위해서 Requestmapping으로 어노테이션한다. 
																		//uri만 받으면 뭘 수정할지 알게된다.  //수정하기위해서 받을게 많다. (consumes)
   @RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH}, value="/{rno}", consumes="application/json", produces=MediaType.TEXT_PLAIN_VALUE)
   public ResponseEntity<String> modify(@RequestBody ReplyVO reply, @PathVariable("rno") Long rno){
      reply.setRno(rno);
      
      log.info("rno : " + rno);
      log.info("modify : " + reply);
      
      return service.modify(reply) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK) :
         new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
   }
   
   //댓글 삭제 
   @DeleteMapping (value="/{rno}", produces=MediaType.TEXT_PLAIN_VALUE)
   //deletemapping을 사용하므로써, Delete에서만 쓸수있는걸 사용할 수 있게된다.
   //get, post 다 써도되는데, DeleteMapping을 사용하는 것은 이것에 포커스 하기 때문이다. 
   public ResponseEntity<String> delete (@PathVariable("rno") long rno) {
	   
	   log.info("rno: " + rno);
	   
	   return service.remove(rno) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK) :
		   new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
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











































