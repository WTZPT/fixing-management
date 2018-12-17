wCREATE TABLE `role` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL COMMENT '用户id',
  `name` varchar(32) NOT NULL COMMENT '用户角色名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_and_name` (`user_id`,`name`) USING BTREE,
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';




INSERT INTO user(name,email,number_id,phone_number,password)
VALUES
('admin1','admin1@sina.cn','120001','13631236487','admin1'),
('worker1','worker1@sina.cn','110001','13631236487','worker1'),
('小明','xiaoming@qq.com','1601030092','13631236488','xiaoming'),
('tom','tom@qq.com','16010300989','13631236488','tom');

INSERT INTO role(user_id,name)
VALUES
('1','ADMIN'),
('2','WORKER'),
('3','USER'),
('4','USER');