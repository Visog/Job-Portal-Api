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

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class UsersController {
	private static Logger logger=Logger.getLogger(UsersController.class);
	
	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private UserService service;
	
	/**
	 * This method creates the Users
	 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employer")
	public JobPortalResponse createUsers(UsersReq req){
		service.saveUsers(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Users saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;
	}
	
	/**
	 * This method updates the users
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employer/{userId}")
	public JobPortalResponse updateUsers(@PathParam("userId") String userId, UsersReq req){
		
		service.updateUsers(req, userId);
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Users updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		
		return jobPortalResponse;
		
	}
	

	/**
	 * This method retrieves all users
	 * 
	 * @return
	 */
	@GET
	@Path("/employer")
	public JobPortalResponse getusers(){
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getUsers());
		jobPortalResponse.setMessage("Users fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		return jobPortalResponse;
	}
	
	/**
	 * This method retrieves a single user
	 * 
	 * @return
	 */
	@GET
	@Path("/employer/{userId}")
	public JobPortalResponse getEmployerJobseeker(@PathParam("userId") String userId) {
		
	JobPortalResponse jobPortalResponse = new JobPortalResponse();
		
		jobPortalResponse.setData(service.getUsers(userId));
		jobPortalResponse.setMessage("Users fetched succcessfully");
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
	@Path("/employer/{userId}")
	public JobPortalResponse deleteUsers(@PathParam("userId") String userId) {
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.deleteUsers(userId)) {
			jobPortalResponse.setMessage("Users deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
			
		} else {
			jobPortalResponse.setMessage("Failed to delete he Users");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);

		}
		return jobPortalResponse;
		
	}
}
