package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.Address;

public interface AddressDao extends AbstractDaoI {

	public List<Address> getAddress();

}
