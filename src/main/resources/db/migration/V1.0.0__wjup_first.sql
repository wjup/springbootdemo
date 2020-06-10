/*
 Navicat Premium Data Transfer

 Source Server         : 太原政务云图10.221.2.44
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 10.221.2.44:3306
 Source Schema         : cloudmap_taiyuan

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 11/05/2020 15:33:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cld_alarm
-- ----------------------------
DROP TABLE IF EXISTS `cld_alarm`;
CREATE TABLE `cld_alarm`  (
  `uuid` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `firstnum` int(11) NULL DEFAULT NULL COMMENT '一级告警',
  `secondnum` int(11) NULL DEFAULT NULL COMMENT '二级告警',
  `thirdnum` int(11) NULL DEFAULT NULL COMMENT '三级告警',
  `fourthnum` int(11) NULL DEFAULT NULL COMMENT '四级告警',
  `ctime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cld_alarm
-- ----------------------------
INSERT INTO `cld_alarm` VALUES ('1', 12, 22, 12, 1212, '2020-05-11 09:48:49');

-- ----------------------------
-- Table structure for cld_cabinet
-- ----------------------------
DROP TABLE IF EXISTS `cld_cabinet`;
CREATE TABLE `cld_cabinet`  (
  `uuid` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `cabinetsize` int(11) NULL DEFAULT NULL COMMENT '机柜空间（单位：G）',
  `ctime` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `nettype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在区域 gov-政务外网 net-互联网',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '政务云图-机柜信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cld_cabinet
-- ----------------------------
INSERT INTO `cld_cabinet` VALUES ('1', 12000, '2020-05-11 09:49:19', 'gov');
INSERT INTO `cld_cabinet` VALUES ('2', 23000, '2020-05-11 09:49:35', 'net');

SET FOREIGN_KEY_CHECKS = 1;
