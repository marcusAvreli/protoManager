package protoManager.system.exceptions.plgnColumn;

import java.util.function.Supplier;

import protoManager.system.exceptions.EntityBusinessException;


public class PlgnClmnException extends EntityBusinessException {
	private static final String EXCEPTION_MESSAGE = "Application does not exist";

    public PlgnClmnException() {
        super(EXCEPTION_MESSAGE);
    }

    public static Supplier<PlgnClmnException> newMenuCategoryCreateException2() {
        return () -> new PlgnClmnException();
    }
  
}
