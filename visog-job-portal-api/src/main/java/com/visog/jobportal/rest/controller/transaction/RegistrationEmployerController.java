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
import com.visog.jobportal.service.transaction.RegistrationEmployerService;

@Path("/registration")
@Produces(MediaType.APPLICATION_JSON)
public class RegistrationEmployerController {

	private static final Logger logger = Logger.getLogger(RegistrationEmployerController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private RegistrationEmployerService service;

	/**
	 * This method creates the Users
	 * 
	 * @param req
	 * @return
	 * @author mubarak
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employer")
	public JobPortalResponse createState(UsersReq req) {

		// service.saveUsers(req);
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.saveEmployer(req)) {

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
	@Path("/employer/{employerId}")
	public JobPortalResponse updateState(@PathParam("employerId") String employerId, UsersReq req) {

		// service.updateUsers(req, employerId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.updateEmployer(req, employerId)) {

			jobPortalResponse.setMessage("Employer updated succcessfully");
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
	 * This method retrieves all Employer 
	 * 
	 * @return
	 */
	@GET
	@Path("/employer")
	public JobPortalResponse getRoles() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmployer());
		jobPortalResponse.setMessage("Employer  fetched succcessfully");
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
	@Path("/employer/{employerId}")
	public JobPortalResponse getState(@PathParam("employerId") String employerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmployer(employerId));
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
	
	
	
	
	@DELETE
	@Path("/employer/{employerId}")
	public JobPortalResponse deleteState(@PathParam("employerId") String employerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteEmployer(employerId)) {
			jobPortalResponse.setMessage("Employer deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the Employer ");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

}
