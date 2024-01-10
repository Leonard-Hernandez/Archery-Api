create table users(
	id bigint not null auto_increment,
	login varchar(100) not null,
	password varchar(300) not null,
	primary key(id)
);
insert into users(login, password) values ('admin', '$2a$10$DRbD4xXrrahAmk1yP1aHFuT2UsBGCve12QgpUpJP96w1A3eOz5xgS')