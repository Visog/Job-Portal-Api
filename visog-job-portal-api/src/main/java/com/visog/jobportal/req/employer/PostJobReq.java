package com.visog.jobportal.req.employer;

import java.util.Date;

public class PostJobReq {

	private String user;

	private String jobTitle;

	private String jobDescription;

	private Double annualPackageFrom;

	private Double annualPackageTo;

	private String currency;

	private String company;

	private Date effectedDateFrom;

	private Date effectedDateTo;

	private String status;

	private Integer minExperience;

	private String phoneNo;

	private Boolean walkIn;
	
	
	private String addressLine1;

	private String addressLine2;

	private String country;

	private String state;

	private String city;

	private String zipcode;

	
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}



	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public Double getAnnualPackageFrom() {
		return annualPackageFrom;
	}

	public void setAnnualPackageFrom(Double annualPackageFrom) {
		this.annualPackageFrom = annualPackageFrom;
	}

	public Double getAnnualPackageTo() {
		return annualPackageTo;
	}

	public void setAnnualPackageTo(Double annualPackageTo) {
		this.annualPackageTo = annualPackageTo;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getEffectedDateFrom() {
		return effectedDateFrom;
	}

	public void setEffectedDateFrom(Date effectedDateFrom) {
		this.effectedDateFrom = effectedDateFrom;
	}

	public Date getEffectedDateTo() {
		return effectedDateTo;
	}

	public void setEffectedDateTo(Date effectedDateTo) {
		this.effectedDateTo = effectedDateTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getMinExperience() {
		return minExperience;
	}

	public void setMinExperience(Integer minExperience) {
		this.minExperience = minExperience;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Boolean getWalkIn() {
		return walkIn;
	}

	public void setWalkIn(Boolean walkIn) {
		this.walkIn = walkIn;
	}

	

}
