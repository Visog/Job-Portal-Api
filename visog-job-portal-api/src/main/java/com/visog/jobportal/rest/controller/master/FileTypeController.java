package com.visog.jobportal.rest.controller.master;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.visog.jobportal.constants.Status;
import com.visog.jobportal.req.master.FileTypeReq;
import com.visog.jobportal.res.master.FileTypeRes;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.FileTypeService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class FileTypeController {
	

	private static final Logger logger = Logger.getLogger(FileTypeController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private FileTypeService service;

	/*
	 * 
	 *  @author Divya Sharma
	 *  
	 * This method creates the File Type
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/fileType")
	public JobPortalResponse createFileType(FileTypeReq req) {

		service.saveFileType(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("File Type saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/*
	 * 
	 *  @author Divya Sharma
	 *  
	 * This method updates the File Type
	 * 
	 * @param req
	 * @return
	 */
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/fileType/{file_id}")
	public JobPortalResponse updateFileType(@PathParam("file_id") String file_id, FileTypeReq req) {

		service.updateFileType(req, file_id);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("FileType updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/*
	 * 
	 *  @author Divya Sharma
	 *  
	 * This method retrieves all File Type
	 * 
	 * @return
	 */
	@GET
	@Path("/fileType")
	public JobPortalResponse getFileTypes() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getFileType());
		jobPortalResponse.setMessage("FileTypes fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/*
	 * 
	 *  @author Divya Sharma
	 *  
	 * This method retrieves a single File Type
	 * 
	 * @return
	 */

	@GET
	@Path("/fileType/{file_id}")
	public JobPortalResponse getFileType(@PathParam("file_id") String file_type_id) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getFileType(file_type_id));
		jobPortalResponse.setMessage("File Type fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	/*
	 * This method delete the file Type 
	 * 
	 * @return
	 * 
	 */
	
	@DELETE
	@Path("/fileType/{file_id}")
	public JobPortalResponse deleteFileType(@PathParam("file_id") String file_id) {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if(service.deleteFileType(file_id)) {
			jobPortalResponse.setMessage("File Type deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the File Type");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return jobPortalResponse;
	
	
	}

	
}
