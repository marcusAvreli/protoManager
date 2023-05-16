package protoManager.system.exceptions.mapper;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import protoManager.rest.CoreApplication;
import protoManager.system.exceptions.generic.ErrorDTO;


public class BasicExceptionMapper {
	private static final Logger logger = LoggerFactory.getLogger(BasicExceptionMapper.class);
    public Response buildResponse(Status status, Throwable e){
    	logger.info("checkPost");
        return buildResponse(status, e.getMessage());
    }

    public Response buildResponse(Status status, String errorMessage){
    	logger.info("checkPost");
        return buildResponse(status.getStatusCode(), errorMessage);
    }

   
    private Response buildResponse(int status, String errorMessage){
    	logger.info("checkPost");
        ErrorDTO dto = buildErrorDTO(status, errorMessage);
        return Response.status(status).entity(dto).type(MediaType.APPLICATION_JSON_TYPE).build();
    }

    private ErrorDTO buildErrorDTO(int status, String errorMessage){
    	logger.info("checkPost:"+errorMessage);
    	logger.info("checkPost:"+status);
        ErrorDTO dto = new ErrorDTO();
        dto.setHttpCode(status);
        dto.setMessage(errorMessage);
        return dto;
    }

}