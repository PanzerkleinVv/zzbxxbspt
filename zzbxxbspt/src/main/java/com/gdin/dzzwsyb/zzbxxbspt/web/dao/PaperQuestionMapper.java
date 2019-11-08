package com.gdin.dzzwsyb.zzbxxbspt.web.dao;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestion;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PaperQuestionMapper extends GenericDao<PaperQuestion, String> {
	long countByExample(PaperQuestionExample example);

	int deleteByExample(PaperQuestionExample example);

	int deleteByPrimaryKey(String id);

	int insert(PaperQuestion record);

	int insertSelective(PaperQuestion record);

	List<PaperQuestion> selectByExample(PaperQuestionExample example);

	PaperQuestion selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") PaperQuestion record, @Param("example") PaperQuestionExample example);

	int updateByExample(@Param("record") PaperQuestion record, @Param("example") PaperQuestionExample example);

	int updateByPrimaryKeySelective(PaperQuestion record);

	int updateByPrimaryKey(PaperQuestion record);
}