create or replace trigger trigger4
  before delete on dept  
  
declare
  -- local variables here
begin
  dbms_output.put_line('before');
end trigger4;
/
