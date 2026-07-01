CREATE database School;
USE School;
CREATE TABLE Students(
	StudentID int PRIMARY KEY,
    Name VARCHAR(50),
    Age INT,
    Gender VARCHAR(10),
    City VARCHAR(50));

insert into Students values
(101,'Rahul',20,'Male','Hyderabad'),
(102,'Priya',19,'Female','Chennai'),
(103,'Arjun',21,'Male','Bengaluru'),
(104,'Sneha',20,'Female','Mumbai'),
(105,'Kiran',22,'Male','Pune');

SELECT * 
FROM Students;

SELECT Name,City
FROM Students;

select *
FROM Students
Where age>20;

SELECT *
FROM Students
where Gender='Female';

SELECT *
FROM Students
where Gender='Hyderabad';

SELECT *
FROM Students
ORDER BY Name ASC;

SELECT *
FROM Students
ORDER BY Age DESC;

SELECT *
FROM Students
ORDER BY City ASC,Name ASC;

SELECT *
FROM Students
WHERE Age BETWEEN 19 AND 21;

select*
from Students
WHERE Name LIKE 'R%';

select*
from Students
WHERE City LIKE '%i';

select*
from Students
WHERE Age IN(20,22);

SET SQL_SAFE_UPDATES = 0;

UPDATE Students
set CITY='Delhi'
where Name='Rahul';

SET SQL_SAFE_UPDATES = 1;

SET SQL_SAFE_UPDATES = 0;
UPDATE Students
set Age = Age+1
Where Name='Arjun';
SET SQL_SAFE_UPDATES = 1;

SET SQL_SAFE_UPDATES = 0;
UPDATE Students
set CITY='Kolkata'
where Name='Sneha';

delete FROM Students
WHERE StudentID=105;

DELETE FROM Students
where City='Chennai';