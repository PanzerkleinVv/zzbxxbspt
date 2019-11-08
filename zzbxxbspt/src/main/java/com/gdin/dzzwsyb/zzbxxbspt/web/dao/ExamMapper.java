package com.gdin.dzzwsyb.zzbxxbspt.web.dao;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericDao;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExamMapper extends GenericDao<Exam, String> {
	long countByExample(ExamExample example);

	int deleteByExample(ExamExample example);

	int deleteByPrimaryKey(String examId);

	int insert(Exam record);

	int insertSelective(Exam record);

	List<Exam> selectByExample(ExamExample example);

	Exam selectByPrimaryKey(String examId);

	int updateByExampleSelective(@Param("record") Exam record, @Param("example") ExamExample example);

	int updateByExample(@Param("record") Exam record, @Param("example") ExamExample example);

	int updateByPrimaryKeySelective(Exam record);

	int updateByPrimaryKey(Exam record);
}