package protoManager.system.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import protoManager.system.exceptions.plgnColumn.PlgnClmnException;
import protoManager.system.exceptions.plgnColumn.PlgnClmnExceptionList;





public class MenuCategoryExceptionMapper {
	  
	   
	   @Provider
	    public static class PlgnClmnExceptionMapper extends BasicExceptionMapper implements ExceptionMapper<PlgnClmnException> {
		   @Override
	        public Response toResponse(PlgnClmnException exception) {
	            return this.buildResponse(exception.getErrorStatus(), exception);
	        }
	        
	    }
	   /*
	   @Provider
	    public static class PlgnClmnExceptionListMapper extends BasicExceptionMapper implements ExceptionMapper<PlgnClmnExceptionList> {
		   @Override
	        public Response toResponse(PlgnClmnExceptionList exception) {
	        	//EntityBusinessException
	            return this.buildResponse(exception.getErrorStatus(), exception);
	        }
	    }
*/	 
}
