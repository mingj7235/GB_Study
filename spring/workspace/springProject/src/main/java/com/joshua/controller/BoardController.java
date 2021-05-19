package com.joshua.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joshua.domain.BoardVO;
import com.joshua.domain.Criteria;
import com.joshua.domain.PageDTO;
import com.joshua.service.BoardService;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {

	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, service.getTotal(cri)));
		
	}
	
	@GetMapping("/register") 
	public void register(@ModelAttribute("cri") Criteria cri) {
		
	}
	
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		service.register(board);
		
		//응답페이지로 board번호를 넘긴다. post방식이므로 redirect되므로 이렇게 보낸다.
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	
}
