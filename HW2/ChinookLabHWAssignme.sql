-- 2.0 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT INTO GENRE(GENREID,NAME) VALUES(26, 'JPOP');
INSERT INTO GENRE(GENREID,NAME) VALUES(27, 'JROCK');
--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(9,'Uzumaki', 'Naruto', 'President', 3, '13-MAY-56', '28-JUN-87', '13 Leaf Village', 'Miami', 'FL', 'Japan', 'JPN 444', '(000)222-2222', '(222)222-2222', 'naru@to.com');

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Goku', 'Son', 'Security Guard', 3, '13-JAN-76', '28-FEB-21', '13 District Area', 'Compton', 'CA', 'Japan', 'JPN 444', '(000)111-1111', '(111)111-0000', 'dragon@ball.com');

--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
VALUES(60,'Goku','Son','Anime Company Place','somewhere','asdfasf','SP','japan','12227-000','+55 (12) 3923-5555','+55(12)3923-5566','luisg@embraer.com.br',3);

INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
VALUES(61,'Roxas','Son','Organization XIII','Mouse Kingdom','asdfasf','SP','japan','12227-000','+55 (12) 3923-5555','+55(12)3923-5566','luisg@embraer.com.br',3);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE CUSTOMERID = 32;
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
--Task – Select all employees hired between 1 st of June 2003 and 1 st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--2.7 DELETE   -----  NOT COMPLETE --------
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--delete invoices entry
ALTER TABLE CUSTOMER DROP 
   CONSTRAINT FK_CustomerSupportRepId;
/
ALTER TABLE INVOICE DROP 
   CONSTRAINT FK_InvoiceCustomerId;
/
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';
/
ALTER TABLE Customer ADD CONSTRAINT FK_CustomerSupportRepId
    FOREIGN KEY (SupportRepId) REFERENCES Employee (EmployeeId)  ;
/  

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION GETSYSDATE
RETURN DATE IS 
  l_sysdate DATE;
BEGIN
  SELECT sysdate
    INTO l_sysdate
    FROM dual;
  RETURN l_sysdate;
END;
/
SELECT getSysdate() FROM dual;

--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION mediaTypeLen(idOfEntry IN NUMBER)
RETURN NUMBER IS 
  lengthOfName NUMBER;
BEGIN
  SELECT LENGTH(name)
    INTO lengthOfName
    FROM MEDIATYPE
    WHERE MEDIATYPEID = idOfEntry;
  RETURN lengthOfName;
END;
/
SELECT mediaTypeLen(2) FROM dual;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION getInvoiceAverage
RETURN NUMBER IS 
    averageOfInvoices NUMBER;
BEGIN
    SELECT AVG(TOTAL)
        INTO averageOfInvoices
        FROM INVOICE;
    RETURN averageOfInvoices;
END;
/
SELECT getInvoiceAverage() FROM dual;
    
--Task – Create a function that returns the most expensive track   
CREATE OR REPLACE FUNCTION getMostExpensiveTrack
RETURN VARCHAR2 IS
    maxTrack VARCHAR2(60);
BEGIN
    SELECT NAME into maxTrack
    FROM TRACK
    WHERE UNITPRICE = ( 
        SELECT MAX(UNITPRICE)
        FROM TRACK
        );
END;
/
SELECT getMostExpensiveTrack FROM dual;

--select unitprice from track where unitprice > 1.99;  there is no value higher than 1.99

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION getInvoiceLineAverage
RETURN NUMBER IS 
    averageOfInvoiceLINE NUMBER;
BEGIN
    SELECT AVG(UNITPRICE)
        INTO averageOfInvoiceLINE
        FROM INVOICELINE;
    RETURN averageOfInvoiceLINE;
END;
/

SELECT getInvoiceLineAverage() FROM dual;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION getEmployeesList
RETURN SYS_REFCURSOR IS
employees SYS_REFCURSOR;
BEGIN
OPEN employees FOR
SELECT lastname, firstname
FROM employee
WHERE birthdate > '01-JAN-1968';
RETURN employees;
END;
/
SELECT getEmployeesList() FROM dual;
--4.0 Stored Procedures
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE getFirstandLastNameEmployee
(S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S
FOR SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

DECLARE S SYS_REFCURSOR;
FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE; -- SET ALBUM_ID TO WHATEVER DATA TYPE ALBUM_ID IS
LASTNAME EMPLOYEE.LASTNAME%TYPE; 
BEGIN
getFirstandLastNameEmployee(S);
LOOP
FETCH S INTO FIRSTNAME, LASTNAME;
EXIT WHEN S%NOTFOUND; -- BREAK OUT OF LOOP WHEN NO MORE ROWS ARE AVAILABLE

DBMS_OUTPUT.PUT_LINE(FIRSTNAME ||'  '||LASTNAME||' ');
END LOOP;
CLOSE S;
END;
/
SET SERVEROUTPUT ON;
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE updateTitleOfEmployee
(   EmployID IN EMPLOYEE.EMPLOYEEID%TYPE,
    EmployTitle IN EMPLOYEE.TITLE%TYPE
)
IS
BEGIN
UPDATE EMPLOYEE SET TITLE = EmployTitle where EMPLOYEEID = EmployID;
COMMIT;
END;
/
EXECUTE updateTitleOfEmployee(9,'hokagage');

--Task – Create a stored procedure that returns the managers of an employee.
create or replace procedure EmployeesManagers as
cursor emp_cur is
select firstname, reportsto
from employee;
emp_row emp_cur%rowtype;
begin
for emp_row in emp_cur
loop
    dbms_output.put_line(emp_row.firstname||'s    Manager is: '||emp_row.reportsto);
    end loop;
end;
/
set serveroutput on;
begin 
 EmployeesManagers;
end;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
create or replace procedure nameAndCompany as
cursor custComp is
select firstname, lastname, company
from customer;
custrow custComp%rowtype;
begin
for custrow in custComp
loop
dbms_output.put_line(custrow.firstname||'s  ' || custrow.lastname||'s  ' || custrow.company);
end loop;
END;
/
set serveroutput on;
EXECUTE nameAndCompany();

--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
delete from invoiceline where invoicelineid = 267;
delete from invoiceline where invoicelineid = 268;
delete from invoice where invoice.invoiceid = 50;
commit;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer
CREATE OR REPLACE PROCEDURE insertTransactionCustomer
IS
BEGIN
INSERT INTO CUSTOMER VALUES(62,'MightyAx','Mighty','Organization XIII','Mouse Kingdom','asdfasf','SP','japan','12227-000','+55 (12) 3923-5555','+55(12)3923-5566','luisg@embraer.com.br',3);
COMMIT;
END;
/
EXECUTE insertTransactionCustomer();

--6.0 Triggers
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into thetable.
create or replace trigger Employee_Insert_Msg
AFTER INSERT on EMPLOYEE
begin
	dbms_output.put_line('New record inserted into EMPLOYEE');
end;
/
--sequence
CREATE SEQUENCE employee_seq
MINVALUE 9
START WITH 9
INCREMENT BY 1
CACHE 10;
/
INSERT INTO EMPLOYEE VALUES(employee_seq.NEXTVAL,'Mike', 'Myers', NULL, NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
create or replace trigger Album_Update_Msg
AFTER UPDATE on ALBUM
begin
	dbms_output.put_line('New row updated into ALBUM');
end;
/
UPDATE ALBUM SET TITLE='Ball Breaker' WHERE TITLE='For Those About To Rock We Salute You';
/
--Task – Create an after delete trigger on the customer table that fires after a row is deleted from thetable.
create or replace trigger Customer_Delete_Msg
AFTER DELETE on CUSTOMER
begin
	dbms_output.put_line('A row has been deleted from CUSTOMER');
end;
/
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Steve' AND LASTNAME = 'Murray';
/

create or replace trigger Customer_Delete_Msg
AFTER DELETE on CUSTOMER
begin
	dbms_output.put_line('A row has been deleted from CUSTOMER');
end;
/
ALTER TABLE CUSTOMER DROP 
   CONSTRAINT FK_CustomerSupportRepId;
/
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Steve' AND LASTNAME = 'Murray';
/
ALTER TABLE Customer ADD CONSTRAINT FK_CustomerSupportRepId
    FOREIGN KEY (SupportRepId) REFERENCES Employee (EmployeeId)  ;
/  


--7.0 JOINS
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
select firstname, lastname, invoice.invoiceid
from customer
inner join invoice
on customer.customerid = invoice.customerid;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
select customer.customerid, customer.firstname, customer.lastname, invoice.invoiceid, invoice.total
from customer
full outer join invoice
on customer.customerid = invoice.customerid;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
select artist.name, album.title
from artist
right join album
on artist.artistid = album.artistid;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT artist.name, album.title
FROM artist 
CROSS JOIN album
order by artist.name ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.reportsto <> B.reportsto
ORDER BY A.REPORTSTO;
