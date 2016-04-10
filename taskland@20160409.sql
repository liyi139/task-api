CREATE DATABASE  IF NOT EXISTS `taskland` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `taskland`;
-- MySQL dump 10.13  Distrib 5.5.47, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: taskland
-- ------------------------------------------------------
-- Server version	5.7.11

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
-- Table structure for table `task_attach_file`
--

DROP TABLE IF EXISTS `task_attach_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_attach_file` (
  `ATTACH_ID` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '任务附件编码',
  `TASK_ID` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '任务编码',
  `ATTACH_NAME` varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '附件名称',
  `ATTACH_PATH` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '存放路径',
  `OPERATOR` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人',
  `OPERATE_TIME` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`ATTACH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='任务田-任务附件';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_comment`
--

DROP TABLE IF EXISTS `task_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_comment` (
  `COMMENT_ID` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '任务评论编码',
  `TASK_ID` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '任务编码',
  `FLOW_ID` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '任务流转编码',
  `REPLY_TYPE` smallint(6) DEFAULT NULL COMMENT '回复类型  1. 查阅、21：转派 21：标记完成  4：拒绝  5 重新发起  6 取消  （同日志表操作类型）',
  `COMMENTS` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '评论内容',
  `REPLIER` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '回复人',
  `REPLY_TIME` timestamp NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`COMMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='任务评论回复表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_flow`
--

DROP TABLE IF EXISTS `task_flow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_flow` (
  `FLOW_ID` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '任务流转编码',
  `TASK_ID` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '任务编码',
  `TASK_ASSIGNER` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '指派人',
  `TASK_HANDLER` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '处理人',
  `ASSIGN_TIME` timestamp NULL DEFAULT NULL COMMENT '指派时间',
  PRIMARY KEY (`FLOW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='任务田-任务流转表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_follow`
--

DROP TABLE IF EXISTS `task_follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_follow` (
  `TASK_ID` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '任务编码',
  `FOLLOWER` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '关注人',
  `FOLLOW_TIME` timestamp NULL DEFAULT NULL COMMENT '关注时间',
  PRIMARY KEY (`TASK_ID`,`FOLLOWER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='任务田-任务关注表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_info`
--

DROP TABLE IF EXISTS `task_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_info` (
  `TASK_ID` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '任务编码',
  `TASK_NAME` varchar(100) CHARACTER SET utf8 DEFAULT NULL COMMENT '任务名称',
  `TASK_CONT` varchar(3000) COLLATE utf8_bin DEFAULT NULL COMMENT '任务内容',
  `TASK_STATUS` smallint(6) DEFAULT NULL COMMENT '任务状态 -1:未开始  1：进行中  2：已完成  3:已拒绝 4：已取消 ',
  `TASK_TYPE` smallint(6) DEFAULT NULL COMMENT '任务类别 1:告警处理、2:业务目标、3:营销待办',
  `TASK_PRIORITY` smallint(6) DEFAULT NULL COMMENT '任务优先级 1:正常   2:紧急   3:非常紧急\n',
  `TASK_RELATE` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '任务关联对象',
  `TASK_RELATE_JSON` varchar(500) COLLATE utf8_bin DEFAULT NULL COMMENT '任务关联配置',
  `TASK_PID` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '父任务编码',
  `BEGIN_DATE` date DEFAULT NULL COMMENT '任务开始时间',
  `DEADLINE` date DEFAULT NULL COMMENT '任务到期时间',
  `REMIND_MODE` char(3) COLLATE utf8_bin DEFAULT NULL COMMENT '提醒方式 111：短信、邮件、页面',
  `REMIND_MEMBER` char(3) COLLATE utf8_bin DEFAULT NULL COMMENT '提醒参与成员 111：指派人、处理人、参与人\n',
  `REMIND_EXPIRE_DAYS` smallint(6) DEFAULT NULL COMMENT '到期提醒天数',
  `CREATOR` varchar(45) COLLATE utf8_bin DEFAULT NULL COMMENT '创建人',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `MODIFIER` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '更新人',
  `MODIFY_TIME` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `LFT` int(11) DEFAULT NULL COMMENT '左边索引,用于树形结构递归查询',
  `RGT` int(11) DEFAULT NULL COMMENT '右边索引,用于树形结构递归查询',
  PRIMARY KEY (`TASK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='任务田-任务信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_log`
--

DROP TABLE IF EXISTS `task_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_log` (
  `LOG_ID` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '日志编码',
  `TASK_ID` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '任务编码',
  `OPERATE_TYPE` smallint(6) DEFAULT NULL COMMENT '操作类型',
  `OPERATE_CONT` varchar(300) COLLATE utf8_bin DEFAULT NULL COMMENT '操作内容  1:查阅  2:回复 3：关注 4：取消关注  11:创建  12：修改  21:转派  22:标记完成  23:拒绝 24:重新发起  25取消',
  `OPERATOR` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人',
  `OPERATE_TIME` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='任务日志表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_participant`
--

DROP TABLE IF EXISTS `task_participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_participant` (
  `TASK_ID` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '任务编码',
  `PARTICIPANT` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '参与人',
  `OPERATOR` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '操作人',
  `OPERATE_TIME` timestamp NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`TASK_ID`,`PARTICIPANT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='任务田-任务参与表\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_remind`
--

DROP TABLE IF EXISTS `task_remind`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_remind` (
  `REMIND_ID` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '任务提醒编码',
  `TASK_ID` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '任务编码',
  `REMIND_CONT` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '提醒内容',
  `REMIND_USER` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '提醒人',
  `REMIND_HANDLER` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '提醒处理人',
  `REMIND_MODE` char(3) COLLATE utf8_bin DEFAULT NULL COMMENT '提醒方式',
  `REMIND_TYPE` smallint(6) DEFAULT NULL COMMENT '提醒类别 1：常规提醒   2：催办提醒    3：超期提醒  \n',
  `RECORD_TIME` timestamp NULL DEFAULT NULL COMMENT '记录时间',
  PRIMARY KEY (`REMIND_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='任务田-任务提醒';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `task_remind_log`
--

DROP TABLE IF EXISTS `task_remind_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_remind_log` (
  `REMIND_ID` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '任务提醒编码',
  `TASK_ID` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '任务编码',
  `REMIND_CONT` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '提醒内容',
  `REMIND_USER` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '提醒人',
  `REMIND_HANDLER` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '提醒处理人',
  `REMIND_MODE` char(3) COLLATE utf8_bin DEFAULT NULL COMMENT '提醒方式',
  `REMIND_TYPE` smallint(6) DEFAULT NULL COMMENT '提醒类别 1：常规提醒   2：催办提醒    3：超期提醒  \n',
  `RECORD_TIME` timestamp NULL DEFAULT NULL COMMENT '记录时间',
  `REMIND_TIME` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`REMIND_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='任务田-任务提醒';
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-09 22:51:57
