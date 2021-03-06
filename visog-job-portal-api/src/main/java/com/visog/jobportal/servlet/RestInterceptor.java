package com.visog.jobportal.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.apache.log4j.Logger;

import com.visog.jobportal.constants.AppConstants;
import com.visog.jobportal.constants.Status;
import com.visog.jobportal.dao.common.UserDao;
import com.visog.jobportal.exceptions.JobPortalException;
import com.visog.jobportal.model.common.AppSession;
import com.visog.jobportal.model.common.Files;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.utils.PropertyUtil;

/**
 * This is the rest interceptor which executes around every API call
 * 
 * @author sguggilla
 *
 */
@Provider
// @ServerInterceptor
public class RestInterceptor implements ContainerRequestFilter, ContainerResponseFilter, ExceptionMapper<Throwable> {

	private static final Logger logger = Logger.getLogger(RestInterceptor.class);

	@Inject
	UserDao dao;

	/**
	 * This will execute before every call and it just logs the request details
	 */
	public void filter(ContainerRequestContext context) throws IOException {

		logger.info("Start filter(ContainerRequestContext context)");
		String url = context.getUriInfo().getPath();
		UserContext userContext = UserContextHolder.getUserContext();

		logger.info("url:::" + context.getUriInfo().getPath());

		if (!url.equals("/login/details") && !url.equals("/registration/job_seeker")
				&& !url.equals("/registration/employer") && !url.equals("/registration/admin")) {

			String sessionId = context.getHeaderString("x-session-id");

			logger.info("Start Header:::" + context.getHeaders());
			logger.info("Session:::" + context.getHeaderString("x-session-id"));
			logger.info("ContentType :::" + context.getHeaderString("Content-Type"));

			AppSession appSession = (AppSession) dao.getByKey(AppSession.class, sessionId);
			logger.info("userId:::" + appSession.getUser().getId());
		
			Users user = (Users) dao.getByKey(Users.class, appSession.getUser().getId());
			logger.info("sessionId:::" + sessionId);
			UserContextHolder.setUserContextData(user, userContext);

			

		} else {
			logger.info("Without session :::");
			UserContextHolder.setUserContextData(userContext);

		}

		logger.info("End Header:::" + context.getHeaders());

	}

	/**
	 * This will execute after the call response and it just logs the response
	 * details
	 */
	public void filter(ContainerRequestContext reqContext, ContainerResponseContext resContext) throws IOException {

		logger.info("Filtering REST Response.......................");

		resContext.getHeaders().add("Access-control-Allow-Origin", "*");
		resContext.getHeaders().add("Access-control-Allow-Credentials", "true");
		resContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
		resContext.getHeaders().add("Access-Control-Allow-Headers",
				AppConstants.SERVICE_KEY + ", " + AppConstants.AUTH_TOKEN);

	}

	/**
	 * This will execute is exception occurred for any request processing then
	 * it will be logged
	 */
	public Response toResponse(Throwable t) {
		JobPortalResponse response = new JobPortalResponse();

		JobPortalException u = null;
		if (t.getCause() instanceof JobPortalException) {
			logger.error("Cause is JobPortalException>>>>>>>>>>>>");
			u = (JobPortalException) t.getCause();
		} else if (t instanceof JobPortalException) {
			logger.error("Exception is JobPortalException>>>>>>>>>>>>");
			u = (JobPortalException) t;
		} else {
			logger.error("Exception is DirectException>>>>>>>>>>>>");
		}

		if (u != null) {

			if (u.getE() != null) {

				logger.error("UserMgmt Exception cause Exception occured in the call", u.getE());

			} else {

				logger.error("UserMgmt Exception occured in the call", u);

			}
		} else {

			logger.error("Exception occured in the call", t);

		}

		// If the user defined exception occurred
		if (u != null) {
			response.setStatusCode(Status.STATUSCODE_FAIL);
			response.setMessage(u.getErroMsg());
			response.setStatus(Status.STATUS_FAIL);
			return Response.serverError().entity(response).build();
		}

		// If Unknown and un-handled exception occurred
		response.setStatusCode(Status.STATUSCODE_ERROR);
		response.setMessage(PropertyUtil.getProperty("UNKNOWN_ERROR_MSG"));
		response.setStatus(Status.STATUS_ERROR);
		logger.info("In error reponse ending>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return Response.serverError().status(Response.Status.UNAUTHORIZED).entity(response)
				.type(MediaType.APPLICATION_JSON).build();

	}

}