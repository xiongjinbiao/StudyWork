create database mhl;

create table mhl.employee(
id int primary key auto_increment,
empId varchar(50) unique not null default '',
pwd char(32) not null default '',
name varchar(50) not null default '',
job varchar(50) not null default ''
) character set utf8;
insert into mhl.employee values(null,'1',MD5('1'),'熊金彪','boss');
insert into mhl.employee values(null,'6668612',MD5('123456'),'张三丰','经理');
insert into mhl.employee values(null,'6668622',MD5('123456'),'小龙女','服务员');
insert into mhl.employee values(null,'6668633',MD5('123456'),'张无忌','收银员');
insert into mhl.employee values(null,'666666',MD5('123456'),'老韩','经理');
select * from mhl.employee;

create table mhl.diningTable(
id int primary key auto_increment,
state varchar(20) not null default '',
orderName varchar(50) not null default '',
orderTel varchar(50) not null default ''
) character set utf8;
insert into mhl.diningTable values(null,'空','','');
insert into mhl.diningTable values(null,'空','','');
insert into mhl.diningTable values(null,'空','','');
select * from mhl.diningTable;

create table mhl.menu(
id int primary key auto_increment,
name varchar(50) not null default '',
type varchar(50) not null default '',
price double not null default 0
) character set utf8;
insert into mhl.menu values(null,'八宝饭','主食',10);
insert into mhl.menu values(null,'叉烧包','主食',20);
insert into mhl.menu values(null,'宫保鸡丁','热菜',30);
insert into mhl.menu values(null,'山药拔鱼','凉菜',14);
insert into mhl.menu values(null,'银丝卷','甜食',9);
insert into mhl.menu values(null,'水煮鱼','热菜',26);
insert into mhl.menu values(null,'甲鱼汤','汤',80);
insert into mhl.menu values(null,'番茄鸡蛋汤','汤',8);
select * from mhl.menu;

create table mhl.bill(
id int primary key auto_increment,
billId varchar(50) not null default '',
menuId int not null default 0,
nums int not null default 0,
money double not null default 0,
diningTableId int not null default 0,
billDate datetime not null,
state varchar(50) not null default ''
) character set utf8;

select * from mhl.bill;



