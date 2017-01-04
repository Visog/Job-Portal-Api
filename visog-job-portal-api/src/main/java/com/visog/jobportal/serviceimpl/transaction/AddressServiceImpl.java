package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.AddressDao;
import com.visog.jobportal.model.master.AddrerssType;
import com.visog.jobportal.model.master.City;
import com.visog.jobportal.model.master.Country;
import com.visog.jobportal.model.master.Currency;
import com.visog.jobportal.model.master.States;
import com.visog.jobportal.model.master.Status;
import com.visog.jobportal.model.transaction.Address;
import com.visog.jobportal.model.transaction.LanguageKnown;
import com.visog.jobportal.model.transaction.PostJob;
import com.visog.jobportal.model.transaction.Address;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.AddressReq;
import com.visog.jobportal.res.transaction.AddressRes;
import com.visog.jobportal.res.transaction.LanguageKnownRes;
import com.visog.jobportal.res.transaction.AddressRes;
import com.visog.jobportal.service.transaction.AddressService;
import com.visog.jobportal.utils.DaoUtils;

public class AddressServiceImpl implements AddressService{
	private static final Logger logger = Logger.getLogger(AddressServiceImpl.class);
	
	@Inject
	private AddressDao dao;

	/****
	 * This method saves the Address
	 * 
	 */
	public void saveAddress(AddressReq req) {
		
	Address address=new Address();
	States states=new States();
	states.setId(req.getState());
	
	Country country=new Country();
	country.setId(req.getCountry());
	
	City city=new City();
	city.setId(req.getCity());
	
	AddrerssType addressType=new AddrerssType();
	addressType.setId(req.getAddressType());
	
	address.setAddressLine1(req.getAddressLine1());
	address.setAddressline2(req.getAddressLine2());
	address.setZipcode(req.getZipcode());
	address.setAssociated(req.getAssociated());
	address.setState(states);
	address.setCountry(country);
	address.setCity(city);
	address.setAddressType(addressType);
	
	DaoUtils.setEntityCreateAuditColumns(address);
	dao.save(address);
	 logger.info("address created successfully : " + address.getId());
	
	}
	
	
	/***
	 * This updates the address
	 */
	public void updateAddress(AddressReq req, String addressId) {
		
		Address address=(Address) dao.getByKey(AddressReq.class,  addressId);
		
		States states=new States();
		states.setId(req.getState());
		Country country=new Country();
		country.setId(req.getCountry());
		City city=new City();
		city.setId(req.getCity());
		AddrerssType addressType=new AddrerssType();
		addressType.setId(req.getAddressType());
		
		address.setAddressLine1(req.getAddressLine1());
		address.setAddressline2(req.getAddressLine2());
		address.setZipcode(req.getZipcode());
		address.setAssociated(req.getAssociated());
		address.setState(states);
		address.setCountry(country);
		address.setCity(city);
		address.setAddressType(addressType);
		
		dao.update(address);
		logger.info(" address updated Successfully"+address.getId());
		
		
		
	}

	/****
	 * this gives the Address List
	 */
	public List<AddressRes> getaddress() {
		
		List<Address> address = dao.getAddress();

		List<AddressRes> addressList = new ArrayList<>();

		AddressRes addressRes = null;

          States states=new States();
		Country country=new Country();
		City city=new City();
		AddrerssType addressType=new AddrerssType();
		

		for (Address add : address) {

			addressRes = new AddressRes();

			addressRes.setId(add.getId());
			addressRes.setAddrtessLine1(add.getAddressLine1());
			addressRes.setAddressLine2(add.getAddressline2());
			addressRes.setCity(add.getCity().getId());
			addressRes.setCountry(add.getCountry().getId());
			addressRes.setState(add.getState().getId());
			addressRes.setAddressType(add.getAddressType().getId());
			addressRes.setAssociated(add.getAssociated());
			addressRes.setZipcode(add.getZipcode());

			
			addressList.add(addressRes);
		}
		return addressList;
	}
	
	
/**
 * This gives Single Address
 */
	public AddressRes getAddress(String id) {
		
		Address address = (Address) dao.getByKey(Address.class, id);
		AddressRes addressRes=new AddressRes();
		addressRes.setId(address.getId());
		addressRes.setAddrtessLine1(address.getAddressLine1());
		addressRes.setAddressLine2(address.getAddressline2());
		addressRes.setCity(address.getCity().getId());
		addressRes.setCountry(address.getCountry().getId());
		addressRes.setState(address.getState().getId());
		addressRes.setAddressType(address.getAddressType().getId());
		addressRes.setAssociated(address.getAssociated());
		addressRes.setZipcode(address.getZipcode());

		
		return addressRes;
	}

	/***
	 * This deletes the address
	 */
	public Boolean deleteAddress(String addressId) {
		
		
		return (dao.delete(Address.class, addressId) != 0);
		
		
	}

}
