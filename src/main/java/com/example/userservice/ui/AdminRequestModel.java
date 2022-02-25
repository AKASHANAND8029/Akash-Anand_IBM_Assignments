package com.example.userservice.ui;

import javax.persistence.Column;
import java.util.Random;

public class AdminRequestModel {
    private int adminId=new Random().nextInt(1000);

    private String adminFirstName;

    private String adminLastname;
    public AdminRequestModel() {
    }

    public AdminRequestModel(int adminId, String adminFirstName, String adminLastname) {
        this.adminId = adminId;
        this.adminFirstName = adminFirstName;
        this.adminLastname = adminLastname;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public void setAdminFirstName(String adminFirstName) {
        this.adminFirstName = adminFirstName;
    }

    public String getAdminLastname() {
        return adminLastname;
    }

    public void setAdminLastname(String adminLastname) {
        this.adminLastname = adminLastname;
    }
}
