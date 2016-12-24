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
import com.visog.jobportal.req.master.CurrencyReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.CurrencyService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class CurrencyController {

	private static final Logger logger = Logger.getLogger(CurrencyController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private CurrencyService service;

	/**
	 * This method creates the Currency
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/currency")
	public JobPortalResponse createCurrency(CurrencyReq req) {

		service.saveCurrency(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Currency saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method updates the Currency
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/currency/{currencyID}")
	public JobPortalResponse updateCurrency(@PathParam("currencyID") String currencyID, CurrencyReq req) {

		service.updateCurrency(req, currencyID);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Currency updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves all currencies
	 * 
	 * @return
	 */
	@GET
	@Path("/currency")
	public JobPortalResponse getCurrencies() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getCurrency());
		jobPortalResponse.setMessage("Currencies fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves a single Currency
	 * 
	 * @return
	 */

	@GET
	@Path("/currency/{currencyID}")
	public JobPortalResponse getCurrency(@PathParam("currencyID") String currencyID) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getCurrency(currencyID));
		jobPortalResponse.setMessage("Currency fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	/**
	 * This method delete the role
	 * 
	 * @return
	 */
	
	@DELETE
	@Path("/currency/{currencyID}")
	public JobPortalResponse deleteCurrency(@PathParam("currencyID") String currencyID) {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if(service.deleteCurrency(currencyID)) {
			jobPortalResponse.setMessage("Currency deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete he role");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return jobPortalResponse;
	
	
	}
}
