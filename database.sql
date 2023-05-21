CREATE DATABASE `generator`
   DEFAULT CHARSET utf8mb4 
   COLLATE utf8mb4_unicode_ci;
   
USE `generator`;


CREATE TABLE `generator`.`template` (
    `id` BIGINT AUTO_INCREMENT COMMENT '自增主键ID',
    `template_id` BIGINT COMMENT '模板ID',
    `template_type_code` INT COMMENT '模板类型编码',
    `name` VARCHAR(64) DEFAULT '' COMMENT '模板名称',
    `content` TEXT COMMENT '模板内容',
    `record_status_code` INT DEFAULT 0 COMMENT '记录状态',
    PRIMARY KEY (`id`),
    INDEX template_idx_template_id (`template_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  AUTO_INCREMENT = 1
    COMMENT ='模板表';