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
import com.visog.jobportal.model.master.Courses;
import com.visog.jobportal.model.master.EducationType;
import com.visog.jobportal.model.master.Specilization;
import com.visog.jobportal.model.master.University;

@Table(name = "EDUCATION_DETAILS")
@Entity
public class EducationDetails extends AbstractModel {

	@Id
	@Column(name = "ID")
	private String id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "COURSES_ID")
	private Courses courses;

	@ManyToOne
	@JoinColumn(name = "EDUCATION_TYPE_ID")
	private EducationType educationType;

	@ManyToOne
	@JoinColumn(name = "SPECIALIZATION_ID")
	private Specilization specialization;

	@ManyToOne
	@JoinColumn(name = "UNIVERSITY_ID")
	private University university;

	@Column(name = "DURATION_FROM_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date durationFromDate;

	@Column(name = "DURATION_TO_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date durationToDate;

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

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}

	public EducationType getEducationType() {
		return educationType;
	}

	public void setEducationType(EducationType educationType) {
		this.educationType = educationType;
	}

	public Specilization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specilization specialization) {
		this.specialization = specialization;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Date getDurationFromDate() {
		return durationFromDate;
	}

	public void setDurationFromDate(Date durationFromDate) {
		this.durationFromDate = durationFromDate;
	}

	public Date getDurationToDate() {
		return durationToDate;
	}

	public void setDurationToDate(Date durationToDate) {
		this.durationToDate = durationToDate;
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