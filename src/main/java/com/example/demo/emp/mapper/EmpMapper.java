package com.example.demo.emp.mapper;

import java.util.List;

import com.example.demo.emp.service.DeptVO;
import com.example.demo.emp.service.EmpReqVO;
import com.example.demo.emp.service.EmpVO;
import com.example.demo.emp.service.JobVO;

public interface EmpMapper {
	public EmpVO getEmp(EmpVO vo);
	public List<EmpVO> getEmpList(EmpReqVO vo);
	public List<EmpVO> getEmpByDept(String[] dept);
	int insert(EmpVO vo);
	int update(EmpVO vo);
	public List<DeptVO> getDepartments();
	public List<JobVO> getJobs();
}
