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
-- Table structure for table `AgiriZbk`
--

DROP TABLE IF EXISTS `AgiriZbk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AgiriZbk` (
  `gakoa` int(11) NOT NULL,
  `zenbakia` int(11) NOT NULL,
  PRIMARY KEY (`gakoa`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AgiriZbk`
--

LOCK TABLES `AgiriZbk` WRITE;
/*!40000 ALTER TABLE `AgiriZbk` DISABLE KEYS */;
INSERT INTO `AgiriZbk` VALUES (1,20);
/*!40000 ALTER TABLE `AgiriZbk` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `Bezeroa` VALUES ('72319896V','Fernando Alonso','1981-07-29','Ferrari'),('41012781A','Jenson Button','1980-01-19','McLaren Mercedes'),('89181921C','Lewis Hamilton','1985-01-07','McLaren Mercedes'),('91218191S','Mark Webber','1976-08-27','Red Bull Racing'),('79811112A','Sebastian Vettel','1987-07-03','Red Bull Racing'),('9871232A','Felipe Massa','1981-04-25','Ferrari'),('98191811C','Michael Schumacher','1969-01-03','Mercedes GP'),('87910171M','Eric Nicolas Rosberg','1985-06-27','Mercedes GP'),('87676121M','Robert Kubica','1984-12-07','Lotus Renault GP'),('56478654Z','Nick HeidField','1977-05-01','Lotus Renault GP'),('97865432K','Vitaly Aleksandrovich Petrov','1984-09-08','Lotus Renault GP'),('98765432A','Rubens Gonçalves Barrichello,','1972-05-23','Williams'),('87654312Z','Pastor Maldonado','1985-03-09','Williams'),('87658711L','Adrian Sutil','1983-01-11','Force India'),('78676711P','Paul di Resta','1986-04-16','Force India'),('87654761K','Kamui Kobayashi','1986-09-13','Sauber-Ferrari'),('56765489C','Sergio Perez Mendoza','1990-01-26','Sauber-Ferrari'),('76876564L','Sébastien Olivier Buemi ','1988-10-31','Toro Rosso'),('76751911O','Jaime Alguersuari Escudero','1990-03-23','Toro Rosso'),('96761211S','Heikki Johannes Kovalainen','1981-10-19','Lotus'),('76598743E','Jarno Trulli','1974-07-13','Lotus'),('75645376A','Kumar Ram Narain Karthikeyan','1977-01-14','Hispania'),('98076857C','Vitantonio Liuzzi','1981-08-06','Hispania'),('91819188J','Timo Glock','1982-03-18','Marussia Virgin'),('65478767D','Jerome d\'Ambrosio','1985-12-17','Marussia Virgin'),('65745367U','Giancarlo Fisichella','1973-01-14','Ferrari (Probador)'),('98976857I','Luca Badoer','1971-01-25','Talderik Gabe'),('98676515O','Takuma Sato','1979-12-01','Japonia');
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
INSERT INTO `DataTaOrdua` VALUES ('2011-05-11 12:00:00'),('2011-11-11 12:21:00'),('2011-12-12 13:15:00'),('2012-01-12 21:12:00'),('2015-11-12 09:10:00');
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
INSERT INTO `Erabiltzailea` VALUES ('98718191A','Antonio Bragueta Suelta','647e3fe797a6a5b3dec15529a3f75592','Barakaldo','1988-01-24','terapeuta',0),('12345678B','rootTerapeuta','c4ca4238a0b923820dcc509a6f75849b','Etxetxua enparantza','1990-04-14','terapeuta',0),('12345678A','rootIdazkari','c4ca4238a0b923820dcc509a6f75849b','Etxetxua enparantza','1990-04-14','idazkaria',0),('76545367P','Francisco Calvo Peinado','647e3fe797a6a5b3dec15529a3f75592','Elorrio','1988-02-02','terapeuta',1),('18718171K','José Lúis Lamata Feliz','647e3fe797a6a5b3dec15529a3f75592','Lekeitio','1978-10-07','terapeuta',0),('34235643P','Eva Fina Segura','647e3fe797a6a5b3dec15529a3f75592','Eibar','1956-06-02','terapeuta',0),('17871812K','Pedro Trabajo Cumplido','647e3fe797a6a5b3dec15529a3f75592','Mungia','1987-07-02','terapeuta',0),('87867565A','Jesús Estan Camino','647e3fe797a6a5b3dec15529a3f75592','Amorebieta','1976-01-13','terapeuta',0),('23142878C','María Concepción Culo Bonito','647e3fe797a6a5b3dec15529a3f75592','Galdakao','1977-01-13','terapeuta',0),('76765645C','Ramona Ponte Alegre','647e3fe797a6a5b3dec15529a3f75592','Castro','1987-09-08','terapeuta',0),('56454341K','Ramona Ponte Alegre','647e3fe797a6a5b3dec15529a3f75592','Basauri','1978-10-01','terapeuta',0),('87676565A','Perfecto Ladrón Honrado','647e3fe797a6a5b3dec15529a3f75592','Llodio','1967-09-28','terapeuta',0),('90897867X','Sandalio Botín Descalzo','647e3fe797a6a5b3dec15529a3f75592','Ibarrangelu','1987-09-28','terapeuta',1);
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
  `terapiaMotaID` varchar(30) NOT NULL,
  PRIMARY KEY (`erabiltzaileID`,`terapiaMotaID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Formakuntza`
--

LOCK TABLES `Formakuntza` WRITE;
/*!40000 ALTER TABLE `Formakuntza` DISABLE KEYS */;
INSERT INTO `Formakuntza` VALUES ('17871812K','Masaje Metamorfico'),('17871812K','Reiki'),('17871812K','Yoga'),('18718171K','Aromaterapia'),('18718171K','Cromoterapia'),('18718171K','Floraterapia'),('18718171K','Musicoterapia'),('18718171K','Shiatsu'),('18718171K','Yoga'),('23142878C','Acupuntura'),('23142878C','Iridologia'),('34235643P','Cromoterapia'),('34235643P','Fitoterapia'),('34235643P','Musicoterapia'),('34235643P','Reiki'),('34235643P','Shiatsu'),('56454341K','Iridologia'),('56454341K','Quiropraxia'),('56454341K','Talasoterapia'),('76545367P','Fitoterapia'),('76545367P','Naturopatia'),('76545367P','Sofrologia\r\n'),('76545367P','Sofrologia'),('76765645C','Quiropraxia'),('76765645C','Talasoterapia'),('87676565A','Acupuntura'),('87676565A','Hidroterapia'),('87676565A','Osteopatia'),('87676565A','Tai-Chi y Chi-Kong'),('87867565A','Aromaterapia'),('87867565A','Floraterapia'),('87867565A','Masaje Metamorfico'),('87867565A','Yoga'),('90897867X','Hidroterapia'),('90897867X','Osteopatia'),('90897867X','Tai-Chi y Chi-Kong'),('98718191A','Acupuntura'),('98718191A','Aromaterapia'),('98718191A','Naturopatia');
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
  `kobratuta` tinyint(1) NOT NULL DEFAULT '0',
  `tratatua` tinyint(1) NOT NULL DEFAULT '0',
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
INSERT INTO `Hitzordua` VALUES ('2012-01-12 21:12:00','18718171K','87910171M','Cromoterapia',NULL,1,1),('2011-11-11 12:21:00','34235643P','72319896V','Sofrologia',NULL,1,1),('2011-05-11 12:00:00','34235643P','9871232A','Cromoterapia',NULL,1,1),('2015-11-12 09:10:00','98718191A','9871232A','Acupuntura',NULL,1,1),('2011-12-12 13:15:00','98718191A','87676121M','Cromoterapia',NULL,1,1);
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
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TerapiaMota`
--

LOCK TABLES `TerapiaMota` WRITE;
/*!40000 ALTER TABLE `TerapiaMota` DISABLE KEYS */;
INSERT INTO `TerapiaMota` VALUES (9,'Cinesiologia',1,50),(8,'Aromaterapia',3,150),(7,'Acupuntura',2,110.5),(1,'Cromoterapia',3,180),(2,'Fitoterapia',2,110),(3,'Floraterapia',3,125.99),(4,'Hidroterapia',2,120),(5,'Iridologia',3,200),(6,'Masaje Metamorfico',2,120),(10,'Musicoterapia',4,210.99),(11,'Naturopatia',1,40.99),(12,'Osteopatia',2,99.99),(13,'Quiropraxia',2,159.99),(14,'Reflexologia',3,109.99),(15,'Reiki',3,110.5),(16,'Shiatsu',2,150.99),(17,'Sofrologia',3,150.99),(18,'Tai-Chi y Chi-Kong',5,100),(19,'Talasoterapia',2,99.99),(20,'Yoga',3,119.99);
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

-- Dump completed on 2011-04-10 20:17:51
