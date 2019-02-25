CREATE TABLE BEAR (
    BEAR_ID INTEGER PRIMARY KEY, 
    BEAR_TYPE_ID INTEGER,
    BEAR_NAME VARCHAR2(100),
    BEAR_BIRTHDATE DATE,
    BEAR_WEIGHT INTEGER DEFAULT 200,
    CAVE_ID INTEGER
    );
    
CREATE TABLE BEAR_TYPE (
  	BEAR_TYPE_ID INTEGER PRIMARY KEY,
  	BEAR_TYPE_NAME VARCHAR2(100)
);

CREATE TABLE CAVE (
  	CAVE_ID INTEGER PRIMARY KEY,
  	CAVE_NAME VARCHAR2(100),
  	MAX_BEARS INTEGER DEFAULT 4
);

CREATE TABLE BEEHIVE (
  	BEEHIVE_ID INTEGER PRIMARY KEY,
  	BEEHIVE_WEIGHT INTEGER DEFAULT 50
);

CREATE TABLE BEAR_BEEHIVE (
  	BEAR_ID INTEGER,
  	BEEHIVE_ID INTEGER,
  	PRIMARY KEY (BEAR_ID, BEEHIVE_ID)
);

ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_BEAR_TYPE
FOREIGN KEY (BEAR_TYPE_ID) REFERENCES BEAR_TYPE(BEAR_TYPE_ID);


ALTER TABLE BEAR
ADD CONSTRAINT FK_BEAR_CAVE
FOREIGN KEY (CAVE_ID) REFERENCES CAVE(CAVE_ID);


ALTER TABLE BEAR_BEEHIVE
ADD CONSTRAINT FK_BEAR_BEEHIVE_BEAR
FOREIGN KEY (BEAR_ID) REFERENCES BEAR(BEAR_ID);


ALTER TABLE BEAR_BEEHIVE
ADD CONSTRAINT FK_BEAR_BEEHIVE_BEEHIVE
FOREIGN KEY (BEEHIVE_ID) REFERENCES BEEHIVE(BEEHIVE_ID);

ALTER TABLE BEAR
ADD CONSTRAINT CK_BEAR_WEIGHT_POSITIVE CHECK (BEAR_WEIGHT > 0);

ALTER TABLE BEEHIVE
ADD CONSTRAINT CK_BEEHIVE_WEIGHT_POSITIVE CHECK (BEEHIVE_WEIGHT > 0);


--ADD UNIQUE CONSTRAINT ON CAVE NAME, BEAR TYPE NAME

ALTER TABLE CAVE
ADD CONSTRAINT UQ_CAVE_NAME UNIQUE (CAVE_NAME);

ALTER TABLE BEAR_TYPE
ADD CONSTRAINT UQ_TYPE_NAME UNIQUE (BEAR_TYPE_NAME);

INSERT INTO BEAR_TYPE VALUES (1, 'KODIAK');
INSERT INTO BEAR_TYPE VALUES (2, 'BLACK');
INSERT INTO BEAR_TYPE VALUES (3, 'TEDDY');

INSERT INTO BEAR VALUES (1,2,'CEDRIC','20-FEB-2019',DEFAULT,NULL);

SELECT * FROM BEAR;

DROP TABLE BEAR;
DROP TABLE BEAR_TYPE;
DROP TABLE CAVE;
DROP TABLE BEEHIVE;
DROP TABLE BEAR_BEEHIVE;
COMMIT;
--COMMENT
/*
MULTI LINE
*/