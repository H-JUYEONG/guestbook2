use mysql;

create user 'guestbook'@'%' identified by 'guestbook';

create database guestbook_db
default character set utf8mb4
collate utf8mb4_general_ci
default encryption='n'
;

grant all privileges on guestbook_db.* to 'guestbook'@'%';
 
flush privileges;