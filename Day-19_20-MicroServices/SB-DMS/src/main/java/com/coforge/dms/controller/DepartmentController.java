package com.coforge.dms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.coforge.dms.model.Department;
import com.coforge.dms.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/dms")
public class DepartmentController {

    private DepartmentService service;
    private Environment environment;

    @Autowired
    public DepartmentController(DepartmentService service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }

    @PostMapping("/departments")
    public ResponseEntity<String> saveDepartment(@Valid @RequestBody Department department) {

        service.saveDepartment(department);

        return new ResponseEntity<>(
                environment.getProperty("dms.save.success"),
                HttpStatus.CREATED);
    }

    @PutMapping("/departments/{dno}")
    public ResponseEntity<String> updateDepartment(@PathVariable int dno,
                                                   @Valid @RequestBody Department department) {

        service.updateDepartment(dno, department);

        return new ResponseEntity<>(
                environment.getProperty("dms.update.success"),
                HttpStatus.OK);
    }

    @DeleteMapping("/departments/{dno}")
    public ResponseEntity<String> deleteByDno(@PathVariable int dno) {

        service.deleteByDno(dno);

        return new ResponseEntity<>(
                environment.getProperty("dms.delete.success"),
                HttpStatus.OK);
    }

    @GetMapping("/departments/{dno}")
    public ResponseEntity<Department> findByDno(@PathVariable int dno) {

        Optional<Department> department = service.findByDno(dno);

        return new ResponseEntity<>(department.get(), HttpStatus.OK);
    }

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> getAllDepartments() {

        return new ResponseEntity<>(
                service.getAllDepartments(),
                HttpStatus.OK);
    }

    @GetMapping("/departments/dname/{dname}")
    public ResponseEntity<List<Department>> findByDname(@PathVariable String dname) {

        return new ResponseEntity<>(
                service.findByDname(dname),
                HttpStatus.OK);
    }

    @DeleteMapping("/departments/dname/{dname}")
    public ResponseEntity<String> deleteByDname(@PathVariable String dname) {

        service.deleteByDname(dname);

        return new ResponseEntity<>(
                environment.getProperty("dms.delete.success"),
                HttpStatus.OK);
    }

    @GetMapping("/departments/dnos")
    public ResponseEntity<List<Integer>> getDnosList() {

        return new ResponseEntity<>(
                service.getDnosList(),
                HttpStatus.OK);
    }
}