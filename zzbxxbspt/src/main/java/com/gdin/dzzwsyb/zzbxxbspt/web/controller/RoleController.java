package com.gdin.dzzwsyb.zzbxxbspt.web.controller;

import javax.annotation.Resource;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.PermissionService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/role")
public class RoleController {

	@Resource
	private RoleService roleService;
	@Resource
	private PermissionService permissionService;

	
}
