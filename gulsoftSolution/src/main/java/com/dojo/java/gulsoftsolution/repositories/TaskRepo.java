package com.dojo.java.gulsoftsolution.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.java.gulsoftsolution.models.Task;

public interface TaskRepo extends CrudRepository<Task, Long>{
	List<Task> findAll();
	List<Task> findByInformationIdIs(Long id);
}
