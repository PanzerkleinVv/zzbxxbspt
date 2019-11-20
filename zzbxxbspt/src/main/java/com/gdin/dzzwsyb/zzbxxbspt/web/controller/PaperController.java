package com.gdin.dzzwsyb.zzbxxbspt.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdin.dzzwsyb.zzbxxbspt.web.model.Paper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestionExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.security.PermissionSign;

@RequestMapping(value = "/paper")
@Controller
public class PaperController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.EXAM)
	public String index() {
		return "paper";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.EXAM)
	@ResponseBody
	public List<ExamExtend> list(HttpSession session) {
		return null;
	}
	
	@RequestMapping(value = "/paper", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.EXAM)
	@ResponseBody
	public List<PaperQuestionExtend> paper(@Valid Paper paper, HttpSession session) {
		return null;
	}
	
}
