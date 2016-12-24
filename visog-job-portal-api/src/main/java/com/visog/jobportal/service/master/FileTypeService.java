package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.FileTypeReq;
import com.visog.jobportal.res.master.FileTypeRes;

/*
 * 
 * @author Divya Sharma
 * 
 */

public interface FileTypeService {
	
	public void saveFileType(FileTypeReq req);
	
	public void updateFileType(FileTypeReq req, String FileTypeId);
	
	public List<FileTypeRes> getFileType();
	
	public FileTypeRes getFileType(String id);
	
	public Boolean deleteFileType(String FileTypeId);
	
}
