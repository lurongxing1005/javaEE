create or replace trigger trigger10
  instead of insert on my_view  
  for each row
declare
  -- local variables here
begin
  dbms_output.put_line('instead of insert on my_view');
  insert into dept values(45,:new.DNAME,:new.LOC);
end trigger10;
/
