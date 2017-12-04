create or replace package P_package is

  -- Author  : ADMINISTRATOR
  -- Created : 2017/11/15 15:01:09
  -- Purpose : 
  

  -- Public function and procedure declarations
  --根据员工的名字得到其部门经理的名字
  function func_getMgrName(p_name varchar2) return varchar2;
  
  --输出某个部门编号下的所有员工
  procedure getAllempbyDeptNo(p_deptno number);

end P_package;
/
create or replace package body P_package is

  --根据员工的名字得到其部门经理的名字
  function func_getMgrName(p_name varchar2) return varchar2 
    as
    v_name emp.ename%type;
    begin 
      
      select ename into v_name from emp where empno = (select mgr from emp where ename=p_name);
      
      return v_name;
      
      end;
      
      
   --输出某个部门编号下的所有员工
  procedure getAllempbyDeptNo(p_deptno number)
    is 
     my_row emp%rowtype;
     --1,定义游标
     cursor my_c is select * from emp where deptno=p_deptno;
    begin 
      --2,打开游标
      open my_c;
      --3,提取数据
      
     -- fetch my_c into my_row;
     -- dbms_output.put_line(my_row.ename);
      
     --  fetch my_c into my_row;
     -- dbms_output.put_line(my_row.ename);
     
     --使用loop 循环
     loop
        fetch my_c into my_row;
        exit when(my_c%notfound);
         dbms_output.put_line(my_row.ename);
       end loop;
     
      
      --关闭游标
      close my_c;
        
      end;
    
end P_package;
/
