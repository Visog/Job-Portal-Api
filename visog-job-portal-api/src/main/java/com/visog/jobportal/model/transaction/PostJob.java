package com.visog.jobportal.model.transaction;

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
import com.visog.jobportal.model.master.Currency;
import com.visog.jobportal.model.master.Status;

@Table(name = "POST_JOB")
@Entity
public class PostJob extends AbstractModel {

	@Id
	@Column(name = "ID")
	private String id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user;

	@Column(name = "JOB_TITLE")
	private String jobTitle;

	@Column(name = "JOB_DESCRIPTION")
	private String jobDescription;

	@Column(name = "ANNUAL_PACKAGE_FROM")
	private Double annualPackageFrom;

	@Column(name = "ANNUAL_PACKAGE_TO")
	private Double annualPackageTo;

	@ManyToOne
	@JoinColumn(name = "CURRENCY_ID")
	private Currency currency;

	@Column(name = "COMPANY")
	private String company;

	@Column(name = "EFFECTED_DATE_FROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectedDateFrom;

	@Column(name = "EFFECTED_DATE_TO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectedDateTo;

	@ManyToOne
	@JoinColumn(name = "	STATUS_ID")
	private Status status;

	@Column(name = "MIN_EXPERIENCE")
	private Integer minExperience;

	@Column(name = "PHONE_NO")
	private String phoneNo;

	@Column(name = "WALKIN")
	private Boolean walkIn;

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

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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
