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
import com.visog.jobportal.req.master.DomainsReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.DomainsService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)

public class DomainsController {
	private static final Logger logger = Logger.getLogger(RolesController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private DomainsService service;

	/**
	 * @author Raghava This method creates the Domain
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/domains")
	public JobPortalResponse createDomains(DomainsReq req) {
		service.saveDomains(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Domain saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * @author Raghava This method updates the Domain
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/domains/{domainsId}")
	public JobPortalResponse updateDomains(@PathParam("domainsId") String domainsId, DomainsReq req) {

		service.updateDomains(req, domainsId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Domain updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * @author Raghava This method retrieves all Domains
	 * 
	 * @return
	 */
	@GET
	@Path("/domains")
	public JobPortalResponse getDomains() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getDomains());
		jobPortalResponse.setMessage("Dpmains fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * @author Raghava This method retrieves a single Role
	 * 
	 * @return
	 */
	@GET
	@Path("/domains/{domainsId}")
	public JobPortalResponse getDomains(@PathParam("domainId") String domainsId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getDomains(domainsId));
		jobPortalResponse.setMessage("Domain fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

}
