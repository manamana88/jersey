package org.glassfish.jersey.jackson.internal.jackson.jaxrs.base;
import com.fasterxml.jackson.databind.JsonMappingException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

/**
 * Implementation if {@link ExceptionMapper} to send down a "400 Bad Request"
 * response in the event that unmappable JSON is received.
 *<p>
 * Note that {@link jakarta.ws.rs.ext.Provider} annotation was include up to
 * Jackson 2.7, but removed from 2.8 (as per [jaxrs-providers#22]
 *
 * @since 2.2
 */
public class JsonMappingExceptionMapper implements ExceptionMapper<JsonMappingException> {
    @Override
    public Response toResponse(JsonMappingException exception) {
        return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).type("text/plain").build();
    }
}
