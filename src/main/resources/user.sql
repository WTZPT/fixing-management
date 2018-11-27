CREATE  TABLE `user`(
  `id`  int  AUTO_INCREMENT COMMENT '用户唯一账号ID',
  `name` varchar(40) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(60) default null COMMENT '用户邮箱地址',
  `number_id` varchar (20) not null COMMENT '编制号',
  `phone_number` varchar(15) NOT NULL COMMENT '用户电话号码',
  `password` varchar(40) NOT NULL COMMENT '用户密码',
  `status` int(2) UNSIGNED NOT NULL DEFAULT '0' COMMENT  '用户状态 0-正常 1-封禁',
  `register_time` timestamp not null DEFAULT current_timestamp COMMENT '注册时间',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户基本信息表';

INSERT INTO user(name,email,number_id,phone_number,password)
VALUES
('admin1','admin1@sina.cn','120001','13631236487','admin1'),
('worker1','worker1@sina.cn','110001','13631236487','worker1'),
('1601030997','xiaoming@qq.com','1601030997','13631236488','xiaoming'),
('1601030998','tom@qq.com','1601030997','13631236488','tom');