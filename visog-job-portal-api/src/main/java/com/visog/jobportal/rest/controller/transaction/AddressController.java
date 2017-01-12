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
import com.visog.jobportal.req.transaction.AddressReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.transaction.AddressService;

@Path("/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class AddressController {
	private static final Logger logger = Logger.getLogger(AddressController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private AddressService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/address")
	public JobPortalResponse createAddress(AddressReq req) {

		service.saveAddress(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Address saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/address/<USER_ADDRESS_ID>")
	public JobPortalResponse updateAddress(@PathParam("addressId") String addressId, AddressReq req) {

		service.updateAddress(req, addressId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("adddress updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/address")
	public JobPortalResponse getAddress() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getAddress());
		jobPortalResponse.setMessage("address fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@GET
	@Path("/address/<USER_ADDRESS_ID>")
	public JobPortalResponse getAddress(@PathParam("addressId") String addressId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getAddress(addressId));
		jobPortalResponse.setMessage("address fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	@DELETE
	@Path("/address/<USER_ADDRESS_ID>")
	public JobPortalResponse deleteAddress(@PathParam("addressId") String addressId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteAddress(addressId)) {
			jobPortalResponse.setMessage("address deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the address");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

}
