CREATE SCHEMA Admin;
CREATE TABLE `Admin`.`Admin` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Username` VARCHAR(45) NOT NULL,
  `Password` CHAR(100) NOT NULL,
  PRIMARY KEY (`ID`));
INSERT INTO `Admin`.`Admin` (`ID`, `Username`, `Password`) VALUES ('1', 'admin', '-4851-3042-2972-82-7510215-622010-2053-1231277-87-105');

CREATE TABLE `Admin`.`Contact` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  `Email` VARCHAR(100) NOT NULL,
  `Message` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`ID`));