-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ims
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ims
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ims` DEFAULT CHARACTER SET utf8 ;
USE `ims` ;

-- -----------------------------------------------------
-- Table `ims`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ims`.`Customer` (
  `CustomerID` INT NULL AUTO_INCREMENT,
  `Phone Number` VARCHAR(255) NULL,
  `Email Address` VARCHAR(255) NULL,
  `Name` VARCHAR(255) NULL,
  PRIMARY KEY (`CustomerID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ims`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ims`.`Item` (
  `ItemID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(255) NOT NULL,
  `Price` DECIMAL(2) NOT NULL,
  PRIMARY KEY (`ItemID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ims`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ims`.`Order` (
  `orderID` INT NOT NULL AUTO_INCREMENT,
  `orderItemsID` INT NULL,
  `CustomerID` INT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `customerID_idx` (`CustomerID` ASC) VISIBLE,
  CONSTRAINT `orderItemsID`
    FOREIGN KEY (`orderID`)
    REFERENCES `ims`.`Order` (`orderItemsID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `customerID`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `ims`.`Customer` (`CustomerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ims`.`OrdersItems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ims`.`OrdersItems` (
  `ordersItemsID` INT NOT NULL AUTO_INCREMENT,
  `orderID` INT NULL,
  `itemID` INT NULL,
  PRIMARY KEY (`ordersItemsID`),
  INDEX `orderID_idx` (`orderID` ASC) VISIBLE,
  INDEX `itemID_idx` (`itemID` ASC) VISIBLE,
  CONSTRAINT `orderID`
    FOREIGN KEY (`orderID`)
    REFERENCES `ims`.`Order` (`orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `itemID`
    FOREIGN KEY (`itemID`)
    REFERENCES `ims`.`Item` (`ItemID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
