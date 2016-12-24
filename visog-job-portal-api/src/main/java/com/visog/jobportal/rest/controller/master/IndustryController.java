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
import com.visog.jobportal.req.master.IndustryReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.IndustryService;
@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class IndustryController {
	
	private static final Logger logger = Logger.getLogger(IndustryController.class);
	
	private @CookieParam("User-Identifier") String userIdentifier;

@Inject
private IndustryService service;

/**
 * This method creates the Industry
 * 
 * @param req
 * @return
 */
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Path("/industry")
public JobPortalResponse createIndustry(IndustryReq req) {

	service.saveIndustry(req);

	JobPortalResponse jobPortalResponse = new JobPortalResponse();
	jobPortalResponse.setMessage("Industry saved succcessfully");
	jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
	jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

	return jobPortalResponse;

}

/**
 * This method updates the Industry
 * 
 * @param req
 * @return
 */
@PUT
@Consumes(MediaType.APPLICATION_JSON)
@Path("/industry/{industryId}")
public JobPortalResponse updateIndustry(@PathParam("industryId") String industryId, IndustryReq req) {

	service.updateIndustry(req, industryId);

	JobPortalResponse jobPortalResponse = new JobPortalResponse();
	jobPortalResponse.setMessage("Industry updated succcessfully");
	jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
	jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

	return jobPortalResponse;

}

/**
 * This method retrieves all industries
 * 
 * @return
 */
@GET
@Path("/industry")
public JobPortalResponse getIndustries() {

	JobPortalResponse jobPortalResponse = new JobPortalResponse();
	jobPortalResponse.setData(service.getIndustry());
	jobPortalResponse.setMessage("Industries fetched succcessfully");
	jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
	jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

	return jobPortalResponse;

}

/**
 * This method retrieves a single Industry
 * 
 * @return
 */

@GET
@Path("/industry/{industryId}")
public JobPortalResponse getIndustry(@PathParam("industryId") String industryId) {

	JobPortalResponse jobPortalResponse = new JobPortalResponse();
	jobPortalResponse.setData(service.getIndustry(industryId));
	jobPortalResponse.setMessage("Industry fetched succcessfully");
	jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
	jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

	return jobPortalResponse;

}

/**
 * This method delete the industry
 * 
 * @return
 */

@DELETE
@Path("/industry/{industryId}")
public JobPortalResponse deleteIndustry(@PathParam("industryId") String industryId) {
	
	JobPortalResponse jobPortalResponse = new JobPortalResponse();

	if(service.deleteIndustry(industryId)) {
		jobPortalResponse.setMessage("Industry deleted succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
	} else {
		jobPortalResponse.setMessage("Failed to delete he industry");
		jobPortalResponse.setStatus(Status.STATUS_FAIL);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
	}


	return jobPortalResponse;


}
}



