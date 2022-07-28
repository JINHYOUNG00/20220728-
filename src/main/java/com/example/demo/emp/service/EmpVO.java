package com.example.demo.emp.service;


import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	private String employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private Date   hireDate;
	private String jobId;
	private String salary;
	private String departmentId;
	private Double commissionPct;
  
}
