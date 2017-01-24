package com.visog.jobportal.dao.common;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.common.Address;

public interface AddressDao extends AbstractDaoI {

	public List<Address> getAddress();

}
