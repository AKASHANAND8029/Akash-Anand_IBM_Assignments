package com.example.userservice.controller;

import com.example.userservice.service.AdminService;
import com.example.userservice.ui.AdminRequestModel;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/admin")
public class AdminController {
    private final ModelMapper modelMapper1;
    private final AdminService adminService;
@Autowired
    public AdminController(ModelMapper modelMapper1, AdminService adminService) {
        this.modelMapper1 = modelMapper1;
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public ResponseEntity<List<AdminRequestModel>> getUsers()
    {
        modelMapper1.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        List<AdminRequestModel> list=new ArrayList<>();
        List<AdminRequestModel> requestModels=adminService.getAllAdmin();
        for (AdminRequestModel a:requestModels)
        {
            list.add(modelMapper1.map(a,AdminRequestModel.class));
        }
        return ResponseEntity.ok(list);
    }


//    @GetMapping("/")
//    public String sayHello()
//    {
//        return "hello world admin";
//    }

}