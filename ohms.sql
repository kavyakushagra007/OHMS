create database Hospital;
use Hospital;
create table PATIENTS(ID int auto_increment primary key,NAME varchar(50) not  null,AGE int not null,GENDER varcharacter(1) not null);
create table DOCTORS(D_ID int auto_increment primary key,NAME varchar(50) not null, SPECILIZATION varchar(70) not null);
create table APPOINMENT(A_ID int auto_increment primary key,P_ID int not null,D_ID int not null ,Appinment_Date date not null,
foreign key (P_ID) references PATIENTS(ID),foreign key (D_ID) references DOCTORS(D_ID));
insert into DOCTORS(NAME,SPECILIZATION) values("Dr. Nilesh Mohan","Ophthalmologist"),
("Dr. Saket Kumar","General Surgeon");
select * from DOCTORS;