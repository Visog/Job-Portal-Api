package com.visog.jobportal.req.jobseeker;

public class LanguageKnownReq {

	private String user;

	private String language;

	private Boolean read;

	private Boolean write;

	private Boolean speak;

	private String proficencylevel;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public Boolean getWrite() {
		return write;
	}

	public void setWrite(Boolean write) {
		this.write = write;
	}

	public Boolean getSpeak() {
		return speak;
	}

	public void setSpeak(Boolean speak) {
		this.speak = speak;
	}

	public String getProficencylevel() {
		return proficencylevel;
	}

	public void setProficencylevel(String proficencylevel) {
		this.proficencylevel = proficencylevel;
	}

}
