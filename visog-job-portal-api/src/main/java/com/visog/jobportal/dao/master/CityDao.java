package com.visog.jobportal.dao.master;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.City;

public interface CityDao extends AbstractDaoI{
	
	public List<City> getCities();

	public Boolean isCityExists(String name);
}
