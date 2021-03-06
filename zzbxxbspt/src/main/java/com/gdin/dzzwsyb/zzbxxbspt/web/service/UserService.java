package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericService;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.UserExample;

/**
 * 用户 业务 接口
 * 
 **/
public interface UserService extends GenericService<User, String> {

	/**
	 * 用户验证
	 * 
	 * @param user
	 * @return
	 */
	User authentication(User user);

	User logon(String userPsw);

	Page<User> search(User user, int pageNo);

	boolean userPswUsed(User user);

	List<User> selectByExample(UserExample example);

}
