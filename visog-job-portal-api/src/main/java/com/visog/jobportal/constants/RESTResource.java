package com.visog.jobportal.constants;

import javax.ejb.Stateless;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Stateless(name = "DemoBusinessRESTResource", mappedName = "ejb/DemoBusinessRESTResource")
public class RESTResource implements RESTResourceProxy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Response login(HttpHeaders httpHeaders, String userId, String password) {
		
		return null;
	}

	public Response restGetMethod() {
		
		return null;
	}

	public Response restPostMethod() {
		
		return null;
	}

	public Response logout(HttpHeaders httpHeaders) {
		return null;
	}

}
