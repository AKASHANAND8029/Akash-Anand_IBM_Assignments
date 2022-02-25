package com.example.userservice.service;

import com.example.userservice.entity.AdminEntity;
import com.example.userservice.repo.AdminRepository;
import com.example.userservice.ui.AdminRequestModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AdminServiceImpl  implements AdminService{
    private final ModelMapper modelMapper1;
    private final AdminRepository adminRepository;

    public AdminServiceImpl(ModelMapper modelMapper1, AdminRepository adminRepository) {
        this.modelMapper1 = modelMapper1;
        this.adminRepository = adminRepository;
    }

    @Override
    public List<AdminRequestModel> getAllAdmin() {
        modelMapper1.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<AdminRequestModel> list=new ArrayList<>();
        Iterable<AdminEntity> iterable= adminRepository.findAll();

        Iterator<AdminEntity> iterator= iterable.iterator();
        while (iterator.hasNext())
        {
            list.add(modelMapper1.map(iterator.next(),AdminRequestModel.class));
        }
        return list;

    }
}
