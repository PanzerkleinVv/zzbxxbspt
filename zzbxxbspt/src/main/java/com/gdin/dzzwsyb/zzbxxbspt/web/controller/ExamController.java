package com.gdin.dzzwsyb.zzbxxbspt.web.controller;

import javax.annotation.Resource;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdin.dzzwsyb.zzbxxbspt.web.biz.ExamBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
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

}
