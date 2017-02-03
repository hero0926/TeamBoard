create table teamboard(
	num number(4) primary key,
	author varchar2(20),
	title varchar2(50),
	content varchar2(1000),
	writeday date default sysdate,
	readcnt number(4),
	reproot number(4),
	repstep number(4),
	repindent number(4),
	boardnum number(3)
)

 from teamboard

select * from 
--insert into teamboard (num, author, title, content, writeday,
readcnt, reproot, repstep, repindent, boardnum)
select teamboard_seq.nextval, author, title, content, writeday,
readcnt, teamboard_seq.currval, repstep, repindent, 4
from myboard
where num between 3400 and 3450

select * from myboard

commit

select *
from myboard
where num < 200


--create table teamboardinfo(
	boardnum number(3) primary key,
	title varchar2(50),
	repyn char(1) default 'Y'
)

select boardnum, title, repyn from teamboardinfo

select trunc(round(156.00,-1), -1) from dual
select trunc(156.00,-1) from dual

select round(156.00,-1) from dual
--create sequence teamboard_seq
--create sequence teamboardinfo_seq
select sysdate from dual


select teamboard_seq.nextval from member

select teamboard_seq.currval from dual


insert into teamboard (num, author, title, content, readcnt, reproot, repstep, repindent, boardnum)
values(teamboard_seq.nextval, '홍길동', 'test title', 'test content', 0, teamboard_seq.currval,
0, 0, 1)

insert into teamboardinfo(boardnum, title, repyn)
values(teamboardinfo_seq.nextval, '첫번째 게시판', 'Y')


insert into teamboardinfo(boardnum, title, repyn)
values(teamboardinfo_seq.nextval, 'FAQ', 'N')

insert into teamboardinfo(boardnum, title, repyn)
values(teamboardinfo_seq.nextval, 'Q&A', 'Y')

insert into teamboardinfo(boardnum, title, repyn)
values(teamboardinfo_seq.nextval, '공지사항', 'N')

commit
select * from  teamboardinfo

update teamboardinfo set title = '게시판' where boardnum = 1

commit

select * from  teamboard

commit

update teamboard set readcnt = 0


select num, author, title, content, writeday,
readcnt, reproot, repstep, repindent
from teamboard
order by reproot desc, repstep

select author, title, content, writeday,
readcnt, reproot, repstep, repindent
from teamboard
where num = 1 




select * from USER_CONS_COLUMNS



--select rownum from  teamboard




select max(repstep) from teamboard
where reproot = 4

select * from (
	select rownum as rnum, num, author, title,
	content, to_char(writeday,'yyyy/MM/dd') writeday,
	readcnt, reproot, repstep, repindent
	from (
		select *
		from teamboard
		order by reproot desc, repstep
	)
) where rnum between 1 and 10


select * from ( select rownum as rnum, num, author, title, content, to_char(writeday,'yyyy/MM/dd') writeday, readcnt, reproot, repstep, repindent from  ( select * from teamboard order by reproot desc, repstep ) ) where rnum between 1 and 10 


insert into teamboard (num, author, title, content, writeday,
readcnt, reproot, repstep, repindent)
select teamboard_seq.nextval, author, title, content, writeday,
readcnt, teamboard_seq.currval, repstep, repindent
from teamboard
where repindent = 0

commit



select * from member






select * from ( 	
select rownum as rnum, num, author, title, 	content, to_char(writeday,'yyyy/MM/dd') writeday, 	
readcnt, reproot, repstep, repindent 	from ( 		
select * 		from teamboard 		order by reproot desc, repstep 
) ) where rnum between 1 and 5 



drop table tmember


select * from MEMBER


create table tmember(
memnum number(4) primary key,
id varchar2(20),
name varchar2(20),
pw varchar2(20),
regday date default sysdate,
status char(1) default 'Y'
)

delete tmember where memnum=2

commit

select * from tmember

create sequence tmember_seq


insert into tmember(memnum, id, name, pw)
values (tmember_seq.nextval, 'hong', '홍길동', '1234')

commit

insert into tmember(memnum, id, name, pw)
values (tmember_seq.nextval, 'admin', '관리자', 'admin')


--로그인 기록용 테이블 추가하기

create table tmember_log(
mxlognum number(4) primary key,
memnum number(4),
loginday date default sysdate
)

create sequence tmember_log_seq

select * from tmember_log

select a.mxlognum, a.memnum, b.id, b.name, a.loginday
from tmember_log a, tmember b
where a.memnum = b.memnum order by a.loginday desc
and b.id = 'hong'
and b.name like '%홍길동%'
order by a.loginday desc

select a.mxlognum, a.memnum, b.id, b.name, a.loginday from tmember_log a, tmember b where a.memnum = b.memnum order by a.loginday desc