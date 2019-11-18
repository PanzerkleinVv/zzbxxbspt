package com.gdin.dzzwsyb.zzbxxbspt.web.biz;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;

public interface ExamBiz {
	
	List<Exam> selectByGroupId(String groupId);
	
	Message deleteByGroupId(String groupId, User me);
	
	Message examNotExist();
	
	Page<Exam> search(Exam exam, int pageNo);
	
	Message edit(Exam exam, User me);

	Exam info(String examId);
	
	Message delete(Exam exam, User me);

}
