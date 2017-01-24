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
import com.visog.jobportal.req.common.PostJobDomainsReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.employer.PostJobDomainsService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class PostJobDomainsController {

	private static final Logger logger = Logger.getLogger(PostJobDomainsController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private PostJobDomainsService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/postJobDomains")
	public JobPortalResponse createPostJobDomain(PostJobDomainsReq req) {

		service.savePostJobDomain(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("postJobDomain saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/postJobDomains/{postJobDomainId}")
	public JobPortalResponse updatePostJobDomain(@PathParam("postJobDomainId") String postJobDomainId,
			PostJobDomainsReq req) {

		service.updatePostJob(req, postJobDomainId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("postJobDomain updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/postJobDomains")
	public JobPortalResponse getPostJobDomains() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getpostjobDomains());
		jobPortalResponse.setMessage("postJobDomains fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/postJobDomains/{postJobDomainId}")
	public JobPortalResponse getPostJobDomain(@PathParam("postJobDomainId") String postJobDomainId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getPostJobDomain(postJobDomainId));
		jobPortalResponse.setMessage("postJobDomain fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@DELETE
	@Path("/postJobDomains/{postJobDomainId}")
	public JobPortalResponse deletePostJobDomain(@PathParam("postJobDomainId") String postJobDomainId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deletePostJobDomain(postJobDomainId)) {
			jobPortalResponse.setMessage("postJobDomain deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the postJobDomain");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;
	}

}
