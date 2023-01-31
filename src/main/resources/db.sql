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
AUTO_INCREMENT=5
;


CREATE TABLE `board` (
	`board_idx` BIGINT(20) NOT NULL AUTO_INCREMENT,
	`board_name` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`board_title` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`board_content` TEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`board_date` DATETIME NULL DEFAULT current_timestamp(),
	`board_hit` INT(11) NULL DEFAULT '0',
	PRIMARY KEY (`board_idx`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=4
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
AUTO_INCREMENT=4
;