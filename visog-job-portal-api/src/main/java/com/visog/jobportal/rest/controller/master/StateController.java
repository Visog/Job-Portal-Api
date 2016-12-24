/**
 * @author Divya
 */
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
import com.visog.jobportal.req.master.StateReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.StateService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class StateController {

	private static final Logger logger = Logger.getLogger(StateController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private StateService service;

	/**
	 * This method creates the State
	 * 
	 * @param req
	 * @return
	 * @author mubarak
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/state")
	public JobPortalResponse createState(StateReq req) {

		// service.saveState(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.saveState(req)) {

			jobPortalResponse.setMessage("State saved succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		} else {

			jobPortalResponse.setMessage("State data already exist");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);

		}

		return jobPortalResponse;

	}

	/**
	 * This method updates the State
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/state/{stateId}")
	public JobPortalResponse updateState(@PathParam("stateId") String stateId, StateReq req) {

		// service.updateState(req, stateId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.updateState(req, stateId)) {

			jobPortalResponse.setMessage("State updated succcessfully");
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
	 * This method retrieves all states
	 * 
	 * @return
	 */
	@GET
	@Path("/state")
	public JobPortalResponse getRoles() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getStates());
		jobPortalResponse.setMessage("States fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves a single state
	 * 
	 * @return
	 */

	@GET
	@Path("/state/{stateId}")
	public JobPortalResponse getState(@PathParam("stateId") String stateId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getState(stateId));
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
	@Path("/state/{stateId}")
	public JobPortalResponse deleteState(@PathParam("stateId") String stateId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if (service.deleteState(stateId)) {
			jobPortalResponse.setMessage("State deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete the state");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}
}
