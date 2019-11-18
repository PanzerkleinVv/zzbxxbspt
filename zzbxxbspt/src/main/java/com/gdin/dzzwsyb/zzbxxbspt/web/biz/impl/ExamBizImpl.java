package com.gdin.dzzwsyb.zzbxxbspt.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.core.feature.orm.mybatis.Page;
import com.gdin.dzzwsyb.zzbxxbspt.core.util.ApplicationUtils;
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

	@Override
	public Message examNotExist() {
		ExamExample example = new ExamExample();
		example.createCriteria().andGroupUsed();
		final boolean flag = examService.countByExample(example) == 0;
		if (flag) {
			return new Message(flag, "");
		} else {
			return new Message(flag, "请删除考试定制后再修改试题");
		}
	}

	@Override
	public Page<Exam> search(Exam exam, int pageNo) {
		return examService.search(exam, pageNo);
	}

	@Override
	public Message edit(Exam exam, User me) {
		if (exam.getExamId() == null || "".equals(exam.getExamId())) {
			exam.setExamId(ApplicationUtils.randomUUID());
			exam.setGroupId(me.getUserGroup());
			examService.insert(exam);
			logService.log(new Log(2, me.getUserId(), "新增考试" + exam.getExamTitle() + "（" + exam.getExamId() + "）"));
			return new Message(true, "保存成功");
		} else {
			examService.update(exam);
			logService.log(new Log(2, me.getUserId(), "修改考试" + exam.getExamTitle() + "（" + exam.getExamId() + "）"));
			return new Message(true, "保存成功");
		}
	}

	@Override
	public Exam info(String examId) {
		return examService.selectById(examId);
	}

	@Override
	public Message delete(Exam exam, User me) {
		paperBiz.deleteByExamId(exam.getExamId(), me);
		examService.delete(exam.getExamId());
		logService.log(new Log(2, me.getUserId(), "删除考试" + exam.getExamTitle() + "（" + exam.getExamId() + "）"));
		return new Message(true, "删除成功");
	}

}
