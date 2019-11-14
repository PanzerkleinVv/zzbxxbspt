package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.GroupMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Group;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.GroupExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.GroupExample.Criteria;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.GroupService;

@Service
public class GroupServiceImpl extends GenericServiceImpl<Group, String> implements GroupService {

	@Resource
	private GroupMapper groupMapper;

	@Override
	public int insert(Group model) {
		return groupMapper.insertSelective(model);
	}

	@Override
	public int update(Group model) {
		return groupMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return groupMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Group selectById(String id) {
		return groupMapper.selectByPrimaryKey(id);
	}

	@Override
	public Group selectOne() {
		return null;
	}

	@Override
	public List<Group> selectList() {
		GroupExample example = new GroupExample();
		example.setOrderByClause("group_name asc");
		return groupMapper.selectByExample(example);
	}

	@Override
	public GenericDao<Group, String> getDao() {
		return groupMapper;
	}

	@Override
	public Page<Group> search(Group group, int pageNo) {
		GroupExample example = new GroupExample();
		Criteria criteria = example.createCriteria();
		if (group != null && group.getGroupName() != null) {
			criteria.andGroupNameLike("%" + group.getGroupName() + "%");
		}
		example.setOrderByClause("group_status desc");
		Page<Group> page = new Page<Group>(pageNo);
		groupMapper.selectByExampleAndPage(page, example);
		return page;
	}

	@Override
	public boolean checkStatus() {
		GroupExample example = new GroupExample();
		example.createCriteria().andGroupStatusEqualTo(1);
		return 0 == groupMapper.countByExample(example);
	}

}
