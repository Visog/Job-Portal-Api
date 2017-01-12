package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.JobRoleDao;
import com.visog.jobportal.model.master.JobRole;
import com.visog.jobportal.req.master.JobRoleReq;
import com.visog.jobportal.res.master.JobRoleRes;
import com.visog.jobportal.service.master.JobRoleService;
import com.visog.jobportal.utils.DaoUtils;

public class JobRoleServiceImpl implements JobRoleService {

	private static final Logger logger = Logger.getLogger(JobRoleServiceImpl.class);

	@Inject
	JobRoleDao dao;

	/**
	 * This method saves the JobRole
	 * @author Raghava
	 */
	public void saveJobRole(JobRoleReq req) {

		
		JobRole jobRole = new JobRole();
		jobRole.setName(req.getName());
		jobRole.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(jobRole);
		
		dao.save(jobRole);

		logger.info("JobRole created successfully : " + jobRole.getId());
	}

	/**
	 * This method updates the JobRole
	 * @author Raghava
	 */
	public void updateJobRole(JobRoleReq req, String jobRoleId) {

		JobRole jobRole = (JobRole) dao.getByKey(JobRole.class, jobRoleId);
		jobRole.setName(req.getName());
		jobRole.setDescription(req.getDescription());
		dao.update(jobRole);
		logger.info("JobRole updated successfully : " + jobRole.getId());
	}
	
	/**
	 * This method returns all the Jobroles
	 * @author Raghava
	 */
	public List<JobRoleRes> getJobRoles() {
		List<JobRole> jobRole = dao.getJobRoles();

		List<JobRoleRes> jobRolesList = new ArrayList<>();
		JobRoleRes rolesRes = null;

		for (JobRole jobRoles : jobRole) {
			rolesRes = new JobRoleRes();
			rolesRes.setId(jobRoles.getId());
			rolesRes.setName(jobRoles.getName());
			rolesRes.setDescription(jobRoles.getDescription());
			jobRolesList.add(rolesRes);
		}

		return jobRolesList;
	}


	/**
	 * This method returns JobRole Details for the given JobRole id  
	 * @author Raghava
	 */
	public JobRoleRes getJobRole(String id) {
		
		JobRole jobRole = (JobRole) dao.getByKey(JobRole.class, id);
		JobRoleRes rolesRes = new JobRoleRes();
		rolesRes.setId(jobRole.getId());
		rolesRes.setName(jobRole.getName());
		rolesRes.setDescription(jobRole.getDescription());
		return rolesRes;
	}


	/**
	 * This method deletes the given jobRole  
	 * @author Raghava
	 */
	public Boolean deleteJobRole(String jobRoleId) {
		return (dao.delete(JobRole.class,jobRoleId) !=0);
	}

}
