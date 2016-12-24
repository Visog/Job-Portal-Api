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

		
		JobRole roles = new JobRole();
		roles.setName(req.getName());
		roles.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(roles);
		
		dao.save(roles);

		logger.info("JobRole created successfully : " + roles.getId());
	}

	/**
	 * This method updates the JobRole
	 * @author Raghava
	 */
	public void updateJobRole(JobRoleReq req, String jobRoleId) {

		JobRole roles = (JobRole) dao.getByKey(JobRole.class, jobRoleId);
		roles.setName(req.getName());
		roles.setDescription(req.getDescription());
		dao.update(roles);
		logger.info("JobRole updated successfully : " + roles.getId());
	}
	
	/**
	 * This method returns all the Jobroles
	 * @author Raghava
	 */

	public List<JobRoleRes> getJobRoles() {
		List<JobRole> roles = dao.getJobRoles();

		List<JobRoleRes> jobRolesList = new ArrayList<>();
		JobRoleRes rolesRes = null;

		for (JobRole role : roles) {
			rolesRes = new JobRoleRes();
			rolesRes.setId(role.getId());
			rolesRes.setName(role.getName());
			rolesRes.setDescription(role.getDescription());
			jobRolesList.add(rolesRes);
		}

		return jobRolesList;
	}


	/**
	 * This method returns JobRole Details for the given JobRole id  
	 * @author Raghava
	 */
	public JobRoleRes getJobRole(String id) {
		
		JobRole role = (JobRole) dao.getByKey(JobRole.class, id);
		JobRoleRes rolesRes = new JobRoleRes();
		rolesRes.setId(role.getId());
		rolesRes.setName(role.getName());
		rolesRes.setDescription(role.getDescription());
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
