package com.koreait.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration   //Servlet의 ServletContext를 이용하기 위함
@ContextConfiguration({
   "file:src/main/webapp/WEB-INF/spring/root-context.xml",
   "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@Log4j
public class BoardControllerTests {
   @Setter(onMethod_=@Autowired)
   private WebApplicationContext wac;
   
   //가짜MVC
   //마치 브라우저에서 사용하는 것처럼 만들어서 Controller를 실행해 볼 수 있다.
   private MockMvc mockMvc;
   
   @Before   //모든 테스트 전에 매번 실행된다.
   public void setup() {
      //WebApplicationContext를 통해 ServletContext를 빌드한다.
      this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build(); 
   }
   
   @Test
   public void testGetList() throws Exception{
	   log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
			   .param("pageNum", "1")
			   .param("amount", "20"))
			   .andReturn().getModelAndView().getModelMap());
   }
   
//   @Test
//   public void testRegister() throws Exception{
//      log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
//    		  
//    		  //키값의 이름은 필드이름과  동일해야한다.
//            .param("title", "테스트 새 글 제목")
//            .param("content", "테스트 새 글 내용")
//            .param("writer", "test123"))
//      .andReturn()/*.getFlashMap()*/.getModelAndView().getViewName());
//      				//flash로 쓰면 이렇게쓰자
//   }
   
//   @Test
//   public void testList() throws Exception{
//      log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))   //GET방식으로 URI호출
//               .andReturn() //응답된 결과값을 통해
//               .getModelAndView() //Model에 어떤 데이터가 담겨 있는지를
//               .getModelMap()); //Map 형식으로 확인
//   }
   
   	//조회처리와 테스트 구현
//   	@Test
//   	public void testGet() throws Exception{
//   		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "3"))
//   				.andReturn().getModelAndView().getModelMap());
//   	}
   
   
   //※수정과 삭제는 성공 시 result에 success를 담아서 view에 전달하기 
   
   //수정처리와 테스트 구현
//   @Test
//   public void testModify() throws Exception {
//	   log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
//			   .param("bno", "3")
//			   .param("title", "수정된 테스트 새 글 제목")
//	           .param("content", "수정된 테스트 새 글 내용")
//	           .param("writer", "test123"))
//	   .andReturn().getFlashMap());
//   }
   
   
   //삭제 처리와 테스트 구현
//   @Test
//   public void testRemove () throws Exception {
//	   log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/remove")
//			   .param("bno", "21")).andReturn().getFlashMap());
//   }
   
   
   
   
}


































