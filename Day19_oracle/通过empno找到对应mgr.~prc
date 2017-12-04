
--通过empno找到对应mgr
create or replace procedure prod_selectMgr(p_no number)
is
 v_mgr number;
begin
  select mgr into v_mgr from emp where empno=p_no;
  dbms_output.put_line(v_mgr);
end prod_selectMgr;
/
