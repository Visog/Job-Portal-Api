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
import com.visog.jobportal.req.transaction.ExperienceDetailsReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.transaction.ExperienceDetailsService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)

public class ExperienceDetailsController {
	
	private static final Logger logger = Logger.getLogger(ExperienceDetailsController .class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private ExperienceDetailsService service;

	/**
	 * This method creates the Experiencedetails
	 * 
	 * @param req
	 * @return
	 */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/experiencedetails")

	public JobPortalResponse createExperienceDetails(ExperienceDetailsReq req) {

		service.saveExperienceDetails(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("ExperienceDetails saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method updates the Experience Details
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/experiencedetails/{experiencedetailsId}")

	public JobPortalResponse updateExperienceDetails(@PathParam("experiencedetailsId") String experiencedetailsId, ExperienceDetailsReq req) {

		service.updateExperienceDetails(req, experiencedetailsId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("ExperienceDetails updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves all experiencedetails
	 * 
	 * @return
	 */
	@GET
	@Path("/experiencedetails")
	public JobPortalResponse getExperienceDetails() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getExperienceDetails());
		jobPortalResponse.setMessage("Roles fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves a single experience detail
	 * 
	 * @return
	 */

	@GET
	@Path("/experiencedetails/{experiencedetailsId}")
	public JobPortalResponse getExperienceDetails(@PathParam("experiencedetailsId") String experiencedetailsId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getexperienceDetails(experiencedetailsId));
		jobPortalResponse.setMessage("ExperienceDetails fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method delete the experience detail
	 * 
	 * @return
	 */

	@DELETE
	@Path("/experiencedetails/{experiencedetailsId}")
	public JobPortalResponse deleteExperienceDetails(@PathParam("experiencedetailsId") String experiencedetailsId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteExperienceDetails(experiencedetailsId)) {
			jobPortalResponse.setMessage("experiencedetails deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the experiencedetailsId");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}
}

	
	
	
	


