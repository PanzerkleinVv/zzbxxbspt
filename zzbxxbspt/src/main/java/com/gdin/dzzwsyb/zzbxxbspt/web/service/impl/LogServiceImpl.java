package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericServiceImpl;
import com.gdin.dzzwsyb.zzbxxbspt.web.dao.LogMapper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogExtend;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogQuery;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.LogService;

@Service
public class LogServiceImpl extends GenericServiceImpl<Log, String> implements LogService {

	@Resource
	private LogMapper logMapper;

	@Override
	public void log(Log log) {
		insert(log);
	}

	@Override
	public Page<LogExtend> search(LogQuery logQuery, int pageNo) {
		Page<LogExtend> page = new Page<LogExtend>(pageNo);
		logMapper.selectByExampleAndPage(page, logQuery.getLogExample());
		return page;
	}

	@Override
	public GenericDao<Log, String> getDao() {
		return logMapper;
	}

	@Override
	public LogExtend selectByIdExtend(String logId) {
		return logMapper.selectByIdExtend(logId);
	}

}
