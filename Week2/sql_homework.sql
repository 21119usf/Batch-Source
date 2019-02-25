--GEORGE SALINAS----
--ORACLE CHINOOK SQL LAB----
--2.1 SELECT--
-- 2.1.1--
SELECT * 
FROM Employee; 
--2.1.2--
SELECT *
FROM Employee 
WHERE lastname = 'King'; 
--2.1.3-- 
SELECT * 
FROM Employee
WHERE firstname = 'Andrew' AND reportsto IS NULL;

--2.2 ORDER BY--
--2.2.1---
SELECT title
FROM Album
ORDER BY title DESC;
--2.2.2--
SELECT firstname
FROM customer
ORDER BY firstname ASC; 

--2.3 INSERT INTO--
--2.3.1--------------------------------------------------------------
INSERT INTO genre(genreid, name)
VALUES (26, 'Salsa');
INSERT INTO genre(genreid, name)
VALUES (27, 'Bolero'); 
--2.3.2---------------------------------------------------------------
INSERT INTO employee(employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
VALUES (9, 'Salinas', 'George', 'Dishwasher', 3, '21-MAR-90', '08-AUG-15', 'real drive', 'Orlando', 'FL', 'US', 'T2P 2T3', '+1(321) 989-2234', '+1(999) 888-3344', 'george@gmail.com'); 
INSERT INTO employee (employeeid, lastname, firstname, title, reportsto, birthdate, hiredate, address, city, state, country, postalcode, phone, fax, email)
VALUES (10, 'Vallejos', 'Hanz', 'Valet', 3, '21-APR-90', '08-MAY-15', '22680 Granda Run', 'Winter Park', 'FL', 'US', 'T2P 2T3', '+1(321) 989-2234', '+1(999) 888-3344', 'hanz@gmail.com'); 
--2.3.3-- 
INSERT INTO customer(customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
VALUES (60, 'Renzo', 'Ronald', 'Revature', '1145 Prism circle', 'Tampa', 'FL', 'US', '99999', '+1(444) 555-2345', '+1(555) 898-0980', 'ronald@gmail.com', 5);
INSERT INTO customer(customerid, firstname, lastname, company, address, city, state, country, postalcode, phone, fax, email, supportrepid)
VALUES (61, 'Fiorella', 'Mayra', 'Revature1', '1146 Prism circle', 'Tampa', 'FL', 'US', '99009', '+1(444) 333-2345', '+1(555) 898-0000', 'mayrad@gmail.com', 8);

--2.4 UPDATE--
--2.4.1----------------------------------------
UPDATE customer 
SET firstname = 'Robert', lastname = 'Walter'
WHERE customerid = (SELECT customerid
                    FROM customer
                    WHERE firstname = 'Aaron' AND lastname = 'Mitchell');
--2.4.2------------------------------------------
UPDATE artist
SET name = 'CCR'
WHERE artistid = (SELECT artistid
                  FROM artist
                  WHERE name='Creedence Clearwater Revival'); 

--2.5 LIKE---------------------------------------
SELECT * 
FROM invoice
WHERE billingaddress LIKE 'T%'; 

--2.6 BETWEEN--
--2.6.1------------------------------------------
SELECT *
FROM invoice 
WHERE total BETWEEN 15 AND 50; 
--2.6.2-------------------------------------------
SELECT * 
FROM employee 
WHERE hiredate BETWEEN '01-JUN-03' AND '01-MAR-04'; 

--2.7 DELETE----------------------------------------
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE INVOICE
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID)
ON DELETE CASCADE;  

ALTER TABLE INVOICELINE
DROP CONSTRAINT FK_INVOICELINEINVOICEID; 

ALTER TABLE INVOICELINE
ADD CONSTRAINT FK_INVOICELINEINVOICEID
FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID)
ON DELETE CASCADE; 

SELECT*
FROM CUSTOMER 
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'; 

--3 SQL FUNCTIONS--
--3.1 System Defined Functions--
--3.1.1----------------------------------
CREATE OR REPLACE FUNCTION current_time
RETURN TIMESTAMP IS 
c_time TIMESTAMP; 

BEGIN  
    c_time := SYSDATE; 
    RETURN c_time; 
END; 
 / 
 
DECLARE
    t TIMESTAMP;
BEGIN
    t := current_time();  
    DBMS_OUTPUT.PUT_LINE(t); 
END; 
/ 
EXIT; 
--3.1.2----------------------
CREATE OR REPLACE FUNCTION return_name_length(name VARCHAR2)
RETURN NUMBER
IS
    name_length NUMBER := 0; 
BEGIN
    SELECT LENGTH(name)
    INTO name_length
    FROM dual; 
    RETURN name_length; 
END; 
/

DECLARE 
    random_name VARCHAR2(100) := 'GEORGE SALINAS'; 
BEGIN
    DBMS_OUTPUT.PUT_LINE('NAME LENGTH: ' || return_name_length(random_name)); 
END;
/ 

--3.2 System Defined Aggregate Functions------
--3.2.1-------------
CREATE OR REPLACE FUNCTION return_invoice_averg
RETURN NUMBER
IS av NUMBER;
BEGIN
    SELECT AVG(TOTAL)
    INTO av 
    FROM INVOICE 
    WHERE TOTAL IS NOT NULL; 
    RETURN av; 
END; 
/

DECLARE 
    average NUMBER := 0;
BEGIN 
    average := return_invoice_averg;
    DBMS_OUTPUT.PUT_LINE('TOTAL AVERAGE: ' || average); 
END; 
/
EXIT; 

--3.2.2--------
CREATE OR REPLACE FUNCTION return_most_expen_track
RETURN NUMBER
IS most_expensive NUMBER;
BEGIN 
    SELECT MAX(unitprice)
    INTO most_expensive
    FROM TRACK; 
    RETURN most_expensive;
END; 
/ 
SELECT return_most_expen_track
FROM DUAL; 

---3.3 User Defined Scalar Functions------
CREATE OR REPLACE FUNCTION get_total_invoice_avg
RETURN NUMBER 
IS gti NUMBER;
BEGIN 
    SELECT AVG(UNITPRICE)
    INTO gti
    FROM INVOICELINE; 
    RETURN gti;
END; 
/ 

SELECT get_total_invoice_avg
FROM DUAL; 

---3.4--------
CREATE OR REPLACE FUNCTION get_employee_af1968
RETURN SYS_REFCURSOR
AS SYS_F SYS_REFCURSOR; 

BEGIN 
    OPEN SYS_F FOR
    SELECT *
    FROM EMPLOYEE
    WHERE BIRTHDATE > '31-DEC-68'; 
    RETURN SYS_F; 
END; 
/ 
SELECT get_employee_af1968
FROM DUAL; 

---4.O Stored Procedures----
---4.1--------
CREATE OR REPLACE PROCEDURE CALL_NAMES(P_CURSOR OUT SYS_REFCURSOR)
IS
    FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
    LAST_NAME EMPLOYEE.LASTNAME%TYPE; 
    
BEGIN 
    LOOP 
        FETCH P_CURSOR
        INTO FIRST_NAME, LAST_NAME;
        EXIT WHEN P_CURSOR%NOTFOUND; 
    END LOOP; 
END; 
/
DECLARE     
    MY_CURSOR SYS_REFCURSOR; 
BEGIN 
    OPEN MY_CURSOR FOR 
        SELECT FIRSTNAME, LASTNAME
        FROM EMPLOYEE;
    CALL_NAMES(MY_CURSOR); 
    CLOSE MY_CURSOR; 
END; 
/ 
--4.2 STORED PROCEDURE INPUT PARAMETERS-------
CREATE OR REPLACE PROCEDURE UPDATE_INFO(X_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
                                        X_LASTNAME IN EMPLOYEE.LASTNAME%TYPE, 
                                        X_FIRSTNAME IN EMPLOYEE.FIRSTNAME%TYPE, 
                                        X_TITLE IN EMPLOYEE.TITLE%TYPE, 
                                        X_ADDRESS IN EMPLOYEE.ADDRESS%TYPE, 
                                        X_CITY IN EMPLOYEE.CITY%TYPE, 
                                        X_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE, 
                                        X_PHONE IN EMPLOYEE.PHONE%TYPE, 
                                        X_EMAIL IN EMPLOYEE.EMAIL%TYPE)
IS  
BEGIN
    UPDATE EMPLOYEE SET LASTNAME = X_LASTNAME WHERE EMPLOYEEID = X_EMPLOYEEID;
    UPDATE EMPLOYEE SET FIRSTNAME = X_FIRSTNAME WHERE EMPLOYEEID = X_EMPLOYEEID;
    UPDATE EMPLOYEE SET TITLE = X_TITLE WHERE EMPLOYEEID = X_EMPLOYEEID;
    UPDATE EMPLOYEE SET ADDRESS = X_ADDRESS WHERE EMPLOYEEID = X_EMPLOYEEID;
    UPDATE EMPLOYEE SET CITY = X_CITY WHERE EMPLOYEEID = X_EMPLOYEEID;
    UPDATE EMPLOYEE SET POSTALCODE = X_POSTALCODE WHERE EMPLOYEEID = X_EMPLOYEEID;
    UPDATE EMPLOYEE SET PHONE = X_PHONE WHERE EMPLOYEEID = X_EMPLOYEEID;
    UPDATE EMPLOYEE SET EMAIL = X_EMAIL WHERE EMPLOYEEID = X_EMPLOYEEID;
    COMMIT; 
END; 
/
EXECUTE UPDATE_INFO(4, 'George', 'Salinas', 'General Manager', '2680 Granada Run', 'Tampa', 'T5K 2N1', '+1(345) 000-5673', 'george@gmail.com'); 

--4.2.2-----
CREATE OR REPLACE PROCEDURE GET_MY_MANAGER(MY_ID IN EMPLOYEE.EMPLOYEEID%TYPE, MY_MANAGERS OUT EMPLOYEE.REPORTSTO%TYPE)
IS
BEGIN
    SELECT REPORTSTO
    INTO MY_MANAGERS
    FROM EMPLOYEE
    WHERE EMPLOYEEID = MY_ID; 
END; 
/

DECLARE
    M_MANAGERS EMPLOYEE.REPORTSTO%TYPE; 
    M_ID EMPLOYEE.EMPLOYEEID%TYPE; 
BEGIN 
    GET_MY_MANAGER(6, M_MANAGERS); 
    DBMS_OUTPUT.PUT_LINE('MY NUMBER OF MANAGERS IS: ' || M_MANAGERS); 
END; 
/ 
--4.3 STORE PROCEDURE OUTPUT PARAMETERS-----------
CREATE OR REPLACE PROCEDURE MY_INFO(MY_ID IN CUSTOMER.CUSTOMERID%TYPE)
IS 
    MY_COMPANY CUSTOMER.COMPANY%TYPE; 
    MY_FIRSTNAME CUSTOMER.FIRSTNAME%TYPE;
    MY_LASTNAME CUSTOMER.LASTNAME%TYPE;
BEGIN
    SELECT COMPANY, FIRSTNAME, LASTNAME
    INTO MY_COMPANY, MY_FIRSTNAME, MY_LASTNAME
    FROM CUSTOMER WHERE CUSTOMERID = MY_ID; 
    DBMS_OUTPUT.PUT_LINE(MY_FIRSTNAME|| ' ' ||MY_LASTNAME|| ' - ' ||MY_COMPANY);
END; 
/ 
DECLARE
BEGIN 
    MY_INFO(1);
END; 
/
--5.0 TRANSACTIONS----
--Create a transaction that given a invoiceId will delete that invoice 
--(There may be constraints that rely on this, find out how to resolve them).---
CREATE OR REPLACE PROCEDURE DEL_INVOICE(MY_INVOICEID IN INVOICE.INVOICEID%TYPE)
IS 
BEGIN
    DELETE FROM INVOICELINE 
    WHERE INVOICEID = MY_INVOICEID; 
    BEGIN
        DELETE FROM INVOICE
        WHERE INVOICEID = MY_INVOICEID; 
    END;
END; 
/ 
EXECUTE DEL_INVOICE(1);
-- Create a transaction nested within a stored procedure that inserts 
--a new record in the 
CREATE OR REPLACE PROCEDURE INSERT_RECORD(MYCUSTOMERID IN CUSTOMER.CUSTOMERID%TYPE,
                                          MYFIRSTNAME IN CUSTOMER.FIRSTNAME%TYPE,
                                          MYLASTNAME IN CUSTOMER.LASTNAME%TYPE,
                                          MYCOMPANY IN CUSTOMER.COMPANY%TYPE,
                                          MYADDRESS IN CUSTOMER.ADDRESS%TYPE,
                                          MYCITY IN CUSTOMER.CITY%TYPE,
                                          MYSTATE IN CUSTOMER.STATE%TYPE,
                                          MYCOUNTRY IN CUSTOMER.COUNTRY%TYPE,
                                          MYPOSTALCODE IN CUSTOMER.POSTALCODE%TYPE,
                                          MYPHONE IN CUSTOMER.PHONE%TYPE,
                                          MYFAX IN CUSTOMER.FAX%TYPE,
                                          MYEMAIL IN CUSTOMER.EMAIL%TYPE,
                                          MYSUPPORTREPID IN CUSTOMER.SUPPORTREPID%TYPE)
IS
BEGIN
    INSERT INTO CUSTOMER VALUES(MYCUSTOMERID, MYFIRSTNAME, MYLASTNAME, MYCOMPANY, MYADDRESS,
                                MYCITY, MYSTATE, MYCOUNTRY, MYPOSTALCODE, MYPHONE, MYFAX, MYEMAIL,
                                MYSUPPORTREPID); 
END;
/ 
EXECUTE INSERT_RECORD(90, 'hanz', 'vallejos', 'revature', '2680 Granada Run', 'Tampa', 'FL', 'US', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'hanz@gmail.com', 3);

--6.0 TRIGGERS----
--Create an after insert trigger on the employee table fired after
--a new record is inserted into the table.
CREATE OR REPLACE TRIGGER AFTER_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE FOR EACH ROW 
BEGIN   
    INSERT INTO EMPLOYEE VALUES(61, 'SALINAS', 'VALLEJOS', 'Software engineer', 9, '09-DEC-87', '13-JAN-90', '202 Hoxton Street', 'London', 'FL', 'United Kingdom', 'SW1V 3EN', '+44 020 7976 5722', '+44 020 7976 5722', 'hanz@gmail.com');
END;
/ 
--Create an after update trigger on the album table that 
--fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER AFTER_UPDATE_ALBUM 
BEFORE UPDATE OR INSERT ON ALBUM FOR EACH ROW
BEGIN 
    DBMS_OUTPUT.PUT_LINE(:OLD.TITLE || ' HAS BEEN UPDATED FROM ALBUM TABLE'); 
END;
/ 
UPDATE ALBUM SET TITLE = 'NEW ALBUM FOR YALL!!' WHERE ALBUMID = 1; 
--Create an after delete trigger on the customer table that fires after a row 
--is deleted from the table.
CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER 
AFTER DELETE ON CUSTOMER FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.FIRSTNAME || ' ' || :OLD.LASTNAME || ' REMOVED FROM TABLE'); 
END; 
/ 
DELETE FROM CUSTOMER WHERE CUSTOMERID = 90; 
--7.0 JOINS---
--7.1 INNER---
SELECT FIRSTNAME, LASTNAME, INVOICEID, C.CUSTOMERID
FROM CUSTOMER C
INNER JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID
ORDER BY C.LASTNAME, C.FIRSTNAME; 
--7.2 OUTER--
SELECT C.CUSTOMERID, INVOICEID, FIRSTNAME, LASTNAME, TOTAL 
FROM CUSTOMER C 
FULL JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID
ORDER BY C.LASTNAME, C.FIRSTNAME; 
--7.3 RIGHT--
SELECT AL.TITLE, AR.NAME
FROM ALBUM AL
RIGHT OUTER JOIN ARTIST AR ON AL.ARTISTID = AR.ARTISTID
ORDER BY AR.NAME;
--7.4 CROSS---
SELECT TITLE, NAME, ROUND(DBMS_RANDOM.VALUE(0,10))QUANTITY
FROM ALBUM
CROSS JOIN ARTIST 
ORDER BY NAME; 
--SELF JOIN--
SELECT
(E1.FIRSTNAME || '  ' || E1.LASTNAME) EMPLOYEE,
(E2.FIRSTNAME || '  ' || E2.LASTNAME) MANAGER
FROM EMPLOYEE E1
LEFT JOIN EMPLOYEE E2 ON E1.REPORTSTO = E2.EMPLOYEEID
ORDER BY MANAGER; 


