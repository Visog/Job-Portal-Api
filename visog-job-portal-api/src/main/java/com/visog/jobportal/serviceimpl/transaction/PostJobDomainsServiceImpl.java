package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.PostJobDomainsDao;
import com.visog.jobportal.model.master.Domains;
import com.visog.jobportal.model.transaction.PostJob;
import com.visog.jobportal.model.transaction.PostJobDomains;
import com.visog.jobportal.req.transaction.PostJobDomainsReq;
import com.visog.jobportal.res.transaction.PostJobDomainsRes;
import com.visog.jobportal.service.transaction.PostJobDomainsService;
import com.visog.jobportal.utils.DaoUtils;

public class PostJobDomainsServiceImpl implements PostJobDomainsService {

	private static final Logger logger = Logger.getLogger(PostJobDomainsServiceImpl.class);

	@Inject
	private PostJobDomainsDao dao;

	public void savePostJobDomain(PostJobDomainsReq req) {
		
		PostJobDomains postJobDomains = new PostJobDomains();
		PostJob postJob = new PostJob();
		Domains domains = new Domains();
		postJob.setId(req.getPostJob());
		postJobDomains.setPostJob(postJob);
		domains.setId(req.getDomain());
		postJobDomains.setDomain(domains);

		DaoUtils.setEntityCreateAuditColumns(postJobDomains);
		dao.save(postJobDomains);
		logger.info("PostJobDomains Created successfully " + postJobDomains.getId());

	}

	public void updatePostJob(PostJobDomainsReq req, String postJobDomainId) {

		PostJobDomains postJobDomains = (PostJobDomains) dao.getByKey(PostJobDomains.class, postJobDomainId);

		PostJob postJob = new PostJob();
		postJobDomains.setPostJob(postJob);
		Domains domains = new Domains();

		postJob.setId(req.getPostJob());
		domains.setId(req.getDomain());
		postJobDomains.setDomain(domains);

		dao.update(postJobDomains);
		logger.info("PostJobDomains updated Successfully" + postJobDomains.getId());

	}

	public List<PostJobDomainsRes> getpostjobDomains() {

		List<PostJobDomains> postJobDomains = dao.getPostJobDomains();

		List<PostJobDomainsRes> postJobDomainsList = new ArrayList<>();

		PostJobDomainsRes postJobDomainsRes = null;

		PostJob postJob = new PostJob();
		Domains domains = new Domains();

		for (PostJobDomains postJobDomain : postJobDomains) {

			postJobDomainsRes = new PostJobDomainsRes();

			postJobDomainsRes.setId(postJobDomain.getId());

			postJobDomainsRes.setPostJob(postJobDomain.getPostJob().getId());

			postJobDomainsRes.setDomain(postJobDomain.getDomain().getId());

			postJobDomainsList.add(postJobDomainsRes);

		}

		return postJobDomainsList;
	}

	public PostJobDomainsRes getPostJobDomain(String id) {

		PostJobDomains postJobDomains = (PostJobDomains) dao.getByKey(PostJobDomains.class, id);

		PostJobDomainsRes postJobDomainsRes = new PostJobDomainsRes();

		postJobDomainsRes.setId(postJobDomains.getId());

		postJobDomainsRes.setPostJob(postJobDomains.getPostJob().getId());

		postJobDomainsRes.setDomain(postJobDomains.getDomain().getId());

		return postJobDomainsRes;
	}

	public Boolean deletePostJobDomain(String postJobDomainId) {

		return (dao.delete(PostJobDomains.class, postJobDomainId) != 0);
	}

}
