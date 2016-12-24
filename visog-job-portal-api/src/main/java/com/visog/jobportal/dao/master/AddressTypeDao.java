package com.visog.jobportal.dao.master;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.AddrerssType;

public interface AddressTypeDao extends AbstractDaoI {

	public List<AddrerssType> getAddressTypes();

}
