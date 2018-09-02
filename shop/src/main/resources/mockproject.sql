create database mockprojectfinal
go
use mockprojectfinal
go
create table [role](
role_id int identity(1,1) primary key,
role_name nvarchar(20)
)
go

create table account(
account_id int identity(1,1) primary key,
[user_name] varchar(20) not null,
password varchar(100) not null,
birthday date,
gender bit,
name nvarchar(50),
email varchar(50),
address nvarchar(50),
phone char(11),
role_id int,
foreign key(role_id) references [role](role_id)
)
go

create table product_type(
[type_id] char(10) primary key,
[type_name] nvarchar(30)
)
go

create table producer(
producer_id int identity(1,1) primary key,
producer_name nvarchar(30),
)
go
create table product(
product_id int identity(1,1) primary key,
product_name nvarchar(50) not null,
price money,
producer_id int,
[type_id] char(10),
foreign key(producer_id) references producer(producer_id),
foreign key([type_id]) references product_type([type_id]),
)
go
create table size(
size_id int identity(1,1) primary key,
product_id int,
size char(3),
foreign key(product_id) references product(product_id)
)
go
create table color(
color_id int identity(1,1) primary key,
product_id int,
color nvarchar(20),
foreign key(product_id) references product(product_id)
)
go
create table product_image(
image_id int identity(1,1) primary key,
product_id int,
product_image varchar(500),
foreign key(product_id) references product(product_id)
)
go

create table [order](
order_id int identity(1,1) primary key,
account_id int,
order_date date,
foreign key(account_id) references account(account_id)
)
go
create table order_detail(
order_detail_id int identity(1,1) primary key,
order_id int,
product_id int,
size_id int,
color_id int,
quantity int,
total money,
foreign key(order_id) references [order](order_id),
foreign key(product_id) references product(product_id),
foreign key(size_id) references size(size_id),
foreign key(color_id) references color(color_id)

)
go
create table comment(
comment_id int identity(1,1) primary key,
product_id int,
account_id int,
comment nvarchar(100),
foreign key(product_id) references product(product_id),
foreign key(account_id) references account(account_id)
)
go

insert into [role](role_name) values('ROLE_GUEST')
insert into [role](role_name) values('ROLE_MEMBER')
insert into [role](role_name) values('ROLE_ADMIN')


--insert_data_ACCOUNT
INSERT INTO account(user_name,password,birthday,gender,name,email,address,phone,role_id)
 VALUES('admin','admin','01/25/1996',1,'Mai Ngoc Son','mns@gmail.com','HCM','113',3)
 INSERT INTO product_type(type_id,type_name)
 VALUES('1','thun')
 INSERT INTO product_type(type_id,type_name)
 VALUES('2','so-mi')
 INSERT INTO product_type(type_id,type_name)
 VALUES('3','quan-nam')

  INSERT INTO account(user_name,password,birthday,gender,name,email,address,phone,role_id)
 VALUES('admin','admin','01/25/1996',1,'Mai Ngoc Son','mns@gmail.com','HCM','113',3)

 INSERT INTO account(user_name,password,birthday,gender,name,email,address,phone,role_id)
 VALUES('member1','member1','01/25/1996',1,'Mai Ngoc Son','mns@gmail.com','HCM','113',2)

 INSERT INTO account(user_name,password,birthday,gender,name,email,address,phone,role_id)
 VALUES('member2','member2','01/25/1996',1,'Mai Ngoc Son','mns@gmail.com','HCM','113',2)



 INSERT INTO producer(producer_name)
 VALUES('A')
  INSERT INTO producer(producer_name)
 VALUES('B')

INSERT INTO product(product_name,price,producer_id,type_id) VALUES('Quan Jean 3x',300000,1,1)
INSERT INTO product(product_name,price,producer_id,type_id) VALUES('Quan Jean 4x',300000,1,1)
INSERT INTO product(product_name,price,producer_id,type_id) VALUES('Quan Jean 5x',300000,1,1)
--insert_data_COLOR
INSERT INTO color(product_id,color)
 VALUES(1,'RED')
 INSERT INTO color(product_id,color)
 VALUES(1,'BLACK')

--insert_data_COMMENT
INSERT INTO	comment(product_id,account_id,comment)
 VALUES(1,1,'OK CON DE')

 INSERT INTO size(product_id,size)
 VALUES(1,'XXL')
insert into Product_image values(
'1','https://cdn-chiaki.megaads.vn/unsafe/0x900/left/top/smart/filters:quality(75)/https://chiaki.vn/upload/product/2017/10/ao-giu-nhiet-heattech-uniqlo-nam-co-tron-59e5d8a195667-17102017171705.jpg'
)
insert into Product_image values(
'1','https://cdn-chiaki.megaads.vn/unsafe/0x900/left/top/smart/filters:quality(75)/https://chiaki.vn/upload/product/2017/10/ao-giu-nhiet-heattech-uniqlo-nam-co-tron-59e5d8a195667-17102017171705.jpg'
)
--insert_data_ORDER
INSERT INTO [order](account_id,order_date)
 VALUES(1,'11/20/2017')

--insert_data_ORDER_DETAIL
INSERT INTO order_detail(order_id,product_id,size_id,color_id,quantity,total)
 VALUES(1,1,1,1,3,300000)


