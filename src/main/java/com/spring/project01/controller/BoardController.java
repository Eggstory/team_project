package com.spring.project01.controller;



import com.spring.project01.dto.BoardResponseDto;
import com.spring.project01.entity.Board;
import com.spring.project01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
//모든 요청을 URL "/board" 밑으로 받겠다.
@RequestMapping("")
public class BoardController {
    private final BoardService boardService;
//    private final ReplyService replyService;

    @RequestMapping("")
    public String main() {
        return "redirect:/listForm";
    }

    @RequestMapping("/listForm")
    public String listForm(Model model) {
        List<BoardResponseDto> list = boardService.findAll();
        model.addAttribute("list", list);
        return  "listForm";
    }

    @RequestMapping("/joinForm")
    public String joinForm(Model model) {
        List<BoardResponseDto> list = boardService.findAll();
        model.addAttribute("list", list);
        return  "joinForm";
    }

    @RequestMapping("/writeForm")
    public String writeForm(Model model) {
        List<BoardResponseDto> list = boardService.findAll();
        model.addAttribute("list", list);
        return  "writeForm";
    }

    @GetMapping("/contentForm")
    public String contentForm(@RequestParam(value = "board_idx" , required = false) Long board_idx,
                              Model model) {
        model.addAttribute("dto", boardService.boardView(board_idx) );
        return  "contentForm";
    }

    @PostMapping("/board/writeAction")
    public String writeAction(Board board) {

        boardService.write(board);

        return "listForm";

    }


}
