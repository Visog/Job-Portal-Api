package com.visog.jobportal.dao.master;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.Country;

public interface CountryDao extends AbstractDaoI {

	public List<Country> getCountries();

	public Boolean isCountryExists(String name);

}
