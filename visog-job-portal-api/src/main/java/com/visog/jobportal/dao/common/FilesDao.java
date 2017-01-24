package com.visog.jobportal.dao.common;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.common.Files;

public interface FilesDao extends AbstractDaoI{
	
	public List<Files> getFiles();
	

}
