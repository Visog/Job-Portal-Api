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
		 
		 Users users=new Users();
		 users.setId(req.getEmployer());
		 users.setId(req.getJobseeker());
		 employerJobseekers.setEmployer(users);
		 employerJobseekers.setJobseeker(users);
		
		 Status  status=new Status();
		 status.setId(req.getStatus());
		 employerJobseekers.setStatus(users);

		 DaoUtils.setEntityCreateAuditColumns(employerJobseekers);
		 dao.save(employerJobseekers);
		 logger.info("EmployerJobseeker created successfully : " + employerJobseekers.getId());
		
	}
	

	/**
	 * This method updates the EmployerJobseeker
	 */
	public void updateEmployerJobseeker(EmployerJobseekerReq req, String employerjobseekerId) {

		EmployerJobseeker employerJobseekers=(EmployerJobseeker) dao.getByKey(EmployerJobseeker.class, employerjobseekerId);
		employerJobseekers.setActiondone(req.getActiondone());
		 
		Users users=new Users();
		 users.setId(req.getEmployer());
		 users.setId(req.getJobseeker());
		 employerJobseekers.setEmployer(users);
		 employerJobseekers.setJobseeker(users);
		
		 Status  status=new Status();
		 status.setId(req.getStatus());
		 employerJobseekers.setStatus(users);
		 dao.update(employerJobseekers);
		logger.info("EmployerJobseeker updated successfully : " + employerJobseekers.getId());
	}


	/**
	 * This method returns all the EmployerJobseekers
	 */
	public List<EmployerJobseekerRes> getEmployerJobseeker() {
		
		List<EmployerJobseeker> employerJobseekers=dao.getEmployerjobseekers();
		List<EmployerJobseekerRes> employerJobseekerList=new ArrayList<>();
		EmployerJobseekerRes employerJobseekerRes=null;
		for(EmployerJobseeker employerJobseeker:employerJobseekers){
			
			employerJobseekerRes=new EmployerJobseekerRes();
			employerJobseekerRes.setId(employerJobseeker.getId());
			employerJobseekerRes.setActiondone(employerJobseeker.getActiondone());
			employerJobseekerRes.setStatus(employerJobseeker.getStatus().getId());
			employerJobseekerRes.setJobseeker(employerJobseeker.getJobseeker().getId());
			employerJobseekerRes.setEmployer(employerJobseeker.getEmployer().getId());
			
			employerJobseekerList.add(employerJobseekerRes);
		}
		return employerJobseekerList;
	
	}


	/**
	 * This method returns  EmployerJobseeker by given id
	 */
	public EmployerJobseekerRes getEmployerJobseeker(String id) {
		
		EmployerJobseeker employerJobseekers=(EmployerJobseeker) dao.getByKey(EmployerJobseeker.class, id);
		EmployerJobseekerRes employerJobseekerRes=new EmployerJobseekerRes();
		employerJobseekerRes.setId(employerJobseekers.getId());
		employerJobseekerRes.setActiondone(employerJobseekers.getActiondone());
		employerJobseekerRes.setStatus(employerJobseekers.getStatus().getId());
		employerJobseekerRes.setEmployer(employerJobseekers.getEmployer().getId());
		employerJobseekerRes.setJobseeker(employerJobseekers.getJobseeker().getId());
		
		return employerJobseekerRes;
	}


	/**
	 * This method deletes the given EmployerJobseeker  
	 */
	public Boolean deleteEmployerJobseeker(String employerjobseekerId) {
		return (dao.delete(EmployerJobseeker.class, employerjobseekerId)!=0);

	}
	

}
