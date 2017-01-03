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

@Table(name = "PROJECT_DETAILS")
@Entity
public class ProjectDetails extends AbstractModel {

	@Id
	@Column(name = "ID")
	private String id;

	@ManyToOne
	@JoinColumn(name = "USERS")
	private Users user;

	@Column(name = "JOB_RESPONSIBILITIES")
	private String jobresponsibilities;

	@Column(name = "PROJECT_DETAILS")
	private String projectdetails;

	@Column(name = "PROJECT_TITLE")
	private String projecttitle;

	@ManyToOne
	@JoinColumn(name = "EMPLOYMENT_TYPE ")
	private EmploymentType employmenttype;

	@Column(name = "CLIENT_NAME ")
	private String clientname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DURATION_FROM ")
	private Date durationfrom;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DURATION_TO ")
	private Date durationto;

	@Column(name = "TEAM_SIZE ")
	private String teamsize;
	
	@Column(name="TECHNOLOGIES_USED")
	private String technologiesused;

	

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

	public String getJobresponsibilities() {
		return jobresponsibilities;
	}

	public void setJobresponsibilities(String jobresponsibilities) {
		this.jobresponsibilities = jobresponsibilities;
	}

	public String getProjectdetails() {
		return projectdetails;
	}

	public void setProjectdetails(String projectdetails) {
		this.projectdetails = projectdetails;
	}

	public String getProjecttitle() {
		return projecttitle;
	}

	public void setProjecttitle(String projecttitle) {
		this.projecttitle = projecttitle;
	}

	public EmploymentType getEmploymenttype() {
		return employmenttype;
	}

	public void setEmploymenttype(EmploymentType employmenttype) {
		this.employmenttype = employmenttype;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public Date getDurationfrom() {
		return durationfrom;
	}

	public void setDurationfrom(Date durationfrom) {
		this.durationfrom = durationfrom;
	}

	public Date getDurationto() {
		return durationto;
	}

	public void setDurationto(Date durationto) {
		this.durationto = durationto;
	}

	public String getTeamsize() {
		return teamsize;
	}

	public void setTeamsize(String teamsize) {
		this.teamsize = teamsize;
	}
	public String getTechnologiesused() {
		return technologiesused;
	}

	public void setTechnologiesused(String technologiesused) {
		this.technologiesused = technologiesused;
	}

}
