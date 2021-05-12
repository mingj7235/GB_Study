package com.koreait.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.domain.BoardVO;
import com.koreait.domain.Criteria;
import com.koreait.domain.PageDTO;
import com.koreait.service.BoardService;
import com.koreait.service.BoardServiceImple;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
   private BoardService service;
   
   @GetMapping("/list")
   public void list(Criteria cri, Model model) {
	 //void로 리턴한다는건 views/board/list.jsp 라는 의미다. 요청을 이렇게 했기 때문이다.
	 //void로 리턴하면 이 경로로 요청한 jsp의 주소를 리턴한다. 자동으로!!
	   
	   log.info("list");
      
      model.addAttribute("list", service.getList(cri));
      model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal()));
   }
   
   @GetMapping("/register")//get방식일때는 여기로, post는 밑으로! 방식이 다르면 방식대로 꽂힌다. 이름이 같아도! 이건 페이지이동용
   public void register() {}
   
   @PostMapping("/register")
   public String register(BoardVO board, /*Model model*/ RedirectAttributes rttr) {
      log.info("register : " + board);
      service.register(board);
//      model.addAttribute("result", board.getBno());
      //새롭게 등록된 번호를 .jsp에 전달하기 위해서는
      //request객체에 담아야 한다. 하지만 redirect방식으로 전송할 때에는
      //request가 초기화 된다. 따라서 세션에 있는 Flash영역에 담아놓고
      //초기화된 request객체에 전달해주면 결과값을 안전하게 이동시킬 수 있다.
      //이 때 RedirectAttributes를 이용한다.
      rttr.addFlashAttribute("result", board.getBno());
      
      //'redirect:' 접두어를 사용하면 스프링 MVC가 내부적으로
      //response.sendRedirect()를 처리해준다.
      return "redirect:/board/list";
   }
   
   //조회 처리와 테스트 구현
   @GetMapping({"/get", "/modify"})
   //RequestParam은 객체와 일반 변수가 동시에 있을 때 분리하기 위해 작성한다.
   public void get(@RequestParam("bno") Long bno, Model model) {
      model.addAttribute("board", service.get(bno));
   }
   
   //※ 수정과 삭제는 성공 시 result에 success를 담아서 view에 전달하기
   //수정 처리와 테스트 구현
   @PostMapping("/modify")
   public String modify(BoardVO board, RedirectAttributes rttr) {
      log.info("modify : " + board);
      
      if(service.modify(board)) {
         rttr.addFlashAttribute("result", "success");
      }
      return "redirect:/board/list";
   }
   //삭제 처리와 테스트 구현
   @GetMapping("/remove")
   public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
      log.info("remove : " + bno);
      if(service.remove(bno)) {
         rttr.addFlashAttribute("result", "success");
      }
      return "redirect:/board/list";
   }
}




















