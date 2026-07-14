package com.coforge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_emp")
public class Employee { 
	@Id
	@Column(name="eid" , length = 5)
	private int eid;
	
	@Column(name = "ename" , length = 20)
	private String ename;
	
	@Column(name="esalary" , length = 5)
	private int esalary;
	
	@Column(name="dno" , length = 3)
	private int dno;
	
	public Employee() {
		super();
	}
	
	
	public Employee(int eid, String ename, int esalary, int dno) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esalary = esalary;
		this.dno = dno;
	}
	
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esalay=" + esalary + ", dno=" + dno + "]";
	}

	public int getEid() {
		return eid;
	}

	public String getEname() {
		return ename;
	}
	
	public int getEsalary() {
		return esalary;
	}
	
	public int getDno() {
		return dno;
	}
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}
	
	public void setDno(int dno) {
		this.dno = dno;
	}
	
}
