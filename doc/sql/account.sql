CREATE DATABASE community;

Drop table  if exists user;
CREATE TABLE user (
    id INT(16) NOT NULL AUTO_INCREMENT,
    uid varchar(255) not null unique,
    username VARCHAR(45) NOT NULL unique,
    password VARCHAR(45) NOT NULL,
    name VARCHAR(45) NULL,
    gender INT(1) NOT NULL COMMENT '男：1，女：0',
    birthday DATETIME NOT NULL COMMENT '出生年月',
    avatar_url VARCHAR(255) NULL COMMENT '头像url',
    email VARCHAR(255) NULL,
    phone VARCHAR(255) NULL,
    location VARCHAR(255) NULL,
    archived TINYINT(1) NOT NULL DEFAULT 0,
    created_at DATETIME NOT NULL COMMENT '创建时间',
    update_at DATETIME NOT NULL COMMENT '信息更新时间',
    last_login_at DATETIME NOT NULL COMMENT '最后登录时间',
    description VARCHAR(255) NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

Drop table  if exists user_role;
CREATE TABLE user_role (
  role_id INT(16),
  role_priority INT(8),
  role_name VARCHAR(255),
  description VARCHAR(255) NULL
);

Drop table  if exists assigned_role;
CREATE TABLE assigned_role (
  user_id INT(16),
  role_id INT(11),
  description VARCHAR(255) NULL
);


