package com.gdin.dzzwsyb.zzbxxbspt.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.web.biz.ExamBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.PaperBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.ExamService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.LogService;

@Service
public class ExamBizImpl implements ExamBiz {

	@Resource
	private ExamService examService;
	
	@Resource
	private PaperBiz paperBiz;
	
	@Resource
	private LogService logService;

	@Override
	public List<Exam> selectByGroupId(String groupId) {
		ExamExample example = new ExamExample();
		example.createCriteria().andGroupIdEqualTo(groupId);
		return examService.selectByExample(example);
	}

	@Override
	public Message deleteByGroupId(String groupId, User me) {
		if (groupId != null && !"".equals(groupId)) {
			ExamExample example = new ExamExample();
			example.createCriteria().andGroupIdEqualTo(groupId);
			List<Exam> exams = examService.selectByExample(example);
			int i = 0;
			if (exams != null) {
				for (Exam exam : exams) {
					paperBiz.deleteByExamId(exam.getExamId(), me);
				}
				i = examService.deleteByExample(example);
				logService.log(new Log(2, me.getUserId(), "删除课题组（" + groupId + "）考试" + i + "场"));
			}
			return new Message(true, "删除考试" + i + "场");
		} else {
			return new Message(false, "无效课题组Id");
		}
	}

}
