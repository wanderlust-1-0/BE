package com.lambdaschool.wanderlust.repository;

import com.lambdaschool.wanderlust.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}