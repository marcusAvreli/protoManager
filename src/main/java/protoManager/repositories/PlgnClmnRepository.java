package protoManager.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import protoManager.DataSourceProvider;
import protoManager.data.model.PlgnClmn;


public class PlgnClmnRepository {
	private static final Logger logger = LoggerFactory.getLogger(PlgnClmnRepository.class);
    Connection conn;
    public PlgnClmnRepository() {
    	try {
			conn=DataSourceProvider.getInstance().getDataSoruce().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @SuppressWarnings("unchecked")
    public List<PlgnClmn> findAll() {
    logger.info("find all started");
    	String sql = "select * from PLGN_TBL_CLMN";
    	List<PlgnClmn> customApplications = null;
    	try {
    		
    		
        	Statement statement = conn.createStatement();
			conn.setAutoCommit(false);
			logger.info("check post_1");
			ResultSet result2 = statement.executeQuery(sql);
			logger.info("check post_2");
			while(result2.next()) {
				if(null == customApplications) {
					customApplications = new ArrayList<PlgnClmn>();
				}
				logger.info("check post_3");
			    String name = ((ResultSet) result2).getString("STR_ID");
			    String displayName  = result2.getString("LBL");
			    String description = result2.getString("TYPE");
			    	String plgnLocale = "en_US";								
			    int id = result2.getInt("NDX");
			    PlgnClmn customApplication = new PlgnClmn(name,displayName,description,plgnLocale);
			    
			    customApplications.add(customApplication);
			   
			    logger.info("iteratre over result set");
			}
			 result2.close();
				statement.close();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 logger.info("find all finished");
        return customApplications;
    }
    public Optional<PlgnClmn> findById(int inId) {
    	//String sql = "select * from test_custom_application where id="+inId;
    	String sql = "select * from PLGN_TBL_CLMN where id="+inId;
    	List<PlgnClmn> customApplications = null;
    	
    		
    		
    	try {
    		
    		
        	Statement statement = conn.createStatement();
			conn.setAutoCommit(false);		
			ResultSet result2 = statement.executeQuery(sql);
			
			while(result2.next()) {
				if(null == customApplications) {
					customApplications = new ArrayList<PlgnClmn>();
				}
			    String name = ((ResultSet) result2).getString("name");
			    String displayName  = result2.getString("display_Name");
			    String description = result2.getString("description");
			    									
			    int id = result2.getInt("id");
			    PlgnClmn customApplication = new PlgnClmn(name,displayName,description,"en_US");
			    
			    customApplications.add(customApplication);
			   
			    logger.info("iteratre over result set");
			}
			 result2.close();
				statement.close();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PlgnClmn customApplication = null;
		if(null != customApplications) {
			customApplication = customApplications.get(0);
		}
		
        return  customApplication != null ? Optional.of(customApplication) : Optional.empty();
    }
}
