package com.visog.jobportal.serviceimpl.transaction;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.PostJobDao;
import com.visog.jobportal.model.master.Currency;
import com.visog.jobportal.model.transaction.PostJob;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.PostJobReq;
import com.visog.jobportal.res.transaction.PostJobRes;
import com.visog.jobportal.service.transaction.PostJobService;

public class PostJobserviceImpl implements PostJobService {

	private static final Logger logger = Logger.getLogger(PostJobserviceImpl.class);

	@Inject
	PostJobDao dao;
	
	public void savePostJob(PostJobReq req) {
		
		Currency currency =new Currency();
		PostJob postJob =new PostJob();
		Users users =new Users();
		users.setId(req.getUser());
		
		
		
		postJob.setJobTitle(req.getJobTitle());
		postJob.setJobDescription(req.getJobDescription());
		postJob.setAnnualPackageFrom(req.getAnnualPackageFrom());
		postJob.setAnnualPackageTo(req.getAnnualPackageTo());
		currency.setId(req.getCurrency());
		postJob.setCompany(req.getCompany());
		postJob.setEffectedDateFrom(req.getEffectedDateFrom());
		
		
		
	
		
	
		
		
		
		
		
	}

	public void updatePostJob(PostJobReq req, String postJobId) {
		// TODO Auto-generated method stub

	}

	public List<PostJobRes> getpostjobs() {
		// TODO Auto-generated method stub
		return null;
	}

	public PostJobRes getPostJob(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deletePostJob(String cityId) {
		// TODO Auto-generated method stub
		return null;
	}

}
