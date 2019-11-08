package com.gdin.dzzwsyb.zzbxxbspt.web.dao;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Paper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaperMapper extends GenericDao<Paper, String> {
	long countByExample(PaperExample example);

	int deleteByExample(PaperExample example);

	int deleteByPrimaryKey(String paperId);

	int insert(Paper record);

	int insertSelective(Paper record);

	List<Paper> selectByExample(PaperExample example);

	Paper selectByPrimaryKey(String paperId);

	int updateByExampleSelective(@Param("record") Paper record, @Param("example") PaperExample example);

	int updateByExample(@Param("record") Paper record, @Param("example") PaperExample example);

	int updateByPrimaryKeySelective(Paper record);

	int updateByPrimaryKey(Paper record);
}