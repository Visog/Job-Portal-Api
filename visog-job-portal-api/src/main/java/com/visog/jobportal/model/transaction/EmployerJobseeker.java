package com.visog.jobportal.model.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.visog.jobportal.model.AbstractModel;

@Table(name = "EMPLOYER_JOBSEEKER")
@Entity
public class EmployerJobseeker extends AbstractModel{
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "EMPLOYER_ID")
	private Users employer;
	
	@ManyToOne
	@JoinColumn(name = "JOB_SEEKER_ID")
	private Users jobseeker;
	
	@ManyToOne
	@JoinColumn(name = "STATUS_ID")
	private Users status;
	
	@Column(name = "ACTION_DONE_BY")
	private String actiondone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Users getEmployer() {
		return employer;
	}

	public void setEmployer(Users employer) {
		this.employer = employer;
	}

	public Users getJobseeker() {
		return jobseeker;
	}

	public void setJobseeker(Users jobseeker) {
		this.jobseeker = jobseeker;
	}

	public Users getStatus() {
		return status;
	}

	public void setStatus(Users status) {
		this.status = status;
	}

	public String getActiondone() {
		return actiondone;
	}

	public void setActiondone(String actiondone) {
		this.actiondone = actiondone;
	}
	
}
