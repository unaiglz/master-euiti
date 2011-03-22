-- phpMyAdmin SQL Dump
-- version 3.3.2deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 17-03-2011 a las 13:03:06
-- Versión del servidor: 5.1.41
-- Versión de PHP: 5.3.2-1ubuntu4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `masterdb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Bezeroa`
--

CREATE TABLE IF NOT EXISTS `Bezeroa` (
  `NAN` varchar(9) NOT NULL,
  `izena` varchar(30) NOT NULL,
  `jaiotzeData` date NOT NULL,
  `helbidea` varchar(50) NOT NULL,
  PRIMARY KEY (`NAN`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `Bezeroa`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `DataTaOrdua`
--

CREATE TABLE IF NOT EXISTS `DataTaOrdua` (
  `dataOrdua` datetime NOT NULL,
  PRIMARY KEY (`dataOrdua`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `DataTaOrdua`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Erabiltzailea`
--

CREATE TABLE IF NOT EXISTS `Erabiltzailea` (
  `NAN` varchar(9) NOT NULL,
  `izena` varchar(50) NOT NULL,
  `pasahitza` varchar(250) NOT NULL,
  `helbidea` varchar(30) NOT NULL,
  `rol` varchar(30) NOT NULL,
  `aktiboa` tinyint(1) NOT NULL,
  PRIMARY KEY (`NAN`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `Erabiltzailea`
--

INSERT INTO `Erabiltzailea` (`NAN`, `izena`, `pasahitza`, `helbidea`, `rol`, `aktiboa`) VALUES
('12341819P', 'junito', '4409eae53c2e26a65cfc24b3a2359eb9', 'La calle del canton', 'Idazkaria', 1),
('1234182A', 'yaya', '6dddeb8b2cabf04d795767f2a140c1e9', 'La calle del sobron', 'Terapeuta', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Formakuntza`
--

CREATE TABLE IF NOT EXISTS `Formakuntza` (
  `erabiltzaileID` int(9) NOT NULL,
  `terapiaMotaID` int(11) NOT NULL,
  PRIMARY KEY (`erabiltzaileID`,`terapiaMotaID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `Formakuntza`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Hitzordua`
--

CREATE TABLE IF NOT EXISTS `Hitzordua` (
  `dataOrdua` datetime NOT NULL,
  `terapeutaID` int(9) NOT NULL,
  `bezeroID` int(9) NOT NULL,
  `terapiaMotaID` int(11) NOT NULL,
  `terapeutarenOharra` varchar(250) DEFAULT NULL,
  `kobratuta` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`dataOrdua`,`bezeroID`),
  KEY `terapeutaID` (`terapeutaID`),
  KEY `bezeroID` (`bezeroID`),
  KEY `terapiaMotaID` (`terapiaMotaID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcar la base de datos para la tabla `Hitzordua`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `TerapiaMota`
--

CREATE TABLE IF NOT EXISTS `TerapiaMota` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Izena` varchar(30) NOT NULL,
  `Iraupena` int(11) NOT NULL,
  `Prezioa` float NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcar la base de datos para la tabla `TerapiaMota`
--

INSERT INTO `TerapiaMota` (`ID`, `Izena`, `Iraupena`, `Prezioa`) VALUES
(1, 'Thai Dantza', 1, 1.5),
(2, 'Hello', 1, 1.78),
(3, 'Minn', 2, 1.4),
(4, 'kilo dance', 2, 150.4);
