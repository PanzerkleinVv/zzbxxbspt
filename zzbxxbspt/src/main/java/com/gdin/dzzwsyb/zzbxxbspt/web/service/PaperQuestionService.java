package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericService;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestion;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestionExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestionExtend;

public interface PaperQuestionService extends GenericService<PaperQuestion, String> {

	int deleteByExample(PaperQuestionExample example);

	List<PaperQuestionExtend> getPaperQestion(String paperId);

}
