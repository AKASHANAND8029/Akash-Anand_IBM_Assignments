package com.example.userservice;

import com.example.userservice.entity.AdminEntity;
import com.example.userservice.entity.ManagerEntity;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.repo.AdminRepository;
import com.example.userservice.repo.ManagerRepository;
import com.example.userservice.repo.UserRepository;
import com.example.userservice.ui.ErrorResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final ManagerRepository managerRepository;

    public UserServiceApplication(UserRepository userRepository, AdminRepository adminRepository, ManagerRepository managerRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.managerRepository = managerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }
    @Bean
    public ModelMapper modelMapper1()
    {
        return new ModelMapper();
    }
    @Bean
    public ModelMapper modelMapper2()
    {
        return new ModelMapper();
    }
    @Bean
    public ErrorResponseModel errorResponseModel()
    {
        return  new ErrorResponseModel();
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new UserEntity(1, UUID.randomUUID().toString(),"John","Doe","john@email.com","tytyt"));
        userRepository.save(new UserEntity(2, UUID.randomUUID().toString(),"Marry","Public","marry@email.com","uyuyuuy"));
        userRepository.save(new UserEntity(3, UUID.randomUUID().toString(),"Daniel","Smith","daniel@email.com","uiyuyu"));
        userRepository.save(new UserEntity(4, UUID.randomUUID().toString(),"Sachin","Tendulkar","sachin@email.com","uiuj"));
      adminRepository.save(new AdminEntity(new Random().nextInt(1000),"Akash","Anand"));
    managerRepository.save(new ManagerEntity(new Random().nextInt(1000),"Akhil","Rana"));
    }

}