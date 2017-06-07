package com.eir.report.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eir.bir.request.model.ConsumerList;
import com.eir.bir.request.model.MultipleRequest;
import com.eir.report.constant.Constant;
import com.eir.report.entity.Address;
import com.eir.report.entity.AddressType;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.CirRequest;
import com.eir.report.entity.ConsumerRequet;
import com.eir.report.entity.EntityDetails;
import com.eir.report.entity.ProductMaster;
import com.eir.report.entity.Request;
import com.eir.report.entity.State;
import com.eir.report.entity.UserDetails;
import com.eir.report.entity.UserRole;
import com.eir.report.repository.AddressRepository;
import com.eir.report.repository.AddressTypeRepository;
import com.eir.report.repository.BirRequestRepository;
import com.eir.report.repository.CirRequestRepository;
import com.eir.report.repository.ConsumerRequetRepository;
import com.eir.report.repository.EntityDetailsRepository;
import com.eir.report.repository.RequestRepository;
import com.eir.report.repository.StateRepository;
import com.eir.report.repository.UserDetailsRepository;
import com.eir.report.service.EirService;

@Service
public class EirServiceImpl implements EirService{
	
	Logger logger = LoggerFactory.getLogger(EirServiceImpl.class);
	
	@Autowired
	BirRequestRepository birRequestRepository;
	
	@Autowired
	AddressRepository addrRepository;
	
	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	AddressTypeRepository addressTypeRepository;
	
	@Autowired
	CirRequestRepository cirReqRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ConsumerRequetRepository consumerListRepository;
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	EntityDetailsRepository entityDetailsRepository;
	
	@Autowired
	UserDetailsRepository userDetailsRepository;
	
	@Override
	public List<BirRequest> retrieveRequest() {
		return birRequestRepository.findAll();
		//return null;
	}

	public void saveUser(Address adr) {
		
		 addrRepository.save(adr);
	}

	@Override
	public List<Address> getAddress() {
		return addrRepository.findAll();
	}

	@Override
	public List<State> getStateList() {
		
		return stateRepository.findAll();
	}

	@Override
	public List<AddressType> getAddressTypeList() {
		
		return addressTypeRepository.findAll();
	}

	@Override
	public void uploadKYCDocuments(HttpServletRequest request, HttpServletResponse response) {
		
		if (!ServletFileUpload.isMultipartContent(request)) {
			// if not, we stop here
			PrintWriter writer;
			try {
				writer = response.getWriter();
				writer.println("Error: Form must has enctype=multipart/form-data.");
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
			// configures upload settings
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// sets memory threshold - beyond which files are stored in disk
			factory.setSizeThreshold(Constant.MEMORY_THRESHOLD);
			// sets temporary location to store files
			factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

			ServletFileUpload upload = new ServletFileUpload(factory);

			// sets maximum size of upload file
			upload.setFileSizeMax(Constant.MAX_FILE_SIZE);

			// sets maximum size of request (include file + form data)
			upload.setSizeMax(Constant.MAX_REQUEST_SIZE);
			
			try {
				// parses the request's content to extract file data
				@SuppressWarnings("unchecked")
				List<FileItem> formItems = upload.parseRequest(request);

				System.out.println("no. of files ---- " + formItems.size());
				logger.debug("no. of files ---- " + formItems.size());
				if (formItems != null && formItems.size() > 0) {
					
					for (FileItem item : formItems) {
						byte[] bytes = item.get();
						// Creating the directory to store file
						//String rootPath = System.getProperty("catalina.home");
						ServletContext context = request.getServletContext();
						String appPath = context.getRealPath("");
						File dir = new File(appPath + File.separator + "uploaded");
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						File serverFile = new File(dir.getAbsolutePath() + File.separator + item.getFieldName());
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();
						
						System.out.println("Server File Location="	+ serverFile.getAbsolutePath());
						
						logger.info("Server File Location="	+ serverFile.getAbsolutePath());

					}
				}

			} catch (Exception e) {
				logger.debug(e.getMessage());
				e.printStackTrace();
			}
		
	}

	@Override
	public void downloadKYCDocuments(HttpServletRequest request, HttpServletResponse response) {

			// get absolute path of the application
			ServletContext context = request.getServletContext();
			String appPath = context.getRealPath("");
			System.out.println("appPath = " + appPath);
			String filePath = "uploaded";
			// construct the complete absolute path of the file
			String fullPath = appPath + filePath;		
			File downloadFile = new File(fullPath);
			FileInputStream inputStream = null;
			OutputStream outStream = null;
			try {
					inputStream = new FileInputStream(downloadFile);
					// get MIME type of the file
					String mimeType = context.getMimeType(fullPath);
					if (mimeType == null) {
						// set to binary type if MIME mapping not found
						mimeType = "application/octet-stream";
					}
					System.out.println("MIME type: " + mimeType);
			
					// set content attributes for the response
					response.setContentType(mimeType);
					response.setContentLength((int) downloadFile.length());
			
					// set headers for the response
					String headerKey = "Content-Disposition";
					String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
					response.setHeader(headerKey, headerValue);
			
					// get output stream of the response
					outStream = response.getOutputStream();
			
					byte[] buffer = new byte[Constant.BUFFER_SIZE];
					int bytesRead = -1;
			
					// write bytes read from the input stream into the output stream
					while ((bytesRead = inputStream.read(buffer)) != -1) {
						outStream.write(buffer, 0, bytesRead);
					}
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					inputStream.close();
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	
	@Override
	public void saveRequestedData(MultipleRequest input , HttpServletRequest request) {
		 		
		cirReqRepository.save(setCIRData(input , request));	
		addressRepository.save(setAddress(input));
		setConsumerListData(input , request);
	}
	
	private Address setAddress(MultipleRequest input) {
		Address addrsEntity = new Address();
			addrsEntity.setAddressLine1(input.getCir().getAddrLine1());
			addrsEntity.setAddressLine2(input.getCir().getAddrLine2());
			addrsEntity.setCity(input.getCir().getCity());
			addrsEntity.setState(input.getCir().getState());
			addrsEntity.setPincode(input.getCir().getPinCode());
		return addrsEntity;
	}

	private ConsumerRequet setConsumerListData(MultipleRequest input, HttpServletRequest request) {
		
		for (ConsumerList consumer_element : input.getConsumer()) {
			ConsumerRequet consumerEntity = new ConsumerRequet();
			
				consumerEntity.setRequest(input.getRequestObj());
				consumerEntity.setErnNumber(consumer_element.getErnNumber());
				consumerEntity.setScore(consumer_element.getScore());
				consumerEntity.setStatus(consumer_element.getStatus());
				consumerEntity.setRelationType(consumer_element.getRelationType());
				consumerEntity.setFirstName(consumer_element.getFirstName());
				consumerEntity.setMiddleName(consumer_element.getMiddleName());
				consumerEntity.setLastName(consumer_element.getLastName());
				consumerEntity.setPersonPan(consumer_element.getPersonPan());
				consumerEntity.setDrivingLic(consumer_element.getDrivingLic());
				consumerEntity.setAadharCard(consumer_element.getAadharhCard());
				consumerEntity.setVoterId(consumer_element.getVoterId());
				consumerEntity.setRationCard(consumer_element.getRationCard());
				consumerEntity.setPassportNo(consumer_element.getPassportNo());
				consumerEntity.setHomeTelephoneNo(consumer_element.getHomeTelephoneNo());
				consumerEntity.setOfficeTelephoneNo(consumer_element.getOfficeTelephoneNo());
				consumerEntity.setMobileNo(consumer_element.getMobileNo());
				consumerEntity.setBirthDate(consumer_element.getBirthDate());
				consumerEntity.setMaritalStatus(consumer_element.getMaritalStatus());
				consumerEntity.setGender(consumer_element.getGender());
				consumerEntity.setPersonAddrLine1(consumer_element.getPersonAddrLine1());
				consumerEntity.setPersonAddrLine2(consumer_element.getPersonAddrLine2());
				consumerEntity.setPersonCity(consumer_element.getPersonCity());
				consumerEntity.setPersonState(consumer_element.getPersonPincode());
				consumerEntity.setPersonPincode(consumer_element.getPersonPincode());
				
			consumerListRepository.save(consumerEntity);
		}
		return null;
	}

	private CirRequest setCIRData(MultipleRequest input, HttpServletRequest request) {
		CirRequest saveCir = new CirRequest();		
				
		saveCir.setRequest(input.getRequestObj());
		saveCir.setErnNumber(input.getCir().getErnNumber());
		saveCir.setStatus(input.getCir().getStatus());
		saveCir.setBankAccNo(input.getCir().getBankAccNo());
		saveCir.setProductField(input.getCir().getProductField());
		saveCir.setPurpose(input.getCir().getPurpose());
		saveCir.setAmount(input.getCir().getAmt());
		saveCir.setAccType1(input.getCir().getAccType1());
		saveCir.setAccType2(input.getCir().getAccType2());
		saveCir.setClientRefNo(input.getCir().getClientRefNo());
		saveCir.setCompanyPan(input.getCir().getCmpPan());
		saveCir.setAddrType(input.getCir().getAddrType());
		saveCir.setAddrLine1(input.getCir().getAddrLine1());
		saveCir.setAddrLine2(input.getCir().getAddrLine2());
		saveCir.setCity(input.getCir().getCity());   
		saveCir.setState(input.getCir().getState());
		saveCir.setPinCode(input.getCir().getPinCode());
		saveCir.setTelephoneNo(input.getCir().getTelephoneNo());
		saveCir.setPan(input.getCir().getPan());
		saveCir.setCin(input.getCir().getCin());
		saveCir.setTin(input.getCir().getTin());
		saveCir.setEmailId(input.getCir().getEmailId());
		saveCir.setTriggers(input.getCir().getTriggers());
		
		return saveCir;
	}

	@Override
	public Request createRequest(MultipleRequest input, HttpServletRequest request) {
		Request setRequestData = setRequestData(input,request);
 		requestRepository.save(setRequestData);
 		return setRequestData;
	}

	private Request setRequestData(MultipleRequest input, HttpServletRequest request) {
		Request reqEntity = new Request();
		
		reqEntity.setUserDetails(setUserDetails());
		reqEntity.setUserHit(1);//TODO temporarily harcode values saved
		if (input.getBir().getCinNumber() != null) 
		{
			reqEntity.setEntityDetails(getEntityObject(input,request));
		}
		reqEntity.setStatus("102");//TODO it should be integer
		reqEntity.setAdminHit(1);//TODO save according to admin hit
		reqEntity.setType("SPECIFIED");//TODO change according to FE flag
		reqEntity.setScore("200");//TODO calculate total score and push in to DB
		
		return reqEntity;
	}
	
	private UserDetails setUserDetails() {
	/*	UserDetails userSet = new UserDetails();
		userSet.setUserId(11);
		userSet.setUserRole(setUserRole());
		userSet.setFirstName("dev1");
		userSet.setLastName("dev1");*/
		
		UserDetails userSet = userDetailsRepository.findByUserId("user1");
		
		System.out.println("userSet");
		
		return userSet;
	}

	private UserRole setUserRole() {
		UserRole setUserRole = new UserRole();
		
		setUserRole.setRoleId(1);
		setUserRole.setDiscription("normal");		
		
		return setUserRole;
	}

	private EntityDetails getEntityObject(MultipleRequest input, HttpServletRequest request) {
		 EntityDetails getEntity = new EntityDetails();
			if ((input.getBir() == null) && (input.getBir().equals(null))) 
			{
				return getEntity;
			}
			else 
			{
				getEntity = entityDetailsRepository.findByEntityCin(input.getBir().getCinNumber());
				if (getEntity == null) {
					entityDetailsRepository.save(setEntityDetails(input,request));					
				}
			}
		
		return getEntity;
	}

	private EntityDetails setEntityDetails(MultipleRequest input, HttpServletRequest request) {
		
			EntityDetails entityObj = new EntityDetails();
			
			entityObj.setEntityName(input.getBir().getEntityName());
			entityObj.setEntityCin(input.getBir().getCinNumber());
		
		return entityObj;
	}
	
	/*private entityObj getEntityObj(bir inpur)
	{
		if(bir input is null)
		{
			return null;
		}
		
		
		getEntity form db by cin
		if exists then return\
		else
		{
			new entity obj
			set name and cin 
			save entity obj in db and return
		}
	}
	*/
	
	@Override
	public UserDetails getUserById(String userId)
	{
		UserDetails userDetails = userDetailsRepository.findByUserId(userId);
		return userDetails;
	}
}
