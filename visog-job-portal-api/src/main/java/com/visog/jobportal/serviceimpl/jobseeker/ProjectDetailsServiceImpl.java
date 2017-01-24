package com.visog.jobportal.serviceimpl.jobseeker;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.jobseeker.ProjectDetailsDao;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.model.jobseeker.ProjectDetails;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.req.common.ProjectDetailsReq;
import com.visog.jobportal.res.transaction.ProjectDetailsRes;
import com.visog.jobportal.service.jobseeeker.ProjectDetailsService;
import com.visog.jobportal.utils.DaoUtils;

/**
 * 
 * @author ShivaPrasad
 *
 */

public class ProjectDetailsServiceImpl implements ProjectDetailsService {

	private static final Logger logger = Logger.getLogger(ProjectDetailsServiceImpl.class);

	@Inject
	 private ProjectDetailsDao dao;

	public void saveProjectDetails(ProjectDetailsReq req) {

		ProjectDetails projectDetails = new ProjectDetails();

		Users users = new Users();
		users.setId(req.getUser());
		
		EmploymentType employmentType = new EmploymentType();
		employmentType.setId(req.getEmploymentType());
	
		
		projectDetails.setUser(users);		
		projectDetails.setJobResponsibilities(req.getJobResponsibilities());
		projectDetails.setProjectDetails(req.getProjectDetails());
		projectDetails.setProjectTitle(req.getProjectTitle());
		projectDetails.setEmploymentType(employmentType);
		projectDetails.setClientName(req.getClientName());
		projectDetails.setDurationFrom(req.getDurationFrom());
		projectDetails.setDurationTo(req.getDurationTo());
		projectDetails.setTeamSize(req.getTeamSize());
		projectDetails.setTechnologiesUsed(req.getTechnologiesUsed());
		

		DaoUtils.setEntityCreateAuditColumns(projectDetails);

		dao.save(projectDetails);
		logger.info("Project Details Created Successfully" + projectDetails.getId());

	}

	public void updateProjectDetails(ProjectDetailsReq req, String projectDetailsId) {

		ProjectDetails projectDetails = (ProjectDetails) dao.getByKey(ProjectDetails.class, projectDetailsId);

		Users users = new Users();
		EmploymentType employmentType = new EmploymentType();

		users.setId(req.getUser());
		projectDetails.setUser(users);
		
		employmentType.setId(req.getEmploymentType());
		projectDetails.setEmploymentType(employmentType);

		projectDetails.setJobResponsibilities(req.getJobResponsibilities());
		projectDetails.setProjectDetails(req.getProjectDetails());
		projectDetails.setProjectTitle(req.getProjectTitle());
		projectDetails.setClientName(req.getClientName());
		projectDetails.setDurationFrom(req.getDurationFrom());
		projectDetails.setDurationTo(req.getDurationTo());
		projectDetails.setTeamSize(req.getTeamSize());
		projectDetails.setTechnologiesUsed(req.getTechnologiesUsed());

		dao.update(projectDetails);
		logger.info("projectdetails updated successfully : " + projectDetails.getId());
	}

	public List<ProjectDetailsRes> getProjectDetails() {

		List<ProjectDetails> projectDetails = dao.getProjectDetails();

		List<ProjectDetailsRes> projectDetailsList = new ArrayList<>();
		
		ProjectDetailsRes projectDetailsRes = null;

		for (ProjectDetails projectDetail : projectDetails) {

			projectDetailsRes = new ProjectDetailsRes();

			projectDetailsRes.setId(projectDetail.getId());
			projectDetailsRes.setUser(projectDetail.getUser().getId());
			projectDetailsRes.setJobResponsibilities(projectDetail.getJobResponsibilities());
			projectDetailsRes.setProjectDetails(projectDetail.getProjectDetails());
			projectDetailsRes.setProjectTitle(projectDetail.getProjectTitle());
			projectDetailsRes.setClientName(projectDetail.getClientName());
			projectDetailsRes.setEmploymentType(projectDetail.getEmploymentType().getId());
			projectDetailsRes.setDurationFrom(projectDetail.getDurationFrom());
			projectDetailsRes.setDurationTo(projectDetail.getDurationTo());
			projectDetailsRes.setTeamSize(projectDetail.getTeamSize());
			projectDetailsRes.setTechnologiesUsed(projectDetail.getTechnologiesUsed());
			projectDetailsList.add(projectDetailsRes);

		}

		return projectDetailsList;
	}

	/***
	 * this gives details of given ID
	 */
	public ProjectDetailsRes getProjectDetails(String id) {

		ProjectDetails projectDetails = (ProjectDetails) dao.getByKey(ProjectDetails.class, id);
		
		ProjectDetailsRes projectDetailRes = new ProjectDetailsRes();

		projectDetailRes.setId(projectDetails.getId());
		projectDetailRes.setUser(projectDetails.getUser().getId());
		projectDetailRes.setJobResponsibilities(projectDetails.getJobResponsibilities());
		projectDetailRes.setClientName(projectDetails.getClientName());
		projectDetailRes.setProjectDetails(projectDetails.getProjectDetails());
		projectDetailRes.setProjectTitle(projectDetails.getProjectTitle());
		projectDetailRes.setEmploymentType(projectDetails.getEmploymentType().getId());
		projectDetailRes.setDurationFrom(projectDetails.getDurationFrom());
		projectDetailRes.setDurationTo(projectDetails.getDurationTo());
		projectDetailRes.setTeamSize(projectDetails.getTeamSize());
		projectDetailRes.setTechnologiesUsed(projectDetails.getTechnologiesUsed());

		return projectDetailRes;
	}

	public Boolean deleteProjectDetails(String projectDetailsId) {
		return (dao.delete(ProjectDetails.class, projectDetailsId) != 0);
	}

}
