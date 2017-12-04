create or replace function func_getempname
(p_no in number) 
return varchar2 is
  v_name varchar2(20);
begin

  --根据员工编号 获取员工姓名
  select ename into v_name from emp where empno=p_no;  
  return(v_name);
end func_getempname;
/
