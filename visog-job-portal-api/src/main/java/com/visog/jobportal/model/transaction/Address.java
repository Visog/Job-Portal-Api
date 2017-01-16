package com.visog.jobportal.model.transaction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.visog.jobportal.model.AbstractModel;
import com.visog.jobportal.model.master.City;
import com.visog.jobportal.model.master.Country;
import com.visog.jobportal.model.master.States;
import com.visog.jobportal.model.master.AddrerssType;

@Table(name = "ADDRESS")
@Entity
public class Address extends AbstractModel {
	@Id
	@Column(name = "Id")
	private String id;

	@Column(name = "ADDRESS_LINE1")
	private String addressLine1;

	@Column(name = "ADDRESS_LINE2")
	private String addressline2;

	@ManyToOne
	@JoinColumn(name = "STATE_ID")
	private States state;

	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	@ManyToOne
	@JoinColumn(name = "CITY_ID")
	private City city;

	@Column(name = "ZIPCODE")
	private String zipcode;

	@Column(name = "ASSOCIATED_TYPE")
	private String associatedType;

	@Column(name = "ASSOCIATED_ID")
	private String associated;

	@ManyToOne
	@JoinColumn(name = "ADDRESS_TYPE_ID")
	private AddrerssType addressType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressline2() {
		return addressline2;
	}

	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}

	public States getState() {
		return state;
	}

	public void setState(States state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAssociatedType() {
		return associatedType;
	}

	public void setAssociatedType(String associatedType) {
		this.associatedType = associatedType;
	}

	public String getAssociated() {
		return associated;
	}

	public void setAssociated(String associated) {
		this.associated = associated;
	}

	public AddrerssType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddrerssType addressType) {
		this.addressType = addressType;
	}

}
