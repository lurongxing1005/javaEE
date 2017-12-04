create or replace trigger trigger9
  before update on emp  
  for each row
declare
  -- local variables here
begin
  
  dbms_output.put_line(:new.ename||'=>工资变动情况'||(:new.sal-:old.sal));
end trigger9;
/
