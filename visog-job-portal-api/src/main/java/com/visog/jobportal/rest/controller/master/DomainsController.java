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
import com.visog.jobportal.req.master.DomainReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.DomainService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)

public class DomainController {
	private static final Logger logger = Logger.getLogger(RolesController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private DomainService service;

	/**
	 * @author Raghava
	 * This method creates the Domain
	 * 
	 * @param req
	 * @return
	 */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/domain")
	public JobPortalResponse createDomain(DomainReq req) {
		service.saveDomain(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Domain saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * @author Raghava
	 * This method updates the Domain
	 * 
	 * @param req
	 * @return
	 */
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/domain/{domainId}")
	public JobPortalResponse updateDomain(@PathParam("domainId") String domainId, DomainReq req) {

		service.updateDomain(req, domainId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Domain updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * @author Raghava
	 * This method retrieves all Domains
	 * 
	 * @return
	 */
	@GET
	@Path("/domain")
	public JobPortalResponse getDomains() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getDomains());
		jobPortalResponse.setMessage("Dpmains fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**@author Raghava
	 * This method retrieves a single Role
	 * 
	 * @return
	 */

	@GET
	@Path("/domain/{domainId}")
	public JobPortalResponse getRole(@PathParam("domainId") String domainId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getDomain(domainId));
		jobPortalResponse.setMessage("Domain fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**@author Raghava
	 * This method delete the role
	 * 
	 * @return
	 */

	@DELETE
	@Path("/domain/{domainId}")
	public JobPortalResponse deleteDomain(@PathParam("domainId") String domainId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteDomain(domainId)) {
			jobPortalResponse.setMessage("Domain deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the Domain");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

}
