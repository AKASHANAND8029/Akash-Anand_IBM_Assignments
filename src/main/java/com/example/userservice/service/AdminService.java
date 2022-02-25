package com.example.userservice.service;

import com.example.userservice.ui.AdminRequestModel;
import com.example.userservice.ui.ManagerRequestModel;

import java.util.List;

public interface AdminService {
    public List<AdminRequestModel> getAllAdmin();
}
