package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.ExamMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExample.Criteria;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.ExamService;

@Service
public class ExamServiceImpl extends GenericServiceImpl<Exam, String> implements ExamService {

	@Resource
	private ExamMapper examMapper;

	@Override
	public int insert(Exam model) {
		return examMapper.insertSelective(model);
	}

	@Override
	public int update(Exam model) {
		if (model.getExamTime() != null) {
			return examMapper.updateByPrimaryKeySelective(model);
		} else {
			examMapper.updateByPrimaryKeySelective(model);
			model = examMapper.selectByPrimaryKey(model.getExamId());
			model.setExamTime(null);
			return examMapper.updateByPrimaryKey(model);
		}
	}

	@Override
	public int delete(String id) {
		return examMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Exam selectById(String id) {
		return examMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Exam> selectList() {
		return null;
	}

	@Override
	public Exam selectOne() {
		return null;
	}

	@Override
	public GenericDao<Exam, String> getDao() {
		return examMapper;
	}

	@Override
	public int deleteByExample(ExamExample example) {
		return examMapper.deleteByExample(example);
	}

	@Override
	public List<Exam> selectByExample(ExamExample example) {
		return examMapper.selectByExample(example);
	}

	@Override
	public long countByExample(ExamExample example) {
		return examMapper.countByExample(example);
	}

	@Override
	public Page<Exam> search(Exam exam, int pageNo) {
		ExamExample example = new ExamExample();
		Criteria criteria = example.createCriteria();
		if (exam != null && exam.getExamTitle() != null) {
			criteria.andExamTitleLike("%" + exam.getExamTitle() + "%");
		}
		criteria.andGroupIdEqualTo(exam.getGroupId());
		example.setOrderByClause("exam_begin desc");
		Page<Exam> page = new Page<Exam>(pageNo);
		examMapper.selectByExampleAndPage(page, example);
		return page;
	}

	@Override
	public List<ExamExtend> getMyExamList(User me) {
		return examMapper.getMyExamList(me);
	}

}
