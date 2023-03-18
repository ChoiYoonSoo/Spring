package org.hdcd.controller;

import java.time.LocalDateTime;

import org.hdcd.domain.Board;
import org.hdcd.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
   
   private final BoardService service;
   
   @GetMapping("/register")
   public void registerForm(Board board,Model model) throws Exception{
      
   }
   
   @PostMapping("/register")
   public String register(@Validated Board board,BindingResult result, Model model) throws Exception{
	   
	   if(result.hasErrors()) {
		   return "board/register";
	   }
	   
      board.setRegDate(LocalDateTime.now());
      service.register(board);
      
      model.addAttribute("msg","등록이 완료되었습니다.");
      
      return "board/success";
   }
   
   @GetMapping("/list")
   public void list(Model model) throws Exception{
	   model.addAttribute("list",service.list());
   }
   
   @GetMapping("/read")
   public void read(Long boardNo, Model model) throws Exception{
	   model.addAttribute(service.read(boardNo));
   }
   
   @GetMapping("/modify")
   public void modifyForm(Long boardNo, Model model) throws Exception{
	   model.addAttribute(service.read(boardNo));
   }
   
}