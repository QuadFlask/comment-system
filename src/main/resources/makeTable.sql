create database commentdb;

grant all privileges on commentdb.* to 'comment-admin'@'localhost' identified by '1';
grant all privileges on commentdb.* to 'comment-admin'@'%' identified by '1';

user commentdb;

create table user(
	id varhcar(20) primary key,
	name varchar(20) not null,
	password varchar(20) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;