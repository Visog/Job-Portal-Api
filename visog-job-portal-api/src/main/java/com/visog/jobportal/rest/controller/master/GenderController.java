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
import com.visog.jobportal.req.master.GenderReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.GenderService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class GenderController {

	private static final Logger logger = Logger.getLogger(GenderController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private GenderService service;

	/**
	 * This method creates the Gender
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/gender")
	public JobPortalResponse createGender(GenderReq req) {

		service.saveGender(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Gender saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method updates the Gender
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/gender/{genderId}")
	public JobPortalResponse updateGender(@PathParam("genderId") String genderId, GenderReq req) {

		service.updateGender(req, genderId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Gender updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	/**
	 * This method retrieves all roles
	 * 
	 * @return
	 */
	@GET
	@Path("/gender")
	public JobPortalResponse getGenders() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getGenders());
		jobPortalResponse.setMessage("Gender fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	/**
	 * This method retrieves a single Role
	 * 
	 * @return
	 */

	@GET
	@Path("/gender/{genderId}")
	public JobPortalResponse getGender(@PathParam("genderId") String genderId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getGender(genderId));
		jobPortalResponse.setMessage("Gender fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	/**
	 * This method delete the role
	 * 
	 * @return
	 */

	@DELETE
	@Path("/gender/{genderId}")
	public JobPortalResponse deleteGender(@PathParam("genderId") String genderId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteGender(genderId)) {
			jobPortalResponse.setMessage("Gender deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the Gender");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;
	}
	
}
