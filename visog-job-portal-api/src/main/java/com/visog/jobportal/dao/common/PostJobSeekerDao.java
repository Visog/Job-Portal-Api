package com.visog.jobportal.dao.common;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.common.PostJobSeeker;

public interface PostJobSeekerDao extends AbstractDaoI {

	public List<PostJobSeeker> getPostJobSeeker();
}
