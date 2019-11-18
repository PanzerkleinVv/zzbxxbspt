package com.gdin.dzzwsyb.zzbxxbspt.web.controller;

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
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.ExamBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.security.PermissionSign;

@Controller
@RequestMapping(value = "/exam")
public class ExamController {
	
	@Resource
	private ExamBiz examBiz;
	
	@RequestMapping(value = "/examNotExist", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.CREATE_QUESTION)
	@ResponseBody
	public Message examNotExist() {
		return examBiz.examNotExist();
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_EXAM)
	public String admin() {
		return "exam";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_EXAM)
	@ResponseBody
	public Page<Exam> search(@RequestParam(value = "pageNo") Integer pageNo,
			@RequestParam(value = "examTitle", required = false) String examTitle, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		Exam exam = new Exam();
		exam.setExamTitle(examTitle);
		exam.setGroupId(me.getUserGroup());
		return examBiz.search(exam, pageNo);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@RequiresPermissions(value = PermissionSign.ADMIN_EXAM)
	@ResponseBody
	public Message edit(@Valid Exam exam, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		if (exam != null) {
			return examBiz.edit(exam, me);
		} else {
			return new Message(false, "保存失败");
		}
	}
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_EXAM)
	@ResponseBody
	public Exam info(@Valid Exam exam) {
		return examBiz.info(exam.getExamId());
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_EXAM)
	@ResponseBody
	public Message delete(@Valid Exam exam, HttpSession session) {
		User me = (User) session.getAttribute("userInfo");
		if (exam != null) {
			return examBiz.delete(exam, me);
		}
		return new Message(false, "删除失败");
	}

}
