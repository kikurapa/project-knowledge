package com.wipro.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;

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
	@Value("${pivotal.servicesservice.name}")
	 protected String servicesservice;
	
	@SuppressWarnings("unchecked")
	public ModelAndView getAllServices()
	{
		ModelAndView mv=new ModelAndView();
		//getting instances using discoveryClient object		
		//List<ServiceInstance> instances=  discoveryClient.getInstances(servicesservice);
		//URI uri=instances.get(0).getUri();	
		//final String uri = "http://localhost:8084/getServices";
		ServiceInstance instance=loadBalancerClient.choose(servicesservice);
		//URI uri=instance.getUri();
		URI uri=URI.create(String.format("http://%s:%s",
				instance.getHost(),instance.getPort()));
		System.out.println("Services-Service.URI========="+uri);
		String url=uri.toString()+"/getServices";
		System.out.println("========================================");
		System.out.println("Services-Service.URI========="+url);
		
		 List<Services> result = restTemplate.getForObject(url, List.class);
		    System.out.println("details of results:"+result.toString());
		    
		mv.addObject("serviceInfo",result);			
		mv.setViewName("displayService");
		return mv;
		
		
	}

}
