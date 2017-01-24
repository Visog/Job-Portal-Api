package com.visog.jobportal.model.employer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.visog.jobportal.model.AbstractModel;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.model.master.EmployerType;
import com.visog.jobportal.model.master.Industry;

@Table(name = "EMPLOYER")
@Entity
public class Employer extends AbstractModel {

	@Id
	@Column(name = "ID")
	private String id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "INDUSTRY_ID")
	private Industry industry;

	@ManyToOne
	@JoinColumn(name = "EMPLOYER_TYPE_ID")
	private EmployerType employerType;

	@Column(name = "PREMIUM_EMPLOYER")
	private String premiumEmployer;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "REGISTERED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registeredDate;

	@Column(name = "REGISTRATION_NUMBER")
	private String registrationNumber;

	@Column(name = "CIN")
	private String cin;

	@Column(name = "CREATED_SID")
	private String createdSid;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "UPDATED_SID")
	private String updatedSid;

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public EmployerType getEmployerType() {
		return employerType;
	}

	public void setEmployerType(EmployerType employerType) {
		this.employerType = employerType;
	}

	public String getPremiumEmployer() {
		return premiumEmployer;
	}

	public void setPremiumEmployer(String premiumEmployer) {
		this.premiumEmployer = premiumEmployer;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCreatedSid() {
		return createdSid;
	}

	public void setCreatedSid(String createdSid) {
		this.createdSid = createdSid;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedSid() {
		return updatedSid;
	}

	public void setUpdatedSid(String updatedSid) {
		this.updatedSid = updatedSid;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}
