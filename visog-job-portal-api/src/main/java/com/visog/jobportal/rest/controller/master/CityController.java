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
import com.visog.jobportal.req.master.CityReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.CityService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class CityController {

	private static final Logger logger = Logger.getLogger(CityController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private CityService service;

	/**
	 * This method creates the City
	 * 
	 * @param req
	 * @return
	 * @author mubarak
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/city")
	public JobPortalResponse createState(CityReq req) {

		// service.saveCity(req);
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.saveCity(req)) {

			jobPortalResponse.setMessage("City saved succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		} else {

			jobPortalResponse.setMessage("City already exists");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);

		}

		return jobPortalResponse;

	}

	/**
	 * This method updates the City
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/city/{cityId}")
	public JobPortalResponse updateState(@PathParam("cityId") String cityId, CityReq req) {

		// service.updateCity(req, cityId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.updateCity(req, cityId)) {

			jobPortalResponse.setMessage("City updated succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		} else {

			jobPortalResponse.setMessage("data not updated alrady exists");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);

		}

		return jobPortalResponse;

	}

	/**
	 * This method retrieves all Cities
	 * 
	 * @return
	 */
	@GET
	@Path("/city")
	public JobPortalResponse getRoles() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getCities());
		jobPortalResponse.setMessage("Cities fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves a single City
	 * 
	 * @return
	 */

	@GET
	@Path("/city/{cityId}")
	public JobPortalResponse getState(@PathParam("cityId") String cityId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getCity(cityId));
		jobPortalResponse.setMessage("State fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method delete the State
	 * 
	 * @return
	 */

	@DELETE
	@Path("/city/{cityId}")
	public JobPortalResponse deleteState(@PathParam("cityId") String cityId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteCity(cityId)) {
			jobPortalResponse.setMessage("City deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the City");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

}
