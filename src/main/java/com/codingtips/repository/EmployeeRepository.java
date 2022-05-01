package com.codingtips.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingtips.model.EmployeeModel;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, Integer> {

}
