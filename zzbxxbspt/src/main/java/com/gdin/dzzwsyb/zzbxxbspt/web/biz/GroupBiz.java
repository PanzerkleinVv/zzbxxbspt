package com.gdin.dzzwsyb.zzbxxbspt.web.biz;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Group;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;

public interface GroupBiz {

	Page<Group> search(Group group, int pageNo);

	Message edit(Group group, User me);

	Group info(String groupId);
	
	Message delete(Group group, User me);
	
	List<Group> list();

}
