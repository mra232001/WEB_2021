    drop database if exists foo;

drop schema if exists webproject
    cascade;
create schema webproject;
set search_path = webproject;

drop table if exists users;

Create table users(
    id int generated by default as identity ,
    username varchar(100) not null,
    password char(80) not null,
    password_confirm char(80) not null,
    primary key (id)
)

select * from users where username = 'manh';
