package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import java.util.List;

import com.gdin.dzzwsyb.zzbxxbspt.core.generic.GenericService;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.Paper;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperExample;
import com.gdin.dzzwsyb.zzbxxbspt.web.model.PaperUser;

public interface PaperService extends GenericService<Paper, String> {

	List<Paper> selectByExample(PaperExample example);
	
	int deleteByExample(PaperExample example);
	
	List<PaperUser> rank(String examId);

}
