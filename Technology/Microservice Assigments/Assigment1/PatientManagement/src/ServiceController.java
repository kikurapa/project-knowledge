package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.model.Services;
import com.wipro.service.ServicesService;

@RestController
public class ServiceController {
	
	@Autowired
	ServicesService servicesService;	
	
	
	@PostMapping("/service")
	public ResponseEntity<Services> createService(@RequestBody Services service) {
		Services prod = servicesService.addPatient(service);
	
		return new ResponseEntity<Services>(prod,HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/getServices")
	@ResponseBody
	public List<Services> getServices() {
		return servicesService.getServices();
		
	}
	

	@GetMapping("/getService/{serviceId}")
	@ResponseBody
	public Optional<Services> getService(@PathVariable("serviceId")Integer serviceId) {
		return servicesService.getService(serviceId);		
	}
	
	@GetMapping("/displayService")
	public ModelAndView getAll()
	{
		return servicesService.getAllServices();
		
		
	}
	
	@GetMapping("/servicecount")
	@ResponseBody
	public String getServiceCount() {
		return String.valueOf(servicesService.getServices().size());		
	}

}
