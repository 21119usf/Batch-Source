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

--Task – Insert two new records into Employee table

--Task – Insert two new records into Customer table

--2.4 UPDATE

--Task – Update Aaron Mitchell in Customer table to Robert Walter

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

--2.5 LIKE

--Task – Select all invoices with a billing address like “T%”

--2.6 BETWEEN

--Task – Select all invoices that have a total between 15 and 50

--Task – Select all employees hired between 1 st of June 2003 and 1 st of March 2004

--2.7 DELETE

--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).