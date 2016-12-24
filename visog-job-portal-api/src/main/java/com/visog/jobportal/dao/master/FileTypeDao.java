package com.visog.jobportal.dao.master;

import java.util.List;
import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.FileType;

/*
 * 
 * @author Divya Sharma
 * 
 */

public interface FileTypeDao extends AbstractDaoI {
	
	public List<FileType> getFileType();
	
}
