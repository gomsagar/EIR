package com.eir.report.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.eir.report.constant.Constant;

public class WriteFile {

	public String writeXmlOutputToFile(String xmlOutputPath, String xmlOutputResponse, Integer xmlOutputFolderReqId, String reportType) {
		// responceData write into file
		FileWriter fr = null;
		try {
			String fileName = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.txt'").format(new Date());

			File file = new File(xmlOutputPath + Constant.SEPERATOR + Constant.SEPERATOR + xmlOutputFolderReqId + reportType + Constant.SEPERATOR + fileName);
			file.getParentFile().mkdirs();
			String filePath = file.getAbsolutePath();
			fr = new FileWriter(file);
			fr.write(xmlOutputResponse);
			return filePath;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close resources
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// end write data here
		return null;
	}
}
