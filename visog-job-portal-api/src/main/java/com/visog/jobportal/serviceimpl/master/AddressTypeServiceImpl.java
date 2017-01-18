package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.AddressTypeDao;
import com.visog.jobportal.model.master.AddrerssType;
import com.visog.jobportal.model.master.Roles;
import com.visog.jobportal.req.master.AddressTypeReq;
import com.visog.jobportal.res.master.AddressTypeRes;
import com.visog.jobportal.res.master.RolesRes;
import com.visog.jobportal.service.master.AddressTypeService;
import com.visog.jobportal.utils.DaoUtils;

public class AddressTypeServiceImpl implements AddressTypeService {
	
	
	private static final Logger logger = Logger.getLogger(AddressTypeServiceImpl.class);
	
	@Inject
	AddressTypeDao dao;


	/**
	 * This method saves the AddressType
	 */
	public void saveAddressType(AddressTypeReq req) {
		
		AddrerssType addressType = new AddrerssType();
		addressType.setName(req.getName());
		addressType.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(addressType);
		
		dao.save(addressType);
		
		logger.info("AddressType created successfully : " + addressType.getId());
		
	}

	/**
	 * This method updates the AddressType
	 */
	public void updateAddressType(AddressTypeReq req, String addressTypeId) {
		
		AddrerssType addressType = (AddrerssType) dao.getByKey(AddrerssType.class, addressTypeId);
		addressType.setName(req.getName());
		addressType.setDescription(req.getDescription());
		dao.update(addressType);
		logger.info("Role updated successfully : " + addressType.getId());
		
	}

	/**
	 * This method returns all the AddressTypes
	 */
	public List<AddressTypeRes> getAddressTypes() {
		

		List<AddrerssType> addressTypes = dao.getAddressTypes();

		List<AddressTypeRes> addressTypelist = new ArrayList<>();
		AddressTypeRes addressTypeRes = null;

		for (AddrerssType addressType : addressTypes) {
			addressTypeRes = new AddressTypeRes();
			addressTypeRes.setId(addressType.getId());
			addressTypeRes.setName(addressType.getName());
			addressTypeRes.setDescription(addressType.getDescription());
			addressTypelist.add(addressTypeRes);
		}

		return addressTypelist;
	}

	/**
	 * This method returns AddressType Details for the given AddressType id  
	 */
	public AddressTypeRes getAddressType(String id) {
		AddrerssType addressType = (AddrerssType) dao.getByKey(AddrerssType.class, id);
		AddressTypeRes addressTypeRes = new AddressTypeRes();
		addressTypeRes.setId(addressType.getId());
		addressTypeRes.setName(addressType.getName());
		addressTypeRes.setDescription(addressType.getDescription());
		
		return addressTypeRes;
	}

	/**
	 * This method deletes the given AddrerssType  
	 */
	public Boolean deleteAddressType(String addressTypeId) {
		return (dao.delete(AddrerssType.class, addressTypeId) !=0);
	}


	

}
