package protoManager.system.exceptions.plgnColumn;

import java.util.function.Supplier;

import protoManager.system.exceptions.EntityBusinessException;
import protoManager.system.exceptions.NoContentException;


public class PlgnClmnExceptionList extends NoContentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String EXCEPTION_MESSAGE = "No Content Exception Updated";

    public PlgnClmnExceptionList() {
        super(EXCEPTION_MESSAGE);
        
    }

  /*
    public static Supplier<PlgnClmnExceptionList> newMenuCategoryCreateException3() {
    	
        return () -> new PlgnClmnExceptionList();
    }*/
}
