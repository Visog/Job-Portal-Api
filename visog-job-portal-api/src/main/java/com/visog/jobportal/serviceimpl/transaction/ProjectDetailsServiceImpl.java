package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.dao.transaction.ProjectDetailsDao;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.model.transaction.ProjectDetails;
import com.visog.jobportal.req.transaction.ProjectDetailsReq;
import com.visog.jobportal.res.transaction.ProjectDetailsRes;
import com.visog.jobportal.service.transaction.ProjectDetailsService;
import com.visog.jobportal.utils.DaoUtils;

/**
 * 
 * @author ShivaPrasad
 *
 */

public class ProjectDetailsServiceImpl implements ProjectDetailsService {

	private static final Logger logger = Logger.getLogger(ProjectDetailsServiceImpl.class);

	@Inject
	ProjectDetailsDao dao;

	public void saveProjectDetails(ProjectDetailsReq req) {

		ProjectDetails projectDetails = new ProjectDetails();
		Users users = new Users();
		EmploymentType employmentType = new EmploymentType();

		users.setId(req.getUser());
		projectDetails.setUser(users);

		employmentType.setId(req.getEmploymentType());
		projectDetails.setEmploymenttype(employmentType);

		projectDetails.setJobresponsibilities(req.getJobResponsibilities());
		projectDetails.setProjectdetails(req.getProjectDetails());
		projectDetails.setProjecttitle(req.getProjecttitle());
		projectDetails.setClientname(req.getClientName());
		projectDetails.setDurationfrom(req.getDurationfrom());
		projectDetails.setDurationto(req.getDurationTo());
		projectDetails.setTeamsize(req.getTeamSize());
		projectDetails.setTechnologiesused(req.getTechnologiesUsed());

		DaoUtils.setEntityCreateAuditColumns(projectDetails);
		dao.save(projectDetails);
		logger.info("projectDetails created successfully : " + projectDetails.getId());

	}

	public List<ProjectDetailsRes> getProjectDetails() {

		List<ProjectDetails> projectDetails = dao.getProjectDetails();

		List<ProjectDetailsRes>  projectDetailsList = new ArrayList<>();
		ProjectDetailsRes projectDetailsRes = null;

		EmploymentType employmentType = new EmploymentType();
		Users users = new Users();
		for (ProjectDetails projectDetail :  projectDetails) {

			projectDetailsRes = new ProjectDetailsRes();

			projectDetailsRes.setId(projectDetail.getId());
			projectDetailsRes.setUser(projectDetail.getUser().getId());
			projectDetailsRes.setJobResponsibilities(projectDetail.getJobresponsibilities());
			projectDetailsRes.setProjectDetails(projectDetail.getProjectdetails());
			projectDetailsRes.setProjecttitle(projectDetail.getProjecttitle());
			projectDetailsRes.setClientName(projectDetail.getClientname());
			projectDetailsRes.setEmploymentType(projectDetail.getEmploymenttype().getId());
			projectDetailsRes.setDurationfrom(projectDetail.getDurationfrom());
			projectDetailsRes.setDurationTo(projectDetail.getDurationto());
			projectDetailsRes.setTeamSize(projectDetail.getTeamsize());
			projectDetailsRes.setTechnologiesUsed(projectDetail.getTechnologiesused());
		}

		return projectDetailsList;
	}

	public Boolean deleteProjectDetails(String id) {
		return (dao.delete(ProjectDetails.class, id) != 0);
	}

	public void updateProjectDetails(ProjectDetailsReq req, String projectDetailsId) {

		ProjectDetails projectDetails  = (ProjectDetails) dao.getByKey(ProjectDetails.class, projectDetailsId);

		EmploymentType employmenttype = new EmploymentType();
		employmenttype.setId(req.getEmploymentType());

		Users users = new Users();
		users.setId(req.getUser());

		projectDetails.setUser(users);
		projectDetails.setEmploymenttype(employmenttype);
		projectDetails.setJobresponsibilities(req.getJobResponsibilities());
		projectDetails.setProjectdetails(req.getProjectDetails());
		projectDetails.setProjecttitle(req.getProjecttitle());
		projectDetails.setClientname(req.getClientName());
		projectDetails.setDurationfrom(req.getDurationfrom());
		projectDetails.setDurationto(req.getDurationTo());projectDetails.setTeamsize(req.getTeamSize());
		projectDetails.setTechnologiesused(req.getTechnologiesUsed());

		dao.update(projectDetails);
		logger.info("projectdetails updated successfully : " + projectDetails.getId());
	}

	/***
	 * this gives details of given ID
	 */
	public ProjectDetailsRes getprojectDetails(String projectDetailsId) {
		ProjectDetails projectDetails = (ProjectDetails) dao.getByKey(ProjectDetails.class, projectDetailsId);

		ProjectDetailsRes projectDetailRes = new ProjectDetailsRes();

		projectDetailRes.setId(projectDetails.getId());
		projectDetailRes.setUser(projectDetails.getUser().getId());
		projectDetailRes.setJobResponsibilities(projectDetails.getJobresponsibilities());
		projectDetailRes.setClientName(projectDetails.getClientname());
		projectDetailRes.setProjectDetails(projectDetails.getProjectdetails());

		projectDetailRes.setProjecttitle(projectDetails.getProjecttitle());

		projectDetailRes.setEmploymentType(projectDetails.getEmploymenttype().getId());

		projectDetailRes.setDurationfrom(projectDetails.getDurationfrom());

		projectDetailRes.setDurationTo(projectDetails.getDurationto());

		projectDetailRes.setTeamSize(projectDetails.getTeamsize());

		projectDetailRes.setTechnologiesUsed(projectDetails.getTechnologiesused());

		return projectDetailRes;
	}

}
