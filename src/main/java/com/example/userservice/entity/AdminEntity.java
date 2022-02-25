package com.example.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;
import java.util.Scanner;

@Data
@Entity
@Table(name="admin")
public class AdminEntity {

    @Id
    private int adminId=new Random().nextInt(1000);
    @Column(name="admin_first_name")
    private String adminFirstName;
    @Column(name="admin_last_name")
    private String adminLastname;



    public AdminEntity() {
    }

    public AdminEntity(int adminId, String adminFirstName, String adminLastname) {
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
    @Override
    public String toString() {
        return "Admin [id=" + adminId + ", FirstName=" + adminFirstName + ", lastName=" + adminLastname + "]";
    }
}
