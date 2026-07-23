package com.coforge.dms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.dms.exception.DepartmentNotFoundException;
import com.coforge.dms.model.Department;
import com.coforge.dms.repo.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepo repo;
    private Environment environment;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepo repo, Environment environment) {
        this.repo = repo;
        this.environment = environment;
    }

    @Override
    public boolean saveDepartment(Department department) {
        repo.save(department);
        return true;
    }

    @Override
    public boolean updateDepartment(int dno, Department department) {

        if (!repo.existsById(dno)) {
            throw new DepartmentNotFoundException(
                    environment.getProperty("dms.invalid.department-notfound"));
        }

        department.setDno(dno);
        repo.save(department);

        return true;
    }

    @Override
    public boolean deleteByDno(int dno) {

        if (!repo.existsById(dno)) {
            throw new DepartmentNotFoundException(
                    environment.getProperty("dms.invalid.department-notfound"));
        }

        repo.deleteById(dno);
        return true;
    }

    @Override
    public Optional<Department> findByDno(int dno) {

        if (!repo.existsById(dno)) {
            throw new DepartmentNotFoundException(
                    environment.getProperty("dms.invalid.department-notfound"));
        }

        return repo.findById(dno);
    }

    @Override
    public List<Department> getAllDepartments() {
        return (List<Department>) repo.findAll();
    }

    @Override
    public List<Department> findByDname(String dname) {

        List<Department> departments = repo.findByDname(dname);

        if (departments.isEmpty()) {
            throw new DepartmentNotFoundException(
                    environment.getProperty("dms.invalid.department-notfound"));
        }

        return departments;
    }

    @Override
    @Transactional
    public boolean deleteByDname(String dname) {

        int count = repo.deleteByDname(dname);

        if (count == 0) {
            throw new DepartmentNotFoundException(
                    environment.getProperty("dms.invalid.department-notfound"));
        }

        return true;
    }

    @Override
    public List<Integer> getDnosList() {
        return repo.getDnos();
    }
}