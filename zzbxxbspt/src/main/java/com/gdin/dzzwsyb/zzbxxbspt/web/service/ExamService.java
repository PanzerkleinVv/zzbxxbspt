package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericService;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;

public interface ExamService extends GenericService<Exam, String> {

	int deleteByExample(ExamExample example);

	List<Exam> selectByExample(ExamExample example);
	
	long countByExample(ExamExample example);
	
	Page<Exam> search(Exam exam, int pageNo);
	
	List<ExamExtend> getMyExamList(User me);

}
