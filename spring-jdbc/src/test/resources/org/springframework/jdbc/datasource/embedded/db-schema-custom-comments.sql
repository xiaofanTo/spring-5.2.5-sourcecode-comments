~ Failed DROP can be ignored if necessary 
drop table T_TEST if exists;

~ Create the com.xiaohuan.Test table
create table T_TEST (NAME varchar(50) not null);