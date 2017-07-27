package com.eir.report.service.impl;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.eir.bir.request.model.Consumer;
import com.eir.bir.request.model.Frequency;
import com.eir.bir.request.model.Gender;
import com.eir.bir.request.model.MultipleRequest;
import com.eir.bir.request.model.SpecifiedUserFlag;
import com.eir.commercial.domains.CommonUtilityService;
import com.eir.domain.BIRDomain;
import com.eir.domain.ComboDomain;
import com.eir.domain.EIRDomain;
import com.eir.model.DashboardObject;
import com.eir.model.BIRObject;
import com.eir.model.CIRWithOutScoreObject;
import com.eir.model.CIRWithScoreObject;
import com.eir.model.ComboWithScoreObject;
import com.eir.model.ComboWithoutScoreObject;
import com.eir.model.DashboardObject;
import com.eir.model.EIRDataConstant;
import com.eir.model.EligibleReport;
import com.eir.model.MemberObject;
import com.eir.model.ViewEarlierEnqRequestObject;
import com.eir.model.ViewEarlierEnquiresObject;
import com.eir.model.ViewEnquiryObject;
import com.eir.model.bir.CompanyReportType;
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
import com.eir.report.entity.Member;
import com.eir.report.entity.MemberProductMapping;
import com.eir.report.entity.ProductMaster;
import com.eir.report.entity.RelationType;
import com.eir.report.entity.ReportSelection;
import com.eir.report.entity.ReportType;
import com.eir.report.entity.Request;
import com.eir.report.entity.State;
import com.eir.report.entity.Status;
import com.eir.report.entity.UserDetails;
import com.eir.report.entity.UserRole;
import com.eir.report.nextgen.service.mapper.CreateReport;
import com.eir.report.repository.AccountTypeRepository;
import com.eir.report.repository.AddressRepository;
import com.eir.report.repository.AddressTypeRepository;
import com.eir.report.repository.BirRequestRepository;
import com.eir.report.repository.CirPurposeRepository;
import com.eir.report.repository.CirRequestRepository;
import com.eir.report.repository.ConsumerFinancialPurposeRepository;
import com.eir.report.repository.ConsumerPurposeRepository;
import com.eir.report.repository.ConsumerRequetRepository;
import com.eir.report.repository.DisputeRepository;
import com.eir.report.repository.EntityDetailsRepository;
import com.eir.report.repository.FrequencyRepository;
import com.eir.report.repository.GenderRepository;
import com.eir.report.repository.KycApprovalRepository;
import com.eir.report.repository.MemberRepository;
import com.eir.report.repository.MemberProductMappingRepository;
import com.eir.report.repository.MemberUserMappingRepository;
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
import com.eir.report.util.WriteFile;

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
	DisputeRepository disputeRepository;
	
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
	
	@Autowired
	MemberUserMappingRepository memberUserMappingRepository;
	
	@Autowired
	MemberProductMappingRepository memberProductMappingRepository;
	
	@Value("${outputXml.path}")
	private String xmlOutputPath;
	
	@Autowired
	MemberRepository memberRepository;
		
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
		
		//return getStateMapperList(stateRepository.findAll());
		return getStateMapperList(stateRepository.findAllByOrderByStateDescriptionAsc());
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
			AddressType addressType = null;
			if(cirReq.getAddrType() != null)
			{
				addressType = addressTypeRepository.findByAddressTypeId(cirReq.getAddrType().getAddressTypeId());
			}
			else
			{
				addressType = addressTypeRepository.findByAddressTypeId(Constant.REGISTERED_LEGAL_OFFICE_ADDRESS_ID);
			}
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

	private CirRequest mapCirInputToCIRRequest(com.eir.bir.request.model.CirRequest cirRequest, Request request,String statusDescription) {
		CirRequest cirRequestEntity = new CirRequest();		
				
		cirRequestEntity.setRequest(request);
		cirRequestEntity.setStatus(getStatusByDescription(statusDescription));
		cirRequestEntity.setBusName(cirRequest.getCompanyName());
		if(cirRequest.getProductField() != null)
		{
			cirRequestEntity.setProductField(cirRequest.getProductField().getReportTypeId());	
		}
		
		if(cirRequest.getCirPurpose() != null)
		{
			cirRequestEntity.setPurposeId(cirRequest.getCirPurpose().getCirPurposeId());	
		}
		
		cirRequestEntity.setCompanyPan(cirRequest.getCmpPan());
		cirRequestEntity.setAddress(createAddress(cirRequest));
		
		cirRequestEntity.setTelephoneNo(cirRequest.getTelephoneNo());
		cirRequestEntity.setCin(cirRequest.getCin());
		cirRequestEntity.setTin(cirRequest.getTin());
		cirRequestEntity.setEmailId(cirRequest.getEmailId());
		
		cirReqRepository.save(cirRequestEntity);
		return cirRequestEntity;
	}
	
	
	private List<ConsumerRequest> mapConsumerInputToConsumerRequest(List<Consumer>  consumerInputList, Request requestEntity, String statusDescription,CirRequest cirRequestEntity) 
	{
		List<ConsumerRequest> consumerEntityRequestList = null;
		
		if(consumerInputList != null && !consumerInputList.isEmpty())
		{
			consumerEntityRequestList = new ArrayList<>();
			for(Consumer consumerInput: consumerInputList)
			{
				ConsumerRequest consumerEntity = new ConsumerRequest();
				
				DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
				DateTime dob = formatter.parseDateTime(consumerInput.getBirthDate().getFormatted());
				
				consumerEntity.setRequest(requestEntity);
				consumerEntity.setCirRequest(cirRequestEntity);
				//consumerEntity.setErnNumber(consumerInput.getErnNumber());
				consumerEntity.setBureauMemberId(Constant.BUREAU_MEMBER_ID);
				consumerEntity.setProductField(Constant.CONSPRODUCTFIELD);
				consumerEntity.setScore(consumerInput.getScore());
				consumerEntity.setStatusId(getStatusByDescription(statusDescription));
				if(consumerInput.getRelationType() != null )
				{
					consumerEntity.setRelationTypeId(consumerInput.getRelationType().getRelationTypeId());	
				}
				
				if(consumerInput.getAccountType() != null)
				{
					consumerEntity.setEnquiryAccountTypeId(consumerInput.getAccountType().getAccntTypeId());
				}
				
				consumerEntity.setEnquiryCreditPurposeId(consumerInput.getConsumerFinancialPurpose().getFinancialPurposeId());
				consumerEntity.setPurposeId(consumerInput.getConsumerPurpose().getPurposeId());
				consumerEntity.setPurposeOfInquiry(consumerInput.getConsumerPurpose().getPurposeId());
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
				consumerEntity.setDateOfBirth(dob);
				consumerEntity.setMaritalStatus(consumerInput.getMaritalStatus());
				consumerEntity.setGenderId(consumerInput.getGender().getId());
				if(consumerInput.getFrequency() != null)
				{
					consumerEntity.setFrequencyId(consumerInput.getFrequency().getFrequencyId());
				}
				consumerEntity.setDurationOfAgreement(consumerInput.getDurationOfAgreement());
				
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
			addrsEntity.setPincode(consumerReq.getPersonPinCode());
			AddressType addressType = null;
			if(consumerReq.getAddressType() != null)
			{
				addressType = addressTypeRepository.findByAddressTypeId(consumerReq.getAddressType().getAddressTypeId());	
			}
			else
			{
				addressType = addressTypeRepository.findByAddressTypeId(Constant.REGISTERED_LEGAL_OFFICE_ADDRESS_ID);
			}
			addrsEntity.setAddressType(addressType);
			addressRepository.save(addrsEntity);
		return addrsEntity;
	}
	
	@Override
	public Request createRequest(MultipleRequest input, HttpServletRequest request) 
	{
		/*Request reqEntity = new Request();
		reqEntity.setUserDetails(getUserDetails(Constant.HARDCOADED_USERID));
		reqEntity.setUserHit(1);//TODO temporarily harcode values saved
		reqEntity.setEntityDetails(getEntityObject(input,request));
		reqEntity.setStatus(getStatusByDescription(com.eir.report.constant.Status.IN_PROCCESS.status()));
		reqEntity.setAdminHit(1);//TODO save according to admin hit
		reqEntity.setType(Constant.SPECIFIED);//TODO change according to FE flag
		
 		requestRepository.save(reqEntity);*/
 		Integer requestId = input.getRequestId();
 		Request reqEntity = requestRepository.findByRequestId(requestId);
 		CirRequest cirRequestEntity = new CirRequest();
 		
 		if (input.getIsBIRActive()) 
		{
			birService.createBIRrequest(input.getBir(), reqEntity,reqEntity.getStatus().getStatusDescription());					
		}
		
		if (input.getIsCIRActive() || input.getIsComboActive()) 
		{
			
			CirRequest cirInputRequest = mapCirInputToCIRRequest(input.getCir(), reqEntity,reqEntity.getStatus().getStatusDescription());
			
			if(Constant.SPECIFIED.equalsIgnoreCase(reqEntity.getType())){
				cirRequestEntity = nextGenWebService.createCIRReport(cirInputRequest );
			}
			
			if (input.getIsComboActive()) 
			{
				List<ConsumerRequest> consumerEntityRequest = mapConsumerInputToConsumerRequest(input.getConsumerList(), reqEntity,reqEntity.getStatus().getStatusDescription(), cirRequestEntity);
				if(Constant.SPECIFIED.equalsIgnoreCase(reqEntity.getType())){
					nextGenWebService.createConsumerReport(consumerEntityRequest);
				}
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
	public void uploadKYCDocuments(HttpServletRequest request, HttpServletResponse response,Integer requestId) {
		
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
				String kycDocumentFilePath = null;
				String description = null;
				// parses the request's content to extract file data
				@SuppressWarnings("unchecked")
				List<FileItem> formItems = upload.parseRequest(request);

				System.out.println("no. of files ---- " + formItems.size());
				logger.debug("no. of files ---- " + formItems.size());
				if (formItems != null && formItems.size() > 0) {
					WriteFile writeFile = new WriteFile();
					for (FileItem item : formItems) {
						// Creating the directory to store file
						//byte[] bytes = item.get();		
						if(Constant.DESCRIPTION.equalsIgnoreCase(item.getFieldName())){
							byte[] bytes = item.get();
							description = new String(bytes);
						}else{
							kycDocumentFilePath = writeFile.saveKycDocument(xmlOutputPath, item , requestId, Constant.KYC);
							if(fileName.toString().isEmpty())
							{
								fileName.append(kycDocumentFilePath);	
							}else{
								fileName.append(",");
								fileName.append(kycDocumentFilePath);	
							}
						}
						
						//String rootPath = System.getProperty("catalina.home");
						/*ServletContext context = request.getServletContext();
						String appPath = context.getRealPath("");
						File dir = new File(appPath + File.separator + "uploaded");
						if (!dir.exists())
							dir.mkdirs();

						// Create the file on server
						File serverFile = new File(dir.getAbsolutePath() + File.separator + item.getFieldName());
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
						stream.write(bytes);
						stream.close();
						*/
						//System.out.println("Server File Location="	+ serverFile.getAbsolutePath());
						
						//logger.info("Server File Location="	+ serverFile.getAbsolutePath());
						
						
					}
				}
				
				KycApproval kycApprval = new KycApproval();
				
				kycApprval.setRequestId(requestId);
				kycApprval.setComment(description);
				//fileName.replace(fileName.length()-1, fileName.length()-1, "");
				//fileName.replace(fileName.length()-1, fileName.length(), " ");
				kycApprval.setKycDocument(fileName.toString());
				//kycApprval.setStatus(getStatusByDescription(com.eir.report.constant.Status.PENDING.status()).getStatusId());
				kycApprval.setStatus(getStatusByDescription(com.eir.report.constant.Status.Pending_KYC_Approval.status()));
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
	public Integer saveSelectedProduct(EligibleReport selection,Integer sentRequestId, Integer userId) 
	{
		Request reqEntity = new Request();
		reqEntity.setUserDetails(getUserDetails(userId));
		Member member = memberRepository.getUserType(userId);
		
		reqEntity.setUserHit(1);//TODO temporarily harcode values saved
		//reqEntity.setEntityDetails(getEntityObject(input,request));
		if(Constant.NonSPECIFIED.equals(member.getMemberType())){
			reqEntity.setStatus(getStatusByDescription(com.eir.report.constant.Status.Pending_KYC_Approval.status()));
		}
		else{
			reqEntity.setStatus(getStatusByDescription(com.eir.report.constant.Status.IN_PROCCESS.status()));
		}
		reqEntity.setAdminHit(1);//TODO save according to admin hit
		
		reqEntity.setType(member.getMemberType());//TODO change according to FE flag
		reqEntity.setMemberId(1);
		
		if(sentRequestId == 0)
		{
 		requestRepository.save(reqEntity);
 		sentRequestId = reqEntity.getRequestId();
		}
 		
			List<ReportSelection> addintoList = new ArrayList<ReportSelection>();
			List<ReportSelection> deletionList = new ArrayList<ReportSelection>();
							
			if (selection.getComboWithScore() == 1) {
				
				ReportSelection cws = new ReportSelection();
				cws.setProductCode(EIRDataConstant.COMBOWITHSCORE);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.COMBOWITHSCORE);
				cws.setProductId(comboWithScore.getProductId());
				cws.setRequestId(sentRequestId);
				addintoList.add(cws);
			}
			if(selection.getComboWithoutScore() == 1)
			{
				ReportSelection cwos = new ReportSelection();
				cwos.setProductCode(EIRDataConstant.COMBOWITHOUTSCORE);
				ProductMaster comboWithOutScore = productMasterRepository.findByproductCode(EIRDataConstant.COMBOWITHOUTSCORE);
				cwos.setProductId(comboWithOutScore.getProductId());
				cwos.setRequestId(sentRequestId);
				addintoList.add(cwos);
			}
			if(selection.getCommWithScore() == 1)
			{
				ReportSelection cirws = new ReportSelection();
				cirws.setProductCode(EIRDataConstant.CIRWITHSCORE);
				ProductMaster cirWithScore = productMasterRepository.findByproductCode(EIRDataConstant.CIRWITHSCORE);
				cirws.setProductId(cirWithScore.getProductId());
				cirws.setRequestId(sentRequestId);
				addintoList.add(cirws);
			}
			if(selection.getCommWithoutScore() == 1)
			{
				ReportSelection cirwos = new ReportSelection();
				cirwos.setProductCode(EIRDataConstant.CIRWITHOUTSCORE);
				ProductMaster cirWithOutScore = productMasterRepository.findByproductCode(EIRDataConstant.CIRWITHOUTSCORE);
				cirwos.setProductId(cirWithOutScore.getProductId());
				cirwos.setRequestId(sentRequestId);
				addintoList.add(cirwos);
			}
			if(selection.getLitigation() == 1)
			{
				ReportSelection let = new ReportSelection();
				let.setProductCode(EIRDataConstant.LETIGATION);
				ProductMaster letigation = productMasterRepository.findByproductCode(EIRDataConstant.LETIGATION);
				let.setProductId(letigation.getProductId());
				let.setRequestId(sentRequestId);
				addintoList.add(let);
			}
			if(selection.getNewsFeed() == 1)
			{
				ReportSelection newsfeed = new ReportSelection();
				newsfeed.setProductCode(EIRDataConstant.NEWSFEED);
				ProductMaster newsFeed = productMasterRepository.findByproductCode(EIRDataConstant.NEWSFEED);
				newsfeed.setProductId(newsFeed.getProductId());
				newsfeed.setRequestId(sentRequestId);
				addintoList.add(newsfeed);
			}
			if(selection.getSme() == 1)
			{
				ReportSelection sme = new ReportSelection();
				sme.setProductCode(EIRDataConstant.SME);
				ProductMaster smeProduct = productMasterRepository.findByproductCode(EIRDataConstant.SME);
				sme.setProductId(smeProduct.getProductId());
				sme.setRequestId(sentRequestId);
				addintoList.add(sme);
			}
			if(selection.getBir() == 1)
			{
				ReportSelection bir = new ReportSelection();
				bir.setProductCode(EIRDataConstant.BIR);
				ProductMaster birProduct = productMasterRepository.findByproductCode(EIRDataConstant.BIR);
				bir.setProductId(birProduct.getProductId());
				bir.setRequestId(sentRequestId);
				addintoList.add(bir);
			}
			
			
			if (selection.getComboWithScore() == 0) {
				
				ReportSelection cws = new ReportSelection();
				cws.setProductCode(EIRDataConstant.COMBOWITHSCORE);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.COMBOWITHSCORE);
				if(null != comboWithScore){
					cws.setProductId(comboWithScore.getProductId());
					cws.setRequestId(sentRequestId);
					deletionList.add(cws);
				}
			}
			if(selection.getComboWithoutScore() == 0)
			{
				ReportSelection cwos = new ReportSelection();
				cwos.setProductCode(EIRDataConstant.COMBOWITHOUTSCORE);
				ProductMaster comboWithoutScore = productMasterRepository.findByproductCode(EIRDataConstant.COMBOWITHOUTSCORE);
				if(null != comboWithoutScore){
				cwos.setProductId(comboWithoutScore.getProductId());
				cwos.setRequestId(sentRequestId);
				deletionList.add(cwos);
				}
			}
			if(selection.getCommWithScore() == 0)
			{
				ReportSelection cirws = new ReportSelection();
				cirws.setProductCode(EIRDataConstant.CIRWITHSCORE);
				ProductMaster cirWithScore = productMasterRepository.findByproductCode(EIRDataConstant.CIRWITHSCORE);
				if(null != cirWithScore){
				cirws.setProductId(cirWithScore.getProductId());
				cirws.setRequestId(sentRequestId);
				deletionList.add(cirws);
				}
			}
			if(selection.getCommWithoutScore() == 0)
			{
				ReportSelection cirwos = new ReportSelection();
				cirwos.setProductCode(EIRDataConstant.CIRWITHOUTSCORE);
				ProductMaster cirWithoutScore = productMasterRepository.findByproductCode(EIRDataConstant.CIRWITHOUTSCORE);
				if(null != cirWithoutScore){
				cirwos.setProductId(cirWithoutScore.getProductId());
				cirwos.setRequestId(sentRequestId);
				deletionList.add(cirwos);
				}
			}
			/*if(selection.getLitigation() == 0)
			{
				ReportSelection let = new ReportSelection();
				let.setProductCode(EIRDataConstant.LETIGATION);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.LETIGATION);
				let.setProductId(comboWithScore.getProductId());
				let.setRequestId(sentRequestId);
				deletionList.add(let);
			}
			if(selection.getNewsFeed() == 0)
			{
				ReportSelection newsfeed = new ReportSelection();
				newsfeed.setProductCode(EIRDataConstant.NEWSFEED);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.NEWSFEED);
				newsfeed.setProductId(comboWithScore.getProductId());
				newsfeed.setRequestId(sentRequestId);
				deletionList.add(newsfeed);
			}
			if(selection.getSme() == 0)
			{
				ReportSelection sme = new ReportSelection();
				sme.setProductCode(EIRDataConstant.SME);
				ProductMaster comboWithScore = productMasterRepository.findByproductCode(EIRDataConstant.SME);
				sme.setProductId(comboWithScore.getProductId());
				sme.setRequestId(sentRequestId);
				deletionList.add(sme);
			}*/
			if(selection.getBir() == 0)
			{
				ReportSelection bir = new ReportSelection();
				bir.setProductCode(EIRDataConstant.BIR);
				ProductMaster birProduct = productMasterRepository.findByproductCode(EIRDataConstant.BIR);
				if(null != birProduct){
					bir.setProductId(birProduct.getProductId());
					bir.setRequestId(sentRequestId);
					deletionList.add(bir);
				}
			}
			
			reportSelectionRepository.save(addintoList);
			reportSelectionRepository.delete(deletionList);
			return sentRequestId;
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
	@Override
	public DashboardObject getDashboardDetails(Integer userId) {
		
		if(userId != null)
		{
		Status inProcessStatus = getStatusByDescription(com.eir.report.constant.Status.IN_PROCCESS.status());
		
		DashboardObject dashboardObject = new DashboardObject();
		
		dashboardObject.setTotEnquiry(requestRepository.findCountByUserId(userId));
		dashboardObject.setInProcessEnquiry(requestRepository.findCountByUserIdAndStatusId(userId,inProcessStatus.getStatusId()));
		dashboardObject.setTotDispute(disputeRepository.findDisputeCountByUserId(userId));
		dashboardObject.setPendingDispute(disputeRepository.findDisputeCountByUserIdAndStatusId(userId,inProcessStatus.getStatusId()));
		
		return dashboardObject;
		}
		
		return null;
	}
	private String dateFormatter(DateTime date)
	{
		//set Date format in ddMMyyyy form for NExtgen request
		//DateTimeFormatter formatter = DateTimeFormat.forPattern("ddMMyyyy");
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		String dateFormat = formatter.print(date);
		//end dateformat here
		return dateFormat;
	}
	
	@Override
	public List<ViewEarlierEnquiresObject> getEarlierEnquiryRequestData(ViewEarlierEnqRequestObject input,Integer userId) {
		
		  Long requestID = null;
		  String fromDate  =null;
		  String toDate  =null;
		  Integer startIndex = null, endIndex = null;
		  if(null != input){
		       if(null != input.getRequestId() && input.getRequestId() !="")
		       {
		              requestID = Long.parseLong(input.getRequestId());
		       }
		       if(null != input.getFromDate() && input.getFromDate().getFormatted() != null && !input.getFromDate().getFormatted().isEmpty()){
		    	   fromDate = input.getFromDate().getFormatted();
		       }
		       if(null != input.getToDate() && input.getToDate().getFormatted() != null && !input.getToDate().getFormatted().isEmpty()){
		    	   toDate = input.getToDate().getFormatted();
		       }
		       if(null != input.getStartIndex())
		       {
		    	   startIndex = input.getStartIndex();
		       }
		       if(null != input.getEndIndex())
		       {
		    	   endIndex =input.getEndIndex();
		       }			   
		  }
		List<Object[]> cirRequests = new ArrayList<>();
		List<Object[]> birRequests = new ArrayList<>();
		List<Object[]> consumerRequests= new ArrayList<>();
	if(null != input.getStartIndex() && null != input.getEndIndex())
	{		
		if(null != requestID && (null != fromDate ) && (null != toDate)){
			
			cirRequests = cirReqRepository.getCirRequestByDateAndRequestId(fromDate, toDate, requestID,userId,startIndex,endIndex);
			 
			birRequests = birRequestRepository.getBirRequestByDateAndRequestId(fromDate, toDate, requestID,userId,startIndex,endIndex);
			
		    consumerRequests = consumerListRepository.getConsumerRequestByDateAndRequestId(fromDate, toDate, requestID,userId,startIndex,endIndex);
			
		}else if(null == requestID && null != fromDate && null != toDate){
			
			cirRequests = cirReqRepository.getCirRequestByDate(fromDate, toDate,userId,startIndex,endIndex);
			 
			birRequests = birRequestRepository.getBirRequestByDate(fromDate, toDate,userId,startIndex,endIndex);
			
		    consumerRequests = consumerListRepository.getConsumerRequestByDate(fromDate, toDate,userId,startIndex,endIndex);
			
		}else if(null != requestID && (null == fromDate) && (null == toDate )){
			cirRequests = cirReqRepository.getCirRequestByRequestId(requestID,userId,startIndex,endIndex);
		 
			birRequests = birRequestRepository.getBirRequestByRequestId(requestID,userId,startIndex,endIndex);
			
		    consumerRequests = consumerListRepository.getConsumerRequestByRequestId(requestID,userId,startIndex,endIndex);
		}
	}
		
		return getViewEarlierEnquiriesObject(cirRequests, birRequests, consumerRequests);
		
	}
	
	@Override
	public List<ViewEarlierEnquiresObject> getCrmAdminRequestData(ViewEarlierEnqRequestObject input) {
		
		  Long requestID = null;
		  String fromDate  =null;
		  String toDate  =null;
		  if(null != input){
		       if(null != input.getRequestId() && input.getRequestId() !="")
		       {
		              requestID = Long.parseLong(input.getRequestId());
		       }
		       if(null != input.getFromDate() && input.getFromDate().getFormatted() != null && !input.getFromDate().getFormatted().isEmpty()){
		    	   fromDate = input.getFromDate().getFormatted();
		       }
		       if(null != input.getToDate() && input.getToDate().getFormatted() != null && !input.getToDate().getFormatted().isEmpty()){
		    	   toDate = input.getToDate().getFormatted();
		       }
		  }
		List<Object[]> cirRequests = new ArrayList<>();
		List<Object[]> birRequests = new ArrayList<>();
		List<Object[]> consumerRequests= new ArrayList<>();
		
		if(null != requestID && (null != fromDate ) && (null != toDate)){
			
			cirRequests = cirReqRepository.getCirRequestByDateAndRequestIdForCrmAdmin(fromDate, toDate, requestID);
			 
			birRequests = birRequestRepository.getBirRequestByDateAndRequestIdForCrmAdmin(fromDate, toDate, requestID);
			
		    consumerRequests = consumerListRepository.getConsumerRequestByDateAndRequestIdForCrmAdmin(fromDate, toDate, requestID);
			
		}else if(null == requestID && null != fromDate && null != toDate){
			
			cirRequests = cirReqRepository.getCirRequestByDateForCrmAdmin(fromDate, toDate);
			 
			birRequests = birRequestRepository.getBirRequestByDateForCrmAdmin(fromDate, toDate);
			
		    consumerRequests = consumerListRepository.getConsumerRequestByDateForCrmAdmin(fromDate, toDate);
			
		}else if(null != requestID && (null == fromDate) && (null == toDate )){
			cirRequests = cirReqRepository.getCirRequestByRequestIdForCrmAdmin(requestID);
		 
			birRequests = birRequestRepository.getBirRequestByRequestIdForCrmAdmin(requestID);
			
		    consumerRequests = consumerListRepository.getConsumerRequestByRequestIdForCrmAdmin(requestID);
		}
		
		return getViewEarlierEnquiriesObject(cirRequests, birRequests, consumerRequests);
		
	}

	/**
	 * @param cirRequests
	 * @param birRequests
	 * @param consumerRequests
	 */
	private List<ViewEarlierEnquiresObject> getViewEarlierEnquiriesObject(List<Object[]> cirRequests, List<Object[]> birRequests,
			List<Object[]> consumerRequests) {
		
		ViewEarlierEnquiresObject viewEnquiresObject;
		String withScore;
		Integer reqId =0;
		String statusDesc  = null;
		Map<Integer,ViewEarlierEnquiresObject> reportStatus = new HashMap<Integer, ViewEarlierEnquiresObject>();
		List<ViewEarlierEnquiresObject> enquiresObjects = new ArrayList<ViewEarlierEnquiresObject>();

		//consumer
		if(!consumerRequests.isEmpty() && null != consumerRequests){
						
            for(Object[] consumerRequest : consumerRequests){
            	
				reqId = (Integer)consumerRequest[0];
				
				if(!(reportStatus.containsKey(reqId))){
					
					viewEnquiresObject = new ViewEarlierEnquiresObject();
					reportStatus.put((reqId), viewEnquiresObject);
					
				}				
			}			
		}
		
		//CIR
		if(!cirRequests.isEmpty() && null != cirRequests){	
		
			for(Object[] cirRequest : cirRequests){
				
				withScore =  (String) cirRequest[2];
				reqId = (Integer)cirRequest[0];
				statusDesc = (String) cirRequest[1];
				
				if(reportStatus.containsKey(reqId)){
					viewEnquiresObject = reportStatus.get(reqId);
					
					if(null != withScore && Constant.CONS_Y.equalsIgnoreCase(withScore)){
						viewEnquiresObject.setComboWithScoreStatus(statusDesc);
							
					}else{
						viewEnquiresObject.setComboWithoutScoreStatus(statusDesc);
					}
				}else{
					viewEnquiresObject = new ViewEarlierEnquiresObject();
					
					if(null != withScore && Constant.CONS_Y.equalsIgnoreCase(withScore)){
						
						viewEnquiresObject.setCommWithScoreStatus(statusDesc);
						
					}else{
						
						viewEnquiresObject.setCommWithoutScoreStatus(statusDesc);
					}
					reportStatus.put((reqId), viewEnquiresObject);
				}
			}
			
		}
		
		//BIR
		if(!birRequests.isEmpty() && null != birRequests){
			
			for(Object[] birRequest : birRequests){
				
				reqId = (Integer)birRequest[0];
				statusDesc = (String) birRequest[1];
				
				if(reportStatus.containsKey(reqId)){
					
					viewEnquiresObject = reportStatus.get(reqId);
					viewEnquiresObject.setBirReportStatus(statusDesc);
				
				}else{
					
					viewEnquiresObject = new ViewEarlierEnquiresObject();
					viewEnquiresObject.setBirReportStatus(statusDesc);
					reportStatus.put((reqId), viewEnquiresObject);
				}
			}
		}
		
		for(Integer mapReqId : reportStatus.keySet()){
			viewEnquiresObject = setStatus(reportStatus.get(mapReqId));
			viewEnquiresObject.setRequestId(mapReqId);
			enquiresObjects.add(viewEnquiresObject);
		}
		
		return enquiresObjects;
	}

	private ViewEarlierEnquiresObject setStatus(ViewEarlierEnquiresObject viewEnquiresObject) {
		
		if(null == viewEnquiresObject.getBirReportStatus()){
			viewEnquiresObject.setBirReportStatus(Constant.CONS_NOT_SELECTED);
		}
		
		if(null == viewEnquiresObject.getComboWithoutScoreStatus()){
			viewEnquiresObject.setComboWithoutScoreStatus(Constant.CONS_NOT_SELECTED);
		}
		
		if(null == viewEnquiresObject.getComboWithScoreStatus()){
			viewEnquiresObject.setComboWithScoreStatus(Constant.CONS_NOT_SELECTED);
		}
		
		if(null == viewEnquiresObject.getCommWithoutScoreStatus()){
			viewEnquiresObject.setCommWithoutScoreStatus(Constant.CONS_NOT_SELECTED);
		}
		
		if(null == viewEnquiresObject.getCommWithScoreStatus()){
			viewEnquiresObject.setCommWithScoreStatus(Constant.CONS_NOT_SELECTED);
		}
		
		viewEnquiresObject.setLitigationStatus(Constant.CONS_NOT_SELECTED);
		viewEnquiresObject.setNewsFeedStatus(Constant.CONS_NOT_SELECTED);
		viewEnquiresObject.setSmeStatus(Constant.CONS_NOT_SELECTED);
		
		return viewEnquiresObject;
	}

	@Override
	public ViewEnquiryObject getRequestByRequestId(Integer reqId) {
		ViewEnquiryObject viewEnquiryObject = new ViewEnquiryObject();
		BIRObject birObject = new BIRObject();
		CIRWithScoreObject cirWithScoreObject = new CIRWithScoreObject();
		CIRWithOutScoreObject cirWithOutScoreObject = new CIRWithOutScoreObject();
		ComboWithScoreObject comboWithScoreObject = new ComboWithScoreObject();
		ComboWithoutScoreObject comboWithoutScoreObject = new ComboWithoutScoreObject();
		Request request = requestRepository.findByRequestId(reqId);
		String score  =null;
		if(null != request){
			BirRequest birRequest = request.getBirRequests();
			//set bir report details			
			if(null != birRequest && null != birRequest.getBirRequestId()){
				//get product id from product selection 
				Object[] birProduct = productMasterRepository.getBIRProductByRequestId(reqId, Constant.BIR_PRODUCT_CODE);
				//get tats from product master table
				//ProductMaster master = productMasterRepository.findByproductId(reportSelection.getProductId());
				
				birObject.setBirReportStatus(birRequest.getStatus().getStatusDescription());
				if(null != birRequest.getCreateUserDate()){
					birObject.setBirRequestDate(formatDate(birRequest.getCreateUserDate().toString()));
				}
				if(null != birRequest.getUpdateUserDate() 
						&& birRequest.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.COMPLETED.status())){
					birObject.setBirResponseDate(formatDate(birRequest.getUpdateUserDate().toString()));
					birObject.setBirMessage(Constant.REPORT_COMPLETED_READY);
				}
				else if(birRequest.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.Pending_KYC_Approval.status()))
				{
					birObject.setBirMessage(Constant.KYC_APPROVAL_PENDING);
					
				}
				else
				{
					birObject.setBirMessage(Constant.REPORT_INCOMPLETE);
				}
				birObject.setBirRequestId(birRequest.getBirRequestId());
				
				if(birProduct.length > 0)
				birObject.setBirTats(birProduct[0].toString());
			}
			
			//set combo details
			//consumerRequests  = request.getConsumerRequets();
			CirRequest cirRequet = request.getCirRequets();
			if(null != request.getConsumerRequets() && !request.getConsumerRequets().isEmpty()){
				score = cirRequet.getWithScore();

				if(null != score && Constant.CONS_Y.equalsIgnoreCase(score)) {
					comboWithScoreObject.setComboWithScoreReportStatus(cirRequet.getStatus().getStatusDescription());
					if(null != cirRequet.getCreateUserDate()){
						comboWithScoreObject.setComboWithScoreRequestDate(formatDate(cirRequet.getCreateUserDate().toString()));
					}
					if(cirRequet.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.COMPLETED.status()) 
							&& cirRequet.getUpdateUserDate() != null){
						comboWithScoreObject.setComboWithScoreResponseDate(formatDate(cirRequet.getUpdateUserDate().toString()));
						comboWithScoreObject.setComboWithScoreMessage(Constant.REPORT_COMPLETED_READY);
					}
					else if(cirRequet.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.Pending_KYC_Approval.status()))
					{
						comboWithScoreObject.setComboWithScoreMessage(Constant.KYC_APPROVAL_PENDING);
						
					}
					else
					{
						comboWithScoreObject.setComboWithScoreMessage(Constant.REPORT_INCOMPLETE);
					}
					comboWithScoreObject.setConsumerRequestId(cirRequet.getCirRequestId());
					
				}else{
					
					comboWithoutScoreObject.setComboWithoutScoreReportStatus(cirRequet.getStatus().getStatusDescription());
					if(null != cirRequet.getCreateUserDate()){
						comboWithoutScoreObject.setComboWithOutScoreRequestDate(formatDate(cirRequet.getCreateUserDate().toString()));
					}
					if(cirRequet.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.COMPLETED.status())
							&& cirRequet.getUpdateUserDate() != null){
						comboWithoutScoreObject.setComboWithOutScoreResponseDate(formatDate(cirRequet.getUpdateUserDate().toString()));
						comboWithoutScoreObject.setComboWithOutScoreMessage(Constant.REPORT_COMPLETED_READY);
					}
					else if(cirRequet.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.Pending_KYC_Approval.status()))
					{
						comboWithoutScoreObject.setComboWithOutScoreMessage(Constant.KYC_APPROVAL_PENDING);
						
					}
					else
					{
						comboWithoutScoreObject.setComboWithOutScoreMessage(Constant.REPORT_INCOMPLETE);
					}
					comboWithoutScoreObject.setConsumerRequestId(cirRequet.getCirRequestId());
				}
			}else if(null != cirRequet && null != cirRequet.getCirRequestId()){	
				score = cirRequet.getWithScore();
				// set cir details			
				 if(null != score && Constant.CONS_Y.equalsIgnoreCase(score)){
					cirWithScoreObject.setCirWithScoreReportStatus(cirRequet.getStatus().getStatusDescription());
					if(null != cirRequet.getCreateUserDate()){
						cirWithScoreObject.setCirWithScoreRequestDate(formatDate(cirRequet.getCreateUserDate().toString()));
					}
					if(null != cirRequet.getUpdateUserDate() 
							&& cirRequet.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.COMPLETED.status())){
						cirWithScoreObject.setCirWithScoreResponseDate(formatDate(cirRequet.getUpdateUserDate().toString()));
						cirWithScoreObject.setCirWithScoreMessage(Constant.REPORT_COMPLETED_READY);
					}
					else if(cirRequet.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.Pending_KYC_Approval.status()))
					{
						cirWithScoreObject.setCirWithScoreMessage(Constant.KYC_APPROVAL_PENDING);
					}
					else
					{
						cirWithScoreObject.setCirWithScoreMessage(Constant.REPORT_INCOMPLETE);
					}
					cirWithScoreObject.setCirRequestId(cirRequet.getCirRequestId());
					
				}else{
					cirWithOutScoreObject.setCirWithOutScoreReportStatus(cirRequet.getStatus().getStatusDescription());
					if(null != cirRequet.getCreateUserDate()){
						cirWithOutScoreObject.setCirWithOutScoreRequestDate(formatDate(cirRequet.getCreateUserDate().toString()));
					}
					if(null != cirRequet.getUpdateUserDate() 
							&& cirRequet.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.COMPLETED.status())){
						cirWithOutScoreObject.setCirWithOutScoreResponseDate(formatDate(cirRequet.getUpdateUserDate().toString()));
						cirWithOutScoreObject.setCirWithOutScoreMessage(Constant.REPORT_COMPLETED_READY);	
					}
					else if(cirRequet.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.Pending_KYC_Approval.status()))
					{
						cirWithOutScoreObject.setCirWithOutScoreMessage(Constant.KYC_APPROVAL_PENDING);
						cirWithOutScoreObject.setCirWithOutScoreMessage(Constant.KYC_APPROVAL_PENDING);
					}
					else
					{
						cirWithOutScoreObject.setCirWithOutScoreMessage(Constant.REPORT_INCOMPLETE);
					}
					cirWithOutScoreObject.setCirRequestId(cirRequet.getCirRequestId());
					
				}
			}
		}
		
		viewEnquiryObject.setBirObject(birObject);
		viewEnquiryObject.setCirWithScoreObject(cirWithScoreObject);
		viewEnquiryObject.setCirWithOutScoreObject(cirWithOutScoreObject);
		viewEnquiryObject.setComboWithScoreObject(comboWithScoreObject);
		viewEnquiryObject.setComboWithOutScoreObject(comboWithoutScoreObject);
		
		ViewEnquiryObject viewEnquiryObjectToReturn = setViewEnqStatus(viewEnquiryObject);
		
		return viewEnquiryObjectToReturn;
	}

	private String formatDate(String strdate) {
		// TODO Auto-generated method stub
		String customFormat = "dd-MM-yyyy HH:mm";

        org.joda.time.format.DateTimeFormatter dtf = ISODateTimeFormat.dateTime();
        org.joda.time.LocalDateTime parsedDate = dtf.parseLocalDateTime(strdate);

        String dateWithCustomFormat = parsedDate.toString(DateTimeFormat.forPattern(customFormat));
		
		
		return dateWithCustomFormat;
	}

	private ViewEnquiryObject setViewEnqStatus(ViewEnquiryObject viewEnquiryObject) {
		
		if(null == viewEnquiryObject.getBirObject().getBirReportStatus()){
			//viewEnquiryObject.setBirReportStatus(Constant.CONS_NOT_SELECTED);
			viewEnquiryObject.getBirObject().setBirReportStatus(Constant.CONS_NOT_SELECTED);
			viewEnquiryObject.getBirObject().setBirRequestDate("-");
			viewEnquiryObject.getBirObject().setBirResponseDate("-");
			viewEnquiryObject.getBirObject().setBirTats("-");
			viewEnquiryObject.getBirObject().setBirMessage("-");
		}
		
		if(null == viewEnquiryObject.getCirWithOutScoreObject().getCirWithOutScoreReportStatus()){
			viewEnquiryObject.getCirWithOutScoreObject().setCirWithOutScoreReportStatus(Constant.CONS_NOT_SELECTED);
			viewEnquiryObject.getCirWithOutScoreObject().setCirWithOutScoreRequestDate("-");
			viewEnquiryObject.getCirWithOutScoreObject().setCirWithOutScoreResponseDate("-");
			viewEnquiryObject.getCirWithOutScoreObject().setCirWithOutScoreMessage("-");
		}
		
		if(null == viewEnquiryObject.getCirWithScoreObject().getCirWithScoreReportStatus()){
			viewEnquiryObject.getCirWithScoreObject().setCirWithScoreReportStatus(Constant.CONS_NOT_SELECTED);
			viewEnquiryObject.getCirWithScoreObject().setCirWithScoreRequestDate("-");
			viewEnquiryObject.getCirWithScoreObject().setCirWithScoreResponseDate("-");
			viewEnquiryObject.getCirWithScoreObject().setCirWithScoreMessage("-");
			
		}
		
		if(null == viewEnquiryObject.getComboWithOutScoreObject().getComboWithoutScoreReportStatus()){
			viewEnquiryObject.getComboWithOutScoreObject().setComboWithoutScoreReportStatus(Constant.CONS_NOT_SELECTED);
			viewEnquiryObject.getComboWithOutScoreObject().setComboWithOutScoreRequestDate("-");
			viewEnquiryObject.getComboWithOutScoreObject().setComboWithOutScoreResponseDate("-");
			viewEnquiryObject.getComboWithOutScoreObject().setComboWithOutScoreMessage("-");
		}
		
		if(null == viewEnquiryObject.getComboWithScoreObject().getComboWithScoreReportStatus()){
			viewEnquiryObject.getComboWithScoreObject().setComboWithScoreReportStatus(Constant.CONS_NOT_SELECTED);
			viewEnquiryObject.getComboWithScoreObject().setComboWithScoreRequestDate("-");
			viewEnquiryObject.getComboWithScoreObject().setComboWithScoreResponseDate("-");
			viewEnquiryObject.getComboWithScoreObject().setComboWithScoreMessage("-");
		}
		
		return viewEnquiryObject;
	}
	
	public void getDownloadFile( ByteArrayOutputStream byteArrayOutputStream,String fileExtention, HttpServletRequest request, HttpServletResponse response)
	{
		OutputStream outStream = null;
		try
		{
				// set headers for the response
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=Report."+fileExtention);
				response.setContentType("application/pdf");
				response.setHeader(headerKey, headerValue);
		
				// get output stream of the response
				outStream = response.getOutputStream();
				byteArrayOutputStream.writeTo(outStream);
				outStream.flush();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				outStream.close();
			}
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public void resubmitRequestForBIR(Integer birRequestId) {
		BirRequest birRequest = birRequestRepository.findByBirRequestId(birRequestId);
		
		//CirRequest cirRequestEntity = nextGenWebService.cre(birRequest);
	}

	@Override
	public Object reSubmitRequestForCombo(Integer requestId) {
		
		Request request = requestRepository.findByRequestId(requestId);
		CirRequest cirRequestEntity = request.getCirRequets();
		String score = null;
		if(null != request && Constant.STATUS_DESCRIPTION_ERROR.equalsIgnoreCase(request.getCirRequets().getStatus().getStatusDescription())){
			
			cirRequestEntity = nextGenWebService.createCIRReport(request.getCirRequets());
		}
		
		//if 4 cousumers are there and out of 4 1 got failed then what status we need to dispaly
		nextGenWebService.createConsumerReport(request.getConsumerRequets());
		
		if(null !=  request.getCirRequets() && null != request.getConsumerRequets() && !request.getConsumerRequets().isEmpty()){
			score = request.getCirRequets().getWithScore();

			if(null != score && score.equalsIgnoreCase(Constant.CONS_Y)){
				ComboWithScoreObject comboWithScoreObject = new ComboWithScoreObject();
				comboWithScoreObject.setComboWithScoreReportStatus(cirRequestEntity.getStatus().getStatusDescription());
				if(null != cirRequestEntity.getCreateUserDate()){
					comboWithScoreObject.setComboWithScoreRequestDate(formatDate(cirRequestEntity.getCreateUserDate().toString()));
				}
				if(null != cirRequestEntity.getUpdateUserDate() 
						&& cirRequestEntity.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.COMPLETED.status()) ){
					comboWithScoreObject.setComboWithScoreResponseDate(formatDate(cirRequestEntity.getUpdateUserDate().toString()));
					comboWithScoreObject.setComboWithScoreMessage(Constant.REPORT_COMPLETED_READY);
				}
				else
				{
					comboWithScoreObject.setComboWithScoreMessage(Constant.REPORT_INCOMPLETE);
				}
				comboWithScoreObject.setConsumerRequestId(cirRequestEntity.getCirRequestId());
				
				return comboWithScoreObject;
			}else{
				ComboWithoutScoreObject comboWithoutScoreObject = new ComboWithoutScoreObject();
				
				comboWithoutScoreObject.setComboWithoutScoreReportStatus(cirRequestEntity.getStatus().getStatusDescription());
				if(null != cirRequestEntity.getCreateUserDate()){
					comboWithoutScoreObject.setComboWithOutScoreRequestDate(formatDate(cirRequestEntity.getCreateUserDate().toString()));
				}
				if(null != cirRequestEntity.getUpdateUserDate() 
						&& cirRequestEntity.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.COMPLETED.status())){
					comboWithoutScoreObject.setComboWithOutScoreResponseDate(formatDate(cirRequestEntity.getUpdateUserDate().toString()));
					comboWithoutScoreObject.setComboWithOutScoreMessage(Constant.REPORT_COMPLETED_READY);	
				}
				else if(cirRequestEntity.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.Pending_KYC_Approval.status()))
				{
					comboWithoutScoreObject.setComboWithOutScoreMessage(Constant.KYC_APPROVAL_PENDING);
					
				}
				else
				{
					comboWithoutScoreObject.setComboWithOutScoreMessage(Constant.REPORT_INCOMPLETE);
				}
				comboWithoutScoreObject.setConsumerRequestId(cirRequestEntity.getCirRequestId());
				
				return comboWithoutScoreObject;
			}
		
		}
		return null;
	}

	@Override
	public Object reSubmitRequestForCIR(Integer cirRequestId) {
		String withScore = null;
		CirRequest cirInputRequest = cirReqRepository.findByCirRequestId(cirRequestId);
		
		CirRequest cirRequestEntity = nextGenWebService.createCIRReport(cirInputRequest );
		if(null != cirRequestEntity){
			withScore = cirInputRequest.getWithScore();
			  if(null != withScore && withScore.equalsIgnoreCase(Constant.CONS_Y) ){
				CIRWithScoreObject cirWithScoreObject = new CIRWithScoreObject();
				cirWithScoreObject.setCirWithScoreReportStatus(cirRequestEntity.getStatus().getStatusDescription());
				if(null != cirRequestEntity.getCreateUserDate()){
					cirWithScoreObject.setCirWithScoreRequestDate(formatDate(cirRequestEntity.getRequest().getCreateUserDate().toString()));
				}
				if(null != cirRequestEntity.getUpdateUserDate()
						&& cirRequestEntity.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.COMPLETED.status())){
					cirWithScoreObject.setCirWithScoreResponseDate(formatDate(cirRequestEntity.getRequest().getUpdateUserDate().toString()));
					cirWithScoreObject.setCirWithScoreMessage(Constant.REPORT_COMPLETED_READY);	
				}
				else if(cirRequestEntity.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.Pending_KYC_Approval.status()))
				{
					cirWithScoreObject.setCirWithScoreMessage(Constant.KYC_APPROVAL_PENDING);
					
				}
				else
				{
					cirWithScoreObject.setCirWithScoreMessage(Constant.REPORT_INCOMPLETE);
				}
				
				return cirWithScoreObject;
			}else{
				CIRWithOutScoreObject cirWithOutScoreObject = new CIRWithOutScoreObject();
				cirWithOutScoreObject.setCirWithOutScoreReportStatus(cirRequestEntity.getStatus().getStatusDescription());
				if(null != cirRequestEntity.getCreateUserDate()){
					cirWithOutScoreObject.setCirWithOutScoreRequestDate(formatDate(cirRequestEntity.getRequest().getCreateUserDate().toString()));
				}
				if(null != cirRequestEntity.getUpdateUserDate()
						&& cirRequestEntity.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.COMPLETED.status())){
					cirWithOutScoreObject.setCirWithOutScoreResponseDate(formatDate(cirRequestEntity.getRequest().getUpdateUserDate().toString()));
					cirWithOutScoreObject.setCirWithOutScoreMessage(Constant.REPORT_COMPLETED_READY);
				}
				else if(cirRequestEntity.getStatus().getStatusDescription().equals(com.eir.report.constant.Status.Pending_KYC_Approval.status()))
				{
					cirWithOutScoreObject.setCirWithOutScoreMessage(Constant.KYC_APPROVAL_PENDING);
					
				}else
				{
					cirWithOutScoreObject.setCirWithOutScoreMessage(Constant.REPORT_INCOMPLETE);
				}
				
				return cirWithOutScoreObject;
			}
		}
		return null;
	}

	@Override
	public Integer getUsersMemberId(Integer userId) 
	{
		memberUserMappingRepository.getUsersMemberId(userId);
		return null;
	}
	
		@Override
	public MemberObject getUserType(Integer userId) {
		
		Member member = memberRepository.getUserType(userId);
		MemberObject memberObject = new MemberObject();
		if(null != member){
			memberObject.setMemberType(member.getMemberType());
		}
		return memberObject;
	}
	
	@Override
	public EligibleReport getEligibleProduct(Integer userID) {
		EligibleReport selection = new EligibleReport();
		List<MemberProductMapping> productList = memberProductMappingRepository.findProductMappingForUserId(userID);
		
		for(MemberProductMapping s : productList){
			
			selectProduct(selection, s.getProductCode());
		}
		return selection;
	}

	private void selectProduct(EligibleReport selection, String productCode) {
		switch (productCode) {
		case EIRDataConstant.COMBOWITHSCORE:
			selection.setComboWithScore(1);
			break;
		case EIRDataConstant.COMBOWITHOUTSCORE:
			selection.setComboWithoutScore(1);
			break;
		case EIRDataConstant.CIRWITHSCORE:
			selection.setCommWithScore(1);
			break;
		case EIRDataConstant.CIRWITHOUTSCORE:
			selection.setCommWithoutScore(1);
			break;
		case EIRDataConstant.BIR:
			selection.setBir(1);
			break;
		case EIRDataConstant.SME:
			selection.setSme(1);
			break;
		case EIRDataConstant.LETIGATION:
			selection.setLitigation(1);
			break;
		case EIRDataConstant.NEWSFEED:
			selection.setNewsFeed(1);
			break;
		}
	}
	@Override
	public EligibleReport getSelectedProduct(Integer reqID)
	{
		EligibleReport selection = new EligibleReport();
		List<ReportSelection> reportSelectionList = reportSelectionRepository.findByRequestId(reqID);
		
		for(ReportSelection reportSelection : reportSelectionList)
		{
			
			selectProduct(selection, reportSelection.getProductCode());
			
		}
		
		
		return selection;
	}
	
	@Override
	public String getEirXMLReport(Integer requestId, String reportType, HttpServletRequest request,HttpServletResponse response) 
	{
		List<String> xmlReportFileList = getXMLReportFilePath(requestId, reportType);
		
		for (String xmlReportFile : xmlReportFileList) 
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			try 
			{
				File xmlReportPath = new File(xmlReportFile);
				
				String readXMLReportFile = FileUtils.readFileToString(xmlReportPath);
				
				baos.write(readXMLReportFile.getBytes());
				
			    System.out.println("size: " + baos.size());
			    
			    getDownloadFile(baos,Constant.FILE_EXTENTION_XML,request,response);
			} 
			catch (FileNotFoundException e) 
			{
				logger.debug(e.getMessage());
				return Constant.FILE_NOT_FOUND;
			} 
			catch (Exception e) 
			{
				logger.debug(e.getMessage());
				e.printStackTrace();
			} 
			finally 
			{
				if (baos != null) 
				{
					try 
					{
						baos.close();
					} catch (IOException e) 
					{
						logger.debug(e.getMessage());
					}
				}
			 }
		}
		return "";
	}
	private List<String> getXMLReportFilePath(Integer requestID, String reportType) 
	{
		List<String> getXMLReportFilePath = new ArrayList<>();
		if (reportType.equals(EIRDataConstant.BIR))
		{
			getXMLReportFilePath.add(xmlOutputPath + birRequestRepository.findByRequest(requestID));
			System.out.println(getXMLReportFilePath);
		}
		if (reportType.equals(EIRDataConstant.CIRWITHOUTSCORE))
		{
			getXMLReportFilePath.add(xmlOutputPath + cirReqRepository.findByRequest(requestID));
		}
		if (reportType.equals(EIRDataConstant.COMBOWITHOUTSCORE))
		{
			getXMLReportFilePath.add(xmlOutputPath + cirReqRepository.findByRequest(requestID));
			
			getXMLReportFilePath.add(xmlOutputPath + consumerListRepository.findByRequest(requestID));
		}
		
		return getXMLReportFilePath;
	}

	@Override
	public List<Integer> getRequestedIds(ViewEarlierEnqRequestObject input) 
	{
		Integer requestID = null;
		  String fromDate  =null;
		  String toDate  =null;
		  List<Integer> requestedIdList = null;
		  if(null != input)
		  {
			  requestedIdList = new ArrayList<>();
		       if(null != input.getRequestId() && !input.getRequestId().isEmpty())
		       {
		              requestID = Integer.parseInt(input.getRequestId());
		              
		              requestedIdList.add(requestID);
		       }
		       else 
		       {		       
			       if(null != input.getFromDate() && input.getFromDate().getFormatted() != null && !input.getFromDate().getFormatted().isEmpty()){
			    	   fromDate = input.getFromDate().getFormatted();
			       }
			       if(null != input.getToDate() && input.getToDate().getFormatted() != null && !input.getToDate().getFormatted().isEmpty()){
			    	   toDate = input.getToDate().getFormatted();
			       }
			       requestedIdList = requestRepository.findRequestByDateAndRequestId(fromDate, toDate);
		       }
		  }
		
		return requestedIdList;
	}
}
