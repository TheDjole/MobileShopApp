CREATE DATABASE  IF NOT EXISTS `mobile_shop` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mobile_shop`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mobile_shop
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `baterija`
--

DROP TABLE IF EXISTS `baterija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baterija` (
  `baterija_id` int(11) NOT NULL AUTO_INCREMENT,
  `vrstaBaterije` varchar(45) NOT NULL,
  PRIMARY KEY (`baterija_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baterija`
--

LOCK TABLES `baterija` WRITE;
/*!40000 ALTER TABLE `baterija` DISABLE KEYS */;
INSERT INTO `baterija` VALUES (1,'Li-Ion'),(2,'Li-Polymer'),(3,'Li-Po');
/*!40000 ALTER TABLE `baterija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boje_ekrana`
--

DROP TABLE IF EXISTS `boje_ekrana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boje_ekrana` (
  `boje_id` int(11) NOT NULL AUTO_INCREMENT,
  `vrednost` varchar(80) NOT NULL,
  PRIMARY KEY (`boje_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boje_ekrana`
--

LOCK TABLES `boje_ekrana` WRITE;
/*!40000 ALTER TABLE `boje_ekrana` DISABLE KEYS */;
INSERT INTO `boje_ekrana` VALUES (1,'(24-bit) 16.777.216'),(2,'(16-bit) 65.536 boja'),(3,'(18-bit) 262.144 boja');
/*!40000 ALTER TABLE `boje_ekrana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dualsim`
--

DROP TABLE IF EXISTS `dualsim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dualsim` (
  `sim_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`sim_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dualsim`
--

LOCK TABLES `dualsim` WRITE;
/*!40000 ALTER TABLE `dualsim` DISABLE KEYS */;
INSERT INTO `dualsim` VALUES (1,'Da'),(2,'Ne');
/*!40000 ALTER TABLE `dualsim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ekran`
--

DROP TABLE IF EXISTS `ekran`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ekran` (
  `ekran_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipEkrana` varchar(45) NOT NULL,
  PRIMARY KEY (`ekran_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ekran`
--

LOCK TABLES `ekran` WRITE;
/*!40000 ALTER TABLE `ekran` DISABLE KEYS */;
INSERT INTO `ekran` VALUES (1,'Super AMOLED'),(2,'TFT'),(3,'IPS LCD'),(4,'SIPS LCD'),(5,'AMOLED'),(6,'LCD (LED backlight)'),(7,'TIPS LCD'),(8,'True HD IPS Plus'),(9,'Super LCD3'),(10,'Super LCD2'),(11,'IPS-Neo LCD');
/*!40000 ALTER TABLE `ekran` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eksternamemorija`
--

DROP TABLE IF EXISTS `eksternamemorija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eksternamemorija` (
  `eksternamemorija_id` int(11) NOT NULL AUTO_INCREMENT,
  `mogucnost` varchar(45) NOT NULL,
  PRIMARY KEY (`eksternamemorija_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eksternamemorija`
--

LOCK TABLES `eksternamemorija` WRITE;
/*!40000 ALTER TABLE `eksternamemorija` DISABLE KEYS */;
INSERT INTO `eksternamemorija` VALUES (1,'proširiva'),(2,'nije proširiva');
/*!40000 ALTER TABLE `eksternamemorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interna_memorija`
--

DROP TABLE IF EXISTS `interna_memorija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interna_memorija` (
  `internamemorija_Id` int(11) NOT NULL AUTO_INCREMENT,
  `vrednost` varchar(45) NOT NULL,
  PRIMARY KEY (`internamemorija_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interna_memorija`
--

LOCK TABLES `interna_memorija` WRITE;
/*!40000 ALTER TABLE `interna_memorija` DISABLE KEYS */;
INSERT INTO `interna_memorija` VALUES (1,'-'),(2,'180 MB'),(3,'4096 MB'),(4,'8192 MB'),(5,'16384 MB'),(6,'32168 MB'),(7,'32768 MB'),(8,'65536 MB'),(9,'131072 MB');
/*!40000 ALTER TABLE `interna_memorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kamera`
--

DROP TABLE IF EXISTS `kamera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kamera` (
  `kamera_id` int(11) NOT NULL AUTO_INCREMENT,
  `kvalitetKamere` decimal(6,1) NOT NULL,
  `opis` varchar(45) NOT NULL,
  PRIMARY KEY (`kamera_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kamera`
--

LOCK TABLES `kamera` WRITE;
/*!40000 ALTER TABLE `kamera` DISABLE KEYS */;
INSERT INTO `kamera` VALUES (1,0.0,'Mpx'),(2,1.9,'Mpx'),(3,2.0,'Mpx'),(4,4.0,'Mpx'),(5,5.0,'Mpx'),(6,8.0,'Mpx'),(7,12.0,'Mpx'),(8,13.0,'Mpx'),(9,16.0,'Mpx'),(10,20.0,'Mpx'),(11,23.0,'Mpx'),(12,20.7,'Mpx');
/*!40000 ALTER TABLE `kamera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik` (
  `korisnik_id` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(45) NOT NULL,
  `prezime` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `adresa` varchar(100) NOT NULL,
  `grad` varchar(45) NOT NULL,
  `telefon` varchar(45) NOT NULL,
  `postanski_broj` varchar(45) NOT NULL,
  `pravo_id` int(11) NOT NULL,
  PRIMARY KEY (`korisnik_id`),
  KEY `pravo_id_idx` (`pravo_id`),
  CONSTRAINT `pravo_id` FOREIGN KEY (`pravo_id`) REFERENCES `prava` (`prava_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,'Nenad','Djordjevic','afroman','krevet','nenaddjordjevic@live.co.uk','Nicifora Ninkovica 39','Beograd','069/1990179','11000',2),(2,'Fernando','Alonso','Fernando','meklaren','fernando@live.co.uk','Milovana Ilica 77','Smederevo','0637711152','13000',2);
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `model`
--

DROP TABLE IF EXISTS `model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `model` (
  `model_id` int(11) NOT NULL AUTO_INCREMENT,
  `nazivModela` varchar(80) NOT NULL,
  `mreze_id` int(11) NOT NULL,
  `dimenzije_telefona` varchar(45) NOT NULL,
  `tezina_telefona` int(11) NOT NULL,
  `tastatura_id` int(11) NOT NULL,
  `baterija_id` int(11) NOT NULL,
  `kamera_id` int(11) NOT NULL,
  `rezolucija_kamere_id` int(11) NOT NULL,
  `ekran_id` int(11) NOT NULL,
  `velicina_ekrana_id` int(11) NOT NULL,
  `rezolucija_ekrana_id` int(11) NOT NULL,
  `brojboja_id` int(11) NOT NULL,
  `RAMmemorija_id` int(11) NOT NULL,
  `interna_memorija_id` int(11) NOT NULL,
  `eksternamemorija_id` int(11) NOT NULL,
  `operativniSistem_id` int(11) NOT NULL,
  `verzija_id` int(11) NOT NULL,
  `dualsim_id` int(11) NOT NULL,
  `referenca_slike` varchar(100) NOT NULL,
  `status_id` int(11) NOT NULL,
  `proizvodjac_id` int(11) NOT NULL,
  `cena` int(11) NOT NULL,
  PRIMARY KEY (`model_id`),
  KEY `mreze_Id_idx` (`mreze_id`),
  KEY `tastatura_id_idx` (`tastatura_id`),
  KEY `baterija_id_idx` (`baterija_id`),
  KEY `kamera_id_idx` (`kamera_id`),
  KEY `rezolucija_kamere_id_idx` (`rezolucija_kamere_id`),
  KEY `ekran_id_idx` (`ekran_id`),
  KEY `rezolucija_ekrana_id_idx` (`rezolucija_ekrana_id`),
  KEY `brojboja_id_idx` (`brojboja_id`),
  KEY `RAMmemorija_id_idx` (`RAMmemorija_id`),
  KEY `interna_memorija_id_idx` (`interna_memorija_id`),
  KEY `eksternamemorija_id_idx` (`eksternamemorija_id`),
  KEY `operativniSistem_id_idx` (`operativniSistem_id`),
  KEY `verzija_id_idx` (`verzija_id`),
  KEY `dualsim_id_idx` (`dualsim_id`),
  KEY `status_id_idx` (`status_id`),
  KEY `proizvodjac_id_idx` (`proizvodjac_id`),
  KEY `velicina_ekrana_id_idx` (`velicina_ekrana_id`),
  CONSTRAINT `RAMmemorija_id` FOREIGN KEY (`RAMmemorija_id`) REFERENCES `rammemorija` (`RAM_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `baterija_id` FOREIGN KEY (`baterija_id`) REFERENCES `baterija` (`baterija_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `brojboja_id` FOREIGN KEY (`brojboja_id`) REFERENCES `boje_ekrana` (`boje_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `dualsim_id` FOREIGN KEY (`dualsim_id`) REFERENCES `dualsim` (`sim_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ekran_id` FOREIGN KEY (`ekran_id`) REFERENCES `ekran` (`ekran_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `eksternamemorija_id` FOREIGN KEY (`eksternamemorija_id`) REFERENCES `eksternamemorija` (`eksternamemorija_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `interna_memorija_id` FOREIGN KEY (`interna_memorija_id`) REFERENCES `interna_memorija` (`internamemorija_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `kamera_id` FOREIGN KEY (`kamera_id`) REFERENCES `kamera` (`kamera_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mreze_id` FOREIGN KEY (`mreze_id`) REFERENCES `mreze` (`mreza_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `operativniSistem_id` FOREIGN KEY (`operativniSistem_id`) REFERENCES `operativnisistem` (`os_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `proizvodjac_id` FOREIGN KEY (`proizvodjac_id`) REFERENCES `proizvodjac` (`proizvodjac_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rezolucija_ekrana_id` FOREIGN KEY (`rezolucija_ekrana_id`) REFERENCES `rezolucija_ekrana` (`rezolucija_ekrana_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `rezolucija_kamere_id` FOREIGN KEY (`rezolucija_kamere_id`) REFERENCES `rezolucija_kamere` (`kameraRez_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `status_id` FOREIGN KEY (`status_id`) REFERENCES `status` (`status_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `tastatura_id` FOREIGN KEY (`tastatura_id`) REFERENCES `tastatura` (`tastatura_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `velicina_ekrana_id` FOREIGN KEY (`velicina_ekrana_id`) REFERENCES `velicina_ekrana` (`velicina_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `verzija_id` FOREIGN KEY (`verzija_id`) REFERENCES `verzija_os` (`verzija_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `model`
--

LOCK TABLES `model` WRITE;
/*!40000 ALTER TABLE `model` DISABLE KEYS */;
INSERT INTO `model` VALUES (1,'S6 Edge Plus 32GB',1,'154.4 x 75.8 x 6.9 mm',153,1,1,9,1,1,18,5,1,8,6,1,1,2,2,'galaxy-s6',1,2,60990),(2,'Galaxy A3 (2016) A310',1,'134.5 x 65.2 x 7.3 mm',132,1,1,8,2,1,13,11,1,5,5,1,1,2,2,'samsung-galaxy-a3',1,2,23780),(3,'Galaxy A5 (2016) A510 Duos',1,'144.8 x 71 x 7.3 mm',155,1,1,8,2,1,16,3,1,6,5,1,1,2,1,'samsung-galaxy-a5',1,2,31155),(4,'Note 5 32GB',2,'153.2 x 76.1 x 7.6 mm',171,1,2,9,1,1,18,5,1,8,7,1,1,2,2,'samsung-galaxy-n920',1,2,59770),(5,'E1200 Pusha',3,'108 x 45 x 13.5 mm',65,2,1,1,17,2,1,1,2,1,1,2,2,1,2,'samsung-e1200',2,2,0),(6,'Lumia 535',4,'140.2 x 72.4 x 8.8 mm',146,1,1,5,3,4,14,9,1,4,4,1,3,3,2,'microsoft-lumia-535',1,10,12198),(7,'Lumia 640 XL',4,'157.9 x 81.5 x 9 mm',171,1,1,8,2,3,18,11,1,4,4,1,3,3,2,'microsoft-lumia-640',1,10,22566),(8,'Lumia 950 XL',5,'151.9 x 78.4 x 8.1 mm',165,1,1,10,4,5,18,5,1,7,7,1,4,3,2,'microsoft-lumia-950',1,10,75627),(9,'iPhone 6s 16GB',6,'138.3 x 67.1 x 7.1 mm',143,1,2,7,5,3,13,13,1,4,5,2,5,4,2,'iphone-6s-16gb',1,6,59770),(10,'iPhone 6s 32GB',1,'138.3 x 67.1 x 7.1 mm',143,1,1,7,5,3,13,13,1,6,7,2,5,5,2,'apple-iphone-6s-32gb',1,6,62820),(11,'iPhone 4S 8GB',7,'115.2 x 58.6 x 9.3 mm',140,1,2,6,6,6,7,10,1,3,4,2,5,6,2,'apple-iphone-4s-8gb',1,6,24396),(12,'iPhone 6 128GB',6,'138.1 x 67 x 6.9 mm',129,1,2,6,6,6,13,13,1,4,9,2,5,7,2,'apple-iphone-6-1',1,6,73188),(13,'iPhone 7 128GB Jet Black',1,'138.3 x 67.1 x 7.1 mm',138,1,1,7,5,3,13,13,1,6,9,2,5,8,2,'apple-iphone-7-128gb-jet-black',1,6,82946),(14,'130',9,'106 x 45.5 x 13.9 mm',68,2,1,1,17,2,2,2,2,1,6,1,2,1,2,'mobilni_telefoni_nokia_130',1,1,3903),(15,'225 Dual SIM',9,'124 x 55.5 x 10.4 mm',101,2,1,3,7,2,4,6,3,1,7,1,2,1,1,'mobilni_telefoni_nokia_225_dual_sim',1,1,7318),(16,'Asha 502 Dual',3,'99.6 x 59.5 x 11.1 mm',100,1,1,5,8,2,5,6,3,2,7,1,6,9,2,'mobilni_telefoni_nokia_502',1,1,6099),(17,'Lumia 630 Dual SIM',4,'129.5 x 66.7 x 9.2 mm',134,1,1,5,8,7,12,8,1,3,4,1,3,3,1,'mobilni_telefoni_nokia_lumia_630_dual_sim',1,1,13417),(18,'G3 DualSim 32GB',6,'146.3 x 74.6 x 8.9 mm',149,1,1,8,9,8,17,5,1,7,7,1,1,10,1,'lg-g3-32gb-dual-sim',1,3,39033),(19,'G4',2,'148.9 x 76.1 x 9.8 mm',155,1,1,9,1,3,17,5,1,7,7,1,1,2,2,'lg-g4',1,3,40253),(20,'Nexus 4 E960 16GB',9,'133.9 x 68.7 x 9.1 mm',139,1,2,6,6,3,13,11,1,6,5,1,1,11,2,'lg-e960-16gb',1,3,31714),(21,'LG G4 Leather',11,'148.9 x 76.1 x 9.8 mm',155,1,1,9,1,3,17,5,1,7,7,1,1,2,2,'lg-g4-leather',1,3,40863),(22,'LG L70',4,'127.2 x 66.8 x 9.5 mm',124,1,1,5,8,3,12,7,1,4,3,1,1,10,2,'lg-l70',1,3,15247),(23,'U830',13,'98x49x14.8 mm',93,2,1,2,7,2,3,6,3,1,2,2,2,1,2,'lg-u830',2,3,5489),(24,'Xperia J ST26i',4,'124.3 x 61.2 x 9.2 mm',124,1,1,5,8,2,9,8,1,3,3,1,1,12,2,'sony-st26',1,4,17077),(25,'Xperia Sola MT27i',4,'116 x 59 x 9.9 mm',107,1,1,5,8,6,8,8,1,3,4,1,1,13,2,'sony-mt27',1,4,18297),(26,'Xperia Z5',5,'146 x 72 x 7.3 mm',154,1,1,11,10,3,16,3,1,7,7,1,1,2,2,'sony-xperia-z5',1,4,59770),(27,'Xperia Z3 D6603',5,'146 x 72 x 7.3 mm',152,1,1,12,11,3,16,3,1,7,5,1,1,10,2,'sony-xperia-z3',1,4,47572),(28,'Z30',2,'140.7 x 72 x 9.4 mm',170,1,1,6,6,1,14,11,1,6,5,1,7,14,2,'mobilni_telefoni_blackberry_z30',1,5,32934),(29,'Q5',2,'120 x 66 x 10.8 mm',120,3,1,5,8,3,6,12,1,6,4,1,7,15,2,'blackberry-q5',1,5,21956),(30,'Z10',14,'130 x 65.6 x 9 mm',136,1,1,6,6,2,10,14,1,6,5,1,7,15,2,'blackberry-z10',1,5,26835),(31,'Q10',4,'119.6 x 66.8 x 10.4 mm',139,3,1,6,6,1,6,12,1,6,5,1,7,15,2,'blackberry-q10',1,5,26225),(32,'One M9',5,'144.6 x 69.7 x 9.6 mm',157,1,2,12,12,9,14,3,1,7,7,1,1,16,2,'htc-one-m9',1,7,68308),(33,'Desire 816 Dual',15,'156.6 x 78.7 x 8 mm',165,1,2,8,9,9,17,11,1,5,4,1,1,10,1,'mobilni_telefoni_htc_desire_816_dual',1,7,32324),(34,'Desire 600',16,'134.8 x 67 x 9.3 mm',130,1,1,6,6,10,12,9,1,4,4,1,1,17,2,'mobilni_telefoni_htc_desire_600',1,7,31714),(35,'One M8 16GB Dual Sim',2,'146.4 x 70.6 x 9.4 mm ',160,1,2,4,13,9,14,3,1,6,5,1,1,10,1,'htc-one-m8-dual',1,7,58550),(36,'One V',4,'120.3 x 59.7 x 9.2 mm',115,1,1,5,8,2,8,7,1,3,3,1,1,12,2,'htc-one-v',1,7,17077),(37,'One mini',2,'132 x 63.2 x 9.3 mm',122,1,2,4,13,10,11,11,1,4,5,1,1,11,2,'htc-one-mini',1,7,37203),(38,'One SV',2,'128 x 66.9 x 9.2 mm',122,1,1,5,8,10,11,7,1,4,4,1,1,12,2,'htc-one-sv',1,7,24396),(39,'One Touch Idol 2 Mini OT-6016D',4,'129 x 63.5 x 7.9 mm',110,1,1,6,6,3,12,9,1,4,3,1,1,18,2,'alcatel-onetouch-idol-2-mini-1',1,8,14637),(41,'Nova',1,'141.2 x 69.1 x 7.1 mm',146,1,3,7,14,3,14,3,1,7,7,1,1,19,2,'huawei-nova',1,9,32324),(42,'P10',1,'145.3 x 69.3 x 7 mm',145,1,1,10,15,11,15,3,1,8,8,1,1,20,2,'huawei-p10',1,9,59770),(43,'P10 Lite',17,'146.5 x 72 x 7.2 mm',146,1,1,7,16,3,16,3,1,7,7,1,1,20,1,'huawei-p10-lite',1,9,33544),(44,'P9 Lite 3GB/16GB',1,'146.8 x 72.6 x 7.5 mm',147,1,1,8,16,3,16,3,1,7,5,1,1,19,2,'huawei-p9-lite-3gb-ram',1,9,28055),(45,'Ascend Y6',1,'143.5 x 72.1 x 8.5 mm',149,1,1,6,6,3,14,4,1,4,4,1,1,16,2,'huawei-y6',1,9,16467),(46,'Mate S',2,'149.8 x 75.3 x 7.2 mm',156,1,1,8,2,5,14,3,1,7,7,1,1,2,1,'huawei-mate-s-',1,9,48792);
/*!40000 ALTER TABLE `model` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mreze`
--

DROP TABLE IF EXISTS `mreze`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mreze` (
  `mreza_id` int(11) NOT NULL AUTO_INCREMENT,
  `mreze` varchar(100) NOT NULL,
  PRIMARY KEY (`mreza_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mreze`
--

LOCK TABLES `mreze` WRITE;
/*!40000 ALTER TABLE `mreze` DISABLE KEYS */;
INSERT INTO `mreze` VALUES (1,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz, 2100Mhz, HSDPA, LTE'),(2,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz, HSDPA, LTE'),(3,'900Mhz, 1800Mhz'),(4,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz, HSDPAy'),(5,'850Mhz, 900Mhz, 1900Mhz, 2100Mhz, HSDPA, LTE'),(6,'1800Mhz, 1900Mhz, 2100Mhz, HSDPA, LTE, CDMA 1900, CDMA2000 1xEV-DOe'),(7,'850Mhz, 900Mhz, 1800Mhz, HSDPA, CDMA2000 1xEV-DO'),(8,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz, HSDPA, LTE, CDMA2000 1xEV-DO'),(9,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz'),(10,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz, 2000MHz, HSDPA, LTE, CDMA 800, CDMA 1900, CDMA2000 1xEV-DO'),(11,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz, 2100Mhz, 2600Mhz, HSDPA, LTE'),(12,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz, HSDPA'),(13,'900Mhz, 1800Mhz, 1900Mhz, UMTS (W-CDMA)'),(14,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz, HSDPA, LTE, CDMA 800, CDMA 1900'),(15,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz, LTE, TD-LTE'),(16,'900Mhz, 1800Mhz, 1900Mhz, HSDPA'),(17,'850Mhz, 900Mhz, 1800Mhz, 1900Mhz, 2100Mhz');
/*!40000 ALTER TABLE `mreze` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operativnisistem`
--

DROP TABLE IF EXISTS `operativnisistem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operativnisistem` (
  `os_id` int(11) NOT NULL AUTO_INCREMENT,
  `vrsta_Operativnog_Sistema` varchar(45) NOT NULL,
  PRIMARY KEY (`os_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operativnisistem`
--

LOCK TABLES `operativnisistem` WRITE;
/*!40000 ALTER TABLE `operativnisistem` DISABLE KEYS */;
INSERT INTO `operativnisistem` VALUES (1,'Android'),(2,'fabrički'),(3,'Windows Phone'),(4,'Windows 10'),(5,'iOS'),(6,'Nokia Asha software platform'),(7,'BlackBerry OS');
/*!40000 ALTER TABLE `operativnisistem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poruzbina`
--

DROP TABLE IF EXISTS `poruzbina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poruzbina` (
  `porudzbina_id` int(11) NOT NULL AUTO_INCREMENT,
  `korisnik_id` int(11) NOT NULL,
  `statusPorudzbine` varchar(45) NOT NULL,
  `iznos` int(11) NOT NULL,
  `opisPorudzbine` varchar(45) NOT NULL,
  PRIMARY KEY (`porudzbina_id`),
  KEY `korisnik_id_idx` (`korisnik_id`),
  CONSTRAINT `korisnik_id` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`korisnik_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poruzbina`
--

LOCK TABLES `poruzbina` WRITE;
/*!40000 ALTER TABLE `poruzbina` DISABLE KEYS */;
INSERT INTO `poruzbina` VALUES (1,1,'placena',32934,''),(2,1,'placena',182360,''),(3,2,'placena',12198,''),(4,2,'placena',73188,''),(5,1,'placena',98803,''),(6,1,'placena',123199,''),(7,1,'placena',82946,'');
/*!40000 ALTER TABLE `poruzbina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prava`
--

DROP TABLE IF EXISTS `prava`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prava` (
  `prava_id` int(11) NOT NULL AUTO_INCREMENT,
  `pravo` varchar(45) NOT NULL,
  PRIMARY KEY (`prava_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prava`
--

LOCK TABLES `prava` WRITE;
/*!40000 ALTER TABLE `prava` DISABLE KEYS */;
INSERT INTO `prava` VALUES (1,'admin'),(2,'korisnik');
/*!40000 ALTER TABLE `prava` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proizvodjac`
--

DROP TABLE IF EXISTS `proizvodjac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proizvodjac` (
  `proizvodjac_id` int(11) NOT NULL AUTO_INCREMENT,
  `nazivBrenda` varchar(45) NOT NULL,
  PRIMARY KEY (`proizvodjac_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proizvodjac`
--

LOCK TABLES `proizvodjac` WRITE;
/*!40000 ALTER TABLE `proizvodjac` DISABLE KEYS */;
INSERT INTO `proizvodjac` VALUES (1,'Nokia'),(2,'Samsung'),(3,'LG'),(4,'Sony'),(5,'Blackberry'),(6,'Apple'),(7,'HTC'),(8,'Alcatel'),(9,'Huawei'),(10,'Microsoft');
/*!40000 ALTER TABLE `proizvodjac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rammemorija`
--

DROP TABLE IF EXISTS `rammemorija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rammemorija` (
  `RAM_id` int(11) NOT NULL AUTO_INCREMENT,
  `vrednost` varchar(45) NOT NULL,
  PRIMARY KEY (`RAM_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rammemorija`
--

LOCK TABLES `rammemorija` WRITE;
/*!40000 ALTER TABLE `rammemorija` DISABLE KEYS */;
INSERT INTO `rammemorija` VALUES (1,'-'),(2,'64 MB'),(3,'512 MB'),(4,'1024 MB'),(5,'1536 MB'),(6,'2048 MB'),(7,'3072 MB'),(8,'4096 MB');
/*!40000 ALTER TABLE `rammemorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezolucija_ekrana`
--

DROP TABLE IF EXISTS `rezolucija_ekrana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rezolucija_ekrana` (
  `rezolucija_ekrana_id` int(11) NOT NULL AUTO_INCREMENT,
  `rezolucija` varchar(45) NOT NULL,
  PRIMARY KEY (`rezolucija_ekrana_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezolucija_ekrana`
--

LOCK TABLES `rezolucija_ekrana` WRITE;
/*!40000 ALTER TABLE `rezolucija_ekrana` DISABLE KEYS */;
INSERT INTO `rezolucija_ekrana` VALUES (1,'128x128'),(2,'128x160'),(3,'1080x1920'),(4,'1280x720'),(5,'1440x2560'),(6,'240x320'),(7,'480x800'),(8,'480x854'),(9,'540x960'),(10,'640x960'),(11,'720x1280'),(12,'720x720'),(13,'750x1334'),(14,'768x1280');
/*!40000 ALTER TABLE `rezolucija_ekrana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rezolucija_kamere`
--

DROP TABLE IF EXISTS `rezolucija_kamere`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rezolucija_kamere` (
  `kameraRez_id` int(11) NOT NULL AUTO_INCREMENT,
  `rezolucija_kamere` varchar(80) NOT NULL,
  `opis` varchar(45) NOT NULL,
  PRIMARY KEY (`kameraRez_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rezolucija_kamere`
--

LOCK TABLES `rezolucija_kamere` WRITE;
/*!40000 ALTER TABLE `rezolucija_kamere` DISABLE KEYS */;
INSERT INTO `rezolucija_kamere` VALUES (1,'5312x2988','piksela'),(2,'4128x3096','piksela'),(3,'2592x1936','piksela'),(4,'4992x3774','piksela'),(5,'1280x720,1920x1080,3840x2160','piksela'),(6,'3264x2448','piksela'),(7,'1600x1200','piksela'),(8,'2592x1994','piksela'),(9,'4160x3120','piksela'),(10,'5520x4140','piksela'),(11,'5248x3936','piksela'),(12,'5376x3752','piksela'),(13,'2688x1520','piksela'),(14,'(2160p) 3840x2160','piksela'),(15,'(1080p) 1920x1080,(2160p) 3840x2160','piksela'),(16,'(1080p) 1920x1080','piksela'),(17,'0','piksela');
/*!40000 ALTER TABLE `rezolucija_kamere` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `status`
--

DROP TABLE IF EXISTS `status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `status` (
  `status_id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`status_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `status`
--

LOCK TABLES `status` WRITE;
/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` VALUES (1,'ima na stanju'),(2,'nema na stanju');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stavka`
--

DROP TABLE IF EXISTS `stavka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stavka` (
  `stavka_id` int(11) NOT NULL AUTO_INCREMENT,
  `porudzbina_id` int(11) NOT NULL,
  `model_id` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL,
  PRIMARY KEY (`stavka_id`),
  KEY `porudzbina_id_idx` (`porudzbina_id`),
  KEY `model_id_idx` (`model_id`),
  CONSTRAINT `model_id` FOREIGN KEY (`model_id`) REFERENCES `model` (`model_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `porudzbina_id` FOREIGN KEY (`porudzbina_id`) REFERENCES `poruzbina` (`porudzbina_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stavka`
--

LOCK TABLES `stavka` WRITE;
/*!40000 ALTER TABLE `stavka` DISABLE KEYS */;
INSERT INTO `stavka` VALUES (1,1,28,1),(2,2,9,2),(3,2,10,1),(4,3,6,1),(5,4,12,1),(6,5,42,1),(7,5,18,1),(8,6,1,1),(9,6,17,1),(10,6,46,1),(11,7,13,1);
/*!40000 ALTER TABLE `stavka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tastatura`
--

DROP TABLE IF EXISTS `tastatura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tastatura` (
  `tastatura_id` int(11) NOT NULL AUTO_INCREMENT,
  `vrstaTastature` varchar(45) NOT NULL,
  PRIMARY KEY (`tastatura_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tastatura`
--

LOCK TABLES `tastatura` WRITE;
/*!40000 ALTER TABLE `tastatura` DISABLE KEYS */;
INSERT INTO `tastatura` VALUES (1,'touch-screen'),(2,'numerička'),(3,'qwerty');
/*!40000 ALTER TABLE `tastatura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `velicina_ekrana`
--

DROP TABLE IF EXISTS `velicina_ekrana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `velicina_ekrana` (
  `velicina_id` int(11) NOT NULL AUTO_INCREMENT,
  `dijagonala` decimal(6,1) NOT NULL,
  PRIMARY KEY (`velicina_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `velicina_ekrana`
--

LOCK TABLES `velicina_ekrana` WRITE;
/*!40000 ALTER TABLE `velicina_ekrana` DISABLE KEYS */;
INSERT INTO `velicina_ekrana` VALUES (1,1.5),(2,1.8),(3,2.2),(4,2.8),(5,3.0),(6,3.1),(7,3.5),(8,3.7),(9,4.0),(10,4.2),(11,4.3),(12,4.5),(13,4.7),(14,5.0),(15,5.1),(16,5.2),(17,5.5),(18,5.7);
/*!40000 ALTER TABLE `velicina_ekrana` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verzija_os`
--

DROP TABLE IF EXISTS `verzija_os`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `verzija_os` (
  `verzija_id` int(11) NOT NULL AUTO_INCREMENT,
  `verzija` varchar(45) NOT NULL,
  PRIMARY KEY (`verzija_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verzija_os`
--

LOCK TABLES `verzija_os` WRITE;
/*!40000 ALTER TABLE `verzija_os` DISABLE KEYS */;
INSERT INTO `verzija_os` VALUES (1,'-'),(2,'v5.1'),(3,'8.1'),(4,'iOS 10.3.2'),(5,'iOS 9'),(6,'iOS 5'),(7,'iOS 8'),(8,'iOS 10'),(9,'1.1'),(10,'v4.4'),(11,'v4.2'),(12,'v4.0'),(13,'v2.3'),(14,'10.2'),(15,'10'),(16,'v5.0'),(17,'v4.1'),(18,'v4.3'),(19,'v6.0'),(20,'v7.0');
/*!40000 ALTER TABLE `verzija_os` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-30 19:12:21
