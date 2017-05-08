package com.eir.report.servlet;

import com.eir.report.web.service.EwacsHelper;

public class SSOConfig {
	private String devMode;
	private String whiteCharList;
	private String redirectPage;
	private String redirectLegacyPage;
	private int legacyVersion;
	private String ssoLogoutUrl;
    private EwacsHelper ewacsHelper;

	public String getSsoLogoutUrl() {
		return ssoLogoutUrl;
	}
	public void setSsoLogoutUrl(String ssoLogoutUrl) {
		this.ssoLogoutUrl = ssoLogoutUrl;
	}
	public String getDevMode() {
		return devMode;
	}
	public void setDevMode(String devMode) {
		this.devMode = devMode;
	}
	public boolean isDev() {
		return Boolean.parseBoolean(devMode);
	}
	public String getWhiteCharList() {
		return whiteCharList;
	}
	public void setWhiteCharList(String whiteCharList) {
		this.whiteCharList = whiteCharList;
	}
	public String getRedirectPage() {
		return redirectPage;
	}
	public void setRedirectPage(String redirectPage) {
		this.redirectPage = redirectPage;
	}
	public String getRedirectLegacyPage() {
		return redirectLegacyPage;
	}
	public void setRedirectLegacyPage(String redirectLegacyPage) {
		this.redirectLegacyPage = redirectLegacyPage;
	}
	public int getLegacyVersion() {
		return legacyVersion;
	}
	public void setLegacyVersion(int legacyVersion) {
		this.legacyVersion = legacyVersion;
	}
    public EwacsHelper getEwacsHelper() {
        return ewacsHelper;
    }

    public void setEwacsHelper(EwacsHelper ewacsHelper) {
        this.ewacsHelper = ewacsHelper;
    }
}
