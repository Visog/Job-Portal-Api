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
import com.visog.jobportal.model.master.Domains;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.model.master.Industry;
import com.visog.jobportal.model.master.JobRole;

@Table(name = "JOB_SEEKER")
@Entity

public class JobSeeker extends AbstractModel {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "RESUME_HEADLINE")
	private String resumeHeadline;

	@ManyToOne
	@JoinColumn(name = "DOMAIN_ID")
	private Domains domain;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user;

	@Column(name = "KEY_SKILLS")
	private String keySkills;

	@Column(name = "WORK_EXPERIENCE_YEARS")
	private Integer workExperienceYears;

	@Column(name = "WORK_EXPERIENCE_MONTHS")
	private Integer workExperienceMonths;

	@Column(name = "HOBBIES_AND_INTEREST")
	private String hobbiesAndInterest;

	@ManyToOne
	@JoinColumn(name = "JOB_ROLE_ID")
	private JobRole jobRole;

	@Column(name = "OTHER_JOB_ROLE")
	private String otherJobRole;

	@ManyToOne
	@JoinColumn(name = "INDUSTRY_ID")
	private Industry industry;

	@Column(name = "PROFILE_SUMMARY")
	private String profileSummary;

	@ManyToOne
	@JoinColumn(name = "EMPLOYMENT_TYPE_ID")
	private EmploymentType employmentType;

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

	public String getResumeHeadline() {
		return resumeHeadline;
	}

	public void setResumeHeadline(String resumeHeadline) {
		this.resumeHeadline = resumeHeadline;
	}

	public Domains getDomain() {
		return domain;
	}

	public void setDomain(Domains domain) {
		this.domain = domain;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getKeySkills() {
		return keySkills;
	}

	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}

	public int getWorkExperienceYears() {
		return workExperienceYears;
	}

	public void setWorkExperienceYears(int workExperienceYears) {
		this.workExperienceYears = workExperienceYears;
	}

	public int getWorkExperienceMonths() {
		return workExperienceMonths;
	}

	public void setWorkExperienceMonths(int workExperienceMonths) {
		this.workExperienceMonths = workExperienceMonths;
	}

	public String getHobbiesAndInterest() {
		return hobbiesAndInterest;
	}

	public void setHobbiesAndInterest(String hobbiesAndInterest) {
		this.hobbiesAndInterest = hobbiesAndInterest;
	}

	public JobRole getJobRole() {
		return jobRole;
	}

	public void setJobRole(JobRole jobRole) {
		this.jobRole = jobRole;
	}

	public String getOtherJobRole() {
		return otherJobRole;
	}

	public void setOtherJobRole(String otherJobRole) {
		this.otherJobRole = otherJobRole;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public String getProfileSummary() {
		return profileSummary;
	}

	public void setProfileSummary(String profileSummary) {
		this.profileSummary = profileSummary;
	}

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

}
