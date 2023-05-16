package protoManager.repositories;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import protoManager.DataSourceProvider;
import protoManager.data.model.CustomApplication;
import protoManager.data.model.PlgnClmn;

//https://github.com/jjhartmann/SciMat-Tool/blob/a2ca7e4da1b1225c5c7d454f71f9cd40c67a2b27/src/scimat/model/knowledgebase/KnowledgeBaseManager.java
//https://github.com/jjhartmann/SciMat-Tool/blob/a2ca7e4da1b1225c5c7d454f71f9cd40c67a2b27/src/scimat/gui/commands/edit/add/AddAuthorGroupEdit.java#L90

//RepositoryCustomApplication CustomApplicationDAO
public class RepositoryCustomApplication {
	private static final Logger logger = LoggerFactory.getLogger(RepositoryCustomApplication.class);
    Connection conn;
   
    public RepositoryCustomApplication() {
    	try {
			conn=DataSourceProvider.getInstance().getDataSoruce().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public CustomApplication save(CustomApplication customApplication) {
    	logger.info("start RepositoryCustomApplication");
    	int id = customApplication.getId();
    	String name = customApplication.getName();
    	String displayName = customApplication.getDisplayName();
    	String description = customApplication.getDescription();
    	String sqlQuery = null;
    	try {
			conn.setAutoCommit(true);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	if(id == -1) {
    		logger.info("it must be insert");
    		String sqlQueryTemplate = "insert into custom_application (name,display_Name,description) values (''{0}'',''{1}'',''{2}'')";
            MessageFormat messageFormat = new MessageFormat(sqlQueryTemplate);
            sqlQuery = messageFormat.format(new Object[] {name, displayName, description});
    	}else {
    		BigInteger bigInt = new BigInteger(String.valueOf(id));
    		logger.info("it must be update");
    		String sqlQueryTemplate = "update custom_application set name=''{0}'',display_Name=''{1}'',description=''{2}'' where id={3}";
            MessageFormat messageFormat = new MessageFormat(sqlQueryTemplate);
            sqlQuery = messageFormat.format(new Object[] {name, displayName, description,bigInt});
    	}	
        
       // Statement statement;
        logger.info("result query:"+sqlQuery);
        umtbExecuteUpdate(sqlQuery);
      
        logger.info("finish RepositoryCustomApplication");   
        return customApplication;
    }
    
    @SuppressWarnings("unchecked")
    public List<CustomApplication> findAll() {
    logger.info("find all started");
    	String sql = "select * from custom_application";
    	List<CustomApplication> customApplications = null;
    	try {
    		
    		
        	Statement statement = conn.createStatement();
			conn.setAutoCommit(false);
			logger.info("check post_1");
			ResultSet result2 = statement.executeQuery(sql);
			logger.info("check post_2");
			while(result2.next()) {
				if(null == customApplications) {
					customApplications = new ArrayList<CustomApplication>();
				}
				logger.info("check post_3");
			    String name = ((ResultSet) result2).getString("NAME");
			    String displayName  = result2.getString("DISPLAY_NAME");
			    String description = result2.getString("DESCRIPTION");
			    	String plgnLocale = "en_US";								
			    int id = result2.getInt("ID");
			    CustomApplication customApplication = new CustomApplication(id,name,displayName,description,plgnLocale);
			    
			    customApplications.add(customApplication);
			   
			    logger.info("iteratre over result set");
			}
				 result2.close();
					statement.close();
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			 close();
		}
    	 logger.info("find all finished");
        return customApplications;
    }
    public CustomApplication findById(int id) {
    	CustomApplication customApplication = null;
    	Long idLong = new Long(String.valueOf(id));
    	BigInteger bigInt = new BigInteger(String.valueOf(id));
    	 String sqlQueryTemplate = "select * from custom_application where id={0}";
         MessageFormat messageFormat = new MessageFormat(sqlQueryTemplate);
         String sqlQuery = messageFormat.format(new Object[] {bigInt});
         try {
     		
        	 logger.info("result sql query:"+sqlQuery);
         	Statement statement = conn.createStatement();
 			conn.setAutoCommit(false);
 			logger.info("check post_1");
 			ResultSet result2 = statement.executeQuery(sqlQuery);
 			logger.info("check post_2");
 			while(result2.next()) {
 				
 				logger.info("check post_3");
 			    String name = ((ResultSet) result2).getString("NAME");
 			    String displayName  = result2.getString("DISPLAY_NAME");
 			    String description = result2.getString("DESCRIPTION");
 			    	String plgnLocale = "en_US";								
 			  
 			    customApplication = new CustomApplication(id,name,displayName,description,plgnLocale);
 			    
 			    
 			   
 			    logger.info("iteratre over result set");
 			}
 			 result2.close();
 				statement.close();
 				
     	} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
         finally {
        	 close();
         }
     	 logger.info("find all finished");
     	 return customApplication;
    }
    
   
    public void deleteById(String id) {
    	logger.info("start delete by id");
    	BigInteger bigInt = new BigInteger(String.valueOf(id));
   	 	String sqlQueryTemplate = "delete from custom_application where id={0}";
        MessageFormat messageFormat = new MessageFormat(sqlQueryTemplate);
        String sqlQuery = messageFormat.format(new Object[] {bigInt});      
        umtbExecuteUpdate(sqlQuery);
        logger.info("finish delete by id");
    }
    
    private void close() {
		try {
			conn.close();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
			logger.error("unable to close connection",e);		
		}
    }
    private void umtbExecuteUpdate(String sqlQuery) {
    	logger.info("start executing query update:"+sqlQuery);
		try(Statement statement = conn.createStatement()) {
			//use the statement in here.
			//closing a Java JDBC Statement instance using the try-with-resources construct:
			logger.info("before execute");
			statement.executeUpdate(sqlQuery);
			//statement.close();
			
			logger.info("after execute");
		} catch(SQLException e) {
			logger.error("some error:",e);
		}finally {
			 close();
		}
		logger.info("finish executing query update");
  }
   
}
