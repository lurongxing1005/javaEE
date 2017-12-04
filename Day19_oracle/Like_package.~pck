create or replace package Like_package is

  -- Author  : ADMINISTRATOR
  -- Created : 2017/11/15 15:50:26
  -- Purpose : 
  
  --声明存储过程
  procedure getempbyLikename(p_likename varchar2);
  
 

end Like_package;
/
create or replace package body Like_package is

 --实现存储过程
  procedure getempbyLikename(p_likename varchar2) 
    as
    -- my_row emp%rowtype;
     
     --1,定义游标
     cursor my_cur is  select * from emp where ename like '%'||p_likename||'%'; 
    begin
      
      --2,3,4
      for my_row in my_cur loop
       dbms_output.put_line(my_row.ename||'  '||my_row.job);
      end loop;
      end;

 
end Like_package;
/
