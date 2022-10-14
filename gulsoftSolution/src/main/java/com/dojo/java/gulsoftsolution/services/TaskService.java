package com.dojo.java.gulsoftsolution.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.java.gulsoftsolution.models.Task;
import com.dojo.java.gulsoftsolution.repositories.TaskRepo;

@Service
public class TaskService {
	private final TaskRepo taskRepo;
	
	public TaskService(TaskRepo taskRepo) {
		this.taskRepo = taskRepo;
	}
	
	public List<Task> allTasks(){
		return taskRepo.findAll();
	}
	
	public List<Task> infoTasks(Long informationId){
		return taskRepo.findByInformationIdIs(informationId);
	}
	
	public Task addTask(Task task) {
		return taskRepo.save(task);
	}
	
	public void deleteTask(Task task) {
		taskRepo.delete(task);
	}
}