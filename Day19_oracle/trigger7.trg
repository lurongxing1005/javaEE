create or replace trigger trigger7
  before update on dept  
  for each row
declare
  -- local variables here
begin
  update emp set deptno = :new.deptno where deptno = :old.deptno;
end trigger7;
/
