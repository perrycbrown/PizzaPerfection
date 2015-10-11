-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: pizzaperfection
-- ------------------------------------------------------
-- Server version	5.6.16

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
-- Table structure for table `pizza_addons`
--

DROP TABLE IF EXISTS `pizza_addons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_addons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `label` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`type`),
  CONSTRAINT `typeid` FOREIGN KEY (`type`) REFERENCES `pizza_addons_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_addons`
--

LOCK TABLES `pizza_addons` WRITE;
/*!40000 ALTER TABLE `pizza_addons` DISABLE KEYS */;
INSERT INTO `pizza_addons` VALUES (1,1,1.00,'small Coke'),(2,1,2.00,'medium Coke'),(3,1,2.50,'large Coke'),(4,1,3.00,'x-large Coke'),(5,2,4.00,'Garlic Bread'),(6,2,5.00,'Garlic Cheese Bread'),(7,3,5.00,'Chocolate Dessert Pizza'),(8,3,5.00,'Cinnamon Dessert Pizza');
/*!40000 ALTER TABLE `pizza_addons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_addons_type`
--

DROP TABLE IF EXISTS `pizza_addons_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_addons_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_label` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_addons_type`
--

LOCK TABLES `pizza_addons_type` WRITE;
/*!40000 ALTER TABLE `pizza_addons_type` DISABLE KEYS */;
INSERT INTO `pizza_addons_type` VALUES (1,'Drinks'),(2,'Breads'),(3,'Desserts');
/*!40000 ALTER TABLE `pizza_addons_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_elements`
--

DROP TABLE IF EXISTS `pizza_elements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_elements` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(11) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `label` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`type`),
  CONSTRAINT `type` FOREIGN KEY (`type`) REFERENCES `pizza_elements_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_elements`
--

LOCK TABLES `pizza_elements` WRITE;
/*!40000 ALTER TABLE `pizza_elements` DISABLE KEYS */;
INSERT INTO `pizza_elements` VALUES (1,1,1.00,'regular crust'),(2,1,2.00,'thick crust'),(3,2,1.00,'regular sauce'),(4,2,2.00,'extra sauce'),(5,3,1.00,'regular cheese'),(6,3,2.00,'extra cheese'),(7,4,1.00,'pepperoni'),(8,4,1.00,'sausage'),(9,4,1.00,'mushrooms'),(10,5,5.00,'small pepperoni'),(11,5,7.50,'medium pepperoni'),(12,5,10.00,'large pepperoni'),(13,5,12.50,'x-large pepperoni'),(14,5,5.00,'small sausage'),(15,5,7.50,'medium sausage'),(16,5,10.00,'large sausage'),(17,5,12.50,'x-large sausage');
/*!40000 ALTER TABLE `pizza_elements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_elements_type`
--

DROP TABLE IF EXISTS `pizza_elements_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_elements_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_label` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_elements_type`
--

LOCK TABLES `pizza_elements_type` WRITE;
/*!40000 ALTER TABLE `pizza_elements_type` DISABLE KEYS */;
INSERT INTO `pizza_elements_type` VALUES (1,'crust'),(2,'sauce'),(3,'cheese'),(4,'topping'),(5,'complete');
/*!40000 ALTER TABLE `pizza_elements_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizza_sizes`
--

DROP TABLE IF EXISTS `pizza_sizes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizza_sizes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `label` varchar(100) DEFAULT NULL,
  `multiplier` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizza_sizes`
--

LOCK TABLES `pizza_sizes` WRITE;
/*!40000 ALTER TABLE `pizza_sizes` DISABLE KEYS */;
INSERT INTO `pizza_sizes` VALUES (1,'small',1.00),(2,'medium',1.50),(3,'large',2.00),(4,'x-large',2.50);
/*!40000 ALTER TABLE `pizza_sizes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-10-11 13:36:35
