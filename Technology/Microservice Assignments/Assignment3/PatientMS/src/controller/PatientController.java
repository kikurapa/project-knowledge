package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.model.Patient;
import com.wipro.service.PatientService;

@Controller
@EnableAutoConfiguration
public class PatientController {
	
	@Autowired
	 PatientService patientService;	
	
	@GetMapping("/create")
    public String createAccount(Patient patient) {
        return "add-patient";
    }
	
	@PostMapping("/addPatient")
	public String createPatient(@ModelAttribute("firstName") String firstName,@ModelAttribute("lastName")String lastName) {
		Patient patientInfo=new Patient(firstName,lastName);
		Patient pInfo = patientService.addPatient(patientInfo);
		if(pInfo != null) {
			return "success"; 
		}else {
			return "fail"; 
		}
	
	}
	
	
	
	@GetMapping("/getPatients")
	@ResponseBody
	public List<Patient> getPatients() {
		return patientService.getPatients();
		
	}
	

	@GetMapping("/getPatient/{patientId}")
	@ResponseBody
	public Optional<Patient> getPatient(@PathVariable("patientId")Integer patientId) {
		return patientService.getPatient(patientId);		
	}
	
	@GetMapping("/displayPatient")
	public ModelAndView getAll()
	{
		return patientService.getAllPatients();
		
		
	}
	
	@GetMapping("/patientCount")
	@ResponseBody
	public String getPatientCount() {
		return String.valueOf(patientService.getPatients().size());		
	}
	
	@GetMapping("/displayService")
	public ModelAndView getAllServices()
	{
		return patientService.getAllServices();
		
		
	}
	

}
