create or replace trigger trigger2
  before insert on dept  
  for each row
declare
  -- local variables here
begin
   dbms_output.put_line('for each row');
end trigger2;
/
