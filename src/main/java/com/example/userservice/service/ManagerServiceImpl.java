package com.example.userservice.service;

import com.example.userservice.entity.AdminEntity;
import com.example.userservice.entity.ManagerEntity;
import com.example.userservice.repo.AdminRepository;
import com.example.userservice.repo.ManagerRepository;
import com.example.userservice.ui.AdminRequestModel;
import com.example.userservice.ui.ManagerRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{
    private final ModelMapper modelMapper2;
    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ModelMapper modelMapper2, ManagerRepository managerRepository) {
        this.modelMapper2 = modelMapper2;
        this.managerRepository = managerRepository;
    }

    @Override
    public List<ManagerRequestModel> getAllManager() {
        modelMapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<ManagerRequestModel> list = new ArrayList<>();
        Iterable<ManagerEntity> iterable = managerRepository.findAll();

        Iterator<ManagerEntity> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.add(modelMapper2.map(iterator.next(),ManagerRequestModel.class));
        }
        return list;
    }
    }
