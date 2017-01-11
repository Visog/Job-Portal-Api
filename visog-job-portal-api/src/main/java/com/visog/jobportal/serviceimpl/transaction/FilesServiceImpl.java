package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.resteasy.logging.Logger;

import com.visog.jobportal.dao.transaction.FilesDao;
import com.visog.jobportal.model.master.FileType;
import com.visog.jobportal.model.transaction.Files;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.FilesReq;
import com.visog.jobportal.res.transaction.FilesRes;
import com.visog.jobportal.service.transaction.FilesService;
import com.visog.jobportal.utils.DaoUtils;

public class FilesServiceImpl implements FilesService {
	private static final Logger logger = Logger.getLogger(FilesServiceImpl.class);
	
	@Inject
	FilesDao dao;

	/**
	 * This method saves the Files
	 */
	public void saveFiles(FilesReq req) {

		Files files=new Files();
		
		files.setFilepath(req.getFilepath());
		files.setAssociated(req.getAssociated());
		files.setAssociatedtype(req.getAssociatedtype());
		
		FileType fileType=new FileType();
		fileType.setId(req.getFiletype());
		files.setFiletype(fileType);
		DaoUtils.setEntityCreateAuditColumns(files);
		dao.save(files);
		logger.info(" files saved Successfully:"+ files.getId());
	}

	/**
	 * This method updates the Files
	 */
	public void updateFiles(FilesReq req, String filesId) {
		
		Files files=(Files) dao.getByKey(Files.class, filesId);
		files.setFilepath(req.getFilepath());
		files.setAssociated(req.getAssociated());
		files.setAssociatedtype(req.getAssociatedtype());
		
		FileType fileType=new FileType();
		fileType.setId(req.getFiletype());
		files.setFiletype(fileType);
		
		dao.update(files);
		logger.info(" files updated Successfully"+files.getId());
		
	}

	/**
	 * This method returns all the Files
	 */
	public List<FilesRes> getFiles() {

		List<Files> files=dao.getFiles();
		List<FilesRes> fileList=new ArrayList<>();
		FilesRes filesRes=null;
		//FileType fileType=new FileType();
		for(Files file:files){
			filesRes =new FilesRes();
			filesRes.setId(file.getId());
			filesRes.setFilepath(file.getFilepath());
			filesRes.setAssociated(file.getAssociated());
			filesRes.setAssociatedtype(file.getAssociatedtype());
			filesRes.setFiletype(file.getFiletype().getId());
			
			fileList.add(filesRes);
			
		}
		
		return fileList;
		
	}

	/**
	 * This method returns Files Details for the given File id  
	 */
	public FilesRes getFiles(String Id) {
		Files files=(Files) dao.getByKey(Files.class, Id);
		FilesRes filesRes=new FilesRes();
		filesRes.setId(files.getId());
		filesRes.setAssociated(files.getAssociated());
		filesRes.setAssociatedtype(files.getAssociatedtype());
		filesRes.setFilepath(files.getFilepath());
		filesRes.setFiletype(files.getFiletype().getId());
		return filesRes;
	}

	/**
	 * This method deletes the given Files  
	 */
	public Boolean deleteFiles(String filesId) {
		return (dao.delete(Files.class, filesId)!=0);
	}
	
	

}
