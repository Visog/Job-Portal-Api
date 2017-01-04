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
public class RegistrationAdminController {

	private static final Logger logger=Logger.getLogger(RegistrationAdminController.class);
	
	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private UserService service;
	
	/**
	 * This method creates the specialization
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/regadmin")
	public JobPortalResponse createUsers(UsersReq req) {
		
			// service.saveUsers(req);
			JobPortalResponse jobPortalResponse = new JobPortalResponse();
			if (service.saveUsers(req)) {
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
	@Path("/regadmin/{regadminId}")
	public JobPortalResponse updateusers(@PathParam("regadminId") String regadminId, UsersReq req) {
		
		// service.updateUsers(req, job_seekerId);

				JobPortalResponse jobPortalResponse = new JobPortalResponse();
				if (service.updateUsers(req, regadminId)) {
					jobPortalResponse.setMessage("Admin updated succcessfully");
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
	@Path("/regadmin")
	public JobPortalResponse getUsers(){
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getUsers());
		jobPortalResponse.setMessage("Admin  fetched succcessfully");
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
	@Path("/regadmin/{regadminId}")
	public JobPortalResponse getUsers(@PathParam("regadminId") String regadminId) {
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getUsers(regadminId));
		jobPortalResponse.setMessage("Admin data fetched succcessfully");
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
	@Path("/regadmin/{regadminId}")
	public JobPortalResponse deleteUsers(@PathParam("regadminId") String regadminId) {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.deleteUsers(regadminId)) {
			
			jobPortalResponse.setMessage("Admin deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {

			jobPortalResponse.setMessage("Failed to delete the Admin ");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}
		return jobPortalResponse;
	}
	
	
}
