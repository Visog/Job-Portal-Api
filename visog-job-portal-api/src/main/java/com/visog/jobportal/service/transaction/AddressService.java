package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.req.transaction.AddressReq;
import com.visog.jobportal.res.transaction.AddressRes;

public interface AddressService {

	public void saveAddress(AddressReq req);

	public void updateAddress(AddressReq req, String addressId);

	public List<AddressRes> getaddress();

	public AddressRes getAddress(String id);

	public Boolean deleteAddress(String addressId);
}
