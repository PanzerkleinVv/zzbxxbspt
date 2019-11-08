/*
Navicat MySQL Data Transfer

Source Server         : zzbxxbspt
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : zzbxxbspt

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2019-11-08 17:19:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer` (
  `ANSWER_ID` varchar(255) NOT NULL,
  `QUESTION_ID` varchar(255) DEFAULT NULL,
  `ANSWER_CONTENT` varchar(255) DEFAULT NULL,
  `ANSWER_TYPE` int(3) DEFAULT NULL,
  `ANSWER_ORDER` int(3) DEFAULT NULL,
  PRIMARY KEY (`ANSWER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of answer
-- ----------------------------

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam` (
  `EXAM_ID` varchar(255) NOT NULL COMMENT '课题id',
  `GROUP_ID` varchar(255) DEFAULT NULL,
  `EXAM_TITLE` varchar(255) DEFAULT NULL,
  `EXAM_BEGIN` datetime DEFAULT NULL,
  `EXAM_END` datetime DEFAULT NULL,
  `EXAM_TIME` int(11) DEFAULT NULL,
  `EXAM_SCORE` int(11) DEFAULT NULL,
  `EXAM_SC` int(11) DEFAULT NULL,
  `EXAM_SC_SCORE` decimal(10,0) DEFAULT NULL,
  `EXAM_TF` int(11) DEFAULT NULL,
  `EXAM_TF_SCORE` decimal(10,0) DEFAULT NULL,
  `EXAM_MC` int(11) DEFAULT NULL,
  `EXAM_MC_SCORE` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`EXAM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exam
-- ----------------------------

-- ----------------------------
-- Table structure for group
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `GROUP_ID` varchar(255) NOT NULL COMMENT '考试分组id',
  `GROUP_NAME` varchar(255) DEFAULT NULL COMMENT '考试分组名',
  `GROUP_STATUS` int(3) DEFAULT NULL,
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `LOG_ID` varchar(255) NOT NULL,
  `LOG_TYPE` int(3) DEFAULT NULL,
  `LOG_USER` varchar(255) DEFAULT NULL,
  `LOG_DESC` varchar(255) DEFAULT NULL,
  `LOG_TIME` datetime DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('0de558e68dfc852bce85c9987c15409969ec0223', '2', 'ac4cd7b0e3e3745a84f742213d99578141813895', '新增学员：测试3（473707e9bf90c6c0bb1c0608fd6a2619ded61ddd）', '2019-11-08 14:19:12');
INSERT INTO `log` VALUES ('12c4d2e6a6ea0ade00255e8804b9e597d57cc514', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-07 17:30:24');
INSERT INTO `log` VALUES ('148f6166ca0de3a752afa59237f3ed40a1ab917a', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-08 12:31:02');
INSERT INTO `log` VALUES ('1c777c8699bde7cbeb923ef98b939d9231bdd64c', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-08 17:05:12');
INSERT INTO `log` VALUES ('1d02f2c8767fc33f2a875c1cb6cfe24e27b0c9d3', '2', 'ac4cd7b0e3e3745a84f742213d99578141813895', '修改学员：测试2（c8a078ba5222e26cd369a0f59b13a849b0dc0f7c）', '2019-11-08 14:38:06');
INSERT INTO `log` VALUES ('376d87a28ebd3bd6fc17053214caf5929267cc17', '2', 'ac4cd7b0e3e3745a84f742213d99578141813895', '删除学员：测试2（c8a078ba5222e26cd369a0f59b13a849b0dc0f7c）', '2019-11-08 14:38:13');
INSERT INTO `log` VALUES ('3ec430ddb4c32d70ede28a2f8f83dad2cd224b68', '2', 'ac4cd7b0e3e3745a84f742213d99578141813895', '新增学员：测试4（b4e27db57852d9442329e9fa758abf8c8632983f）', '2019-11-08 14:19:48');
INSERT INTO `log` VALUES ('43f1ff5f25c1f5b86394d3a572ab0dca88de2f0b', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-07 16:09:10');
INSERT INTO `log` VALUES ('60c653c8f1e735d962e957f41e6a327283b646e0', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-07 17:40:42');
INSERT INTO `log` VALUES ('830548d45f9650cdfe15177efcc55055802a7eb2', '2', 'ac4cd7b0e3e3745a84f742213d99578141813895', '新增学员：测试2（c8a078ba5222e26cd369a0f59b13a849b0dc0f7c）', '2019-11-08 14:18:43');
INSERT INTO `log` VALUES ('8593ab2a93568ef3b918cf560ae25a444264a708', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-07 15:55:41');
INSERT INTO `log` VALUES ('85995fa52af48cb4993b88a93ef78e18d5c23790', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-07 17:27:37');
INSERT INTO `log` VALUES ('87a72e769bd67387c7aedf2089bd77c43ea7aa92', '2', 'ac4cd7b0e3e3745a84f742213d99578141813895', '删除学员：测试4（b4e27db57852d9442329e9fa758abf8c8632983f）', '2019-11-08 14:38:16');
INSERT INTO `log` VALUES ('8d607ede7af0d18af4501d4ef0b092ec60365617', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-08 15:06:12');
INSERT INTO `log` VALUES ('9137f2ac8665af0d0d01f3221e9b0fe4a59cf0b4', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-08 11:46:22');
INSERT INTO `log` VALUES ('a041a313ac4e0940ed1d46f919a0ed21dd1b58ce', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-06 17:14:59');
INSERT INTO `log` VALUES ('a37431d4f4487d546f2854ee302c35d77f3c9b3d', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-07 16:04:35');
INSERT INTO `log` VALUES ('adab48f3eb5404c6705701a0989b0331fc5cb6fa', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-07 15:11:45');
INSERT INTO `log` VALUES ('b161f2310e57e1147466d06240e35eedca8e2902', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-06 18:06:23');
INSERT INTO `log` VALUES ('b6e81d1d6b83873477df5dd07fdaa802e1b58813', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-08 14:09:37');
INSERT INTO `log` VALUES ('bed57819ad1f4b0b7595481888e9b9fcaa05ec69', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-07 15:51:41');
INSERT INTO `log` VALUES ('c0c2dbf88affdcdd8f0274fb1fab249c77b086f5', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-07 14:57:10');
INSERT INTO `log` VALUES ('d541e30b1f5da5553c17b57bd275b28f1c39d855', '2', 'ac4cd7b0e3e3745a84f742213d99578141813895', '删除学员：测试2（6b4d797c03a66e737d28a912fab46241b96bb521）', '2019-11-06 17:15:06');
INSERT INTO `log` VALUES ('e83a0ed0d4ed914b66bd2120ce759e35d8cc4cb5', '2', 'ac4cd7b0e3e3745a84f742213d99578141813895', '修改学员：测试2（c8a078ba5222e26cd369a0f59b13a849b0dc0f7c）', '2019-11-08 14:33:55');
INSERT INTO `log` VALUES ('ee0d867d2a1d246ef2092ea9302e9a5ce50d145a', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-07 16:06:26');
INSERT INTO `log` VALUES ('eeac49c1e066f4532d383ead1c6e0e49ab72db88', '2', 'ac4cd7b0e3e3745a84f742213d99578141813895', '修改学员：测试3（473707e9bf90c6c0bb1c0608fd6a2619ded61ddd）', '2019-11-08 15:18:35');
INSERT INTO `log` VALUES ('f79039434b78af0298d7c77a4761542d7af4b498', '1', 'ac4cd7b0e3e3745a84f742213d99578141813895', '登录系统', '2019-11-08 17:15:09');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `PAPER_ID` varchar(255) NOT NULL,
  `EXAM_ID` varchar(255) DEFAULT NULL,
  `USER_ID` varchar(255) DEFAULT NULL,
  `PAPER_SCORE` decimal(10,0) DEFAULT NULL,
  `PAPER_BEGIN` datetime DEFAULT NULL,
  PRIMARY KEY (`PAPER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------

-- ----------------------------
-- Table structure for paper_question
-- ----------------------------
DROP TABLE IF EXISTS `paper_question`;
CREATE TABLE `paper_question` (
  `ID` varchar(255) NOT NULL,
  `PAPER_ID` varchar(255) DEFAULT NULL,
  `QUESTION_ID` varchar(255) DEFAULT NULL,
  `ANSWER` varchar(255) DEFAULT NULL,
  `QUESTION_ORDER` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper_question
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `PERM_ID` int(3) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `PERM_NAME` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '权限名',
  `PERM_SIGN` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '权限标识',
  `PERM_DESC` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '权限权限描述',
  PRIMARY KEY (`PERM_ID`),
  UNIQUE KEY `pk_permission` (`PERM_ID`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '新开课题', 'create_group', '开启新的竞赛考试分组');
INSERT INTO `permission` VALUES ('2', '监考员管理', 'admin_teacher', '竞赛考试分组管理员');
INSERT INTO `permission` VALUES ('3', '日志管理', 'admin_log', '日志查阅');
INSERT INTO `permission` VALUES ('4', '题目设置', 'create_question', '导入题库');
INSERT INTO `permission` VALUES ('5', '学员管理', 'admin_student', '导入学员');
INSERT INTO `permission` VALUES ('6', '分数统计', 'analysis_exam', '统计分数生成报表');
INSERT INTO `permission` VALUES ('7', '答题', 'exam', '学员答题');
INSERT INTO `permission` VALUES ('42', '考试设置', 'admin_eaxm', '设置考试参数');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `QUESTION_ID` varchar(255) NOT NULL,
  `GROUP_ID` varchar(255) DEFAULT NULL,
  `QUESTION_TYPE` int(3) DEFAULT NULL,
  `QUESTION_CONTENT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`QUESTION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ROLE_ID` int(3) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `ROLE_NAME` varchar(255) NOT NULL COMMENT '角色名',
  `ROLE_SIGN` varchar(255) NOT NULL COMMENT '角色标识',
  `ROLE_DESC` varchar(255) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '系统管理员', 'admin', '系统管理员');
INSERT INTO `role` VALUES ('2', '考试管理员', 'teacher', '考试管理员');
INSERT INTO `role` VALUES ('3', '学员', 'student', '学员');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ROLE_ID` int(3) NOT NULL,
  `PERM_ID` int(3) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '1', '2');
INSERT INTO `role_permission` VALUES ('101', '1', '3');
INSERT INTO `role_permission` VALUES ('102', '2', '4');
INSERT INTO `role_permission` VALUES ('103', '2', '5');
INSERT INTO `role_permission` VALUES ('104', '2', '6');
INSERT INTO `role_permission` VALUES ('105', '3', '7');
INSERT INTO `role_permission` VALUES ('106', '1', '4');
INSERT INTO `role_permission` VALUES ('107', '1', '5');
INSERT INTO `role_permission` VALUES ('108', '1', '6');
INSERT INTO `role_permission` VALUES ('109', '2', '42');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `USER_ID` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '用户ID',
  `USER_NAME` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '用户名',
  `USER_PSW` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '用户密码',
  `USER_ROLE_ID` int(3) NOT NULL,
  `USER_DESC` varchar(255) DEFAULT NULL,
  `USER_GROUP` varchar(255) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('473707e9bf90c6c0bb1c0608fd6a2619ded61ddd', '测试3', '440104195507081942', '3', '', '0');
INSERT INTO `user` VALUES ('685ff2cc2803e3402f1ca85610e3184316e424fc', '测试', '440104199209210417', '3', '11111', '0');
INSERT INTO `user` VALUES ('ac4cd7b0e3e3745a84f742213d99578141813895', 'admin', '1234567890', '1', '系统管理员', '0');
