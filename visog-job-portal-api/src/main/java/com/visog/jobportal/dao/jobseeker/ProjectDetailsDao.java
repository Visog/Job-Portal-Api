package com.visog.jobportal.dao.jobseeker;
import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.jobseeker.ProjectDetails;

public interface ProjectDetailsDao extends AbstractDaoI{

	public List<ProjectDetails> getProjectDetails();
		

}
