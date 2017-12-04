--创建表空间
create tablespace mytablespace
datafile 'f:\app\mydatafile' size 50M;

--创建临时表空间
create temporary tablespace mytempspace
tempfile 'f:\app\mytempfile' size 40M;
