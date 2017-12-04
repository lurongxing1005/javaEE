create or replace trigger trigger3
  before delete on dept  
  for each row
declare
  -- local variables here
begin
   dbms_output.put_line('before for each row');
end trigger3;
/
