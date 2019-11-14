package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.PaperMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Paper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.PaperService;

@Service
public class PaperServiceImpl extends GenericServiceImpl<Paper, String> implements PaperService {

	@Resource
	private PaperMapper paperMapper;

	@Override
	public int insert(Paper model) {
		return paperMapper.insertSelective(model);
	}

	@Override
	public int update(Paper model) {
		return paperMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return paperMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Paper selectById(String id) {
		return paperMapper.selectByPrimaryKey(id);
	}

	@Override
	public Paper selectOne() {
		return null;
	}

	@Override
	public List<Paper> selectList() {
		return null;
	}

	@Override
	public List<Paper> selectByExample(PaperExample example) {
		return paperMapper.selectByExample(example);
	}

	@Override
	public int deleteByExample(PaperExample example) {
		return paperMapper.deleteByExample(example);
	}

	@Override
	public GenericDao<Paper, String> getDao() {
		return paperMapper;
	}

}
