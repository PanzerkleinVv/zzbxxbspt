package com.gdin.dzzwsyb.zzbxxbspt.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.web.biz.PaperBiz;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Log;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Message;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Paper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperQuestionExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.User;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.LogService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.PaperQuestionService;
import com.gdin.dzzwsyb.zzbxxbspt.web.service.PaperService;

@Service
public class PaperBizImpl implements PaperBiz {

	@Resource
	private PaperService paperService;

	@Resource
	private PaperQuestionService paperQuestionService;

	@Resource
	private LogService logService;

	@Override
	public List<Paper> selectByUserId(String userId) {
		PaperExample example = new PaperExample();
		example.createCriteria().andUserIdEqualTo(userId);
		return paperService.selectByExample(example);
	}

	@Override
	public Message deleteByUserId(String userId, User me) {
		if (userId != null && !"".equals(userId)) {
			PaperExample example = new PaperExample();
			example.createCriteria().andUserIdEqualTo(userId);
			List<Paper> papers = paperService.selectByExample(example);
			int i = 0;
			int j = 0;
			if (papers != null) {
				for (Paper paper : papers) {
					PaperQuestionExample example0 = new PaperQuestionExample();
					example0.createCriteria().andPaperIdEqualTo(paper.getPaperId());
					j += paperQuestionService.deleteByExample(example0);
				}
				i = paperService.deleteByExample(example);
			}
			logService.log(new Log(2, me.getUserId(), "删除用户（" + userId + "）试卷" + i + "份、答案" + j + "行"));
			return new Message(true, "删除试卷" + i + "份、答案" + j + "行");
		} else {
			return new Message(false, "无效用户Id");
		}
	}

	@Override
	public Message deleteByExamId(String examId, User me) {
		if (examId != null && !"".equals(examId)) {
			PaperExample example = new PaperExample();
			example.createCriteria().andExamIdEqualTo(examId);
			List<Paper> papers = paperService.selectByExample(example);
			int i = 0;
			int j = 0;
			if (papers != null) {
				for (Paper paper : papers) {
					PaperQuestionExample example0 = new PaperQuestionExample();
					example0.createCriteria().andPaperIdEqualTo(paper.getPaperId());
					j += paperQuestionService.deleteByExample(example0);
				}
				i = paperService.deleteByExample(example);
			}
			logService.log(new Log(2, me.getUserId(), "删除考试（" + examId + "）试卷" + i + "份、答案" + j + "行"));
			return new Message(true, "删除试卷" + i + "份、答案" + j + "行");
		} else {
			return new Message(false, "无效考试Id");
		}
	}

}
