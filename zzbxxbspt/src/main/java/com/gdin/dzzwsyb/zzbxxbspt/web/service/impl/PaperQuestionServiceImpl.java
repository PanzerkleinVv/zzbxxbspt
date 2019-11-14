package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.PaperQuestionMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestion;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestionExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.PaperQuestionService;

@Service
public class PaperQuestionServiceImpl extends GenericServiceImpl<PaperQuestion, String>
		implements PaperQuestionService {

	@Resource
	private PaperQuestionMapper paperQuestionMapper;

	@Override
	public int insert(PaperQuestion model) {
		return paperQuestionMapper.insertSelective(model);
	}

	@Override
	public int update(PaperQuestion model) {
		return paperQuestionMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return paperQuestionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PaperQuestion selectById(String id) {
		return paperQuestionMapper.selectByPrimaryKey(id);
	}

	@Override
	public PaperQuestion selectOne() {
		return null;
	}

	@Override
	public List<PaperQuestion> selectList() {
		return null;
	}

	@Override
	public int deleteByExample(PaperQuestionExample example) {
		return paperQuestionMapper.deleteByExample(example);
	}

	@Override
	public GenericDao<PaperQuestion, String> getDao() {
		return paperQuestionMapper;
	}

}
