package com.gdin.dzzwsyb.zzbxxbspt.web.dao;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Answer;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.AnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswerMapper extends GenericDao<Answer, String> {
	long countByExample(AnswerExample example);

	int deleteByExample(AnswerExample example);

	int deleteByPrimaryKey(String answerId);

	int insert(Answer record);

	int insertSelective(Answer record);

	List<Answer> selectByExample(AnswerExample example);

	Answer selectByPrimaryKey(String answerId);

	int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

	int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

	int updateByPrimaryKeySelective(Answer record);

	int updateByPrimaryKey(Answer record);
}