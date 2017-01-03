package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.PostJobSeeker;

public interface PostJobSeekerDao extends AbstractDaoI {

	public List<PostJobSeeker> getPostJobSeeker();
}
