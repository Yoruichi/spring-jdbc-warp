CREATE TABLE IF NOT EXISTS `test`.`foo` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gender` TINYINT(1) NOT NULL DEFAULT 1 COMMENT 'gender',
  `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '名称',
  `email` VARCHAR(64) NOT NULL DEFAULT '' COMMENT 'email',
  `age` int(3) NULL COMMENT 'age',
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT='foo';

CREATE TABLE IF NOT EXISTS `test2`.`foo` (
  `id` INT unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gender` TINYINT(1) NOT NULL DEFAULT 1 COMMENT 'gender',
  `name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '名称',
  `email` VARCHAR(64) NOT NULL DEFAULT '' COMMENT 'email',
  `age` int(3) NULL COMMENT 'age',
  PRIMARY KEY (`id`))
ENGINE = InnoDB DEFAULT CHARSET=utf8 COMMENT='foo';