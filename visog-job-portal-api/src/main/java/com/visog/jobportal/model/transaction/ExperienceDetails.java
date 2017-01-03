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
@Table(name="EXPERIENCE_DETAILS")
@Entity
public class ExperienceDetails {
	@Id
	@Column(name="ID")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="USERS")
	private Users user;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@Column(name="EMPLOYMENT_TYPE")
	private String employmentType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DURATION_FROM")
	private Date durationFrom;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DURATION_TO")
	private Date durationTo;
	
	@Column(name="DESIGNATION")
	private String designation;
	
	@Column(name="JOB_PROFILE")
	private String jobProfile;

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}


	public Date getDurationFrom() {
		return durationFrom;
	}

	public void setDurationFrom(Date durationFrom) {
		this.durationFrom = durationFrom;
	}

	public Date getDurationTo() {
		return durationTo;
	}

	public void setDurationTo(Date durationTo) {
		this.durationTo = durationTo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJobProfile() {
		return jobProfile;
	}

	public void setJobProfile(String jobProfile) {
		this.jobProfile = jobProfile;
	}
	
	
	
	
	 

}
