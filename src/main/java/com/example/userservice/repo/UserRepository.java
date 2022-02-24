package com.example.userservice.repo;

import com.example.userservice.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Integer> {
    @Query
    public UserEntity findByUserId(String userId);
    @Query
    public UserEntity findByEmail(String email);
    @Query
    public UserEntity findByFirstName(String firstName);




}
