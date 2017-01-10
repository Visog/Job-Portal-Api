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
import com.visog.jobportal.req.transaction.PostJobReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.transaction.PostJobService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class PostJobController {

	private static final Logger logger = Logger.getLogger(PostJobController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private PostJobService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/postJob")
	public JobPortalResponse createPostJob(PostJobReq req) {

		service.savePostJob(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("postJob saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/postJob/{postJobId}")
	public JobPortalResponse updatePostJob(@PathParam("postJobId") String postJobId, PostJobReq req) {

		service.updatePostJob(req, postJobId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("postJob updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	@GET
	@Path("/postJob")
	public JobPortalResponse getPostJobs() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getpostjobs());
		jobPortalResponse.setMessage("postJobs fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	
	@GET
	@Path("/postJob/{postJobId}")
	public JobPortalResponse getPostJob(@PathParam("postJobId") String postJobId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getPostJob(postJobId));
		jobPortalResponse.setMessage("postJob fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	
	@DELETE
	@Path("/postJob/{postJobId}")
	public JobPortalResponse deletePostJob(@PathParam("postJobId") String postJobId) {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if(service.deletePostJob(postJobId)) {
			jobPortalResponse.setMessage("postJob deleted succcessfully");
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
