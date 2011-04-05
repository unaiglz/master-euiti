-- MySQL dump 10.13  Distrib 5.1.41, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: masterdb
-- ------------------------------------------------------
-- Server version	5.1.41-3ubuntu12.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Bezeroa`
--

DROP TABLE IF EXISTS `Bezeroa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bezeroa` (
  `NAN` varchar(9) NOT NULL,
  `izena` varchar(30) NOT NULL,
  `jaiotzeData` date NOT NULL,
  `helbidea` varchar(50) NOT NULL,
  PRIMARY KEY (`NAN`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bezeroa`
--

LOCK TABLES `Bezeroa` WRITE;
/*!40000 ALTER TABLE `Bezeroa` DISABLE KEYS */;
INSERT INTO `Bezeroa` VALUES ('12341819P','Nurino','2011-03-24','Jordankola'),('1234182A','Svolder','2011-03-01','Arenas'),('221133445','Loki','0300-02-15','Northland'),('221233445','Azrael','2011-03-11','Goitik'),('72826430N','Lander','1989-11-06','Casa de Lander'),('98911128K','J','2001-09-12','k'),('98919111K','Ñoñorra','2001-11-11','La Casilla'),('12345678A','Kloth','1111-11-11','Kokokokokokok'),('91919191A','Joaquin','1801-11-11','Koklo');
/*!40000 ALTER TABLE `Bezeroa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DataTaOrdua`
--

DROP TABLE IF EXISTS `DataTaOrdua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DataTaOrdua` (
  `dataOrdua` datetime NOT NULL,
  PRIMARY KEY (`dataOrdua`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DataTaOrdua`
--

LOCK TABLES `DataTaOrdua` WRITE;
/*!40000 ALTER TABLE `DataTaOrdua` DISABLE KEYS */;
/*!40000 ALTER TABLE `DataTaOrdua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Erabiltzailea`
--

DROP TABLE IF EXISTS `Erabiltzailea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Erabiltzailea` (
  `NAN` varchar(9) NOT NULL,
  `izena` varchar(50) NOT NULL,
  `pasahitza` varchar(250) NOT NULL,
  `helbidea` varchar(30) NOT NULL,
  `jaiotzeD` date DEFAULT NULL,
  `rol` varchar(30) NOT NULL,
  `aktiboa` tinyint(1) NOT NULL,
  PRIMARY KEY (`NAN`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Erabiltzailea`
--

LOCK TABLES `Erabiltzailea` WRITE;
/*!40000 ALTER TABLE `Erabiltzailea` DISABLE KEYS */;
INSERT INTO `Erabiltzailea` VALUES ('12341819P','junito','4409eae53c2e26a65cfc24b3a2359eb9','La calle del canton',NULL,'Idazkaria',1),('1234182A','yaya','6dddeb8b2cabf04d795767f2a140c1e9','La calle del sobrao','2010-03-11','Terapeuta',1),('12345678A','unai','6bb84a94e0f980240a50c86142b268c0','Mungia','2011-03-11','Idazkaria',1);
/*!40000 ALTER TABLE `Erabiltzailea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Formakuntza`
--

DROP TABLE IF EXISTS `Formakuntza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Formakuntza` (
  `erabiltzaileID` varchar(9) NOT NULL,
  `terapiaMotaID` varchar(11) NOT NULL,
  PRIMARY KEY (`erabiltzaileID`,`terapiaMotaID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Formakuntza`
--

LOCK TABLES `Formakuntza` WRITE;
/*!40000 ALTER TABLE `Formakuntza` DISABLE KEYS */;
INSERT INTO `Formakuntza` VALUES ('1234182A','Thai Dantza'),('12345678A','Thai Dantza');
/*!40000 ALTER TABLE `Formakuntza` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Hitzordua`
--

DROP TABLE IF EXISTS `Hitzordua`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Hitzordua` (
  `dataOrdua` datetime NOT NULL,
  `terapeutaID` varchar(9) NOT NULL,
  `bezeroID` varchar(9) NOT NULL,
  `terapiaMotaID` varchar(20) NOT NULL,
  `terapeutarenOharra` varchar(500) DEFAULT NULL,
  `kobratuta` tinyint(1) NOT NULL DEFAULT '1',
  `tratatua` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`dataOrdua`,`bezeroID`),
  KEY `terapeutaID` (`terapeutaID`),
  KEY `bezeroID` (`bezeroID`),
  KEY `terapiaMotaID` (`terapiaMotaID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Hitzordua`
--

LOCK TABLES `Hitzordua` WRITE;
/*!40000 ALTER TABLE `Hitzordua` DISABLE KEYS */;
INSERT INTO `Hitzordua` VALUES ('1111-11-11 11:11:00','1234182','12345678','0',NULL,1,0),('1111-11-11 11:11:00','1234182A','12345678A','Thai Dantza','Gauza oso politak esango nizkioke.',1,0),('1990-11-11 11:11:00','1234182A','221233445','Thai Dantza','null',1,0);
/*!40000 ALTER TABLE `Hitzordua` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TerapiaMota`
--

DROP TABLE IF EXISTS `TerapiaMota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TerapiaMota` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Izena` varchar(30) NOT NULL,
  `Iraupena` int(11) NOT NULL,
  `Prezioa` float NOT NULL,
  PRIMARY KEY (`ID`,`Izena`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TerapiaMota`
--

LOCK TABLES `TerapiaMota` WRITE;
/*!40000 ALTER TABLE `TerapiaMota` DISABLE KEYS */;
INSERT INTO `TerapiaMota` VALUES (1,'Thai Dantza',1,1.5),(2,'Hello',1,1.78),(3,'Minn',2,1.4),(4,'kilo dance',2,150.4),(5,'Kilo',2,1.9),(6,'Jklk',1,1);
/*!40000 ALTER TABLE `TerapiaMota` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-04-05 19:06:50
