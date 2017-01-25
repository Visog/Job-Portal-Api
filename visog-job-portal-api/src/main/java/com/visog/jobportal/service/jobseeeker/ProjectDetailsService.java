package com.visog.jobportal.service.jobseeeker;

import java.util.List;

import com.visog.jobportal.req.jobseeker.ProjectDetailsReq;
import com.visog.jobportal.res.common.ProjectDetailsRes;


public interface ProjectDetailsService {

	public void saveProjectDetails(ProjectDetailsReq req);

	public void updateProjectDetails(ProjectDetailsReq req, String projectDetailsId);

	public List<ProjectDetailsRes> getProjectDetails();
	
	public ProjectDetailsRes getProjectDetails(String id);

	public Boolean deleteProjectDetails(String projectDetailsId);

	

}