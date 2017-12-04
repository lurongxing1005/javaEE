create or replace procedure getEmpCount(
p_deptno in number,
 total  out number) 
 is
begin
 select count(*) into total from emp where deptno = p_deptno; 
end getEmpCount;
/
