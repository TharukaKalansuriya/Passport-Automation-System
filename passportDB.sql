CREATE DATABASE passportAutomation;
use passportAutomation;
 
CREATE TABLE admin( 
Name VARCHAR(100),
Password VARCHAR(100));

CREATE TABLE Applicants (
    ApplicantID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100),
    Address VARCHAR(200),
    Contact INT,
    email VARCHAR(100),
    gender VARCHAR(100),
    NIC INT,
    DocLink VARCHAR(400),
    DocumentVerification VARCHAR(100),
    PoliceReportVerification VARCHAR(100),
    DateReservation VARCHAR(100)
);
ALTER TABLE Applicants
ADD COLUMN admindates VARCHAR(100);

ALTER TABLE Applicants
DROP COLUMN admindates;


ALTER TABLE Applicants
ADD COLUMN available VARCHAR(100);

ALTER TABLE Applicants
ADD COLUMN DateStatus VARCHAR(100);

ALTER TABLE Applicants
DROP COLUMN DateReservation;

ALTER TABLE Applicants
DROP COLUMN gender;
select * from applicants;
USE passportAutomation;

ALTER TABLE Applicants
ADD COLUMN gender VARCHAR(100);

ALTER TABLE Applicants
ADD COLUMN userdate VARCHAR(100);

select ApplicantID,name from applicants;
INSERT INTO admin (ID, Password) VALUES ('700tk', '1234aj');
INSERT INTO admin (ID, Password) VALUES ('881tk', '4321ni');

CREATE TABLE admin( 
ID VARCHAR(100),
Password VARCHAR(100));
select * fradminom APPLICANTS;
drop table applicants;
update 