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
status enum('PENDING','APPROVED','CANCELED') default('PENDING'),
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

