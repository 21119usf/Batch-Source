-- 2.1 Select statements, fairly self explanatory
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

-- 2.2 incorporating the ORDER BY & ASC|DESC keywords
SELECT * FROM ALBUM ORDER BY TITLE ASC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY DESC;

-- 2.3 Insert some entries into the database using SELECT COUNT + 1 to ensure unique key value
INSERT INTO GENRE VALUES ( (SELECT COUNT(GENREID) FROM GENRE) + 1,'Dubstep');
INSERT INTO GENRE VALUES ( (SELECT COUNT(GENREID) FROM GENRE) + 1,'Trap');
INSERT INTO EMPLOYEE VALUES ( (SELECT COUNT(EMPLOYEEID) FROM EMPLOYEE) + 1, 'DAVID','LAVOIE','MR',null,TO_DATE('1992-07-15','yyyy-mm-dd'),TO_DATE('2019-02-11','yyyy-mm-dd'),'IDK DO U','VANCOUVER','BC','CANADA','T5K 2N1','978-551-1314','978-551-1314','LAVOIE.DAVIDW@GMAIL.COM');
INSERT INTO EMPLOYEE VALUES ( (SELECT COUNT(EMPLOYEEID) FROM EMPLOYEE) + 1, 'MY DOPPLEGANGER','LIAR','MR',null,TO_DATE('1992-07-15','yyyy-mm-dd'),TO_DATE('2019-02-11','yyyy-mm-dd'),'IDK DO U','VANCOUVER','BC','CANADA','T5K 2N1','978-551-1314','978-551-1314','LAVOIE.DAVIDW@GMAIL.COM');
INSERT INTO CUSTOMER VALUES ( (SELECT COUNT(CUSTOMERID) FROM CUSTOMER) + 1, 'JAMES','BOND','M5','7 SCOTLAND YARD','LONDON','LONDON','ENGLAND','0001','007-007,0070','007-007,0070','007@M5.UK',4);
INSERT INTO CUSTOMER VALUES ( (SELECT COUNT(CUSTOMERID) FROM CUSTOMER) + 1, 'DANIEL','WATERHOUSE','The Massachusetts Bay Colony Insitute of Technological Arts','100 Mass Ave','Cambridge','MA','USA','0001','000-00,0001','000-000,001','root@eruditorum.com',3);

-- 2.4 replace Aaron Mitchell with Robert Walter and Creedence with CCR
UPDATE CUSTOMER
SET FIRSTNAME='Robert',
LASTNAME='Walter'
WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
UPDATE ARTIST
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';

-- 2.5 Select all invoices with a billing address that begins with T
SELECT * FROM INVOICE WHERE billingaddress LIKE 'T%';

-- 2.6a Select invoices that have a total between 15 and 30
SELECT * FROM INVOICE WHERE total BETWEEN 15 AND 30;
-- 2.6B Select employees hired between 01-Jun-2003 and 01-Mar-2004
SELECT * FROM EMPLOYEE WHERE hiredate BETWEEN TO_DATE('01-JUN-2003','DD-MON-YYYY') and TO_DATE('01-MAR-2004','DD-MON-YYYY');

/* 2.7 Delete CUSTOMER Robert Walter. I don't want to lose the invoices, so I set the customerid to 1 instead.
I recognize this is perhaps disingenous, to the issue at hand, but honestly I don't think you should be deleting all of the
invoices of a customer just because you no longer have that customer. Instead you ought to have a row set up for deleted 
customers when you create the table in the first place */
UPDATE INVOICE
SET customerid = 1 WHERE customerid =(SELECT customer.customerid FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter');
DELETE FROM CUSTOMER WHERE FIRSTNAME ='Robert' AND LASTNAME='Walter';

-- 3.1a Create a function to return the current time
CREATE OR REPLACE FUNCTION THREE_ONEA
RETURN VARCHAR2 AS
FU VARCHAR2(20);
BEGIN
SELECT TO_CHAR(LOCALTIMESTAMP , 'DD/MM/YYYY HH:MI:SS') INTO FU FROM DUAL; --THIS ALREADY EXISTED, Y DID I MAKE THIS A FUNCTION?
RETURN FU;
END;
/
SELECT THREE_ONEA FROM DUAL;
-- 3.1b Create a function to return the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION THREE_ONEB(ID NUMBER)
RETURN NUMBER AS
FU NUMBER;
BEGIN
SELECT LENGTH(NAME) INTO FU FROM MEDIATYPE WHERE MEDIATYPEID=ID;
RETURN FU;
END;
/
SELECT LENGTH('Protected AAC audio file') FROM DUAL; --24
SELECT THREE_TWOB(2) FROM DUAL; --24, MATCHES. IS GOOD

-- 3.2a function which returns the aggregate average of all invoices
CREATE OR REPLACE FUNCTION THREE_TWOA
RETURN NUMBER AS
FU NUMBER(10,2);
BEGIN
SELECT AVG(TOTAL) INTO FU FROM INVOICE;
RETURN FU;
END;
/
SELECT THREE_TWOA FROM DUAL; -- passes the eye check
-- 3.2b function which returns the most expensive track(s)
-- since many tracks meet this criteria I return a cursor pointing to all of them.
CREATE OR REPLACE FUNCTION THREE_TWOB
RETURN SYS_REFCURSOR AS
FU SYS_REFCURSOR;
BEGIN
    OPEN FU
    FOR SELECT * 
        FROM TRACK 
        WHERE UNITPRICE=(SELECT MAX(unitprice) FROM TRACK);
RETURN FU;
END;
/
SELECT * FROM TRACK WHERE UNITPRICE = (SELECT MAX(UNITPRICE) FROM TRACK); -- regular query
SELECT THREE_TWOB FROM DUAL; -- Is same. passes eye check again

-- 3.3 create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION THREE_THREE
RETURN NUMBER AS
FU NUMBER(10,2);
BEGIN
    SELECT AVG(unitprice) INTO FU FROM INVOICELINE;
    RETURN FU;
END;
/
SELECT THREE_THREE FROM DUAL; --

-- 3.4 create a function which returns all employees born after 1968
-- like 3.2b returns a ref cursor, since their will be many employees born after 1968.
CREATE OR REPLACE FUNCTION THREE_FOUR
RETURN SYS_REFCURSOR IS
fu SYS_REFCURSOR;
BEGIN
    OPEN FU
    FOR SELECT FIRSTNAME, LASTNAME
        FROM EMPLOYEE
        WHERE BIRTHDATE > TO_DATE('12-JAN-68', 'DD-MON-RR');
    return FU;
END;
/
SELECT THREE_FOUR FROM DUAL;

-- 4.1 select the first and last names of all the employees.
-- This makes no sense, a storage procedure isn't for selecting things?
-- this technically does what you want
CREATE OR REPLACE PROCEDURE FOUR_ONEA
AS S SYS_REFCURSOR;
BEGIN
    OPEN S
    FOR SELECT FIRSTNAME,LASTNAME 
        FROM EMPLOYEE;
        DBMS_SQL.RETURN_RESULT(S);
END;
-- this method is more complicated but also may be more what you want
CREATE SEQUENCE ESEQ
MINVALUE 1
START WITH 1
INCREMENT BY 1
CACHE 10;
--
CREATE TABLE ENAMES (
    EID INTEGER PRIMARY KEY,
    NAME1 VARCHAR2(21),
    NAME2 VARCHAR2(21)
    );

CREATE OR REPLACE PROCEDURE FOUR_ONEB
AS
BEGIN
    INSERT INTO ENAMES SELECT EMPLOYEEID,FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
EXECUTE FOUR_ONEA;
EXECUTE FOUR_ONEB;

-- 4.2a update the personal information of an employee
CREATE OR REPLACE PROCEDURE FOUR_TWOA
(EMPLOYEEID NUMBER, FIRSTNAME VARCHAR2, LASTNAME VARCHAR2, ADDRESS VARCHAR2, CITY VARCHAR2, STATE VARCHAR2, COUNTRY VARCHAR2,
POSTAL VARCHAR2, PHONE VARCHAR2, EMAIL VARCHAR2)
AS
BEGIN
    UPDATE EMPLOYEE
    SET firstname = firstname,
    lastname = lastname,
    address = address,
    city = city,
    state = state,
    country = country,
    postalcode = postal,
    phone = phone,
    email = email
    WHERE EMPLOYEEID=EMPLOYEEID;
END;

--4.2 Return the manager of an employee. AGAIN WHY ISNT THIS A FUNCTION? I DON'T UNDERSTAND.
CREATE OR REPLACE PROCEDURE FOUR_TWOB ( EID NUMBER)
AS S SYS_REFCURSOR;
BEGIN
    OPEN S
    FOR SELECT FIRSTNAME,LASTNAME
        FROM EMPLOYEE
        WHERE EMPLOYEEID=(SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = EID);
        DBMS_SQL.RETURN_RESULT(S);
END;
EXECUTE FOUR_TWOB(2);
--4.3 return the name and company of a customer. AND AGAIN THIS SHOULD BE A FUNCTION >_< it's returning something man.
CREATE OR REPLACE PROCEDURE FOUR_THREE ( CID NUMBER)
AS S SYS_REFCURSOR;
BEGIN
    OPEN S
    FOR SELECT FIRSTNAME,LASTNAME,COMPANY
        FROM CUSTOMER
        WHERE CUSTOMERID=CID;
        DBMS_SQL.RETURN_RESULT(S);
END;
EXECUTE FOUR_THREE(2);

--5.0 transaction that given an invoice id deletes the invoice
--this time I'm just going to delete all the invoice lines associated with the invoice in question
CREATE OR REPLACE PROCEDURE FIVE_OH( IID NUMBER)
AS
BEGIN
    DELETE INVOICELINE WHERE INVOICEID=IID;
    DELETE INVOICE WHERE INVOICEID=IID;
    COMMIT;
END;
/    
SAVEPOINT S1;
EXECUTE FIVE_OH(180);
--5.1 Nest a transaction within a storage procedure to insert a new record into customer
CREATE OR REPLACE PROCEDURE FIVE_ONE
(FIRSTNAME VARCHAR2, LASTNAME VARCHAR2, COMPANY VARCHAR2, ADDRESS VARCHAR2, CITY VARCHAR2, STATE VARCHAR2, COUNTRY VARCHAR2,
POSTAL VARCHAR2, PHONE VARCHAR2, FAX VARCHAR2, EMAIL VARCHAR2)
AS
BEGIN
    INSERT INTO CUSTOMER VALUES (
    (SELECT COUNT(CUSTOMERID) FROM customer) + 1,
    firstname,
    lastname,
    company,
    address,
    city,
    state,
    country,
    postal,
    phone,
    fax,
    email,
    1
    );
    COMMIT;
END;
/

-- 6.1a trigger on the employee table after a new record is inserted into the table
CREATE OR REPLACE TRIGGER SIX_ONEA
AFTER INSERT ON EMPLOYEE
BEGIN
dbms_output.put_line('Hello Employee');
END;
/

-- 6.1b trigger on the album table after a new record is inserted into the table
CREATE OR REPLACE TRIGGER SIX_ONEB
AFTER UPDATE,INSERT ON ALBUM
BEGIN
dbms_output.put_line('Hello Album');
END;
/
-- 6.1c after delete trigger on customer
CREATE OR REPLACE TRIGGER SIX_ONEC
AFTER DELETE ON CUSTOMER
BEGIN
dbms_output.put_line('Goodbye Customer');
END;
/

-- 7.1 Inner join on customers and orders specifying the name of the customer and the invoiceID
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM INVOICE
INNER JOIN CUSTOMER ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

-- 7.2 Outer join on customers and invoices specifying CutomerID, firstname, lastname, invoiceID, and invoice total
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM INVOICE
FULL OUTER JOIN CUSTOMER ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

-- 7.3 Right join on album and artist specifying artist name and title
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ALBUM
RIGHT JOIN ARTIST ON ALBUM.ARTISTID=ARTIST.ARTISTID;

-- 7.4 Cross join on album and artist sorting by artist name in ascending order
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ALBUM
CROSS JOIN ARTIST WHERE ALBUM.ARTISTID=ARTIST.ARTISTID
ORDER BY NAME ASC;

-- 7.5 Self join on employee table, joining on reportsto column
-- I interpreted this to mean replace the reportsto column with the first name and last name of the person you report too.
-- Unfortunately, this does erase bossman, and I'm not sure how to fix that
SELECT A.EMPLOYEEID, A.FIRSTNAME, A.LASTNAME, B.FIRSTNAME AS BOSSNAME1, B.LASTNAME AS BOSSNAME2
FROM EMPLOYEE A, EMPLOYEE B
WHERE a.REPORTSTO=b.EMPLOYEEID;