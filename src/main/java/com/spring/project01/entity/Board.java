package com.spring.project01.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

//엔티티에 @Setter를 넣지 않는다. JPA 함수 호출시 중복호출되는 경향이 있다.
@Getter
@NoArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx", nullable = false)
    private Long boardIdx; // PK

    @Column(name = "board_title", nullable = false)
    private String boardTitle; // 제목

    @Column(name = "board_content", nullable = false)
    private String boardContent; // 내용

    @Column(name = "board_name", nullable = false)
    private String boardName; // 작성자

    @Column(name = "board_hit", nullable = false)
    private Long boardHit; // 조회수

    @Column(name = "board_date", nullable = false)
    private LocalDateTime boardDate = LocalDateTime.now(); // 생성일,수정일

    @Builder
    public Board(String board_title, String board_content,String board_name, Long board_hit) {
        this.boardTitle = board_title;
        this.boardContent = board_content;
        this.boardName = board_name;
        this.boardHit = board_hit;
    }
    public void update(String board_title, String board_content,String board_name, Long board_hit) {
        this.boardTitle = board_title;
        this.boardContent = board_content;
        this.boardName = board_name;
        this.boardHit = board_hit;
        this.boardDate = LocalDateTime.now();
    }
}