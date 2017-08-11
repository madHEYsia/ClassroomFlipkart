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
  `emailId` varchar(100) NOT NULL,
  `productId` varchar(45) NOT NULL,
  `quantity` varchar(100) NOT NULL DEFAULT '1',
  PRIMARY KEY (`emailId`,`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartdetails`
--

LOCK TABLES `cartdetails` WRITE;
/*!40000 ALTER TABLE `cartdetails` DISABLE KEYS */;
INSERT INTO `cartdetails` VALUES ('','4','1');
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
  `minPrice` varchar(10) NOT NULL,
  `maxPrice` varchar(10) NOT NULL,
  PRIMARY KEY (`category`,`subcategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES ('APPLIANCES','Air Conditioners','100','1200'),('APPLIANCES','Kitchen Appliances','100','1200'),('APPLIANCES','Refrigerators','100','1200'),('APPLIANCES','Smart Home Appliances','100','1200'),('APPLIANCES','Televisions','100','1200'),('APPLIANCES','Washing Machine','100','1200'),('BABY & KIDS','Baby Care','100','1200'),('BABY & KIDS','Boy`s Clothing','100','1200'),('BABY & KIDS','Boy`s Foot Wear','100','1200'),('BABY & KIDS','Girl`s Clothing','100','1200'),('BABY & KIDS','Girl`s Foot Wear','100','1200'),('BABY & KIDS','Toys','100','1200'),('BOOKS & MORE','Books','100','1200'),('BOOKS & MORE','Car & Bike Accessories','100','1200'),('BOOKS & MORE','Car Electronics & Applications','100','1200'),('BOOKS & MORE','Exercise & Fitness','100','1200'),('BOOKS & MORE','Gaming & Accessories','100','1200'),('BOOKS & MORE','Music','100','1200'),('BOOKS & MORE','Sports','100','1200'),('BOOKS & MORE','Stationery','100','1200'),('ELECTRONICS','Desktop PCs','100','1200'),('ELECTRONICS','Home Entertainement','100','1200'),('ELECTRONICS','Laptops','100','1200'),('ELECTRONICS','Mobile','100','1200'),('ELECTRONICS','Mobile Accessories','100','1200'),('ELECTRONICS','Smart Wearables Tech','100','1200'),('FURNITURE','Furnishing','100','1200'),('FURNITURE','furniture','100','1200'),('FURNITURE','Kitchen & Dining','100','1200'),('FURNITURE','Kitchen Storage','100','1200'),('FURNITURE','Lightning','100','1200'),('FURNITURE','Wall Decals & Stickers','100','1200'),('MEN','Accessories','100','1200'),('MEN','Bottom Wear','100','1200'),('MEN','Footwear','100','1200'),('MEN','Men\'s Grooming','100','1200'),('MEN','Sports Wear','100','1200'),('MEN','Top Wear','100','1200'),('MEN','Watches','100','1200'),('WOMEN','Accessories','100','1200'),('WOMEN','Beauty & Grooming','100','1200'),('WOMEN','Ethnic Wear','100','1200'),('WOMEN','Foot Wear','100','1200'),('WOMEN','Jewellery','100','1200'),('WOMEN','Sports Wear','100','1200'),('WOMEN','Western Wear','100','1200');
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
INSERT INTO `currentuser` VALUES ('.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Shubham Madheysia');
/*!40000 ALTER TABLE `currentuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homeproducts`
--

DROP TABLE IF EXISTS `homeproducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `homeproducts` (
  `type` varchar(100) NOT NULL,
  `productId` varchar(100) NOT NULL,
  PRIMARY KEY (`type`,`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homeproducts`
--

LOCK TABLES `homeproducts` WRITE;
/*!40000 ALTER TABLE `homeproducts` DISABLE KEYS */;
INSERT INTO `homeproducts` VALUES ('Discounts for You','1'),('Discounts for You','2'),('Discounts for You','3'),('Discounts for You','4'),('Discounts for You','5'),('Featured Product','1'),('Featured Product','2'),('Featured Product','3'),('Featured Product','4'),('Featured Product','5'),('New Arrival','1'),('New Arrival','2'),('New Arrival','3'),('New Arrival','4'),('New Arrival','5'),('Trending','1'),('Trending','2'),('Trending','3'),('Trending','4'),('Trending','5');
/*!40000 ALTER TABLE `homeproducts` ENABLE KEYS */;
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
  `productComent` varchar(2000) NOT NULL,
  `productRating` varchar(10) NOT NULL,
  PRIMARY KEY (`timestamp`,`productId`,`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productcoment`
--

LOCK TABLES `productcoment` WRITE;
/*!40000 ALTER TABLE `productcoment` DISABLE KEYS */;
INSERT INTO `productcoment` VALUES ('2017.07.27.19.55.28','1','submiitr07@gmail.com','Simply awesome','5'),('2017.07.28.11.55.28','1','ravi@gmail.com','Terrific purchase','5'),('2017.07.28.13.55.28','1','hkbansal@gmail.com','Good','4'),('2017.07.29.4.55.28','1','vkthakur@gmail.com','Four Stars','4'),('2017.08.2.4.55.28','1','ravi@gmail.com','Mind Blowing purchase','4'),('2017.08.4.4.55.28','1','paras@gmail.com','Worth every penny','5'),('2017.08.5.4.55.28','1','submiitr07@gmail.com','Good product again from the Flipkart shopping','4'),('2017.08.7.4.55.28','1','hkbansal@gmail.com','Great product','5'),('2017.08.9.4.55.28','1','vkthakur@gmail.com','Highly recommended','3');
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
  `productName` varchar(200) NOT NULL,
  `newPrice` varchar(10) NOT NULL,
  `oldPrice` varchar(10) NOT NULL,
  `category` varchar(100) NOT NULL,
  `subcategory` varchar(100) NOT NULL,
  `imageName` varchar(100) NOT NULL,
  `productAvailability` varchar(20) NOT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productdetail`
--

LOCK TABLES `productdetail` WRITE;
/*!40000 ALTER TABLE `productdetail` DISABLE KEYS */;
INSERT INTO `productdetail` VALUES ('1','Aquire Large PVC Vinyl Sticker  (Pack of 1)','139','650','FURNITURE','Wall Decals & Stickers','AC2.jpg','AVAILABLE'),('10','Aquire Large PVC Vinyl Sticker  (Pack of 2)','400','650','FURNITURE','Wall Decals & Stickers','AC2.jpg','AVAILABLE'),('2','Aquire Large PVC Vinyl Sticker  (Pack of 3)','500','650','FURNITURE','Wall Decals & Stickers','AC2.jpg','AVAILABLE'),('3','Aquire Large PVC Vinyl Sticker  (Pack of 4)','236','650','FURNITURE','Wall Decals & Stickers','AC2.jpg','NOT AVAILABLE'),('4','Aquire Large PVC Vinyl Sticker  (Pack of 5)','563','650','FURNITURE','Wall Decals & Stickers','AC2.jpg','ON SALE'),('5','Aquire Large PVC Vinyl Sticker  (Pack of 1)','115','650','FURNITURE','Wall Decals & Stickers','AC2.jpg','AVAILABLE'),('6','Aquire Large PVC Vinyl Sticker  (Pack of 2)','545','650','FURNITURE','Wall Decals & Stickers','AC2.jpg','AVAILABLE'),('7','Aquire Large PVC Vinyl Sticker  (Pack of 3)','646','650','FURNITURE','Wall Decals & Stickers','AC2.jpg','AVAILABLE'),('8','Aquire Large PVC Vinyl Sticker  (Pack of 3)','131','650','FURNITURE','Wall Decals & Stickers','AC2.jpg','NOT AVAILABLE'),('9','Aquire Large PVC Vinyl Sticker  (Pack of 3)','496','650','FURNITURE','Wall Decals & Stickers','AC2.jpg','ON SALE');
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
INSERT INTO `productseller` VALUES ('1','1'),('2','1'),('3','1'),('4','1'),('5','1');
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
INSERT INTO `sellerdetails` VALUES ('1','Aquire Large PVC Vinyl Sticker  (Pack of 1)','Welcome to Aquire, place on the web to find artistic designs of wall decals and wall stickers. Stick in your Living room and bedroom to designer look to your bedroom. Wall Stickers/Decals are the latest trend, sweeping the world of interior design. A quick and easy way to personalize and transform your home with attractive wall decors. They are extremely durable and are available in various designs. These are very easy to apply and remove. You can apply these by yourself. PVC vinyl compatible, ideal for Family Lounge, Bedroom, Café, Restaurant, Kids Room, Nursery Room etc. Features PVC, Non-toxic, Eco-friendly and Waterproof. 1) The surface you wish to attach your decal must be clean and free from dust, grease or any other contamination. 2) Simply peel those pre-cut pieces of wall stickers off from the backing paper and apply them to the desired area. Refer to the finished design shown in between the sheet and follow the numbers mentioned on the pieces to form the desired pattern. Freshly painted or lacquered surfaces must be allowed to completely cure for minimum 30 days before the decal is applied. 3) After pasting the wall stickers on your wall, press firmly along the border and remove air bubbles if any.');
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
  `deliveryDays` varchar(10) NOT NULL,
  `deliveryCharges` varchar(10) NOT NULL,
  PRIMARY KEY (`sellerId`,`pincode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sellerpincodes`
--

LOCK TABLES `sellerpincodes` WRITE;
/*!40000 ALTER TABLE `sellerpincodes` DISABLE KEYS */;
INSERT INTO `sellerpincodes` VALUES ('1','273000','9-12','FREE'),('1','273001','4-6','₹ 50 '),('1','273002','3-5','FREE'),('1','273003','4-8','₹ 50 '),('1','273004','7-8','₹ 50 '),('1','273005','5-6','FREE'),('1','273006','10-11','FREE');
/*!40000 ALTER TABLE `sellerpincodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraddress`
--

DROP TABLE IF EXISTS `useraddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `useraddress` (
  `emailId` varchar(100) NOT NULL,
  `userAddress` varchar(500) NOT NULL,
  `isDefault` varchar(10) NOT NULL,
  PRIMARY KEY (`emailId`,`userAddress`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraddress`
--

LOCK TABLES `useraddress` WRITE;
/*!40000 ALTER TABLE `useraddress` DISABLE KEYS */;
INSERT INTO `useraddress` VALUES ('submiitr07@gmail.com','49, Awas Vikas Colony, Roorkee, Uttrakhnad','false'),('submiitr07@gmail.com','A319, Jawahar Bhawan, IIT Roorkee-247667, Roorkee, Uttrakhand','true'),('submiitr07@gmail.com','A538, Rajiv Bhawan, IIT Roorkee, Roorkee, Uttrakhand','false'),('submiitr07@gmail.com','A635, Rajiv Bhawan, IIT Roorkee, Roorkee, Uttrakhnad','false');
/*!40000 ALTER TABLE `useraddress` ENABLE KEYS */;
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
  `certifiedUser` varchar(20) NOT NULL,
  PRIMARY KEY (`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetail`
--

LOCK TABLES `userdetail` WRITE;
/*!40000 ALTER TABLE `userdetail` DISABLE KEYS */;
INSERT INTO `userdetail` VALUES ('hkbansal@gmail.com','Harsh Bansal','iitr','yes'),('paras@gmail.com','Paras Jindal','iitr','no'),('ravi@gmail.com','Ravi Sharma','iitr','no'),('submiitr07@gmail.com','Shubham Madheysia','iitr','yes'),('vkthakur@gmail.com','Vikrant Thakur','iitr','yes');
/*!40000 ALTER TABLE `userdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userorders`
--

DROP TABLE IF EXISTS `userorders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userorders` (
  `timestamp` varchar(45) NOT NULL,
  `emailId` varchar(100) NOT NULL,
  `productId` varchar(10) NOT NULL,
  `quantity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`emailId`,`productId`,`timestamp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userorders`
--

LOCK TABLES `userorders` WRITE;
/*!40000 ALTER TABLE `userorders` DISABLE KEYS */;
INSERT INTO `userorders` VALUES ('2017.08.11.20.59.04','submiitr07@gmail.com','1','5'),('2017.08.11.21.09.06','submiitr07@gmail.com','2','1'),('2017.08.11.20.59.04','submiitr07@gmail.com','3','1'),('2017.08.11.21.04.29','submiitr07@gmail.com','3','1'),('2017.08.11.21.09.06','submiitr07@gmail.com','3','1'),('2017.08.11.20.59.04','submiitr07@gmail.com','4','1'),('2017.08.11.21.04.29','submiitr07@gmail.com','4','1'),('2017.08.11.21.09.06','submiitr07@gmail.com','4','1'),('2017.08.11.21.01.41','submiitr07@gmail.com','5','1');
/*!40000 ALTER TABLE `userorders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-11 21:15:30
