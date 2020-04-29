CREATE TABLE `contents` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `BOOK_ID` int(11) DEFAULT NULL COMMENT '图书id',
  `NAME` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '目录名',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE `book` (
  `ID` int(11) NOT NULL COMMENT '主键',
  `TITLE` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '标题',
  `PATH` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '图片路径',
  `PRESS` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '出版社',
  `SCORE` decimal(2,1) NOT NULL COMMENT '评分',
  `AUTHOR` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '作者',
  `CATEGORY` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '类目',
  `PRICE` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '价格',
  `PUBLIS_TIME` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '出版时间',
  `CONTENT` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '内容简介',
  `REMARKS` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '备注',
  `CREATE_TIME` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '创建时间',
  `UPDATE_TIME` varchar(255) COLLATE utf8_bin NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;