create or replace function changedatetype(tdate in date) return varchar2 is
  date_str varchar2(50);
begin
  select  to_char(tdate,'yyyy"Äê"mm"ÔÂ"dd"ÈÕ" hh24:mi:ss')  into date_str from dual;
  return(date_str);
end changedatetype;
/
