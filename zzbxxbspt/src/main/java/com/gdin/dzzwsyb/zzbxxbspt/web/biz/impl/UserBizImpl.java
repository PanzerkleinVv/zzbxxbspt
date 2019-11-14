package com.gdin.dzzwsyb.zzbxxbspt.web.biz.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.zzbxxbspt.core.util.IdCardUtil;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.PaperBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.UserBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Group;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.UserExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.ExcelService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.FileService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.LogService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.UserService;

@Service
public class UserBizImpl implements UserBiz {

	@Resource
	private UserService userService;

	@Resource
	private LogService logService;

	@Resource
	private ExcelService excelService;

	@Resource
	private FileService fileService;

	@Resource
	private PaperBiz paperBiz;

	@Override
	public User logon(User user) {
		final User authUserInfo = userService.authentication(user);
		logService.log(new Log(1, authUserInfo.getUserId(), "登录系统"));
		return authUserInfo;
	}

	@Override
	public Page<User> search(User user, int pageNo) {
		return userService.search(user, pageNo);
	}

	@Override
	public Message edit(User user, User me) {
		if (user.getUserId() == null || "".equals(user.getUserId())) {
			user.setUserId(ApplicationUtils.randomUUID());
			user.setUserGroup(me.getUserGroup());
			user.setUserRoleId(3);
			userService.insert(user);
			logService.log(new Log(2, me.getUserId(), "新增学员：" + user.getUserName() + "（" + user.getUserId() + "）"));
			return new Message(true, "保存成功");
		} else {
			userService.update(user);
			logService.log(new Log(2, me.getUserId(), "修改学员：" + user.getUserName() + "（" + user.getUserId() + "）"));
			return new Message(true, "保存成功");
		}
	}

	@Override
	public User info(String userId) {
		return userService.selectById(userId);
	}

	@Override
	public Message delete(User user, User me) {
		paperBiz.deleteByUserId(user.getUserId(), me);
		userService.delete(user.getUserId());
		logService.log(new Log(2, me.getUserId(), "删除学员：" + user.getUserName() + "（" + user.getUserId() + "）"));
		return new Message(true, "删除成功");
	}

	@Override
	public Boolean checkPsw(User user) {
		return userService.userPswUsed(user);
	}

	@Override
	public File template(String filename) {
		return fileService.template(filename);
	}

	@Override
	public Message input(InputStream inputStream, String groupId) throws IOException {
		String[][] data = excelService.getData(inputStream);
		List<User> users = new ArrayList<User>();
		for (String[] row : data) {
			User user = new User();
			if (row[0] == null) {
				continue;
			} else {
				user.setUserName(row[0]);
			}
			if (row[1] == null) {
				continue;
			} else {
				Message pswCheck = IdCardUtil.validate18Idcard(row[1]);
				if (pswCheck.isFlag()) {
					User checkUser = new User();
					checkUser.setUserGroup(groupId);
					checkUser.setUserPsw(row[1].toUpperCase());
					if (!userService.userPswUsed(checkUser)) {
						pswCheck = new Message(false, "身份证被占用或用户已存在");
					}
				}
				user.setUserPsw(row[1]);
				user.setMessage(pswCheck);
			}
			if (row[2] != null) {
				user.setUserDesc(row[2]);
			}
			users.add(user);
		}
		return new Message(true, "Excel解析成功", users);
	}

	@Override
	public Message saveAll(List<User> users, User me) {
		for (User user : users) {
			user.setUserId(ApplicationUtils.randomUUID());
			user.setUserGroup(me.getUserGroup());
			user.setUserRoleId(3);
			userService.insert(user);
			logService.log(new Log(2, me.getUserId(), "新增学员：" + user.getUserName() + "（" + user.getUserId() + "）"));
		}
		return new Message(true, "保存成功" + users.size() + "位学员");
	}

	@Override
	public Message deleteByGroupId(String groupId, User me) {
		if (groupId != null && !"".equals(groupId)) {
			UserExample example = new UserExample();
			example.createCriteria().andUserGroupEqualTo(groupId);
			List<User> users = userService.selectByExample(example);
			if (users != null) {
				for (User user : users) {
					delete(user, me);
				}
			}
			return new Message(true, "删除" + users.size() + "位学员与考试记录");
		} else {
			return new Message(false, "无效课题组Id");
		}
	}

	@Override
	public void createGroupManager(Group group, User me) {
		User user = new User("考试管理员", "1234567890");
		user.setUserId(ApplicationUtils.randomUUID());
		user.setUserDesc(group.getGroupName());
		user.setUserRoleId(2);
		user.setUserGroup(group.getGroupId());
		userService.insert(user);
		logService.log(new Log(2, me.getUserId(), "新增考试管理员：" + user.getUserName() + "（" + user.getUserId() + "）"));
	}

}
