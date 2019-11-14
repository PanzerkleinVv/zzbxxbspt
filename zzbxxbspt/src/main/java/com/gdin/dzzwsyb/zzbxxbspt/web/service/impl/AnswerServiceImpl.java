package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.AnswerMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Answer;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.AnswerExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.AnswerService;

@Service
public class AnswerServiceImpl extends GenericServiceImpl<Answer, String> implements AnswerService {

	@Resource
	private AnswerMapper answerMapper;

	@Override
	public int insert(Answer model) {
		return answerMapper.insertSelective(model);
	}

	@Override
	public int update(Answer model) {
		return answerMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return answerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Answer selectById(String id) {
		return answerMapper.selectByPrimaryKey(id);
	}

	@Override
	public Answer selectOne() {
		return null;
	}

	@Override
	public List<Answer> selectList() {
		return null;
	}

	@Override
	public GenericDao<Answer, String> getDao() {
		return answerMapper;
	}

	@Override
	public int deleteByExample(AnswerExample example) {
		return answerMapper.deleteByExample(example);
	}

	@Override
	public List<Answer> selectByExample(AnswerExample example) {
		return answerMapper.selectByExample(example);
	}

}
