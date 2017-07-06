package com.eir.report.constant;

public class Constant {
	
	/*public static final String PENDING = "PENDING";
	public static final String DOWNLOADED = "DOWNLOADED";
	public static final String IN_PROCCESS = "IN_PROCCESS";
	public static final String COMPLETED = "COMPLETED";
	public static final String ERROR = "ERROR";
	public static final String KYC_APPROVED = "KYC_APPROVED";
	public static final String KYC_REJECTED = "KYC_REJECTED";	
	public static final String RECIEVEANDPLACED = "RECIEVEANDPLACED";
	public static final String SCOREDANDSERVED = "SCOREDANDSERVED";
	public static final String OPEN = "OPEN";
	public static final String CLOSED = "CLOSED";*/
	
	// upload settings
	public static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	public static final int MAX_FILE_SIZE = 1024 * 1024 * 2000; // 2GB
	public static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2500; // 2.5GB
	
	public static final int BUFFER_SIZE = 4096;
	
	public static final String USER_ID = "USER_ID";
	public static final String SPECIFIED = "SPECIFIED";
	public static final String ACCESS_TOKEN = "AccessToken"; 
	
	public static final Integer HARDCOADED_USERID = 1;
	public static final Integer BUREAU_MEMBER_ID = 3388;
	public static final String CONSPRODUCTFIELD = "INCCIR002";
	
	public static final String BURERROR = "BURERROR";
	public static final String CONS_Y= "Y";
	public static final String CONS_N= "N";
	public static final String CONS_NOT_SELECTED= "not-select";
	public static final String BIR_PRODUCT_CODE= "BIR";
	
	public static final Integer RETRY_COUNT = 3;
}
