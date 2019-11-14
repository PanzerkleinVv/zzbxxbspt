package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericService;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Answer;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.AnswerExample;

public interface AnswerService extends GenericService<Answer, String> {
	
	int deleteByExample(AnswerExample example);
	
	List<Answer> selectByExample(AnswerExample example);

}
