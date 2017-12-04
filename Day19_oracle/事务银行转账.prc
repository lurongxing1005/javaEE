create or replace procedure prod_trans
(
p_fromID in number,
p_toID in number, 
p_balance in number,
p_result out number
)
 as
begin
  --成功是  1
  p_result := 1;
  --转出
  update tab_account set balance=balance-p_balance where account_id=p_fromID;
  --转入
  update tab_account set balance=balance+p_balance where account_id=p_toID;
  --生成一条记录  
  insert into tab_tranrecord values(my_seq.nextval,p_fromID,p_toID,p_balance,sysdate);
  commit;
  dbms_output.put_line('成功');
  
  exception
    when others then
      --失败是  0
     p_result := 0;
    dbms_output.put_line('失败');  
    rollback;
end prod_trans;
/
