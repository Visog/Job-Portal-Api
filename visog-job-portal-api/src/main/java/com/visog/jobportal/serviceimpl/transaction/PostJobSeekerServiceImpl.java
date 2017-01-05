package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.PostJobSeekerDao;
import com.visog.jobportal.model.master.Status;
import com.visog.jobportal.model.transaction.PostJob;
import com.visog.jobportal.model.transaction.PostJobSeeker;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.PostJobSeekerReq;
import com.visog.jobportal.res.transaction.PostJobSeekerRes;
import com.visog.jobportal.service.transaction.PostJobSeekerService;
import com.visog.jobportal.utils.DaoUtils;

public class PostJobSeekerServiceImpl implements PostJobSeekerService {

	private static final Logger logger = Logger.getLogger(PostJobSeekerServiceImpl.class);

	@Inject
	private PostJobSeekerDao dao;

	public void savePostJObSeeker(PostJobSeekerReq req) {

		PostJobSeeker postJobSeeker = new PostJobSeeker();
		Users users = new Users();
		PostJob postJob = new PostJob();
		Status status = new Status();

		users.setId(req.getJobSeeker());
		postJobSeeker.setJobSeeker(users);
		users.setId(req.getEmployer());
		postJobSeeker.setEmployer(users);

		postJob.setId(req.getPostJob());
		postJobSeeker.setPostJob(postJob);

		status.setId(req.getStatus());
		postJobSeeker.setStatus(status);

		DaoUtils.setEntityCreateAuditColumns(postJobSeeker);
		dao.save(postJobSeeker);
		logger.info("PostJobseeker is created Successfully" + postJobSeeker.getId());

	}

	public void updatePostJobSeeker(PostJobSeekerReq req, String postJobSeekerId) {

		PostJobSeeker postJobSeeker = (PostJobSeeker) dao.getByKey(PostJobSeeker.class, postJobSeekerId);

		Users users = new Users();
		PostJob postJob = new PostJob();
		Status status = new Status();

		users.setId(req.getJobSeeker());
		postJobSeeker.setJobSeeker(users);
		users.setId(req.getEmployer());
		postJobSeeker.setEmployer(users);

		postJob.setId(req.getPostJob());
		postJobSeeker.setPostJob(postJob);

		status.setId(req.getStatus());
		postJobSeeker.setStatus(status);
		
		dao.update(postJobSeeker);
		logger.info("JobSeeker Updated Successfully" + postJobSeeker.getId());
	}

	public List<PostJobSeekerRes> getPostJobSeekers() {

		List<PostJobSeeker> postJobSeeker = dao.getPostJobSeeker();

		List<PostJobSeekerRes> postJobSeekkerList = new ArrayList<>();

		PostJobSeekerRes postJobSeekerRes = null;

		for (PostJobSeeker postJobSeekers : postJobSeeker) {

			postJobSeekerRes = new PostJobSeekerRes();

			postJobSeekerRes.setId(postJobSeekers.getId());

			postJobSeekerRes.setJobSeeker(postJobSeekers.getJobSeeker().getId());
			postJobSeekerRes.setEmployer(postJobSeekers.getEmployer().getId());
			postJobSeekerRes.setPostJob(postJobSeekers.getPostJob().getId());
			postJobSeekerRes.setStatus(postJobSeekers.getStatus().getId());

			postJobSeekkerList.add(postJobSeekerRes);

		}

		return postJobSeekkerList;
	}

	public PostJobSeekerRes getpostJobSeeker(String id) {
		
		PostJobSeeker postJobSeeker = (PostJobSeeker) dao.getByKey(PostJobSeeker.class,id );
		
		PostJobSeekerRes postJobSeekerRes =new PostJobSeekerRes();
		
		postJobSeekerRes.setId(postJobSeeker.getId());
		
		postJobSeekerRes.setJobSeeker(postJobSeeker.getJobSeeker().getId());
		
		postJobSeekerRes.setEmployer(postJobSeeker.getEmployer().getId());
		postJobSeekerRes.setPostJob(postJobSeeker.getPostJob().getId());
		
		postJobSeekerRes.setStatus(postJobSeeker.getStatus().getId());

		return postJobSeekerRes;
	}

	public Boolean deletePostJobSeeker(String postJobSeekerId) {

		return (dao.delete(PostJobSeeker.class, postJobSeekerId) !=0);
	}

}
