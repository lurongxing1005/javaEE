create or replace trigger trig_dept_log
  after insert or delete or update on dept  
  for each row
declare
  -- local variables here
  str1 t_dept_log.logmsg%type; --旧数据
  str2 t_dept_log.logmsg%type; --新数据
begin
  if inserting then
   select :new.dname into str1 from dual;   
   str1 := '添加了记录:'||str1;
  elsif deleting then
   select :old.dname into str1 from dual;
   str1 := '删除了记录：'||str1; 
  
  elsif updating then
   select :new.dname into str2 from dual;
   select :old.dname into str1 from dual;
   str1 := '将'||str1||'修改为'||str2;
  
  end if;

  insert into t_dept_log(logmsg) values(str1);
  
end trig_dept_log;
/
