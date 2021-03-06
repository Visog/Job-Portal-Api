package com.visog.jobportal.serviceimpl.common;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.common.EmployerJobSeekerDao;
import com.visog.jobportal.model.common.EmployerJobSeeker;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.model.master.Status;
import com.visog.jobportal.req.employer.EmployerJobSeekerReq;
import com.visog.jobportal.res.common.EmployerJobSeekerRes;
import com.visog.jobportal.service.common.EmployerJobSeekerService;
import com.visog.jobportal.utils.DaoUtils;

/**
 * @author Ravi
 *
 */
public class EmployerJobSeekerServiceImpl implements EmployerJobSeekerService {

	private static final Logger logger = Logger.getLogger(EmployerJobSeekerServiceImpl.class);

	@Inject
	private EmployerJobSeekerDao dao;

	public void saveEmployerJobSeeker(EmployerJobSeekerReq req) {

		EmployerJobSeeker employerJobSeeker = new EmployerJobSeeker();
		Users users = new Users();
		users.setId(req.getEmployer());
		employerJobSeeker.setEmployer(users);

		users.setId(req.getJobSeeker());
		employerJobSeeker.setJobSeeker(users);

		Status status = new Status();
		status.setId(req.getStatus());
		employerJobSeeker.setStatus(status);
		employerJobSeeker.setActionDone(req.getActionDone());

		DaoUtils.setEntityCreateAuditColumns(employerJobSeeker);

		dao.save(employerJobSeeker);

		logger.info("Employer Job Seeker created successfully" + employerJobSeeker.getId());

	}

	public EmployerJobSeekerRes getEmployerJobSeeker(String Id) {

		EmployerJobSeeker employerJobSeeker = (EmployerJobSeeker) dao.getByKey(EmployerJobSeeker.class, Id);
		EmployerJobSeekerRes employerJobSeekerRes = new EmployerJobSeekerRes();
		employerJobSeekerRes.setId(employerJobSeeker.getId());
		employerJobSeekerRes.setEmployer(employerJobSeeker.getEmployer().getId());
		employerJobSeekerRes.setJobSeeker(employerJobSeeker.getJobSeeker().getId());
		employerJobSeekerRes.setStatus(employerJobSeeker.getStatus().getId());
		employerJobSeekerRes.setActionDone(employerJobSeeker.getActionDone());

		return employerJobSeekerRes;
	}

	public void updateEmployerJobSeeker(EmployerJobSeekerReq req, String employerJobSeekerId) {

		EmployerJobSeeker employerJobSeeker = (EmployerJobSeeker) dao.getByKey(EmployerJobSeeker.class,
				employerJobSeekerId);

		Users users = new Users();
		users.setId(req.getEmployer());
		employerJobSeeker.setEmployer(users);

		users.setId(req.getJobSeeker());
		employerJobSeeker.setJobSeeker(users);

		Status status = new Status();
		status.setId(req.getStatus());
		employerJobSeeker.setStatus(status);
		employerJobSeeker.setActionDone(req.getActionDone());
		dao.update(employerJobSeeker);

		logger.info("EmployerJobseeker updated successfully : " + employerJobSeeker.getId());
	}

	public Boolean deleteEmployerJobSeeker(String employerJobSeekerId) {

		return (dao.delete(EmployerJobSeeker.class, employerJobSeekerId) != 0);
	}

	public List<EmployerJobSeekerRes> getEmployerJobSeeker() {

		List<EmployerJobSeeker> employerJobSeekers = dao.getEmployerJobSeeker();

		List<EmployerJobSeekerRes> employerJobseekerList = new ArrayList<>();

		EmployerJobSeekerRes employerJobseekerRes = null;

		for (EmployerJobSeeker employerJobSeeker : employerJobSeekers) {

			employerJobseekerRes = new EmployerJobSeekerRes();
			employerJobseekerRes.setEmployer(employerJobSeeker.getEmployer().getId());
			employerJobseekerRes.setJobSeeker(employerJobSeeker.getJobSeeker().getId());
			employerJobseekerRes.setStatus(employerJobSeeker.getStatus().getId());
			employerJobseekerRes.setActionDone(employerJobSeeker.getActionDone());

		}
		return employerJobseekerList;
	}

}
