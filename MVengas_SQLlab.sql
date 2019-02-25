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
RETURN DATE AS              -- IF NO ALIAS FOR THE RETURN TYPE DONT PUT A ';'
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
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE
RETURN SYS_REFCURSOR AS
EXP_TRACKS SYS_REFCURSOR;
BEGIN
OPEN EXP_TRACKS FOR
SELECT * FROM TRACK
WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK);
RETURN EXP_TRACKS;
END;
/
--HAD TO RETURN A CURSOR SINCE THERE IS MORE THAN ONE TRACK WITH THE MOST EXPENSIVE PRICE AT 1.99
SELECT MOST_EXPENSIVE FROM DUAL;


--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_PRICE
RETURN INVOICELINE.UNITPRICE%TYPE AS
AVERAGE INVOICELINE.UNITPRICE%TYPE;
BEGIN
SELECT AVG(UNITPRICE) INTO AVERAGE
FROM INVOICELINE;
RETURN AVERAGE;
END;
/

SELECT AVG_PRICE FROM DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION BORN_AFTER
RETURN SYS_REFCURSOR AS
AFTER_DATE SYS_REFCURSOR;
BEGIN
OPEN AFTER_DATE FOR 
SELECT * FROM EMPLOYEE
WHERE BIRTHDATE >= '01-JAN-1968';
RETURN AFTER_DATE;
END;
/

SELECT BORN_AFTER FROM DUAL;


--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures.
--You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE FIRSTLASTNAMES
AS RC  SYS_REFCURSOR;
BEGIN
OPEN RC FOR
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
dbms_sql.return_result(RC);
END;
/

EXECUTE FIRSTLASTNAMES;

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE
(OLD_TITLE EMPLOYEE.TITLE%TYPE, NEW_TITLE EMPLOYEE.TITLE%TYPE)
AS
BEGIN
UPDATE EMPLOYEE
SET TITLE = NEW_TITLE
WHERE TITLE = OLD_TITLE;
END;
/

EXECUTE UPDATE_EMPLOYEE('IT Manager', 'Trainer');


--Task – Create a stored procedure that returns the managers of an employee .
CREATE OR REPLACE PROCEDURE RET_MANAGERS
(EMP_FIRST VARCHAR2, EMP_LAST VARCHAR2)
AS RC SYS_REFCURSOR;
BEGIN
OPEN RC FOR
SELECT FIRSTNAME, LASTNAME, TITLE FROM EMPLOYEE
WHERE EMPLOYEEID = (SELECT REPORTSTO FROM EMPLOYEE WHERE FIRSTNAME = EMP_FIRST AND LASTNAME = EMP_LAST);
dbms_sql.return_result(RC);
END;
/

EXECUTE RET_MANAGERS('Robert', 'King');


--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NAMECOMPANY
(CUST NUMBER)
AS RC SYS_REFCURSOR;
BEGIN
OPEN RC FOR
SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER
WHERE CUSTOMERID = CUST;
dbms_sql.return_result(RC);
END;
/

EXECUTE NAMECOMPANY(10);


--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice
-- (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICE
(INVOICE_NUM NUMBER)
AS
BEGIN
DELETE FROM INVOICELINE
WHERE INVOICEID = INVOICE_NUM;
DELETE FROM INVOICE
WHERE INVOICEID = INVOICE_NUM;
COMMIT;
END;
/

EXECUTE DELETE_INVOICE(113);
--SELECT COUNT(*) FROM INVOICELINE
--WHERE INVOICEID = 113;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER
(NUMID NUMBER, FNAME VARCHAR2, LNAME VARCHAR2, EMAIL VARCHAR2)
AS
BEGIN
INSERT INTO CUSTOMER VALUES(NUMID, LNAME, FNAME, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, EMAIL, NULL);
COMMIT;
END;
/

EXECUTE INSERT_CUSTOMER(1001, 'Mark', 'Venegas', 'markavenegas@hotmail.com');


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE SEQUENCE MYSEQ
MINVALUE 100
MAXVALUE 10000
START WITH 5000
INCREMENT BY -5
CACHE 20;

SET SERVEROUTPUT ON;

CREATE OR REPLACE TRIGGER INSERT_EMP
AFTER INSERT ON EMPLOYEE
DECLARE
NUM_EMPS NUMBER;
BEGIN
SELECT COUNT(*) INTO NUM_EMPS FROM EMPLOYEE;
DBMS_OUTPUT.PUT_LINE('NUMBER OF EMPLOYEES: ' || NUM_EMPS);
END;    
/

DROP TRIGGER INSERT_EMP;

INSERT INTO EMPLOYEE VALUES(1001, 'Venegas', 'Erik', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

DELETE FROM EMPLOYEE
WHERE FIRSTNAME = 'Erik';


--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER UPDATE_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('OLD TITLE: ' || :OLD.TITLE);
DBMS_OUTPUT.PUT_LINE('NEW TITLE: ' || :NEW.TITLE);
END;
/

DROP TRIGGER UPDATE_ALBUM;

UPDATE ALBUM
SET TITLE = 'Lifelight'
WHERE TITLE = 'War';

UPDATE ALBUM
SET TITLE = 'War'
WHERE TITLE = 'Lifelight';


--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER DELETE_CUST
AFTER DELETE ON CUSTOMER
DECLARE
NUM_CUSTS NUMBER;
BEGIN
SELECT COUNT(*) INTO NUM_CUSTS FROM CUSTOMER;
DBMS_OUTPUT.PUT_LINE('NUMBER OF CUSTOMERS: ' || NUM_CUSTS);
END;    
/

DROP TRIGGER DELETE_CUST;

INSERT INTO CUSTOMER VALUES(1000, 'Mark', 'Venegas', 'Revature', '8327 Serenity Ct.', 'El Cajon', 'CA', 'United States', '92021', '+1 (619) 831-2031', NULL, 'markavenegas@hotmail.com', NULL);

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Mark' AND LASTNAME = 'Venegas';


--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID
ORDER BY CUSTOMERID ASC;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER, INVOICE
WHERE CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID(+);

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.ARTISTID, ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.EMPLOYEEID;









