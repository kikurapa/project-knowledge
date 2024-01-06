package com.wipro.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
