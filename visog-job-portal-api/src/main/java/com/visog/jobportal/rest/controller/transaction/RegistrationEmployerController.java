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
import com.visog.jobportal.req.transaction.UsersReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.transaction.UserService;

import RegistrationEmployerDaoImpl.RegistrationEmployerService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class RegistrationEmployerController {
	private static final Logger logger=Logger.getLogger(RegistrationEmployerController.class);
	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private RegistrationEmployerService service;
	
	/**
	 * This method creates the Users
	 * 
	 * @param req
	 * @return
	 * @author Mubarak
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/regemployer")
	public JobPortalResponse createUsers(UsersReq req) {
		// service.saveUsers(req);
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.saveRegistrationEmployerDetails(req)) {
			jobPortalResponse.setMessage("Your data saved succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
			
		} else {
			jobPortalResponse.setMessage("Mail Address/Mobile Number  already exists");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);

		}
		return jobPortalResponse;
		
	}
	
	/**
	 * This method updates the Users
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/regemployer/{regemployerId}")
	public JobPortalResponse updateusers(@PathParam("regemployerId") String regemployerId, UsersReq req) {
		
		// service.updateUsers(req, job_seekerId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.updateEmployerDetails(req, regemployerId)) {
			jobPortalResponse.setMessage("employer updated succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
			
		} else {
			jobPortalResponse.setMessage("data not updated already exists");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);

		}
		return jobPortalResponse;
		
	}
	
	
	/**
	 * This method retrieves all Users 
	 * 
	 * @return
	 */
	@GET
	@Path("/regemployer")
	public JobPortalResponse getUsers(){
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmployerDetails());
		jobPortalResponse.setMessage("employer  fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;
		
	}
	
	/**
	 * This method retrieves a single Users
	 * 
	 * @return
	 */

	@GET
	@Path("/regemployer/{regemployerId}")
	public JobPortalResponse getUsers(@PathParam("regemployerId") String regemployerId) {
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmployerDetails(regemployerId));
		jobPortalResponse.setMessage("employer data fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;
		
	}
	
	/**
	 * This method delete the user
	 * 
	 * @return
	 */
	@DELETE
	@Path("/regemployer/{regemployerId}")
	public JobPortalResponse deleteUsers(@PathParam("regemployerId") String regemployerId) {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.deleteEmployerDetails(regemployerId)) {
			
			jobPortalResponse.setMessage("employer deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {

			jobPortalResponse.setMessage("Failed to delete the employer ");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}
		return jobPortalResponse;
	}

}
