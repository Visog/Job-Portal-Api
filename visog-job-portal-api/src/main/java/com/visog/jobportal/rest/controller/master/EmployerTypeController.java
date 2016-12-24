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
import com.visog.jobportal.req.master.EmployerTypeReq;
import com.visog.jobportal.res.master.EmployerTypeRes;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.EmployerTypeService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)


/*
*
*  @author: Divya Sharma 
*
*/


public class EmployerTypeController {
	

	private static final Logger logger = Logger.getLogger(EmployerTypeController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private EmployerTypeService service;

	/*
	 *  @author: Divya Sharma 
	 *  
	 * This method creates the Employer Type
	 * 
	 * @param req
	 * @return
	 */
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employerType")
	public JobPortalResponse createEmployerType(EmployerTypeReq req) {

		service.saveEmployerType(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Employer Type saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/*
	 *  @author: Divya Sharma 
	 *  
	 * This method updates the EmployerType
	 * 
	 * @param req
	 * @return
	 */
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/employerType/{employer_Id}")
	public JobPortalResponse updateEmployerType(@PathParam("employer_Id") String employer_Id, EmployerTypeReq req) {

		service.updateEmployerType(req, employer_Id);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Employer Type updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/*
	 *  @author: Divya Sharma 
	 *  
	 * This method retrieves all employer_type
	 * 
	 * @return
	 */
	
	@GET
	@Path("/employerType")
	public JobPortalResponse getEmployerTypes() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmployerType());
		jobPortalResponse.setMessage("Employer Type fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/*
	 *  @author: Divya Sharma 
	 *  
	 * This method retrieves a single Employer Type
	 * 
	 * @return
	 */

	@GET
	@Path("/employerType/{employer_Id}")
	public JobPortalResponse getEmployerType(@PathParam("employer_Id") String employer_type_id) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getEmployerType(employer_type_id));
		jobPortalResponse.setMessage("Employer Type fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	/*
	 *  @author: Divya Sharma 
	 *  
	 * This method delete the employer_type_id
	 * 
	 * @return
	 */
	
	@DELETE
	@Path("/employerType/{employer_Id}")
	public JobPortalResponse deleteEmployerType(@PathParam("employer_Id") String employer_Id) {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if(service.deleteEmployerType(employer_Id)) {
			jobPortalResponse.setMessage("Employer Type deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the Employer Type");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return jobPortalResponse;
	
	
	}

}
