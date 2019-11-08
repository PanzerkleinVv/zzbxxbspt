package com.gdin.dzzwsyb.zzbxxbspt.web.dao;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.LogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogMapper extends GenericDao<Log, String> {
	long countByExample(LogExample example);

	int deleteByExample(LogExample example);

	int deleteByPrimaryKey(String logId);

	int insert(Log record);

	int insertSelective(Log record);

	List<Log> selectByExample(LogExample example);

	Log selectByPrimaryKey(String logId);

	int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

	int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

	int updateByPrimaryKeySelective(Log record);

	int updateByPrimaryKey(Log record);
}