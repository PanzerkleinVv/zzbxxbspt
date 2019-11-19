package com.gdin.dzzwsyb.zzbxxbspt.web.biz;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Question;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;

public interface QuestionBiz {

	List<Question> selectByGroupId(String groupId);

	Message deleteByGroupId(String groupId, User me);

	Page<Question> search(Question question, int pageNo);
	
	Message edit(QuestionExtend question, User me);
	
	QuestionExtend info (Question question);
	
	Message delete(Question question, User me);
	
	File template(String filename);
	
	Message input(InputStream inputStream, String groupId) throws IOException;
	
	Message saveAll(List<QuestionExtend> questions, User me);
	
	Long[] getCount(String groupId);

}
