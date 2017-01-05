package com.visog.jobportal.model.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.visog.jobportal.model.AbstractModel;
import com.visog.jobportal.model.master.Languages;

@Table(name = "LANGUAGE_KNOWN")
@Entity
public class LanguageKnown  extends AbstractModel{
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "LANGUAGE_ID")
	private Languages language;
	
	@Column(name = "READ_ID")
	private String read;
	
	@Column(name = "WRITE_ID")
	private String write;
	
	@Column(name = "SPEAK")
	private String speak;
	
	@Column(name = "PROFICENCY_LEVEL")
	private String proficencylevel;

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

	public Languages getLanguage() {
		return language;
	}

	public void setLanguage(Languages language) {
		this.language = language;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public String getSpeak() {
		return speak;
	}

	public void setSpeak(String speak) {
		this.speak = speak;
	}

	public String getProficencylevel() {
		return proficencylevel;
	}

	public void setProficencylevel(String proficencylevel) {
		this.proficencylevel = proficencylevel;
	}
	

}
