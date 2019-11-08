package com.gdin.dzzwsyb.zzbxxbspt.web.dao;

import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;

public interface UserMapper extends GenericDao<User, String> {
	long countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(String userId);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(String userId);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	User authentication(@Param("record") User record);

	List<User> selectByExampleAndPage(Page<User> page, UserExample example);

	List<User> logon(String userPsw);
}