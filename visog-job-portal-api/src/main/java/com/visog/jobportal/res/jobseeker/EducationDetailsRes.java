package com.visog.jobportal.res.jobseeker;

import java.util.Date;

public class EducationDetailsRes {

	private String id;

	private String user;

	private String courses;

	private String educationType;

	private String specialization;

	private String university;

	private Date durationFromDate;

	private Date durationToDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
