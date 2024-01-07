package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.model.Services;
import com.wipro.service.ServicesService;

@Controller
@EnableAutoConfiguration
public class ServiceController {
	
	@Autowired
	ServicesService servicesService;	
	
	@GetMapping("/create")
    public String createAccount(Services patient) {
        return "add-service";
    }
	
	@PostMapping("/addService")
	public String createService(@ModelAttribute("serviceName") String serviceName,@ModelAttribute("fees")float fees) {
		Services serviceInfo=new Services(serviceName,fees);
		Services SInfo = servicesService.addPatient(serviceInfo);
		if(SInfo != null) {
			return "success"; 
		}else {
			return "fail"; 
		}
	
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
