package com.example.userservice.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;


@Data
@Entity
@Table(name="manager_table")
public class ManagerEntity {
    @Id

    @Column(name = "manager_id",unique = true,nullable = false)
    private int managerId=new Random().nextInt(1000);
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;

    public ManagerEntity() {
    }

    public ManagerEntity( int managerId,String firstName, String lastName) {

this.managerId=managerId;
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
    @Override
    public String toString() {
        return "Manager [id=" + managerId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}
