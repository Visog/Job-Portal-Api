package com.visog.jobportal.service.common;

import java.util.List;

import com.visog.jobportal.req.common.AddressReq;
import com.visog.jobportal.res.common.AddressRes;

public interface AddressService {

	public void saveAddress(AddressReq req);

	public void updateAddress(AddressReq req, String addressId);

	public List<AddressRes> getAddress();

	public AddressRes getAddress(String id);

	public Boolean deleteAddress(String addressId);
}
