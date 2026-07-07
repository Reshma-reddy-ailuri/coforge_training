package com.coforge.ems.util;

public class ApplicationProperties {

    // Database Connection Properties
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/training";
    public static final String userName = "root";
    public static final String password = "root";

    // SQL Queries
    public static final String insertsql =
            "INSERT INTO tbl_emp VALUES (?,?,?,?)";

    public static final String updatesql =
            "UPDATE tbl_emp SET ename=?, esalary=?, dno=? WHERE eid=?";

    public static final String deletesql =
            "DELETE FROM tbl_emp WHERE eid=?";

    public static final String findsql =
            "SELECT * FROM tbl_emp WHERE eid=?";

    public static final String findAllsql =
            "SELECT * FROM tbl_emp";

    // Success Messages
    public static final String insertSuccess =
            "SUCCESS : Employee Object Created";

    public static final String updateSuccess =
            "SUCCESS : Employee Record Updated";

    public static final String deleteSuccess =
            "SUCCESS : Employee Record Deleted";

    // Failure Messages
    public static final String dbFailed =
            "FAILED : DB Error Occurred";

    // Validation Message
    public static final String validationFailed =
            "FAILED : Invalid Employee Object or Details";

}