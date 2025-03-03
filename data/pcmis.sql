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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='劳动案件表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_case`
--

LOCK TABLES `_case` WRITE;
/*!40000 ALTER TABLE `_case` DISABLE KEYS */;
INSERT INTO `_case` VALUES (1,1,'2025-03-01 10:00:00','王小明',50.00,3,'某建筑公司','工程建设','处理中',4,20.00,1,'2025-03-03 15:52:29','2025-03-03 15:52:29'),(2,2,'2025-03-02 14:30:00','李大军',80.00,5,'某施工单位','工程建设','待受理',4,0.00,0,'2025-03-03 15:52:29','2025-03-03 15:52:29');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='附件管理表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachment`
--

LOCK TABLES `attachment` WRITE;
/*!40000 ALTER TABLE `attachment` DISABLE KEYS */;
INSERT INTO `attachment` VALUES (1,'项目合同',1,'市政道路改造合同.pdf','/uploads/contracts/project1.pdf',204800,3,'2025-03-03 15:53:23'),(2,'保证金凭证',2,'住宅小区建设保证金缴纳凭证.jpg','/uploads/deposits/project2.jpg',102400,3,'2025-03-03 15:53:23'),(3,'案件证据',1,'工资拖欠证据.png','/uploads/evidence/case1.png',512000,4,'2025-03-03 15:53:23'),(4,'案件证据',2,'工地录音证据.mp3','/uploads/evidence/case2.mp3',1048576,4,'2025-03-03 15:53:23');
/*!40000 ALTER TABLE `attachment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_evidence`
--

DROP TABLE IF EXISTS `case_evidence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `case_evidence` (
  `evidence_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `case_id` bigint unsigned NOT NULL,
  `evidence_type` enum('书面证据','物证','视听资料','电子数据') NOT NULL,
  `description` text NOT NULL COMMENT '证据描述',
  PRIMARY KEY (`evidence_id`),
  KEY `case_id` (`case_id`),
  CONSTRAINT `case_evidence_ibfk_1` FOREIGN KEY (`case_id`) REFERENCES `_case` (`case_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='案件证据链表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_evidence`
--

LOCK TABLES `case_evidence` WRITE;
/*!40000 ALTER TABLE `case_evidence` DISABLE KEYS */;
INSERT INTO `case_evidence` VALUES (1,1,'书面证据','合同副本及工资支付记录'),(2,2,'视听资料','现场录音证据');
/*!40000 ALTER TABLE `case_evidence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `case_followup`
--

DROP TABLE IF EXISTS `case_followup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `case_followup` (
  `follow_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `case_id` bigint unsigned NOT NULL,
  `visit_time` datetime NOT NULL COMMENT '回访时间',
  `visit_result` text NOT NULL COMMENT '回访结果',
  `visitor_id` bigint unsigned NOT NULL COMMENT '回访人',
  PRIMARY KEY (`follow_id`),
  KEY `case_id` (`case_id`),
  KEY `visitor_id` (`visitor_id`),
  CONSTRAINT `case_followup_ibfk_1` FOREIGN KEY (`case_id`) REFERENCES `_case` (`case_id`),
  CONSTRAINT `case_followup_ibfk_2` FOREIGN KEY (`visitor_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='案件回访记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_followup`
--

LOCK TABLES `case_followup` WRITE;
/*!40000 ALTER TABLE `case_followup` DISABLE KEYS */;
INSERT INTO `case_followup` VALUES (1,1,'2025-03-05 09:30:00','投诉人表示已收到部分款项',4),(2,2,'2025-03-06 10:00:00','案件正在处理中',4);
/*!40000 ALTER TABLE `case_followup` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='案件处理流程表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `case_process`
--

LOCK TABLES `case_process` WRITE;
/*!40000 ALTER TABLE `case_process` DISABLE KEYS */;
INSERT INTO `case_process` VALUES (1,1,'接待意见','案件已受理，等待进一步调查',4,'2025-03-03 15:52:29'),(2,2,'监察意见','已调查相关证据，建议调解',4,'2025-03-03 15:52:29');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='工程项目表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,'市政道路改造工程','某市政建设局','某建筑公司',5000.00,'北京市朝阳区','2025-01-15','2025-02-01','在建',200.00,'已缴纳','保函',1,3,'2025-03-03 15:52:29','2025-03-03 15:52:29'),(2,'住宅小区建设项目','某房地产公司','某施工单位',8000.00,'上海市浦东新区','2025-02-10','2025-03-01','在建',300.00,'部分缴纳','存款',1,3,'2025-03-03 15:52:29','2025-03-03 15:52:29');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_company`
--

DROP TABLE IF EXISTS `project_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_company` (
  `relation_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `project_id` bigint unsigned NOT NULL,
  `company_type` enum('建设单位','总承包','分包单位','监理单位') NOT NULL,
  `company_name` varchar(200) NOT NULL,
  `contact_person` varchar(50) DEFAULT NULL,
  `contact_phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`relation_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `project_company_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目参与单位表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_company`
--

LOCK TABLES `project_company` WRITE;
/*!40000 ALTER TABLE `project_company` DISABLE KEYS */;
INSERT INTO `project_company` VALUES (1,1,'建设单位','某市政建设局','张建设','13888880001'),(2,1,'总承包','某建筑公司','李施工','13999990002'),(3,1,'监理单位','某工程监理公司','王监理','13777770003'),(4,2,'建设单位','某房地产公司','赵房建','13666660004'),(5,2,'总承包','某施工单位','钱工程','13555550005');
/*!40000 ALTER TABLE `project_company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_phase`
--

DROP TABLE IF EXISTS `project_phase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `project_phase` (
  `phase_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `project_id` bigint unsigned NOT NULL,
  `phase_type` enum('立项','施工','竣工','验收') NOT NULL COMMENT '阶段类型',
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  `phase_status` enum('未开始','进行中','已完成') DEFAULT '未开始',
  PRIMARY KEY (`phase_id`),
  KEY `project_id` (`project_id`),
  CONSTRAINT `project_phase_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='项目阶段表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_phase`
--

LOCK TABLES `project_phase` WRITE;
/*!40000 ALTER TABLE `project_phase` DISABLE KEYS */;
INSERT INTO `project_phase` VALUES (1,1,'立项','2025-01-01','2025-01-10','已完成'),(2,1,'施工','2025-02-01',NULL,'进行中'),(3,2,'立项','2025-02-15','2025-02-20','已完成'),(4,2,'施工','2025-03-01',NULL,'进行中');
/*!40000 ALTER TABLE `project_phase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `risk_assessment`
--

DROP TABLE IF EXISTS `risk_assessment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `risk_assessment` (
  `assessment_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `project_id` bigint unsigned NOT NULL,
  `risk_level` enum('低风险','中风险','高风险') NOT NULL,
  `assessment_date` date NOT NULL,
  `assessment_by` bigint unsigned NOT NULL COMMENT '评估人',
  `risk_factors` text NOT NULL COMMENT '风险因素',
  `preventive_measures` text COMMENT '预防措施',
  PRIMARY KEY (`assessment_id`),
  KEY `project_id` (`project_id`),
  KEY `assessment_by` (`assessment_by`),
  CONSTRAINT `risk_assessment_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `risk_assessment_ibfk_2` FOREIGN KEY (`assessment_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='风险评估记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `risk_assessment`
--

LOCK TABLES `risk_assessment` WRITE;
/*!40000 ALTER TABLE `risk_assessment` DISABLE KEYS */;
INSERT INTO `risk_assessment` VALUES (1,1,'中风险','2025-03-01',3,'项目进度缓慢，存在工期延误风险','增加施工人员，加快施工进度'),(2,2,'高风险','2025-03-02',3,'发现施工质量存在问题，可能导致安全事故','加强质量检查，确保施工规范执行');
/*!40000 ALTER TABLE `risk_assessment` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='短信验证码表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sms_code`
--

LOCK TABLES `sms_code` WRITE;
/*!40000 ALTER TABLE `sms_code` DISABLE KEYS */;
INSERT INTO `sms_code` VALUES (1,'13812345678','563482','login','2025-03-04 10:30:00','2025-03-03 15:52:29'),(2,'13987654321','834927','register','2025-03-04 10:40:00','2025-03-03 15:52:29'),(3,'13765439876','927614','password_reset','2025-03-04 11:00:00','2025-03-03 15:52:29'),(4,'13654329876','618294','login','2025-03-04 11:15:00','2025-03-03 15:52:29'),(5,'13543218765','492738','register','2025-03-04 12:00:00','2025-03-03 15:52:29');
/*!40000 ALTER TABLE `sms_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stat_report`
--

DROP TABLE IF EXISTS `stat_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stat_report` (
  `report_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `report_type` enum('项目统计','案件统计','工资发放统计') NOT NULL,
  `report_period` enum('日报','周报','月报','年报') NOT NULL,
  `report_data` json NOT NULL COMMENT '统计结果数据',
  `generate_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `generated_by` bigint unsigned NOT NULL,
  PRIMARY KEY (`report_id`),
  KEY `generated_by` (`generated_by`),
  CONSTRAINT `stat_report_ibfk_1` FOREIGN KEY (`generated_by`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='统计报表存储表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stat_report`
--

LOCK TABLES `stat_report` WRITE;
/*!40000 ALTER TABLE `stat_report` DISABLE KEYS */;
INSERT INTO `stat_report` VALUES (1,'项目统计','月报','{\"ongoing\": 2, \"completed\": 0, \"total_projects\": 2}','2025-03-03 15:52:30',1),(2,'案件统计','周报','{\"pending\": 1, \"resolved\": 1, \"total_cases\": 2}','2025-03-03 15:52:30',1);
/*!40000 ALTER TABLE `stat_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_dict`
--

DROP TABLE IF EXISTS `sys_dict`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_dict` (
  `dict_id` int NOT NULL AUTO_INCREMENT,
  `dict_type` varchar(50) NOT NULL COMMENT '字典类型',
  `dict_code` varchar(50) NOT NULL COMMENT '字典编码',
  `dict_value` varchar(100) NOT NULL COMMENT '字典值',
  `sort_order` int DEFAULT '0' COMMENT '排序号',
  PRIMARY KEY (`dict_id`),
  UNIQUE KEY `uniq_type_code` (`dict_type`,`dict_code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='数据字典表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_dict`
--

LOCK TABLES `sys_dict` WRITE;
/*!40000 ALTER TABLE `sys_dict` DISABLE KEYS */;
INSERT INTO `sys_dict` VALUES (1,'role','admin','管理员',1),(2,'role','user','普通用户',2),(3,'case_status','pending','待受理',1),(4,'case_status','processing','处理中',2),(5,'case_status','completed','已办结',3);
/*!40000 ALTER TABLE `sys_dict` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_log`
--

DROP TABLE IF EXISTS `sys_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_log` (
  `log_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint unsigned NOT NULL,
  `module` varchar(50) NOT NULL COMMENT '操作模块',
  `operation_type` enum('新增','修改','删除','查询','导入','导出') NOT NULL,
  `operation_desc` varchar(500) DEFAULT NULL COMMENT '操作描述',
  `ip_address` varchar(50) DEFAULT NULL COMMENT '操作IP',
  `operation_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`log_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `sys_log_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统操作日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_log`
--

LOCK TABLES `sys_log` WRITE;
/*!40000 ALTER TABLE `sys_log` DISABLE KEYS */;
INSERT INTO `sys_log` VALUES (1,1,'用户管理','新增','添加新用户 user1','192.168.1.1','2025-03-03 15:52:30'),(2,3,'项目管理','修改','更新项目合同金额','192.168.1.2','2025-03-03 15:52:30');
/*!40000 ALTER TABLE `sys_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_notice`
--

DROP TABLE IF EXISTS `sys_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_notice` (
  `notice_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `content` text NOT NULL,
  `publisher_id` bigint unsigned NOT NULL,
  `publish_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`notice_id`),
  KEY `publisher_id` (`publisher_id`),
  CONSTRAINT `sys_notice_ibfk_1` FOREIGN KEY (`publisher_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统通知公告表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_notice`
--

LOCK TABLES `sys_notice` WRITE;
/*!40000 ALTER TABLE `sys_notice` DISABLE KEYS */;
INSERT INTO `sys_notice` VALUES (1,'系统维护公告','系统将于2025-03-10 00:00进行维护',1,'2025-03-03 15:52:30',NULL),(2,'工资发放通知','三月份工资已发放，请查收',3,'2025-03-03 15:52:30',NULL);
/*!40000 ALTER TABLE `sys_notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_permission`
--

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_permission` (
  `perm_id` int NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `perm_name` varchar(50) NOT NULL COMMENT '权限名称',
  `perm_key` varchar(100) NOT NULL COMMENT '权限标识（如system:user:list）',
  `menu_icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `component` varchar(200) DEFAULT NULL COMMENT '前端组件路径',
  PRIMARY KEY (`perm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (1,'用户管理','system:user:list','user','/user/list'),(2,'角色管理','system:role:list','role','/role/list'),(3,'项目管理','project:manage','project','/project/list'),(4,'案件管理','case:manage','case','/case/list'),(5,'工资发放','wage:payment','money','/wage/payment');
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role` (
  `role_id` int NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) NOT NULL COMMENT '角色名称',
  `role_key` varchar(50) NOT NULL COMMENT '角色标识',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'管理员','admin','系统管理员，具有所有权限'),(2,'普通用户','user','普通用户，具有基本访问权限'),(3,'项目经理','project_manager','负责项目的管理和审批'),(4,'案件管理员','case_manager','负责案件的受理和处理');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_perm`
--

DROP TABLE IF EXISTS `sys_role_perm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_role_perm` (
  `role_id` int NOT NULL,
  `perm_id` int NOT NULL,
  PRIMARY KEY (`role_id`,`perm_id`),
  KEY `perm_id` (`perm_id`),
  CONSTRAINT `sys_role_perm_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `sys_role_perm_ibfk_2` FOREIGN KEY (`perm_id`) REFERENCES `sys_permission` (`perm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_perm`
--

LOCK TABLES `sys_role_perm` WRITE;
/*!40000 ALTER TABLE `sys_role_perm` DISABLE KEYS */;
INSERT INTO `sys_role_perm` VALUES (1,1),(1,2),(1,3),(3,3),(1,4),(4,4),(1,5),(3,5);
/*!40000 ALTER TABLE `sys_role_perm` ENABLE KEYS */;
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
  `email` varchar(100) DEFAULT NULL COMMENT '电子邮箱',
  `real_name` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `role_id` int NOT NULL DEFAULT '2' COMMENT '角色ID（1-管理员 2-普通用户）',
  `department` varchar(100) DEFAULT NULL COMMENT '所属部门',
  `position` varchar(50) DEFAULT NULL COMMENT '职位',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `uniq_username` (`username`),
  KEY `idx_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','hashed_password','13800001111','admin@example.com','张伟',1,'系统管理','系统管理员','2025-03-03 15:52:29','2025-03-03 15:52:29'),(2,'user1','hashed_password','13900002222','user1@example.com','李娜',2,'工程部','普通用户','2025-03-03 15:52:29','2025-03-03 15:52:29'),(3,'pm1','hashed_password','13700003333','pm1@example.com','王强',3,'工程部','项目经理','2025-03-03 15:52:29','2025-03-03 15:52:29'),(4,'case_mgr','hashed_password','13600004444','case_mgr@example.com','赵敏',4,'法务部','案件管理员','2025-03-03 15:52:29','2025-03-03 15:52:29');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wage_payment`
--

DROP TABLE IF EXISTS `wage_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wage_payment` (
  `payment_id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `project_id` bigint unsigned NOT NULL,
  `worker_name` varchar(100) NOT NULL COMMENT '工人姓名',
  `id_card` varchar(20) NOT NULL COMMENT '身份证号',
  `payment_amount` decimal(15,2) NOT NULL COMMENT '发放金额',
  `payment_date` date NOT NULL COMMENT '发放日期',
  `payment_method` enum('银行转账','现金','其他') DEFAULT '银行转账',
  `payment_proof` bigint unsigned DEFAULT NULL COMMENT '支付凭证附件',
  PRIMARY KEY (`payment_id`),
  KEY `project_id` (`project_id`),
  KEY `payment_proof` (`payment_proof`),
  CONSTRAINT `wage_payment_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`project_id`),
  CONSTRAINT `wage_payment_ibfk_2` FOREIGN KEY (`payment_proof`) REFERENCES `attachment` (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='工资发放记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wage_payment`
--

LOCK TABLES `wage_payment` WRITE;
/*!40000 ALTER TABLE `wage_payment` DISABLE KEYS */;
INSERT INTO `wage_payment` VALUES (1,1,'赵四','110101199001011234',5000.00,'2025-03-01','银行转账',NULL),(2,2,'钱六','310101198802021234',4500.00,'2025-03-02','现金',NULL);
/*!40000 ALTER TABLE `wage_payment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-03 15:54:58
