package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.req.transaction.FilesReq;
import com.visog.jobportal.res.transaction.FilesRes;

public interface FilesService {

	public void saveFiles(FilesReq req);

	public void updateFiles(FilesReq req, String filesId);

	public List<FilesRes> getFiles();

	public FilesRes getFiles(String id);

	public Boolean deleteFiles(String filesId);

}
