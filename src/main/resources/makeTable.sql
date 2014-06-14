create database commentdb;

grant all privileges on commentdb.* to 'comment-admin'@'localhost' identified by '1';
grant all privileges on commentdb.* to 'comment-admin'@'%' identified by '1';

use commentdb;

create table user(
	id varchar(20) primary key,
	name varchar(20) not null,
	password varchar(20) not null,
	explanation varchar(100)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user values('pop2331', '성의현', '1', 'flask');
insert into user values('pop9310', '성의현2', '1', 'flask2');

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

create table recommended_comment(
	comment_id int not null,
	recommend_user_id varchar(20) not null,
	primary key (comment_id, recommend_user_id),
	foreign key (`comment_id`) references `comment`(`comment_id`),
	foreign key (`recommend_user_id`) references `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

create table opposited_comment(
	comment_id int not null,
	opposited_user_id varchar(20) not null,
	primary key (comment_id, opposited_user_id),
	foreign key (`comment_id`) references `comment`(`comment_id`),
	foreign key (`opposited_user_id`) references `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;