package com.neodem.common.beans;

public class EmailAddress extends AbstractBean  {
	
	private String address;
	private String domain;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
}
