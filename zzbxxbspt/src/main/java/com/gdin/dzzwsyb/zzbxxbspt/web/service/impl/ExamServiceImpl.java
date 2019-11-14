package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.ExamMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExample;
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
		return examMapper.updateByPrimaryKeySelective(model);
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

}
