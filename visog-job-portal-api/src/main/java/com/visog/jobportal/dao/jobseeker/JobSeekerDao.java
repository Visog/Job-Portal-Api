package com.visog.jobportal.dao.jobseeker;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.jobseeker.JobSeeker;

public interface JobSeekerDao extends AbstractDaoI {

	public List<JobSeeker> getJobSeekers();
}