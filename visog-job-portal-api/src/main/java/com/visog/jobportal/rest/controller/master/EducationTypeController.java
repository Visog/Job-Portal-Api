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
import com.visog.jobportal.req.master.EducationTypeReq;
import com.visog.jobportal.req.master.RolesReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.EducationTypeService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class EducationTypeController {
	private static final Logger logger = Logger.getLogger(EducationTypeController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private EducationTypeService service;

	/**
	 * This method creates the Role
	 * 
	 * @param req
	 * @return
	 */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/educationtype")
	public JobPortalResponse createEducationType(EducationTypeReq req) {

		service.saveEducationType(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Education Type saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method updates the Role
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/educationtype/{educationtypeId}")

	public JobPortalResponse updateRole(@PathParam("educationtypeId") String educationtypeId, EducationTypeReq req) {

		service.updateEducationType(req, educationtypeId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("EducationTYpe updated succcessfully");
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
	@Path("/educationtype")
	public JobPortalResponse getEducationType() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEducationTypes());
		jobPortalResponse.setMessage("Roles fetched succcessfully");
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
	@Path("/educationtype/{educationtypeId}")
	public JobPortalResponse getRole(@PathParam("educationtypeId") String educationtypeId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEducationType(educationtypeId));
		jobPortalResponse.setMessage("Education Type fetched succcessfully");
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
	@Path("/educationtype/{educationtypeId}")
	public JobPortalResponse deleteRole(@PathParam("educationtypeId") String educationtypeId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteEducationType(educationtypeId)) {
			jobPortalResponse.setMessage("educationtype deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the educationtypeId");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}
}
