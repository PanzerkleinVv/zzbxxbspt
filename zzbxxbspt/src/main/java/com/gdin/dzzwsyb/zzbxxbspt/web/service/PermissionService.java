package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericService;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Permission;

public interface PermissionService extends GenericService<Permission, Integer> {

	List<Permission> selectPermissionsByRoleId(Integer roleId);

}
