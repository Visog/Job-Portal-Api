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
import com.visog.jobportal.req.master.LanguagesReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.master.LanguagesService;

@Path("/master")
@Produces(MediaType.APPLICATION_JSON)
public class LanguagesController {
	
	private static final Logger logger = Logger.getLogger(LanguagesController.class);

	private @CookieParam("User-Identifier") String userIdentifier;

	@Inject
	private LanguagesService service;

	/**
	 * This method creates the Language
	 * 
	 * @param req
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/languages")
	public JobPortalResponse createLanguage(LanguagesReq req) {

		service.saveLanguage(req);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Language saved succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method updates the Language
	 * 
	 * @param req
	 * @return
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/languages/{languageId}")
	public JobPortalResponse updateLanguage(@PathParam("languageId") String languageId, LanguagesReq req) {

		service.updateLanguage(req, languageId);

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("Language updated succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves all languages
	 * 
	 * @return
	 */
	@GET
	@Path("/languages")
	public JobPortalResponse getLanguages() {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getLanguages());
		jobPortalResponse.setMessage("Languages fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}

	/**
	 * This method retrieves a single Language
	 * 
	 * @return
	 */

	@GET
	@Path("/languages/{languageId}")
	public JobPortalResponse getLanguage(@PathParam("languageId") String languageId) {

		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setData(service.getLanguage(languageId));
		jobPortalResponse.setMessage("Language fetched succcessfully");
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);

		return jobPortalResponse;

	}
	
	/**
	 * This method delete the language
	 * 
	 * @return
	 */
	
	@DELETE
	@Path("/languages/{languageId}")
	public JobPortalResponse deleteLanguage(@PathParam("languageId") String languageId) {
		
		JobPortalResponse jobPortalResponse = new JobPortalResponse();

		if(service.deleteLanguage(languageId)) {
			jobPortalResponse.setMessage("Language deleted succcessfully");
			jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		} else {
			jobPortalResponse.setMessage("Failed to delete he language");
			jobPortalResponse.setStatus(Status.STATUS_FAIL);
			jobPortalResponse.setStatusCode(Status.STATUSCODE_FAIL);
		}


		return jobPortalResponse;
	
	
	}

}
