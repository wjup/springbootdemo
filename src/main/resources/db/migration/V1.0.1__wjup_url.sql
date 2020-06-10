/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : springboot

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 11/05/2020 17:25:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for gc_url
-- ----------------------------
DROP TABLE IF EXISTS `gc_url`;
CREATE TABLE `gc_url`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广告跳转链接',
  `name` varchar(99) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名字备注',
  `type` varchar(9) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型：footerAd（手机底部浮动广告）、headerAd（顶部列表广告）、floatAd（两侧悬浮广告）、videoDoAd（视频下方广告）',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示图地址',
  `sort` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排序',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '有效性：2已删除，1可用，0不可用',
  `start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '启用时间',
  `end_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '到期时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gc_url
-- ----------------------------
INSERT INTO `gc_url` VALUES (1, '/', '', 'headerAd', 'http://img818.yingshengyl.com/static/images/ps/1541576097729904587.gif', '0', '1', '2019-03-08', '2020-04-08');
INSERT INTO `gc_url` VALUES (2, '/', '播放器下方广告', 'videoDoAd', 'http://charming.kuaiyunds.com/charming/img/headerad.gif', '0', '1', '2019-03-08', '2022-04-08');
INSERT INTO `gc_url` VALUES (4, '/', '招租图', 'headerAd', 'http://charming.kuaiyunds.com/charming/img/headerad.gif', '2', '1', '2019-02-08', '2099-11-14');
INSERT INTO `gc_url` VALUES (5, '/', '底部悬浮广告', 'footerAd', 'https://cbu01.alicdn.com/img/ibank/2018/065/256/9429652560_1995781528.jpg', '0', '1', '2019-03-08', '2020-05-08');
INSERT INTO `gc_url` VALUES (8, '/', '', 'floatAd', 'https://img.alicdn.com/imgextra/i4/2200544786935/O1CN01uefpeL216HChR3WNT_!!1-martrix_bbs.gif', '0', '1', '2019-03-15', '2020-02-21');
INSERT INTO `gc_url` VALUES (9, '/', '', 'floatAd', 'https://img.alicdn.com/imgextra/i2/2200544786935/O1CN016XkIzh216HCmJPLUd_!!1-martrix_bbs.gif', '1', '1', '2019-03-15', '2020-03-13');
INSERT INTO `gc_url` VALUES (10, '/', '', 'videoDoAd', 'https://cbu01.alicdn.com/img/ibank/2018/065/256/9429652560_1995781528.jpg', '1', '1', '2019-03-30', '2020-05-01');
INSERT INTO `gc_url` VALUES (11, '/', '', 'headerAd', 'https://cbu01.alicdn.com/img/ibank/2018/845/926/8573629548_1995781528.jpg', '2', '1', '2019-03-30', '2020-06-12');

SET FOREIGN_KEY_CHECKS = 1;
