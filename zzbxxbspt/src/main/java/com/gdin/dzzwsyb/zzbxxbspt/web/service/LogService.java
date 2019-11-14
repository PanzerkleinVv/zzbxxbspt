package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericService;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogQuery;

public interface LogService extends GenericService<Log, String> {

	void log(Log log);

	Page<LogExtend> search(LogQuery logQuery, int pageNo);

	LogExtend selectByIdExtend(String logId);
	
}
