package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.req.transaction.PostJobDomainsReq;
import com.visog.jobportal.res.transaction.PostJobDomainsRes;



public interface PostJobDomainsService {

	public void savePostJobDomain(PostJobDomainsReq req);

	public void updatePostJob(PostJobDomainsReq req, String postJobDomainId);

	public List<PostJobDomainsRes> getpostjobDomains();

	public PostJobDomainsRes getPostJobDomain(String id);

	public Boolean deletePostJobDomain(String postJobDomainId);
}
