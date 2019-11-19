package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.QuestionMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Question;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionExample.Criteria;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.QuestionService;

@Service
public class QuestionServiceImpl extends GenericServiceImpl<Question, String> implements QuestionService {

	@Resource
	private QuestionMapper questionMapper;

	@Override
	public int insert(Question model) {
		return questionMapper.insertSelective(model);
	}

	@Override
	public int update(Question model) {
		return questionMapper.updateByPrimaryKeySelective(model);
	}

	@Override
	public int delete(String id) {
		return questionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Question selectById(String id) {
		return questionMapper.selectByPrimaryKey(id);
	}

	@Override
	public Question selectOne() {
		return null;
	}

	@Override
	public List<Question> selectList() {
		return null;
	}

	@Override
	public GenericDao<Question, String> getDao() {
		return questionMapper;
	}

	@Override
	public int deleteByExample(QuestionExample example) {
		return questionMapper.deleteByExample(example);
	}

	@Override
	public List<Question> selectByExample(QuestionExample example) {
		return questionMapper.selectByExample(example);
	}

	@Override
	public Page<Question> search(Question question, int pageNo) {
		QuestionExample example = new QuestionExample();
		Criteria criteria = example.createCriteria();
		criteria.andGroupIdEqualTo(question.getGroupId());
		if (question.getQuestionContent() != null) {
			criteria.andQuestionContentLike("%" + question.getQuestionContent() + "%");
		}
		example.setOrderByClause("question_type, question_content asc");
		Page<Question> page = new Page<Question>(pageNo);
		questionMapper.selectByExampleAndPage(page, example);
		return page;
	}

	@Override
	public Long countByExample(QuestionExample example) {
		return questionMapper.countByExample(example);
	}

}
