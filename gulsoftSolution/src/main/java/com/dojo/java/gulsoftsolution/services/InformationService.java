package com.dojo.java.gulsoftsolution.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dojo.java.gulsoftsolution.models.Information;
import com.dojo.java.gulsoftsolution.models.User;
import com.dojo.java.gulsoftsolution.repositories.InfoRepository;

@Service
public class InformationService {
	
	private final InfoRepository infoRepo;
	
	public InformationService(InfoRepository infoRepo) {
		this.infoRepo = infoRepo;
	}
	
	public List<Information> allInformations(){
		return infoRepo.findAll();
	}
	
	public Information updateInformation(Information information) {
		return infoRepo.save(information);
	}
	
	public List<Information> getAssignedUsers(User user){
		return infoRepo.findAllByUsers(user);
	}
	
	public List<Information> getUnassignedUsers(User user){
		return infoRepo.findByUsersNotContains(user);
	}
	
	public Information addInformation(Information information) {
		return infoRepo.save(information);
	}
	
	public void deleteInformation(Information information) {
		infoRepo.delete(information);
	}
	
	public Information findById(Long id) {
		Optional<Information> optionalInformation = infoRepo.findById(id);
		if(optionalInformation.isPresent()) {
			return optionalInformation.get();
		}else {
			return null;
		}
	}
}

