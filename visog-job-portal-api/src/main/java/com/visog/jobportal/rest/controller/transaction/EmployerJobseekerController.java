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
import com.visog.jobportal.req.transaction.EmployerJobseekerReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.transaction.EmployerJobseekerService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class EmployerJobseekerController {
	
	private static final Logger logger = Logger.getLogger(EmployerJobseekerController.class);
	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private EmployerJobseekerService service;
	
	/**
	 * This method creates the employerjobseeker
	 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employerjobseeker")
	public JobPortalResponse createEmployerJobseeker(EmployerJobseekerReq req){
	
		service.saveEmployerJobseeker(req);
JobPortalResponse jobPortalResponse = new JobPortalResponse();
		
		jobPortalResponse.setMessage("employerjobseeker saved succcessfully");
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
	@Path("/employerjobseeker/{employerjobseekerId}")
	public JobPortalResponse updateEmployerJobseeker(@PathParam("employerjobseekerId") String employerjobseekerId, EmployerJobseekerReq req) {
	
		service.updateEmployerJobseeker(req, employerjobseekerId);
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("employerjobseeker updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		
		return jobPortalResponse;
		
	}
	
	

	/**
	 * This method retrieves all employerjobseekers
	 * 
	 * @return
	 */
	@GET
	@Path("/employerjobseeker")
	public JobPortalResponse getemployerjobseeker() {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmployerJobseeker());
		jobPortalResponse.setMessage("employerjobseeker fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		return jobPortalResponse;
		
	}
	
	/**
	 * This method retrieves a single employerjobseeker
	 * 
	 * @return
	 */
	@GET
	@Path("/employerjobseeker/{employerjobseekerId}")
	public JobPortalResponse getEmployerJobseeker(@PathParam("employerjobseekerId") String employerjobseekerId) {
		
JobPortalResponse jobPortalResponse = new JobPortalResponse();
		
		jobPortalResponse.setData(service.getEmployerJobseeker(employerjobseekerId));
		jobPortalResponse.setMessage("employerjobseeker fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		return jobPortalResponse;
	}
	
	/**
	 * This method delete the employerjobseeker
	 * 
	 * @return
	 */
	@DELETE
	@Path("/employerjobseeker/{employerjobseekerId}")
	public JobPortalResponse deleteEmployerJobseeker(@PathParam("employerjobseekerId") String employerjobseekerId) {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if(service.deleteEmployerJobseeker(employerjobseekerId)){
			jobPortalResponse.setMessage("employerjobseeker deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
			
	
		}
		else  {
			
			jobPortalResponse.setMessage("Failed to delete he employerjobseeker");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		
		}
		return jobPortalResponse;

	}
}
