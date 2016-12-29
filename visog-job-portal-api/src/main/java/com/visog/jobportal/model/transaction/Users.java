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
import com.visog.jobportal.model.master.Gender;
import com.visog.jobportal.model.master.Roles;


@Table(name = "USERS")
@Entity
public class Users extends AbstractModel{
	
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "ALTERNATIVE_EMAIL")
	private String alternativeEmail;
	
	@Column(name = "DOB")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "PHONE_NO")
	private String phone;
	
	@Column(name = "LANDLINE")
	private String landline;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private Roles role;
	
	@ManyToOne
	@JoinColumn(name = "GENDER_ID")
	private Gender gender;
	
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
	
	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAlternativeEmail() {
		return alternativeEmail;
	}

	public void setAlternativeEmail(String alternativeEmail) {
		this.alternativeEmail = alternativeEmail;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
}

