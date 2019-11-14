package com.gdin.dzzwsyb.zzbxxbspt.web.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.LogBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogQuery;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.LogService;

@Service
public class LogBizImpl implements LogBiz {

	@Resource
	private LogService logService;

	@Override
	public Page<LogExtend> search(LogQuery logQuery, int pageNo) {
		return logService.search(logQuery, pageNo);
	}

	@Override
	public LogExtend info(Log log) {
		return logService.selectByIdExtend(log.getLogId());
	}

}
