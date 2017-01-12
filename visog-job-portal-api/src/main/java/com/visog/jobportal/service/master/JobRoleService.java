package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.JobRoleReq;
import com.visog.jobportal.res.master.JobRoleRes;

public interface JobRoleService {

	public void saveJobRole(JobRoleReq req);

	public void updateJobRole(JobRoleReq req, String jobRoleId);

	public List<JobRoleRes> getJobRoles();

	public JobRoleRes getJobRole(String id);

	public Boolean deleteJobRole(String jobRoleId);
}
