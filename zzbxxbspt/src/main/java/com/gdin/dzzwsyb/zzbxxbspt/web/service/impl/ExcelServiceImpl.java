package com.gdin.dzzwsyb.zzbxxbspt.web.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Service;

import com.gdin.dzzwsyb.zzbxxbspt.web.service.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService {

	@Override
	public String[][] getData(InputStream inputStream) throws IOException {
		POIFSFileSystem system = new POIFSFileSystem(inputStream);
		@SuppressWarnings("resource")
		HSSFSheet sheet = new HSSFWorkbook(system).getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		Row row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		String[][] content = new String[rowNum - 1][colNum];
		for (int i = 1; i < rowNum; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colNum; j++) {
				// 获取每个单元格的值
				if (row.getCell(j) != null) {
					content[i - 1][j] = row.getCell(j).getStringCellValue();
				}
			}
		}
		system.close();
		return content;
	}

}
