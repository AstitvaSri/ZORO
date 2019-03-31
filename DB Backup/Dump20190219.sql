-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: zorodb
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `credentials`
--

DROP TABLE IF EXISTS `credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `credentials` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`,`email`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credentials`
--

LOCK TABLES `credentials` WRITE;
/*!40000 ALTER TABLE `credentials` DISABLE KEYS */;
INSERT INTO `credentials` VALUES (1,'asti365@gmail.com','0XQSOR'),(3,'asti3689@gmail.com','0XQSOR'),(5,'hjk@gmail.com','0XQSOR'),(7,'hello@gmail.com','123'),(8,'ab.xyhhj@gmail.com','12345');
/*!40000 ALTER TABLE `credentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `otp_entries`
--

DROP TABLE IF EXISTS `otp_entries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `otp_entries` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unverified_emails` varchar(45) DEFAULT NULL,
  `current_otp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otp_entries`
--

LOCK TABLES `otp_entries` WRITE;
/*!40000 ALTER TABLE `otp_entries` DISABLE KEYS */;
INSERT INTO `otp_entries` VALUES (1,'mishraanuj.cs@gmail.com ','N8IIMD'),(18,'asti@gmail.com ','60VAS3'),(21,'abc@gmail.com','B2B6DA'),(26,'asti1997.mri@gmail.com','3D8NIF'),(27,'asd@gmail.kom','XFF4SF'),(28,'asti321@gmail.com','SK43M5'),(30,'jun@g.com','2ZSMW6'),(31,'hy@gm.com','CKMTR8'),(32,'as@gm.com','O71DB4'),(33,'ash@kmail.com','WJ5RWG'),(34,'ash@gmail.com','Y1WST4'),(35,'asti1997.sri@gmail.com','1LDRRO'),(36,'astiksjab@gmail.com','P8WFQ1'),(37,'astitva.cse@gmail.com','J2KG0I'),(38,'astitva.ccv@gmail.com','WBS1WC'),(39,'asti1997.sri@gmail','J0PUZN'),(40,'astiksjab@gmail','65JDYI'),(41,'asti@hmail','6NU6UG'),(42,'asti@kmail.com','3VN1WM'),(43,'asd@hjmai','KNLZEY'),(44,'asd@jmain','BUXYR9'),(45,'asd@gmail.com','BV389A');
/*!40000 ALTER TABLE `otp_entries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_personal_details`
--

DROP TABLE IF EXISTS `user_personal_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_personal_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(60) NOT NULL DEFAULT 'example@mail.com',
  `details_json` varchar(300) NOT NULL DEFAULT '{"key"="value"}',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_personal_details`
--

LOCK TABLES `user_personal_details` WRITE;
/*!40000 ALTER TABLE `user_personal_details` DISABLE KEYS */;
INSERT INTO `user_personal_details` VALUES (20,'ab.xy@gmail.com','{\"lastName\":\"Surname\",\"firstName\":\"FirstName\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LKO\",\"state\":\"UP\",\"email\":\"ab.xy@gmail.com\",\"age\":21}'),(22,'ab.z@gmail.com','{\"lastName\":\"Surname\",\"firstName\":\"FirstName\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LKO\",\"state\":\"UP\",\"email\":\"ab.z@gmail.com\",\"age\":21}'),(23,'ab.xyhhj@gmail.com','{\"lastName\":\"Surname\",\"firstName\":\"FirstName\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LKO\",\"state\":\"UP\",\"email\":\"ab.xyhhj@gmail.com\",\"age\":21}');
/*!40000 ALTER TABLE `user_personal_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-19 23:43:54
