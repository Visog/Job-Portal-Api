package com.visog.jobportal.model.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.visog.jobportal.model.AbstractModel;
import com.visog.jobportal.model.master.Courses;
import com.visog.jobportal.model.master.EducationType;
import com.visog.jobportal.model.master.Specilization;
import com.visog.jobportal.model.master.University;

@Table(name = "EDUCATION_DETAILS")
@Entity
public class EducationDetails extends AbstractModel{
	
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
	private String durationFrom;

	@Column(name = "DURATION_TO_DATE")
	private String durationTo;

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

	public String getDurationFrom() {
		return durationFrom;
	}

	public void setDurationFrom(String durationFrom) {
		this.durationFrom = durationFrom;
	}

	public String getDurationTo() {
		return durationTo;
	}

	public void setDurationTo(String durationTo) {
		this.durationTo = durationTo;
	}

	

}