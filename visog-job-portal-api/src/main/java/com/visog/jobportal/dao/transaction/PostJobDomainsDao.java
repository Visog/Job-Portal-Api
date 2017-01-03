package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.PostJobDomains;

public interface PostJobDomainsDao extends AbstractDaoI{
	
	public List<PostJobDomains> getPostJobDomains();

}
