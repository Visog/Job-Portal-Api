package com.visog.jobportal.dao.employer;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.employer.PostJobDomains;

public interface PostJobDomainsDao extends AbstractDaoI{
	
	public List<PostJobDomains> getPostJobDomains();

}
