CREATE DATABASE  IF NOT EXISTS `seminario` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `seminario`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: seminario
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `alerta`
--

DROP TABLE IF EXISTS `alerta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alerta` (
  `idAlerta` int NOT NULL AUTO_INCREMENT,
  `mensaje` varchar(45) NOT NULL,
  PRIMARY KEY (`idAlerta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alerta`
--

LOCK TABLES `alerta` WRITE;
/*!40000 ALTER TABLE `alerta` DISABLE KEYS */;
INSERT INTO `alerta` VALUES (1,'Alerta de verificación'),(2,'Alerta de riesgo'),(3,'Alerta de revisión');
/*!40000 ALTER TABLE `alerta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `numeroDocumento` varchar(45) DEFAULT NULL,
  `fechaNacimiento` datetime NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `mail` varchar(45) NOT NULL,
  `EsTerrorista` tinyint NOT NULL,
  `Cruce_idCruce1` int NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE KEY `unique_numeroDocumento` (`numeroDocumento`),
  KEY `fk_Cliente_Cruce1_idx` (`Cruce_idCruce1`),
  CONSTRAINT `fk_Cliente_Cruce1` FOREIGN KEY (`Cruce_idCruce1`) REFERENCES `cruce` (`idCruce`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Juan','Pérez','12345678','1980-05-12 00:00:00','Av. Siempre Viva 742','01123456789','juan.perez@gmail.com',0,1),(2,'Ana','García','23456789','1990-07-15 00:00:00','Calle Falsa 123','01123456790','ana.garcia@hotmail.com',0,1),(3,'Carlos','López','34567890','1985-01-30 00:00:00','Av. Libertador 456','01123456791','carlos.lopez@yahoo.com.ar',0,1),(4,'Laura','Martínez','45678901','1992-03-20 00:00:00','Av. Corrientes 789','01123456792','laura.martinez@gmail.com',0,1),(5,'Jorge','Fernández','56789012','1988-11-11 00:00:00','Calle Rivadavia 321','01123456793','jorge.fernandez@hotmail.com',0,1),(6,'María','González','67890123','1995-02-14 00:00:00','Av. San Martín 654','01123456794','maria.gonzalez@yahoo.com.ar',0,1),(7,'Pedro','Ramírez','78901234','1983-06-28 00:00:00','Calle Mendoza 987','01123456795','pedro.ramirez@gmail.com',0,1),(8,'Sofía','Díaz','89012345','1994-08-22 00:00:00','Av. Belgrano 852','01123456796','sofia.diaz@hotmail.com',0,1),(9,'Ricardo','Morales','90123456','1987-12-05 00:00:00','Calle Tucumán 159','01123456797','ricardo.morales@yahoo.com.ar',0,1),(10,'Valeria','Cruz','12345679','1991-10-10 00:00:00','Av. de los Incas 111','01123456798','valeria.cruz@gmail.com',0,1),(11,'Martín','Reyes','23456780','1986-09-09 00:00:00','Calle Maipú 222','01123456799','martin.reyes@hotmail.com',0,1),(12,'Patricia','Cordero','34567891','1989-04-18 00:00:00','Av. La Plata 333','01123456800','patricia.cordero@yahoo.com.ar',0,1),(13,'Hugo','Salazar','45678902','1982-05-25 00:00:00','Calle Godoy Cruz 444','01123456801','hugo.salazar@gmail.com',0,1),(14,'Estela','Hernández','56789013','1993-07-30 00:00:00','Av. Pueyrredón 555','01123456802','estela.hernandez@hotmail.com',0,1),(15,'Fernando','Soto','67890124','1980-08-17 00:00:00','Calle Santa Fe 666','01123456803','fernando.soto@yahoo.com.ar',0,1),(16,'Lucía','Jiménez','78901235','1992-12-12 00:00:00','Av. Cincuentenario 777','01123456804','lucia.jimenez@gmail.com',0,1),(17,'Diego','Rojas','89012346','1984-01-22 00:00:00','Calle Libertad 888','01123456805','diego.rojas@hotmail.com',0,1),(18,'Sandra','Vargas','90123457','1990-03-15 00:00:00','Av. Sarmiento 999','01123456806','sandra.vargas@yahoo.com.ar',0,1),(19,'Gustavo','Ponce','12345680','1985-11-30 00:00:00','Calle Jujuy 1000','01123456807','gustavo.ponce@gmail.com',0,1),(20,'Nadia','Silva','23456781','1991-04-28 00:00:00','Av. 9 de Julio 1001','01123456808','nadia.silva@hotmail.com',0,1),(21,'Gabriel','Ortega','34567892','1987-05-14 00:00:00','Calle 25 de Mayo 1002','01123456809','gabriel.ortega@yahoo.com.ar',0,1),(22,'Inés','Cano','45678903','1989-06-19 00:00:00','Av. Santa Fe 1003','01123456810','ines.cano@gmail.com',0,1),(23,'Felipe','Alonso','56789014','1983-09-05 00:00:00','Calle Defensa 1004','01123456811','felipe.alonso@hotmail.com',0,1),(24,'Cecilia','Bermúdez','67890125','1990-07-30 00:00:00','Av. Rivadavia 1005','01123456812','cecilia.bermudez@yahoo.com.ar',0,1),(25,'Salvador','Mora','78901236','1986-12-15 00:00:00','Calle Salta 1006','01123456813','salvador.mora@gmail.com',0,1),(26,'Lorena','Gutiérrez','89012347','1992-01-20 00:00:00','Av. Brasil 1007','01123456814','lorena.gutierrez@hotmail.com',0,1),(27,'Diego','Córdoba','90123458','1984-04-11 00:00:00','Calle San Juan 1008','01123456815','diego.cordoba@yahoo.com.ar',0,1),(28,'Mónica','Cisneros','12345681','1985-03-22 00:00:00','Av. Colón 1009','01123456816','monica.cisneros@gmail.com',0,1),(29,'Roberto','Salinas','23456782','1993-02-09 00:00:00','Calle Corrientes 1010','01123456817','roberto.salinas@hotmail.com',0,1),(33,'AAMIR','ALI CHAUDHRY','BN 4196361','1985-10-18 00:00:00','Calle Falsa 123','123456789','aamir.ali@hotmail.com',1,1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cruce`
--

DROP TABLE IF EXISTS `cruce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cruce` (
  `idCruce` int NOT NULL AUTO_INCREMENT,
  `idCliente` int NOT NULL,
  `idRegistro` int NOT NULL,
  `fechaCruce` datetime DEFAULT NULL,
  `resultado` varchar(45) DEFAULT NULL,
  `alertaGenerada` tinyint NOT NULL,
  `Alerta_idAlerta` int DEFAULT NULL,
  PRIMARY KEY (`idCruce`),
  KEY `fk_Cruce_Alerta1` (`Alerta_idAlerta`),
  CONSTRAINT `fk_Cruce_Alerta1` FOREIGN KEY (`Alerta_idAlerta`) REFERENCES `alerta` (`idAlerta`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cruce`
--

LOCK TABLES `cruce` WRITE;
/*!40000 ALTER TABLE `cruce` DISABLE KEYS */;
INSERT INTO `cruce` VALUES (1,1,1,NULL,NULL,0,NULL),(2,2,1,NULL,NULL,0,NULL),(3,3,1,NULL,NULL,0,NULL);
/*!40000 ALTER TABLE `cruce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operador`
--

DROP TABLE IF EXISTS `operador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operador` (
  `idOperador` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `userName` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `Cruce_idCruce` int NOT NULL,
  PRIMARY KEY (`idOperador`),
  KEY `fk_Operador_Cruce1_idx` (`Cruce_idCruce`),
  CONSTRAINT `fk_Operador_Cruce1` FOREIGN KEY (`Cruce_idCruce`) REFERENCES `cruce` (`idCruce`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operador`
--

LOCK TABLES `operador` WRITE;
/*!40000 ALTER TABLE `operador` DISABLE KEYS */;
INSERT INTO `operador` VALUES (1,'Marcos','Romano','marcos.romano','1234',1);
/*!40000 ALTER TABLE `operador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `repet_json`
--

DROP TABLE IF EXISTS `repet_json`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `repet_json` (
  `dataID` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `alias` varchar(45) NOT NULL,
  `numeroDocumento` varchar(45) DEFAULT NULL,
  `nacionalidad` varchar(80) NOT NULL,
  `comentario` varchar(45) NOT NULL,
  `Cruce_idCruce` int NOT NULL,
  PRIMARY KEY (`dataID`),
  KEY `fk_RePET_JSON_Cruce1_idx` (`Cruce_idCruce`),
  CONSTRAINT `fk_RePET_JSON_Cruce1` FOREIGN KEY (`Cruce_idCruce`) REFERENCES `cruce` (`idCruce`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `repet_json`
--

LOCK TABLES `repet_json` WRITE;
/*!40000 ALTER TABLE `repet_json` DISABLE KEYS */;
/*!40000 ALTER TABLE `repet_json` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-05 11:27:43
