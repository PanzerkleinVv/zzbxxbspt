package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericService;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestion;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestionExample;

public interface PaperQuestionService extends GenericService<PaperQuestion, String> {

	int deleteByExample(PaperQuestionExample example);

}
