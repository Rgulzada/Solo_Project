package com.dojo.java.gulsoftsolution.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.java.gulsoftsolution.models.Information;
import com.dojo.java.gulsoftsolution.models.User;

public interface InfoRepository extends CrudRepository<Information, Long> {
	List<Information> findAll();
	Information findByIdIs(Long id);
	List<Information> findAllByUsers(User user);
	List<Information> findByUsersNotContains(User user);
}