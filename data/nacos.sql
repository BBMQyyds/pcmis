-- MySQL dump 10.13  Distrib 8.0.40, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nacos_config
-- ------------------------------------------------------
-- Server version	8.0.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `config_info`
--

DROP TABLE IF EXISTS `config_info`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info`
(
    `id`           bigint                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `data_id`      varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
    `group_id`     varchar(255) COLLATE utf8mb3_bin          DEFAULT NULL,
    `content`      longtext COLLATE utf8mb3_bin     NOT NULL COMMENT 'content',
    `md5`          varchar(32) COLLATE utf8mb3_bin           DEFAULT NULL COMMENT 'md5',
    `gmt_create`   datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `src_user`     text COLLATE utf8mb3_bin COMMENT 'source user',
    `src_ip`       varchar(50) COLLATE utf8mb3_bin           DEFAULT NULL COMMENT 'source ip',
    `app_name`     varchar(128) COLLATE utf8mb3_bin          DEFAULT NULL,
    `tenant_id`    varchar(128) COLLATE utf8mb3_bin          DEFAULT '' COMMENT '租户字段',
    `c_desc`       varchar(256) COLLATE utf8mb3_bin          DEFAULT NULL,
    `c_use`        varchar(64) COLLATE utf8mb3_bin           DEFAULT NULL,
    `effect`       varchar(64) COLLATE utf8mb3_bin           DEFAULT NULL,
    `type`         varchar(64) COLLATE utf8mb3_bin           DEFAULT NULL,
    `c_schema`     text COLLATE utf8mb3_bin,
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`, `group_id`, `tenant_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 82
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='config_info';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info`
--

LOCK TABLES `config_info` WRITE;
/*!40000 ALTER TABLE `config_info`
    DISABLE KEYS */;
INSERT INTO `config_info`
VALUES (3, 'pcmis-case.yaml', 'pcmis',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\n\nspring:\n  redis:\n    database: 0\n    port: 6379\n    host: localhost\n    password:\n    jedis:\n      pool:\n        max-active: 8\n        max-wait: -1\n        max-idle: 8\n        min-idle: 0\n    timeout: 1200\n    cache:\n      redis:\n        time-to-live: 1800s\n      cache-names: menus_cache\n      type: redis\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-case-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '8930caeec6ebca5aa6097a9e34d13452', '2025-03-01 04:25:43', '2025-03-03 02:05:29', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', '', '', '', 'yaml', ''),
       (5, 'pcmis-file.yaml', 'pcmis',
        'pcmis-file:\n  test:\n    admin: jdsbbmq-new-file\nspring:\n  redis:\n    database: 0\n    port: 6379\n    host: localhost\n    password:\n    jedis:\n      pool:\n        max-active: 8\n        max-wait: -1\n        max-idle: 8\n        min-idle: 0\n    timeout: 1200\n    cache:\n      redis:\n        time-to-live: 1800s\n      cache-names: menus_cache\n      type: redis\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-file-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        'df09eee2a55c464c69656663399db5d7', '2025-03-01 04:44:37', '2025-03-03 02:06:22', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', '', '', '', 'yaml', ''),
       (6, 'pcmis-visual.yaml', 'pcmis',
        'pcmis-visual:\n  test:\n    admin: jdsbbmq-new-visual\nspring:\n  redis:\n    database: 0\n    port: 6379\n    host: localhost\n    password:\n    jedis:\n      pool:\n        max-active: 8\n        max-wait: -1\n        max-idle: 8\n        min-idle: 0\n    timeout: 1200\n    cache:\n      redis:\n        time-to-live: 1800s\n      cache-names: menus_cache\n      type: redis\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-visual-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '1fc506f40ff9771cd71cfafe4de57db1', '2025-03-01 04:45:02', '2025-03-03 02:06:31', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', '', '', '', 'yaml', ''),
       (7, 'pcmis-project.yaml', 'pcmis',
        'pcmis-project:\n  test:\n    admin: jdsbbmq-new-project\nspring:\n  redis:\n    database: 0\n    port: 6379\n    host: localhost\n    password:\n    jedis:\n      pool:\n        max-active: 8\n        max-wait: -1\n        max-idle: 8\n        min-idle: 0\n    timeout: 1200\n    cache:\n      redis:\n        time-to-live: 1800s\n      cache-names: menus_cache\n      type: redis\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-project-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '7930e9d7e3c8dfeb364923d85d264c26', '2025-03-01 04:45:24', '2025-03-03 02:06:38', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', '', '', '', 'yaml', ''),
       (8, 'pcmis-risk.yaml', 'pcmis',
        'pcmis-risk:\n  test:\n    admin: jdsbbmq-new-risk\nspring:\n  redis:\n    database: 0\n    port: 6379\n    host: localhost\n    password:\n    jedis:\n      pool:\n        max-active: 8\n        max-wait: -1\n        max-idle: 8\n        min-idle: 0\n    timeout: 1200\n    cache:\n      redis:\n        time-to-live: 1800s\n      cache-names: menus_cache\n      type: redis\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-risk-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        'b3718990053c3b6e2e83b657ca7907bc', '2025-03-01 04:45:52', '2025-03-03 02:06:47', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', '', '', '', 'yaml', ''),
       (9, 'pcmis-security.yaml', 'pcmis',
        'pcmis-security:\n  test:\n    admin: jdsbbmq-new-security\nspring:\n  redis:\n    database: 0\n    port: 6379\n    host: localhost\n    password:\n    jedis:\n      pool:\n        max-active: 8\n        max-wait: -1\n        max-idle: 8\n        min-idle: 0\n    timeout: 1200\n    cache:\n      redis:\n        time-to-live: 1800s\n      cache-names: menus_cache\n      type: redis\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-security-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '42cea0beb9481932ed71726607322249', '2025-03-01 04:46:11', '2025-03-03 02:06:58', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', '', '', '', 'yaml', ''),
       (23, 'pcmis-user.yaml', 'pcmis',
        'pcmis-user:\n  test:\n    admin: jdsbbmq-new-user\nspring:\n  redis:\n    database: 0\n    port: 6379\n    host: localhost\n    password:\n    jedis:\n      pool:\n        max-active: 8\n        max-wait: -1\n        max-idle: 8\n        min-idle: 0\n    timeout: 1200\n    cache:\n      redis:\n        time-to-live: 1800s\n      cache-names: menus_cache\n      type: redis\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-user-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        'a03d315d865e7343214c98b8cbb6e883', '2025-03-01 05:51:32', '2025-03-03 02:07:09', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', '', '', '', 'yaml', ''),
       (26, 'gateway-routes', 'pcmis',
        '[\n    {\n        \"id\": \"pcmis-case\",\n        \"uri\": \"lb://pcmis-case\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/case/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-file\",\n        \"uri\": \"lb://pcmis-file\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/file/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-project\",\n        \"uri\": \"lb://pcmis-project\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/project/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-risk\",\n        \"uri\": \"lb://pcmis-risk\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/risk/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-security\",\n        \"uri\": \"lb://pcmis-security\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/security/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-user\",\n        \"uri\": \"lb://pcmis-user\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/testUser/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-visual\",\n        \"uri\": \"lb://pcmis-visual\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/visual/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    }\n]\n',
        '6f11ab221258beb07afdef075fd96e15', '2025-03-01 07:54:59', '2025-03-01 12:25:13', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', '', '', '', 'json', ''),
       (31, 'gateway-sentinel', 'pcmis',
        '[\n  {\n    \"resource\": \"pcmis-case\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 20,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-file\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 20,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-project\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 20,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-risk\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 20,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-security\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 20,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-user\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 20,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-visual\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 20,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  }\n]',
        '1331c0eb8174482bae8c48eff730156d', '2025-03-01 09:03:00', '2025-03-01 12:16:10', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', '', '', '', 'json', ''),
       (35, 'gateway-sentinel-flow', 'pcmis',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  }\r\n]',
        '3f5a544aae12faad39989ccef9a07f08', '2025-03-01 12:12:55', '2025-03-01 12:12:55', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', NULL, NULL, NULL, 'json', NULL),
       (36, 'gateway-sentinel-degrade', 'pcmis',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  }\r\n]',
        '895502cc353e46089a973916b23e8cd9', '2025-03-01 12:13:35', '2025-03-01 12:13:35', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', NULL, NULL, NULL, 'json', NULL),
       (37, 'gateway-sentinel-param', 'pcmis',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  }\r\n]',
        'a4ec8f430df6be7f86b62add8c500c86', '2025-03-01 12:14:22', '2025-03-01 12:14:22', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', NULL, NULL, NULL, 'json', NULL),
       (38, 'gateway-sentinel-system', 'pcmis',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  }\r\n]',
        '999af4db131cf2fe44c4d7a958e8b8a0', '2025-03-01 12:14:49', '2025-03-01 12:14:49', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', NULL, NULL, NULL, 'json', NULL),
       (39, 'gateway-sentinel-authority', 'pcmis',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  }\r\n]',
        '17bcf33104a735b26e92b449d66f367f', '2025-03-01 12:15:39', '2025-03-01 12:15:39', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', NULL, NULL, NULL, 'json', NULL),
       (43, 'pcmis-gateway.yaml', 'pcmis',
        'spring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n  cloud:\n    sentinel:\n      datasource:\n        flow-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-flow\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: flow\n        degrade-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-degrade\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: degrade\n        param-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-param\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: param-flow\n        authority-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-authority\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: authority\n    gateway:\n      routes:\n        config:\n          data-id: gateway-routes\n          group: pcmis\n          namespace: pcmis\n',
        '32090b563c4e24b0393dd91a8b1b360f', '2025-03-01 13:08:22', '2025-03-02 04:29:37', NULL, '0:0:0:0:0:0:0:1', '',
        'pcmis', '', '', '', 'yaml', '');
/*!40000 ALTER TABLE `config_info`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_info_aggr`
--

DROP TABLE IF EXISTS `config_info_aggr`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info_aggr`
(
    `id`           bigint                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `data_id`      varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
    `group_id`     varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
    `datum_id`     varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'datum_id',
    `content`      longtext COLLATE utf8mb3_bin     NOT NULL COMMENT '内容',
    `gmt_modified` datetime                         NOT NULL COMMENT '修改时间',
    `app_name`     varchar(128) COLLATE utf8mb3_bin DEFAULT NULL,
    `tenant_id`    varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT '租户字段',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_configinfoaggr_datagrouptenantdatum` (`data_id`, `group_id`, `tenant_id`, `datum_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='增加租户字段';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info_aggr`
--

LOCK TABLES `config_info_aggr` WRITE;
/*!40000 ALTER TABLE `config_info_aggr`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `config_info_aggr`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_info_beta`
--

DROP TABLE IF EXISTS `config_info_beta`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info_beta`
(
    `id`           bigint                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `data_id`      varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
    `group_id`     varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
    `app_name`     varchar(128) COLLATE utf8mb3_bin          DEFAULT NULL COMMENT 'app_name',
    `content`      longtext COLLATE utf8mb3_bin     NOT NULL COMMENT 'content',
    `beta_ips`     varchar(1024) COLLATE utf8mb3_bin         DEFAULT NULL COMMENT 'betaIps',
    `md5`          varchar(32) COLLATE utf8mb3_bin           DEFAULT NULL COMMENT 'md5',
    `gmt_create`   datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `src_user`     text COLLATE utf8mb3_bin COMMENT 'source user',
    `src_ip`       varchar(50) COLLATE utf8mb3_bin           DEFAULT NULL COMMENT 'source ip',
    `tenant_id`    varchar(128) COLLATE utf8mb3_bin          DEFAULT '' COMMENT '租户字段',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_configinfobeta_datagrouptenant` (`data_id`, `group_id`, `tenant_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='config_info_beta';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info_beta`
--

LOCK TABLES `config_info_beta` WRITE;
/*!40000 ALTER TABLE `config_info_beta`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `config_info_beta`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_info_tag`
--

DROP TABLE IF EXISTS `config_info_tag`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_info_tag`
(
    `id`           bigint                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `data_id`      varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
    `group_id`     varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
    `tenant_id`    varchar(128) COLLATE utf8mb3_bin          DEFAULT '' COMMENT 'tenant_id',
    `tag_id`       varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_id',
    `app_name`     varchar(128) COLLATE utf8mb3_bin          DEFAULT NULL COMMENT 'app_name',
    `content`      longtext COLLATE utf8mb3_bin     NOT NULL COMMENT 'content',
    `md5`          varchar(32) COLLATE utf8mb3_bin           DEFAULT NULL COMMENT 'md5',
    `gmt_create`   datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    `src_user`     text COLLATE utf8mb3_bin COMMENT 'source user',
    `src_ip`       varchar(50) COLLATE utf8mb3_bin           DEFAULT NULL COMMENT 'source ip',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_configinfotag_datagrouptenanttag` (`data_id`, `group_id`, `tenant_id`, `tag_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='config_info_tag';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_info_tag`
--

LOCK TABLES `config_info_tag` WRITE;
/*!40000 ALTER TABLE `config_info_tag`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `config_info_tag`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config_tags_relation`
--

DROP TABLE IF EXISTS `config_tags_relation`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `config_tags_relation`
(
    `id`        bigint                           NOT NULL COMMENT 'id',
    `tag_name`  varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'tag_name',
    `tag_type`  varchar(64) COLLATE utf8mb3_bin  DEFAULT NULL COMMENT 'tag_type',
    `data_id`   varchar(255) COLLATE utf8mb3_bin NOT NULL COMMENT 'data_id',
    `group_id`  varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'group_id',
    `tenant_id` varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
    `nid`       bigint                           NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`nid`),
    UNIQUE KEY `uk_configtagrelation_configidtag` (`id`, `tag_name`, `tag_type`),
    KEY `idx_tenant_id` (`tenant_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='config_tag_relation';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config_tags_relation`
--

LOCK TABLES `config_tags_relation` WRITE;
/*!40000 ALTER TABLE `config_tags_relation`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `config_tags_relation`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_capacity`
--

DROP TABLE IF EXISTS `group_capacity`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_capacity`
(
    `id`                bigint unsigned                  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `group_id`          varchar(128) COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Group ID，空字符表示整个集群',
    `quota`             int unsigned                     NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
    `usage`             int unsigned                     NOT NULL DEFAULT '0' COMMENT '使用量',
    `max_size`          int unsigned                     NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
    `max_aggr_count`    int unsigned                     NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数，，0表示使用默认值',
    `max_aggr_size`     int unsigned                     NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
    `max_history_count` int unsigned                     NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
    `gmt_create`        datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`      datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_group_id` (`group_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='集群、各Group容量信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_capacity`
--

LOCK TABLES `group_capacity` WRITE;
/*!40000 ALTER TABLE `group_capacity`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `group_capacity`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `his_config_info`
--

DROP TABLE IF EXISTS `his_config_info`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `his_config_info`
(
    `id`           bigint unsigned                  NOT NULL,
    `nid`          bigint unsigned                  NOT NULL AUTO_INCREMENT,
    `data_id`      varchar(255) COLLATE utf8mb3_bin NOT NULL,
    `group_id`     varchar(128) COLLATE utf8mb3_bin NOT NULL,
    `app_name`     varchar(128) COLLATE utf8mb3_bin          DEFAULT NULL COMMENT 'app_name',
    `content`      longtext COLLATE utf8mb3_bin     NOT NULL,
    `md5`          varchar(32) COLLATE utf8mb3_bin           DEFAULT NULL,
    `gmt_create`   datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `gmt_modified` datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `src_user`     text COLLATE utf8mb3_bin,
    `src_ip`       varchar(50) COLLATE utf8mb3_bin           DEFAULT NULL,
    `op_type`      char(10) COLLATE utf8mb3_bin              DEFAULT NULL,
    `tenant_id`    varchar(128) COLLATE utf8mb3_bin          DEFAULT '' COMMENT '租户字段',
    PRIMARY KEY (`nid`),
    KEY `idx_gmt_create` (`gmt_create`),
    KEY `idx_gmt_modified` (`gmt_modified`),
    KEY `idx_did` (`data_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 86
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='多租户改造';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `his_config_info`
--

LOCK TABLES `his_config_info` WRITE;
/*!40000 ALTER TABLE `his_config_info`
    DISABLE KEYS */;
INSERT INTO `his_config_info`
VALUES (0, 1, 'pcmis-case', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    userId: pcmis123456',
        '4a5b79d637528a52a90d32e4d41cf6d3', '2025-03-01 12:19:59', '2025-03-01 04:20:00', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (1, 2, 'pcmis-case', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    userId: pcmis123456',
        '4a5b79d637528a52a90d32e4d41cf6d3', '2025-03-01 12:22:28', '2025-03-01 04:22:28', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (1, 3, 'pcmis-case', 'pcmis', '', 'pcmis-case:\n  test:\n    admin: jdsbbmq', '5a92b7a4dcd28cfd198d4ae0e407682b',
        '2025-03-01 12:25:16', '2025-03-01 04:25:17', NULL, '0:0:0:0:0:0:0:1', 'D', 'pcmis'),
       (0, 4, 'pcmis-case.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq',
        '50aa90fcac83f25ddfdbe387f404414a', '2025-03-01 12:25:42', '2025-03-01 04:25:43', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (3, 5, 'pcmis-case.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq',
        '50aa90fcac83f25ddfdbe387f404414a', '2025-03-01 12:35:43', '2025-03-01 04:35:44', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (0, 6, 'pcmis-file.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq-new',
        '7102c8372006553164230423018712e5', '2025-03-01 12:44:37', '2025-03-01 04:44:37', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (0, 7, 'pcmis-visual.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq-new',
        '7102c8372006553164230423018712e5', '2025-03-01 12:45:02', '2025-03-01 04:45:02', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (0, 8, 'pcmis-project.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq-new',
        '7102c8372006553164230423018712e5', '2025-03-01 12:45:24', '2025-03-01 04:45:24', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (0, 9, 'pcmis-risk.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq-new',
        '7102c8372006553164230423018712e5', '2025-03-01 12:45:51', '2025-03-01 04:45:52', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (0, 10, 'pcmis-security.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq-new',
        '7102c8372006553164230423018712e5', '2025-03-01 12:46:10', '2025-03-01 04:46:11', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (3, 11, 'pcmis-case.yaml', 'pcmis', '', 'pcmis-case:\n  test:\n    admin: jdsbbmq-new',
        '3eb3a3d30f5362cdf3646b222c875675', '2025-03-01 12:55:00', '2025-03-01 04:55:01', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (5, 12, 'pcmis-file.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq-new',
        '7102c8372006553164230423018712e5', '2025-03-01 12:55:09', '2025-03-01 04:55:10', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (6, 13, 'pcmis-visual.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq-new',
        '7102c8372006553164230423018712e5', '2025-03-01 12:55:18', '2025-03-01 04:55:19', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (7, 14, 'pcmis-project.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq-new',
        '7102c8372006553164230423018712e5', '2025-03-01 12:55:28', '2025-03-01 04:55:29', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (8, 15, 'pcmis-risk.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq-new',
        '7102c8372006553164230423018712e5', '2025-03-01 12:55:37', '2025-03-01 04:55:37', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (9, 16, 'pcmis-security.yaml', 'pcmis', '', 'pcmis-case:\r\n  test:\r\n    admin: jdsbbmq-new',
        '7102c8372006553164230423018712e5', '2025-03-01 12:55:46', '2025-03-01 04:55:46', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (5, 17, 'pcmis-file.yaml', 'pcmis', '', 'pcmis-case:\n  test:\n    admin: jdsbbmq-new-file',
        '7aa67a38af3e642ba0421d160b9f8f7f', '2025-03-01 13:27:28', '2025-03-01 05:27:28', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (6, 18, 'pcmis-visual.yaml', 'pcmis', '', 'pcmis-case:\n  test:\n    admin: jdsbbmq-new-visual',
        '8fa5ee58a0f0044dc237ede49e98e83c', '2025-03-01 13:27:39', '2025-03-01 05:27:40', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (7, 19, 'pcmis-project.yaml', 'pcmis', '', 'pcmis-case:\n  test:\n    admin: jdsbbmq-new-project',
        '2e2b1212884dc7ba90aec2fec0998e18', '2025-03-01 13:27:50', '2025-03-01 05:27:50', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (8, 20, 'pcmis-risk.yaml', 'pcmis', '', 'pcmis-case:\n  test:\n    admin: jdsbbmq-new-risk',
        '2448971967168c0d633eb2612fe635b7', '2025-03-01 13:27:58', '2025-03-01 05:27:58', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (9, 21, 'pcmis-security.yaml', 'pcmis', '', 'pcmis-case:\n  test:\n    admin: jdsbbmq-new-security',
        'b85c9922c7af5d2286147bbd4fe05260', '2025-03-01 13:28:11', '2025-03-01 05:28:12', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (0, 22, 'pcmis-user', 'pcmis', '', 'pcmis-user:\r\n  test:\r\n    admin: jdsbbmq-new-user',
        '783818fdf2688782c3828df2986e9324', '2025-03-01 13:28:33', '2025-03-01 05:28:34', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (21, 23, 'pcmis-user', 'pcmis', '', 'pcmis-user:\r\n  test:\r\n    admin: jdsbbmq-new-user',
        '783818fdf2688782c3828df2986e9324', '2025-03-01 13:28:43', '2025-03-01 05:28:43', NULL, '0:0:0:0:0:0:0:1', 'D',
        'pcmis'),
       (0, 24, 'pcmis-ser.yaml', 'pcmis', '', 'pcmis-user:\r\n  test:\r\n    admin: jdsbbmq-new-user',
        '783818fdf2688782c3828df2986e9324', '2025-03-01 13:29:01', '2025-03-01 05:29:02', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (22, 25, 'pcmis-ser.yaml', 'pcmis', '', 'pcmis-user:\r\n  test:\r\n    admin: jdsbbmq-new-user',
        '783818fdf2688782c3828df2986e9324', '2025-03-01 13:51:06', '2025-03-01 05:51:07', NULL, '0:0:0:0:0:0:0:1', 'D',
        'pcmis'),
       (0, 26, 'pcmis-user.yaml', 'pcmis', '', 'pcmis-user:\r\n  test:\r\n    admin: jdsbbmq-new-user',
        '783818fdf2688782c3828df2986e9324', '2025-03-01 13:51:32', '2025-03-01 05:51:32', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (3, 27, 'pcmis-case.yaml', 'pcmis', '', 'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case',
        'dee1142360b0914083b627b74385ff25', '2025-03-01 14:36:58', '2025-03-01 06:36:59', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 28, 'pcmis-case.yaml', 'pcmis', '', 'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case11',
        'e582b735ffa6c0a2375242820a4c10e5', '2025-03-01 14:37:10', '2025-03-01 06:37:10', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (0, 29, 'gateway-routes', 'pcmis', '',
        '[\r\n    {\r\n        \"id\": \"pcmis-case\",\r\n        \"uri\": \"lb://pcmis-case\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/case/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-file\",\r\n        \"uri\": \"lb://pcmis-file\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/file/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-project\",\r\n        \"uri\": \"lb://pcmis-project\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/project/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-risk\",\r\n        \"uri\": \"lb://pcmis-risk\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/risk/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-security\",\r\n        \"uri\": \"lb://pcmis-security\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/security/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-user\",\r\n        \"uri\": \"lb://pcmis-user\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/user/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-visual\",\r\n        \"uri\": \"lb://pcmis-visual\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/visual/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    }\r\n]\r\n',
        '5bea2da5abd413cfc50bb3b81d4407be', '2025-03-01 15:54:59', '2025-03-01 07:54:59', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (26, 30, 'gateway-routes', 'pcmis', '',
        '[\r\n    {\r\n        \"id\": \"pcmis-case\",\r\n        \"uri\": \"lb://pcmis-case\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/case/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-file\",\r\n        \"uri\": \"lb://pcmis-file\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/file/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-project\",\r\n        \"uri\": \"lb://pcmis-project\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/project/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-risk\",\r\n        \"uri\": \"lb://pcmis-risk\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/risk/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-security\",\r\n        \"uri\": \"lb://pcmis-security\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/security/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-user\",\r\n        \"uri\": \"lb://pcmis-user\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/user/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    },\r\n    {\r\n        \"id\": \"pcmis-visual\",\r\n        \"uri\": \"lb://pcmis-visual\",\r\n        \"predicates\": [\r\n            {\r\n                \"args\": {\r\n                    \"pattern\": \"/visual/**\"\r\n                },\r\n                \"name\": \"Path\"\r\n            }\r\n        ]\r\n    }\r\n]\r\n',
        '5bea2da5abd413cfc50bb3b81d4407be', '2025-03-01 16:10:59', '2025-03-01 08:11:00', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (26, 31, 'gateway-routes', 'pcmis', '',
        '[\n    {\n        \"id\": \"pcmis-case\",\n        \"uri\": \"lb://pcmis-case\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/case/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-file\",\n        \"uri\": \"lb://pcmis-file\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/file/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-project\",\n        \"uri\": \"lb://pcmis-project\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/project/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-risk\",\n        \"uri\": \"lb://pcmis-risk\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/risk/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-security\",\n        \"uri\": \"lb://pcmis-security\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/security/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-user\",\n        \"uri\": \"lb://pcmis-user\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/testUser/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-visual\",\n        \"uri\": \"lb://pcmis-visual\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/visual/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    }\n]\n',
        '6f11ab221258beb07afdef075fd96e15', '2025-03-01 16:11:51', '2025-03-01 08:11:52', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (26, 32, 'gateway-routes', 'pcmis', '',
        '[\n    {\n        \"id\": \"pcmis-case\",\n        \"uri\": \"lb://pcmis-case\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/case/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-file\",\n        \"uri\": \"lb://pcmis-file\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/file/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-project\",\n        \"uri\": \"lb://pcmis-project\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/project/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-risk\",\n        \"uri\": \"lb://pcmis-risk\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/risk/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-security\",\n        \"uri\": \"lb://pcmis-security\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/security/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-user\",\n        \"uri\": \"lb://pcmis-user\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/user/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-visual\",\n        \"uri\": \"lb://pcmis-visual\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/visual/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    }\n]\n',
        '153c16a19a1d2990eaf084d374decd23', '2025-03-01 16:31:48', '2025-03-01 08:31:48', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (26, 33, 'gateway-routes', 'pcmis', '',
        '[\n    {\n        \"id\": \"pcmis-case\",\n        \"uri\": \"lb://pcmis-case\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/case/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-file\",\n        \"uri\": \"lb://pcmis-file\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/file/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-project\",\n        \"uri\": \"lb://pcmis-project\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/project/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-risk\",\n        \"uri\": \"lb://pcmis-risk\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/risk/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-security\",\n        \"uri\": \"lb://pcmis-security\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/security/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-user\",\n        \"uri\": \"lb://pcmis-user\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/testUser/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-visual\",\n        \"uri\": \"lb://pcmis-visual\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/visual/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    }\n]\n',
        '6f11ab221258beb07afdef075fd96e15', '2025-03-01 16:32:36', '2025-03-01 08:32:36', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (0, 34, 'gateway-sentinel', 'pcmis', '',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  }\r\n]\r\n',
        '7ef3a5cf9e1a0897daa96293c1e7b6c2', '2025-03-01 17:02:59', '2025-03-01 09:03:00', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (26, 35, 'gateway-routes', 'pcmis', '',
        '[\n    {\n        \"id\": \"pcmis-case\",\n        \"uri\": \"lb://pcmis-case\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/case/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-file\",\n        \"uri\": \"lb://pcmis-file\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/file/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-project\",\n        \"uri\": \"lb://pcmis-project\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/project/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-risk\",\n        \"uri\": \"lb://pcmis-risk\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/risk/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-security\",\n        \"uri\": \"lb://pcmis-security\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/security/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-user\",\n        \"uri\": \"lb://pcmis-user\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/user/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-visual\",\n        \"uri\": \"lb://pcmis-visual\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/visual/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    }\n]\n',
        '153c16a19a1d2990eaf084d374decd23', '2025-03-01 19:23:35', '2025-03-01 11:23:35', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (31, 36, 'gateway-sentinel', 'pcmis', '',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 10,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  }\r\n]\r\n',
        '7ef3a5cf9e1a0897daa96293c1e7b6c2', '2025-03-01 19:48:41', '2025-03-01 11:48:41', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (26, 37, 'gateway-routes', 'pcmis', '',
        '[\n    {\n        \"id\": \"pcmis-case\",\n        \"uri\": \"lb://pcmis-case\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/case/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-file\",\n        \"uri\": \"lb://pcmis-file\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/file/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-project\",\n        \"uri\": \"lb://pcmis-project\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/project/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-risk\",\n        \"uri\": \"lb://pcmis-risk\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/risk/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-security\",\n        \"uri\": \"lb://pcmis-security\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/security/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-user\",\n        \"uri\": \"lb://pcmis-user\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/testUser/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-visual\",\n        \"uri\": \"lb://pcmis-visual\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/visual/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    }\n]\n',
        '6f11ab221258beb07afdef075fd96e15', '2025-03-01 20:06:14', '2025-03-01 12:06:14', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (0, 38, 'gateway-sentinel-flow', 'pcmis', '',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"limitApp\": \"default\",\r\n    \"grade\": 1,\r\n    \"count\": 20,\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0,\r\n    \"clusterMode\": false\r\n  }\r\n]',
        '3f5a544aae12faad39989ccef9a07f08', '2025-03-01 20:12:55', '2025-03-01 12:12:55', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (0, 39, 'gateway-sentinel-degrade', 'pcmis', '',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"count\": 100,\r\n    \"grade\": 0,\r\n    \"timeWindow\": 10,\r\n    \"maxQueueingTimeMs\": 500\r\n  }\r\n]',
        '895502cc353e46089a973916b23e8cd9', '2025-03-01 20:13:34', '2025-03-01 12:13:35', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (0, 40, 'gateway-sentinel-param', 'pcmis', '',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"paramIdx\": 0,\r\n    \"count\": 50,\r\n    \"burst\": 20,\r\n    \"limitApp\": \"default\"\r\n  }\r\n]',
        'a4ec8f430df6be7f86b62add8c500c86', '2025-03-01 20:14:22', '2025-03-01 12:14:22', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (0, 41, 'gateway-sentinel-system', 'pcmis', '',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"grade\": 0,\r\n    \"count\": 100,\r\n    \"timeWindow\": 60\r\n  }\r\n]',
        '999af4db131cf2fe44c4d7a958e8b8a0', '2025-03-01 20:14:48', '2025-03-01 12:14:49', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (0, 42, 'gateway-sentinel-authority', 'pcmis', '',
        '[\r\n  {\r\n    \"resource\": \"pcmis-case\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-file\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-project\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-risk\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-security\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-user\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  },\r\n  {\r\n    \"resource\": \"pcmis-visual\",\r\n    \"limitApp\": \"default\",\r\n    \"strategy\": 0,\r\n    \"controlBehavior\": 0\r\n  }\r\n]',
        '17bcf33104a735b26e92b449d66f367f', '2025-03-01 20:15:38', '2025-03-01 12:15:39', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (31, 43, 'gateway-sentinel', 'pcmis', '',
        '[\n  {\n    \"resource\": \"pcmis-case\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 100,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-file\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 100,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-project\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 100,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-risk\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 100,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-security\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 100,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-user\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 100,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  },\n  {\n    \"resource\": \"pcmis-visual\",\n    \"limitApp\": \"default\",\n    \"grade\": 1,\n    \"count\": 100,\n    \"strategy\": 0,\n    \"controlBehavior\": 0,\n    \"clusterMode\": false\n  }\n]\n',
        'e91b6fb6ff314a93b132cac7a4bf04ba', '2025-03-01 20:16:10', '2025-03-01 12:16:10', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (26, 44, 'gateway-routes', 'pcmis', '',
        '[\n    {\n        \"id\": \"pcmis-case\",\n        \"uri\": \"lb://pcmis-case\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/case/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-file\",\n        \"uri\": \"lb://pcmis-file\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/file/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-project\",\n        \"uri\": \"lb://pcmis-project\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/project/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-risk\",\n        \"uri\": \"lb://pcmis-risk\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/risk/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-security\",\n        \"uri\": \"lb://pcmis-security\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/security/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-user\",\n        \"uri\": \"lb://pcmis-user\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/user/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    },\n    {\n        \"id\": \"pcmis-visual\",\n        \"uri\": \"lb://pcmis-visual\",\n        \"predicates\": [\n            {\n                \"args\": {\n                    \"pattern\": \"/visual/**\"\n                },\n                \"name\": \"Path\"\n            }\n        ]\n    }\n]\n',
        '153c16a19a1d2990eaf084d374decd23', '2025-03-01 20:25:12', '2025-03-01 12:25:13', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (0, 45, 'pcmis-gateway', 'pcmis', '',
        'spring:\r\n  cloud:\r\n    sentinel:\r\n      datasource:\r\n        flow-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-flow\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: flow\r\n        degrade-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-degrade\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: degrade\r\n        param-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-param\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: param-flow\r\n        authority-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-authority\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: authority\r\n    gateway:\r\n      routes:\r\n        config:\r\n          data-id: gateway-routes\r\n          group: pcmis\r\n          namespace: pcmis\r\n          # 路由规则应当放在 Nacos 上，以便动态配置路由\r\n',
        '52b590f9bffb2b4025d89c88698bd2b9', '2025-03-01 21:06:42', '2025-03-01 13:06:42', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (42, 46, 'pcmis-gateway', 'pcmis', '',
        'spring:\r\n  cloud:\r\n    sentinel:\r\n      datasource:\r\n        flow-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-flow\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: flow\r\n        degrade-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-degrade\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: degrade\r\n        param-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-param\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: param-flow\r\n        authority-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-authority\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: authority\r\n    gateway:\r\n      routes:\r\n        config:\r\n          data-id: gateway-routes\r\n          group: pcmis\r\n          namespace: pcmis\r\n          # 路由规则应当放在 Nacos 上，以便动态配置路由\r\n',
        '52b590f9bffb2b4025d89c88698bd2b9', '2025-03-01 21:08:00', '2025-03-01 13:08:01', NULL, '0:0:0:0:0:0:0:1', 'D',
        'pcmis'),
       (0, 47, 'pcmis-gateway.yaml', 'pcmis', '',
        'spring:\r\n  cloud:\r\n    sentinel:\r\n      datasource:\r\n        flow-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-flow\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: flow\r\n        degrade-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-degrade\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: degrade\r\n        param-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-param\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: param-flow\r\n        authority-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-authority\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: authority\r\n    gateway:\r\n      routes:\r\n        config:\r\n          data-id: gateway-routes\r\n          group: pcmis\r\n          namespace: pcmis\r\n',
        '0ee82e16b4d42a8ca732a2ccfc09f4e7', '2025-03-01 21:08:21', '2025-03-01 13:08:22', NULL, '0:0:0:0:0:0:0:1', 'I',
        'pcmis'),
       (43, 48, 'pcmis-gateway.yaml', 'pcmis', '',
        'spring:\r\n  cloud:\r\n    sentinel:\r\n      datasource:\r\n        flow-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-flow\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: flow\r\n        degrade-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-degrade\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: degrade\r\n        param-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-param\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: param-flow\r\n        authority-control:\r\n          nacos:\r\n            username: nacos\r\n            password: 2003\r\n            server-addr: localhost:8848\r\n            data-id: gateway-sentinel-authority\r\n            data-type: json\r\n            group-id: pcmis\r\n            namespace: pcmis\r\n            rule-type: authority\r\n    gateway:\r\n      routes:\r\n        config:\r\n          data-id: gateway-routes\r\n          group: pcmis\r\n          namespace: pcmis\r\n',
        '0ee82e16b4d42a8ca732a2ccfc09f4e7', '2025-03-01 21:14:05', '2025-03-01 13:14:05', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (43, 49, 'pcmis-gateway.yaml', 'pcmis', '',
        'spring:\n  cloud:\n    sentinel:\n      datasource:\n        \n        degrade-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-degrade\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: degrade\n        param-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-param\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: param-flow\n        authority-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-authority\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: authority\n    gateway:\n      routes:\n        config:\n          data-id: gateway-routes\n          group: pcmis\n          namespace: pcmis\n',
        '55685e2fc854c06fd96ab3f8319712a0', '2025-03-01 21:14:40', '2025-03-01 13:14:40', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 50, 'pcmis-case.yaml', 'pcmis', '', 'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case',
        'dee1142360b0914083b627b74385ff25', '2025-03-02 08:10:53', '2025-03-02 00:10:53', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 51, 'pcmis-case.yaml', 'pcmis', '',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource',
        '223b307a55f048bab60509610fd4aa52', '2025-03-02 08:13:20', '2025-03-02 00:13:21', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 52, 'pcmis-case.yaml', 'pcmis', '',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n    initialSize: 5\n    minIdle: 5\n    maxActive: 20\n    maxWait: 60000\n    timeBetweenEvictionRunsMillis: 60000\n    minEvictableIdleTimeMillis: 300000\n    validationQuery: SELECT 1 FROM DUAL\n    testWhileIdle: true\n    testOnBorrow: false\n    testOnReturn: false\n    poolPreparedStatements: true\n    maxPoolPreparedStatementPerConnectionSize: 20\n    useGlobalDataSourceStat: true\n    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500\n    filters: stat,wall,log4j',
        '4c260820cd8f3e8760938d15fa9f0091', '2025-03-02 08:16:24', '2025-03-02 00:16:24', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 53, 'pcmis-case.yaml', 'pcmis', '',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n    initialSize: 5\n    minIdle: 5\n    maxActive: 20\n    maxWait: 60000\n    timeBetweenEvictionRunsMillis: 60000\n    minEvictableIdleTimeMillis: 300000\n    validationQuery: SELECT 1 FROM DUAL\n    testWhileIdle: true\n    testOnBorrow: false\n    testOnReturn: false\n    poolPreparedStatements: true\n    maxPoolPreparedStatementPerConnectionSize: 20\n    useGlobalDataSourceStat: true\n    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500\n    filters: stat,wall,log4j',
        '4c260820cd8f3e8760938d15fa9f0091', '2025-03-02 08:17:22', '2025-03-02 00:17:22', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 54, 'pcmis-case.yaml', 'pcmis', '',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource',
        '223b307a55f048bab60509610fd4aa52', '2025-03-02 08:17:50', '2025-03-02 00:17:50', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 55, 'pcmis-case.yaml', 'pcmis', '',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n    initialSize: 5\n    minIdle: 5\n    maxActive: 20\n    maxWait: 60000\n    timeBetweenEvictionRunsMillis: 60000\n    minEvictableIdleTimeMillis: 300000\n    validationQuery: SELECT 1 FROM DUAL\n    testWhileIdle: true\n    testOnBorrow: false\n    testOnReturn: false\n    poolPreparedStatements: true\n    maxPoolPreparedStatementPerConnectionSize: 20\n    useGlobalDataSourceStat: true\n    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500\n    filters: stat,wall,log4j',
        '4c260820cd8f3e8760938d15fa9f0091', '2025-03-02 08:34:36', '2025-03-02 00:34:37', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 56, 'pcmis-case.yaml', 'pcmis', '',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n    initialSize: 5\n    minIdle: 5\n    maxActive: 20\n    maxWait: 60000\n    timeBetweenEvictionRunsMillis: 60000\n    minEvictableIdleTimeMillis: 300000\n    validationQuery: SELECT 1 FROM DUAL\n    testWhileIdle: true\n    testOnBorrow: false\n    testOnReturn: false\n    poolPreparedStatements: true\n    maxPoolPreparedStatementPerConnectionSize: 20\n    useGlobalDataSourceStat: true\n    connectionProperties: druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500\n    filters: stat,wall',
        '596cfaa10d0ea4c885531fa2bfa7ba9e', '2025-03-02 08:52:42', '2025-03-02 00:52:43', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 57, 'pcmis-case.yaml', 'pcmis', '',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource',
        '223b307a55f048bab60509610fd4aa52', '2025-03-02 11:00:32', '2025-03-02 03:00:33', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (5, 58, 'pcmis-file.yaml', 'pcmis', '', 'pcmis-file:\n  test:\n    admin: jdsbbmq-new-file',
        '515f76363c545bcb219baa3383490492', '2025-03-02 12:28:37', '2025-03-02 04:28:38', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (6, 59, 'pcmis-visual.yaml', 'pcmis', '', 'pcmis-visual:\n  test:\n    admin: jdsbbmq-new-visual',
        '46668f0573fde461e0a5db2fd1fa1c6e', '2025-03-02 12:28:45', '2025-03-02 04:28:45', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (7, 60, 'pcmis-project.yaml', 'pcmis', '', 'pcmis-project:\n  test:\n    admin: jdsbbmq-new-project',
        'bd543d952eeed77b7c40fc95bc28b937', '2025-03-02 12:28:53', '2025-03-02 04:28:53', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (8, 61, 'pcmis-risk.yaml', 'pcmis', '', 'pcmis-risk:\n  test:\n    admin: jdsbbmq-new-risk',
        'b1ce834deac1e7ce741eaed44dd4a05d', '2025-03-02 12:29:02', '2025-03-02 04:29:03', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (9, 62, 'pcmis-security.yaml', 'pcmis', '', 'pcmis-security:\n  test:\n    admin: jdsbbmq-new-security',
        '9fe5bdcb17fb3c589243db1198375e6a', '2025-03-02 12:29:10', '2025-03-02 04:29:10', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (23, 63, 'pcmis-user.yaml', 'pcmis', '', 'pcmis-user:\r\n  test:\r\n    admin: jdsbbmq-new-user',
        '783818fdf2688782c3828df2986e9324', '2025-03-02 12:29:17', '2025-03-02 04:29:18', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (43, 64, 'pcmis-gateway.yaml', 'pcmis', '',
        'spring:\n  cloud:\n    sentinel:\n      datasource:\n        flow-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-flow\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: flow\n        degrade-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-degrade\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: degrade\n        param-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-param\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: param-flow\n        authority-control:\n          nacos:\n            username: nacos\n            password: 2003\n            server-addr: localhost:8848\n            data-id: gateway-sentinel-authority\n            data-type: json\n            group-id: pcmis\n            namespace: pcmis\n            rule-type: authority\n    gateway:\n      routes:\n        config:\n          data-id: gateway-routes\n          group: pcmis\n          namespace: pcmis\n',
        'aef16212295cbcd760d67090067bb87a', '2025-03-02 12:29:37', '2025-03-02 04:29:37', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 65, 'pcmis-case.yaml', 'pcmis', '',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource',
        '223b307a55f048bab60509610fd4aa52', '2025-03-02 12:50:53', '2025-03-02 04:50:53', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (5, 66, 'pcmis-file.yaml', 'pcmis', '',
        'pcmis-file:\n  test:\n    admin: jdsbbmq-new-file\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource',
        '7405fb73c9cf8c736f4e6a0713aaac71', '2025-03-02 12:52:00', '2025-03-02 04:52:00', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (6, 67, 'pcmis-visual.yaml', 'pcmis', '',
        'pcmis-visual:\n  test:\n    admin: jdsbbmq-new-visual\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource',
        '7c133f9dd99693f783b8fbb774559150', '2025-03-02 12:52:09', '2025-03-02 04:52:10', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (7, 68, 'pcmis-project.yaml', 'pcmis', '',
        'pcmis-project:\n  test:\n    admin: jdsbbmq-new-project\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource',
        'b04a085df50420787ee2b7b87557a645', '2025-03-02 12:52:18', '2025-03-02 04:52:19', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (8, 69, 'pcmis-risk.yaml', 'pcmis', '',
        'pcmis-risk:\n  test:\n    admin: jdsbbmq-new-risk\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource',
        '465dffc4030c6a15acfab829319eedeb', '2025-03-02 12:52:31', '2025-03-02 04:52:31', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (9, 70, 'pcmis-security.yaml', 'pcmis', '',
        'pcmis-security:\n  test:\n    admin: jdsbbmq-new-security\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource',
        '23e84fe300230f9ac11783eaf2b5cef8', '2025-03-02 12:52:39', '2025-03-02 04:52:40', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (23, 71, 'pcmis-user.yaml', 'pcmis', '',
        'pcmis-user:\n  test:\n    admin: jdsbbmq-new-user\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource',
        '95ccc51e45a52f093e53956194ffffbc', '2025-03-02 12:53:02', '2025-03-02 04:53:03', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 72, 'pcmis-case.yaml', 'pcmis', '',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\n\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '4d8467332e4a524343df58a20269a868', '2025-03-02 13:22:59', '2025-03-02 05:22:59', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (5, 73, 'pcmis-file.yaml', 'pcmis', '',
        'pcmis-file:\n  test:\n    admin: jdsbbmq-new-file\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '52c0b6bcf0fb6691ed8cfef7cb58ba1f', '2025-03-02 13:23:22', '2025-03-02 05:23:23', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (6, 74, 'pcmis-visual.yaml', 'pcmis', '',
        'pcmis-visual:\n  test:\n    admin: jdsbbmq-new-visual\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '05e1bd272e2f5f18524006b6c66be3c4', '2025-03-02 13:23:36', '2025-03-02 05:23:36', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (7, 75, 'pcmis-project.yaml', 'pcmis', '',
        'pcmis-project:\n  test:\n    admin: jdsbbmq-new-project\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '674a5ce270f13bb492c81c6cdad3145e', '2025-03-02 13:23:53', '2025-03-02 05:23:53', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (8, 76, 'pcmis-risk.yaml', 'pcmis', '',
        'pcmis-risk:\n  test:\n    admin: jdsbbmq-new-risk\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        'b52ba72a09a9f254c3578727c185948c', '2025-03-02 13:24:04', '2025-03-02 05:24:05', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (9, 77, 'pcmis-security.yaml', 'pcmis', '',
        'pcmis-security:\n  test:\n    admin: jdsbbmq-new-security\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '5be38815a6a616955778610db61fdf9c', '2025-03-02 13:24:29', '2025-03-02 05:24:29', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (23, 78, 'pcmis-user.yaml', 'pcmis', '',
        'pcmis-user:\n  test:\n    admin: jdsbbmq-new-user\nspring:\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '11717fb6ea5bd9fc6b2a4a557fdf3d65', '2025-03-02 13:24:41', '2025-03-02 05:24:42', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (3, 79, 'pcmis-case.yaml', 'pcmis', '',
        'pcmis-case:\n  test:\n    admin: jdsbbmq-new-case\n\nspring:\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-case-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '85a17f55969573bf4ef6222f34b5f2f7', '2025-03-03 10:05:28', '2025-03-03 02:05:29', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (5, 80, 'pcmis-file.yaml', 'pcmis', '',
        'pcmis-file:\n  test:\n    admin: jdsbbmq-new-file\nspring:\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-file-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '31e63d542ff47691ea1c9c3eb3cbbf76', '2025-03-03 10:06:22', '2025-03-03 02:06:22', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (6, 81, 'pcmis-visual.yaml', 'pcmis', '',
        'pcmis-visual:\n  test:\n    admin: jdsbbmq-new-visual\nspring:\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-visual-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        'f7d91cf6c824e9f4c62ef466f7709ae6', '2025-03-03 10:06:31', '2025-03-03 02:06:31', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (7, 82, 'pcmis-project.yaml', 'pcmis', '',
        'pcmis-project:\n  test:\n    admin: jdsbbmq-new-project\nspring:\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-project-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        'fa5299aea50391395a5829aeac98e20d', '2025-03-03 10:06:38', '2025-03-03 02:06:38', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (8, 83, 'pcmis-risk.yaml', 'pcmis', '',
        'pcmis-risk:\n  test:\n    admin: jdsbbmq-new-risk\nspring:\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-risk-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '16ac61629e28055920d121e3a988d5a7', '2025-03-03 10:06:47', '2025-03-03 02:06:47', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (9, 84, 'pcmis-security.yaml', 'pcmis', '',
        'pcmis-security:\n  test:\n    admin: jdsbbmq-new-security\nspring:\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-security-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '9e991607e480ab6a084fb271c4590242', '2025-03-03 10:06:57', '2025-03-03 02:06:58', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis'),
       (23, 85, 'pcmis-user.yaml', 'pcmis', '',
        'pcmis-user:\n  test:\n    admin: jdsbbmq-new-user\nspring:\n  cloud:\n    sentinel:\n      log:\n        dir: ./logs/pcmis-user-logs\n        file: sentinel.log\n        max-size: 10MB\n        retention-days: 30\n  datasource:\n    driver-class-name: com.mysql.cj.jdbc.Driver\n    url: jdbc:mysql://localhost:3306/pcmis?characterEncoding=utf8&serverTimezone=UTC\n    username: root\n    password: 2003\n    type: com.alibaba.druid.pool.DruidDataSource\n\nmybatis:\n  config-location: classpath:mybatis.cfg.xml\n  type-aliases-package: com.lzy.common.entity\n  mapper-locations:\n    - classpath:mapper/*.xml\n\nmybatis-plus:\n  mapper-locations: classpath:mapper/*.xml\n  global-config:\n    db-config:\n      id-type: auto\n      field-strategy: NOT_EMPTY\n      db-type: MYSQL\n  configuration:\n    map-underscore-to-camel-case: true\n    call-setters-on-nulls: true\n    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl',
        '1d2e1b2c33126056268bf71ebc15a7b2', '2025-03-03 10:07:09', '2025-03-03 02:07:09', NULL, '0:0:0:0:0:0:0:1', 'U',
        'pcmis');
/*!40000 ALTER TABLE `his_config_info`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissions`
--

DROP TABLE IF EXISTS `permissions`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissions`
(
    `role`     varchar(50)  NOT NULL,
    `resource` varchar(255) NOT NULL,
    `action`   varchar(8)   NOT NULL,
    UNIQUE KEY `uk_role_permission` (`role`, `resource`, `action`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissions`
--

LOCK TABLES `permissions` WRITE;
/*!40000 ALTER TABLE `permissions`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `permissions`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles`
(
    `username` varchar(50) NOT NULL,
    `role`     varchar(50) NOT NULL,
    UNIQUE KEY `idx_user_role` (`username`, `role`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles`
    DISABLE KEYS */;
INSERT INTO `roles`
VALUES ('nacos', 'ROLE_ADMIN');
/*!40000 ALTER TABLE `roles`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_capacity`
--

DROP TABLE IF EXISTS `tenant_capacity`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tenant_capacity`
(
    `id`                bigint unsigned                  NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `tenant_id`         varchar(128) COLLATE utf8mb3_bin NOT NULL DEFAULT '' COMMENT 'Tenant ID',
    `quota`             int unsigned                     NOT NULL DEFAULT '0' COMMENT '配额，0表示使用默认值',
    `usage`             int unsigned                     NOT NULL DEFAULT '0' COMMENT '使用量',
    `max_size`          int unsigned                     NOT NULL DEFAULT '0' COMMENT '单个配置大小上限，单位为字节，0表示使用默认值',
    `max_aggr_count`    int unsigned                     NOT NULL DEFAULT '0' COMMENT '聚合子配置最大个数',
    `max_aggr_size`     int unsigned                     NOT NULL DEFAULT '0' COMMENT '单个聚合数据的子配置大小上限，单位为字节，0表示使用默认值',
    `max_history_count` int unsigned                     NOT NULL DEFAULT '0' COMMENT '最大变更历史数量',
    `gmt_create`        datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified`      datetime                         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_tenant_id` (`tenant_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='租户容量信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_capacity`
--

LOCK TABLES `tenant_capacity` WRITE;
/*!40000 ALTER TABLE `tenant_capacity`
    DISABLE KEYS */;
/*!40000 ALTER TABLE `tenant_capacity`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tenant_info`
--

DROP TABLE IF EXISTS `tenant_info`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tenant_info`
(
    `id`            bigint                           NOT NULL AUTO_INCREMENT COMMENT 'id',
    `kp`            varchar(128) COLLATE utf8mb3_bin NOT NULL COMMENT 'kp',
    `tenant_id`     varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_id',
    `tenant_name`   varchar(128) COLLATE utf8mb3_bin DEFAULT '' COMMENT 'tenant_name',
    `tenant_desc`   varchar(256) COLLATE utf8mb3_bin DEFAULT NULL COMMENT 'tenant_desc',
    `create_source` varchar(32) COLLATE utf8mb3_bin  DEFAULT NULL COMMENT 'create_source',
    `gmt_create`    bigint                           NOT NULL COMMENT '创建时间',
    `gmt_modified`  bigint                           NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_tenant_info_kptenantid` (`kp`, `tenant_id`),
    KEY `idx_tenant_id` (`tenant_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8mb3_bin COMMENT ='tenant_info';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tenant_info`
--

LOCK TABLES `tenant_info` WRITE;
/*!40000 ALTER TABLE `tenant_info`
    DISABLE KEYS */;
INSERT INTO `tenant_info`
VALUES (1, '1', 'pcmis', 'pcmis', 'pcmis', 'nacos', 1740802396209, 1740802396209);
/*!40000 ALTER TABLE `tenant_info`
    ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users`
(
    `username` varchar(50)  NOT NULL,
    `password` varchar(500) NOT NULL,
    `enabled`  tinyint(1)   NOT NULL,
    PRIMARY KEY (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users`
    DISABLE KEYS */;
INSERT INTO `users`
VALUES ('nacos', '$2a$10$JQ3Rh5fl1sJFOFsYgdzsU.BcdXbmuH6rkV5N8sCT6RVjxmzsrGshq', 1);
/*!40000 ALTER TABLE `users`
    ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2025-03-03 15:54:48
