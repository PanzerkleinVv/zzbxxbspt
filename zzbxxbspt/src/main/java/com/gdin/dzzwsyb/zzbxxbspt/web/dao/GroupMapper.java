package com.gdin.dzzwsyb.zzbxxbspt.web.dao;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Group;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.GroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupMapper extends GenericDao<Group, String> {
	long countByExample(GroupExample example);

	int deleteByExample(GroupExample example);

	int deleteByPrimaryKey(String groupId);

	int insert(Group record);

	int insertSelective(Group record);

	List<Group> selectByExample(GroupExample example);

	Group selectByPrimaryKey(String groupId);

	int updateByExampleSelective(@Param("record") Group record, @Param("example") GroupExample example);

	int updateByExample(@Param("record") Group record, @Param("example") GroupExample example);

	int updateByPrimaryKeySelective(Group record);

	int updateByPrimaryKey(Group record);
}