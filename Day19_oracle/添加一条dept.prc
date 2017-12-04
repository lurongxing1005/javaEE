--创建存储过程 插入一条数据

create or replace procedure prod_adddept
(p_deptno in number, 
 p_dname in varchar2,
 p_loc in varchar2 default '厦门市'
 ) 
is
begin
 insert into dept values(p_deptno,p_dname,p_loc);
 commit; 
end prod_adddept;
/
