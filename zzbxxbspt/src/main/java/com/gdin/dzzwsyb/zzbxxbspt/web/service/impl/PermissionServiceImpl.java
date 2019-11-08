package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.PermissionMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Permission;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.PermissionService;
import org.springframework.stereotype.Service;

/**
 * 权限Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午12:05:03
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Integer> implements PermissionService {

	@Resource
	private PermissionMapper permissionMapper;

	@Override
	public GenericDao<Permission, Integer> getDao() {
		return permissionMapper;
	}

	@Override
	public List<Permission> selectPermissionsByRoleId(Integer roleId) {
		return permissionMapper.selectPermissionsByRoleId(roleId);
	}
}
