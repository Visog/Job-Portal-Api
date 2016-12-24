package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.AddressTypeReq;
import com.visog.jobportal.res.master.AddressTypeRes;

public interface AddressTypeService {

	public void saveAddressType(AddressTypeReq req);

	public void updateAddressType(AddressTypeReq req, String addressTypeId);

	public List<AddressTypeRes> getAddressTypes();

	public AddressTypeRes getAddressType(String id);

	public Boolean deleteAddressType(String addressTypeId);

}
