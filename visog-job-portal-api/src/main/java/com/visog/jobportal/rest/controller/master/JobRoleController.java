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
import com.visog.jobportal.req.master.JobRoleReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.JobRoleService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class JobRoleController {

	private static final Logger logger = Logger.getLogger(JobRoleController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private JobRoleService service;

	/**
	 * This method creates the JobRole
	 * @author Raghava
	 * @param req
	 * @return
	 */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/jobRole")
	public JobPortalResponse createRole(JobRoleReq req) {

		service.saveJobRole(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("JobRole saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	/**
	 * This method updates the JobRole
	 * @author Raghava
	 * @param req
	 * @return
	 */
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/jobRole/{jobRoleId}")
	public JobPortalResponse updateRole(@PathParam("jobRoleId") String jobRoleId, JobRoleReq req) {

		service.updateJobRole(req, jobRoleId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("JobRole updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	/**
	 * This method retrieves all Jobroles
	 * @author Raghava
	 * @return
	 */
	
	@GET
	@Path("/jobRole")
	public JobPortalResponse getRoles() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getJobRoles());
		jobPortalResponse.setMessage("JobRoles fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	/**
	 * This method retrieves a single JobRole
	 * @author Raghava
	 * @return
	 */

	@GET
	@Path("/jobRole/{jobRoleId}")
	public JobPortalResponse getRole(@PathParam("jobRoleId") String jobRoleId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getJobRole(jobRoleId));
		jobPortalResponse.setMessage("JobRole fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	/**
	 * This method delete the Jobrole
	 * @author Raghava
	 * @return
	 */

	@DELETE
	@Path("/jobRole/{jobRoleId}")
	public JobPortalResponse deleteRole(@PathParam("jobRoleId") String jobRoleId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteJobRole(jobRoleId)) {
			jobPortalResponse.setMessage("JobRole deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the Jobrole");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}


}
