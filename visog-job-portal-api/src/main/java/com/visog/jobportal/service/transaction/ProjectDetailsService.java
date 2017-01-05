package com.visog.jobportal.service.transaction;

import java.util.List;
import com.visog.jobportal.req.transaction.ProjectDetailsReq;
import com.visog.jobportal.res.transaction.ProjectDetailsRes;

public interface ProjectDetailsService {
	
	public void saveProjectDetails(ProjectDetailsReq req);

	public ProjectDetailsRes getprojectDetails(String projectDetailsId);

	public void updateProjectDetails(ProjectDetailsReq req, String projectDetailsId);

	public Boolean deleteProjectDetails(String id);

	public List<ProjectDetailsRes> getProjectDetails();

}