CREATE TABLE `upload` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) DEFAULT NULL,
  `path` varchar(300) DEFAULT NULL,
  `file_size` bigint(24) NOT NULL DEFAULT '0' COMMENT '当前文件大小（最大24位-16MB）',
  `file_total_size` bigint(24) NOT NULL DEFAULT '0' COMMENT '文件总大小（最大24位-16MB）',
  `status` int(1) DEFAULT NULL,
  `md5` varchar(32) DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次上传时间',
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='上传文件记录';
