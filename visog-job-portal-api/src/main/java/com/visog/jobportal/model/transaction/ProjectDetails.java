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
import com.visog.jobportal.model.master.EmploymentType;


@Entity
@Table(name ="PROJECT_DETAILS")
public class ProjectDetails extends AbstractModel{
	
	@Id
	@Column(name ="ID")
	private String id;
	
	@ManyToOne
	@JoinColumn(name ="USER_ID")
	private Users user;
	
	@Column(name ="JOB_RESPONSIBILITIES")
	private String jobResponsibilities;
	
	@Column(name ="PROJECT_DETAILS")
	private String projectDetails;
	
	@Column(name ="PROJECT_TITLE")
	private String projectTitle;
	
	@ManyToOne
	@JoinColumn(name ="EMPLOYMENT_TYPE_ID")
	private EmploymentType employmentType;
	
	@Column(name ="CLIENT_NAME")
	private String clientName;
	
	@Column(name ="DURATION_FROM")
	@Temporal(TemporalType.TIMESTAMP)
	private Date durationFrom;
	
	@Column(name ="DURATION_TO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date durationTo;
	
	@Column(name ="TEAM_SIZE")
	private String teamSize;
	
	@Column(name ="TECHNOLOGIES_USED")
	private String technologiesUsed;

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

	public String getJobResponsibilities() {
		return jobResponsibilities;
	}

	public void setJobResponsibilities(String jobResponsibilities) {
		this.jobResponsibilities = jobResponsibilities;
	}

	public String getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public EmploymentType getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(EmploymentType employmentType) {
		this.employmentType = employmentType;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
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

	public String getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(String teamSize) {
		this.teamSize = teamSize;
	}

	public String getTechnologiesUsed() {
		return technologiesUsed;
	}

	public void setTechnologiesUsed(String technologiesUsed) {
		this.technologiesUsed = technologiesUsed;
	}
	
	

	
}
