package pl.edu.agh.soa.lab2.exception;

import pl.edu.agh.soa.lab2.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFoundMapper implements ExceptionMapper<DataNotFound> {

    @Override
    public Response toResponse(DataNotFound dataNotFound) {
        ErrorMessage errorMessage = new ErrorMessage(dataNotFound.getMessage(), 404);
        return Response.status(Response.Status.NOT_FOUND)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(errorMessage)
                .build();
    }
}
