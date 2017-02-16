package com.visog.jobportal.daoimpl.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.visog.jobportal.model.common.Users;

@Entity
@Table(name = "APP_SESSION")
public class AppSession {

	@Id
	@Column(name = "SESSION_ID")
	private String sessionId;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGIN_DATE")
	private Date loginDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LOGOUT_DATE")
	private Date logoutDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_HIT_DATE")
	private Date lastHitDate;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Date getLogoutDate() {
		return logoutDate;
	}

	public void setLogoutDate(Date logoutDate) {
		this.logoutDate = logoutDate;
	}

	public Date getLastHitDate() {
		return lastHitDate;
	}

	public void setLastHitDate(Date lastHitDate) {
		this.lastHitDate = lastHitDate;
	}

}
