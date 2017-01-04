package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.dao.transaction.ProjectDetailsDao;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.model.transaction.EmployerJobseeker;
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
	private static final Logger logger = Logger.getLogger(ProjectDetails.class);
	
	@Inject
	ProjectDetailsDao dao;

	
	public void saveProjectDetails(ProjectDetailsReq req) {
		
		ProjectDetails projectDetails =new ProjectDetails();
		Users users =new Users();
		users.setId(req.getUser());
		projectDetails.setUser(users);
		
		EmploymentType employmenttype=new EmploymentType();
		employmenttype.setId(req.getEmploymentType());
		projectDetails.setEmploymenttype(employmenttype);
		
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
		
		List<ProjectDetails> projectdetails = dao.getProjectDetails();

		List<ProjectDetailsRes> projectdetailsList = new ArrayList<>();
		ProjectDetailsRes  projectdetailsRes =null;
		
		for(ProjectDetails projectdetail :  projectdetails)
		{
			Users users =new Users();
			EmploymentType employmenttype=new EmploymentType();
			
			ProjectDetailsRes projectDetailsRes = new ProjectDetailsRes();
			
			projectdetailsRes.setId(projectdetail.getId());
			projectdetailsRes.setUser(projectdetail.getUser().getId());
			projectdetailsRes.setJobResponsibilities(projectdetail.getJobresponsibilities());
			projectdetailsRes.setProjectDetails(projectdetail.getProjectdetails());
			projectdetailsRes.setProjecttitle(projectdetail.getProjecttitle());
			projectdetailsRes.setClientName(projectdetail.getClientname());
			projectdetailsRes.setEmploymentType(projectdetail.getEmploymenttype().getId());
			projectdetailsRes.setDurationfrom(projectdetail.getDurationfrom());
			projectdetailsRes.setDurationTo(projectdetail.getDurationto());
			projectdetailsRes.setTeamSize(projectdetail.getTeamsize());
			projectdetailsRes.setTechnologiesUsed(projectdetail.getTechnologiesused());	
		}
		
		return projectdetailsList;
	}


	public Boolean deleteProjectDetails(String projectdetailsId) {
		return (dao.delete(ProjectDetails.class, projectdetailsId) != 0);
	}



	
	public void updateProjectDetails(ProjectDetailsReq req, String projectdetailsId) {

		ProjectDetails projectdetails = (ProjectDetails) dao.getByKey(ProjectDetails.class, projectdetailsId);

		EmploymentType employmenttype=new EmploymentType();
		employmenttype.setId(req.getEmploymentType());

		Users users =new Users();
		users.setId(req.getUser());
		
		projectdetails.setUser(users);
		projectdetails.setEmploymenttype(employmenttype);
		projectdetails.setJobresponsibilities(req.getJobResponsibilities());
		projectdetails.setProjectdetails(req.getProjectDetails());
		projectdetails.setProjecttitle(req.getProjecttitle());
		projectdetails.setClientname(req.getClientName());
		projectdetails.setDurationfrom(req.getDurationfrom());
		projectdetails.setDurationto(req.getDurationTo());
		projectdetails.setTeamsize(req.getTeamSize());
		projectdetails.setTechnologiesused(req.getTechnologiesUsed());	

			dao.update(projectdetails);
			logger.info("projectdetails updated successfully : " + projectdetails.getId());
	}

/***
 * this gives details of given ID
 */
	public ProjectDetailsRes getprojectDetails(String Id) {
		ProjectDetails projectDetails=(ProjectDetails) dao.getByKey(ProjectDetails.class, Id);
		
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
	