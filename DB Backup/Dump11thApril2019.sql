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
-- Table structure for table `all_products`
--

DROP TABLE IF EXISTS `all_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `all_products` (
  `productid` int(11) NOT NULL,
  `title` varchar(45) DEFAULT NULL,
  `rating` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `avail` varchar(45) DEFAULT NULL,
  `imgPath` varchar(45) DEFAULT NULL,
  `categ` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `owner` varchar(45) NOT NULL,
  PRIMARY KEY (`productid`),
  UNIQUE KEY `productid_UNIQUE` (`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `all_products`
--

LOCK TABLES `all_products` WRITE;
/*!40000 ALTER TABLE `all_products` DISABLE KEYS */;
INSERT INTO `all_products` VALUES (1,'Camera','3.5/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','electronics','Rs. 20,000',''),(4,'Bed','3.5/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','electronics','Rs. 20,000',''),(5,'Bed','3.5/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','electronics','Rs. 20,000',''),(7,'Fan','3.5/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','electronics','Rs. 20,000',''),(8,'Dog','3.5/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','electronics','Rs. 20,000',''),(9,'Dog','3.5/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','electronics','Rs. 20,000',''),(10,'Dog','3.5/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','electronics','Rs. 20,000',''),(11,'Dog','3.5/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','electronics','Rs. 20,000',''),(12,'Car','3.5/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','electronics','Rs. 20,000',''),(13,'Camera not Stand','3.5/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','electronics','Rs. 20,000',''),(14,'Red Shirt','0/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','dress','Rs. 20,000',''),(15,'Red Shirt','0/5','Alambagh, Lucknow','20 days','path/folder/file.jpg','dress','Rs. 20,000','');
/*!40000 ALTER TABLE `all_products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credentials`
--

DROP TABLE IF EXISTS `credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `credentials` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` text,
  `password` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credentials`
--

LOCK TABLES `credentials` WRITE;
/*!40000 ALTER TABLE `credentials` DISABLE KEYS */;
INSERT INTO `credentials` VALUES (1,'asti365@gmail.com','0XQSOR'),(3,'asti3689@gmail.com','0XQSOR'),(5,'hjk@gmail.com','0XQSOR'),(7,'hello@gmail.com','123'),(8,'ab.xyhhj@gmail.com','12345'),(9,'doggy@gmai.com','12345'),(10,'asti678@hj.com','1234567');
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
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `otp_entries`
--

LOCK TABLES `otp_entries` WRITE;
/*!40000 ALTER TABLE `otp_entries` DISABLE KEYS */;
INSERT INTO `otp_entries` VALUES (1,'mishraanuj.cs@gmail.com ','N8IIMD'),(18,'asti@gmail.com ','60VAS3'),(21,'abc@gmail.com','B2B6DA'),(26,'asti1997.mri@gmail.com','3D8NIF'),(27,'asd@gmail.kom','XFF4SF'),(28,'asti321@gmail.com','SK43M5'),(30,'jun@g.com','2ZSMW6'),(31,'hy@gm.com','CKMTR8'),(32,'as@gm.com','O71DB4'),(33,'ash@kmail.com','WJ5RWG'),(34,'ash@gmail.com','Y1WST4'),(36,'astiksjab@gmail.com','P8WFQ1'),(38,'astitva.ccv@gmail.com','WBS1WC'),(39,'asti1997.sri@gmail','J0PUZN'),(40,'astiksjab@gmail','65JDYI'),(41,'asti@hmail','6NU6UG'),(43,'asd@hjmai','KNLZEY'),(44,'asd@jmain','BUXYR9'),(47,'ab.ghj@gmail.com','GRTHPE'),(48,'asti1887.sri@gmail.com','490YY6'),(49,'heyther@gmail.com','PW7QO0'),(50,'asti@kmail.com','XV63PK'),(51,'abcd@ef.mail.com','CR5WC4'),(52,'adam@gmail.com','5QIXHS'),(54,'adam.se@gm.com','Y72NU4'),(55,'asd@gmm.com','584W3M'),(56,'ad.ad@ad.com','203AEY'),(57,'kaise@kaise.com','MIXS83'),(58,'hey@gmail.vom','FQHFLG'),(59,'ironman@jarvis.com','U4DOQH'),(60,'hello@world.in','4YWUYX'),(61,'aaaaa@aaa.aa','PQA2ZM'),(62,'hithere@hi.hi','2E2CLD'),(63,'abc.xt@man.com','8X8PIB'),(64,'ma.com@com.gmail','90X42P'),(65,'agha@hm.com','S86Q1T'),(66,'asd@gh.com','75AWTZ'),(67,'aa.cc@bb.com','G4P4RR'),(68,'astiitva@gmail.com','BDXGTX'),(69,'asas@gmia.co','AYPN5C'),(70,'undefined','Y8GG2H'),(71,'asd@hm.com','PQUZJI'),(72,'asd@h.com','GDMSDE'),(73,'asd@gm.com','6VFSOG'),(74,'asdf@hm.com','29CLNM'),(75,'123456','N72G0F'),(76,'anuj@v.com','AY6GVD'),(78,'junisevil@gmail.com','08KPO5'),(79,'jun@gmakc.com','IWHPM0'),(81,'jun@gmail.com','198E14'),(84,'junis@gmail.com','98S3S6'),(86,'jun@gmaik.cio','92NQYM'),(88,'asd@c.mom','7K5NZF'),(91,'alokmishra@ambalika.co.in','PNER95'),(93,'vishesh522@gmail.com','9BENMS');
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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_personal_details`
--

LOCK TABLES `user_personal_details` WRITE;
/*!40000 ALTER TABLE `user_personal_details` DISABLE KEYS */;
INSERT INTO `user_personal_details` VALUES (20,'ab.xy@gmail.com','{\"lastName\":\"Surname\",\"firstName\":\"FirstName\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LKO\",\"state\":\"UP\",\"email\":\"ab.xy@gmail.com\",\"age\":21}'),(22,'ab.z@gmail.com','{\"lastName\":\"Surname\",\"firstName\":\"FirstName\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LKO\",\"state\":\"UP\",\"email\":\"ab.z@gmail.com\",\"age\":21}'),(23,'ab.xyhhj@gmail.com','{\"lastName\":\"Surname\",\"firstName\":\"FirstName\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LKO\",\"state\":\"UP\",\"email\":\"ab.xyhhj@gmail.com\",\"age\":21}'),(24,'abc.xy@gmail.com','{\"lastName\":\"Surname\",\"firstName\":\"FirstName\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LKO\",\"state\":\"UP\",\"age\":21,\"email\":\"abc.xy@gmail.com\"}'),(28,'abcd.xy@gmail.com','{\"lastName\":\"Mishra\",\"firstName\":\"Anuj\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LKO\",\"state\":\"UP\",\"age\":21,\"email\":\"abcd.xy@gmail.com\"}'),(31,'abcde.xy@gmail.com','{\"firstName\":\"Anuj\",\"lastName\":\"Mishra\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LKO\",\"state\":\"UP\",\"email\":\"abcde.xy@gmail.com\",\"age\":21}'),(37,'abgh.xy@gmail.com','{\"lastName\":\"Xavier\",\"firstName\":\"Charles\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LKO\",\"state\":\"UP\",\"email\":\"abgh.xy@gmail.com\",\"age\":21}'),(40,'abggggh.xy@gmail.com','{\"firstName\":\"Homie\",\"lastName\":\"Victor\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LA\",\"state\":\"UP\",\"age\":22,\"email\":\"abggggh.xy@gmail.com\"}'),(41,'abyh.xy@gmail.com','{\"firstName\":\"Homie\",\"lastName\":\"Victor\",\"gender\":\"Male\",\"phone\":\"950638627\",\"city\":\"LA\",\"state\":\"UP\",\"age\":22,\"email\":\"abyh.xy@gmail.com\"}'),(42,'abyhzzzzzzzzz.xy@gmail.com','{\"lastName\":\"Victor\",\"firstName\":\"Homie\",\"gender\":\"Male\",\"city\":\"LA\",\"phone\":\"950638627\",\"state\":\"UP\",\"email\":\"abyhzzzzzzzzz.xy@gmail.com\",\"age\":22}');
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

-- Dump completed on 2019-04-11 14:03:10
