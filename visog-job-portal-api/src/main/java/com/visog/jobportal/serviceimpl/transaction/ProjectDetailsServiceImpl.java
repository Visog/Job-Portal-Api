package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.dao.transaction.ProjectDetailsDao;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.model.transaction.ProjectDetails;
import com.visog.jobportal.req.transaction.ProjectDetailsReq;
import com.visog.jobportal.res.transaction.ProjectDetailsRes;
import com.visog.jobportal.service.transaction.ProjectDetailsService;


/**
 * 
 * @author ShivaPrasad
 *
 */

public class ProjectDetailsServiceImpl implements ProjectDetailsService {
	
	@Inject
	ProjectDetailsDao dao;

	
	public void saveProjectDetails(ProjectDetailsReq req) {
		
		ProjectDetails projectDetails =new ProjectDetails();
		Users users =new Users();
		users.setId(req.getUser());
		projectDetails.setUser(users);
		projectDetails.setJobresponsibilities(req.getJobResponsibilities());
		projectDetails.setProjectdetails(req.getProjectDetails());
		projectDetails.setProjecttitle(req.getProjecttitle());
		EmploymentType employmenttype=new EmploymentType();
		employmenttype.setId(req.getEmploymentType());
		projectDetails.setEmploymenttype(employmenttype);
		projectDetails.setClientname(req.getClientName());
		projectDetails.setDurationfrom(req.getDurationfrom());
		projectDetails.setDurationto(req.getDurationTo());
		projectDetails.setTeamsize(req.getTeamSize());
		projectDetails.setTechnologiesused(req.getTechnologiesUsed());	

		

	}



	public List<ProjectDetailsRes> getProjectDetails() {
		
		List<ProjectDetails> projectdetails = dao.getProjectDetails();

		List<ProjectDetailsRes> projectdetailsList = new ArrayList<>();
		ProjectDetailsRes  projectdetailsRes =null;
		
		for(ProjectDetails projectdetail :  projectdetails)
		{
			ProjectDetailsRes projectDetailsRes = new ProjectDetailsRes();
			projectdetailsRes.setId(projectdetail.getId());
			Users users =new Users();
			projectdetailsRes.setUser(projectdetail.getUser().getId());
			projectdetailsRes.setJobResponsibilities(projectdetail.getJobresponsibilities());
			projectdetailsRes.setProjectDetails(projectdetail.getProjectdetails());
			projectdetailsRes.setProjecttitle(projectdetailsRes.getProjecttitle());
			EmploymentType employmenttype=new EmploymentType();
			employmenttype.setId(projectdetailsRes.getEmploymentType());
			projectdetailsRes.setDurationfrom(projectdetail.getDurationfrom());
			projectdetailsRes.setDurationTo(projectdetailsRes.getDurationTo());
			projectdetailsRes.setTeamSize(projectdetailsRes.getTeamSize());
			projectdetailsRes.setTechnologiesUsed(projectdetailsRes.getTechnologiesUsed());	
		}
		
		return null;
	}


	public Boolean deleteProjectDetails(String projectdetailsId) {
		return (dao.delete(ProjectDetails.class, projectdetailsId) != 0);
	}



	
	public void updateProjectDetails(ProjectDetailsReq req, String projectdetailsId) {

		ProjectDetails projectdetails = (ProjectDetails) dao.getByKey(ProjectDetails.class, projectdetailsId);

		
		

		Users users =new Users();
		users.setId(req.getUser());
		projectdetails.setUser(users);
		projectdetails.setJobresponsibilities(req.getJobResponsibilities());
		projectdetails.setProjectdetails(req.getProjectDetails());
		projectdetails.setProjecttitle(req.getProjecttitle());
		EmploymentType employmenttype=new EmploymentType();
		employmenttype.setId(req.getEmploymentType());
		projectdetails.setEmploymenttype(employmenttype);
		projectdetails.setClientname(req.getClientName());
		projectdetails.setDurationfrom(req.getDurationfrom());
		projectdetails.setDurationto(req.getDurationTo());
		projectdetails.setTeamsize(req.getTeamSize());
		projectdetails.setTechnologiesused(req.getTechnologiesUsed());	

			dao.update(projectdetails);
	}

/***
 * this gives details of given ID
 */

	
	public ProjectDetailsRes getprojectDetails(String Id) {
		ProjectDetails projectDetails=(ProjectDetails) dao.getByKey(ProjectDetails.class, Id);
		
		ProjectDetailsRes projectDetailRes = new ProjectDetailsRes();
		
		projectDetailRes.setId(projectDetails.getId());
		
		projectDetailRes.setJobResponsibilities(projectDetails.getJobresponsibilities());
		
		projectDetailRes.setProjectDetails(projectDetails.getProjectdetails());
		
		projectDetailRes.setProjecttitle(projectDetailRes.getProjecttitle());
		
		projectDetailRes.setId(projectDetailRes.getEmploymentType());
		
		projectDetailRes.setDurationfrom(projectDetails.getDurationfrom());
		
		projectDetailRes.setDurationTo(projectDetailRes.getDurationTo());
		
		projectDetailRes.setTeamSize(projectDetailRes.getTeamSize());
		
		projectDetailRes.setTechnologiesUsed(projectDetailRes.getTechnologiesUsed());
		return null;
	}
		
		
}
	