package com.gdin.dzzwsyb.zzbxxbspt.web.biz;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Group;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;

public interface UserBiz {

	User logon(User user);

	Page<User> search(User user, int pageNo);

	Message edit(User user, User me);

	User info(String userId);

	Message delete(User user, User me);

	Boolean checkPsw(User user);

	File template(String filename);

	Message input(InputStream inputStream, String groupId) throws IOException;
	
	Message saveAll(List<User> users, User me);
	
	Message deleteByGroupId(String groupId, User me);
	
	void createGroupManager(Group group, User me);

}
