package protoManager.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import protoManager.data.model.PlgnClmn;
import protoManager.repositories.PlgnClmnRepository;
import protoManager.service.PlgnClmnService;


public class PlgnClmnServiceImpl  implements PlgnClmnService {
    private PlgnClmnRepository plgnClmnRepository;

    @Inject
    public PlgnClmnServiceImpl(PlgnClmnRepository streamRepository) {
        this.plgnClmnRepository = streamRepository;
    }

    public Optional<PlgnClmn> findById(int uid) {
        return plgnClmnRepository.findById(uid);
    }


  
    public List<PlgnClmn> findAll() {
        return plgnClmnRepository.findAll();
    }
}

