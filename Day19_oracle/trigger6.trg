create or replace trigger trigger6
  after delete on dept  
  
declare
  -- local variables here
begin
  dbms_output.put_line('after');
end trigger6;
/
