package com.gdin.dzzwsyb.zzbxxbspt.web.biz;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperUser;

public interface AnalysisBiz {

	List<Exam> exams(String groupId);

	List<PaperUser> rank(String examId);

}
