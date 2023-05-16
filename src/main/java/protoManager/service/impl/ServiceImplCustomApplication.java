package protoManager.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import protoManager.data.model.CustomApplication;
import protoManager.repositories.RepositoryCustomApplication;
import protoManager.service.ServiceCustomApplication;

public class ServiceImplCustomApplication  implements ServiceCustomApplication {
	private static final Logger logger = LoggerFactory.getLogger(ServiceImplCustomApplication.class);
    private RepositoryCustomApplication repositoryCustomApplication;

    @Inject
    public ServiceImplCustomApplication(RepositoryCustomApplication streamRepository) {
        this.repositoryCustomApplication = streamRepository;
    }
/*
    public Optional<PlgnClmn> findById(int uid) {
        return repositoryCustomApplication.findById(uid);
    }

*/
  /*
    public List<PlgnClmn> findAll() {
        return plgnClmnRepository.findAll();
    }
*/
	@Override
	public CustomApplication save(CustomApplication tExam) {
		// TODO Auto-generated method stub
		logger.info("before save service custom application >>>>"+tExam +"<<<<<<<<<<");
		CustomApplication customApplication = repositoryCustomApplication.save(tExam);
		logger.info("after save service custom application");
		return customApplication;
	}
	@Override
	public List<CustomApplication> findAll() {
		
		List<CustomApplication> customApplications = repositoryCustomApplication.findAll();
		logger.info("after save service custom application");
		return customApplications;
	}
	@Override
	public CustomApplication findById(int id) {
		// TODO Auto-generated method stub
		CustomApplication customApplication = repositoryCustomApplication.findById(id);
		logger.info("after save service custom application");
		return customApplication;
	}
	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		repositoryCustomApplication.deleteById(id);
	}
}


