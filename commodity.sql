-- auto-generated definition
create table commodity
(
    id         bigint auto_increment
        primary key,
    name       varchar(100) null,
    price      decimal      null,
    `describe` varchar(100) null
);