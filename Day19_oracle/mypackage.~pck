create or replace package mypackage is

  -- Author  : ADMINISTRATOR
  -- Created : 2017/11/15 13:47:49
  -- Purpose : 
  
 
 --声明存储过程
   procedure  prod_01(p_name varchar2);

  -- Public function and procedure declarations
  --声明函数
  function func_01(p_num1 number,p_num2 number) return number;

end mypackage;
/
create or replace package body mypackage is

  
--实现存储过程  包体
   procedure  prod_01(p_name varchar2)
     as
     begin
        dbms_output.put_line('hello '|| p_name);
       end;
       
      --实现函数
  function func_01(p_num1 number,p_num2 number) return number as
    begin
      return p_num1+p_num2;
      end;
 
end mypackage;
/
