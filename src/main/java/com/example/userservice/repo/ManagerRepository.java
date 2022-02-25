package com.example.userservice.repo;

import com.example.userservice.entity.ManagerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<ManagerEntity,Integer> {
}
