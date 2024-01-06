package com.wipro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.model.Patient;
import com.wipro.model.Services;
import com.wipro.repo.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;
	
	@Autowired
	RestTemplate restTemplate;

	/*
	 * static { List<Patient> patients=new ArrayList<>(); patients.add(new
	 * Patient("Kiran", "Kumar")); patients.add(new Patient("Rohit", "Kumar"));
	 * patients.add(new Patient("Niraj", "Kumar")); for(Patient patient : patients)
	 * { addPatient(patient); } }
	 */
	public Patient addPatient(Patient patient)	{
		System.out.println("new patientInfo details inside addPatient service is:"+patient.getFirstName()+" "+patient.getLastName());
		System.out.println("repo object:"+patientRepository);
		return patientRepository.save(patient);
	}
	
	public List<Patient> getPatients() {
		return patientRepository.findAll(); //return all patient objects
		
	}
	
	public Optional<Patient> getPatient(Integer patientId) {
		return patientRepository.findById(patientId); //return only 1 patient object based on the Id
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView getAllPatients()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("patientInfo",patientRepository.findAll());	
		mv.setViewName("displayPatient");
		return mv;
		
		
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView getAllServices()
	{
		ModelAndView mv=new ModelAndView();
		final String uri = "http://localhost:8084/getServices";
		 List<Services> result = restTemplate.getForObject(uri, List.class);
		    System.out.println("details of results:"+result.toString());
		    
		mv.addObject("serviceInfo",result);			
		mv.setViewName("displayService");
		return mv;
		
		
	}

}
