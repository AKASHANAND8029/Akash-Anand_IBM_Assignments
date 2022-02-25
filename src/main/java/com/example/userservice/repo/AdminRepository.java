package com.example.userservice.repo;

import com.example.userservice.entity.AdminEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<AdminEntity,Integer> {
}
