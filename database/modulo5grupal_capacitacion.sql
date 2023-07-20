-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: modulo5grupal
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `capacitacion`
--

DROP TABLE IF EXISTS `capacitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `capacitacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `descripcion` varchar(200) COLLATE utf8mb3_spanish_ci NOT NULL,
  `fecha` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `hora` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  `lugar` varchar(45) COLLATE utf8mb3_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `capacitacion`
--

LOCK TABLES `capacitacion` WRITE;
/*!40000 ALTER TABLE `capacitacion` DISABLE KEYS */;
INSERT INTO `capacitacion` VALUES (1,'sdsadas','asdasdsadasd','2024-12-12','10:10','mi casa'),(2,'dsadasdassadasdasdsad','adsadasdsafsesgfsfsefdsfdsfdsfdsfdsfdsfdsfsdfsdfsdfasdfftrdgfdher','2025-10-10','15:30','otra casa'),(3,'3, 2 ,1 ','feliz año nuevo','2023-12-31','00:00','una tercera casa distinta a las otras dos'),(4,'test','test','2024-05-04','11:00','test'),(5,'adasdasdasd','ddasdassd','2024-10-12','12:43','htrtewrwewerew'),(6,'probando','test','2023-04-12','16:00','test'),(7,'adasdasdasd','sadasdasdasda','1990-12-12','12:23','test'),(8,'dsadasdasdsad','sadasdasdasdsa','0132-02-23','12:21','test'),(9,'dasddsa','dasdasdads','1990-12-23','23:04','mi casa'),(10,'adasdasdasd','ASDSADSADAS','2025-03-12','12:03','test fecha 2'),(11,'dasdasd','asdsadas','2024-07-15','21:03','test fecha'),(12,'edsdaasd','sadsadas','2023-07-16','10:10','test fecha 1'),(13,'adsadasdas','asdasdas','2023-07-14','04:31','test fecha 3'),(14,'asdas','asdsad','2023-07-14','06:05','test fecha 4'),(15,'adasdasdasd','asdsads','2023-07-14','15:15','test fecha 5'),(16,'adasdasdasd','asdasdsa','2023-07-14','15:15','test fecha 6'),(17,'asdasdsa','dasdasdas','2023-07-13','10:10','test fecha 7'),(18,'adasdasdasd','adsadasd','2023-07-13','12:12','test fecha 8'),(19,'dsdasda','asdasddas','2024-07-15','23:01','test fecha 11'),(20,'adasdsa','sdsadasda','2023-07-16','12:03','asdasdsa'),(21,'asdasdas','asdsadasd','2024-03-12','03:04','sadsasdas'),(22,'test redirect 1','test redirect 1','2024-02-04','05:03','test redirect 1'),(23,'test redirect 2','test','2024-04-05','04:32','test redirect 2'),(24,'asdasdas','asdasda','2024-03-04','08:09','test redirect 3'),(25,'adasdasdasd','test','2024-04-06','12:03','test redirect 4'),(26,'asdas','asdasd','2024-03-04','05:06','sadadssad'),(27,'adasdasdasd','asdasdasd','2024-04-14','07:06','test redirect 5'),(28,'adasdasdasd','asdasdas','2024-03-06','08:06','test redirect 6'),(29,'adasdasdasd','ASDSADASD','2024-08-05','06:54','test ajax 1'),(30,'adasdasdasd','wqeqweqweq','2024-04-05','06:05','test redirect algo'),(31,'adasdasdasd','sadsadasd','2024-03-05','05:56','wewqeqweqw'),(32,'adasdasdasd','dsadasdasd','2023-12-06','05:35','eqweqweq'),(33,'sdadasdas','dasdasda','2024-04-05','21:24','sadasdasdasd');
/*!40000 ALTER TABLE `capacitacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-19 19:59:53
