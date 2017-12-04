select MY_SEQ.currval as 当前值 from dual;

select my_seq.nextval as 下一个值 from dual;

--使用
insert into tab_student values(my_seq.nextval,'will2',50);

select * from tab_student;

