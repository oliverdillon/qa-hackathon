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
  `CustomerID` INT NOT NULL,
  `Phone Number` VARCHAR(255) NULL,
  `Email Address` VARCHAR(255) NULL,
  `Name` VARCHAR(255) NULL,
  PRIMARY KEY (`CustomerID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ims`.`Item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ims`.`Item` (
  `ItemID` INT NOT NULL,
  `Name` VARCHAR(255) NULL,
  `Price` DECIMAL(2) NULL,
  PRIMARY KEY (`ItemID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ims`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ims`.`Order` (
  `orderID` INT NOT NULL,
  `CustomerID` INT NULL,
  `TotalPrice` INT NULL,
  PRIMARY KEY (`orderID`),
  INDEX `customerID_idx` (`CustomerID` ASC) VISIBLE,
  CONSTRAINT `fk_customerID`
    FOREIGN KEY (`CustomerID`)
    REFERENCES `ims`.`Customer` (`CustomerID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ims`.`OrdersItems`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ims`.`OrdersItems` (
  `ordersItemsID` INT NOT NULL,
  `orderID` INT NULL,
  `itemID` INT NULL,
  PRIMARY KEY (`ordersItemsID`),
  INDEX `orderID_idx` (`orderID` ASC) VISIBLE,
  INDEX `itemID_idx` (`itemID` ASC) VISIBLE,
  CONSTRAINT `fk_orderID`
    FOREIGN KEY (`orderID`)
    REFERENCES `ims`.`Order` (`orderID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itemID`
    FOREIGN KEY (`itemID`)
    REFERENCES `ims`.`Item` (`ItemID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
