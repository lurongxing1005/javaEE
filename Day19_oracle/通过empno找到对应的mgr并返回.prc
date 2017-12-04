

--通过empno找到对应mgr
create or replace procedure prod_smgr_return(p_no number,p_mgr out number)
is

begin
  select mgr into p_mgr from emp where empno=p_no;
end prod_smgr_return;
/
