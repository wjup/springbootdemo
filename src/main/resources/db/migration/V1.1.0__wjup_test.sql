/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : jeesite

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 11/05/2020 18:11:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for js_sys_job
-- ----------------------------
DROP TABLE IF EXISTS `js_sys_job`;
CREATE TABLE `js_sys_job`  (
  `job_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务组名',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '任务描述',
  `invoke_target` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'Cron执行表达式',
  `misfire_instruction` decimal(1, 0) NOT NULL COMMENT '计划执行错误策略',
  `concurrent` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否并发执行',
  `instance_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'JeeSiteScheduler' COMMENT '集群的实例名字',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态（0正常 1删除 2暂停）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者',
  `create_date` datetime(0) NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新者',
  `update_date` datetime(0) NOT NULL COMMENT '更新时间',
  `remarks` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`job_name`, `job_group`) USING BTREE,
  INDEX `idx_sys_job_status`(`status`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '作业调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of js_sys_job
-- ----------------------------
INSERT INTO `js_sys_job` VALUES ('MsgLocalMergePushTask', 'SYSTEM', '消息推送服务 (延迟推送)', 'msgLocalMergePushTask.execute()', '0 0/30 * * * ?', 2, '0', 'JeeSiteScheduler', '2', 'system', '2019-08-07 17:48:50', 'system', '2019-08-07 17:48:50', NULL);
INSERT INTO `js_sys_job` VALUES ('MsgLocalPushTask', 'SYSTEM', '消息推送服务 (实时推送)', 'msgLocalPushTask.execute()', '0/3 * * * * ?', 2, '0', 'JeeSiteScheduler', '2', 'system', '2019-08-07 17:48:50', 'system', '2019-08-07 17:48:50', NULL);

SET FOREIGN_KEY_CHECKS = 1;
