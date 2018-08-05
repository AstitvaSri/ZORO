CREATE DATABASE  IF NOT EXISTS `zorodb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `zorodb`;
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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `authorName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'Revolution 2020','Chetan Bhagat'),(2,'Revolution 2020','Chetan Bhagat'),(3,'Revolution 2020','Chetan Bhagat'),(4,'Revolution 2020','Chetan Bhagat'),(5,'Revolution 2020','Chetan Bhagat'),(6,'Revolution 2020','Chetan Bhagat'),(7,'Revolution 2020','Chetan Bhagat'),(8,'Revolution 2020','Chetan Bhagat'),(9,'Revolution 2020','Chetan Bhagat'),(10,'Revolution 2020','Chetan Bhagat'),(11,'Revolution 2020','Chetan Bhagat'),(12,'Revolution 2020','Chetan Bhagat'),(13,'Revolution 2020','Chetan Bhagat'),(14,'Revolution 2020','Chetan Bhagat'),(15,'Revolution 2020','Chetan Bhagat'),(16,'Revolution 2020','Chetan Bhagat'),(17,'Revolution 2020','Chetan Bhagat'),(18,'2 States','Chetan Bhagat'),(19,'2 States','Chetan Bhagat'),(20,'2 States','Chetan Bhagat'),(21,'2 States','Chetan Bhagat'),(22,'2 States','Chetan Bhagat'),(23,'2 States','Chetan Bhagat'),(24,'2 States','Chetan Bhagat'),(25,'2 States','Chetan Bhagat'),(26,'2 States','Chetan Bhagat');
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `existing_users`
--

DROP TABLE IF EXISTS `existing_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `existing_users` (
  `email` varchar(50) NOT NULL DEFAULT 'example@something.com',
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `existing_users`
--

LOCK TABLES `existing_users` WRITE;
/*!40000 ALTER TABLE `existing_users` DISABLE KEYS */;
INSERT INTO `existing_users` VALUES ('abc@gmail.com','12345'),('xyz@gmail.com','12345'),('xz@gmail.com','123qwerty');
/*!40000 ALTER TABLE `existing_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-24 16:58:27
