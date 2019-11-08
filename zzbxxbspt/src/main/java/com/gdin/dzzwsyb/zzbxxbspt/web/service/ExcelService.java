package com.gdin.dzzwsyb.zzbxxbspt.web.service;

import java.io.IOException;
import java.io.InputStream;

public interface ExcelService {

	String[][] getData(InputStream inputStream) throws IOException;

}
