-- 2.1 SELECT ------------------------------------------------------------------
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE
WHERE LASTNAME = 'King';

SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY ----------------------------------------------------------------
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;

-- 2.3 INSERT INTO -------------------------------------------------------------
INSERT INTO GENRE(GENREID, NAME)
VALUES(26, 'House');

INSERT INTO GENRE(GENREID, NAME)
VALUES(27, 'Drum-and-Bass');

INSERT INTO EMPLOYEE
VALUES(9, 'Smith', 'John', 'IT Staff', 6, '08-MAR-87', '20-AUG-04', 
'284 Main St', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 382-3842', 
'+1 (780) 382-3892', 'smithj@chinookcorp.com');

INSERT INTO EMPLOYEE
VALUES(10, 'Johnson', 'Frank', 'IT Staff', 6, '10-JUL-89', '20-JUN-04', 
'837 West St', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 382-3342', 
'+1 (780) 382-3332', 'johnsonf@chinookcorp.com');

INSERT INTO CUSTOMER
VALUES(60, 'Smith', 'John', NULL, '284 Main St', 'Edmonton', 'Alberta', 
'Canada', 'T5K 2N1', '+1 (780) 382-3842', NULL, 'smithj@chinookcorp.com', 5);

INSERT INTO CUSTOMER
VALUES(61, 'Johnson', 'Frank', NULL, '837 West St', 'Edmonton', 'Alberta', 
'Canada', 'T5K 2N1', '+1 (780) 382-3342', NULL, 'johnsonf@chinookcorp.com', 5);

-- 2.4 UPDATE ------------------------------------------------------------------
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5 LIKE --------------------------------------------------------------------
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN -----------------------------------------------------------------
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004';

-- 2.7 DELETE ------------------------------------------------------------------
DELETE FROM INVOICELINE -- REMOVE INVOICES IN INVOICELINE
WHERE INVOICEID IN (
    SELECT INVOICEID FROM INVOICE
    WHERE CUSTOMERID = (
        SELECT CUSTOMERID FROM CUSTOMER
        WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'
    )
);

DELETE FROM INVOICE     -- REMOVE CUSTOMER IN INVOICE
WHERE CUSTOMERID IN (
    SELECT CUSTOMERID FROM CUSTOMER
    WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'
);

DELETE FROM CUSTOMER    -- REMOVE CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- 3.1 SYSTEM DEFINED FUNCTIONS ------------------------------------------------
CREATE OR REPLACE FUNCTION GET_TIME
RETURN TIMESTAMP IS
T TIMESTAMP;
BEGIN
    T := SYSDATE;
    RETURN(T);
END;
/
SELECT GET_TIME() FROM DUAL;

CREATE OR REPLACE FUNCTION GET_NAME_LENGTH(IDENT IN NUMBER)
RETURN NUMBER IS
L NUMBER;
BEGIN
    SELECT LENGTH(NAME) INTO L FROM MEDIATYPE WHERE MEDIATYPEID = IDENT;
    RETURN(L);
END;
/
SELECT GET_NAME_LENGTH(1) FROM DUAL;

-- 3.2 SYSTEM DEFINED AGGREGATE FUNCTIONS --------------------------------------
CREATE OR REPLACE FUNCTION GET_AVERAGE_INVOICE_TOTAL
RETURN NUMBER IS
TOTALAVG NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO TOTALAVG FROM INVOICE;
    RETURN(TOTALAVG);
END;
/
SELECT GET_AVERAGE_INVOICE_TOTAL() FROM DUAL;

CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN NUMBER IS
MAXTRACK NUMBER;
BEGIN
    SELECT MAX(UNITPRICE) INTO MAXTRACK FROM TRACK;
    RETURN(MAXTRACK);
END;
/
SELECT MOST_EXPENSIVE_TRACK() FROM DUAL;

-- 3.3 USER-DEFINED SCALAR FUNCTIONS -------------------------------------------
CREATE OR REPLACE FUNCTION AVG_INVOICELINE_PRICE
RETURN NUMBER IS
AVGPRICE NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO AVGPRICE FROM INVOICELINE;
    RETURN(AVGPRICE);
END;
/
SELECT AVG_INVOICELINE_PRICE() FROM DUAL;

-- 3.4 USER-DEFINED TABLE VALUED FUNCTIONS -------------------------------------
CREATE OR REPLACE FUNCTION EMPLOYEES_AFTER_1968
RETURN SYS_REFCURSOR IS
C_RESULT SYS_REFCURSOR;
BEGIN
    OPEN C_RESULT FOR
    SELECT EMPLOYEEID FROM EMPLOYEE
    WHERE BIRTHDATE > '01-JAN-1968';
    RETURN C_RESULT;
END;
/
SELECT EMPLOYEES_AFTER_1968() FROM DUAL;

-- 4.1 BASIC STORED PROCEDURE --------------------------------------------------
CREATE OR REPLACE PROCEDURE GET_NAMES(S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
SET SERVEROUTPUT ON SIZE 1000000
DECLARE
    S SYS_REFCURSOR;
    FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
    LAST_NAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    GET_NAMES(S);
    LOOP
        FETCH S
        INTO FIRST_NAME, LAST_NAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRST_NAME || ' ' || LAST_NAME);
    END LOOP;
    CLOSE S;
END;
/

-- 4.2 STORED PROCEDURE INPUT PARAMETERS ---------------------------------------
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_INFO(
    E_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
    E_LASTNAME IN EMPLOYEE.LASTNAME%TYPE,
    E_FIRSTNAME IN EMPLOYEE.FIRSTNAME%TYPE,
    E_ADDRESS IN EMPLOYEE.ADDRESS%TYPE,
    E_CITY IN EMPLOYEE.CITY%TYPE,
    E_COUNTRY IN EMPLOYEE.COUNTRY%TYPE,
    E_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE,
    E_PHONE IN EMPLOYEE.PHONE%TYPE,
    E_FAX IN EMPLOYEE.FAX%TYPE,
    E_EMAIL IN EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE SET LASTNAME = E_LASTNAME WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET FIRSTNAME = E_FIRSTNAME WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET ADDRESS = E_ADDRESS WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET CITY = E_CITY WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET COUNTRY = E_COUNTRY WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET POSTALCODE = E_POSTALCODE WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET PHONE = E_PHONE WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET FAX = E_FAX WHERE EMPLOYEEID = E_EMPLOYEEID;
    UPDATE EMPLOYEE SET EMAIL = E_EMAIL WHERE EMPLOYEEID = E_EMPLOYEEID;
    COMMIT;
END;
/
EXECUTE UPDATE_EMPLOYEE_INFO(10, 'Jones', 'Erik', '666 Satan St', 'Tampa', 'US', '33612', '+1 813-510-0152', '+1 813-510-0153', 'jonese@gmail.com');

CREATE OR REPLACE PROCEDURE RETURN_MANAGER(
    E_EMPLOYEEID IN EMPLOYEE.EMPLOYEEID%TYPE,
    E_MANAGERID OUT EMPLOYEE.REPORTSTO%TYPE)
IS
BEGIN
    SELECT REPORTSTO INTO E_MANAGERID
    FROM EMPLOYEE WHERE EMPLOYEEID = E_EMPLOYEEID;
END;
/
SET SERVEROUTPUT ON
DECLARE
    E_EMPLOYEEID EMPLOYEE.EMPLOYEEID%TYPE;
    E_MANAGERID EMPLOYEE.REPORTSTO%TYPE;
BEGIN
    RETURN_MANAGER(10, E_MANAGERID);
    DBMS_OUTPUT.PUT_LINE(E_MANAGERID);
END;
/

-- 4.3 STORED PROCEDURE OUTPUT PARAMETERS --------------------------------------
CREATE OR REPLACE PROCEDURE GET_NAME_COMPANY(
    CUSTOMER_ID IN CUSTOMER.CUSTOMERID%TYPE,
    C_FN OUT CUSTOMER.FIRSTNAME%TYPE,
    C_LN OUT CUSTOMER.LASTNAME%TYPE,
    C_CO OUT CUSTOMER.COMPANY%TYPE)
IS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY
    INTO C_FN, C_LN, C_CO
    FROM CUSTOMER WHERE CUSTOMERID = CUSTOMER_ID;
END;
/
SET SERVEROUTPUT ON
DECLARE
    C_FN CUSTOMER.FIRSTNAME%TYPE;
    C_LN CUSTOMER.LASTNAME%TYPE;
    C_CO CUSTOMER.COMPANY%TYPE;
BEGIN
    GET_NAME_COMPANY(10, C_FN, C_LN, C_CO);
    DBMS_OUTPUT.PUT_LINE(C_FN || ' ' || C_LN || ' - ' || C_CO);
END;
/

-- 5.0 TRANSACTIONS ------------------------------------------------------------
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICE_ID IN INVOICE.INVOICEID%TYPE)
IS
BEGIN
    -- DELETE INVOICE FROM INVOICELINE
    DELETE FROM INVOICELINE
    WHERE INVOICEID = INVOICE_ID;
    
    -- DELETE INVOICE
    DELETE FROM INVOICE
    WHERE INVOICEID = INVOICE_ID;
END;
/
EXECUTE DELETE_INVOICE(216);

CREATE OR REPLACE PROCEDURE CREATE_CUSTOMER(
    C_CUSTOMERID IN CUSTOMER.CUSTOMERID%TYPE,
    C_FIRSTNAME IN CUSTOMER.FIRSTNAME%TYPE,
    C_LASTNAME IN CUSTOMER.LASTNAME%TYPE,
    C_COMPANY IN CUSTOMER.COMPANY%TYPE,
    C_ADDRESS IN CUSTOMER.ADDRESS%TYPE,
    C_CITY IN CUSTOMER.CITY%TYPE,
    C_STATE IN CUSTOMER.STATE%TYPE,
    C_COUNTRY IN CUSTOMER.COUNTRY%TYPE,
    C_POSTALCODE IN CUSTOMER.POSTALCODE%TYPE,
    C_PHONE IN CUSTOMER.PHONE%TYPE,
    C_FAX IN CUSTOMER.FAX%TYPE,
    C_EMAIL IN CUSTOMER.EMAIL%TYPE,
    C_SUPPORTREPID IN CUSTOMER.SUPPORTREPID%TYPE)
IS
BEGIN
    INSERT INTO CUSTOMER VALUES(
        C_CUSTOMERID, C_FIRSTNAME, C_LASTNAME, C_COMPANY, C_ADDRESS, C_CITY,
        C_STATE, C_COUNTRY, C_POSTALCODE, C_PHONE, C_FAX, C_EMAIL,
        C_SUPPORTREPID);
END;
/
EXECUTE CREATE_CUSTOMER(666, 'Erik', 'Jones', 'Hell Inc.', '666 Satan St', 'Tampa', 'Florida', 'US', '33612', '+1 813-510-0152', '+1 813-510-0153', 'jonese@gmail.com', 5);

-- 6.1 AFTER/FOR ---------------------------------------------------------------
CREATE OR REPLACE TRIGGER AFTER_CREATE_EMPLOYEE
AFTER INSERT ON EMPLOYEE FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:NEW.FIRSTNAME || ' ' || :NEW.LASTNAME || ' created');
END;
/
SET SERVEROUTPUT ON
INSERT INTO EMPLOYEE
VALUES(11, 'Smith', 'John', 'IT Staff', 6, '08-MAR-87', '20-AUG-04', 
'284 Main St', 'Edmonton', 'AB', 'Canada', 'T5K 2N1', '+1 (780) 382-3842', 
'+1 (780) 382-3892', 'smithj@chinookcorp.com');

CREATE OR REPLACE TRIGGER AFTER_UPDATE_ALBUM
AFTER UPDATE OR INSERT ON ALBUM FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:NEW.TITLE || ' created');
END;
/
SET SERVEROUTPUT ON
INSERT INTO ALBUM
VALUES(348, 'Something', 275);

CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.FIRSTNAME || ' ' || :OLD.LASTNAME || ' deleted');
END;
/
SET SERVEROUTPUT ON
DELETE FROM CUSTOMER WHERE CUSTOMERID = 666;

-- 7.1 INNER -------------------------------------------------------------------
SELECT FIRSTNAME, LASTNAME, INVOICEID FROM CUSTOMER C
JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID
ORDER BY C.LASTNAME;

-- 7.2 OUTER -------------------------------------------------------------------
SELECT FIRSTNAME, LASTNAME, INVOICEID, TOTAL FROM CUSTOMER C
FULL JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID
ORDER BY C.LASTNAME;

-- 7.3 RIGHT -------------------------------------------------------------------
SELECT NAME, TITLE FROM ALBUM AL
RIGHT JOIN ARTIST AR ON AL.ARTISTID = AR.ARTISTID
ORDER BY NAME;

-- 7.4 CROSS -------------------------------------------------------------------
SELECT NAME, TITLE FROM ALBUM AL
CROSS JOIN ARTIST AR
ORDER BY NAME ASC;

-- 7.5 SELF --------------------------------------------------------------------
SELECT
    (E.FIRSTNAME || ' ' || E.LASTNAME) EMPLOYEE,
    (M.FIRSTNAME || ' ' || M.LASTNAME) MANAGER
FROM EMPLOYEE E
LEFT JOIN EMPLOYEE M ON E.REPORTSTO = M.EMPLOYEEID
ORDER BY MANAGER;
