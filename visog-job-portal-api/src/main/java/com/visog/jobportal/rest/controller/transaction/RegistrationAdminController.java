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
import com.visog.jobportal.service.transaction.RegistrationAdminService;

@Path("/registration")
@Produces(MediaType.APPLICATION_JSON)
public class RegistrationAdminController {

	private static final Logger logger = Logger.getLogger(RegistrationAdminController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private RegistrationAdminService service;

	/**
	 * This method creates the Users
	 * 
	 * @param req
	 * @return
	 * @author mubarak
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/admin")
	public JobPortalResponse createState(UsersReq req) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.saveAdmin(req)) {

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
	@Path("/admin/{adminId}")
	public JobPortalResponse updateState(@PathParam("adminId") String adminId, UsersReq req) {


		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.updateAdmin(req, adminId)) {

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
	 * This method retrieves all Admin
	 * 
	 * @return
	 */
	@GET
	@Path("/admin")
	public JobPortalResponse getAdmin() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getAdmin());
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
	@Path("/admin/{adminId}")
	public JobPortalResponse getAdmin(@PathParam("adminId") String adminId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getAdmin(adminId));
		jobPortalResponse.setMessage("Admin fetched succcessfully");
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
	@Path("/admin/{adminId}")
	public JobPortalResponse deleteState(@PathParam("adminId") String adminId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteAdmin(adminId)) {
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