package protoManager.service;

import java.util.List;

import protoManager.data.model.CustomApplication;
import protoManager.data.model.PlgnClmn;

//https://github.com/GIPL-Internship/Online-Exam-API/blob/47a8900dff231b1b8cfc9e4d0b5aa59f16270a58/src/main/java/com/example/theexamapi/service/TExamService.java
//Online-Exam-API/src/main/java/com/example/theexamapi/service/TExamService.java 
public interface ServiceCustomApplication {
	 CustomApplication save(CustomApplication tExam);

	    //TExam update(TExam tExam);
	 List<CustomApplication> findAll();
	 
	 CustomApplication findById(int id);
	 void deleteById(String id);
}
