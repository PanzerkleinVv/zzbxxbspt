package com.gdin.dzzwsyb.zzbxxbspt.web.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.LogBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogQuery;
import com.gdin.dzzwsyb.zzbxxbspt.web.security.PermissionSign;

@Controller
@RequestMapping(value = "/log")
public class LogController {

	@Resource
	private LogBiz logBiz;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_LOG)
	public String admin() {
		return "log";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_LOG)
	@ResponseBody
	public Page<LogExtend> search(@RequestParam(value = "pageNo") Integer pageNo,
			@Valid LogQuery logQuery) {
		return logBiz.search(logQuery, pageNo);
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	@RequiresPermissions(value = PermissionSign.ADMIN_LOG)
	@ResponseBody
	public LogExtend info(@Valid Log log) {
		return logBiz.info(log);
	}

}
