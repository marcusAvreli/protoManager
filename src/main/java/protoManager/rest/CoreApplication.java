package protoManager.rest;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import protoManager.repositories.PlgnClmnRepository;
import protoManager.repositories.RepositoryCustomApplication;
import protoManager.rest.filter.CORSFilter;


import protoManager.rest.resources.PlgnClmnResource;
import protoManager.rest.resources.ResourceCustomApplication;
import protoManager.service.PlgnClmnService;
import protoManager.service.ServiceCustomApplication;
import protoManager.service.impl.PlgnClmnServiceImpl;
import protoManager.service.impl.ServiceImplCustomApplication;






//The Java class will be hosted at the URI path "/helloworld"
//https://github.com/GIPL-Internship/Online-Exam-API/blob/47a8900dff231b1b8cfc9e4d0b5aa59f16270a58/src/main/java/com/example/theexamapi/config/AppConfig.java
//exception handaling taken from 
//https://github.com/632691987/coffee
//resource binding taken from
//Online-Exam-API/src/main/java/com/example/theexamapi/config/AppConfig.java
//Online-Exam-API/src/main/java/com/example/theexamapi/service/impl/TStreamServiceImpl.java
public class CoreApplication extends ResourceConfig {
	private static final Logger logger = LoggerFactory.getLogger(CoreApplication.class);
    /** Maximum timeout seconds. */
    private static final long TIMEOUT_SECONDS = 50;

    /**
     * Start Application.
     */
    public CoreApplication() {
    	   registerResources();

           // Now you can expect validation errors to be sent to the
           // client.
       //    property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }
   
    public void registerResources() {
        register(CORSFilter.class);
     //   register(JerseyResource.class);
    
        register(PlgnClmnResource.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(PlgnClmnServiceImpl.class).to(PlgnClmnService.class);
                bind(PlgnClmnRepository.class).to(PlgnClmnRepository.class);
            }
        });
        register(ResourceCustomApplication.class);
        register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(ServiceImplCustomApplication.class).to(ServiceCustomApplication.class);
                bind(RepositoryCustomApplication.class).to(RepositoryCustomApplication.class);
            }
        });
    }
 

}