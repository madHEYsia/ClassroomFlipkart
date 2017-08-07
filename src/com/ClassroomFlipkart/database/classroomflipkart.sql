-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: classroommail
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
-- Table structure for table `chat`
--

DROP TABLE IF EXISTS `chat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chat` (
  `timestamp` varchar(50) NOT NULL,
  `sender` varchar(100) NOT NULL,
  `receiver` varchar(100) NOT NULL,
  `message` varchar(200) NOT NULL,
  PRIMARY KEY (`timestamp`,`sender`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chat`
--

LOCK TABLES `chat` WRITE;
/*!40000 ALTER TABLE `chat` DISABLE KEYS */;
INSERT INTO `chat` VALUES ('2017.07.27.19.55.28','submiitr07@gmail.com','hkbansal@gmail.com','Please check the slider.js file '),('2017.07.27.20.55.28','submiitr07@gmail.com','vkthakur@gmail.com','I made some changes yesterday. Pull latest code'),('2017.07.29.10.55.28','hkbansal@gmail.com','vkthakur@gmail.com',' @vikrant corrected it. Working fine.'),('2017.07.29.12.29.12','vkthakur@gmail.com','submiitr07@gmail.com','ok'),('2017.07.29.12.29.43','hkbansal@gmail.com','submiitr07@gmail.com','Its fun. Trying again. Afterall I made it'),('2017.07.29.12.36.33','submiitr07@gmail.com','ravi@gmail.com','fix that bug please'),('2017.07.29.21.43.53','hkbansal@gmail.com','ravi@gmail.com','Sample Tsting here also\n:)'),('2017.07.30.01.49.51','submiitr07@gmail.com','ravi@gmail.com','Even comment too'),('2017.08.04.01.56.19','submiitr07@gmail.com','hkbansal@gmail.com','Hi, testing on UI comment'),('2017.08.04.01.57.11','submiitr07@gmail.com','hkbansal@gmail.com','Testing Again and Again. Don\'t Mind'),('2017.08.04.01.57.13','submiitr07@gmail.com','hkbansal@gmail.com','Testing Again and Again. Don\'t Mind'),('2017.08.04.01.57.14','submiitr07@gmail.com','hkbansal@gmail.com','Testing Again and Again. Don\'t Mind'),('2017.08.04.01.57.16','submiitr07@gmail.com','hkbansal@gmail.com','Testing Again and Again. Don\'t Mind'),('2017.08.04.01.57.17','submiitr07@gmail.com','hkbansal@gmail.com','Testing Again and Again. Don\'t Mind'),('2017.08.04.01.57.20','submiitr07@gmail.com','hkbansal@gmail.com','Testing Again and Again. Don\'t Mind'),('2017.08.04.02.00.55','hkbansal@gmail.com','ravi@gmail.com','*Testing\nSorry sir'),('2017.08.04.02.26.51','hkbansal@gmail.com','submiitr07@gmail.com','Keep Testing. Be consistent'),('2017.08.04.02.27.16','hkbansal@gmail.com','vkthakur@gmail.com','Thanks. Will look at it and merge in master'),('2017.08.04.02.54.47','hkbansal@gmail.com','harpreet@gmail.com','Hello there !!'),('2017.08.04.15.07.25','submiitr07@gmail.com','navin@gmail.com','Hello there !!');
/*!40000 ALTER TABLE `chat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currentuser`
--

DROP TABLE IF EXISTS `currentuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currentuser` (
  `id` varchar(100) NOT NULL,
  `fullName` varchar(400) NOT NULL,
  `emailId` varchar(100) NOT NULL,
  PRIMARY KEY (`id`,`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currentuser`
--

LOCK TABLES `currentuser` WRITE;
/*!40000 ALTER TABLE `currentuser` DISABLE KEYS */;
INSERT INTO `currentuser` VALUES ('.8Q8MF32.CN762064CH1JMT.','Harsh Bansal','hkbansal@gmail.com');
/*!40000 ALTER TABLE `currentuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mails`
--

DROP TABLE IF EXISTS `mails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mails` (
  `subjectId` varchar(100) NOT NULL,
  `messageTimestamp` varchar(100) NOT NULL,
  `senderMail` varchar(100) NOT NULL,
  `receiverMail` varchar(100) NOT NULL,
  `message` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`subjectId`,`messageTimestamp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mails`
--

LOCK TABLES `mails` WRITE;
/*!40000 ALTER TABLE `mails` DISABLE KEYS */;
INSERT INTO `mails` VALUES ('2017.08.04.18.18.15.8Q8MF32.CN762064CH1JMT.','2017.08.04.18.18.15','submiitr07@gmail.com','hkbansal@gmail.com;vkthakur@gmail.com','Nice working with you.'),('2017.08.04.18.21.02.8Q8MF32.CN762064CH1JMT.','2017.08.04.18.21.02','hkbansal@gmail.com','ravi@gmail.com;submiitr07@gmail.com','Thanks dude.'),('2017.08.04.18.21.02.8Q8MF32.CN762064CH1JMT.','2017.08.04.20.23.09','submiitr07@gmail.com','hkbansal@gmail.com ; ravi@gmail.com','All the best Harsh !!'),('2017.08.04.18.21.02.8Q8MF32.CN762064CH1JMT.','2017.08.04.21.23.09','hkbansal@gmail.com','submiitr07@gmail.com',':)'),('2017.08.04.18.21.02.8Q8MF32.CN762064CH1JMT.','2017.08.05.19.12.02','hkbansal@gmail.com','submiitr07@gmail.com','Hi.\n\n-Harsh Bansal'),('2017.08.04.18.21.02.8Q8MF32.CN762064CH1JMT.','2017.08.05.19.14.45','hkbansal@gmail.com','ravi@gmail.com','Thanks'),('2017.08.04.18.21.02.8Q8MF32.CN762064CH1JMT.','2017.08.05.19.43.29','submiitr07@gmail.com','hkbansal@gmail.com','Hello. How are you ?'),('2017.08.04.18.21.02.8Q8MF32.CN762064CH1JMT.','2017.08.05.20.39.41','submiitr07@gmail.com','hkbansal@gmail.com','I am fine. Hows is DBMS course'),('2017.08.04.18.23.09.8Q8MF32.CN762064CH1JMT.','2017.08.04.18.23.09','hkbansal@gmail.com','hkbansal@gmail.com','ookkkk'),('2017.08.04.18.23.09.8Q8MF32.CN762064CH1JMT.','2017.08.06.22.24.30','hkbansal@gmail.com','submiitr07@gmail.com','Plz test'),('2017.08.05.20.46.40.8Q8MF32.CN762064CH1JMT.','2017.08.05.20.46.40','ravi@gmail.com','harpreet@gmail.com','How are you there ?'),('2017.08.05.20.46.40.8Q8MF32.CN762064CH1JMT.','2017.08.05.21.22.32','harpreet@gmail.com','submiitr07@gmail.com','Hey shubham this mail must be new to you. Isn\'t it ?'),('2017.08.05.20.46.40.8Q8MF32.CN762064CH1JMT.','2017.08.05.21.26.23','submiitr07@gmail.com','harpreet@gmail.com','yeah Bro. You did it'),('2017.08.05.20.46.40.8Q8MF32.CN762064CH1JMT.','2017.08.05.21.30.59','submiitr07@gmail.com','harpreet@gmail.com','Inox unread not working'),('2017.08.05.20.46.40.8Q8MF32.CN762064CH1JMT.','2017.08.05.21.32.13','harpreet@gmail.com','submiitr07@gmail.com','Its working. Chill'),('2017.08.05.20.46.40.8Q8MF32.CN762064CH1JMT.','2017.08.05.23.34.55','submiitr07@gmail.com','harpreet@gmail.com','you used receive this mail even if you deleted my thread. \n,,|,'),('2017.08.05.22.52.09.8Q8MF32.CN762064CH1JMT.','2017.08.05.22.52.09','submiitr07@gmail.com','navin@gmail.com','tested'),('2017.08.05.22.52.09.8Q8MF32.CN762064CH1JMT.','2017.08.05.23.05.30','navin@gmail.com','harpreet@gmail.com','It really feels good to have found the bug. SOLVED !!'),('2017.08.06.01.41.20.8Q8MF32.CN762064CH1JMT.','2017.08.06.01.41.20','submiitr07@gmail.com','submiitr07@gmail.com','here'),('2017.08.06.03.16.34.8Q8MF32.CN762064CH1JMT.','2017.08.06.03.16.34','submiitr07@gmail.com','submiitr07@gmail.com',''),('2017.08.06.03.16.34.8Q8MF32.CN762064CH1JMT.','2017.08.06.03.32.26','submiitr07@gmail.com','submiitr07@gmail.com','ok'),('2017.08.06.03.16.34.8Q8MF32.CN762064CH1JMT.','2017.08.06.03.32.49','submiitr07@gmail.com','submiitr07@gmail.com','last'),('2017.08.06.15.35.10.8Q8MF32.CN762064CH1JMT.','2017.08.06.15.35.10','hkbansal@gmail.com','submiitr07@gmail.com','Here'),('2017.08.06.22.26.18.8Q8MF32.CN762064CH1JMT.','2017.08.06.22.26.18','hkbansal@gmail.com','submiitr07@gmail.com',''),('2017.08.06.22.26.30.8Q8MF32.CN762064CH1JMT.','2017.08.06.22.26.30','hkbansal@gmail.com','submiitr07@gmail.com',''),('2017.08.06.22.26.37.8Q8MF32.CN762064CH1JMT.','2017.08.06.22.26.37','hkbansal@gmail.com','submiitr07@gmail.com',''),('2017.08.06.22.26.58.8Q8MF32.CN762064CH1JMT.','2017.08.06.22.26.58','hkbansal@gmail.com','submiitr07@gmail.com','submiitr07@gmail.com'),('2017.08.06.22.27.43.8Q8MF32.CN762064CH1JMT.','2017.08.06.22.27.43','hkbansal@gmail.com','submiitr07@gmail.com','submiitr07@gmail.com\n\nsubmiitr07@gmail.com'),('2017.08.06.22.27.50.8Q8MF32.CN762064CH1JMT.','2017.08.06.22.27.50','hkbansal@gmail.com','submiitr07@gmail.com','submiitr07@gmail.comsubmiitr07@gmail.comsubmiitr07@gmail.comsubmiitr07@gmail.com'),('2017.08.06.22.28.27.8Q8MF32.CN762064CH1JMT.','2017.08.06.22.28.27','hkbansal@gmail.com','submiitr07@gmail.com','ohh'),('2017.08.06.22.28.46.8Q8MF32.CN762064CH1JMT.','2017.08.06.22.28.46','hkbansal@gmail.com','submiitr07@gmail.com','ok');
/*!40000 ALTER TABLE `mails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjectdetails`
--

DROP TABLE IF EXISTS `subjectdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subjectdetails` (
  `subjectId` varchar(100) NOT NULL,
  `mailId` varchar(100) NOT NULL,
  `subjectName` varchar(1000) NOT NULL DEFAULT '(no subject)',
  `important` varchar(10) NOT NULL DEFAULT 'false',
  `deleted` varchar(10) NOT NULL DEFAULT 'false',
  `latestMessageRead` varchar(10) NOT NULL DEFAULT 'false',
  `isDraft` varchar(10) NOT NULL DEFAULT 'false',
  `draftMessage` varchar(2000) DEFAULT NULL,
  `draftReceipents` varchar(1000) DEFAULT NULL,
  `draftTimeStamp` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`subjectId`,`mailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjectdetails`
--

LOCK TABLES `subjectdetails` WRITE;
/*!40000 ALTER TABLE `subjectdetails` DISABLE KEYS */;
INSERT INTO `subjectdetails` VALUES ('2017.08.04.18.18.15.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','Farewell','true','false','true','false','','',NULL),('2017.08.04.18.18.15.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Farewell','true','false','true','false','','',NULL),('2017.08.04.18.18.15.8Q8MF32.CN762064CH1JMT.','vkthakur@gmail.com','Farewell','true','false','false','false','','',NULL),('2017.08.04.18.21.02.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','Thanks','false','false','true','true','','','2017.08.04.18.21.02'),('2017.08.04.18.21.02.8Q8MF32.CN762064CH1JMT.','ravi@gmail.com','Thanks','false','false','true','false','','',NULL),('2017.08.04.18.21.02.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Thanks','false','false','true','false','','',NULL),('2017.08.04.18.23.09.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','again self testing','true','false','true','false','Plz test','submiitr07@gmail.com','2017.08.05.18.12.54'),('2017.08.04.18.23.09.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Fwd: again self testing','true','false','false','false','','',NULL),('2017.08.05.18.12.54.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','(no subject)','true','false','true','true','','','2017.08.05.18.12.54'),('2017.08.05.20.46.40.8Q8MF32.CN762064CH1JMT.','harpreet@gmail.com','Hi Harpreet','true','false','true','true','','','2017.08.05.20.46.40'),('2017.08.05.20.46.40.8Q8MF32.CN762064CH1JMT.','ravi@gmail.com','Hi Harpreet','true','false','true','false','','',NULL),('2017.08.05.20.46.40.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Hi Harpreet','true','false','true','false','','',NULL),('2017.08.05.22.52.09.8Q8MF32.CN762064CH1JMT.','harpreet@gmail.com','Fwd: Navin Testing','true','false','true','false','','',NULL),('2017.08.05.22.52.09.8Q8MF32.CN762064CH1JMT.','navin@gmail.com','Navin Testing','true','false','true','false','','',NULL),('2017.08.05.22.52.09.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Navin Testing','true','false','true','false','','',NULL),('2017.08.06.01.41.20.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','this is longggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg  subject','true','false','true','false','','',NULL),('2017.08.06.03.16.34.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Self message Testing','false','false','true','false','','',NULL),('2017.08.06.15.35.10.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','Important Mail','true','false','true','false','','',NULL),('2017.08.06.15.35.10.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Important Mail','true','false','false','false','','',NULL),('2017.08.06.22.26.18.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','Testing','false','false','true','false','','',NULL),('2017.08.06.22.26.18.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Testing','false','false','false','false','','',NULL),('2017.08.06.22.26.30.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','Testing','false','false','true','false','','',NULL),('2017.08.06.22.26.30.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','Testing','false','false','false','false','','',NULL),('2017.08.06.22.26.37.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','submiitr07@gmail.com','false','false','true','false','','',NULL),('2017.08.06.22.26.37.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','submiitr07@gmail.com','false','false','false','false','','',NULL),('2017.08.06.22.26.58.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','submiitr07@gmail.com','false','false','true','false','','',NULL),('2017.08.06.22.26.58.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','submiitr07@gmail.com','false','false','false','false','','',NULL),('2017.08.06.22.27.43.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','submiitr07@gmail.com','false','false','true','false','','',NULL),('2017.08.06.22.27.43.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','submiitr07@gmail.com','false','false','false','false','','',NULL),('2017.08.06.22.27.50.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','submiitr07@gmail.com','false','false','true','false','','',NULL),('2017.08.06.22.27.50.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','submiitr07@gmail.com','false','false','false','false','','',NULL),('2017.08.06.22.28.27.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','submiitr07@gmail.com','false','false','true','false','','',NULL),('2017.08.06.22.28.27.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','submiitr07@gmail.com','false','false','false','false','','',NULL),('2017.08.06.22.28.46.8Q8MF32.CN762064CH1JMT.','hkbansal@gmail.com','submiitr07@gmail.com','false','false','true','false','','',NULL),('2017.08.06.22.28.46.8Q8MF32.CN762064CH1JMT.','submiitr07@gmail.com','submiitr07@gmail.com','false','false','false','false','','',NULL);
/*!40000 ALTER TABLE `subjectdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userdetail`
--

DROP TABLE IF EXISTS `userdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userdetail` (
  `fullName` varchar(100) NOT NULL,
  `emailId` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`emailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userdetail`
--

LOCK TABLES `userdetail` WRITE;
/*!40000 ALTER TABLE `userdetail` DISABLE KEYS */;
INSERT INTO `userdetail` VALUES ('Harpreet Singh','harpreet@gmail.com','iitr'),('Harsh Bansal','hkbansal@gmail.com','iitr'),('Mukul Gupta','mukul@gmail.com','iitr'),('Navin Gupta','navin@gmail.com','iitr'),('Nitesh Prajapati','nitesh@gmail.com','iitr'),('Ravi Sharma','ravi@gmail.com','iitr'),('Shubham Madheysia','submiitr07@gmail.com','iitr'),('Vikrant Thakur','vkthakur@gmail.com','iitr');
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

-- Dump completed on 2017-08-06 22:56:15
