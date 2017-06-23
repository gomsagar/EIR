package com.eir.report.nextgen.service.mapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.eir.commercial.domains.Velocitypage;
//import com.eir.commercial.services.CommonUtilityService;
import com.eir.report.service.impl.NextGenWebServiceImpl;
import com.experian.nextgen.ind.model.consumer.uofpojo.Bpaygrid;
import com.experian.nextgen.ind.model.consumer.uofpojo.Conscred;
import com.experian.nextgen.ind.model.consumer.uofpojo.ResponseInfo;


public class ConsumerMapper {

	public static ResponseInfo responseInfo = null;
	public static Bpaygrid bpaygrid = null;
	public String mapConsData(ResponseInfo responseInfo) throws IOException
	{
		try
		{
			//responseInfo = ExperianHttpDirectClient.getCIRReport();
		VelocityEngine velocityEngine = new VelocityEngine();
		Properties properties = new Properties();
		properties.setProperty("resource.loader", "file");
		properties
				.setProperty("file.resource.loader.class",
						"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

		velocityEngine.init(properties);
		Template template = velocityEngine
				.getTemplate("Consumer_VmFiles/MainConsumer.vm");
		VelocityContext context = new VelocityContext();
		
		context.put("StringUtils", StringUtils.class);
		context.put("bpGrid", Bpaygrid.class);
		context.put("responseInfo", responseInfo);
	
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
		createPdf(pdfConsOutput);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//objectMappingForRating.clear();
		return "";
	}
		
	 
	 public void createHtml(String value)
		{
		
		 
			Velocitypage velocitypage = new Velocitypage();
		
		        File file = new File("D:/output");
		        FileWriter fileWriter = null;
				
				if (!file.exists())
				{
				 file.mkdirs();
				}      
		        
		        try
		        {
		        	file = new File("D:/output/Cons.html");
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
		        
		       
		    /*   CommonUtilityService commonUtilityService = new CommonUtilityService();
		       commonUtilityService.htmlToPdfFile(value, "D:/output/EIRConsReport.pdf", "");
		       System.out.println("PDF File Created");*/
			
		}
	 
	public static void main(String[] args)
	{
		
		NextGenWebServiceImpl impl = new NextGenWebServiceImpl();
		//impl.getCIRReport();
		
		// TODO Auto-generated method stub
		/*String value="";
		try 
		{
            File f = new File("C:/Experian/EIR/getConsumerProductRespnse.xml");
            FileInputStream  fileInputStream  =  new FileInputStream(f);
            SOAPMessage message = MessageFactory.newInstance().createMessage(null, fileInputStream );
            
            Unmarshaller unmarshaller = JAXBContext.newInstance(ResponseInfo.class).createUnmarshaller();
            System.out.println(message.getSOAPBody());
          //  responseInfo = (ResponseInfo)unmarshaller.unmarshal(message.getSOAPBody().extractContentAsDocument());
            System.out.println(responseInfo);
		  //  responseInfo.getConsumerResponse();
		    
		    List<Conscred> conscredList = responseInfo.getConsumerResponse().getConscred();
			for(Conscred conscred: conscredList)
			{
				List<Bpaygrid> bpaygridList = conscred.getBpaygrid();
				
				Map<String, ArrayList<Bpaygrid>> paymentHistMap = new HashMap<String, ArrayList<Bpaygrid>>();
				
				ArrayList<Bpaygrid> bpayGridList = null; 
				
				for(Bpaygrid bpaygrid: bpaygridList)
				{
					if(paymentHistMap.containsKey(bpaygrid.getYear()))
					{
						bpayGridList = paymentHistMap.get(bpaygrid.getYear());
						bpayGridList.add(bpaygrid);
					}
					else
					{
						bpayGridList = new ArrayList<>();
						bpayGridList.add(bpaygrid);
						paymentHistMap.put(bpaygrid.getYear(), bpayGridList);
					}
					
				}
				conscred.setPaymentHistMap(paymentHistMap);
			}
		    
            ConsumerMapper consumerMapper = new ConsumerMapper();
			value=consumerMapper.mapConsData(responseInfo);
			
        } 
		catch (SOAPException | JAXBException | IOException e)
		{
            // TODO Auto-generated catch block
            e.printStackTrace();
     }*/
	}

}
