package com.spring.project01.service;

import com.spring.project01.dto.BoardResponseDto;
import com.spring.project01.entity.Board;
import com.spring.project01.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public List<BoardResponseDto> findAll() {
        //정렬기능 추가
        Sort sort = Sort.by(Sort.Direction.DESC,"boardIdx", "boardDate");
        List<Board> list = boardRepository.findAll(sort);

        //List<Board>를 List<BoardResponseDto>로 변환
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }
}
