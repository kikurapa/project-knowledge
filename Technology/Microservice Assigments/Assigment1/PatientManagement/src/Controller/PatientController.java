package com.wipro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
public class PatientController {
	
	@Autowired
	 PatientService patientService;	
	
	
		/*
		 * @PostMapping("/addPatient") public String add(@ModelAttribute("firstName")
		 * String firstName,@ModelAttribute("lastName")String lastName) {
		 * System.out.println("Inside the controller addPatient post method"); Patient
		 * patientInfo=new Patient(firstName,lastName);
		 * System.out.println("details of patientInfo is:"+patientInfo.getFirstName()
		 * +" "+patientInfo.getLastName());
		 * 
		 * Patient savedPatientInfo=patientService.addPatient(patientInfo); //control
		 * goes to the service class-addPatient method if (savedPatientInfo!=null) {
		 * return "success"; } else { return "fail"; }
		 * 
		 * }
		 */
	
	@PostMapping("/patient")
	public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
		Patient prod = patientService.addPatient(patient);
	
		return new ResponseEntity<Patient>(prod,HttpStatus.CREATED);
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
	
	
	

}
