/*
2.0 SQL Queries
    In this section you will be performing various queries against the Oracle Chinook database.
*/
--2.1 SELECT
-- Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;


--2.2 ORDER BY
-- Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;


--2.3 INSERT INTO
SAVEPOINT BEFORE_INSERT;
-- Task – Insert two new records into Genre table 
INSERT INTO GENRE VALUES(100, 'Orchestral');
INSERT INTO GENRE VALUES(101, 'Video Game');


-- Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE VALUES(1000, 'Venegas', 'Mark', 'Software Engineer', NULL, '05-JUL-94', '20-FEB-2019', '8327 Serenity Ct.', 'El Cajon', 'CA', 'United States', '92021', '+1 (619) 831-2031', NULL, 'markavenegas@hotmail.com');
INSERT INTO EMPLOYEE VALUES(1001, 'Venegas', 'Erik', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- Task – Insert two new records into Customer table
INSERT INTO CUSTOMER VALUES(1000, 'Venegas', 'Mark', 'Revature', '8327 Serenity Ct.', 'El Cajon', 'CA', 'United States', '92021', '+1 (619) 831-2031', NULL, 'markavenegas@hotmail.com', NULL);
INSERT INTO CUSTOMER VALUES(1001, 'Venegas', 'Erik', 'Revature', '8327 Serenity Ct.', 'El Cajon', 'CA', 'United States', '92021', '+1 (619) 831-2031', NULL, 'mexiturtle321@gmail.com', NULL);

ROLLBACK TO BEFORE_INSERT;


--2.4 UPDATE
SAVEPOINT BEFORE_UPDATE;
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

ROLLBACK TO BEFORE_UPDATE;


--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';


--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
SAVEPOINT BEFORE_DELETE;

DELETE FROM INVOICELINE
WHERE INVOICEID = 116 OR INVOICEID = 245 OR INVOICEID = 268 OR INVOICEID = 290 OR INVOICEID = 342 OR INVOICEID = 50 OR INVOICEID = 61;

DELETE FROM INVOICE
WHERE customerid = 32;

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' and LASTNAME = 'Walter';
-- To delete the 1 record, I had to trace back up the tree of references that were connected to this cusotmer including orders and invoices
ROLLBACK TO BEFORE_DELETE;


--SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION RETURN_CURR_TIME
RETURN DATE AS
BEGIN
RETURN CURRENT_TIMESTAMP;
END;
/

SELECT RETURN_CURR_TIME FROM DUAL;

--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION RETURN_LENGTH_MEDIA
RETURN NUMBER AS
LEN NUMBER(4,1);
BEGIN
SELECT COUNT(NAME) INTO LEN
FROM MEDIATYPE;
RETURN LEN;
END;
/


--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION AVERAGE_INVOICES
RETURN NUMBER AS
AVERAGE NUMBER(6,2);
BEGIN
SELECT AVG(TOTAL) INTO AVERAGE
FROM INVOICE;
RETURN AVERAGE;
END;
/

SELECT AVERAGE_INVOICES FROM DUAL;

--Task – Create a function that returns the most expensive track


--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.




