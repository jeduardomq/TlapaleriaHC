-- MySQL Script generated by MySQL Workbench
-- 04/02/15 11:19:59
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema tlapaleriahc
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tlapaleriahc` ;
CREATE SCHEMA IF NOT EXISTS `tlapaleriahc` DEFAULT CHARACTER SET latin1 ;
USE `tlapaleriahc` ;

-- -----------------------------------------------------
-- Table `tlapaleriahc`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`cliente` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`cliente` (
  `cveCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `apellidos` VARCHAR(25) NOT NULL,
  `calle` VARCHAR(18) NOT NULL,
  `numero` INT(5) NOT NULL,
  `ciudad` VARCHAR(15) NOT NULL,
  `estado` VARCHAR(12) NOT NULL,
  `RFC` VARCHAR(12) NOT NULL,
  `numCelular` VARCHAR(15) NOT NULL,
  `numTelefono` VARCHAR(15) NOT NULL,
  `codigoPostal` INT(5) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`cveCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`proveedor` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`proveedor` (
  `cveProveedor` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `apellidos` VARCHAR(25) NOT NULL,
  `calle` VARCHAR(18) NOT NULL,
  `numero` INT(5) NOT NULL,
  `ciudad` VARCHAR(15) NOT NULL,
  `estado` VARCHAR(12) NOT NULL,
  `RFC` VARCHAR(12) NOT NULL,
  `numCelular` VARCHAR(15) NOT NULL,
  `numTelefono` VARCHAR(15) NOT NULL,
  `codigoPostal` INT(5) NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`cveProveedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`compra` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`compra` (
  `cveCompra` INT(11) NOT NULL AUTO_INCREMENT,
  `cveProveedor` INT(11) NOT NULL,
  `fecha` DATE NULL,
  `total` DOUBLE(6,2) NULL,
  PRIMARY KEY (`cveCompra`),
  INDEX `fk_compra_proveedor1_idx` (`cveProveedor` ASC),
  CONSTRAINT `fk_compra_proveedor1`
    FOREIGN KEY (`cveProveedor`)
    REFERENCES `tlapaleriahc`.`proveedor` (`cveProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`venta` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`venta` (
  `cveVenta` INT(11) NOT NULL,
  `cveCliente` INT(11) NOT NULL,
  `nickname` VARCHAR(12) NOT NULL,
  `fecha` DATETIME NOT NULL,
  `hora` DATETIME NOT NULL,
  `subtotal` DOUBLE(6,2) NOT NULL,
  `total` DOUBLE(6,2) NOT NULL,
  `formaPago` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`cveVenta`),
  INDEX `cveCliente` (`cveCliente` ASC),
  CONSTRAINT `venta_ibfk_1`
    FOREIGN KEY (`cveCliente`)
    REFERENCES `tlapaleriahc`.`cliente` (`cveCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`credito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`credito` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`credito` (
  `cveCredito` INT(11) NOT NULL AUTO_INCREMENT,
  `cveVenta` INT(11) NOT NULL,
  `saldo` DOUBLE(6,2) NOT NULL,
  `fecha` DATE NOT NULL,
  PRIMARY KEY (`cveCredito`),
  INDEX `cveVenta` (`cveVenta` ASC),
  CONSTRAINT `credito_ibfk_1`
    FOREIGN KEY (`cveVenta`)
    REFERENCES `tlapaleriahc`.`venta` (`cveVenta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`cuentas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`cuentas` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`cuentas` (
  `cveCuenta` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(12) NOT NULL,
  `saldo` DOUBLE(6,2) NOT NULL,
  PRIMARY KEY (`cveCuenta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`producto` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`producto` (
  `cveProducto` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(18) NOT NULL,
  `marca` VARCHAR(18) NOT NULL,
  `precio` DOUBLE(6,2) NOT NULL,
  `volMedida` VARCHAR(12) NOT NULL,
  `SKUProveedor` VARCHAR(18) NOT NULL,
  `descripcion` VARCHAR(35) NOT NULL,
  PRIMARY KEY (`cveProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`detcompras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`detcompras` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`detcompras` (
  `cveCompra` INT(11) NOT NULL,
  `cveProducto` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `precioUnitario` DECIMAL(6,2) NOT NULL,
  INDEX `cveProducto` (`cveProducto` ASC),
  INDEX `cveCompra` (`cveCompra` ASC),
  CONSTRAINT `detcompras_ibfk_1`
    FOREIGN KEY (`cveProducto`)
    REFERENCES `tlapaleriahc`.`producto` (`cveProducto`),
  CONSTRAINT `detcompras_ibfk_2`
    FOREIGN KEY (`cveCompra`)
    REFERENCES `tlapaleriahc`.`compra` (`cveCompra`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`detventas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`detventas` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`detventas` (
  `cveVenta` INT(11) NOT NULL,
  `cveProducto` INT(11) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `precio` DECIMAL(6,2) NOT NULL,
  INDEX `cveProducto` (`cveProducto` ASC),
  INDEX `cveVenta` (`cveVenta` ASC),
  CONSTRAINT `detventas_ibfk_1`
    FOREIGN KEY (`cveProducto`)
    REFERENCES `tlapaleriahc`.`producto` (`cveProducto`),
  CONSTRAINT `detventas_ibfk_2`
    FOREIGN KEY (`cveVenta`)
    REFERENCES `tlapaleriahc`.`venta` (`cveVenta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`inventario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`inventario` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`inventario` (
  `idProducto` INT(11) NOT NULL,
  `cantidad` INT(6) NOT NULL,
  `stockMinimo` INT(6) NOT NULL,
  INDEX `idProducto` (`idProducto` ASC),
  CONSTRAINT `inventario_ibfk_1`
    FOREIGN KEY (`idProducto`)
    REFERENCES `tlapaleriahc`.`producto` (`cveProducto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`pago`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`pago` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`pago` (
  `cvePago` INT(11) NOT NULL AUTO_INCREMENT,
  `cveCredito` INT(11) NOT NULL,
  `fecha` DATE NOT NULL,
  `cantidad` DOUBLE(6,2) NOT NULL,
  `tipoPago` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`cvePago`),
  INDEX `fk_pago_credito1_idx` (`cveCredito` ASC),
  CONSTRAINT `fk_pago_credito1`
    FOREIGN KEY (`cveCredito`)
    REFERENCES `tlapaleriahc`.`credito` (`cveCredito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `tlapaleriahc`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tlapaleriahc`.`usuario` ;

CREATE TABLE IF NOT EXISTS `tlapaleriahc`.`usuario` (
  `cveUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(12) NOT NULL,
  `contraseña` VARCHAR(18) NOT NULL,
  `tipo` VARCHAR(12) NOT NULL,
  `estado` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`cveUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
