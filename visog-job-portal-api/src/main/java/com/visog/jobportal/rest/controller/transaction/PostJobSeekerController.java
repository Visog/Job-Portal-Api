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
import com.visog.jobportal.req.transaction.PostJobDomainsReq;
import com.visog.jobportal.req.transaction.PostJobSeekerReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.transaction.PostJobSeekerService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class PostJobSeekerController {

	private static final Logger logger = Logger.getLogger(PostJobSeekerController.class);

	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private PostJobSeekerService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/postJobSeeker")
	public JobPortalResponse createPostJobDomain(PostJobSeekerReq req) {

		service.savePostJObSeeker(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("PostJobSeeker saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}


	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/postJobSeeker/{postJobSeekerId}")
	public JobPortalResponse updatePostJobDomain(@PathParam("postJobSeekerId") String postJobSeekerId,
			PostJobSeekerReq req) {

		service.updatePostJobSeeker(req, postJobSeekerId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("postJobSeeker updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/postJobSeeker")
	public JobPortalResponse getPostJobDomains() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getPostJobSeekers());
		jobPortalResponse.setMessage("postJobSeekers fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/postJobSeeker/{postJobSeekerId}")
	public JobPortalResponse getPostJobDomain(@PathParam("postJobSeekerId") String postJobSeekerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getpostJobSeeker(postJobSeekerId));
		jobPortalResponse.setMessage("postJobSeeker fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	@DELETE
	@Path("/postJobSeeker/{postJobSeekerId}")
	public JobPortalResponse deletePostJobDomain(@PathParam("postJobSeekerId") String postJobSeekerId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deletePostJobSeeker(postJobSeekerId)) {
			jobPortalResponse.setMessage("postJobSeeker deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the postJob");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;
	}



}
