package com.gdin.dzzwsyb.zzbxxbspt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.GroupBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Group;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.security.PermissionSign;

@Controller
@RequestMapping(value = "/group")
public class GroupController {

	@Resource
	private GroupBiz groupBiz;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.CREATE_GROUP)
	public String admin() {
		return "group";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.CREATE_GROUP)
	@ResponseBody
	public Page<Group> search(@RequestParam(value = "pageNo") Integer pageNo,
			@RequestParam(value = "groupName", required = false) String groupName) {
		Group group = new Group();
		if (groupName != null && !"".equals(groupName)) {
			group.setGroupName(groupName);
		}
		return groupBiz.search(group, pageNo);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@RequiresPermissions(value = PermissionSign.CREATE_GROUP)
	@ResponseBody
	public Message edit(@Valid Group group, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		if (group != null) {
			return groupBiz.edit(group, me);
		} else {
			return new Message(false, "保存失败");
		}
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.CREATE_GROUP)
	@ResponseBody
	public Group info(@Valid Group group) {
		return groupBiz.info(group.getGroupId());
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.CREATE_GROUP)
	@ResponseBody
	public Message delete(@Valid Group group, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		if (group != null) {
			return groupBiz.delete(group, me);
		}
		return new Message(false, "删除失败");
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_LOG)
	@ResponseBody
	public List<Group> list() {
		return groupBiz.list();
	}

}
