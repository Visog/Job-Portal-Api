package com.visog.jobportal.serviceimpl.common;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.common.AddressDao;
import com.visog.jobportal.model.common.Address;
import com.visog.jobportal.model.master.AddrerssType;
import com.visog.jobportal.model.master.City;
import com.visog.jobportal.model.master.Country;
import com.visog.jobportal.model.master.States;
import com.visog.jobportal.req.common.AddressReq;
import com.visog.jobportal.res.common.AddressRes;
import com.visog.jobportal.service.common.AddressService;
import com.visog.jobportal.utils.DaoUtils;

public class AddressServiceImpl implements AddressService {
	private static final Logger logger = Logger.getLogger(AddressServiceImpl.class);

	@Inject
	AddressDao dao;

	/****
	 * This method saves the Address
	 * 
	 */
	public void saveAddress(AddressReq req) {

		Address address = new Address();
		States states = new States();
		states.setId(req.getState());

		Country country = new Country();
		country.setId(req.getCountry());

		City city = new City();
		city.setId(req.getCity());

		AddrerssType addressType = new AddrerssType();
		addressType.setId(req.getAddressType());

		address.setAddressLine1(req.getAddressLine1());
		address.setAddressLine2(req.getAddressLine2());
		address.setCountry(country);
		address.setState(states);
		address.setCity(city);
		address.setZipcode(req.getZipcode());
		address.setAssociatedType(req.getAssociatedType());
		address.setAssociated(req.getAssociated());
		address.setAddressType(addressType);

		DaoUtils.setEntityCreateAuditColumns(address);
		dao.save(address);
		logger.info("address created successfully : " + address.getId());

	}

	/***
	 * This updates the address
	 */
	public void updateAddress(AddressReq req, String addressId) {
		Address address = (Address) dao.getByKey(AddressReq.class, addressId);

		address.setAddressLine1(req.getAddressLine1());
		address.setAddressLine2(req.getAddressLine2());
		address.setZipcode(req.getZipcode());
		address.setAssociatedType(req.getAssociatedType());
		address.setAssociated(req.getAssociated());

		Country country = new Country();
		country.setId(req.getCountry());
		address.setCountry(country);

		States states = new States();
		states.setId(req.getState());
		address.setState(states);

		City city = new City();
		city.setId(req.getCity());
		address.setCity(city);
		
		AddrerssType addressType = new AddrerssType();
		addressType.setId(req.getAddressType());
		address.setAddressType(addressType);

		DaoUtils.setEntityCreateAuditColumns(address);
		dao.save(address);
		logger.info("address created successfully : " + address.getId());

	}

	

	/****
	 * this gives the Address List
	 */
	public List<AddressRes> getAddress() {
		List<Address> address = dao.getAddress();

		List<AddressRes> addressList = new ArrayList<>();

		AddressRes addressRes = null;

		for (Address add : address) {

			addressRes = new AddressRes();
			addressRes.setId(add.getId());
			addressRes.setAddressLine1(add.getAddressLine1());
			addressRes.setAddressLine2(add.getAddressLine2());
			addressRes.setCity(add.getCity().getId());
			addressRes.setAddressLine2(add.getAddressLine2());
			addressRes.setCountry(add.getCountry().getId());
			addressRes.setState(add.getState().getId());
			addressRes.setCity(add.getCity().getId());
			addressRes.setZipcode(add.getZipcode());
			addressRes.setAssociatedType(add.getAssociatedType());
			addressRes.setAssociated(add.getAssociated());

			addressRes.setAddressType(add.getAddressType().getId());

			addressList.add(addressRes);
		}
		return addressList;
	}

	/**
	 * This gives Single Address
	 */
	public AddressRes getAddress(String id) {

		Address address = (Address) dao.getByKey(Address.class, id);

		AddressRes addressRes = new AddressRes();
		addressRes.setId(address.getId());
		addressRes.setAddressLine1(address.getAddressLine1());
		addressRes.setAddressLine2(address.getAddressLine2());
		addressRes.setCity(address.getCity().getId());
		addressRes.setAddressLine2(address.getAddressLine2());
		addressRes.setCountry(address.getCountry().getId());
		addressRes.setState(address.getState().getId());
		addressRes.setCity(address.getCity().getId());
		addressRes.setZipcode(address.getZipcode());
		addressRes.setAssociatedType(address.getAssociatedType());
		addressRes.setAssociated(address.getAssociated());
		addressRes.setAddressType(address.getAddressType().getId());

		return addressRes;
	}

	/***
	 * This deletes the address
	 */
	public Boolean deleteAddress(String addressId) {

		return (dao.delete(Address.class, addressId) != 0);
	}

}
