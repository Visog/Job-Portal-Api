package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.JobSeeker;

public interface JobSeekerDao extends AbstractDaoI {

	public List<JobSeeker> getJobSeekers();
}
