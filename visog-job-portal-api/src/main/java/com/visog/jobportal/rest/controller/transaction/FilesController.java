package com.visog.jobportal.rest.controller.transaction;

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
import com.visog.jobportal.req.transaction.FilesReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.transaction.FilesService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class FilesController {
	private static final Logger logger = Logger.getLogger(FilesController.class);
	
	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private FilesService service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/files")
	public JobPortalResponse createFiles(FilesReq req){
		
		service.saveFiles(req);
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("files saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		
		return jobPortalResponse;
		
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/files/{filesId}")
	public JobPortalResponse updateFiles(@PathParam("filesId") String filesId, FilesReq req) {
		
		service.updateFiles(req, filesId);
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("files updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		
		return jobPortalResponse;
		
	}
	
	@GET
	@Path("/files")
	public JobPortalResponse getFiles() {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getFiles());
		jobPortalResponse.setMessage("files fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		
		return jobPortalResponse;
	}
	
	
	@GET
	@Path("/files/{filesId}")
	public JobPortalResponse getPostJob(@PathParam("filesId") String filesId){
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getFiles(filesId));
		jobPortalResponse.setMessage("files fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		
		return jobPortalResponse;
	}
	
	@DELETE
	@Path("/files/{filesId}")
	public JobPortalResponse deleteFiles(@PathParam("filesId") String filesId){
		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteFiles(filesId)) {
			jobPortalResponse.setMessage("files deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
			
		} else {
			jobPortalResponse.setMessage("Failed to delete the files");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);

		}
		
		return jobPortalResponse;
		
	}

}
