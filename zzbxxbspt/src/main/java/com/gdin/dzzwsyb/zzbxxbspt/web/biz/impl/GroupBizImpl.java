package com.gdin.dzzwsyb.zzbxxbspt.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.ExamBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.GroupBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.QuestionBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.UserBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Group;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.GroupService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.LogService;

@Service
public class GroupBizImpl implements GroupBiz {

	@Resource
	private GroupService groupService;

	@Resource
	private LogService logService;

	@Resource
	private UserBiz userBiz;
	
	@Resource
	private ExamBiz examBiz;
	
	@Resource
	private QuestionBiz questionBiz;

	@Override
	public Page<Group> search(Group group, int pageNo) {
		return groupService.search(group, pageNo);
	}

	@Override
	public Message edit(Group group, User me) {
		if (group.getGroupId() == null || "".equals(group.getGroupId())) {
			group.setGroupId(ApplicationUtils.randomUUID());
			group.setGroupStatus(0);
			groupService.insert(group);
			logService.log(new Log(2, me.getUserId(), "新增课题组" + group.getGroupName() + "（" + group.getGroupId() + "）"));
			userBiz.createGroupManager(group, me);
			return new Message(true, "保存成功");
		} else if (group.getGroupName() != null && !"".equals(group.getGroupName())) {
			groupService.update(group);
			logService.log(new Log(2, me.getUserId(), "修改课题组" + group.getGroupName() + "（" + group.getGroupId() + "）"));
			return new Message(true, "保存成功");
		} else if (group.getGroupStatus() == 1) {
			if (groupService.checkStatus()) {
				groupService.update(group);
				group = groupService.selectById(group.getGroupId());
				logService.log(
						new Log(2, me.getUserId(), "启用课题组" + group.getGroupName() + "（" + group.getGroupId() + "）"));
				return new Message(true, "启用成功");
			} else {
				return new Message(false, "启用失败，同一时间只允许存在一个启用课题组，请先停用已启用的课题组。");
			}
		} else {
			groupService.update(group);
			group = groupService.selectById(group.getGroupId());
			logService.log(new Log(2, me.getUserId(), "停用课题组" + group.getGroupName() + "（" + group.getGroupId() + "）"));
			return new Message(true, "停用成功");
		}
	}

	@Override
	public Group info(String groupId) {
		return groupService.selectById(groupId);
	}

	@Override
	public Message delete(Group group, User me) {
		Message message1 = userBiz.deleteByGroupId(group.getGroupId(), me);
		Message message2 = examBiz.deleteByGroupId(group.getGroupId(), me);
		Message message3 = questionBiz.deleteByGroupId(group.getGroupId(), me);
		groupService.delete(group.getGroupId());
		logService.log(new Log(2, me.getUserId(), "删除课题组：" + group.getGroupName() + "（" + group.getGroupId() + "）"));
		return new Message(true, "删除课题组成功，" + message1.getContent() + message2.getContent() + message3.getContent());
	}

	@Override
	public List<Group> list() {
		return groupService.selectList();
	}

}
