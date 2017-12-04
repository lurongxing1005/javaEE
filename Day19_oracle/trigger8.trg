create or replace trigger trigger8
  before insert on tab_student  
  for each row
declare
  -- local variables here
begin
---½«ÐòÁÐnextval----¡·stu_id  :new.stu_id  

   select my_seq.nextval into :new.stu_id  from dual;
end trigger8;
/
