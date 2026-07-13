package com.coforge.ems.util;

public class ApplicationProperties {

    // Database Connection Properties
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3306/training";
    public static final String userName = "root";
    public static final String password = "root";

    // SQL Queries
    public static final String insertSql =
            "INSERT INTO tbl_emp VALUES (?,?,?,?)";

    public static final String updateSql =
            "UPDATE tbl_emp SET ename=?, esalary=?, dno=? WHERE eid=?";

    public static final String deleteSql =
            "DELETE FROM tbl_emp WHERE eid=?";

    public static final String findSql =
            "SELECT * FROM tbl_emp WHERE eid=?";

    public static final String findAllSql =
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
    public static final String notFound = "FAILED : Employee Record Not Found";

    // Validation Message
    public static final String validationFailed =
            "FAILED : Invalid Employee Object or Details";

}