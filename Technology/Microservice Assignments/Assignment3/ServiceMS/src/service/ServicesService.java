package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.model.Services;
import com.wipro.repo.ServiceRepository;

@Service
public class ServicesService {
	
	@Autowired
	ServiceRepository serviceRepository;
	
	public Services addPatient(Services service)	{
		//System.out.println("new patientInfo details inside addPatient service is:"+patient.getFirstName()+" "+patient.getLastName());
		System.out.println("repo object:"+serviceRepository);
		return serviceRepository.save(service);
	}
	
	public List<Services> getServices() {
		return serviceRepository.findAll(); //return all patient objects
		
	}
	
	public Optional<Services> getService(Integer serviceId) {
		return serviceRepository.findById(serviceId); //return only 1 service object based on the Id
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView getAllServices()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("serviceInfo",serviceRepository.findAll());	
		mv.setViewName("displayService");
		return mv;
		
		
	}

}
