create database db_shiro;
use db_shiro;
create table users(
                    id int auto_increment primary key,
                    userName varchar(10),
                    password varchar(20)

);
select * from users;

insert into  users(id,userName,password) values(1,'wby','123');