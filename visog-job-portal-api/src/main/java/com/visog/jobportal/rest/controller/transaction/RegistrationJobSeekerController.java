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
public class RegistrationJobSeekerController {

	private static final Logger logger = Logger.getLogger(RegistrationJobSeekerController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private UserService service;

	/**
	 * This method creates the Users
	 * 
	 * @param req
	 * @return
	 * @author mubarak
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/job_seeker")
	public JobPortalResponse createState(UsersReq req) {

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
	@Path("/job_seeker/{job_seekerId}")
	public JobPortalResponse updateState(@PathParam("job_seekerId") String job_seekerId, UsersReq req) {

		// service.updateUsers(req, job_seekerId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.updateUsers(req, job_seekerId)) {

			jobPortalResponse.setMessage("Job Seeker updated succcessfully");
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
	 * This method retrieves all JobSeeker 
	 * 
	 * @return
	 */
	@GET
	@Path("/job_seeker")
	public JobPortalResponse getRoles() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getUsers());
		jobPortalResponse.setMessage("JobSeeker  fetched succcessfully");
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
	@Path("/job_seeker/{job_seekerId}")
	public JobPortalResponse getState(@PathParam("job_seekerId") String job_seekerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getUsers(job_seekerId));
		jobPortalResponse.setMessage("State fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method delete the State
	 * 
	 * @return
	 */
	@GET
	@Path("/job_seeker/{email}/{password}")
	public JobPortalResponse getStateLogin(@PathParam("email") String email,@PathParam("password") String password) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.isUsersLoginExists(password, email)) {

			jobPortalResponse.setMessage("Login done succcessfully !!");
			jobPortalResponse.setData(service.getIds(password,email));
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		} else {

			jobPortalResponse.setMessage("Not valid credentials !!");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);

		}

		return jobPortalResponse;

	}
	
	
	
	@DELETE
	@Path("/job_seeker/{job_seekerId}")
	public JobPortalResponse deleteState(@PathParam("job_seekerId") String job_seekerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteUsers(job_seekerId)) {
			jobPortalResponse.setMessage("JobSeeker deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the JobSeeker ");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

}
