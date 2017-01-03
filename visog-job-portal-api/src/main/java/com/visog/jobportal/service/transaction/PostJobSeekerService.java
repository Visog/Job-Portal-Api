package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.req.transaction.PostJobSeekerReq;
import com.visog.jobportal.res.transaction.JobSeekerRes;
import com.visog.jobportal.res.transaction.PostJobSeekerRes;

public interface PostJobSeekerService {

	public void savePostJObSeeker(PostJobSeekerReq req);

	public void updatePostJobSeeker(PostJobSeekerReq req, String postJobSeekerId);

	public List<PostJobSeekerRes> getPostJobSeekers();

	public PostJobSeekerRes getpostJobSeeker(String id);

	public Boolean deletePostJobSeeker(String postJobseekerId);

}
