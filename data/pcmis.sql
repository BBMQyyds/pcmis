-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pcmis
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `_case`
--

DROP TABLE IF EXISTS `_case`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `_case` (
  `case_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '案件ID',
  `project_id` bigint unsigned DEFAULT NULL COMMENT '关联项目ID',
  `complain_time` datetime NOT NULL COMMENT '投诉时间',
  `complainant` varchar(100) NOT NULL COMMENT '投诉人姓名',
  `complain_amount` decimal(15,2) NOT NULL COMMENT '投诉金额',
  `complain_people_num` int DEFAULT '1' COMMENT '涉及人数',
  `respondent` varchar(200) NOT NULL COMMENT '被投诉单位',
  `case_type` enum('工程建设','非工程') DEFAULT '工程建设' COMMENT '案件类别',
  `current_status` enum('待受理','处理中','已办结') DEFAULT '待受理' COMMENT '当前状态',
  `handler_id` bigint unsigned DEFAULT NULL COMMENT '案件负责人',
  `resolve_amount` decimal(15,2) DEFAULT '0.00' COMMENT '已解决金额',
  `resolve_people_num` int DEFAULT '0' COMMENT '已解决人数',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`case_id`),
  KEY `idx_complain_time` (`complain_time`),
  KEY `project_id` (`project_id`),
  KEY `handler_id` (`handler_id`),
  CONSTRAINT `_case_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `_case_ibfk_2` FOREIGN KEY (`handler_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='劳动案件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_case`
--

LOCK TABLES `_case` WRITE;
/*!40000 ALTER TABLE `_case` DISABLE KEYS */;
INSERT INTO `_case` VALUES (1,1,'2025-03-02 03:37:47','Complainant 1',1200.00,1,'Respondent 1','工程建设','待受理',1,0.00,0,'2025-03-02 03:37:47','2025-03-02 03:37:47'),(2,2,'2025-03-02 04:37:47','Complainant 2',1300.00,2,'Respondent 2','非工程','处理中',2,1000.00,1,'2025-03-02 04:37:47','2025-03-02 04:37:47'),(3,3,'2025-03-02 05:37:47','Complainant 3',1400.00,3,'Respondent 3','工程建设','已办结',3,1500.00,2,'2025-03-02 05:37:47','2025-03-02 05:37:47'),(4,4,'2025-03-02 06:37:47','Complainant 4',1500.00,1,'Respondent 4','非工程','待受理',4,0.00,0,'2025-03-02 06:37:47','2025-03-02 06:37:47'),(5,5,'2025-03-02 07:37:47','Complainant 5',1600.00,4,'Respondent 5','工程建设','处理中',5,500.00,1,'2025-03-02 07:37:47','2025-03-02 07:37:47'),(6,6,'2025-03-02 08:37:47','Complainant 6',1700.00,5,'Respondent 6','非工程','已办结',6,2000.00,2,'2025-03-02 08:37:47','2025-03-02 08:37:47'),(7,7,'2025-03-02 09:37:47','Complainant 7',1800.00,6,'Respondent 7','工程建设','待受理',7,0.00,0,'2025-03-02 09:37:47','2025-03-02 09:37:47'),(8,8,'2025-03-02 10:37:47','Complainant 8',1900.00,7,'Respondent 8','非工程','处理中',8,1500.00,1,'2025-03-02 10:37:47','2025-03-02 10:37:47'),(9,9,'2025-03-02 11:37:47','Complainant 9',2000.00,8,'Respondent 9','工程建设','已办结',9,2500.00,2,'2025-03-02 11:37:47','2025-03-02 11:37:47'),(10,10,'2025-03-02 12:37:47','Complainant 10',2100.00,9,'Respondent 10','非工程','待受理',10,0.00,0,'2025-03-02 12:37:47','2025-03-02 12:37:47');
/*!40000 ALTER TABLE `_case` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attachment`
--

DROP TABLE IF EXISTS `attachment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attachment` (
  `file_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '文件ID',
  `biz_type` enum('项目合同','保证金凭证','案件证据') NOT NULL COMMENT '业务类型',
  `biz_id` bigint unsigned NOT NULL COMMENT '关联业务ID',
  `file_name` varchar(200) NOT NULL COMMENT '文件名称',
  `file_path` varchar(500) NOT NULL COMMENT '存储路径',
  `file_size` bigint DEFAULT '0' COMMENT '文件大小（字节）',
  `upload_user` bigint unsigned NOT NULL COMMENT '上传人',
  `upload_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  PRIMARY KEY (`file_id`),
  KEY `idx_biz` (`biz_type`,`biz_id`),
  KEY `upload_user` (`upload_user`),
  CONSTRAINT `attachment_ibfk_1` FOREIGN KEY (`upload_user`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='附件管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachment`
--

LOCK TABLES `attachment` WRITE;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
INSERT INTO `attachment` VALUES (1,'项目合同',1,'file_1.pdf','/path/to/file/1.pdf',1200,1,'2025-03-02 03:37:47'),(2,'保证金凭证',2,'file_2.pdf','/path/to/file/2.pdf',2500,2,'2025-03-02 04:37:47'),(3,'案件证据',3,'file_3.pdf','/path/to/file/3.pdf',3500,3,'2025-03-02 05:37:47'),(4,'项目合同',4,'file_4.pdf','/path/to/file/4.pdf',4500,4,'2025-03-02 06:37:47'),(5,'保证金凭证',5,'file_5.pdf','/path/to/file/5.pdf',1500,5,'2025-03-02 07:37:47'),(6,'案件证据',6,'file_6.pdf','/path/to/file/6.pdf',500,6,'2025-03-02 08:37:47'),(7,'项目合同',7,'file_7.pdf','/path/to/file/7.pdf',1200,7,'2025-03-02 09:37:47'),(8,'保证金凭证',8,'file_8.pdf','/path/to/file/8.pdf',2000,8,'2025-03-02 10:37:47'),(9,'案件证据',9,'file_9.pdf','/path/to/file/9.pdf',2800,9,'2025-03-02 11:37:47'),(10,'项目合同',10,'file_10.pdf','/path/to/file/10.pdf',3200,10,'2025-03-02 12:37:47');
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_process`
--

DROP TABLE IF EXISTS `case_process`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `case_process` (
  `process_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '流程ID',
  `case_id` bigint unsigned NOT NULL COMMENT '案件ID',
  `step_type` enum('接待意见','监察意见','行政意见') NOT NULL COMMENT '处理阶段',
  `content` text NOT NULL COMMENT '处理意见',
  `handler_id` bigint unsigned NOT NULL COMMENT '处理人',
  `handle_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '处理时间',
  PRIMARY KEY (`process_id`),
  KEY `idx_case` (`case_id`),
  KEY `handler_id` (`handler_id`),
  CONSTRAINT `case_process_ibfk_1` FOREIGN KEY (`case_id`) REFERENCES `_case` (`case_id`),
  CONSTRAINT `case_process_ibfk_2` FOREIGN KEY (`handler_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='案件处理流程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_process`
--

LOCK TABLES `case_process` WRITE;
/*!40000 ALTER TABLE `case_process` DISABLE KEYS */;
INSERT INTO `case_process` VALUES (1,1,'行政意见','处理意见内容 1',8,'2025-03-02 02:37:47'),(2,5,'接待意见','处理意见内容 2',4,'2025-03-02 02:37:47'),(3,2,'监察意见','处理意见内容 3',3,'2025-03-02 02:37:47'),(4,9,'接待意见','处理意见内容 4',8,'2025-03-02 02:37:47'),(5,9,'行政意见','处理意见内容 5',6,'2025-03-02 02:37:47'),(6,6,'接待意见','处理意见内容 6',3,'2025-03-02 02:37:47'),(7,7,'监察意见','处理意见内容 7',2,'2025-03-02 02:37:47'),(8,8,'接待意见','处理意见内容 8',4,'2025-03-02 02:37:47'),(9,10,'行政意见','处理意见内容 9',9,'2025-03-02 02:37:47'),(10,3,'接待意见','处理意见内容 10',5,'2025-03-02 02:37:47');
/*!40000 ALTER TABLE `case_process` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project` (
  `project_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `project_name` varchar(200) NOT NULL COMMENT '项目名称',
  `construction_unit` varchar(200) NOT NULL COMMENT '建设单位',
  `contractor` varchar(200) NOT NULL COMMENT '总承包单位',
  `contract_price` decimal(15,2) NOT NULL COMMENT '合同价款（万元）',
  `project_location` varchar(200) NOT NULL COMMENT '项目地点',
  `sign_date` date NOT NULL COMMENT '合同签订日期',
  `start_date` date NOT NULL COMMENT '开工日期',
  `status` enum('在建','停工','完工') DEFAULT '在建' COMMENT '项目状态',
  `deposit_amount` decimal(15,2) DEFAULT '0.00' COMMENT '工资保证金金额',
  `deposit_status` enum('未缴纳','已缴纳','部分缴纳') DEFAULT '未缴纳' COMMENT '保证金状态',
  `deposit_type` enum('存款','保函','保单') DEFAULT NULL COMMENT '缴纳方式',
  `special_account` tinyint(1) DEFAULT '0' COMMENT '专用账户是否开设',
  `create_by` bigint unsigned DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`project_id`),
  KEY `idx_project_name` (`project_name`),
  KEY `create_by` (`create_by`),
  CONSTRAINT `project_ibfk_1` FOREIGN KEY (`create_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='工程项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'Project 1','Construction Unit 1','Contractor 1',150.50,'Location 1','2025-03-02','2025-03-02','在建',20.00,'未缴纳','存款',1,1,'2025-03-02 03:37:47','2025-03-02 03:37:47'),(2,'Project 2','Construction Unit 2','Contractor 2',200.00,'Location 2','2025-03-02','2025-03-02','停工',30.00,'已缴纳','保单',1,2,'2025-03-02 04:37:47','2025-03-02 04:37:47'),(3,'Project 3','Construction Unit 3','Contractor 3',250.00,'Location 3','2025-03-02','2025-03-02','完工',40.00,'部分缴纳','保函',0,3,'2025-03-02 05:37:47','2025-03-02 05:37:47'),(4,'Project 4','Construction Unit 4','Contractor 4',300.00,'Location 4','2025-03-02','2025-03-02','在建',50.00,'未缴纳','存款',0,4,'2025-03-02 06:37:47','2025-03-02 06:37:47'),(5,'Project 5','Construction Unit 5','Contractor 5',350.00,'Location 5','2025-03-02','2025-03-02','停工',60.00,'已缴纳','保单',1,5,'2025-03-02 07:37:47','2025-03-02 07:37:47'),(6,'Project 6','Construction Unit 6','Contractor 6',400.00,'Location 6','2025-03-02','2025-03-02','完工',70.00,'部分缴纳','保函',1,6,'2025-03-02 08:37:47','2025-03-02 08:37:47'),(7,'Project 7','Construction Unit 7','Contractor 7',450.00,'Location 7','2025-03-02','2025-03-02','在建',80.00,'未缴纳','存款',0,7,'2025-03-02 09:37:47','2025-03-02 09:37:47'),(8,'Project 8','Construction Unit 8','Contractor 8',500.00,'Location 8','2025-03-02','2025-03-02','停工',90.00,'已缴纳','保单',0,8,'2025-03-02 10:37:47','2025-03-02 10:37:47'),(9,'Project 9','Construction Unit 9','Contractor 9',550.00,'Location 9','2025-03-02','2025-03-02','完工',100.00,'部分缴纳','保函',1,9,'2025-03-02 11:37:47','2025-03-02 11:37:47'),(10,'Project 10','Construction Unit 10','Contractor 10',600.00,'Location 10','2025-03-02','2025-03-02','在建',110.00,'未缴纳','存款',0,10,'2025-03-02 12:37:47','2025-03-02 12:37:47');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sms_code`
--

DROP TABLE IF EXISTS `sms_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sms_code` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `code` varchar(10) NOT NULL COMMENT '验证码',
  `biz_type` varchar(50) NOT NULL COMMENT '业务类型（login/register等）',
  `expire_time` datetime NOT NULL COMMENT '过期时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='短信验证码表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_code`
--

LOCK TABLES `sms_code` WRITE;
/*!40000 ALTER TABLE `sms_code` DISABLE KEYS */;
INSERT INTO `sms_code` VALUES (1,'13812345678','5234','login','2025-03-02 03:37:47','2025-03-02 03:37:47'),(2,'13823456789','6345','register','2025-03-02 04:37:47','2025-03-02 04:37:47'),(3,'13834567890','7456','login','2025-03-02 05:37:47','2025-03-02 05:37:47'),(4,'13845678901','8567','register','2025-03-02 06:37:47','2025-03-02 06:37:47'),(5,'13856789012','9678','login','2025-03-02 07:37:47','2025-03-02 07:37:47'),(6,'13867890123','0789','reset_password','2025-03-02 08:37:47','2025-03-02 08:37:47'),(7,'13878901234','1890','register','2025-03-02 09:37:47','2025-03-02 09:37:47'),(8,'13889012345','2901','login','2025-03-02 10:37:47','2025-03-02 10:37:47'),(9,'13890123456','3012','register','2025-03-02 11:37:47','2025-03-02 11:37:47'),(10,'13801234567','4123','login','2025-03-02 12:37:47','2025-03-02 12:37:47');
/*!40000 ALTER TABLE `sms_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '加密密码',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `role_id` int NOT NULL DEFAULT '2' COMMENT '角色ID（1-管理员 2-普通用户）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uniq_username` (`username`),
  KEY `idx_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user1','password_1234','13812345678','Real Name 1',1,'2025-03-02 03:37:47','2025-03-02 03:37:47'),(2,'user2','password_5678','13823456789','Real Name 2',2,'2025-03-02 04:37:47','2025-03-02 04:37:47'),(3,'user3','password_9101','13834567890','Real Name 3',2,'2025-03-02 05:37:47','2025-03-02 05:37:47'),(4,'user4','password_1121','13845678901','Real Name 4',1,'2025-03-02 06:37:47','2025-03-02 06:37:47'),(5,'user5','password_3141','13856789012','Real Name 5',2,'2025-03-02 07:37:47','2025-03-02 07:37:47'),(6,'user6','password_5161','13867890123','Real Name 6',1,'2025-03-02 08:37:47','2025-03-02 08:37:47'),(7,'user7','password_7181','13878901234','Real Name 7',2,'2025-03-02 09:37:47','2025-03-02 09:37:47'),(8,'user8','password_9202','13889012345','Real Name 8',1,'2025-03-02 10:37:47','2025-03-02 10:37:47'),(9,'user9','password_1223','13890123456','Real Name 9',2,'2025-03-02 11:37:47','2025-03-02 11:37:47'),(10,'user10','password_3244','13801234567','Real Name 10',1,'2025-03-02 12:37:47','2025-03-02 12:37:47');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-02 13:28:19
