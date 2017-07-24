package com.eir.report.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.fileupload.FileItem;

import com.eir.report.constant.Constant;

public class WriteFile {

	public String writeXmlOutputToFile(String xmlOutputPath, String xmlOutputResponse, Integer xmlOutputFolderReqId, String reportType) {
		// responceData write into file
		FileWriter fr = null;
		try {
			String fileName = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.txt'").format(new Date());

			String filePath = xmlOutputFolderReqId + Constant.SEPERATOR + reportType + Constant.SEPERATOR + fileName;
			File file = new File(xmlOutputPath + Constant.SEPERATOR + filePath);
			file.getParentFile().mkdirs();
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
	
	public String saveKycDocument(String documentOutputPath, FileItem item, Integer outputFolderReqId, String kycDocument){
		FileWriter fr = null;
		try {
			String fileName = item.getFieldName();
			byte[] bytes = item.get();
			String filePath = outputFolderReqId + Constant.SEPERATOR + kycDocument + Constant.SEPERATOR + fileName;
			File file = new File(documentOutputPath + Constant.SEPERATOR + filePath);
			file.getParentFile().mkdirs();
			fr = new FileWriter(file);
			//fr.write(xmlOutputResponse);
			String fileOutput = new String(bytes);
			fr.write(fileOutput);
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
