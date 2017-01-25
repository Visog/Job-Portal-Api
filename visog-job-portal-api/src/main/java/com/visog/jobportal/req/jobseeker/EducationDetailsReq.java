package com.visog.jobportal.req.jobseeker;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.model.master.Courses;
import com.visog.jobportal.model.master.EducationType;
import com.visog.jobportal.model.master.Specilization;
import com.visog.jobportal.model.master.University;

public class EducationDetailsReq {

	private String user;

	private String courses;

	private String educationType;

	private String specialization;

	private String university;

	private Date durationFromDate;

	private Date durationToDate;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}

	public String getEducationType() {
		return educationType;
	}

	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
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
			
			

}
