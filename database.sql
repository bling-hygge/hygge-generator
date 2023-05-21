CREATE DATABASE `generator`
   DEFAULT CHARSET utf8mb4 
   COLLATE utf8mb4_unicode_ci;
   
USE `generator`;


CREATE TABLE `generator`.`template` (
    `id` BIGINT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
    `template_id` BIGINT UNSIGNED NOT NULL COMMENT '模板ID',
    `name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '模板名称',
    `content` TEXT COMMENT '模板内容',
    `record_create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间',
    `record_update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录更新时间',
    `record_status_code` INT NOT NULL DEFAULT 0 COMMENT '记录状态',
    PRIMARY KEY (`id`),
    INDEX template_idx_template_id (`template_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci
  AUTO_INCREMENT = 1
    COMMENT ='模板表';