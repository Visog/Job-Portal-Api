package com.visog.jobportal.dao.master;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.Gender;


public interface GenderDao extends AbstractDaoI {

	public List<Gender> getGenders();
	
}
