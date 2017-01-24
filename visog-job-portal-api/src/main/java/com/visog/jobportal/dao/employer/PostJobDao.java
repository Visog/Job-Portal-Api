package com.visog.jobportal.dao.employer;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.employer.PostJob;

public interface PostJobDao extends AbstractDaoI {
	
	public List<PostJob> getPostJobs();

}
