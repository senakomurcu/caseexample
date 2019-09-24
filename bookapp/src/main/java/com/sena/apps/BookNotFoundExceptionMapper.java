package com.sena.apps;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BookNotFoundExceptionMapper implements ExceptionMapper<IllegalStateException> {

    public Response toResponse(final IllegalStateException exception) {
        if ("BAD_REQUEST".equals(exception.getMessage())) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return null;
    }
    private void toR() {
		// TODO Auto-generated method stub

	}
    
}