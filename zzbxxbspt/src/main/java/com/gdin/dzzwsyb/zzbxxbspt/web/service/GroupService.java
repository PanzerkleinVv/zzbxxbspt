package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericService;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Group;

public interface GroupService extends GenericService<Group, String> {

	Page<Group> search(Group group, int pageNo);

	boolean checkStatus();

}
