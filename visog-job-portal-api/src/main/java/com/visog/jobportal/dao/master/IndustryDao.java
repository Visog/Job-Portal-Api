package com.visog.jobportal.dao.master;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.Industry;

public interface IndustryDao extends AbstractDaoI {
	
	public List<Industry> getIndustries();
	

}
