package com.visog.jobportal.rest.controller.employer;

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
import com.visog.jobportal.req.employer.EmployerReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.employer.EmployerService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)

public class EmployerController {

	private static final Logger logger = Logger.getLogger(EmployerController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private EmployerService service;

	/*
	 * raghava
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employer")

	public JobPortalResponse createEmployer(EmployerReq req) {

		service.saveEmployer(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Employer saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employer/{employerId}")
	public JobPortalResponse updatePostJob(@PathParam("employerId") String employerId, EmployerReq req) {

		service.updateEmployer(req, employerId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Employer updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/employer")
	public JobPortalResponse getEmployers() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmployers());
		jobPortalResponse.setMessage("Employers fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/employer/{employerId}")
	public JobPortalResponse getEmployer(@PathParam("employerId") String employerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmployer(employerId));
		jobPortalResponse.setMessage("Employer fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@DELETE
	@Path("/employer/{employerId}")
	public JobPortalResponse deleteEmployer(@PathParam("employerId") String employerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteEmployer(employerId)) {
			jobPortalResponse.setMessage("Employer deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the Employer");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

}
