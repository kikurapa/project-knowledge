package com.wipro.service;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.wipro.model.Services;
@FeignClient(value = "Services-Service")
@LoadBalancerClient(name="Services-Service",configuration=CloudProviderConfiguration.class)
public interface PatientInfoProxy {
	@GetMapping("/getServices")
	public List<Services> getService();

}
