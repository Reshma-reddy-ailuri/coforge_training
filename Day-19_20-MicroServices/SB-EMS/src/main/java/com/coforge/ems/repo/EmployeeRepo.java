package com.coforge.ems.repo;

import java.util.List;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coforge.ems.model.Employee;

//do the implementation automatically same as DAO
//public interface EmployeeRepo extends JpaAttributeConverter<Employee, Integer> {

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
	public List <Employee> findByEname(String ename);
	public int deleteByEname(String ename);
	public List<Employee> findByDno(int dno);
	public int deleteByDno(int dno);
	
	//custom query methods
	@Query("select eid from Employee")
	public List<Integer> getEids();
	
	@Query("select count(*),max(esalary),min(esalary),sum(esalary),avg(esalary) from Employee")
	public String getInfo();
}