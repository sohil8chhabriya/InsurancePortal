package com.insurance.portal.java.repository;
import org.springframework.data.repository.CrudRepository;

import com.insurance.portal.java.entity.*;

public interface UserRepository extends CrudRepository<User, Integer> {

}