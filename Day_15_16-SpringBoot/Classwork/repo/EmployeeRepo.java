package com.coforge.ems.repo;
// repository == DAO layer

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ems.model.Employee;
// it automatically implements
@Repository
// <Employee==entity,Integer == type of primary key>
public interface EmployeeRepo extends CrudRepository<Employee, Integer>{
	public List<Employee> findByEname (String ename) ;
	public int deleteByEname(String ename);
	public List<Employee> findByDno(int dno);
	public int deleteByDno(int dno);
	
	//Custom Query Methods
	@Query("select eid from Employee")
	public List<Integer> getEids();
	
	@Query("select count(*),max(esalary),min(esalary),sum(esalary),avg(esalary) from Employee")
	public String getInfo();
}
