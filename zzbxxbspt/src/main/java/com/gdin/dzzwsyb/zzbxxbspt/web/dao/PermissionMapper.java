package com.gdin.dzzwsyb.zzbxxbspt.web.dao;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Permission;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper extends GenericDao<Permission, Integer> {
	long countByExample(PermissionExample example);

	int deleteByExample(PermissionExample example);

	int deleteByPrimaryKey(Integer permId);

	int insert(Permission record);

	int insertSelective(Permission record);

	List<Permission> selectByExample(PermissionExample example);

	Permission selectByPrimaryKey(Integer permId);

	int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

	int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);

	List<Permission> selectPermissionsByRoleId(Integer roleId);
}