-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.16-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para ventas
CREATE DATABASE IF NOT EXISTS `ventas` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `ventas`;

-- Volcando estructura para tabla ventas.vendedor
CREATE TABLE IF NOT EXISTS `vendedor` (
  `idVendedor` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` char(3) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `salarioBase` int(11) NOT NULL,
  `porComision` double NOT NULL,
  `fechaIngreso` date NOT NULL,
  `activo` tinyint(4) NOT NULL,
  PRIMARY KEY (`idVendedor`),
  KEY `codigo` (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla ventas.vendedor: ~13 rows (aproximadamente)
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
REPLACE INTO `vendedor` (`idVendedor`, `codigo`, `nombre`, `salarioBase`, `porComision`, `fechaIngreso`, `activo`) VALUES
	(13, 'N04', 'Pablo Rodriguez Garcia', 325000, 3.5, '1989-07-17', 1),
	(14, 'S01', 'Natali Marquez Mojica', 250000, 2.7, '2001-11-01', 1),
	(15, 'C02', 'Felix Manuel Polanco Arias', 325000, 2.8, '2010-02-21', 1),
	(16, 'N01', 'Juan David Quintero Osorio', 192000, 2.7, '2007-05-15', 1),
	(17, 'O06', 'Brenda Elizabeth Linares', 250000, 3.07, '1988-04-28', 1),
	(18, 'E02', 'David Omar Tejeda Perez', 192000, 1.8, '1999-08-13', 0),
	(19, 'O09', 'Maria Alexandra Cabrera Fortuna', 325000, 3.6, '2011-01-31', 1),
	(20, 'S05', 'Adriana Jimenez Hernandez', 192000, 3.4, '1994-07-10', 1),
	(21, 'N02', 'Laura Cristina Gomez Zapata', 250000, 4.1, '2008-11-26', 1),
	(24, 'S12', 'Porfirio Álvarez', 250000, 3.45, '2016-01-01', 1);
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;

-- Volcando estructura para tabla ventas.ventas
CREATE TABLE IF NOT EXISTS `ventas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vendedor` char(3) COLLATE utf8_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  `valorVenta` int(11) NOT NULL,
  `observacion` varchar(200) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Índice 2` (`vendedor`),
  CONSTRAINT `codVendedor` FOREIGN KEY (`vendedor`) REFERENCES `vendedor` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla ventas.ventas: ~59 rows (aproximadamente)
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
REPLACE INTO `ventas` (`id`, `vendedor`, `fecha`, `valorVenta`, `observacion`) VALUES
	(13, 'N01', '2015-05-03', 9233000, ''),
	(14, 'S01', '2015-05-22', 7447000, ''),
	(15, 'O06', '2015-05-03', 65400, ''),
	(16, 'N02', '2015-05-26', 8875000, ''),
	(17, 'N01', '2015-05-21', 7687000, ''),
	(18, 'S01', '2015-05-22', 6259000, ''),
	(19, 'N01', '2015-05-08', 5425000, ''),
	(20, 'O09', '2015-05-09', 8033000, ''),
	(21, 'O06', '2015-05-03', 5033000, ''),
	(22, 'C02', '2015-05-11', 8032000, ''),
	(23, 'N04', '2015-05-17', 3056000, ''),
	(24, 'O06', '2015-05-17', 9962000, ''),
	(25, 'N01', '2015-05-28', 834000, ''),
	(26, 'C02', '2015-05-19', 1975000, ''),
	(27, 'C02', '2015-05-08', 8520000, ''),
	(28, 'S05', '2015-05-19', 6504000, ''),
	(29, 'N01', '2015-05-25', 9886000, ''),
	(30, 'O06', '2015-05-17', 2493000, ''),
	(31, 'O09', '2015-05-03', 2999000, ''),
	(32, 'S01', '2015-05-18', 9981000, ''),
	(33, 'N02', '2015-05-17', 1719000, ''),
	(34, 'E02', '2015-05-29', 5731000, ''),
	(35, 'S01', '2015-05-11', 9102000, ''),
	(36, 'E02', '2015-05-08', 6368000, ''),
	(37, 'C02', '2015-05-10', 2253000, ''),
	(38, 'E02', '2015-05-01', 9402000, ''),
	(39, 'E02', '2015-05-28', 6445000, ''),
	(40, 'S01', '2015-05-15', 1692000, ''),
	(41, 'S05', '2015-05-10', 9415000, ''),
	(42, 'O09', '2015-05-22', 5792000, ''),
	(43, 'O09', '2015-05-14', 7277000, ''),
	(44, 'C02', '2015-05-31', 7229000, ''),
	(45, 'O09', '2015-05-16', 5782000, ''),
	(46, 'S01', '2015-05-03', 2130000, ''),
	(47, 'N04', '2015-05-01', 998000, ''),
	(48, 'O06', '2015-05-15', 7298000, ''),
	(49, 'S05', '2015-05-09', 1232000, ''),
	(50, 'N02', '2015-05-24', 727000, ''),
	(51, 'N02', '2015-05-03', 2941000, ''),
	(52, 'O09', '2015-05-25', 5818000, ''),
	(53, 'O06', '2015-05-14', 8204000, ''),
	(54, 'S01', '2015-05-03', 6723000, ''),
	(55, 'N02', '2015-05-07', 8792000, ''),
	(56, 'E02', '2015-05-26', 6666000, ''),
	(57, 'E02', '2015-05-13', 2992000, ''),
	(58, 'N04', '2015-06-01', 281000, ''),
	(59, 'S05', '2015-05-10', 4774000, ''),
	(60, 'O06', '2015-05-05', 5790000, ''),
	(61, 'N02', '2015-05-24', 5255000, ''),
	(62, 'N04', '2015-05-21', 4729000, ''),
	(63, 'N01', '2015-05-14', 6633000, ''),
	(64, 'S05', '2015-05-17', 8754000, ''),
	(65, 'S05', '2015-05-22', 2724000, ''),
	(66, 'S05', '2015-05-06', 2059000, ''),
	(67, 'N02', '2015-05-30', 1402000, ''),
	(68, 'O06', '2015-05-29', 7660000, ''),
	(69, 'N01', '2015-05-31', 6790000, ''),
	(70, 'C02', '2015-05-22', 4743000, ''),
	(71, 'O09', '2015-05-31', 7114000, '');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
