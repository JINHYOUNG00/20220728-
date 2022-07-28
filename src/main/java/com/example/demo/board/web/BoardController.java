package com.example.demo.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.Criteria;
import com.example.demo.common.PageDTO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/boardSelectList")
	public String boardSelectList(Model model, Criteria cri) {
		
		List<BoardVO> list = service.boardSelectList(cri);
		// 페이징
		// 전체건수
		cri.setAmount(5);
		int total = service.getTotal(cri);
		model.addAttribute("pageMaker", new PageDTO(cri,total));
//		model.addAttribute("list", list);
		model.addAttribute("list", service.boardSelectList(cri));
		
		return "board/boardSelectList";
	}
	
	
	@RequestMapping("/boardSelect")
	public String boardSelect(BoardVO vo, Model model) {
		
		vo = service.boardSelect(vo);
		model.addAttribute("vo", vo);
		
		return "board/boardSelect";
	}
	
	@RequestMapping("/boardInsertForm")
	public String boardInsert(BoardVO vo) {
		
		return "board/boardInsert";
	}
	
	@RequestMapping("/boardInsert")
	public String insert(BoardVO vo) {
		
		service.boardInsert(vo);
		
		return "redirect:boardSelectList";
	}
	
	@RequestMapping("/boardUpdateForm")
	public String boardUpdate(BoardVO vo, Model model) {
		
		model.addAttribute("vo", service.boardSelect(vo));
		return "board/boardUpdate";
	}
	
	@RequestMapping("/boardUpdate")
	public String update(BoardVO vo) {
		service.boardUpdate(vo);
		
		return "redirect:boardSelectList";
	}
	
	@GetMapping("/boardDelete")
	public String delete(BoardVO vo) {
		
		service.boardDelete(vo);
		
		return "redirect:boardSelectList";
	}
//	@GetMapping("/boardDelete")
//	public String delete(Model medel, @RequestParam BoardVO vo, RedirectAttributes rttr) {
//		if(service.boardDelete(vo)) {
//			rttr.addFlashAttribute("result1", "success"); // 일회성
//			rttr.addAttribute("result2", "success"); // 파라미터
//		}
//		
//		return "redirect:boardSelectList";
//	}
	
}
