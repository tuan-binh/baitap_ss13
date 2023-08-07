create database demojdbc;
use demojdbc;

create table user (
    id int(3) not null auto_increment primary key ,
    name varchar(120) not null ,
    email varchar(220) not null ,
    country varchar(120)
);

insert into user (name, email, country) values ("Minh","Minh@rikkei.academy","VietNam");
insert into user (name, email, country) values ("Kante","Kante@che.uk","Kenia");