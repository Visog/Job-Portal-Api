package com.visog.jobportal.constants;

import java.io.Serializable;

import javax.ejb.Local;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Local
@Path("restInterceptor")
public interface RESTResourceProxy extends Serializable {

	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@Context HttpHeaders httpHeaders, @FormParam("userId") String userId,
			@FormParam("password") String password);

	@GET
	@Path("demo-get-method")
	@Produces(MediaType.APPLICATION_JSON)
	public Response restGetMethod();

	@POST
	@Path("demo-post-method")
	@Produces(MediaType.APPLICATION_JSON)
	public Response restPostMethod();

	@POST
	@Path("logout")
	public Response logout(@Context HttpHeaders httpHeaders);
}
