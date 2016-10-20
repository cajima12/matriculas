-- MySQL Script generated by MySQL Workbench
-- 02/27/15 14:26:22
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema correo
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `correo` ;

-- -----------------------------------------------------
-- Schema correo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `correo` DEFAULT CHARACTER SET latin1 ;
USE `correo` ;

-- -----------------------------------------------------
-- Table `correo`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`roles` ;

CREATE TABLE IF NOT EXISTS `correo`.`roles` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(120) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `correo`.`departamentos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`departamentos` ;

CREATE TABLE IF NOT EXISTS `correo`.`departamentos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(120) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `correo`.`unidades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`unidades` ;

CREATE TABLE IF NOT EXISTS `correo`.`unidades` (
  `id` VARCHAR(3) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `codigo` VARCHAR(45) NOT NULL,
  `departamentos_id` INT NOT NULL,
  PRIMARY KEY (`id`, `departamentos_id`),
  CONSTRAINT `fk_unidades_departamentos1`
    FOREIGN KEY (`departamentos_id`)
    REFERENCES `correo`.`departamentos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_unidades_departamentos1_idx` ON `correo`.`unidades` (`departamentos_id` ASC);


-- -----------------------------------------------------
-- Table `correo`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `correo`.`usuarios` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(80) NOT NULL,
  `password` VARCHAR(120) NOT NULL,
  `nombre` VARCHAR(120) NULL DEFAULT NULL,
  `apellidos` VARCHAR(180) NULL DEFAULT NULL,
  `fecha_creacion` DATETIME NOT NULL,
  `siglas` VARCHAR(10) NOT NULL,
  `telefono` VARCHAR(9) NULL,
  `pd` TINYINT(1) NULL DEFAULT 0,
  `jefatura` VARCHAR(120) NULL,
  `firma` TINYINT(1) NULL DEFAULT 0,
  `unidades_id` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`id`, `unidades_id`),
  CONSTRAINT `fk_usuarios_unidades1`
    FOREIGN KEY (`unidades_id`)
    REFERENCES `correo`.`unidades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_usuarios_unidades1_idx` ON `correo`.`usuarios` (`unidades_id` ASC);


-- -----------------------------------------------------
-- Table `correo`.`usuarios_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`usuarios_roles` ;

CREATE TABLE IF NOT EXISTS `correo`.`usuarios_roles` (
  `usuarios_id` BIGINT(20) NOT NULL,
  `roles_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`usuarios_id`, `roles_id`),
  CONSTRAINT `fk_usuarios_has_roles_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `correo`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_has_roles_usuarios`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `correo`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_usuarios_has_roles_roles1_idx` ON `correo`.`usuarios_roles` (`roles_id` ASC);

CREATE INDEX `fk_usuarios_has_roles_usuarios_idx` ON `correo`.`usuarios_roles` (`usuarios_id` ASC);


-- -----------------------------------------------------
-- Table `correo`.`documentos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`documentos` ;

CREATE TABLE IF NOT EXISTS `correo`.`documentos` (
  `id` VARCHAR(10) NOT NULL,
  `documento` VARCHAR(45) NOT NULL,
  `bop` TINYINT(1) NULL DEFAULT 0,
  `descripcion` VARCHAR(240) NULL,
  `recurso` LONGTEXT NULL,
  `cab` LONGTEXT NULL,
  `pie` LONGTEXT NULL,
  `text-cab` LONGTEXT NULL,
  `text-pie` LONGTEXT NULL,
  `text-cue` LONGTEXT NULL,
  `firma` TINYINT(1) NULL,
  `registro` TINYINT(1) NULL,
  `tipo_firma` VARCHAR(45) NULL,
  `csv` TINYINT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `correo`.`tipos_incidencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`tipos_incidencia` ;

CREATE TABLE IF NOT EXISTS `correo`.`tipos_incidencia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(255) NOT NULL,
  `tipo` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `correo`.`remesas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`remesas` ;

CREATE TABLE IF NOT EXISTS `correo`.`remesas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `num_remesa` VARCHAR(45) NOT NULL,
  `enviado` DATETIME NOT NULL,
  `bloqueo` TINYINT(1) NULL DEFAULT 0,
  `p1` VARCHAR(45) NULL,
  `p2` VARCHAR(45) NULL,
  `fecha_devolucion` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `correo`.`tipo_via`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`tipo_via` ;

CREATE TABLE IF NOT EXISTS `correo`.`tipo_via` (
  `id` VARCHAR(3) NOT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `nombre_corto` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `correo`.`provincias`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`provincias` ;

CREATE TABLE IF NOT EXISTS `correo`.`provincias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `correo`.`localidades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`localidades` ;

CREATE TABLE IF NOT EXISTS `correo`.`localidades` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(80) NOT NULL,
  `provincias_id` INT NOT NULL,
  PRIMARY KEY (`id`, `provincias_id`),
  CONSTRAINT `fk_poblaciones_provincias1`
    FOREIGN KEY (`provincias_id`)
    REFERENCES `correo`.`provincias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_poblaciones_provincias1_idx` ON `correo`.`localidades` (`provincias_id` ASC);


-- -----------------------------------------------------
-- Table `correo`.`diario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`diario` ;

CREATE TABLE IF NOT EXISTS `correo`.`diario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ano` VARCHAR(5) NOT NULL,
  `cbar` VARCHAR(45) NOT NULL,
  `cbarpf` VARCHAR(45) NULL,
  `cbarrec` VARCHAR(45) NULL,
  `expediente` VARCHAR(45) NULL,
  `referencia` VARCHAR(45) NOT NULL,
  `nif` VARCHAR(15) NULL DEFAULT '*** ***',
  `contribuyente` VARCHAR(255) NOT NULL,
  `domicilio` VARCHAR(255) NOT NULL,
  `cod_postal` VARCHAR(5) NOT NULL,
  `fecha_grabacion` DATETIME NOT NULL,
  `fecha_envio` DATETIME NOT NULL,
  `fecha_recepcion` DATETIME NULL,
  `pdfs` LONGTEXT NULL,
  `observaciones` LONGTEXT NOT NULL,
  `text_com_1` LONGTEXT NULL,
  `text_com_2` LONGTEXT NULL,
  `text_com_3` LONGTEXT NULL,
  `cabecera_1` LONGTEXT NULL,
  `cabecera_2` LONGTEXT NULL,
  `cabecera_3` LONGTEXT NULL,
  `pie_reposicion` LONGTEXT NULL,
  `pie_devolucion` LONGTEXT NULL,
  `pie_rectificacion` LONGTEXT NULL,
  `pie_nulidad` LONGTEXT NULL,
  `pie_revocacion` LONGTEXT NULL,
  `c1` INT NULL,
  `c2` INT NULL,
  `p1` INT NULL,
  `p2` INT NULL,
  `p3` INT NULL,
  `p4` INT NULL,
  `p5` INT NULL,
  `firma` TINYINT(1) NULL,
  `pd` TINYINT(1) NULL,
  `titulo` LONGTEXT NULL,
  `sello` TINYINT(1) NULL,
  `remesas_id` INT NOT NULL,
  `usuarios_id` BIGINT(20) NOT NULL,
  `documentos_id` VARCHAR(10) NOT NULL,
  `tipos_incidencia_id` INT NOT NULL,
  `tipo_via_id` VARCHAR(3) NOT NULL,
  `provincias_id` INT NOT NULL,
  `localidades_id` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`id`, `remesas_id`, `usuarios_id`, `documentos_id`, `tipos_incidencia_id`, `tipo_via_id`, `provincias_id`, `localidades_id`),
  CONSTRAINT `fk_diario_remesas1`
    FOREIGN KEY (`remesas_id`)
    REFERENCES `correo`.`remesas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_diario_usuarios1`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `correo`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_diario_documentos1`
    FOREIGN KEY (`documentos_id`)
    REFERENCES `correo`.`documentos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_diario_tipos_incidencia1`
    FOREIGN KEY (`tipos_incidencia_id`)
    REFERENCES `correo`.`tipos_incidencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_diario_tipo_via1`
    FOREIGN KEY (`tipo_via_id`)
    REFERENCES `correo`.`tipo_via` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_diario_provincias1`
    FOREIGN KEY (`provincias_id`)
    REFERENCES `correo`.`provincias` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_diario_localidades1`
    FOREIGN KEY (`localidades_id`)
    REFERENCES `correo`.`localidades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_diario_remesas1_idx` ON `correo`.`diario` (`remesas_id` ASC);

CREATE INDEX `fk_diario_usuarios1_idx` ON `correo`.`diario` (`usuarios_id` ASC);

CREATE INDEX `fk_diario_documentos1_idx` ON `correo`.`diario` (`documentos_id` ASC);

CREATE INDEX `fk_diario_tipos_incidencia1_idx` ON `correo`.`diario` (`tipos_incidencia_id` ASC);

CREATE INDEX `fk_diario_tipo_via1_idx` ON `correo`.`diario` (`tipo_via_id` ASC);

CREATE INDEX `fk_diario_provincias1_idx` ON `correo`.`diario` (`provincias_id` ASC);

CREATE INDEX `fk_diario_localidades1_idx` ON `correo`.`diario` (`localidades_id` ASC);


-- -----------------------------------------------------
-- Table `correo`.`bop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`bop` ;

CREATE TABLE IF NOT EXISTS `correo`.`bop` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `referencia` VARCHAR(45) NOT NULL,
  `expediente` VARCHAR(45) NOT NULL,
  `fecha_envio` DATETIME NOT NULL,
  `relacion_contribuyente` VARCHAR(45) NOT NULL,
  `num_bop` VARCHAR(45) NULL,
  `fecha_publicacion` DATETIME NULL,
  `fecha_grabacion` DATETIME NULL,
  `contribuyente` VARCHAR(255) NULL,
  `nif_contribuyente` VARCHAR(15) NULL,
  `documentos_id` VARCHAR(10) NOT NULL,
  `usuarios_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`, `documentos_id`, `usuarios_id`),
  CONSTRAINT `fk_bop_documentos1`
    FOREIGN KEY (`documentos_id`)
    REFERENCES `correo`.`documentos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bop_usuarios1`
    FOREIGN KEY (`usuarios_id`)
    REFERENCES `correo`.`usuarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_bop_documentos1_idx` ON `correo`.`bop` (`documentos_id` ASC);

CREATE INDEX `fk_bop_usuarios1_idx` ON `correo`.`bop` (`usuarios_id` ASC);


-- -----------------------------------------------------
-- Table `correo`.`documentos_has_unidades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`documentos_has_unidades` ;

CREATE TABLE IF NOT EXISTS `correo`.`documentos_has_unidades` (
  `documentos_id` VARCHAR(10) NOT NULL,
  `unidades_id` VARCHAR(3) NOT NULL,
  PRIMARY KEY (`documentos_id`, `unidades_id`),
  CONSTRAINT `fk_documentos_has_unidades_documentos1`
    FOREIGN KEY (`documentos_id`)
    REFERENCES `correo`.`documentos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_documentos_has_unidades_unidades1`
    FOREIGN KEY (`unidades_id`)
    REFERENCES `correo`.`unidades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_documentos_has_unidades_unidades1_idx` ON `correo`.`documentos_has_unidades` (`unidades_id` ASC);

CREATE INDEX `fk_documentos_has_unidades_documentos1_idx` ON `correo`.`documentos_has_unidades` (`documentos_id` ASC);


-- -----------------------------------------------------
-- Table `correo`.`devoluciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `correo`.`devoluciones` ;

CREATE TABLE IF NOT EXISTS `correo`.`devoluciones` (
  `codigo_barras` VARCHAR(23) NOT NULL,
  `observaciones` LONGTEXT NOT NULL,
  `fecha_notificada` DATETIME NULL,
  `fecha_entrada` DATETIME NULL,
  `fecha_devuelta` DATETIME NULL,
  `tipos_incidencia_id` INT NOT NULL,
  PRIMARY KEY (`codigo_barras`, `tipos_incidencia_id`),
  CONSTRAINT `fk_devoluciones_tipos_incidencia1`
    FOREIGN KEY (`tipos_incidencia_id`)
    REFERENCES `correo`.`tipos_incidencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_devoluciones_tipos_incidencia1_idx` ON `correo`.`devoluciones` (`tipos_incidencia_id` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
