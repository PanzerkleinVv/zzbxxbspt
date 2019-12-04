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

import com.gdin.dzzwsyb.zzbxxbspt.web.biz.AnalysisBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperUser;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.security.PermissionSign;

@Controller
@RequestMapping(value = "/analysis")
public class AnalysisController {
	
	@Resource
	private AnalysisBiz analysisBiz;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ANALYSIS_EXAM)
	public String admin() {
		return "analysis";
	}
	
	@RequestMapping(value = "/exams", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ANALYSIS_EXAM)
	@ResponseBody
	public List<Exam> exams(HttpSession session) {
		final User me = (User) session.getAttribute("userInfo");
		return analysisBiz.exams(me.getUserGroup());
	}
	
	@RequestMapping(value = "/rank", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ANALYSIS_EXAM)
	@ResponseBody
	public List<PaperUser> rank(@Valid String examId) {
		return analysisBiz.rank(examId);
	}

}
