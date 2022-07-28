package com.example.demo.emp.service;


import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpReqVO {
	private String employeeId;
	private String[] dept;
	private String jobId;
	private Date sdt;
	private Date edt;
	
}
