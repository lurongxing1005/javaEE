create or replace procedure Prod_getEMpBYName(p_ename in varchar2)
 is
 my_row emp%rowtype;
begin
  select * into my_row from emp where ename=p_ename;
  dbms_output.put_line(my_row.ename||' '||my_row.job);
end Prod_getEMpBYName;
/
