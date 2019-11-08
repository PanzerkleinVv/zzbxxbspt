package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.io.File;
import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.web.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public File template(String filename) {
		return new File(Thread.currentThread().getContextClassLoader().getResource("").toString()
				.replace("classes", "resource/" + filename).replace("file:/", ""));
	}

}
