-- CREATE TABLES
CREATE TABLE CUSTOMER_BANK_APP (
    CustomerID NUMBER NOT NULL,
    Username VARCHAR2(64) NOT NULL,
    Password VARCHAR2(64) NOT NULL,
    FirstName VARCHAR2(64) NOT NULL,
    LastName VARCHAR2(64) NOT NULL,
    CONSTRAINT PK_CUSTOMER_BANK_APP PRIMARY KEY (CustomerID)
);

CREATE TABLE ACCOUNT_BANK_APP (
    AccountID NUMBER NOT NULL,
    CustomerID NUMBER NOT NULL,
    Balance NUMBER(12, 2) NOT NULL,
    CONSTRAINT PK_ACCOUNT_BANK_APP PRIMARY KEY (AccountID)
);

CREATE TABLE APPLICATION_BANK_APP (
    ApplicationID NUMBER NOT NULL,
    CustomerID NUMBER NOT NULL,
    CONSTRAINT PK_APPLICATION_BANK_APP PRIMARY KEY (ApplicationID)
);

--FOREIGN KEYS
ALTER TABLE ACCOUNT_BANK_APP
ADD CONSTRAINT FK_CustomerID
FOREIGN KEY (CustomerID)
REFERENCES CUSTOMER_BANK_APP (CustomerID);

ALTER TABLE APPLICATION_BANK_APP
ADD CONSTRAINT FK_CustomerID_APPLICATION
FOREIGN KEY (CustomerID)
REFERENCES CUSTOMER_BANK_APP (CustomerID);

--OTHER CONSTRAINTS
ALTER TABLE ACCOUNT_BANK_APP
ADD CONSTRAINT BALANCE_POSITIVE
CHECK (Balance >= 0);

ALTER TABLE CUSTOMER_BANK_APP
ADD CONSTRAINT UNIQUE_USERNAME
UNIQUE (Username);

--SEQUENCE
CREATE SEQUENCE CUSTOMER_ID;
CREATE SEQUENCE ACCOUNT_ID;
CREATE SEQUENCE APPLICATION_ID;

--INSERTS
INSERT INTO CUSTOMER_BANK_APP
VALUES (CUSTOMER_ID.NEXTVAL, 'a', 'a', 'a', 'a');

INSERT INTO ACCOUNT_BANK_APP
VALUES (ACCOUNT_ID.NEXTVAL, 1, 0);

INSERT INTO APPLICATION_BANK_APP
VALUES (APPLICATION_ID.NEXTVAL, 1);

--SELECTS
SELECT CUSTOMERID, USERNAME, FIRSTNAME, LASTNAME FROM CUSTOMER_BANK_APP;
SELECT * FROM ACCOUNT_BANK_APP;
SELECT * FROM APPLICATION_BANK_APP;
SELECT COUNT(*) FROM CUSTOMER_BANK_APP WHERE CustomerID = 10;