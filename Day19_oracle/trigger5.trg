create or replace trigger trigger5
  after delete on dept  
  for each row
declare
  -- local variables here
begin
  dbms_output.put_line('after for each row');
end trigger5;
/
