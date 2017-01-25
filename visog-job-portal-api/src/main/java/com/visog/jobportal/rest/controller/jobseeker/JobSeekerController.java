package com.visog.jobportal.rest.controller.jobseeker;

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
import com.visog.jobportal.req.jobseeker.JobSeekerReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.jobseeeker.JobSeekerService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class JobSeekerController {

	private static final Logger logger = Logger.getLogger(JobSeekerController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private JobSeekerService service;

	/*
	 * raghava
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/jobseeker")

	public JobPortalResponse createJobSeeker(JobSeekerReq req) {

		service.saveJObSeeker(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Job Seeker saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/jobseeker/{jobseekerId}")
	public JobPortalResponse updatePostJob(@PathParam("jobseekerId") String jobseekerId, JobSeekerReq req) {

		service.updateJobSeeker(req, jobseekerId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("JobSeeker updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/jobseeker")
	public JobPortalResponse getJobSeekers() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getJobSeekers());
		jobPortalResponse.setMessage("Job Seekers fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/jobseeker/{jobseekerId}")
	public JobPortalResponse getPostJob(@PathParam("jobseekerId") String jobseekerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getJobSeeker(jobseekerId));
		jobPortalResponse.setMessage("job seeker fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@DELETE
	@Path("/jobseeker/{jobseekerId}")
	public JobPortalResponse deletePostJob(@PathParam("jobseekerId") String jobseekerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteJobSeeker(jobseekerId)) {
			jobPortalResponse.setMessage("Job Seeker deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {  
			jobPortalResponse.setMessage("Failed to delete the jobseeker");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

}
