package com.coforge.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	private int sid;
	private String sname;
	private List<String> subjects;
	private Set<String> technicalSkills;
	private Map<String,Integer> marks;
	private Address address;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int sid, String sname, Address address, List<String> subjects, Set<String> technicalSkills,
			Map<String, Integer> marks) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.address = address;
		this.subjects = subjects;
		this.technicalSkills = technicalSkills;
		this.marks = marks;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	public Set<String> getTechnicalSkills() {
		return technicalSkills;
	}
	public void setTechnicalSkills(Set<String> technicalSkills) {
		this.technicalSkills = technicalSkills;
	}
	public Map<String, Integer> getMarks() {
		return marks;
	}
	public void setMarks(Map<String, Integer> subjectMarks) {
		this.marks = subjectMarks;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", subjects=" + subjects + ", technicalSkills="
				+ technicalSkills + ", marks=" + marks + ", address=" + address + "]";
	}
	
	public void displayStudentDetails() {
		System.out.println("sid:" +sid);
		System.out.println("sname: "+sname);
		System.out.println("\nSubjects");
		for(String subject:subjects) {
			System.out.println(subject);
		}
		System.out.println("\nSkills");
		for(String Skills:technicalSkills) {
			System.out.println(Skills);
		}
		System.out.println("marks");
		for(Map.Entry<String,Integer> entry : marks.entrySet()) {
			System.out.println(entry.getKey() + "" +entry.getValue());
		}
		
		address.displayAddress();
	}
	
	
	
}
