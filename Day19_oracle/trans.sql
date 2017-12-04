--事务

insert into tab_student values(120,'rose',18);
commit;

insert into tab_student values(121,'rose1',18);
insert into tab_student values(122,'rose2',18);
commit;

delete from tab_student where stu_id = 120;
delete from tab_student where stu_id = 121;
rollback;

select * from tab_student;


delete from tab_student where stu_id = 120;
delete from tab_student where stu_id = 121;
savepoint mypoint;
delete from tab_student where stu_id = 122;
rollback to mypoint;

commit;

--1.设置保存点savepoint  a
--2.取消部分事务 rollback to a
--3.取消全部事务 rollback








