package com.visog.jobportal.serviceimpl.transaction;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.JobSeekerDao;
import com.visog.jobportal.req.transaction.JobSeekerReq;
import com.visog.jobportal.res.transaction.JobSeekerRes;
import com.visog.jobportal.service.transaction.JobSeekerService;
import com.visog.jobportal.utils.DaoUtils;

public class JobSeekerServiceImpl implements JobSeekerService {

	private static final Logger logger = Logger.getLogger(JobSeekerServiceImpl.class);
	
	@Inject
	JobSeekerDao dao;


	/**
	 * @author Raghava
	 */
	
	public Boolean saveJObSeeker(JobSeekerReq req) {
		return null;
		
	}

	public Boolean updateJobSeeker(JobSeekerReq req, String jobseekerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<JobSeekerRes> getJobSeekers() {
		// TODO Auto-generated method stub
		return null;
	}

	public JobSeekerRes getJobSeeker(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deleteJobSeeker(String jobseekerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
