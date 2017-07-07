package com.eir.commercial.domains;

import java.awt.Insets;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.omg.CORBA.SystemException;
import org.zefer.pd4ml.PD4ML;
import org.zefer.pd4ml.PD4PageMark;



public class CommonUtilityService {

	
	protected static Integer topValue = 0;
	protected static Integer leftValue = 0;
	protected static Integer rightValue = 0;
	protected static Integer bottomValue = 0;
	protected static Integer userSpaceWidth = 940;	
	private static String hrd="<div align=\"right\"><font face=\"Segoe UI\" size=\"2\" style=\"text-align:right;\">" + 
		    	       "Experian Reference Number (ERN): refNo"
+"<br>Enquiry Reference: --"
+"<br>Member Name: Bank Of India</font></div>";
	/**
	 * method to convert html file to Pdf file
	 * 
	 * @param inputHtmlFile
	 * @param outFileName
	 * @param pwd
	 * @throws SystemException 
	 */
	public ByteArrayOutputStream htmlToPdfFile(String inputHtmlFile, String outFileName,
			String pwd) throws SystemException  {		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			PD4ML pd4ml = new PD4ML();
			pd4ml.interpolateImages(true);
			
			pd4ml.setPageInsets(new Insets(topValue, leftValue, bottomValue,
					rightValue));
			pd4ml.setHtmlWidth(userSpaceWidth);

			pd4ml.useTTF("java:fonts", true);
			pd4ml.setDefaultTTFs("DINNextLTPro-Regular", "Arial", "Courier New");
			
			pd4ml.enableSmartTableBreaks(true);
			pd4ml.setPageSize(PD4ML.A4);
			pd4ml.setPermissions(pwd, 0xffffffff, true);
			pd4ml.generateOutlines(true);
			
			pd4ml.useTTF("fonts",true);
		
			PD4PageMark header = new PD4PageMark(){
			};
			
            header.setAreaHeight(50);
            //header.setPageNumberTemplate("#$[page]"); 
            pd4ml.setPageHeader( header );
            PD4PageMark footer = new PD4PageMark();
    	  
	      footer.setAreaHeight(50);
	      footer.setPageNumberAlignment(PD4PageMark.LEFT_ALIGN);
	      footer.setHtmlTemplate( "<font face=\"Segoe UI\" size=\"2\">" + 
	    	       "Page: " + "${page} of ${total}</font>" );
	      //footer.setPageNumberTemplate("#$[page]"); 
	     // footer.setHtmlTemplate(hrd);
	    //  pd4ml.setPageFooter(footer);
	      pd4ml.render(new StringReader(inputHtmlFile), baos);
	     /* FileOutputStream fos2 = new FileOutputStream(new File(outFileName));
			fos2.write(baos.toByteArray());
			System.out.println("PDF File Created");
			fos2.flush();
			fos2.close();*/
		
		} catch (InvalidParameterException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();	
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}   		
		return baos;
	}
	
	
	/**
	 * method to create the zip file for given folder
	 * 
	 * @param newZipfileName
	 * @param filePathList
	 * @return
	 * @throws SystemException 
	
	 */
	public String folderToZip(String newZipfileName, ArrayList<String> filePathList) throws SystemException {

		FileOutputStream fos=null;
		ZipOutputStream zos =null;
	
		try{			
			
			byte[] buffer = new byte[1024];

			fos = new FileOutputStream(newZipfileName);
			
			zos = new ZipOutputStream(fos);

			for (int i = 0; i < filePathList.size(); i++) {

				File srcFile = new File(filePathList.get(i));
				FileInputStream fis = new FileInputStream(srcFile);

				zos.putNextEntry(new ZipEntry(srcFile.getName()));
				int length;
				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}				
				srcFile=null;
				zos.closeEntry();

				fis.close();
			}
			zos.close();	
		
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		finally{
			try {
				fos.close();
				zos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
					
		}
		
		return newZipfileName;

	}
	
	public void doIt(){
		 String str = "<table> <tr>"+
	        "<td bgcolor=\"#FFFFFF\" style=\"text-align:right;\"><span class=\"MetaDataElementLabels\">Experian Reference Number (ERN):</span> <span class=\"MetaDataElementValues\">1444259783028</span> <span class=\"MetaDataElementValues\">14/10/2015</span> <span class=\"MetaDataElementValues\">12:26:46 PM</span></td>"+
	      "</tr>"+
	      "<tr>"+
	        "<td bgcolor=\"#FFFFFF\" style=\"height:5px;\"></td>"+
	      "</tr>"+
	      "<tr>"+
	        "<td bgcolor=\"#FFFFFF\" style=\"text-align:right;\"><span class=\"MetaDataElementLabels\">Experian Reference:</span> <span class=\"MetaDataElementValues\">123456789012340</span></td>"+
	      "</tr>"+
	      "<tr>"+
	       "<td bgcolor=\"#FFFFFF\" style=\"height:5px;\"></td>"+
	      "</tr>"+
	      "<tr>"+
	        "<td bgcolor=\"#FFFFFF\" style=\"text-align:right;\"><span class=\"MetaDataElementLabels\">Member Name:</span> <span class=\"MetaDataElementValues\">12345678901234567890</span></td>"+
	      "</tr> </table>";
	}
}