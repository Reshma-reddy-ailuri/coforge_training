package com.coforge.dms.service;

import java.util.List;
import java.util.Optional;

import com.coforge.dms.model.Department;

public interface DepartmentService {

    boolean saveDepartment(Department department);

    boolean updateDepartment(int dno, Department department);

    boolean deleteByDno(int dno);

    Optional<Department> findByDno(int dno);

    List<Department> getAllDepartments();

    List<Department> findByDname(String dname);

    boolean deleteByDname(String dname);

    List<Integer> getDnosList();

}