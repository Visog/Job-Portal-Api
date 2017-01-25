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
import com.visog.jobportal.req.jobseeker.ExperienceDetailsReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.jobseeeker.ExperienceDetailsService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class ExperienceDetailsController {

	private static final Logger logger = Logger.getLogger(ExperienceDetailsController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private ExperienceDetailsService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/experienceDetails")
	public JobPortalResponse createExperienceDetails(ExperienceDetailsReq req) {

		service.saveExperienceDetails(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("experienceDetails saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/experienceDetails/{experienceDetailsId}")
	public JobPortalResponse updateExperienceDetails(@PathParam("experienceDetailsId") String experienceDetailsId,
			ExperienceDetailsReq req) {

		service.updateExperienceDetails(req, experienceDetailsId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("experienceDetails updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/experienceDetails")
	public JobPortalResponse getExperienceDetails() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getExperienceDetails());
		jobPortalResponse.setMessage("experienceDetails fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/experienceDetails/{experienceDetailsId}")
	public JobPortalResponse getExperienceDetails(@PathParam("experienceDetailsId") String experienceDetailsId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getexperienceDetails(experienceDetailsId));
		jobPortalResponse.setMessage("experienceDetails fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@DELETE
	@Path("/experienceDetails/{experienceDetailsId}")
	public JobPortalResponse deleteExperienceDetails(@PathParam("experienceDetailsId") String experienceDetailsId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteExperienceDetails(experienceDetailsId)) {
			jobPortalResponse.setMessage("experienceDetails deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the experienceDetails");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;
	}

}
