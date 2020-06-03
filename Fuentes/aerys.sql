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
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idCiudad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.ciudad: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` (`idCiudad`, `nombre`, `descripcion`) VALUES
	(1, 'Medellin', 'Antioquia');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` char(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `idGenero` int(11) NOT NULL,
  `idTipoDeDocumento` int(11) NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `idGenero` (`idGenero`),
  KEY `idTipoDeDocumento` (`idTipoDeDocumento`),
  KEY `contrasena` (`contrasena`),
  KEY `correo` (`correo`),
  KEY `nombre` (`nombre`),
  CONSTRAINT `FK_cliente_genero` FOREIGN KEY (`idGenero`) REFERENCES `genero` (`idGenero`),
  CONSTRAINT `FK_cliente_tipodedocumento` FOREIGN KEY (`idTipoDeDocumento`) REFERENCES `tipodedocumento` (`idTipoDeDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.cliente: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`idCliente`, `cedula`, `nombre`, `apellido`, `telefono`, `correo`, `contrasena`, `idGenero`, `idTipoDeDocumento`) VALUES
	(1, '1036952167', 'Jose Roberto', 'Lima Da silva', '3206502045', 'josedasilva.trabajo@gmail.com', '123', 2, 2),
	(3, '244655', 'Leonardino', 'Lima', '3177296823', 'leonardino.lima@gmail.com', 'leo123', 1, 1),
	(10, '196516', 'Manuela', 'Perez', '1243125321', 'mariana.lima@gmail.com', '789', 2, 2),
	(11, '789f', 'ana maria ', 'ramirez ramirez', '48951', 'ana@gmail.com', '123', 2, 2),
	(12, '196516', 'rodrigo', 'patino', '52841', 'rodrigo@gmail.com', '789', 1, 2);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.cosmetologa
CREATE TABLE IF NOT EXISTS `cosmetologa` (
  `idCosmetologa` int(11) NOT NULL AUTO_INCREMENT,
  `cedula` char(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `idTipoDeDocumento` int(11) NOT NULL,
  `idGenero` int(11) NOT NULL,
  `fotoCosmetologa` blob,
  PRIMARY KEY (`idCosmetologa`),
  KEY `idGenero` (`idGenero`),
  KEY `idTipoDeDocumento` (`idTipoDeDocumento`),
  KEY `nombre` (`nombre`),
  CONSTRAINT `FK_cosmetologa_genero` FOREIGN KEY (`idGenero`) REFERENCES `genero` (`idGenero`),
  CONSTRAINT `FK_cosmetologa_tipodedocumento` FOREIGN KEY (`idTipoDeDocumento`) REFERENCES `tipodedocumento` (`idTipoDeDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.cosmetologa: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cosmetologa` DISABLE KEYS */;
INSERT INTO `cosmetologa` (`idCosmetologa`, `cedula`, `nombre`, `apellido`, `telefono`, `correo`, `contrasena`, `idTipoDeDocumento`, `idGenero`, `fotoCosmetologa`) VALUES
	(1, '9875424', 'marian', 'lima', 36434, 'mariana.lima@gmail.com', '789', 1, 2, NULL),
	(2, '196516', 'Manuela', 'Perez', 1243125321, 'mariana.lima@gmail.com', '789', 2, 2, NULL),
	(3, '1865', 'manuela', 'ramirez', 1243125321, 'ana@gmail.com', '789', 2, 2, NULL);
/*!40000 ALTER TABLE `cosmetologa` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.duracionyprecioportratamiento
CREATE TABLE IF NOT EXISTS `duracionyprecioportratamiento` (
  `idDuracionYprecioPorTratamiento` int(11) NOT NULL AUTO_INCREMENT,
  `duracion` varchar(50) NOT NULL,
  `multiplicador` int(11) NOT NULL,
  PRIMARY KEY (`idDuracionYprecioPorTratamiento`),
  KEY `precio` (`multiplicador`),
  KEY `duracion` (`duracion`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.duracionyprecioportratamiento: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `duracionyprecioportratamiento` DISABLE KEYS */;
INSERT INTO `duracionyprecioportratamiento` (`idDuracionYprecioPorTratamiento`, `duracion`, `multiplicador`) VALUES
	(7, '30 Minutos', 1),
	(8, '60 Minutos', 2),
	(9, '120 Minutos', 3);
/*!40000 ALTER TABLE `duracionyprecioportratamiento` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `idEstado` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idEstado`),
  KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.estado: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` (`idEstado`, `nombre`, `descripcion`) VALUES
	(1, 'Por confirmar', 'sin aceptar o rechazar por las cosmetologas');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.genero
CREATE TABLE IF NOT EXISTS `genero` (
  `idGenero` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idGenero`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.genero: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` (`idGenero`, `nombre`, `descripcion`) VALUES
	(1, 'Masculino', 'Hombre'),
	(2, 'Femenino', 'Mujer');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.sector
CREATE TABLE IF NOT EXISTS `sector` (
  `idSector` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idSector`),
  KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.sector: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `sector` DISABLE KEYS */;
INSERT INTO `sector` (`idSector`, `nombre`, `descripcion`) VALUES
	(1, 'Rionegro', 'Antioquia');
/*!40000 ALTER TABLE `sector` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.servicio
CREATE TABLE IF NOT EXISTS `servicio` (
  `idServicio` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(500) NOT NULL,
  `precio` int(11) NOT NULL,
  `fotoServicio` blob,
  PRIMARY KEY (`idServicio`),
  KEY `nombre` (`nombre`),
  KEY `precio` (`precio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.servicio: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` (`idServicio`, `nombre`, `descripcion`, `precio`, `fotoServicio`) VALUES
	(1, 'Masaje', 'Adiós a ese nudo en el cuello, al dolor de espalda, a la tensión muscular. Libérate en una hora de todos esos torturantes dolores musculares con este masaje a domicilio.', 100000, NULL),
	(2, 'Limpieza facial', 'Extraemos tus puntos negros, puntos blancos, comedones y póstulas, sumado a una mascarilla facial acorde a tu tipo de piel devolvemos la luminosidad y vitalidad a la piel de tu rostro.', 200000, NULL),
	(3, 'Depilacion', 'La depilación con cera a la larga sigue siendo el método más rápido y efectivo para terminar de una vez con ese vello corporal tan molesto.', 50000, NULL);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.servicioporcosmetologa
CREATE TABLE IF NOT EXISTS `servicioporcosmetologa` (
  `idServicioPorCosmetologa` int(11) NOT NULL AUTO_INCREMENT,
  `idServicio` varchar(50) NOT NULL,
  `idCosmetologa` varchar(50) NOT NULL,
  PRIMARY KEY (`idServicioPorCosmetologa`),
  KEY `idServicio` (`idServicio`),
  KEY `idCosmetologa` (`idCosmetologa`),
  CONSTRAINT `FK_servicioporcosmetologa_cosmetologa` FOREIGN KEY (`idCosmetologa`) REFERENCES `cosmetologa` (`nombre`),
  CONSTRAINT `FK_servicioporcosmetologa_servico` FOREIGN KEY (`idServicio`) REFERENCES `servicio` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.servicioporcosmetologa: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `servicioporcosmetologa` DISABLE KEYS */;
INSERT INTO `servicioporcosmetologa` (`idServicioPorCosmetologa`, `idServicio`, `idCosmetologa`) VALUES
	(4, 'Masaje', 'marian'),
	(5, 'Limpieza facial', 'marian'),
	(6, 'Depilacion', 'marian');
/*!40000 ALTER TABLE `servicioporcosmetologa` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.solicitud
CREATE TABLE IF NOT EXISTS `solicitud` (
  `idSolicitud` int(11) NOT NULL AUTO_INCREMENT,
  `duracion` varchar(50) NOT NULL,
  `fecha` varchar(50) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `AnombreDe` varchar(45) NOT NULL,
  `idCliente` varchar(50) NOT NULL,
  `idCosmetologa` varchar(50) NOT NULL,
  `idEstado` varchar(50) NOT NULL,
  `idSector` varchar(50) NOT NULL,
  `idServicio` varchar(50) NOT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`idSolicitud`),
  KEY `idCliente` (`idCliente`),
  KEY `idCosmetologa` (`idCosmetologa`),
  KEY `idEstado` (`idEstado`),
  KEY `idSector` (`idSector`),
  KEY `idServicio` (`idServicio`),
  KEY `precio` (`precio`),
  CONSTRAINT `FK_solicitud_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`nombre`),
  CONSTRAINT `FK_solicitud_cosmetologa` FOREIGN KEY (`idCosmetologa`) REFERENCES `cosmetologa` (`nombre`),
  CONSTRAINT `FK_solicitud_estado` FOREIGN KEY (`idEstado`) REFERENCES `estado` (`nombre`),
  CONSTRAINT `FK_solicitud_sector` FOREIGN KEY (`idSector`) REFERENCES `sector` (`nombre`),
  CONSTRAINT `FK_solicitud_servico` FOREIGN KEY (`idServicio`) REFERENCES `servicio` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.solicitud: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;

-- Volcando estructura para tabla aerys.tipodedocumento
CREATE TABLE IF NOT EXISTS `tipodedocumento` (
  `idTipoDeDocumento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idTipoDeDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla aerys.tipodedocumento: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `tipodedocumento` DISABLE KEYS */;
INSERT INTO `tipodedocumento` (`idTipoDeDocumento`, `nombre`, `descripcion`) VALUES
	(1, 'Documento', 'Identidad'),
	(2, 'Cedula', 'ciudadania');
/*!40000 ALTER TABLE `tipodedocumento` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
ciudadciudad