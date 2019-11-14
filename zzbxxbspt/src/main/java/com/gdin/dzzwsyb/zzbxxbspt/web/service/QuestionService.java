package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericService;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Question;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionExample;

public interface QuestionService extends GenericService<Question, String> {

	int deleteByExample(QuestionExample example);

	List<Question> selectByExample(QuestionExample example);
	
	Page<Question> search(Question question, int pageNo);

}