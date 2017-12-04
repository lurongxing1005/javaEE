select ename,empno,rownum n from emp order by empno desc;

select ename,empno,rownum n from emp;


select * from emp where rownum>1;
select * from emp where rownum>=1;

select * from emp where rownum>=1 AND rownum<=5;
select * from emp where rownum>=1 AND rownum<=10;

--第2页  1页5条数据

---pageNum    pageSize     pageNum*pagesize   (pageNUm-1)*pageSize
select * from (select rownum r,t1.* from emp t1 where rownum<=2*5) t2 where t2.r > (2-1)*5;






