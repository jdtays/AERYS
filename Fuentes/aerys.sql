-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.35-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para aerys
CREATE DATABASE IF NOT EXISTS `aerys` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `aerys`;

-- Volcando estructura para tabla aerys.ciudad
CREATE TABLE IF NOT EXISTS `ciudad` (
  `idCiudad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`idCiudad`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.ciudad: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` (`idCiudad`, `nombre`) VALUES
	(1, 'Medellin'),
	(2, 'Rionegro'),
	(3, 'Ceja');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(10) NOT NULL AUTO_INCREMENT,
  `cedula` int(10) NOT NULL,
  `cliente` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `correo` int(11) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `cliente` (`cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.cliente: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idCliente`, `cedula`, `cliente`, `telefono`, `correo`, `contrasena`) VALUES
	(1, 1036, 'Jose', '6151160', 0, '156jose');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.cosmetologa
CREATE TABLE IF NOT EXISTS `cosmetologa` (
  `idCosmetologa` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` int(10) NOT NULL,
  `cosmetologa` varchar(50) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `servicioC` varchar(50) NOT NULL,
  PRIMARY KEY (`idCosmetologa`),
  KEY `cosmetologa` (`cosmetologa`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.cosmetologa: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `cosmetologa` DISABLE KEYS */;
INSERT INTO `cosmetologa` (`idCosmetologa`, `cedula`, `cosmetologa`, `telefono`, `correo`, `contrasena`, `servicioC`) VALUES
	(1, 10369, 'maria', '5947263', 'maria@gmail.com', '189dsfd', '');
/*!40000 ALTER TABLE `cosmetologa` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `idEstado` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(50) NOT NULL,
  PRIMARY KEY (`idEstado`),
  KEY `estado` (`estado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.estado: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` (`idEstado`, `estado`) VALUES
	(2, 'Aceptado'),
	(4, 'Cancelado'),
	(6, 'En Camino'),
	(5, 'En Ejecucion'),
	(1, 'Por Confirmar'),
	(3, 'Rechazado');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.sector
CREATE TABLE IF NOT EXISTS `sector` (
  `idSector` int(11) NOT NULL AUTO_INCREMENT,
  `sector` varchar(50) NOT NULL,
  PRIMARY KEY (`idSector`),
  KEY `sector` (`sector`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.sector: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` (`idSector`, `sector`) VALUES
	(1, 'Bello'),
	(2, 'Sabaneta');
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.servicio
CREATE TABLE IF NOT EXISTS `servicio` (
  `idServicio` int(11) NOT NULL AUTO_INCREMENT,
  `servicio` varchar(50) NOT NULL,
  `caracteristicas` varchar(500) NOT NULL,
  PRIMARY KEY (`idServicio`),
  KEY `servicio` (`servicio`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.servicio: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` (`idServicio`, `servicio`, `caracteristicas`) VALUES
	(6, 'Masaje', 'Relajante'),
	(7, 'Masaje, Limpieza', 'Relajante, Facial'),
	(8, 'Masaje, Limpieza, Depilacion', 'Relajante, Facial, Cera'),
	(9, 'Limpieza', 'Facial'),
	(10, 'Limpieza, Depilacion', 'Facial, Cera'),
	(11, 'Depilacion', 'Cera');
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.solicitud
CREATE TABLE IF NOT EXISTS `solicitud` (
  `idSolicitud` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` varchar(50) NOT NULL,
  `cosmetologa` varchar(50) NOT NULL,
  `servicio` varchar(50) NOT NULL,
  `sector` varchar(50) NOT NULL,
  `duracion` time NOT NULL DEFAULT '00:00:00',
  `fecha` date NOT NULL,
  `estado` varchar(50) NOT NULL,
  PRIMARY KEY (`idSolicitud`),
  KEY `estado` (`estado`),
  KEY `FK_solicitude_sector` (`sector`),
  KEY `FK_solicitude_servicio` (`servicio`),
  KEY `FK_solicitude_cliente` (`cliente`),
  KEY `FK_solicitude_cosmetologa` (`cosmetologa`),
  CONSTRAINT `FK_solicitude_cliente` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`cliente`),
  CONSTRAINT `FK_solicitude_cosmetologa` FOREIGN KEY (`cosmetologa`) REFERENCES `cosmetologa` (`cosmetologa`),
  CONSTRAINT `FK_solicitude_estado` FOREIGN KEY (`estado`) REFERENCES `estado` (`estado`),
  CONSTRAINT `FK_solicitude_sector` FOREIGN KEY (`sector`) REFERENCES `sector` (`sector`),
  CONSTRAINT `FK_solicitude_servicio` FOREIGN KEY (`servicio`) REFERENCES `servicioc` (`servicioC`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.solicitud: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` (`idSolicitud`, `cliente`, `cosmetologa`, `servicio`, `sector`, `duracion`, `fecha`, `estado`) VALUES
	(2, 'Jose', 'maria', 'Masaje', 'Sabaneta', '01:30:00', '2018-09-16', 'Por Confirmar');
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
