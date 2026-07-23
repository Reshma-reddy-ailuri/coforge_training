package com.coforge.dms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.dms.model.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Integer> {

    List<Department> findByDname(String dname);

    int deleteByDname(String dname);

    @Query("select d.dno from Department d")
    List<Integer> getDnos();
}