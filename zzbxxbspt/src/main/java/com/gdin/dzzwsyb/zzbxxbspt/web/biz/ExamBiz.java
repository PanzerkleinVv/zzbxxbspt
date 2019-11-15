package com.gdin.dzzwsyb.zzbxxbspt.web.biz;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;

public interface ExamBiz {
	
	List<Exam> selectByGroupId(String groupId);
	
	Message deleteByGroupId(String groupId, User me);
	
	Message examNotExist();

}
