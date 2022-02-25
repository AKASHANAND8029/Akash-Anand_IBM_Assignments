package com.example.userservice.controller;

import com.example.userservice.service.AdminService;
import com.example.userservice.service.ManagerService;
import com.example.userservice.ui.AdminRequestModel;
import com.example.userservice.ui.ManagerRequestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    private final ModelMapper modelMapper2;
    private final ManagerService managerService;
    @Autowired
    public ManagerController(ModelMapper modelMapper2, ManagerService managerService) {
        this.modelMapper2 = modelMapper2;
        this.managerService = managerService;
    }
    @GetMapping("/managers")
    public ResponseEntity<List<ManagerRequestModel>> getUsers()
    {
        modelMapper2.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<ManagerRequestModel> list=new ArrayList<>();
        List<ManagerRequestModel> requestModels=managerService.getAllManager();
        for (ManagerRequestModel m:requestModels)
        {
            list.add(modelMapper2.map(m,ManagerRequestModel.class));
        }
        return ResponseEntity.ok(list);
    }

//    @GetMapping("/")
//    public String sayHello()
//    {
//        return "hello world";
//    }
}
