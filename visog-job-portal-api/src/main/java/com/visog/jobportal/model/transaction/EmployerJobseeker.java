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

@Table(name = "EMPLOYER_JOBSEEKER")
@Entity
public class EmployerJobseeker extends AbstractModel {

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

	@Column(name = "CREATED_SID")
	private String createdSid;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "UPDATED_SID")
	private String updatedSid;

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

	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Column(name = "UPDATED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	

}
