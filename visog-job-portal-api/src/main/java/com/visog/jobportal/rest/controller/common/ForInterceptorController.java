package com.visog.jobportal.rest.controller.common;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import com.visog.jobportal.constants.Status;
import com.visog.jobportal.req.common.FilesReq;
import com.visog.jobportal.req.common.LoginReq;
import com.visog.jobportal.res.master.JobPortalResponse;
import com.visog.jobportal.service.common.FilesService;
import com.visog.jobportal.service.common.LoginService;
import com.visog.jobportal.servlet.RestInterceptor;

@Path("/forinterceptor")
@Produces(MediaType.APPLICATION_JSON)
public class ForInterceptorController {

	private static final Logger logger = Logger.getLogger(ForInterceptorController.class);

	private @CookieParam("User-Identifier") String userIdentifier;
	
	@Inject
	private RestInterceptor restInterceptor;
	
	private ContainerRequestContext reqContext;
	
	private HttpServletResponse response;
	
	
	@Context 
	ResourceContext resourceContext;
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/details/{userId}")
	//public void createState(@HeaderParam("userId") String userId) {

	public String getDetails(@PathParam("userId") String userId){
		
		//restInterceptor.filter(context);
		 // response.getOutputHeaders().putSingle("X-Some-Header", "value");
		
		
		//restInterceptor.filter(reqContext.getHeaders().add("userId", userId));
		
		//response.addHeader("userId", userId);
	//	  requestContext.
		//resourceContext.getClass()
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		jobPortalResponse.setMessage("files updated succcessfully"+userId);
		jobPortalResponse.setStatus(Status.STATUS_SUCCESS);
		jobPortalResponse.setStatusCode(Status.STATUSCODE_SUCCESS);
		
		return userId;
		
		
		

	}

	
	   /**
     * This method describes how to access headers, cookies and context information.
     * @param headers : access all headers.
     * @param info : access all URI components
     * @param id : access a path param by name and assign it to a variable.
     * @param accept : access a http header by name.
     * @return
     */

	
	
	/*@GET
	@Path("/get")
	 public String setHeaders(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		return "";
 
		    
	}
		  
	public JobPortalResponse addUser(@Context HttpHeaders headers) {
		JobPortalResponse jobPortalResponse = new JobPortalResponse();
		String userAgent = headers.getRequestHeader("user-agent").get(0);
		
		return jobPortalResponse;

	}*/
	

	



}
