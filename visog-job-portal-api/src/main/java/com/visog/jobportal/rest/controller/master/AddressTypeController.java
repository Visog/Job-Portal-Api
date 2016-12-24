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
import com.visog.jobportal.req.master.AddressTypeReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.AddressTypeService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class AddressTypeController {

	private static final Logger logger = Logger.getLogger(RolesController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private AddressTypeService service;
	
	
	/**
	 * This method creates the AddressType
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addressType")
	public JobPortalResponse createAddressType(AddressTypeReq req) {

		service.saveAddressType(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("AddressType saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	
	/**
	 * This method updates the AddressType
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addressType/{addressTypeId}")
	public JobPortalResponse updateAddressType(@PathParam("addressTypeId") String addressTypeId, AddressTypeReq req) {

		service.updateAddressType(req, addressTypeId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("AddressType updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	
	/**
	 * This method retrieves all AddressTypes
	 * 
	 * @return
	 */
	@GET
	@Path("/addressType")
	public JobPortalResponse getAddressTypes() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getAddressTypes());
		jobPortalResponse.setMessage("AddressTypes fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	/**
	 * This method retrieves a single AddressType
	 * 
	 * @return
	 */

	@GET
	@Path("/addressType/{addressTypeId}")
	public JobPortalResponse getAddressType(@PathParam("addressTypeId") String addressTypeId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getAddressType(addressTypeId));
		jobPortalResponse.setMessage("AddressType fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	
	/**
	 * This method delete the AddressType
	 * 
	 * @return
	 */
	
	@DELETE
	@Path("/addressType/{addressTypeId}")
	public JobPortalResponse deleteAddressType(@PathParam("addressTypeId") String addressTypeId) {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if(service.deleteAddressType(addressTypeId)) {
			jobPortalResponse.setMessage("AddressType deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the role");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return jobPortalResponse;
	
	
	}

}
