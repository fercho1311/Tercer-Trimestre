-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Pedidos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Pedidos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Pedidos` DEFAULT CHARACTER SET utf8 ;
USE `Pedidos` ;

-- -----------------------------------------------------
-- Table `Pedidos`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pedidos`.`Cliente` (
  `Cod_Cliente` INT NOT NULL,
  `Nombre` VARCHAR(45) NULL,
  `Direccion` VARCHAR(50) NULL,
  `Telefono` VARCHAR(15) NULL,
  PRIMARY KEY (`Cod_Cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pedidos`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pedidos`.`Empleado` (
  `Cod_Empleado` INT NOT NULL,
  `Nombre` VARCHAR(30) NULL,
  `Apellidos` VARCHAR(30) NULL,
  `Sexo` VARCHAR(1) NULL,
  `Fecha_Nacimiento` DATE NULL,
  `SueldoBase` DECIMAL(8,2) NULL,
  PRIMARY KEY (`Cod_Empleado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pedidos`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pedidos`.`Producto` (
  `Cod_Producto` INT NOT NULL,
  `Descripcion` VARCHAR(45) NULL,
  `Precio` DECIMAL(8,2) NULL,
  `Existencia` INT NULL,
  PRIMARY KEY (`Cod_Producto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pedidos`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pedidos`.`Pedido` (
  `Num_Pedido` INT NOT NULL,
  `Fecha_Pedido` DATE NULL,
  `Fecha_Entrega` DATE NULL,
  `Estatus` VARCHAR(20) NULL,
  `Cliente_Cod_Cliente` INT NOT NULL,
  `Empleado_Cod_Empleado` INT NOT NULL,
  PRIMARY KEY (`Num_Pedido`),
  INDEX `fk_Pedido_Cliente_idx` (`Cliente_Cod_Cliente` ASC) VISIBLE,
  INDEX `fk_Pedido_Empleado1_idx` (`Empleado_Cod_Empleado` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pedidos`.`Detalle Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pedidos`.`Detalle Pedido` (
  `Pedido_Num_Pedido` INT NOT NULL,
  `Producto_Cod_Producto` INT NOT NULL,
  PRIMARY KEY (`Pedido_Num_Pedido`, `Producto_Cod_Producto`),
  INDEX `fk_Pedido_has_Producto_Producto1_idx` (`Producto_Cod_Producto` ASC) VISIBLE,
  INDEX `fk_Pedido_has_Producto_Pedido1_idx` (`Pedido_Num_Pedido` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
