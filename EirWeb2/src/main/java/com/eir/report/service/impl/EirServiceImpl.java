package com.eir.report.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eir.bir.request.model.Consumer;
import com.eir.bir.request.model.Frequency;
import com.eir.bir.request.model.Gender;
import com.eir.bir.request.model.MultipleRequest;
import com.eir.bir.request.model.SpecifiedUserFlag;
import com.eir.model.EIRDataConstant;
import com.eir.model.EligibleReport;
import com.eir.report.constant.Constant;
import com.eir.report.entity.AccountType;
import com.eir.report.entity.Address;
import com.eir.report.entity.AddressType;
import com.eir.report.entity.BirRequest;
import com.eir.report.entity.CirPurpose;
import com.eir.report.entity.CirRequest;
import com.eir.report.entity.ConsumerFinancialPurpose;
import com.eir.report.entity.ConsumerPurpose;
import com.eir.report.entity.ConsumerRequest;
import com.eir.report.entity.EntityDetails;
import com.eir.report.entity.KycApproval;
import com.eir.report.entity.ProductMaster;
import com.eir.report.entity.RelationType;
import com.eir.report.entity.ReportSelection;
import com.eir.report.entity.ReportType;
import com.eir.report.entity.Request;
import com.eir.report.entity.State;
import com.eir.report.entity.Status;
import com.eir.report.entity.UserDetails;
import com.eir.report.entity.UserRole;
import com.eir.report.repository.AccountTypeRepository;
import com.eir.report.repository.AddressRepository;
import com.eir.report.repository.AddressTypeRepository;
import com.eir.report.repository.BirRequestRepository;
import com.eir.report.repository.CirPurposeRepository;
import com.eir.report.repository.CirRequestRepository;
import com.eir.report.repository.ConsumerFinancialPurposeRepository;
import com.eir.report.repository.ConsumerPurposeRepository;
import com.eir.report.repository.ConsumerRequetRepository;
import com.eir.report.repository.EntityDetailsRepository;
import com.eir.report.repository.FrequencyRepository;
import com.eir.report.repository.GenderRepository;
import com.eir.report.repository.KycApprovalRepository;
import com.eir.report.repository.ProductMasterRepository;
import com.eir.report.repository.RelationTypeRepository;
import com.eir.report.repository.ReportSelectionRepository;
import com.eir.report.repository.ReportTypeRepository;
import com.eir.report.repository.RequestRepository;
import com.eir.report.repository.StateRepository;
import com.eir.report.repository.StatusRepository;
import com.eir.report.repository.UserDetailsRepository;
import com.eir.report.service.BirReportService;
import com.eir.report.service.EirService;
import com.eir.report.service.NextGenWebService;
import com.eir.report.util.GetStatus;

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
	
	@Autowired
	CirPurposeRepository cirPurposeRepository;
	
	@Autowired
	AccountTypeRepository accntTypeRepository;
	
	@Autowired
	ReportTypeRepository reportTypeRepository;
	
	@Autowired
	RelationTypeRepository relationTypeRepository;
	
	@Autowired
	ConsumerPurposeRepository consumerPurposeRepository;
	
	@Autowired
	StatusRepository statusRepository;
	
	@Autowired
	ProductMasterRepository productMasterRepository;
	
	@Autowired
	EirService eirService;
	
	@Autowired
	BirReportService birService;
	
	@Autowired
	NextGenWebService nextGenWebService; 
	
	@Autowired
	ConsumerFinancialPurposeRepository consumerFinancialPurposeRepository;
	
	@Autowired
	ReportSelectionRepository reportSelectionRepository;
	
	@Autowired
	GenderRepository genderRepository; 
	
	@Autowired
	KycApprovalRepository kycApprovalRepository;
	
	@Autowired
	FrequencyRepository frequencyRepository;
	
	
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
	public List<com.eir.bir.request.model.State> getStateList() {
		
		return getStateMapperList(stateRepository.findAll());
	}

	private List<com.eir.bir.request.model.State> getStateMapperList(List<State> entityStateList) 
	{
		if(entityStateList != null && !entityStateList.isEmpty())
		{
			List<com.eir.bir.request.model.State> stateList = new ArrayList<>();
			for (State state : entityStateList) 
			{
				com.eir.bir.request.model.State responceObj = new com.eir.bir.request.model.State();
				
				responceObj.setStateId(state.getStateId());
				responceObj.setStateDescription(state.getStateCodeDescription());
				
				stateList.add(responceObj);				
			}
			return stateList;
		}
		return null;
	}

	@Override
	public List<com.eir.bir.request.model.AddressType> getAddressTypeList() {
		
		return getAddressTypeMapper(addressTypeRepository.findAll());
	}
	
	private List<com.eir.bir.request.model.AddressType> getAddressTypeMapper(List<AddressType> entityAddressType) 
	{
		if (entityAddressType != null && !entityAddressType.isEmpty()) 
		{
			List<com.eir.bir.request.model.AddressType> adrssTypeList = new ArrayList<com.eir.bir.request.model.AddressType>();
			for (AddressType addressType : entityAddressType) 
			{
				com.eir.bir.request.model.AddressType responceSddrsTypeObj = new com.eir.bir.request.model.AddressType();
				
				responceSddrsTypeObj.setAddressTypeId(addressType.getAddressTypeId());
				responceSddrsTypeObj.setAddressTypeDescription(addressType.getAddressTypeDescription());
				
				adrssTypeList.add(responceSddrsTypeObj);
			}			
			return adrssTypeList;
		}
		return null;
	}
	
	/*@Override
	public void saveRequestedData(MultipleRequest input , HttpServletRequest request) {
		 		
		//cirReqRepository.save(setCIRData(input , request));
		addressRepository.save(createAddress(input.getCir()));
		setConsumerListData(input , request);
	}*/
	
	private Address createAddress(com.eir.bir.request.model.CirRequest cirReq) {
		Address addrsEntity = new Address();
			addrsEntity.setAddressLine1(cirReq.getAddrLine1());
			addrsEntity.setAddressLine2(cirReq.getAddrLine2());
			addrsEntity.setCity(cirReq.getCity());
			addrsEntity.setStateId(cirReq.getCirState().getStateId());
			addrsEntity.setPincode(cirReq.getPinCode());
			AddressType addressType = addressTypeRepository.findByAddressTypeId(cirReq.getAddrType().getAddressTypeId());
			addrsEntity.setAddressType(addressType);
			addressRepository.save(addrsEntity);
		return addrsEntity;
	}

	/*private ConsumerRequest setConsumerListData(MultipleRequest input, HttpServletRequest request) {
		
		for (Consumer consumer_element : input.getConsumer()) {
			ConsumerRequest consumerEntity = new ConsumerRequest();
			
				consumerEntity.setRequest(input.getRequestObj());
				//consumerEntity.setErnNumber(consumer_element.getErnNumber());
				consumerEntity.setScore(consumer_element.getScore());
				consumerEntity.setStatus(consumer_element.getStatus());
				consumerEntity.setRelationType(setRelationType(consumer_element));
				consumerEntity.setAccountType(setAccntType(consumer_element));
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
				//consumerEntity.setBirthDate(consumer_element.getBirthDate());
				consumerEntity.setMaritalStatus(consumer_element.getMaritalStatus());
				consumerEntity.setGender(consumer_element.getGender());
				consumerEntity.setPersonAddrLine1(consumer_element.getPersonAddrLine1());
				consumerEntity.setPersonAddrLine2(consumer_element.getPersonAddrLine2());
				consumerEntity.setPersonCity(consumer_element.getPersonCity());
				consumerEntity.setPersonState(consumer_element.getPersonPincode());
				consumerEntity.setPersonPincode(consumer_element.getPersonPincode());
				consumerEntity.setAmount(consumer_element.getAmount());
				
			consumerListRepository.save(consumerEntity);
		}
		return null;
	}*/

	private CirRequest mapCirInputToCIRRequest(com.eir.bir.request.model.CirRequest cirRequest, Request request) {
		CirRequest cirRequestEntity = new CirRequest();		
				
		cirRequestEntity.setRequest(request);
		cirRequestEntity.setStatus(getStatusByDescription(com.eir.report.constant.Status.IN_PROCCESS.status()));
		cirRequestEntity.setBusName(cirRequest.getCompanyName());
		cirRequestEntity.setProductField(cirRequest.getProductField().getReportTypeId());
		cirRequestEntity.setPurposeId(cirRequest.getCirPurpose().getCirPurposeId());
		cirRequestEntity.setCompanyPan(cirRequest.getCmpPan());
		cirRequestEntity.setAddress(createAddress(cirRequest));
		
		cirRequestEntity.setTelephoneNo(cirRequest.getTelephoneNo());
		cirRequestEntity.setCin(cirRequest.getCin());
		cirRequestEntity.setTin(cirRequest.getTin());
		cirRequestEntity.setEmailId(cirRequest.getEmailId());
		
		cirReqRepository.save(cirRequestEntity);
		return cirRequestEntity;
	}
	
	
	private List<ConsumerRequest> mapConsumerInputToConsumerRequest(List<Consumer>  consumerInputList, Request requestEntity, CirRequest cirRequestEntity) 
	{
		List<ConsumerRequest> consumerEntityRequestList = null;
		
		if(consumerInputList != null && !consumerInputList.isEmpty())
		{
			consumerEntityRequestList = new ArrayList<>();
			for(Consumer consumerInput: consumerInputList)
			{
				ConsumerRequest consumerEntity = new ConsumerRequest();
				consumerEntity.setRequest(requestEntity);
				consumerEntity.setCirRequest(cirRequestEntity);
				//consumerEntity.setErnNumber(consumerInput.getErnNumber());
				consumerEntity.setScore(consumerInput.getScore());
				consumerEntity.setStatusId(getStatusByDescription(com.eir.report.constant.Status.IN_PROCCESS.status()));
				consumerEntity.setRelationTypeId(consumerInput.getRelationType().getRelationTypeId()); 
				consumerEntity.setEnquiryAccountTypeId(consumerInput.getAccountType().getAccntTypeId());
				consumerEntity.setEnquiryCreditPurposeId(consumerInput.getConsumerFinancialPurpose().getFinancialPurposeId());
				consumerEntity.setPurposeId(consumerInput.getConsumerPurpose().getPurposeId());
				consumerEntity.setFirstName(consumerInput.getFirstName());
				consumerEntity.setMiddleName(consumerInput.getMiddleName());
				consumerEntity.setLastName(consumerInput.getLastName());
				consumerEntity.setPersonPan(consumerInput.getPersonPan());
				consumerEntity.setDrivingLic(consumerInput.getDrivingLic());
				consumerEntity.setAadharCard(consumerInput.getAadharhCard());
				consumerEntity.setVoterId(consumerInput.getVoterId());
				consumerEntity.setRationCard(consumerInput.getRationCard());
				consumerEntity.setPassportNo(consumerInput.getPassportNo());
				consumerEntity.setHomeTelephoneNo(consumerInput.getHomeTelephoneNo());
				consumerEntity.setOfficeTelephoneNo(consumerInput.getOfficeTelephoneNo());
				consumerEntity.setMobileNo(consumerInput.getMobileNo());
				consumerEntity.setDateOfBirth(consumerInput.getBirthDate());
				consumerEntity.setMaritalStatus(consumerInput.getMaritalStatus());
				consumerEntity.setGenderId(consumerInput.getGender().getId());
				
				consumerEntity.setAddressId(createAddressForConsumerList(consumerInput));
								
				consumerEntity.setEnquiryAmount(consumerInput.getAmount());
				consumerListRepository.save(consumerEntity);
				consumerEntityRequestList.add(consumerEntity);
			}
		}
		return consumerEntityRequestList;
	}
	
	private Address createAddressForConsumerList(Consumer consumerReq) {
		Address addrsEntity = new Address();
			addrsEntity.setAddressLine1(consumerReq.getPersonAddrLine1());
			addrsEntity.setAddressLine2(consumerReq.getPersonAddrLine2());
			addrsEntity.setCity(consumerReq.getPersonCity());
			addrsEntity.setStateId(consumerReq.getPersonState().getStateId());
			addrsEntity.setPincode(consumerReq.getPersonPincode());
			AddressType addressType = addressTypeRepository.findByAddressTypeId(consumerReq.getAddressType().getAddressTypeId());
			addrsEntity.setAddressType(addressType);
			addressRepository.save(addrsEntity);
		return addrsEntity;
	}
	
	@Override
	public Request createRequest(MultipleRequest input, HttpServletRequest request) 
	{
		Request reqEntity = new Request();
		reqEntity.setUserDetails(getUserDetails(Constant.HARDCOADED_USERID));
		reqEntity.setUserHit(1);//TODO temporarily harcode values saved
		reqEntity.setEntityDetails(getEntityObject(input,request));
		reqEntity.setStatus(getStatusByDescription(com.eir.report.constant.Status.IN_PROCCESS.status()));
		reqEntity.setAdminHit(1);//TODO save according to admin hit
		reqEntity.setType(Constant.SPECIFIED);//TODO change according to FE flag
		
 		requestRepository.save(reqEntity);
 		
 		if (input.getIsBIRActive()) 
		{
			birService.createBIRrequest(input.getBir(), reqEntity);					
		}
		
		if (input.getIsCIRActive() || input.getIsComboActive()) 
		{
			
			CirRequest cirInputRequest = mapCirInputToCIRRequest(input.getCir(), reqEntity);
			
			CirRequest cirRequestEntity = nextGenWebService.createCIRReport(cirInputRequest );
			
			
			if (input.getIsComboActive()) 
			{
				List<ConsumerRequest> consumerEntityRequest = mapConsumerInputToConsumerRequest(input.getConsumerList(), reqEntity, cirRequestEntity);
				nextGenWebService.createConsumerReport(consumerEntityRequest);
			}
		}
		
 		return reqEntity;
	}

	/*private Request setRequestData(MultipleRequest input, HttpServletRequest request) {
		Request reqEntity = new Request();
		
		reqEntity.setUserDetails(getUserDetails());
		reqEntity.setUserHit(1);//TODO temporarily harcode values saved
		reqEntity.setEntityDetails(getEntityObject(input,request));
		reqEntity.setStatus(getStatus(com.eir.report.constant.Status.IN_PROCCESS.status()));//TODO it should be integer
		reqEntity.setAdminHit(1);//TODO save according to admin hit
		reqEntity.setType(Constant.SPECIFIED);//TODO change according to FE flag
		//reqEntity.setScore("200");//TODO calculate total score and push in to DB
		return reqEntity;
	}*/
	
	private ProductMaster setProductMaster() {
		return productMasterRepository.findByproductId(101);
	}


	private UserDetails getUserDetails(Integer userID) 
	{
		UserDetails userSet = userDetailsRepository.findByUserId(userID);
		System.out.println("userSet");
		return userSet;
	}

	private UserRole setUserRole() {
		UserRole setUserRole = new UserRole();
		
		setUserRole.setRoleId(1);
		setUserRole.setDiscription("normal");		
		
		return setUserRole;
	}

	private EntityDetails getEntityObject(MultipleRequest input, HttpServletRequest request) 
	{
		 EntityDetails getEntity = null;
			if(input.getBir() != null && input.getBir().getCompany().getCinNumber() != null && !input.getBir().getCompany().getCinNumber().isEmpty())  
			{
				getEntity = entityDetailsRepository.findByEntityCin(input.getBir().getCompany().getCinNumber());
				if(getEntity == null)
				{
					getEntity =  createEntityDetails(input.getBir());
				}
			}
		
		return getEntity;
	}

	private EntityDetails createEntityDetails(com.eir.bir.request.model.BirRequest birInput) 
	{
		EntityDetails entityObj = new EntityDetails();
		entityObj.setEntityName(birInput.getCompany().getEntityName());
		entityObj.setEntityCin(birInput.getCompany().getCinNumber());
		return entityDetailsRepository.save(entityObj);
	}

	@Override
	public List<com.eir.bir.request.model.CirPurpose> getCirPurposeList() {
		return cirPurposeMapper(cirPurposeRepository.findAll());
	}

	@Override
	public List<com.eir.bir.request.model.AccountType> getAccountTypeList() {
		return getAccntTypeMapper(accntTypeRepository.findAll());
	}

	private List<com.eir.bir.request.model.AccountType> getAccntTypeMapper(List<AccountType> entityAccountType) {
		
		if (entityAccountType != null && !entityAccountType.isEmpty()) 
		{
			List<com.eir.bir.request.model.AccountType> accntTypeList = new ArrayList<com.eir.bir.request.model.AccountType>();
			for (AccountType accountType : entityAccountType) 
			{
				com.eir.bir.request.model.AccountType accntTypeResponce = new com.eir.bir.request.model.AccountType();
				
				accntTypeResponce.setAccntTypeId(accountType.getAccntTypeId());
				accntTypeResponce.setAccntTypeDescription(accountType.getAccntTypeDescription());
				accntTypeList.add(accntTypeResponce);
			}
			return accntTypeList;
		}
		return null;
	}

	@Override
	public List<com.eir.bir.request.model.ReportType> getReportTypeList() {
		return getReportTypeMapper(reportTypeRepository.findAll());
	}
	
	private List<com.eir.bir.request.model.ReportType> getReportTypeMapper(List<ReportType> entityReportType) 
	{
		 if (entityReportType != null && !entityReportType.isEmpty()) 
		 {
			 List<com.eir.bir.request.model.ReportType> reportTypeList = new ArrayList<com.eir.bir.request.model.ReportType>();
			 for (ReportType reportType : entityReportType) 
			 {
				 com.eir.bir.request.model.ReportType reportTypeResponse = new com.eir.bir.request.model.ReportType();
				 reportTypeResponse.setReportTypeId(reportType.getReportTypeId());
				 reportTypeResponse.setReportTypeDescription(reportType.getReportTypeDescription());
				 
				 reportTypeList.add(reportTypeResponse);			
			}
			return reportTypeList;
		}
		return null;
	}

	public UserDetails getUserById(Integer userId)
	{
		UserDetails userDetails = userDetailsRepository.findByUserId(userId);
		return userDetails;
	}
	@Override
	public List<com.eir.bir.request.model.RelationType> getRelationTypeList() {
		return getRelatnTypeMapper(relationTypeRepository.findAll());
	}

	private List<com.eir.bir.request.model.RelationType> getRelatnTypeMapper(List<RelationType> entityRelatnType) 
	{
		if (entityRelatnType != null && !entityRelatnType.isEmpty()) 
		{
			List<com.eir.bir.request.model.RelationType> reltnTypeList = new ArrayList<com.eir.bir.request.model.RelationType>();
			for (RelationType relationType : entityRelatnType) 
			{
				com.eir.bir.request.model.RelationType relatnTypeResponce = new com.eir.bir.request.model.RelationType();
				
				Integer convertedRelationTypeId = Integer.parseInt(relationType.getRelationTypeId());
				relatnTypeResponce.setRelationTypeId(convertedRelationTypeId);
				relatnTypeResponce.setRelationTypeDescription(relationType.getRelationTypeDescription());
				reltnTypeList.add(relatnTypeResponce);
			}
			return reltnTypeList;
		}
		return null;
	}

	@Override
	public List<com.eir.bir.request.model.ConsumerPurpose> getConsumerPurposeList() {
		return getConsumerPurposeMapper(consumerPurposeRepository.findAll());
	}
	
	private List<com.eir.bir.request.model.ConsumerPurpose> getConsumerPurposeMapper(List<ConsumerPurpose> entityConsumrPurpose) 
	{
		if (entityConsumrPurpose != null && !entityConsumrPurpose.isEmpty()) 
		{
			List<com.eir.bir.request.model.ConsumerPurpose> consumerPurposesList = new ArrayList<com.eir.bir.request.model.ConsumerPurpose>();
			for (ConsumerPurpose consumerPurpose : entityConsumrPurpose) 
			{
				com.eir.bir.request.model.ConsumerPurpose consumerPurposeResponce = new com.eir.bir.request.model.ConsumerPurpose();
				
				
				consumerPurposeResponce.setPurposeId(consumerPurpose.getPurposeId());
				consumerPurposeResponce.setDescription(consumerPurpose.getDescription());
				consumerPurposesList.add(consumerPurposeResponce);				
			}
			return consumerPurposesList;			
		}
		return null;
	}

	@Override
	public List<com.eir.bir.request.model.ConsumerFinancialPurpose> findConsumerFinancialPurposeByPurposeId(Integer purposeId) 
	{
		return consumerFinancialPurposeMapper(consumerFinancialPurposeRepository.findBypurposeId(purposeId));
	}
	
	@Override
	public void uploadKYCDocuments(HttpServletRequest request, HttpServletResponse response) {
		
		StringBuilder fileName = new StringBuilder();
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
						
						if(fileName.toString().isEmpty())
						{
							fileName.append(item.getFieldName());	
						}else{
							fileName.append(",");
							fileName.append(item.getFieldName());	
						}
					}
				}
				
				KycApproval kycApprval = new KycApproval();
				
				kycApprval.setRequestId(3242);
				kycApprval.setComment("uploaded completed");
				//fileName.replace(fileName.length()-1, fileName.length()-1, "");
				//fileName.replace(fileName.length()-1, fileName.length(), " ");
				kycApprval.setKycDocument(fileName.toString());
				kycApprval.setStatus(getStatusByDescription(com.eir.report.constant.Status.PENDING.status()).getStatusId());
				
				kycApprovalRepository.save(kycApprval);

			} catch (Exception e) {
				logger.debug(e.getMessage());
				e.printStackTrace();
			}
		
	}

	@Override
	public void downloadKYCDocuments(int reqId,String fileName, HttpServletRequest request, HttpServletResponse response) {

			// get absolute path of the application
			ServletContext context = request.getServletContext();
			String appPath = context.getRealPath("");
			System.out.println("appPath = " + appPath);
			String filePath = "uploaded";
			// construct the complete absolute path of the file
			String path = "/"+reqId+"/"+fileName;
			String path1 = "C:/angulr2";
			//String fullPath = appPath + filePath + path;	
			String fullPath = path1 + path;		
			File downloadFile = new File(fullPath);
			//File downloadFile = new File("C:/Users/c19221a/Documents/EIR_workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/EirWeb2/uploaded/kk.txt");
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
	public boolean saveSelectedProduct(EligibleReport selection) 
	{
		Request reqEntity = new Request();
		reqEntity.setUserDetails(getUserDetails(Constant.HARDCOADED_USERID));
		reqEntity.setUserHit(1);//TODO temporarily harcode values saved
		//reqEntity.setEntityDetails(getEntityObject(input,request));
		reqEntity.setStatus(getStatusByDescription(com.eir.report.constant.Status.IN_PROCCESS.status()));
		reqEntity.setAdminHit(1);//TODO save according to admin hit
		reqEntity.setType(Constant.SPECIFIED);//TODO change according to FE flag
		
 		requestRepository.save(reqEntity);
 		
			List<ReportSelection> addintoList = new ArrayList<ReportSelection>();
							
			if (selection.getComboWithScore()) {	
				ReportSelection cws = new ReportSelection();
				cws.setProductCode(EIRDataConstant.COMBOWITHSCORE);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.COMBOWITHSCORE);
				cws.setProductId(comboWithScore.getProductId());
				cws.setRequestId(reqEntity.getRequestId());
				addintoList.add(cws);
			}
			if(selection.getComboWithoutScore())
			{
				ReportSelection cwos = new ReportSelection();
				cwos.setProductCode(EIRDataConstant.COMBOWITHOUTSCORE);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.COMBOWITHOUTSCORE);
				cwos.setProductId(comboWithScore.getProductId());
				cwos.setRequestId(reqEntity.getRequestId());
				addintoList.add(cwos);
			}
			if(selection.getCommWithScore())
			{
				ReportSelection cirws = new ReportSelection();
				cirws.setProductCode(EIRDataConstant.CIRWITHSCORE);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.CIRWITHSCORE);
				cirws.setProductId(comboWithScore.getProductId());
				cirws.setRequestId(reqEntity.getRequestId());
				addintoList.add(cirws);
			}
			if(selection.getCommWithoutScore())
			{
				ReportSelection cirwos = new ReportSelection();
				cirwos.setProductCode(EIRDataConstant.CIRWITHOUTSCORE);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.CIRWITHOUTSCORE);
				cirwos.setProductId(comboWithScore.getProductId());
				cirwos.setRequestId(reqEntity.getRequestId());
				addintoList.add(cirwos);
			}
			if(selection.getLitigation())
			{
				ReportSelection let = new ReportSelection();
				let.setProductCode(EIRDataConstant.LETIGATION);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.LETIGATION);
				let.setProductId(comboWithScore.getProductId());
				let.setRequestId(reqEntity.getRequestId());
				addintoList.add(let);
			}
			if(selection.getNewsFeed())
			{
				ReportSelection newsfeed = new ReportSelection();
				newsfeed.setProductCode(EIRDataConstant.NEWSFEED);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.NEWSFEED);
				newsfeed.setProductId(comboWithScore.getProductId());
				newsfeed.setRequestId(reqEntity.getRequestId());
				addintoList.add(newsfeed);
			}
			if(selection.getSme())
			{
				ReportSelection sme = new ReportSelection();
				sme.setProductCode(EIRDataConstant.SME);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.SME);
				sme.setProductId(comboWithScore.getProductId());
				sme.setRequestId(reqEntity.getRequestId());
				addintoList.add(sme);
			}
			if(selection.getBir())
			{
				ReportSelection bir = new ReportSelection();
				bir.setProductCode(EIRDataConstant.BIR);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.BIR);
				bir.setProductId(comboWithScore.getProductId());
				bir.setRequestId(reqEntity.getRequestId());
				addintoList.add(bir);
			}
			
			reportSelectionRepository.save(addintoList);
			return true;
	}
	
	public Status getStatusByDescription(String statusDesc)
	{
		if(statusDesc != null && !statusDesc.isEmpty())
		{
			return statusRepository.findBystatusDescription(statusDesc);	
		}
		return null;
	}
	
	private List<com.eir.bir.request.model.CirPurpose> cirPurposeMapper(List<CirPurpose> cirPurposeEntityList)
	{
		if(cirPurposeEntityList != null && !cirPurposeEntityList.isEmpty())
		{
			List<com.eir.bir.request.model.CirPurpose> cirPurposeList = new ArrayList<>();
			for(CirPurpose entity: cirPurposeEntityList)
			{
				com.eir.bir.request.model.CirPurpose cirPurposeResponseObj = new com.eir.bir.request.model.CirPurpose();
				cirPurposeResponseObj.setCirPurposeId(entity.getCirPurposeId());
				cirPurposeResponseObj.setCirPurposeDescription(entity.getCirPurposeDescription());
				cirPurposeList.add(cirPurposeResponseObj);
			}
			return cirPurposeList;
		}
		return null;
	}
	
	private List<com.eir.bir.request.model.ConsumerFinancialPurpose> consumerFinancialPurposeMapper(List<ConsumerFinancialPurpose> consumerFinancialPurposeEntityList)
	{
		if(consumerFinancialPurposeEntityList != null && !consumerFinancialPurposeEntityList.isEmpty())
		{
			List<com.eir.bir.request.model.ConsumerFinancialPurpose> consumerFinancialPurposeList = new ArrayList<>();
			for(ConsumerFinancialPurpose entity: consumerFinancialPurposeEntityList)
			{
				com.eir.bir.request.model.ConsumerFinancialPurpose consumerFinancialPurpose = new com.eir.bir.request.model.ConsumerFinancialPurpose();
				consumerFinancialPurpose.setFinancialPurposeId(entity.getFinancialPurposeId());
				consumerFinancialPurpose.setPurposeId(entity.getPurposeId());
				consumerFinancialPurpose.setFinancialDescription(entity.getDescription());
				consumerFinancialPurposeList.add(consumerFinancialPurpose);
			}
			return consumerFinancialPurposeList;
		}
		return null;
	}

	@Override
	public List<Gender> getGender() 
	{
		List<com.eir.report.entity.Gender> genderList = genderRepository.findAll();
		if(genderList != null && !genderList.isEmpty())
		{
			List<Gender> genderModelList = new ArrayList<>();
			for(com.eir.report.entity.Gender entity: genderList)
			{
				Gender gender = new Gender();
				gender.setId(entity.getId());
				gender.setDescription(entity.getDescription());
				genderModelList.add(gender);
			}
			return genderModelList;
		}
		return null;
	}

	@Override
	public SpecifiedUserFlag getSpecifiedUserFlag() {
		//userDetailsRepository.get
		
		return null;
	}

	@Override
	public List<Frequency> getFrequency() {
		
		return getFrequencyMapper(frequencyRepository.findAll());
	}

	private List<Frequency> getFrequencyMapper(List<com.eir.report.entity.Frequency> frequencyEnittyList) {

		if(frequencyEnittyList != null && !frequencyEnittyList.isEmpty())
		{
			List<Frequency> frequencyList = new ArrayList<>();
			for(com.eir.report.entity.Frequency entity: frequencyEnittyList)
			{
				Frequency frequencyResponseObj = new Frequency();
				frequencyResponseObj.setFrequencyId(entity.getFrequencyId());
				frequencyResponseObj.setFrequencyDescription(entity.getFrequencyDescription());
				frequencyList.add(frequencyResponseObj);
			}
			return frequencyList;
		}
		return null;	
	}
	
}
