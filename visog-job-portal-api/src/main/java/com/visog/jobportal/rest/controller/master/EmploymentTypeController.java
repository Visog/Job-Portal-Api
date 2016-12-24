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
import com.visog.jobportal.req.master.EmploymentTypeReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.EmploymentTypeService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)

/*
 * 
 * @author Divya Sharma
 * 
 * */

public class EmploymentTypeController {
	

	private static final Logger logger = Logger.getLogger(EmploymentTypeController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private EmploymentTypeService service;

	/**
	 * @author Divya Sharma
	 * 
	 * This method creates the Employment Type
	 * 
	 * @param req
	 * @return
	 */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employmentType")
	public JobPortalResponse createEmploymentType(EmploymentTypeReq req) {

		service.saveEmploymentType(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Employment Type saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * @author Divya Sharma
	 * 
	 * This method updates the Employment Type
	 * 
	 * @param req
	 * @return
	 */
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employmentType/{employment_id}")
	public JobPortalResponse updateEmploymentType(@PathParam("employment_id") String employment_id, EmploymentTypeReq req) {

		service.updateEmploymentType(req, employment_id);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Employment Type updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * @author Divya Sharma
	 * 
	 * This method retrieves all Employment Type
	 * 
	 * @return
	 */
	
	@GET
	@Path("/employmentType")
	public JobPortalResponse getEmploymentTypes() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmploymentType());
		jobPortalResponse.setMessage("Employment Type fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * @author Divya Sharma
	 * This method retrieves a single Employment Type
	 * 
	 * @return
	 */

	@GET
	@Path("/employmentType/{employment_id}")
	public JobPortalResponse getEmploymentType(@PathParam("employment_id") String employment_type_id) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmploymentType(employment_type_id));
		jobPortalResponse.setMessage("Employment Type fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	/**
	 * 
	 *  @author Divya Sharma
	 * 
	 * This method delete the Employment Type
	 * 
	 * @return
	 */
	
	@DELETE
	@Path("/employmentType/{employment_id}")
	public JobPortalResponse deleteEmploymentType(@PathParam("employment_id") String employment_id) {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if(service.deleteEmploymentType(employment_id)) {
			jobPortalResponse.setMessage("Employment Type deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the Employment Type");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return jobPortalResponse;
	
	
	}

}
