--SQL ASSIGNMENT
--SECTION 2: SQL QUERIES
/*
2.1 SELECT
Task – Select all records from the Employee table.
Task – Select all records from the Employee table where last name is King.
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

/*
2.2 ORDER BY
Task – Select all albums in Album table and sort result set in descending order by title.
Task – Select first name from Customer and sort result set in ascending order by city
*/
SELECT * FROM ALBUM ORDER BY TITLE DESC; --DESC = DESCENDING ORDER; ASC = ASCENDING ORDER
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

/*
2.3 INSERT INTO
Task – Insert two new records into Genre table 
Task – Insert two new records into Employee table
Task – Insert two new records into Customer table
*/
INSERT INTO GENRE VALUES(26, '8-bit');
INSERT INTO GENRE VALUES (27, 'Animation');
INSERT INTO EMPLOYEE VALUES(9, 'Sosa', 'Juan', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO EMPLOYEE VALUES(10, 'Knighten', 'Matt', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO CUSTOMER VALUES(60, 'Juan', 'Sosa', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'jsosa690@gmail.com', NULL);
INSERT INTO CUSTOMER VALUES(61, 'Matt', 'Knighten', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'jsosa690@gmail.com', NULL);

/*
2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
*/
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

/*
2.5 LIKE
Task – Select all invoices with a billing address like “T%” 
*/
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

/*
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter 
(There may be constraints that rely on this, find out how to resolve them).
*/
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID = 32;
DELETE FROM INVOICELINE WHERE INVOICEID = 116;
DELETE FROM INVOICELINE WHERE INVOICEID = 342;
DELETE FROM INVOICELINE WHERE INVOICEID = 245;
DELETE FROM INVOICELINE WHERE INVOICEID = 268;
DELETE FROM INVOICELINE WHERE INVOICEID = 290;
DELETE FROM INVOICELINE WHERE INVOICEID = 50;
DELETE FROM INVOICELINE WHERE INVOICEID = 61;
DELETE FROM INVOICE WHERE CUSTOMERID = 32;
DELETE FROM CUSTOMER WHERE CUSTOMERID = 32;

--SECTION 3: SQL FUNCTIONS
/*
3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of name in MEDIATYPE table
*/
CREATE OR REPLACE FUNCTION GIVETIME
RETURN DATE IS RETURNDATE DATE;
BEGIN
    SELECT SYSDATE INTO RETURNDATE FROM DUAL;
    RETURN RETURNDATE;
END;
/
SELECT GIVETIME FROM DUAL;

CREATE OR REPLACE FUNCTION NAMELENGTH(N_ID IN MEDIATYPE.MEDIATYPEID%TYPE)
RETURN NUMBER IS TOTAL_LENGTH NUMBER(10,2);
    BEGIN
        SELECT LENGTH(NAME) INTO TOTAL_LENGTH FROM MEDIATYPE WHERE MEDIATYPEID = N_ID;
        RETURN TOTAL_LENGTH;
    END;
/
SELECT NAMELENGTH(2) FROM DUAL; --Returns length of media with id = 2

/*
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices 
Task – Create a function that returns the most expensive track
*/
CREATE OR REPLACE FUNCTION AVERAGE
RETURN NUMBER AS N_TOTAL NUMBER(10,2);
BEGIN
    SELECT AVG(TOTAL) INTO N_TOTAL FROM INVOICE;
    RETURN N_TOTAL;
END;
/
SELECT AVERAGE FROM DUAL;

CREATE OR REPLACE FUNCTION EXPENSIVE
RETURN NUMBER AS BOUGIE NUMBER(10,2);
BEGIN
    SELECT MAX(UNITPRICE) INTO BOUGIE FROM TRACK;
    RETURN BOUGIE;
END;
/
SELECT EXPENSIVE FROM DUAL;

/*
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
*/
CREATE OR REPLACE FUNCTION AVG_ITEMS
RETURN NUMBER AS AVERAGE NUMBER(10,2);
BEGIN
    SELECT AVG(UNITPRICE) INTO AVERAGE
    FROM INVOICELINE;
RETURN AVERAGE;
END;
/
SELECT AVG_ITEMS FROM DUAL;

/*
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/
CREATE OR REPLACE FUNCTION GETEMPLOYEES
RETURN SYS_REFCURSOR IS S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE BIRTHDATE > '01-JAN-1968';
    RETURN S;
END;
/
SELECT GETEMPLOYEES FROM DUAL;

--SECTION 4: STORED PROCEDURES
/*
4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.
*/
CREATE OR REPLACE PROCEDURE EMPLOYEENAME(
    S OUT SYS_REFCURSOR)
IS 
BEGIN
    OPEN S FOR
        SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE;
END;
/
DECLARE 
    S SYS_REFCURSOR;
    FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE;
    LASTNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    EMPLOYEENAME(S);
    LOOP
        FETCH S INTO FIRSTNAME, LASTNAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRSTNAME||' '||LASTNAME);
    END LOOP;
    CLOSE S;
END;
/
SET SERVEROUTPUT ON;

/*
4.2 Stored Procedure Input Parameters
Task – Create a stored procedure that updates the personal information of an employee.
Task – Create a stored procedure that returns the managers of an employee .
*/
CREATE OR REPLACE PROCEDURE UPDATEEMPLOYEE(
    E_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
    E_TITLE IN EMPLOYEE.TITLE%TYPE,
    E_REPORTSTO IN EMPLOYEE.REPORTSTO%TYPE,
    E_HIREDATE IN EMPLOYEE.HIREDATE%TYPE,
    E_ADDRESS IN EMPLOYEE.ADDRESS%TYPE,
    E_CITY IN EMPLOYEE.CITY%TYPE,
    E_STATE IN EMPLOYEE.STATE%TYPE,
    E_COUNTRY IN EMPLOYEE.COUNTRY%TYPE,
    E_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE,
    E_PHONE IN EMPLOYEE.PHONE%TYPE,
    E_FAX IN EMPLOYEE.FAX%TYPE,
    E_EMAIL IN EMPLOYEE.EMAIL%TYPE)
AS
BEGIN
    UPDATE EMPLOYEE SET TITLE = E_TITLE,
                        REPORTSTO = E_REPORTSTO,
                        HIREDATE = E_HIREDATE,
                        ADDRESS = E_ADDRESS,
                        CITY = E_CITY,
                        STATE = E_STATE,
                        COUNTRY = E_COUNTRY,
                        POSTALCODE = E_POSTALCODE,
                        PHONE = E_PHONE,
                        FAX = E_FAX,
                        EMAIL = E_EMAIL
    WHERE EMPLOYEEID = E_EMPLOYEEID;
END;
/

CREATE OR REPLACE PROCEDURE BOSSFINDER(
    EMPLOYEEIN EMPLOYEE.EMPLOYEEID%TYPE,
    BOSSOUT OUT EMPLOYEE.EMPLOYEEID%TYPE)
AS 
BEGIN
    SELECT REPORTSTO INTO BOSSOUT
    FROM EMPLOYEE
    WHERE EMPLOYEEID=EMPLOYEEIN;
END;
/
DECLARE
    BOSSFIRST EMPLOYEE.LASTNAME%TYPE;
    BOSSLAST EMPLOYEE.FIRSTNAME%TYPE;
    BOSSID EMPLOYEE.EMPLOYEEID%TYPE;
BEGIN
    BOSSFINDER(2,BOSSID);
    SELECT FIRSTNAME, LASTNAME 
    INTO BOSSFIRST, BOSSLAST
    FROM EMPLOYEE
    WHERE EMPLOYEEID=BOSSID;
    DBMS_OUTPUT.put_line(BOSSFIRST||' '||BOSSLAST);
END;
/

/*
4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.
*/
CREATE OR REPLACE PROCEDURE RETURNER(
    CUSTOMERIN IN CUSTOMER.CUSTOMERID%TYPE,
    FIRSTOUT OUT CUSTOMER.FIRSTNAME%TYPE,
    LASTOUT OUT CUSTOMER.LASTNAME%TYPE,
    COMPANYOUT OUT CUSTOMER.COMPANY%TYPE)
AS  
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY 
    INTO FIRSTOUT, LASTOUT, COMPANYOUT
    FROM CUSTOMER
    WHERE CUSTOMERID=CUSTOMERIN;
END;
/
SET SERVEROUTPUT ON;
DECLARE
    firstName CUSTOMER.FIRSTNAME%TYPE;
    lastName CUSTOMER.LASTNAME%TYPE;
    company CUSTOMER.COMPANY%TYPE;
BEGIN
    RETURNER(1,firstName,lastName,company);
    DBMS_OUTPUT.PUT_LINE(firstName || ' ' || lastName || ' works for: ' || company);
END;
/

--SECTION 5: TRANSACTIONS
/*
5.1 
Task – Create a transaction that given a invoiceId will delete that invoice 
(There may be constraints that rely on this, find out how to resolve them).
Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/
CREATE OR REPLACE PROCEDURE REMOVAL(I_ID IN INVOICE.INVOICEID%TYPE)
AS
BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = I_ID;
    DELETE FROM INVOICE WHERE INVOICEID = I_ID;
    COMMIT;
END;
/

CREATE SEQUENCE CUSTOMERSEQ
MINVALUE 1
MAXVALUE 10000
START WITH 62
INCREMENT BY 1
CACHE 20;

CREATE OR REPLACE PROCEDURE CUSTOMERCREATE(
    I_FIRSTNAME IN CUSTOMER.FIRSTNAME%TYPE,
    I_LASTNAME IN CUSTOMER.LASTNAME%TYPE,
    I_COMPANY IN CUSTOMER.COMPANY%TYPE,
    I_ADDRESS IN CUSTOMER.ADDRESS%TYPE,
    I_CITY IN CUSTOMER.CITY%TYPE,
    I_STATE IN VARCHAR2,
    I_COUNTRY IN CUSTOMER.COUNTRY%TYPE,
    I_POSTALCODE IN CUSTOMER.POSTALCODE%TYPE,
    I_PHONE IN CUSTOMER.PHONE%TYPE,
    I_FAX IN CUSTOMER.FAX%TYPE,
    I_EMAIL IN CUSTOMER.EMAIL%TYPE,
    I_SUPPORTREPID IN CUSTOMER.SUPPORTREPID%TYPE)
IS BEGIN
    INSERT INTO CUSTOMER VALUES(CUSTOMERSEQ.NEXTVAL,
                                I_FIRSTNAME,
                                I_LASTNAME,
                                I_COMPANY,
                                I_ADDRESS,
                                I_CITY,
                                I_STATE,
                                I_COUNTRY,
                                I_POSTALCODE,
                                I_PHONE,
                                I_FAX,
                                I_EMAIL,
                                I_SUPPORTREPID);
    COMMIT;
END;
/
EXECUTE ADD_NEW_CUSTOMER('Juan','Sosa','Revature','399 Cook Blvd','Bradley','Illinois','USA','60915','8153866635','1','jsosa690@gmail.com','3');

--SECTION 6: TRIGGERS
/*
6.1 AFTER/FOR
Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
Task – Create an after update trigger on the album table that fires after a row is inserted in the table
Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/
CREATE TRIGGER INSERTION
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('AFTER INSERTION TRIGGER');
END;

CREATE TRIGGER E_UPDATE
AFTER UPDATE ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('AFTER UPDATE TRIGGER');
END;

CREATE TRIGGER E_DELETE
AFTER DELETE ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('AFTER DELETE TRIGGER');
END;

--SECTION 7: JOINS
/*
7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID FROM CUSTOMER
INNER JOIN INVOICE
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

/*
7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, 
specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE
ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

/*
7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM RIGHT JOIN ARTIST
ON ARTIST.ARTISTID = ALBUM.ARTISTID;

/*
7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/
SELECT * FROM
ALBUM CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

/*
7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.
*/
--FIX THIS PLSSSSSSSSSS
SELECT *
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.reportsto <> B.reportsto
ORDER BY A.REPORTSTO;