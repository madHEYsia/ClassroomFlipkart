-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: classroomflipkart
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `cartdetails`
--

DROP TABLE IF EXISTS `cartdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartdetails` (
  `cartId` varchar(100) NOT NULL,
  `productId` varchar(45) NOT NULL,
  `quantity` varchar(100) NOT NULL DEFAULT '1',
  PRIMARY KEY (`cartId`,`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartdetails`
--

LOCK TABLES `cartdetails` WRITE;
/*!40000 ALTER TABLE `cartdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `cartdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category` varchar(100) NOT NULL,
  `subcategory` varchar(100) NOT NULL,
  PRIMARY KEY (`category`,`subcategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('APPLIANCES','Air Conditioners'),('APPLIANCES','Kitchen Appliances'),('APPLIANCES','Refrigerators'),('APPLIANCES','Smart Home Appliances'),('APPLIANCES','Televisions'),('APPLIANCES','Washing Machine'),('BABY & KIDS','Baby Care'),('BABY & KIDS','Boy\'s Clothing'),('BABY & KIDS','Boy\'s Foot Wear'),('BABY & KIDS','Girl\'s Clothing'),('BABY & KIDS','Girl\'s Foot Wear'),('BABY & KIDS','Toys'),('BOOKS & MORE','Books'),('BOOKS & MORE','Car & Bike Accessories'),('BOOKS & MORE','Car Electronics & Applications'),('BOOKS & MORE','Exercise & Fitness'),('BOOKS & MORE','Gaming & Accessories'),('BOOKS & MORE','Music'),('BOOKS & MORE','Sports'),('BOOKS & MORE','Stationery'),('ELECTRONICS','Desktop PCs'),('ELECTRONICS','Home Entertainement'),('ELECTRONICS','Laptops'),('ELECTRONICS','Mobile'),('ELECTRONICS','Mobile Accessories'),('ELECTRONICS','Smart Wearables Tech'),('FURNITURE','Dining & Serving'),('FURNITURE','Furnishing'),('FURNITURE','furniture'),('FURNITURE','Kitchen & Dining'),('FURNITURE','Kitchen Storage'),('FURNITURE','Lightning'),('MEN','Accessories'),('MEN','Bottom Wear'),('MEN','Footwear'),('MEN','Men\'s Grooming'),('MEN','Sports Wear'),('MEN','Top Wear'),('MEN','Watches'),('WOMEN','Accessories'),('WOMEN','Beauty & Grooming'),('WOMEN','Ethnic Wear'),('WOMEN','Foot Wear'),('WOMEN','Jewellery'),('WOMEN','Sports Wear'),('WOMEN','Western Wear');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currentuser`
--

DROP TABLE IF EXISTS `currentuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currentuser` (
  `id` varchar(100) NOT NULL,
  `emailId` varchar(100) NOT NULL,
  `name` varchar(400) NOT NULL,
  PRIMARY KEY (`id`,`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currentuser`
--

LOCK TABLES `currentuser` WRITE;
/*!40000 ALTER TABLE `currentuser` DISABLE KEYS */;
INSERT INTO `currentuser` VALUES ('.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Shubham');
/*!40000 ALTER TABLE `currentuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productcoment`
--

DROP TABLE IF EXISTS `productcoment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productcoment` (
  `timestamp` varchar(45) NOT NULL,
  `productId` varchar(10) NOT NULL,
  `emailId` varchar(45) NOT NULL,
  `productComent` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`timestamp`,`productId`,`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcoment`
--

LOCK TABLES `productcoment` WRITE;
/*!40000 ALTER TABLE `productcoment` DISABLE KEYS */;
/*!40000 ALTER TABLE `productcoment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productdetail`
--

DROP TABLE IF EXISTS `productdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productdetail` (
  `productId` varchar(10) NOT NULL,
  `productName` varchar(200) DEFAULT NULL,
  `newPrice` varchar(10) DEFAULT NULL,
  `oldPrice` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdetail`
--

LOCK TABLES `productdetail` WRITE;
/*!40000 ALTER TABLE `productdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `productdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productseller`
--

DROP TABLE IF EXISTS `productseller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productseller` (
  `productId` varchar(10) NOT NULL,
  `sellerId` varchar(10) NOT NULL,
  PRIMARY KEY (`productId`,`sellerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productseller`
--

LOCK TABLES `productseller` WRITE;
/*!40000 ALTER TABLE `productseller` DISABLE KEYS */;
/*!40000 ALTER TABLE `productseller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sellerdetails`
--

DROP TABLE IF EXISTS `sellerdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sellerdetails` (
  `sellerId` varchar(10) NOT NULL,
  `sellerName` varchar(100) DEFAULT NULL,
  `sellerDescription` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`sellerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sellerdetails`
--

LOCK TABLES `sellerdetails` WRITE;
/*!40000 ALTER TABLE `sellerdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `sellerdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sellerpincodes`
--

DROP TABLE IF EXISTS `sellerpincodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sellerpincodes` (
  `sellerId` varchar(10) NOT NULL,
  `pincode` varchar(6) NOT NULL,
  PRIMARY KEY (`sellerId`,`pincode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sellerpincodes`
--

LOCK TABLES `sellerpincodes` WRITE;
/*!40000 ALTER TABLE `sellerpincodes` DISABLE KEYS */;
/*!40000 ALTER TABLE `sellerpincodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraddress`
--

DROP TABLE IF EXISTS `useraddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraddress` (
  `userId` int(11) NOT NULL,
  `userAddress` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`,`userAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraddress`
--

LOCK TABLES `useraddress` WRITE;
/*!40000 ALTER TABLE `useraddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `useraddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercart`
--

DROP TABLE IF EXISTS `usercart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usercart` (
  `emailId` varchar(100) NOT NULL,
  `cartId` varchar(100) NOT NULL,
  PRIMARY KEY (`emailId`,`cartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercart`
--

LOCK TABLES `usercart` WRITE;
/*!40000 ALTER TABLE `usercart` DISABLE KEYS */;
/*!40000 ALTER TABLE `usercart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetail`
--

DROP TABLE IF EXISTS `userdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userdetail` (
  `emailId` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetail`
--

LOCK TABLES `userdetail` WRITE;
/*!40000 ALTER TABLE `userdetail` DISABLE KEYS */;
INSERT INTO `userdetail` VALUES ('submiitr07@gmail.com','Shubham','iitr');
/*!40000 ALTER TABLE `userdetail` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-08 17:08:11
