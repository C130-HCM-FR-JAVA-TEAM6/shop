create database mockproject
go
use mockproject
go
create table [role](
role_id int identity(1,1) primary key,
role_name nvarchar(20)
)
go

create table account(
account_id int identity(1,1) primary key,
[user_name] varchar(20) not null,
password varchar(20) not null,
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
create table Product_image(
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
order_id int,
product_id int,
quantity int,
total money,
primary key(order_id,product_id),
foreign key(order_id) references [order](order_id),
foreign key(product_id) references product(product_id)
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
--insert_data_ACCOUNT
INSERT INTO account(user_name,password,birthday,gender,name,email,address,phone,role_id)
 VALUES('mns','mns@123','01/25/1996',1,'Mai Ngoc Son','mns@gmail.com','HCM','113',1)
 select * from account
--insert_data_COLOR
INSERT INTO color(product_id,color)
 VALUES(2,'RED')
   select * from color
--insert_data_COMMENT
INSERT INTO	comment(product_id,account_id,comment)
 VALUES(1,1,'OK CON DE')
  select * from [comment]
--insert_data_ORDER
INSERT INTO [order](account_id,order_date)
 VALUES(1,'11/20/2017')
 select * from [order]
--insert_data_ORDER_DETAIL
INSERT INTO order_detail(order_id,product_id,quantity,total)
 VALUES(1,1,3,300000)
 select * from order_detail
--insert_data_PRODUCER
INSERT INTO producer(producer_name)
 VALUES('A')
 select * from producer
--insert_data_PRODUCT
INSERT INTO product(product_name,price,producer_id,type_id) VALUES('Quan Jean 3x',300000,1,1)
INSERT INTO product(product_name,price,producer_id,type_id) VALUES('Quan Jean 4x',300000,1,1)
INSERT INTO product(product_name,price,producer_id,type_id) VALUES('Quan Jean 5x',300000,1,1)
select * from product
--insert_data_PRODUCT_IMAGE
INSERT INTO Product_image(product_id,product_image)
 VALUES(2,'https://cdn2.yame.vn/pimg/so-mi-nam-ma-bu-caro-td-a19-0016611/afeb4fcf-c453-3100-31ab-001483d31e14.jpg?w=440')
 INSERT INTO Product_image(product_id,product_image)
 VALUES(2,'https://cdn2.yame.vn/pimg/so-mi-nam-ma-bu-caro-td-a19-0016611/afeb4fcf-c453-3100-31ab-001483d31e14.jpg?w=440')
 INSERT INTO Product_image(product_id,product_image)
 VALUES(2,'https://cdn2.yame.vn/pimg/so-mi-nam-ma-bu-caro-td-a19-0016611/afeb4fcf-c453-3100-31ab-001483d31e14.jpg?w=440')

 INSERT INTO Product_image(product_id,product_image)
 VALUES(3,'https://cdn2.yame.vn/pimg/so-mi-nam-ma-bu-caro-td-a19-0016611/afeb4fcf-c453-3100-31ab-001483d31e14.jpg?w=440')

 INSERT INTO Product_image(product_id,product_image)
 VALUES(4,'https://cdn2.yame.vn/pimg/so-mi-nam-ma-bu-caro-td-a19-0016611/afeb4fcf-c453-3100-31ab-001483d31e14.jpg?w=440')
--insert_data_PRODUCT_TYPE
INSERT INTO	product_type(type_id,type_name)
 VALUES('1','thun')
 INSERT INTO product_type(type_id,type_name)
 VALUES('2','so-mi')
 INSERT INTO product_type(type_id,type_name)
 VALUES('3','quan-nam')
--insert_data_ROLE
INSERT INTO [role](role_name)
 VALUES('AD')
--insert_data_SIZE
INSERT INTO size(product_id,size)
 VALUES(2,'XXL')