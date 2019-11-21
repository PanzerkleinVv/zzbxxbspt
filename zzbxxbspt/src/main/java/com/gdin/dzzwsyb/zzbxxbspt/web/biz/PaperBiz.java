package com.gdin.dzzwsyb.zzbxxbspt.web.biz;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Paper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;

public interface PaperBiz {

	List<Paper> selectByUserId(String userId);

	Message deleteByUserId(String userId, User me);
	
	Message deleteByExamId(String examId, User me);
	
	List<ExamExtend> getMyExamList(User me);

}
