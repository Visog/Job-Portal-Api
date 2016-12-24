package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.visog.jobportal.dao.master.FileTypeDao;
import com.visog.jobportal.model.master.FileType;
import com.visog.jobportal.req.master.FileTypeReq;
import com.visog.jobportal.res.master.FileTypeRes;
import com.visog.jobportal.service.master.FileTypeService;
import com.visog.jobportal.utils.DaoUtils;

/*
 * 
 * @author Divya Sharma
 * 
 */

public class FileTypeSeviceImpl implements FileTypeService {

	private static final Logger logger = Logger.getLogger(FileTypeSeviceImpl.class);

	@Inject
	FileTypeDao dao;

	/*
	 * @author Divya Sharma
	 * 
	 * This method saves the File Type
	 */
	
	public void saveFileType(FileTypeReq req) {
		FileType filetypes = new FileType();
		filetypes.setExtension(req.getExtension());
		filetypes.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(filetypes);
		
		dao.save(filetypes);

		logger.info("File Type created successfully : " + filetypes.getId());
	}

	/*
	 *  @author Divya Sharma
	 * 
	 * This method updates the File Type
	 * 
	 */
	
	public void updateFileType(FileTypeReq req, String filetypeId) {
		FileType filetypes = (FileType) dao.getByKey(FileType.class, filetypeId);
		filetypes.setExtension(req.getExtension());
		filetypes.setDescription(req.getDescription());
		dao.update(filetypes);
		logger.info("File Type updated successfully : " + filetypes.getId());
	}

	/*
	 *  @author Divya Sharma
	 *  
	 * This method returns all the file type
	 * 
	 */
	
	public List<FileTypeRes> getFileType() {

		List<FileType> filetypes = dao.getFileType();

		List<FileTypeRes> filetypesList = new ArrayList<>();
		FileTypeRes filetypesRes = null;

		for (FileType filetype : filetypes) {
			filetypesRes = new FileTypeRes();
			filetypesRes.setId(filetype.getId());
			filetypesRes.setExtension(filetype.getExtension());
			filetypesRes.setDescription(filetype.getDescription());
			filetypesList.add(filetypesRes);
		}

		return filetypesList;
	}

	/*
	 * 
	* @author Divya Sharma
	* 
	 * This method returns File Type Details for the given file type 
	 *  
	 */
	
	public FileTypeRes getFileType(String id) {
		FileType filetype = (FileType) dao.getByKey(FileType.class, id);
		FileTypeRes filetypesRes = new FileTypeRes();
		filetypesRes.setId(filetype.getId());
		filetypesRes.setExtension(filetype.getExtension());
		filetypesRes.setDescription(filetype.getDescription());
		return filetypesRes;
	}

	/*
	 * @author Divya Sharma
	 * 
	 * This method deletes the given File Type 
	 *  
	 */
	
	public Boolean deleteFileType(String filetypeId) {
		return (dao.delete(FileType.class, filetypeId) != 0);
		
	}

	


}
