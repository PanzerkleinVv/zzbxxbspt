package com.gdin.dzzwsyb.zzbxxbspt.web.dao;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Question;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionMapper extends GenericDao<Question, String> {
	long countByExample(QuestionExample example);

	int deleteByExample(QuestionExample example);

	int deleteByPrimaryKey(String questionId);

	int insert(Question record);

	int insertSelective(Question record);

	List<Question> selectByExample(QuestionExample example);

	Question selectByPrimaryKey(String questionId);

	int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

	int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

	int updateByPrimaryKeySelective(Question record);

	int updateByPrimaryKey(Question record);
}