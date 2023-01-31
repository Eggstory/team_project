package com.spring.project01.service;

import com.spring.project01.dto.BoardResponseDto;
import com.spring.project01.entity.Board;
import com.spring.project01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// HTTP요청 -> @Controller -> @Service -> DTO/Entity -> @Repository(DAO) -> DBMS
// HTTP응답(html,json) <- @Controller <- @Service -> DTO/Entity <- @Repository(DAO) <- DBMS

@Service
@RequiredArgsConstructor
public class BoardService {
    private  final BoardRepository boardRepository;

    public List<BoardResponseDto> findAll() {
        //정렬 기능 추가
        Sort sort = Sort.by(Sort.Direction.DESC,"boardIdx","boardDate");
        List<Board> list = boardRepository.findAll(sort);

        return  list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    // 특정 게시글 불러오기
    public Board boardView(Long board_idx) {

        return boardRepository.findById(board_idx).get();
    }

    public void write(Board board) {

        boardRepository.save(board);

    }




}
