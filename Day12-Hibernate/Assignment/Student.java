package com.coforge.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "student_table")
public class Student { 
	@Id
	private int sid;
	private String sname;
	
	@ManyToMany(cascade=CascadeType.ALL)
	
	@JoinTable(
			name="student_course",
			joinColumns = @JoinColumn(name="sid"),
			inverseJoinColumns = @JoinColumn(name="cid") )
	
	
	public Set <Course> courses = new HashSet<Course> ();
	
	public Student() {
		super();
	}
	
	
	public Student(int sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + "]";
	}

	public int getSid() {
		return sid;
	}

	public String getSname() {
		return sname;
	}
		
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}	
	
	public Set <Course> getCourses() {
		return courses;
	}
	
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
