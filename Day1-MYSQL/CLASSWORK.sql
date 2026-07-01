CREATE database training;
USE training;
CREATE table tbl_employee(
	eid INT,
    ename VARCHAR(50),-- varchar is used for static memory allocation whereas varchar2 is used for dynamic memory allocation,but varchar is faster.
    esalary INT
);
describe tbl_employee; -- displays table structure information
INSERT INTO tbl_employee VALUES
(101,'Reshma',100000),
(102,'Srima',120000),
(103,'Abhi',80000),
(104,null,70000); -- default value for all datatypes in mysql is NULL.
INSERT INTO tbl_employee(eid,esalary) values (105,30000);
SELECT distinct *
FROM  tbl_employee;

select distinct eid,esalary
FROM tbl_employee;

SELECT distinct *
FROM tbl_employee
where eid=101;


SELECT distinct *
FROM tbl_employee
where eid!=101;    


SELECT distinct *
FROM tbl_employee
where eid<>101; -- <>==not equal operator


SELECT distinct ename
FROM tbl_employee
where esalary <=80000;

select distinct eid,ename
from tbl_employee
where ename IS null;

select distinct eid,ename
from tbl_employee
where ename IS NOT null;

select distinct * 
from tbl_employee
where eid IN (101,103);

select distinct * 
from tbl_employee
where eid NOT IN (101,103);

select distinct * 
from tbl_employee
where eid IN (101,106); -- as 106 is not present it will ignore.

select distinct * 
from tbl_employee
where esalary BETWEEN 120000 and 80000; -- it is empty because when we do minus(upper limit- lower limit) it will give negative value and here no negative values are present so it will not display anything.

SELECT distinct *
from tbl_employee
WHERE ename LIKE '%a';

SELECT distinct *
from tbl_employee
WHERE ename LIKE '%h%';

SELECT distinct *
from tbl_employee
WHERE ename NOT LIKE '%a';
-- for NULL pattern matching will not work

SET SQL_SAFE_UPDATES = 0; -- we set this "Temporarily disable Safe Update Mode (for the current session)"

UPDATE tbl_employee
SET esalary = 0
WHERE eid = 101;

SET SQL_SAFE_UPDATES = 1;

select distinct *
from tbl_employee;

rollback;

select distinct *
from tbl_employee;

DELETE from tbl_employee WHERE ename is NULL;
select 'Abhi',100+200 from tbl_employee;

select distinct eid as "Employee ID" ,sysdate() as "current_date",
'Abhi',100+200 as "sum" from tbl_employee;

ALTER table tbl_employee add column deptno Integer;

SELECT * from tbl_employee1;

rename table tbl_employee to  tbl_employee1;

ALTER TABLE tbl_employee drop column deptno;
SELECT distinct * from tbl_employee;

ALTER table tbl_employee rename column eid to empid;
truncate table tbl_employee;

drop table tbl_employee1;