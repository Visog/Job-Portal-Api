package com.visog.jobportal.service.employer;

import java.util.List;

import com.visog.jobportal.req.employer.PostJobDomainsReq;
import com.visog.jobportal.res.employer.PostJobDomainsRes;




public interface PostJobDomainsService {

	public void savePostJobDomain(PostJobDomainsReq req);

	public void updatePostJob(PostJobDomainsReq req, String postJobDomainId);

	public List<PostJobDomainsRes> getpostjobDomains();

	public PostJobDomainsRes getPostJobDomain(String id);

	public Boolean deletePostJobDomain(String postJobDomainId);
}
