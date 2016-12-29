package com.visog.jobportal.serviceimpl.transaction;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.EmployerJobseekerDao;
import com.visog.jobportal.model.transaction.EmployerJobseeker;
import com.visog.jobportal.req.transaction.EmployerJobseekerReq;
import com.visog.jobportal.res.transaction.EmployerJobseekerRes;
import com.visog.jobportal.service.transaction.EmployerJobseekerService;

/**
 * @author Ravi
 *
 */
public class EmployerJobseekerServiceImpl implements EmployerJobseekerService{
	private static final Logger logger = Logger.getLogger(EmployerJobseeker.class);
			

	@Inject
	EmployerJobseekerDao dao;
	
	/**
	 * This method saves the Specialization
	 */
	public void saveEmployerJobseeker(EmployerJobseekerReq req) {
		
		EmployerJobseeker employerJobseekers=new EmployerJobseeker();
		employerJobseekers.setActiondone(req.getActiondone());
	
		
		
		
		
	}

	@Override
	public void updateEmployerJobseeker(EmployerJobseekerReq req, String employerjobseekerId) {
		
	}

	@Override
	public List<EmployerJobseekerRes> getEmployerJobseeker(String Id) {
		return null;
	}

	@Override
	public Boolean deleteEmployerJobseeker(String employerjobseekerId) {
		return null;
	}


}
