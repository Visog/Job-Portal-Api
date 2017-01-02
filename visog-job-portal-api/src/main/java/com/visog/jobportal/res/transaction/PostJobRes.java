package com.visog.jobportal.res.transaction;

import java.util.Date;

public class PostJobRes {

	
	private String id;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
