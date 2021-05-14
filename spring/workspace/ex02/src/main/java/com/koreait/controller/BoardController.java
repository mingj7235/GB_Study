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
      //getTotal(Criteria) : type과 keyword가 전달되면 검색된 게시글의 건수이며, 검색하지 않으면 전체 게시글의 건수이다. 
      model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
   }
   
   @GetMapping("/register")//get방식일때는 여기로, post는 밑으로! 방식이 다르면 방식대로 꽂힌다. 이름이 같아도! 이건 페이지이동용
   public void register(@ModelAttribute("cri") Criteria cri) {log.info(cri);}
   
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
   public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
      model.addAttribute("board", service.get(bno));
      
   }
   
   //※ 수정과 삭제는 성공 시 result에 success를 담아서 view에 전달하기
   //수정 처리와 테스트 구현
   @PostMapping("/modify")
   public String modify(BoardVO board, Criteria cri, RedirectAttributes rttr) {
      log.info("modify : " + board);
      
      
      if(service.modify(board)) {
         rttr.addFlashAttribute("result", "success");
      }
//    flash는 1개밖에 못담는다. 약간 임시방편의 느낌이다. 
      //세션의 느낌인데 이것이 많아지면 목적과 다르다 그래서 제한을 둔것이다. 1번의 요청과 응답때 한번만써야한다.
      //Flash는세션의 남용을 방지하고자 1개의 파라미터만 전달 할 수있다.
      //따라서 여러개를 전달할 때에는 컬렉션에 담아서 넘기거나
      //URL에 붙여서 전달하는 RedirectAttributes 객체의 addAttribute()를 사용하여 보내야한다. 
//      rttr.addFlashAttribute("pageNum", cri.getPageNum());
//      rttr.addFlashAttribute("amount", cri.getAmount());
      
      //rttr의 addAttribute는 get방식으로 보내준다. 즉, 자동으로  쿼리스트링처럼 보내준다.
      //주의!!  redirect는 무조건 get방식일수밖에없다. 즉 list(get방식) 으로 리턴해주는거니까!!
      //항상 컨트롤러에 있는 클래스타입의 매개변수는 생성자를 통해서 파라미터 값으로 초기화 한다.
      //만약 전달받은 파라미터 값에 매핑되는 생성자가 없다면 값을 전달받을 수 없다.
      //rttr.addAttribute("cri", cri);
      
      //따라서 반드시 해당 객체의 생성자에 전달할 필드명과 일치하도록 설정해주어야 한다.  
      rttr.addAttribute("pageNum", cri.getPageNum());
      rttr.addAttribute("amount", cri.getAmount());
      rttr.addAttribute("keyword", cri.getKeyword());
      rttr.addAttribute("type", cri.getType());
      
      return "redirect:/board/list";
   }
   
   
   //삭제 처리와 테스트 구현
   @GetMapping("/remove")
   public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {
      log.info("remove : " + bno);
      if(service.remove(bno)) {
         rttr.addFlashAttribute("result", "success");
      }
      rttr.addAttribute("pageNum", cri.getPageNum());
      rttr.addAttribute("amount", cri.getAmount());
      rttr.addAttribute("keyword", cri.getKeyword());
      rttr.addAttribute("type", cri.getType());
      return "redirect:/board/list";
   }
}




















