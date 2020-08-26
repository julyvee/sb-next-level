drop table T_CUSTOMERS if exists;

create table T_CUSTOMERS (ID integer identity primary key, FIRST_NAME varchar(50) not null, LAST_NAME varchar(50) not null, AGE integer);