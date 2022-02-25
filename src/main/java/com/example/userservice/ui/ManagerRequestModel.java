package com.example.userservice.ui;

import javax.persistence.Column;
import java.util.Random;

public class ManagerRequestModel {
    private int managerId=new Random().nextInt(1000);

    private String firstName;

    private String lastName;

    public ManagerRequestModel() {
    }

    public ManagerRequestModel(int managerId, String firstName, String lastName) {
        this.managerId = managerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
