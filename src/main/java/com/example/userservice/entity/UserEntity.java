package com.example.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user_table")
public class UserEntity {
    @Id
    @Column(name="id")
    private Integer id=new Random().nextInt(1000);
    @Column(name = "user_id",unique = true,nullable = false)
    private String userId;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "user_encrypted_password",nullable = false)
    private String encryptedPassword;
}
