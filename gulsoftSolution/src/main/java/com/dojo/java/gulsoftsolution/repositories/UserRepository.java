package com.dojo.java.gulsoftsolution.repositories;


import org.springframework.data.repository.CrudRepository;

import com.dojo.java.gulsoftsolution.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
}

