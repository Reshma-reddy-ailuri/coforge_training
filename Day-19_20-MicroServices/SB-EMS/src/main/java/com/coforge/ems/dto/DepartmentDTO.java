package com.coforge.ems.dto;

public class DepartmentDTO {

    private int dno;

    private String dname;

    // Default Constructor
    public DepartmentDTO() {
        super();
    }

    // Parameterized Constructor
    public DepartmentDTO(int dno, String dname) {
        super();
        this.dno = dno;
        this.dname = dname;
    }

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Department [dno=" + dno + ", dname=" + dname + "]";
    }
}