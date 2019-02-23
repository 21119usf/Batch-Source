--2.0 SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.

--2.1 SELECT

--Task – Select all records from the Employee table.
SELECT * 
FROM EMPLOYEE;

--Task – Select all records from the Employee table where last name is King.
SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY

--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM ALBUM
ORDER BY TITLE DESC;

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY;

--2.3 INSERT INTO

--Task – Insert two new records into Genre table
INSERT INTO GENRE
VALUES (26, 'Country');

INSERT INTO GENRE
VALUES (27, 'EDM');

--Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE
VALUES (9, 'Master', 'Chief', 'Sales Support Agent', 2, '09-JAN-54', '04-MAR-98', '123 Sample Dr', 'Tampa', 'FL', 
'United States', 'T2P 5M5', '+1 (512) 555-5555', '+1 (681) 666-6666', 'masterchief@halo.com');

INSERT INTO EMPLOYEE
VALUES (10, 'Ricky', 'Bobby', 'Sales Support Agent', 2, '09-JAN-63', '04-MAR-01', '123 Address St', 'Columbia', 'SC', 
'United States', 'T2P 5M5', '+1 (512) 111-1111', '+1 (681) 777-7777', 'rickybobby@racing.com');

--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER
VALUES (61, 'Bob', 'Smith', 'Google', '155 West Parkway', 'New York City', 'NY', 'USA', '78666', '+1 (512) 345-4343', 
'+1 (512) 345-3444', 'bobsmith@google.com', 5);

INSERT INTO CUSTOMER
VALUES (62, 'Troy', 'Apple', 'Amazon', '321 Springs Rd', 'New York City', 'NY', 'USA', '12345', '+1 (512) 999-9999', 
'+1 (512) 345-6544', 'troyapple@amazon.com', 5);

--2.4 UPDATE

--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE

--Task – Select all invoices with a billing address like “T%”
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN

--Task – Select all invoices that have a total between 15 and 50

--Task – Select all employees hired between 1 st of June 2003 and 1 st of March 2004

--2.7 DELETE

--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).