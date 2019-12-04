package com.gdin.dzzwsyb.zzbxxbspt.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.web.biz.AnalysisBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.biz.PaperBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Exam;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.ExamExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Paper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperUser;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.ExamService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.PaperService;

@Service
public class AnalysisBizImpl implements AnalysisBiz {
	
	@Resource
	private ExamService examService;
	
	@Resource
	private PaperService paperService;
	
	@Resource
	private PaperBiz paperBiz;

	@Override
	public List<Exam> exams(String groupId) {
		ExamExample example = new ExamExample();
		example.createCriteria().andGroupIdEqualTo(groupId);
		example.setOrderByClause("exam_begin desc");
		return examService.selectByExample(example);
	}

	@Override
	public List<PaperUser> rank(String examId) {
		final Exam exam = examService.selectById(examId);
		List<PaperUser> papers = paperService.rank(examId);
		for (Paper paper : papers) {
			if (paper.getPaperScore() == null) {
				if (exam.getExamEnd().getTime() < System.currentTimeMillis() || paper.getPaperBegin().getTime() + exam.getExamTime() * 60000 < System.currentTimeMillis()) {
					paperBiz.scoring(paper.getPaperId());
				}
			}
		}
		return paperService.rank(examId);
	}

}
