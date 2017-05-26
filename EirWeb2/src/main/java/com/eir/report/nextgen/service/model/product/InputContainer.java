package com.eir.report.nextgen.service.model.product;

import java.io.Serializable;


public class InputContainer implements Serializable{
	
	private int errorCode;
	private boolean flag;
	private Uiq uiq;
	private UiqProductList uiqlist;
	private long bureauMemberId;


	public Uiq getUiq() {
		return uiq;
	}

	public void setUiq(Uiq uiq) {
		this.uiq = uiq;
	}

	public InputContainer(){
		errorCode=-1;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
		
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public long getBureauMemberId() {
		return bureauMemberId;
	}

	public void setBureauMemberId(long bureauMemberId) {
		this.bureauMemberId = bureauMemberId;
	}

	/**
	 * @return the uiqlist
	 */
	public UiqProductList getUiqlist() {
		return uiqlist;
	}

	/**
	 * @param uiqlist the uiqlist to set
	 */
	public void setUiqlist(UiqProductList uiqlist) {
		this.uiqlist = uiqlist;
	}

	
	

	
}
