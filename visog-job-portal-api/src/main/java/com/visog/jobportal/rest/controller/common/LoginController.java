package com.visog.jobportal.rest.controller.common;

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
import com.visog.jobportal.req.common.LoginReq;
import com.visog.jobportal.req.jobseeker.JobSeekerReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.common.LoginService;
import com.visog.jobportal.servlet.RestInterceptor;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private LoginService service;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/details")
	public JobPortalResponse login(LoginReq req) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		if (service.isUsersLoginExists(req.getPassword(), req.getEmail())) {
			jobPortalResponse.setData(service.getDetails(req.getEmail()));
			jobPortalResponse.setMessage("Login succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to login!!!");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}

		return jobPortalResponse;

	}

}
