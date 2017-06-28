package com.eir.report.nextgen.service.mapper;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.eir.commercial.domains.CommonUtilityService;
import com.eir.domain.EIRDomain;
import com.experian.nextgen.ind.model.consumer.uofpojo.Bpaygrid;

public class CreateReport {
	
	//public void generatestring(ResponseInfo responseInfoCons,CommercialReportDetails reportDetails )
	public void generatestring(EIRDomain eirDomain, String reportType)
	{
		
		try
		{
		
			VelocityEngine velocityEngine = new VelocityEngine();
			Properties properties = new Properties();
			properties.setProperty("resource.loader", "file");
			properties.setProperty("file.resource.loader.class","org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	
			velocityEngine.init(properties);
			Template template = velocityEngine.getTemplate("/vmFiles/Combo.vm");
			VelocityContext context = new VelocityContext();
			
			context.put("bpGrid", Bpaygrid.class);
			/*context.put("responseInfo", responseInfoCons);
			context.put("reportDetails", reportDetails);*/
			context.put("eirDomain",eirDomain);
			context.put("StringUtils", StringUtils.class);
			/*context.put("isCombo",isCombo);
			context.put("isEIR",isEIR);*/
			context.put("reportType",reportType);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
			SimpleDateFormat sdf2 = new SimpleDateFormat("MMM/yyyy");
			context.put("sdf", sdf);
			context.put("sdf2", sdf2);
	
			StringWriter writer = new StringWriter();
			template.merge(context, writer);
			String htmlConsOutput = writer.toString();
			createHtml(htmlConsOutput);
			
			Boolean isPdf = true;
			context.put("isPdf", isPdf);
			StringWriter writer1 = new StringWriter();
			template.merge(context, writer1);
			String pdfConsOutput = writer1.toString();
			//createHtml(pdfConsOutput);
			createPdf(pdfConsOutput);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void createHtml(String value)
	{
	
	        File file = new File("D:/output");
	        FileWriter fileWriter = null;
			
			if (!file.exists())
			{
			 file.mkdirs();
			}      
	        
	        try
	        {
	        	file = new File("D:/output/HTMLReport.html");
				fileWriter = new FileWriter(file);
				fileWriter.write(value);
				System.out.println("Html File Created");
			} 
	        catch (IOException e) 
	        {
				e.printStackTrace();
			} 
	        catch (Exception e) 
	        {
				e.printStackTrace();
			}
	        
	        finally
	        {
				try 
				{
					if (fileWriter != null) 
					{
						fileWriter.close();
					}
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		
	}
 
	public void createPdf(String value)
	{
	
	        File file = new File("D:/output");
	        
			if (!file.exists())
			{
			 file.mkdirs();
			}      
	        
	       
	       CommonUtilityService commonUtilityService = new CommonUtilityService();
	       commonUtilityService.htmlToPdfFile(value, "D:/output/PDFReport.pdf", "");
	       System.out.println("PDF File Created");
		
	}
 /*public static void main(String args[])
 {
	 File file;
	 FileReader f = null;
	 try
     {
     	 file = new File("D:/output/HTMLReport.html");
			fileWriter = new FileWriter(file);
			fileWriter.write(value);
			System.out.println("Html File Created");
     	f = new FileReader(file);
     	createPdf(f.toString());
		} 
     catch (IOException e) 
     {
			e.printStackTrace();
		} 
     catch (Exception e) 
     {
			e.printStackTrace();
		}
     
     finally
     {
			try 
			{
				if (f != null) 
				{
					f.close();
				}
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
 }
*/
}