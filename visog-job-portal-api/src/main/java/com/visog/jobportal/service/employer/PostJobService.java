package com.visog.jobportal.service.employer;

import java.util.List;

import com.visog.jobportal.req.common.PostJobReq;
import com.visog.jobportal.res.transaction.PostJobRes;

public interface PostJobService {

	public void savePostJob(PostJobReq req);

	public void updatePostJob(PostJobReq req, String postJobId);

	public List<PostJobRes> getpostjobs();

	public PostJobRes getPostJob(String id);

	public Boolean deletePostJob(String postJobId);

}
