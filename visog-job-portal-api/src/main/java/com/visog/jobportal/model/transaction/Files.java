package com.visog.jobportal.model.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.visog.jobportal.model.AbstractModel;

@Table(name = "FILES")
@Entity
public class Files extends AbstractModel{
	
	@Id
	@Column(name = "ID")
	private String id;
	
	@Column(name = "FILE_PATH")
	private String filepath;
	
	@ManyToOne
	@JoinColumn(name = "FILE_TYPE_ID")
	private Users filetype;
	
	@Column(name = "ASSOCIATED_TYPE")
	private String associatedtype;
	
	@Column(name = "ASSOCIATED_ID")
	private String associated;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Users getFiletype() {
		return filetype;
	}

	public void setFiletype(Users filetype) {
		this.filetype = filetype;
	}

	public String getAssociatedtype() {
		return associatedtype;
	}

	public void setAssociatedtype(String associatedtype) {
		this.associatedtype = associatedtype;
	}

	public String getAssociated() {
		return associated;
	}

	public void setAssociated(String associated) {
		this.associated = associated;
	}
	

}
