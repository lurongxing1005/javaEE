
--创建存储过程 修改某个员工的工资

create or replace procedure prod_updatesal
(p_no in number,
p_sal in  number
) 
is
begin
  update emp set sal=sal+p_sal where empno = p_no;
  commit; 
end prod_updatesal;
/
