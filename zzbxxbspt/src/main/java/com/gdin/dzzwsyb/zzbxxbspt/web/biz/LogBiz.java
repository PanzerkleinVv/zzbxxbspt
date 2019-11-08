package com.gdin.dzzwsyb.zzbxxbspt.web.biz;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogQuery;

public interface LogBiz {
	
	Page<LogExtend> search(LogQuery logQuery);

}
