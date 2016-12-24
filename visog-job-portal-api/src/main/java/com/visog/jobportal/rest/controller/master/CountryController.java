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
import com.visog.jobportal.req.master.CountryReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.CountryService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class CountryController {

	private static final Logger logger = Logger.getLogger(CountryController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private CountryService service;

	/**
	 * This method creates the country
	 * 
	 * @param req
	 * @return
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/country")
	public JobPortalResponse createRole(CountryReq req) {

		// service.saveCountry(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.saveCountry(req)) {
			jobPortalResponse.setMessage("Country saved succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Country data already exist");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

	/**
	 * This method updates the Role
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/country/{countryId}")
	public JobPortalResponse updateRole(@PathParam("countryId") String countryId, CountryReq req) {

		// service.updateCountry(req, countryId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.updateCountry(req, countryId)) {

			jobPortalResponse.setMessage("Country updated succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {

			jobPortalResponse.setMessage("data not update already exist");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

	/**
	 * This method retrieves all Countries
	 * 
	 * @return
	 */
	@GET
	@Path("/country")
	public JobPortalResponse getRoles() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getCountries());
		jobPortalResponse.setMessage("Countries fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves a single Country
	 * 
	 * @return
	 */

	@GET
	@Path("/country/{countryId}")
	public JobPortalResponse getRole(@PathParam("countryId") String countryId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getCountry(countryId));
		jobPortalResponse.setMessage("Country fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method delete the Country
	 * 
	 * @return
	 */

	@DELETE
	@Path("/country/{countryId}")
	public JobPortalResponse deleteRole(@PathParam("countryId") String countryId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteCountry(countryId)) {
			jobPortalResponse.setMessage("Country deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the country");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}
}
