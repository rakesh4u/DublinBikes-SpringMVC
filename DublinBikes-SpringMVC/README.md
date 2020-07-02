# EISAssignment
Calling API through HTTP request (GET)to get real time data -  12/07/2019,
--------------------------------------------------------------------------------------
Installed OracleDB and JAVA 7 -16/07/2019
-------------------------------------------------------------------------------------
DB Schema-STATIONS 
 CREATE TABLE "SYSTEM"."STATIONS" 
   (	"STATIONNUMBER" NUMBER(*,0) NOT NULL ENABLE, 
	"NAME" VARCHAR2(256 BYTE), 
	"LATITUDE" VARCHAR2(256 BYTE), 
	"LONGITUDE" VARCHAR2(256 BYTE), 
	"BIKESTANDS" VARCHAR2(256 BYTE), 
	"AVAILABLEBIKESTANDS" VARCHAR2(256 BYTE), 
	"AVAILABLEBIKES" VARCHAR2(256 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
  21/07/2019
 ------------------------------------------------------------------------------------------------
Changes to folder hierarchy  - 22/07/2019
--------------------------------------------------------------------------------------------------
Response from API is Parsed and based on the position the data is filetered & inserted into DB
23/07/2019
--------------------------------------------------------------------------------------------------
