create database commentdb;

grant all privileges on commentdb.* to 'comment-admin'@'localhost' identified by '1';
grant all privileges on commentdb.* to 'comment-admin'@'%' identified by '1';

user commentdb;

create table user(
	id varhcar(20) primary key,
	name varchar(20) not null,
	password varchar(20) not null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user values('pop2331', 'flask', '1');

create table comment(
	comment_id int auto_increment primary key,
	writer_id varchar(20) not null,
	contents varchar(500),
	recommendation_count int default 0,
	opposition_count int default 0,
	regdttm char(12),
	foreign key (`writer_id`) references `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into comment(writer_id, contents, recommendation_count, opposition_count, regdttm) values(
	'pop2331',
	'test',
	1,
	2,
	'201406040000'
);