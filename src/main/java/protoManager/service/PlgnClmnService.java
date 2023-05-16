package protoManager.service;

import java.util.List;
import java.util.Optional;

import protoManager.data.model.PlgnClmn;


public interface PlgnClmnService {
	   Optional<PlgnClmn> findById(int uid);


	  List<PlgnClmn> findAll();
}
