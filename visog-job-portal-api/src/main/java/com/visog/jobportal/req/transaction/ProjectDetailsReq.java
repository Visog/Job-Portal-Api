package com.visog.jobportal.req.transaction;

import java.util.Date;

public class ProjectDetailsReq {
	
	private String user;
	
	private String jobResponsibilities;
	
	private String projectDetails;
	
	private String projecttitle;
	
	private String employmentType;
	
	private String clientName;
	
	private Date durationfrom;
	
	private Date durationTo;
	
	private String teamSize;
	
	private String technologiesUsed;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
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

	public String getProjecttitle() {
		return projecttitle;
	}

	public void setProjecttitle(String projecttitle) {
		this.projecttitle = projecttitle;
	}

	public String getEmploymentType() {
		return employmentType;
	}

	public void setEmploymentType(String employmentType) {
		this.employmentType = employmentType;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public Date getDurationfrom() {
		return durationfrom;
	}

	public void setDurationfrom(Date durationfrom) {
		this.durationfrom = durationfrom;
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
