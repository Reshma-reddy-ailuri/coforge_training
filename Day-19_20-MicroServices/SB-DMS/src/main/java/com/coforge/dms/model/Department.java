package com.coforge.dms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_department")
public class Department {

    @Id
    @Column(name = "dno")
    @NotNull
    private int dno;

    @Column(name = "dname", length = 20)
    @NotBlank
    private String dname;

    // Default Constructor
    public Department() {
        super();
    }

    // Parameterized Constructor
    public Department(int dno, String dname) {
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