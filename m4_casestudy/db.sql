drop database m4_casestudy_badminton;
create database m4_casestudy_badminton;
use m4_casestudy_badminton;
create table role(
id int primary key auto_increment,
name varchar(50) not null unique
);
create table account(
id bigint primary key auto_increment,
username varchar(255) not null unique,
password varchar(255) not null,
role_id int not null,
foreign key (role_id) references role(id)
);
create table user(
id bigint primary key auto_increment,
account_id bigint not null unique,
foreign key (account_id) references account(id) on delete cascade,
name varchar(255) not null,
email varchar(255) not null,
phone varchar(255) not null
);
create table fields(
id int primary key auto_increment,
status enum('AVAILABLE','NOT_AVAILABLE')
);
create table shift(
id int primary key auto_increment,
start_time time,
end_time time,
unique(start_time,end_time)
);
create table field_book(
id bigint primary key auto_increment,
user_id bigint not null,
field_id int not null,
shift_id int not null,
foreign key (user_id) references user(id),
foreign key (field_id) references fields(id),
foreign key (shift_id) references shift(id),
status enum('PENDING','APPROVED','CANCELED') default('PENDING'),
date_book date not null,
unique (field_id,shift_id,date_book)
);
create table class_schedule(
id int primary key auto_increment,
name varchar(20) not null,
days varchar(50) not null,
min_students int not null default 5,
max_students int not null default 10,
status enum('NOT_OPEN','OPEN','FULL') not null default 'NOT_OPEN'
);
create table study_schedule(
id int primary key auto_increment,
teacher_name varchar(255) not null,
field_id int not null,
shift_id int not null,
class_id int not null unique,
foreign key (field_id) references fields(id),
foreign key (shift_id) references shift(id),
foreign key (class_id) references class_schedule(id)
);
create table study_book(
id bigint primary key auto_increment,
user_id bigint not null,
schedule_id int not null,
foreign key (user_id) references user(id),
foreign key (schedule_id) references study_schedule(id),
status enum('PENDING','APPROVED','CANCELED') not null default 'PENDING',
unique(user_id,schedule_id)
);
create table pay(
id int primary key auto_increment,
pay_type varchar(20) not null unique
);
create table payment(
id bigint primary key auto_increment,
pay_id int not null,
study_book_id bigint not null unique,
foreign key (pay_id) references pay(id),
foreign key (study_book_id) references study_book(id),
status enum('UNPAID','PAID')
);

insert into role(name) values
('ADMIN'),
('USER');

insert into account(username,password,role_id) values
('namdb','namdb',1),
('huyg','huyg',1),
('dinhhung','dinhhung',1),
('hangle','hangle',1),
('phuongnam','123',2),
('phamminhthu','123',2),
('hoanglong','123',2),
('vothanhdat','123',2),
('dangthimy','123',2),
('phuonganh','123',2),
('quocbao','123',2),
('tuananh','123',2),
('khanhlinh','123',2),
('minhtri','123',2),
('anhkhoa','123',2),
('thuydung','123',2),
('dangminh','123',2),
('vuphuoc','123',2),
('tienlinh','123',2);

insert into user(account_id,name,email,phone) values
(1,'Đinh Phương Nam','namdb@gmail.com','0905123456'),
(2,'Trần Phát Huy','huyg5e@gmail.com','0905123457'),
(3,'Đình Hùng','hungdinh@gmail.com','0905123458'),
(4,'Lê Hằng','hangle@gmail.com','0905123459'),

(5,'Phương Thanh Nam','namnt@gmail.com','0912345680'),
(6,'Phạm Minh Thư','thu.pham@gmail.com','0912345681'),
(7,'Hoàng Long','long.hoang@gmail.com','0912345682'),
(8,'Võ Thành Đạt','dat.vo@gmail.com','0912345683'),
(9,'Đặng Thị My','my.dang@gmail.com','0912345684'),
(10,'Phương Anh','anh.phuong@gmail.com','0912345685'),
(11,'Quốc Bảo','bao.quoc@gmail.com','0912345686'),
(12,'Tuấn Anh','tuan.anh@gmail.com','0912345687'),
(13,'Khánh Linh','linh.khanh@gmail.com','0912345688'),
(14,'Minh Trí','tri.minh@gmail.com','0912345689'),
(15,'Anh Khoa','khoa.anh@gmail.com','0912345690'),
(16,'Thùy Dung','dung.thuy@gmail.com','0912345691'),
(17,'Đặng Đinh Minh','minhdd@gmail.com','0912345692'),
(18,'Lê Vũ Phước','phuoclv@gmail.com','0912345693'),
(19,'Nguyễn Tiến Linh','linhnt@gmail.com','0912345694');

insert into fields(status) values
('AVAILABLE'),
('AVAILABLE'),
('AVAILABLE'),
('AVAILABLE'),
('AVAILABLE'),
('NOT_AVAILABLE');

insert into shift(start_time,end_time) values
('05:00','07:00'),
('07:00','09:00'),
('09:00','11:00'),
('11:00','13:00'),
('13:00','15:00'),
('15:00','17:00'),
('17:00','19:00'),
('19:00','21:00'),
('21:00','23:00');

insert into class_schedule(name,days,min_students,max_students,status) values
('Lớp Cơ Bản','2-4-6',5,10,'OPEN'),
('Lớp Nâng Cao','3-5-7',5,10,'OPEN');

insert into study_schedule(teacher_name,field_id,shift_id,class_id) values
('Nguyễn Hữu Phúc',1,7,1),
('Trần Minh Khoa',2,7,2);

insert into study_book(user_id,schedule_id,status) values
(5,1,'APPROVED'),
(6,1,'APPROVED'),
(7,1,'APPROVED'),
(8,1,'APPROVED'),
(9,1,'APPROVED'),
(10,1,'APPROVED'),
(11,1,'APPROVED'),
(12,1,'APPROVED'),

(13,2,'APPROVED'),
(14,2,'APPROVED'),
(15,2,'APPROVED'),
(16,2,'APPROVED'),
(17,2,'APPROVED'),
(18,2,'APPROVED'),
(19,2,'APPROVED');

insert into field_book(user_id,field_id,shift_id,date_book,status) values
(5,3,1,'2026-02-28','APPROVED'),
(6,4,2,'2026-02-28','APPROVED'),
(7,5,3,'2026-02-28','APPROVED'),
(8,3,4,'2026-02-28','APPROVED'),
(9,4,5,'2026-02-28','APPROVED'),
(10,5,6,'2026-02-28','APPROVED'),
(11,3,8,'2026-02-28','PENDING'),
(12,4,9,'2026-02-28','APPROVED'),

(13,1,1,'2026-03-01','APPROVED'),
(14,2,2,'2026-03-01','APPROVED'),
(15,3,3,'2026-03-01','APPROVED'),
(16,4,4,'2026-03-01','APPROVED'),
(17,5,5,'2026-03-01','APPROVED'),
(18,1,6,'2026-03-01','CANCELED'),
(19,2,8,'2026-03-01','APPROVED');

insert into pay(pay_type) values
('CASH'),
('BANKING');

insert into payment(pay_id,study_book_id,status) values
(1,1,'PAID'),
(2,2,'PAID'),
(1,3,'PAID'),
(2,4,'PAID'),
(1,5,'UNPAID'),
(2,6,'PAID'),
(1,7,'PAID'),
(2,8,'UNPAID'),
(1,9,'PAID'),
(2,10,'PAID'),
(1,11,'UNPAID'),
(2,12,'PAID'),
(1,13,'PAID'),
(2,14,'PAID'),
(1,15,'UNPAID');


