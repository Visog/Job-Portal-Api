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
import com.visog.jobportal.req.transaction.LanguageKnownReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.transaction.LanguageKnownService;


@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class LanguageKnownController {
	private static final Logger logger=Logger.getLogger(LanguageKnownController.class);
	
	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private LanguageKnownService service;
	
	
	/**
	 * This method creates the LanguageKnown
	 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/lanhguageknown")
	public JobPortalResponse createLanguageKnown(LanguageKnownReq req){
		
		service.saveLanguageKnown(req);
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("LanguageKnown saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		
		return jobPortalResponse;
	}
	
	
	/**
	 * This method updates the employerjobseeker
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/lanhguageknown/{lanhguageKnownId}")
	public JobPortalResponse updateLanguageKnown(@PathParam("lanhguageKnownId") String lanhguageKnownId, LanguageKnownReq req){
		
		service.updateLanguageKnown(req, lanhguageKnownId);
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("lanhguageknown updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		
		return jobPortalResponse;
		
	}
	
	/**
	 * This method retrieves all lanhguageknown
	 * 
	 * @return
	 */
	@GET
	@Path("/lanhguageknown")
	public JobPortalResponse getLanguageKnown(){
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getLanguageKnown());
		jobPortalResponse.setMessage("lanhguageknown fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		
		return jobPortalResponse;
	}
	
	/**
	 * This method retrieves a single lanhguageknown
	 * @return
	 */
	@GET
	@Path("/lanhguageknown/{lanhguageKnownId}")
	public JobPortalResponse getLanguageKnown(@PathParam("lanhguageKnownId") String lanhguageKnownId){
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getLanguageKnown(lanhguageKnownId));
		jobPortalResponse.setMessage("lanhguageknown fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		
		return jobPortalResponse;
	}
	
	/**
	 * This method delete the specialization
	 * 
	 * @return
	 */
	@DELETE
	@Path("/lanhguageknown/{lanhguageKnownId}")
	public JobPortalResponse deleteLanguageKnown(@PathParam("lanhguageKnownId") String lanhguageKnownId){
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		
		if (service.deleteLanguageKnown(lanhguageKnownId)) {
			jobPortalResponse.setMessage("lanhguageKnown deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
			
		}else {
			jobPortalResponse.setMessage("Failed to delete the lanhguageKnown");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}
		
		return jobPortalResponse;
	}
	

}
