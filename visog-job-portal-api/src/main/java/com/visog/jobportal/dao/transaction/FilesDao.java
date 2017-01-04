package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.Files;

public interface FilesDao extends AbstractDaoI{
	
	public List<Files> getFiles();
	
	

}
