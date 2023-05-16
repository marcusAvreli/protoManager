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

import protoManager.data.model.PlgnClmn;
import protoManager.service.PlgnClmnService;
import protoManager.system.exceptions.plgnColumn.PlgnClmnException;
import protoManager.system.exceptions.plgnColumn.PlgnClmnExceptionList;

@Path("plgnClmn")  
public class PlgnClmnResource {
	//  private TStreamService streamService;
	private static final Logger logger = LoggerFactory.getLogger(PlgnClmnResource.class);
	private PlgnClmnService plgnClmnService;
	  /**
     * @param streamService
     */
    @Inject
    public PlgnClmnResource(PlgnClmnService plgnClmnService) {
        this.plgnClmnService = plgnClmnService;
    }

    @GET
	@Path("{clmnId}")
	@Produces(MediaType.APPLICATION_JSON)
	public PlgnClmn getClmnById(@PathParam(value = "clmnId") int clmnId) {  
		logger.info("getStream started");
		if(null == plgnClmnService) {
			logger.info("service is null");
		}
		PlgnClmn tStream = plgnClmnService.findById(clmnId).orElseThrow(PlgnClmnException.newMenuCategoryCreateException2());
		return tStream;
	   
	}
    
    @GET 	
 	@Produces(MediaType.APPLICATION_JSON)
 	public List<PlgnClmn> getAllClmn() {  
 		logger.info("getAllClmn");
 		if(null == plgnClmnService) {
 			logger.info("service is null");
 		}
 	//	List<PlgnClmn> tStream = plgnClmnService.findAll();
 		//items.stream().findAny().map((e) -> items).orElseThrow(PlgnClmnExceptionList.newMenuCategoryCreateException3());

 		//List<PlgnClmn> tStream = 	 (plgnClmnService.findAll()).orElseThrow(PlgnClmnExceptionList.newMenuCategoryCreateException3());
 		List<PlgnClmn> tStream = 	 plgnClmnService.findAll();
 		PlgnClmn plgnClmn = new PlgnClmn("name1", "displayName1", "description1", "en_US");
 		tStream = new ArrayList<PlgnClmn>();
 		tStream.add(plgnClmn);
 		if(tStream == null) {
 			throw new PlgnClmnExceptionList();
 		}
 		return tStream;
 	   
 	}
    
    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_JSON)
    public void putTodo(PlgnClmn todo) {
    	System.out.println("post called");
    	logger.info("post called");
    }
    @POST
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteClmn(@PathParam(value = "id") int id) {
    	
       logger.info("delete called:" + id);
    }
    
    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateClmn(PlgnClmn plgnClmn) {
    	
       logger.info("update called:" + plgnClmn);
    }
}
