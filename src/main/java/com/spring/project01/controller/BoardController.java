package com.spring.project01.controller;



import com.spring.project01.dto.BoardResponseDto;
import com.spring.project01.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
//모든 요청을 URL "/board" 밑으로 받겠다.
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
//    private final ReplyService replyService;

    @RequestMapping("")
    public String main() {
        return "redirect:/board/listForm";
    }

    @RequestMapping("/listForm")
    public String listForm(Model model) {
        List<BoardResponseDto> list = boardService.findAll();
        model.addAttribute("list", list);
        return  "listForm";
    }
}
