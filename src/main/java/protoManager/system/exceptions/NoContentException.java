package protoManager.system.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import protoManager.system.exceptions.generic.CoffeeGenericException;

public abstract class NoContentException extends CoffeeGenericException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5696407915051550043L;
	//private final Status errorStatus = Status.BAD_REQUEST;
	 private final Response.Status errorStatus = Response.Status.NOT_FOUND;

  

	  public NoContentException(String messageTemplate, Object[] _parameters) {
	        super(messageTemplate, _parameters);
	    }

	    public NoContentException(String errorMessage){
	        super(errorMessage);
	    }

	    public Status getErrorStatus() {
	        return errorStatus;
	    }

   
}
