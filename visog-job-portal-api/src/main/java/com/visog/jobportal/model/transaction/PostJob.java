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
	@Column(name ="ID")
	private String id;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Users user;
	
	@Column(name ="JOB_TITLE")
	private String jobTitle;
	
	@Column(name ="JOB_DESCRIPTION")
	private String jobDescription; 
	
	@Column(name ="ANNUAL_PACKAGE_FROM")
	private Double annualPackageFrom; 
	
	@Column(name ="ANNUAL_PACKAGE_TO")
	private Double annualPackageTo;
	
	@Column(name ="CURRENCY_ID")
	private Currency currency;
	
	@Column(name ="EFFECTED_DATE_FROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectedDateFrom;
	
	@Column(name ="EFFECTED_DATE_TO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectedDateTo;
	
	@ManyToOne
	@JoinColumn(name ="	STATUS_ID")
	private Status status;
	
	@Column(name ="MIN_EXPERIENCE")
	private Integer minExperience;
	
	@Column(name ="PHONE_NO")
	private String phoneNo;
	
	private Boolean 
	

}
