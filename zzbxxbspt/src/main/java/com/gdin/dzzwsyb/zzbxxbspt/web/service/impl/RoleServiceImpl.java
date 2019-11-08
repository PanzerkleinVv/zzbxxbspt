package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.RoleMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Role;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 角色Service实现类
 *
 * @author StarZou
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements RoleService {

	@Resource
	private RoleMapper roleMapper;

	@Override
	public GenericDao<Role, Integer> getDao() {
		return roleMapper;
	}

	@Override
	public List<Role> selectRolesByUserId(String userId) {
		return roleMapper.selectRolesByUserId(userId);
	}

}
