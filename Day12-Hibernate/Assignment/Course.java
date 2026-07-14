package com.coforge.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name= "course_table")
public class Course {
	@Id
	private int cid;
	
	private String cname;
	
	@ManyToMany(mappedBy="courses")
	
	private Set <Student> students = new HashSet<Student>();
	
	public Course() {
		super();
	}
	
	
	public Course(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + "]";
	}

	public int getCid() {
		return cid;
	}

	public String getCname() {
		return cname;
	}
		
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public void setCname(String cname) {
		this.cname = cname;
	}	
	
	public Set <Student> getStudents() {
		return students;
	}
	
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}

