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
import com.visog.jobportal.req.master.StatusReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.StatusService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)

public class StatusController {
	private static final Logger logger = Logger.getLogger(RolesController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private StatusService service;
	
	/**
	 * This method creates the Status
	 * @author Raghava
	 * @param req
	 * @return
	 */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/status")
	public JobPortalResponse createStatus(StatusReq req) {

		service.saveStatus(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Status saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	
	/**
	 * This method updates the Status
	 * @author Raghava
	 * @param req
	 * @return
	 */
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/status/{statusId}")
	public JobPortalResponse updateRole(@PathParam("statusId") String statusId, StatusReq req) {

		service.updateStatus(req, statusId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Status updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	/**
	 * This method retrieves all Status
	 * @author Raghava
	 * @return
	 */
	
	@GET
	@Path("/status")
	public JobPortalResponse getStatus() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getStatus());
		jobPortalResponse.setMessage("Status fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves a single status
	 * @author Raghava
	 * @return
	 */

	@GET
	@Path("/status/{statusId}")
	public JobPortalResponse getRole(@PathParam("roleId") String roleId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getStatus(roleId));
		jobPortalResponse.setMessage("status fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	

	/**
	 * This method delete the role
	 * @author Raghava
	 * @return
	 */

	@DELETE
	@Path("/status/{statusId}")
	public JobPortalResponse deleteRole(@PathParam("statusId") String statusId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteStatus(statusId)) {
			jobPortalResponse.setMessage("Status deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the status");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

	
	
	
	
	
}
