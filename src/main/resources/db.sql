drop TABLE IF EXISTS reply;
drop TABLE IF EXISTS board;
drop table member;






CREATE DATABASE team_project;

CREATE TABLE `member` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`user_id` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`user_pw` VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	`user_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`user_role` VARCHAR(255) NULL DEFAULT 'ROLE_USER' COLLATE 'utf8mb4_general_ci',
	`joindate` DATE NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;


CREATE TABLE `board` (
	`board_idx` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`board_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`board_title` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`board_content` VARCHAR(1000) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`board_date` DATETIME NULL DEFAULT current_timestamp(),
	`board_hit` INT(11) NULL DEFAULT '0',
	PRIMARY KEY (`board_idx`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `reply` (
	`reply_idx` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`reply_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`reply_content` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`reply_date` DATE NULL DEFAULT current_timestamp(),
	`reply_board_idx` BIGINT(20) NOT NULL,
	PRIMARY KEY (`reply_idx`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;





insert into member( id, user_id, user_pw, user_name, user_role, joindate )
      VALUES ( 0, 'hong', '1234', '홍길동', 'ROLE_USER', '2022-09-09');
insert into member( id, user_id, user_pw, user_name, user_role, joindate )
      values ( 0, 'tom', '1234', '톰아저씨', 'ROLE_USER', '2022-09-09' );
insert into member( id, user_id, user_pw, user_name, user_role, joindate )
      VALUES ( 0, 'admin', '1234', '관리자', 'ROLE_ADMIN', '2022-09-09' );
      
      
INSERT INTO board VALUES (0, '홍길동', '글 제목1', '글 내용1', DEFAULT, DEFAULT);
INSERT INTO board VALUES (0, '변사또', '글 제목2', '글 내용2', DEFAULT, DEFAULT);
INSERT INTO board VALUES (0, '사임당', '글 제목3', '글 내용3', DEFAULT, DEFAULT);

      
   
INSERT INTO reply VALUES (0, '홍두께', '댓글 제목1', DEFAULT, 1);
INSERT INTO reply VALUES (0, '심청', '댓글 제목2', DEFAULT, 2);
INSERT INTO reply VALUES (0, '심봉사', '댓글 제목3', DEFAULT, 3);

