--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.

--2.1 SELECT

--Task  Select all records from the Employee table.
SELECT * 
FROM EMPLOYEE;

--Task  Select all records from the Employee table where last name is King.
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';

--Task  Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY

--Task  Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM ALBUM
ORDER BY TITLE DESC;

--Task  Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY;

--2.3 INSERT INTO

--Task  Insert two new records into Genre table
INSERT INTO GENRE
VALUES (26, 'Country');

INSERT INTO GENRE
VALUES (27, 'EDM');

--Task  Insert two new records into Employee table
INSERT INTO EMPLOYEE
VALUES (9, 'Master', 'Chief', 'Sales Support Agent', 2, '09-JAN-54', '04-MAR-98', '123 Sample Dr', 'Tampa', 'FL', 
'United States', 'T2P 5M5', '+1 (512) 555-5555', '+1 (681) 666-6666', 'masterchief@halo.com');

INSERT INTO EMPLOYEE
VALUES (10, 'Ricky', 'Bobby', 'Sales Support Agent', 2, '09-JAN-63', '04-MAR-01', '123 Address St', 'Columbia', 'SC', 
'United States', 'T2P 5M5', '+1 (512) 111-1111', '+1 (681) 777-7777', 'rickybobby@racing.com');

--Task  Insert two new records into Customer table
INSERT INTO CUSTOMER
VALUES (61, 'Bob', 'Smith', 'Google', '155 West Parkway', 'New York City', 'NY', 'USA', '78666', '+1 (512) 345-4343', 
'+1 (512) 345-3444', 'bobsmith@google.com', 5);

INSERT INTO CUSTOMER
VALUES (62, 'Troy', 'Apple', 'Amazon', '321 Springs Rd', 'New York City', 'NY', 'USA', '12345', '+1 (512) 999-9999', 
'+1 (512) 345-6544', 'troyapple@amazon.com', 5);

--2.4 UPDATE

--Task  Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Task  Update name of artist in the Artist table Creedence Clearwater Revival to CCR
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE

--Task  Select all invoices with a billing address like T%
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN

--Task  Select all invoices that have a total between 15 and 50
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Task  Select all employees hired between 1 st of June 2003 and 1 st of March 2004
SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JAN-03' AND '01-MAR-04';

--2.7 DELETE

--Task  Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).

--Constraints: INVOICELINEINVOICEID(FK) -> INVOICEID(PK), INVOICECUSTOMERID(FK) -> CUSTOMERID(PK), CUSTOMERID(PK)
--So we must delete from INVOICELINE table first, then INVOICE table second, then CUSTOMER table third.

--Delete from INVOICELINE table
DELETE FROM INVOICELINE
WHERE INVOICEID IN (
    SELECT INVOICEID
    FROM INVOICE
    WHERE CUSTOMERID = (
        SELECT CUSTOMERID
        FROM CUSTOMER
        WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'
    )
);

--Delete from INVOICE table
DELETE FROM INVOICE
WHERE CUSTOMERID IN (
    SELECT CUSTOMERID
    FROM CUSTOMER
    WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'
);

--Delete from CUSTOMER table
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3. SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform
--various actions against the database

--3.1 System Defined Functions

--Task  Create a function that returns the current time.
CREATE OR REPLACE FUNCTION GET_CURRENT_TIME
RETURN TIMESTAMP IS
CURRENT_TIME TIMESTAMP;
BEGIN
CURRENT_TIME := CURRENT_TIMESTAMP;
RETURN CURRENT_TIME;
END;
/
SELECT GET_CURRENT_TIME() 
FROM DUAL;

--Task  create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION GET_LENGTH_OF_NAME
(M_ID IN NUMBER)
RETURN NUMBER IS
LENGTH NUMBER;
BEGIN
SELECT LENGTH(NAME)
INTO LENGTH
FROM MEDIATYPE
WHERE MEDIATYPEID = M_ID;
RETURN LENGTH;
END;
/
SELECT GET_LENGTH_OF_NAME(5)
FROM DUAL;

--3.2 System Defined Aggregate Functions

--Task  Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION GET_AVERAGE_TOTAL_ALL_INVOICES
RETURN NUMBER IS
AVGTOTAL NUMBER;
BEGIN
SELECT AVG(TOTAL)
INTO AVGTOTAL
FROM INVOICE;
RETURN AVGTOTAL;
END;
/
SELECT GET_AVERAGE_TOTAL_ALL_INVOICES()
FROM DUAL;

--Task  Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION GET_MOST_EXPENSIVE_TRACK
RETURN NUMBER IS
MOST_EXPENSIVE_TRACK NUMBER;
BEGIN
SELECT MAX(UNITPRICE)
INTO MOST_EXPENSIVE_TRACK
FROM TRACK;
RETURN MOST_EXPENSIVE_TRACK;
END;
/
SELECT GET_MOST_EXPENSIVE_TRACK() FROM DUAL;

--3.3 User Defined Scalar Functions

--Task  Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION GET_AVG_PRICE_IL_ITEMS
RETURN NUMBER IS
AVERAGEPRICE NUMBER;
BEGIN
SELECT AVG(UNITPRICE)
INTO AVERAGEPRICE
FROM INVOICELINE;
RETURN AVERAGEPRICE;
END;
/
SELECT GET_AVG_PRICE_IL_ITEMS() FROM DUAL;

--3.4 User Defined Table Valued Functions

--Task  Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION GET_EMPLOYEES_BORN_AFTER_1968
RETURN SYS_REFCURSOR IS
EMPLOYEES SYS_REFCURSOR;
BEGIN
OPEN EMPLOYEES FOR
SELECT LASTNAME, FIRSTNAME
FROM EMPLOYEE
WHERE BIRTHDATE > '01-JAN-1968';
RETURN EMPLOYEES;
END;
/
SELECT GET_EMPLOYEES_BORN_AFTER_1968() FROM DUAL;

--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.

--4.1 Basic Stored Procedure

--Task  Create a stored procedure that selects the first and last names of all the employees.

--4.2 Stored Procedure Input Parameters
CREATE OR REPLACE PROCEDURE GET_FIRST_LAST_NAMES
(SR OUT SYS_REFCURSOR)
AS
BEGIN
OPEN SR
FOR SELECT FIRSTNAME, LASTNAME 
FROM EMPLOYEE;
END;
/

DECLARE SR SYS_REFCURSOR;
FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE;
LASTNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
GET_FIRST_LAST_NAMES(SR);
LOOP
FETCH SR INTO FIRSTNAME, LASTNAME;
EXIT WHEN SR%NOTFOUND;
DBMS_OUTPUT.PUT_LINE(FIRSTNAME || '  ' || LASTNAME);
END LOOP;
CLOSE SR;
END;
/

--Task  Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_PERSONAL_INFO_EMPLOYEE
(E_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE, E_LASTNAME IN EMPLOYEE.LASTNAME%TYPE, E_FIRSTNAME IN EMPLOYEE.FIRSTNAME%TYPE, 
E_TITLE IN EMPLOYEE.TITLE%TYPE, E_REPORTSTO IN EMPLOYEE.REPORTSTO%TYPE, E_BIRTHDATE IN EMPLOYEE.BIRTHDATE%TYPE, 
E_HIREDATE IN EMPLOYEE.HIREDATE%TYPE, E_ADDRESS IN EMPLOYEE.ADDRESS%TYPE, E_CITY IN EMPLOYEE.CITY%TYPE, 
E_STATE IN EMPLOYEE.STATE%TYPE, E_COUNTRY IN EMPLOYEE.COUNTRY%TYPE, E_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE, 
E_PHONE IN EMPLOYEE.PHONE%TYPE, E_FAX IN EMPLOYEE.FAX%TYPE, E_EMAIL IN EMPLOYEE.EMAIL%TYPE)
AS
BEGIN
UPDATE EMPLOYEE
SET LASTNAME = E_LASTNAME, FIRSTNAME = E_FIRSTNAME, TITLE = E_TITLE, REPORTSTO = E_REPORTSTO, BIRTHDATE = E_BIRTHDATE, 
HIREDATE = E_HIREDATE, ADDRESS = E_ADDRESS, CITY = E_CITY, COUNTRY = E_COUNTRY, POSTALCODE = E_POSTALCODE, PHONE = E_PHONE, 
FAX = E_FAX, EMAIL = E_EMAIL
WHERE EMPLOYEEID = E_EMPLOYEEID;
END;
/
EXECUTE UPDATE_PERSONAL_INFO_EMPLOYEE(10, 'Bob', 'Sam', 'Sales Support Agent', 2, '09-JAN-68', '04-MAR-06', '555 Address St', 'Columbia', 'NC', 'United States', 'T2P 5M5', '+1 (512) 111-1111', '+1 (681) 777-7777', 'bobsam@racing.com');

--Task  Create a stored procedure that returns the managers of an employee .
CREATE OR REPLACE PROCEDURE MANAGERS_OF_EMPLOYEES
AS
CURSOR EMP_CUR
IS
SELECT FIRSTNAME, REPORTSTO
FROM EMPLOYEE;
EMP_ROW EMP_CUR%ROWTYPE;
BEGIN
FOR EMP_ROW
IN EMP_CUR
LOOP
DBMS_OUTPUT.PUT_LINE(EMP_ROW.FIRSTNAME || ' MANAGER IS: ' || EMP_ROW.REPORTSTO);
END LOOP;
END;
/
SET SERVEROUTPUT ON;
BEGIN
MANAGERS_OF_EMPLOYEES;
END;
/

--4.3 Stored Procedure Output Parameters

--Task  Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE NAME_COMPANY_CUSTOMER
IS
CURSOR CUR
IS
SELECT FIRSTNAME, LASTNAME, COMPANY
FROM CUSTOMER;
CURROW CUR%ROWTYPE;
BEGIN
FOR CURROW IN CUR
LOOP
DBMS_OUTPUT.PUT_LINE(CURROW.FIRSTNAME || ' ' || CURROW.LASTNAME || ' ' || CURROW.COMPANY);
END LOOP;
END;
/
SET SERVEROUTPUT ON;
EXECUTE NAME_COMPANY_CUSTOMER();

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored
--procedure.

--Task  Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICEID
(I_INVOICEID IN INVOICE.INVOICEID%TYPE)
AS
BEGIN
DELETE FROM INVOICELINE
WHERE INVOICEID = I_INVOICEID;
DELETE FROM INVOICE
WHERE INVOICEID = I_INVOICEID;
COMMIT;
END;
/
EXECUTE DELETE_INVOICEID(179);

--Task  Create a transaction nested within a stored procedure that inserts a new record in the Customer
--table
CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER
IS
BEGIN
INSERT INTO CUSTOMER
VALUES (62, 'Bo', 'Smith', 'Google', '155 West Parkway', 'New York City', 'NY', 'USA', '78666', '+1 (512) 345-4343', 
'+1 (512) 345-3444', 'bobsmith@google.com', 5);
COMMIT;
END;
/
EXECUTE INSERT_CUSTOMER();

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are
--executed on a table.

--6.1 AFTER/FOR

--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the
--table.
CREATE OR REPLACE TRIGGER INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
BEGIN
DBMS_OUTPUT.PUT_LINE('INSERT EMPLOYEE');
END;
/

--Task  Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER UPDATE_ALBUM
AFTER UPDATE ON ALBUM
BEGIN 
DBMS_OUTPUT.PUT_LINE('UPDATE ALBUM');
END;
/

--Task  Create an after delete trigger on the customer table that fires after a row is deleted from the
--table.
CREATE OR REPLACE TRIGGER DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
BEGIN
DBMS_OUTPUT.PUT_LINE('DELETE CUSTOMER');
END;
/

--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work
--with outer, inner, right, left, cross, and self joins.

--7.1 INNER

--Task  Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.
SELECT FIRSTNAME, LASTNAME, INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2 OUTER

--Task  Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, FIRSTNAME, LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT

--Task  Create a right join that joins album and artist specifying artist name and title.
SELECT NAME, TITLE
FROM ALBUM
RIGHT JOIN ARTIST
ON ALBUM.ARTISTID = ARTIST.ARTISTID;

--7.4 CROSS

--Task  Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT NAME, TITLE
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY NAME;

--7.5 SELF

--Task  Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO <> B.REPORTSTO;