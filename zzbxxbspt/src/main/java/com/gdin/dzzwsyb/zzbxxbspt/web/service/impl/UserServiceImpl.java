package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.util.List;
import javax.annotation.Resource;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.UserMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.UserExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.UserExample.Criteria;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户Service实现类
 *
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public int insert(User model) {
		return userMapper.insertSelective(model);
	}

	@Override
	public int update(User model) {
		return userMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public User authentication(User user) {
		return userMapper.authentication(user);
	}

	@Override
	public User selectById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public GenericDao<User, String> getDao() {
		return userMapper;
	}

	@Override
	public List<User> selectList() {
		UserExample example = new UserExample();
		example.createCriteria().andUserIdIsNotNull();
		example.setOrderByClause("USER_NAME");
		return userMapper.selectByExample(example);
	}

	@Override
	public User logon(String userPsw) {
		final List<User> list = userMapper.logon(userPsw);
		return list.get(0);
	}

	@Override
	public Page<User> search(User user, int pageNo) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		if (user != null && user.getUserName() != null) {
			criteria.andUserNameLike("%" + user.getUserName() + "%");
		}
		criteria.andUserGroupEqualTo(user.getUserGroup()).andUserRoleIdEqualTo(3);
		example.setOrderByClause("user_desc, user_name asc");
		Page<User> page = new Page<User>(pageNo);
		userMapper.selectByExampleAndPage(page, example);
		return page;
	}
	
	@Override
	public boolean userPswUsed(User user) {
		if (user != null) {
			UserExample example = new UserExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserPswEqualTo(user.getUserPsw()).andUserGroupEqualTo(user.getUserGroup());
			if (user.getUserId() != null && !"".equals(user.getUserId())) {
				criteria.andUserIdNotEqualTo(user.getUserId());
			}
			return userMapper.countByExample(example) == 0;
		} else {
			return false;
		}
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		return userMapper.selectByExample(example);
	}
}
