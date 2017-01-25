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
import com.visog.jobportal.req.jobseeker.EducationDetailsReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.jobseeeker.EducationDetailsService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class EducationDetailsController {

	private static final Logger logger = Logger.getLogger(EducationDetailsController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private EducationDetailsService service;

	/*
	 * Rahul
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/educationDetails")

	public JobPortalResponse createEducationDetails(EducationDetailsReq req) {

		service.saveEducationDetails(req);;

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("EducationDetails saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/educationDetails/{educationDetailsId}")

	public JobPortalResponse updateEducationDetails(@PathParam("educationDetailsId") String educationdetailsId,
			EducationDetailsReq req) {

		service.updateEducationDetails(req, educationdetailsId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("EducationDetails updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/educationDetails")
	public JobPortalResponse getEducationDetails() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEducationDetails());
		jobPortalResponse.setMessage("EducationDetails fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/educationDetails/{educationDetailsId}")
	public JobPortalResponse getEducationDetails(@PathParam("educationDetailsId") String educationdetailsId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEducationDetail(educationdetailsId));
		jobPortalResponse.setMessage("EducationDetails fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@DELETE
	@Path("/educationDetails/{educationDetailsId}")
	public JobPortalResponse deleteEducationDetails(@PathParam("educationDetailsId") String educationdetailsId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.deleteEducationDetails(educationdetailsId)) {
			jobPortalResponse.setMessage("EducationDetails deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the EducationDetails");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

}
