package com.visog.jobportal.rest.controller.common;

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
import com.visog.jobportal.req.employer.EmployerJobSeekerReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.common.EmployerJobSeekerService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class EmployerJobSeekerController {

	private static final Logger logger = Logger.getLogger(EmployerJobSeekerController.class);
	
	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private EmployerJobSeekerService service;

	/**
	 * This method creates the employerjobseeker
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employerJobSeeker")
	public JobPortalResponse createEmployerJobSeeker(EmployerJobSeekerReq req) {

		service.saveEmployerJobSeeker(req);
		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		jobPortalResponse.setMessage("employerjobseeker saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;
	}

	/**
	 * This method updates the employerjobseeker
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employerJobSeeker/{employerJobSeekerId}")
	public JobPortalResponse updateEmployerJobseeker(@PathParam("employerJobSeekerId") String employerJobSeekerId,
			EmployerJobSeekerReq req) {

		service.updateEmployerJobSeeker(req, employerJobSeekerId);
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("employerjobseeker updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves all employerjobseekers
	 * 
	 * @return
	 */
	@GET
	@Path("/employerJobSeeker")
	public JobPortalResponse getemployerJobSeeker() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmployerJobSeeker());
		jobPortalResponse.setMessage("employerjobseeker fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		return jobPortalResponse;

	}

	/**
	 * This method retrieves a single employerjobseeker
	 * 
	 * @return
	 */
	@GET
	@Path("/employerJobSeeker/{employerJobSeekerId}")
	public JobPortalResponse getEmployerJobseeker(@PathParam("employerJobSeekerId") String employerJobSeekerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		jobPortalResponse.setData(service.getEmployerJobSeeker(employerJobSeekerId));
		jobPortalResponse.setMessage("employerjobseeker fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		return jobPortalResponse;
	}

	/**
	 * This method delete the employerjobseeker
	 * 
	 * @return
	 */
	@DELETE
	@Path("/employerJobSeeker/{employerJobSeekerId}")
	public JobPortalResponse deleteEmployerJobSeeker(@PathParam("employerJobSeekerId") String employerJobSeekerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.deleteEmployerJobSeeker(employerJobSeekerId)) {
			jobPortalResponse.setMessage("employerjobseeker deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		} else {

			jobPortalResponse.setMessage("Failed to delete he employerjobseeker");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);

		}
		return jobPortalResponse;

	}
}
