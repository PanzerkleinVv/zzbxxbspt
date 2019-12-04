package com.gdin.dzzwsyb.zzbxxbspt.web.biz;

import java.math.BigDecimal;
import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Paper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestion;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;

public interface PaperBiz {

	List<Paper> selectByUserId(String userId);

	Message deleteByUserId(String userId, User me);

	Message deleteByExamId(String examId, User me);

	List<ExamExtend> getMyExamList(User me);

	void newPaper(Paper paper, User me);

	PaperExtend getPaper(String paperId);

	Message submit(List<PaperQuestion> paperQuestions);

	BigDecimal scoring(String paperId);

}
