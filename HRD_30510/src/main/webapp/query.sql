create table member_tbl_02 (
	custno number(6) NOT NULL,
	custname varchar2(20),
	joindate date,
	grade char(1),
	address varchar2(60),
	constraint member_tbl_custno_pk primary key (custno)
);

insert into member_tbl_02 values(10001, '박정희', '2019-02-15', 'A', '경기 분당구 서현동');
insert into member_tbl_02 values(10002, '최선한', '2019-02-15', 'B', '경기 군포시 산본동');
insert into member_tbl_02 values(10003, '김순애', '2019-02-15', 'A', '경기 군포시 산본동');
insert into member_tbl_02 values(10004, '최정현', '2019-02-15', 'B', '경기 분당구 정자동');
insert into member_tbl_02 values(10005,'김영림', '2019-02-15', 'A', '경기 분당구 정자동');
insert into member_tbl_02 values(10006,'박세영', '2019-02-15', 'C', '경기 용인시 용인동');

create table loan_tbl_02 (
	custno number(6) not null,
	bookno number(4) not null,
	rentdate date,
	returndate date,
	constraint loan_tbl_number_pk primary key (custno, bookno)
);

insert into loan_tbl_02 values(10001, 1234, '2019-02-15', '2019-02-15');
insert into loan_tbl_02 values(10001, 1122, '2019-02-15', '2019-02-16');
insert into loan_tbl_02 values(10002, 1234, '2019-03-15', '2019-02-15');
insert into loan_tbl_02 values(10003, 1234, '2019-04-17', '2019-02-15');
insert into loan_tbl_02 values(10004, 1122, '2019-12-19', '2019-02-15');
insert into loan_tbl_02 values(10005, 1122, '2020-02-15', '2019-02-15');
insert into loan_tbl_02 values(10005, 1113, '2019-02-15', '2019-02-15');
insert into loan_tbl_02 values(10005, 1114, '2019-02-15', '2019-02-15');
insert into loan_tbl_02 values(10006, 1113, '2020-02-15', '2019-02-15');


select * from mem_tbl_02