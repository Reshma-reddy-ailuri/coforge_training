package com.coforge.ems.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.coforge.ems.dto.DepartmentDTO;

@FeignClient(name = "SB-DMS-SERVICE")
//@FeignClient(name="SB-DMS-SERVICE",path="/api/v1/dms")
public interface DepartmentClient {

    @GetMapping("/api/v1/dms/departments/{dno}")
    public DepartmentDTO findDepartmentById(@PathVariable int dno);

    @GetMapping("/api/v1/dms/departments")
	public List<DepartmentDTO> findAllDepartments();

}