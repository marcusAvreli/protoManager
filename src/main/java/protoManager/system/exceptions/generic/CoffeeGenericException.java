package protoManager.system.exceptions.generic;

@SuppressWarnings("serial")
//https://github.com/632691987/coffee/tree/0f0539e48f3b1f98491d8269d55731cad61347c6/src/main/java/tina/coffee/system
//coffee/src/main/java/tina/coffee/system/


//https://github.com/632691987/coffee/blob/0f0539e48f3b1f98491d8269d55731cad61347c6/src/main/java/tina/coffee/system/exceptions/generic/CoffeeGenericException.java
//coffee/src/main/java/tina/coffee/system/exceptions/generic/CoffeeGenericException.java
public class CoffeeGenericException extends RuntimeException{

    private String messageTemplate;

    private Object[] parameters;

    public CoffeeGenericException(String messageTemplate, Object[] _parameters){
        this.messageTemplate = messageTemplate;
        this.parameters = _parameters;
    }

    public CoffeeGenericException(){
        super();
    }

    public CoffeeGenericException(String message){
        super(message);
    }

    public CoffeeGenericException(Throwable cause){
        super(cause);
    }

    public CoffeeGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessageTemplate() {
        return messageTemplate;
    }

    public Object[] getParameters() {
        return parameters;
    }
}