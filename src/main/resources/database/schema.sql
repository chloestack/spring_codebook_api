drop table if exists code_group;
create table code_group (
    group_code varchar(10) not null,
    group_name varchar(10),
    description varchar(50),
    primary key (group_code)
);
drop table if exists code;
create table code (
    code varchar(10) not null,
    group_code varchar(10),
    code_name varchar(10),
    primary key (code),
    foreign key (group_code) references code_group
);