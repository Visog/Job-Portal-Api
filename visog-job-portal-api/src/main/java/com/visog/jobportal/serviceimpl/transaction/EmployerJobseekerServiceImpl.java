package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.EmployerJobseekerDao;
import com.visog.jobportal.model.master.Status;
import com.visog.jobportal.model.transaction.EmployerJobseeker;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.EmployerJobseekerReq;
import com.visog.jobportal.res.transaction.EmployerJobseekerRes;
import com.visog.jobportal.service.transaction.EmployerJobseekerService;
import com.visog.jobportal.utils.DaoUtils;

/**
 * @author Ravi
 *
 */
public class EmployerJobseekerServiceImpl implements EmployerJobseekerService {

	private static final Logger logger = Logger.getLogger(EmployerJobseekerServiceImpl.class);

	@Inject
	EmployerJobseekerDao dao;

	/**
	 * This method saves the EmployerJobseeker author Ravi
	 */
	public void saveEmployerJobseeker(EmployerJobseekerReq req) {

		EmployerJobseeker employerJobseeker = new EmployerJobseeker();

		Users users = new Users();
		users.setId(req.getEmployer());
		employerJobseeker.setEmployer(users);

		users.setId(req.getJobSeeker());
		employerJobseeker.setJobSeeker(users);

		Status status = new Status();
		status.setId(req.getStatus());
		employerJobseeker.setStatus(status);

		employerJobseeker.setActionDone(req.getActionDone());

		dao.save(employerJobseeker);

		DaoUtils.setEntityCreateAuditColumns(employerJobseeker);

		logger.info("Employer JobSeeker Created Successfully" + employerJobseeker.getId());

	}

	/**
	 * This method updates the EmployerJobseeker
	 */
	public void updateEmployerJobseeker(EmployerJobseekerReq req, String employerjobseekerId) {

		EmployerJobseeker employerJobseeker = (EmployerJobseeker) dao.getByKey(EmployerJobseeker.class,
				employerjobseekerId);
		Users users = new Users();
		users.setId(req.getEmployer());
		employerJobseeker.setEmployer(users);

		users.setId(req.getJobSeeker());
		employerJobseeker.setJobSeeker(users);

		Status status = new Status();
		status.setId(req.getStatus());
		employerJobseeker.setStatus(status);

		employerJobseeker.setActionDone(req.getActionDone());

		dao.update(employerJobseeker);

		logger.info("EmployerJobseeker updated successfully : " + employerJobseeker.getId());
	}

	/**
	 * This method returns all the EmployerJobseekers
	 */
	public List<EmployerJobseekerRes> getEmployerJobseeker() {

		List<EmployerJobseeker> employerJobseekers = dao.getEmployerjobseekers();
		List<EmployerJobseekerRes> employerJobseekerList = new ArrayList<>();
		EmployerJobseekerRes employerJobseekerRes = null;

		for (EmployerJobseeker employerJobseeker : employerJobseekers) {

			employerJobseekerRes = new EmployerJobseekerRes();
			employerJobseekerRes.setId(employerJobseeker.getId());
			employerJobseekerRes.setEmployer(employerJobseeker.getEmployer().getId());
			employerJobseekerRes.setJobSeeker(employerJobseeker.getJobSeeker().getId());
			employerJobseekerRes.setStatus(employerJobseeker.getStatus().getId());
			employerJobseekerRes.setActionDone(employerJobseeker.getActionDone());

			employerJobseekerList.add(employerJobseekerRes);
		}
		return employerJobseekerList;

	}

	/**
	 * This method returns EmployerJobseeker by given id
	 */
	public EmployerJobseekerRes getEmployerJobseeker(String id) {

		EmployerJobseeker employerJobseekers = (EmployerJobseeker) dao.getByKey(EmployerJobseeker.class, id);
		EmployerJobseekerRes employerJobseekerRes = new EmployerJobseekerRes();

		employerJobseekerRes.setId(employerJobseekers.getId());
		employerJobseekerRes.setEmployer(employerJobseekers.getEmployer().getId());
		employerJobseekerRes.setJobSeeker(employerJobseekers.getJobSeeker().getId());
		employerJobseekerRes.setStatus(employerJobseekers.getStatus().getId());
		employerJobseekerRes.setActionDone(employerJobseekers.getActionDone());

		return employerJobseekerRes;
	}

	/**
	 * This method deletes the given EmployerJobseeker
	 */
	public Boolean deleteEmployerJobseeker(String employerjobseekerId) {
		return (dao.delete(EmployerJobseeker.class, employerjobseekerId) != 0);

	}

}
