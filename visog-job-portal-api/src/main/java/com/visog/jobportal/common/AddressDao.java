package com.visog.jobportal.common;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.common.Address;
import com.visog.jobportal.req.common.AddressReq;

public interface AddressDao extends AbstractDaoI {

	public List<Address> getAddress();

	public Address getDataByAssociatedAddress(String addressAssociatedId);

}
