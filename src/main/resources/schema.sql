drop table T_CUSTOMERS if exists;

create table T_CUSTOMERS (ID integer identity primary key, FIRSTNAME varchar(50) not null, LASTNAME varchar(50) not null, AGE integer);