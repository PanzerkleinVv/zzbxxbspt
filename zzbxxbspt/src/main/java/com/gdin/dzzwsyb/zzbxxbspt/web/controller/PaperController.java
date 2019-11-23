package com.gdin.dzzwsyb.zzbxxbspt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdin.dzzwsyb.zzbxxbspt.web.model.Paper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperExtend;
import com.gdin.dzzwsyb.zzbxxbspt.core.util.ApplicationUtils;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.PaperBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.security.PermissionSign;

@RequestMapping(value = "/paper")
@Controller
public class PaperController {

	@Resource
	private PaperBiz paperBiz;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.EXAM)
	public String index() {
		return "paper";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.EXAM)
	@ResponseBody
	public List<ExamExtend> list(HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		return paperBiz.getMyExamList(me);
	}

	@RequestMapping(value = "/paper", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.EXAM)
	@ResponseBody
	public PaperExtend paper(@Valid Paper paper, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		if (paper == null || paper.getPaperId() == null) {
			paper.setUserId(me.getUserId());
			paper.setPaperId(ApplicationUtils.randomUUID());
			paperBiz.newPaper(paper);
			return paperBiz.getPaper(paper.getPaperId());
		} else {
			return paperBiz.getPaper(paper.getPaperId());
		}
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	@RequiresPermissions(value = PermissionSign.EXAM)
	@ResponseBody
	public Message submit(@Valid List<PaperExtend> paper, HttpSession session) {
		return null;
	}

}
