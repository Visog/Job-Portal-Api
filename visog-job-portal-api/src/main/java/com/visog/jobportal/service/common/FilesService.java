package com.visog.jobportal.service.common;

import java.util.List;

import com.visog.jobportal.req.common.FilesReq;
import com.visog.jobportal.res.transaction.FilesRes;

public interface FilesService {

	public void saveFiles(FilesReq req);

	public void updateFiles(FilesReq req, String filesId);

	public List<FilesRes> getFiles();

	public FilesRes getFiles(String id);

	public Boolean deleteFiles(String filesId);

}
