CREATE TABLE `p_user` (
	`iuser` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`iuser`) USING BTREE,
	UNIQUE INDEX `name` (`name`) USING BTREE
);

CREATE TABLE `p_management` (
	`imanagement` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`iuser` BIGINT(20) UNSIGNED NOT NULL,
	`year` YEAR NOT NULL DEFAULT year(current_timestamp()),
	`month` INT(11) NOT NULL DEFAULT month(current_timestamp()),
	`month_limit` INT(10) UNSIGNED NOT NULL,
	`balance` INT(10) UNSIGNED NOT NULL,
	`expense` INT(10) UNSIGNED NULL DEFAULT '0',
	PRIMARY KEY (`imanagement`) USING BTREE,
	UNIQUE INDEX `iuser` (`iuser`, `year`, `month`) USING BTREE,
	CONSTRAINT `p_management_ibfk_1` FOREIGN KEY (`iuser`) REFERENCES `team_c`.`p_user` (`iuser`) ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT `month` CHECK (`month` between 1 and 12)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `p_payment` (
	`ipayment` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`imenu` BIGINT(20) UNSIGNED NOT NULL,
	`imanagement` BIGINT(20) UNSIGNED NOT NULL,
	`payment_at` DATETIME NULL DEFAULT current_timestamp(),
	`current_menu_price` INT(10) UNSIGNED NULL DEFAULT NULL,
	`review_grade` TINYINT(3) UNSIGNED NULL DEFAULT NULL,
	`restaurant` VARCHAR(20) NULL DEFAULT '식당이름을 입력해주세요' COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`ipayment`) USING BTREE,
	INDEX `imanagement` (`imanagement`) USING BTREE,
	CONSTRAINT `p_payment_ibfk_2` FOREIGN KEY (`imanagement`) REFERENCES `team_c`.`p_management` (`imanagement`) ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT `review_grade` CHECK (`review_grade` between 1 and 3)
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `p_user_menu` (
	`iuser_menu` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`iuser` BIGINT(20) UNSIGNED NOT NULL,
	`menu` VARCHAR(20) NOT NULL COLLATE 'utf8mb4_general_ci',
	`normal_price` INT(10) UNSIGNED NOT NULL,
	PRIMARY KEY (`iuser_menu`) USING BTREE,
	UNIQUE INDEX `menu` (`menu`, `iuser`) USING BTREE,
	INDEX `iuser` (`iuser`) USING BTREE,
	CONSTRAINT `p_user_menu_ibfk_1` FOREIGN KEY (`iuser`) REFERENCES `team_c`.`p_user` (`iuser`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1000
;




CREATE TABLE p_common_menu(
	icommon_menu BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY key
	,menu VARCHAR(20) UNIQUE NOT null
	,normal_price INT(10) UNSIGNED NOT NULL
);

CREATE TABLE `p_tag` (
	`itag` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`tag` VARCHAR(15) NOT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`itag`) USING BTREE,
	UNIQUE INDEX `tag` (`tag`) USING BTREE
)
COLLATE='utf8mb4_general_ci'
ENGINE=INNODB;

CREATE TABLE `p_tag_menu` (
	`itag` BIGINT(20) UNSIGNED NOT NULL,
	`imenu` BIGINT(20) UNSIGNED NOT NULL,
	UNIQUE INDEX `itag` (`itag`, `imenu`) USING BTREE,
	CONSTRAINT `p_tag_menu_ibfk_1` FOREIGN KEY (`itag`) REFERENCES `team_c`.`p_tag` (`itag`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
;