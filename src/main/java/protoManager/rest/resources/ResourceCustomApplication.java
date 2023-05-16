package protoManager.rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import protoManager.data.model.CustomApplication;
import protoManager.data.model.PlgnClmn;
import protoManager.service.PlgnClmnService;
import protoManager.service.ServiceCustomApplication;
import protoManager.system.exceptions.plgnColumn.PlgnClmnException;
import protoManager.system.exceptions.plgnColumn.PlgnClmnExceptionList;

@Path("customApplication")  
public class ResourceCustomApplication {
	//  private TStreamService streamService;
	private static final Logger logger = LoggerFactory.getLogger(ResourceCustomApplication.class);
	private ServiceCustomApplication serviceCustomApplication;
	  /**
     * @param streamService
     */
    @Inject
    public ResourceCustomApplication(ServiceCustomApplication serviceCustomApplication) {
        this.serviceCustomApplication = serviceCustomApplication;
    }

    @POST
	@Path("save")
    @Consumes (MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public CustomApplication save(CustomApplication customApplication) {  
		logger.info("START web service save");
		if(null == serviceCustomApplication) {
			logger.info("service is null");
		}
		CustomApplication tStream = serviceCustomApplication.save(customApplication);
		logger.info("FINISH web service save");
		return tStream;
	   
	}
    
    @GET 	
 	@Produces(MediaType.APPLICATION_JSON)
 	public List<CustomApplication> getAll() {  
 		logger.info("getAllClmn");
 		if(null == serviceCustomApplication) {
 			logger.info("service is null");
 		}
 	//	List<PlgnClmn> tStream = plgnClmnService.findAll();
 		//items.stream().findAny().map((e) -> items).orElseThrow(PlgnClmnExceptionList.newMenuCategoryCreateException3());

 		//List<PlgnClmn> tStream = 	 (plgnClmnService.findAll()).orElseThrow(PlgnClmnExceptionList.newMenuCategoryCreateException3());
 		List<CustomApplication> tStream = 	 serviceCustomApplication.findAll();
 		
 		if(tStream == null) {
 			throw new PlgnClmnExceptionList();
 		}
 		return tStream;
 	   
 	}
    
    @GET
  	@Path("{clmnId}")
  	@Produces(MediaType.APPLICATION_JSON)
  	public CustomApplication getById(@PathParam(value = "clmnId") int clmnId) {  
  		logger.info("getStream started");
  		if(null == serviceCustomApplication) {
  			logger.info("service is null");
  		}
  		CustomApplication customApplication = serviceCustomApplication.findById(clmnId);
  		return customApplication;
  	   
  	}
    @GET
  	@Path("delete/{clmnId}")
    @Consumes(MediaType.APPLICATION_JSON)
  	//@Produces(MediaType.APPLICATION_JSON)
	public void deleteById(@PathParam(value = "clmnId") String clmnId) {
    	logger.info("deleteById started");
    	serviceCustomApplication.deleteById(clmnId);
    }
}
