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

import com.visog.jobportal.req.transaction.ProjectDetailsReq;
import com.visog.jobportal.req.transaction.UsersReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.rest.controller.transaction.ProjectDetailsController;
import com.visog.jobportal.service.transaction.ProjectDetailsService;

import com.visog.jobportal.service.transaction.UserService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class ProjectDetailsController {
	private static final Logger logger = Logger.getLogger(ProjectDetailsController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private ProjectDetailsService service;

	/**
	 * This method creates the Projectdetails
	 * 
	 * @param req
	 * @return
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/projectDetails")
	public JobPortalResponse createProjectDetails(ProjectDetailsReq req) {

		service.saveProjectDetails(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("ProjectDetails saved succcessfully");
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
	@Path("/projectDetails/{projectDetailsId}")
	public JobPortalResponse updateProjectDetails(@PathParam("projectDetailsId") String projectDetailsId,
			ProjectDetailsReq req) {

		service.updateProjectDetails(req, projectDetailsId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("ProjectDetails updated succcessfully");
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
	@Path("/projectDetails")
	public JobPortalResponse getProjectDetails() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getProjectDetails());
		jobPortalResponse.setMessage("ProjectDetails fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves a single Project
	 * 
	 * @return
	 */

	@GET
	@Path("/projectDetails/{projectDetailsId}")
	public JobPortalResponse getProjectDetails(@PathParam("projectDetailsId") String projectDetailsId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getprojectDetails(projectDetailsId));
		jobPortalResponse.setMessage("ProjectDetails fetched succcessfully");
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
	@Path("/projectDetails/{projectDetailsId}")
	public JobPortalResponse deleteProjectDetails(@PathParam("projectDetailsId") String projectDetailsId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteProjectDetails(projectDetailsId)) {
			jobPortalResponse.setMessage("ProjectDetails deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the ProjectDetails");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}
}
