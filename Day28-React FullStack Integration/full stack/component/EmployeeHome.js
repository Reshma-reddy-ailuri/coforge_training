import { Component } from "react";
import Employee from "../Models/Employee";
import EmployeeService from "../services/EmployeeService";

class EmployeeHome extends Component {

    constructor() {
        super()
        this.employeeService = new EmployeeService();
        this.state = {
            eid: 0,
            ename: "",
            esalary: 0,
            dno: 0,

            employees: [],
            flag: false,

            result: "",

            eidError: "",
            enameError: "",
            esalaryError: "",
            dnoError: ""
        }
    }

    saveEmployeeValidation() {

        let valid = true;

        if (this.state.eid === "") {
            this.setState({ eidError: "Employee ID is required" });
            valid = false;
        } else if (isNaN(this.state.eid) || Number(this.state.eid) <= 0) {
            this.setState({ eidError: "Employee ID must be positive number" });
            valid = false;
        }

        if (this.state.ename === "") {
            this.setState({ enameError: "Employee Name is required" });
            valid = false;
        } else if (!/^[A-Za-z ]+$/.test(this.state.ename)) {
            this.setState({ enameError: "Name should contain only alphabets" });
            valid = false;
        }

        if (this.state.dno === "") {
            this.setState({ dnoError: "Department No is required" });
            valid = false;
        } else if (isNaN(this.state.dno) || Number(this.state.dno) <= 0) {
            this.setState({ dnoError: "Department No must be positive number" });
            valid = false;
        }

        if (this.state.esalary === "") {
            this.setState({ esalaryError: "Salary is required" });
            valid = false;
        } else if (isNaN(this.state.esalary) || Number(this.state.esalary) <= 0) {
            this.setState({ esalaryError: "Salary must be positive number" });
            valid = false;
        }

        return valid

    }
    saveEmployee = () => {
        if (this.saveEmployeeValidation()) {
            let employee = new Employee(this.state.eid, this.state.ename, this.state.esalary, this.state.dno)
            this.employeeService.saveEmployee(employee)
                .then((response) => {
                    console.log(response.data);
                    this.setState({
                        result: response.data,
                        flag: false,
                        employees: []
                    });
                })
                .catch((error) => {
                    console.error(error);
                });
        }
    }

    updateEmployee = () => {

        let valid = true;

        if (this.state.eid === "") {
            this.setState({ eidError: "Employee ID is required" });
            valid = false;
        }
        else if (isNaN(this.state.eid) || Number(this.state.eid) <= 0) {
            this.setState({ eidError: "Employee ID must be positive number" });
            valid = false;
        }

        if (!valid) {
            return;
        }
        //creating object
        let employee = new Employee(
            this.state.eid,
            this.state.ename,
            this.state.esalary,
            this.state.dno
        );

        this.employeeService.updateEmployee(employee)
            .then((response) => {
                console.log(response.data);
                this.setState({
                    result: response.data,
                    flag: false,
                    employees: []
                });
            })
            .catch((error) => {
                console.error(error);
            });
    }
    deleteEmployee = () => {

        let valid = true;

        if (this.state.eid === "") {
            this.setState({ eidError: "Employee ID is required" });
            valid = false;
        }
        else if (isNaN(this.state.eid) || Number(this.state.eid) <= 0) {
            this.setState({ eidError: "Employee ID must be positive number" });
            valid = false;
        }

        if (!valid) {
            return;
        }

        this.employeeService.deleteEmployee(this.state.eid)
            .then((response) => {
                console.log(response.data);

                this.setState({
                    result: response.data,
                    flag: false,
                    employees: []
                });
            })
            .catch((error) => {
                console.error(error);
            });
    }
    findEmployee = () => {

        this.employeeService.findEmployee(this.state.eid)
            .then((response) => {

                this.setState({
                    employees: [response.data],
                    flag: true,
                    result: ""
                });

            })
            .catch((error) => {
                console.error(error);
            });

    }
   findAllEmployee = () => {

    this.employeeService.findAllEmployees()
        .then((response) => {

            this.setState({
                employees: response.data,
                flag: true,
                result: ""
            });

        })
        .catch((error) => {
            console.error(error);
        });

}
    render() {
        return (
            <>
                <h2>Employee Registration</h2>

                <p>Employee ID:
                    <input type="text" value={this.state.eid} onChange={(e) => this.setState({ eid: e.target.value })} /></p>
                <p style={{ color: "red" }}>{this.state.eidError}</p>

                <p>Employee Name:
                    <input type="text" value={this.state.ename} onChange={(e) => this.setState({ ename: e.target.value })} /></p>
                <p style={{ color: "red" }}>{this.state.enameError}</p>

                <p>Salary:
                    <input type="text" value={this.state.esalary} onChange={(e) => this.setState({ esalary: e.target.value })} /></p>
                <p style={{ color: "red" }}>{this.state.esalaryError}</p>

                <p>Department No:
                    <input type="text" value={this.state.dno} onChange={(e) => this.setState({ dno: e.target.value })} /></p>
                <p style={{ color: "red" }}>{this.state.dnoError}</p>

                <button onClick={this.saveEmployee}>Save Employee</button>&nbsp;
                <button onClick={this.updateEmployee}>Update Employee</button>&nbsp;
                <button onClick={this.deleteEmployee}>Delete Employee</button>&nbsp;
                <button onClick={this.findEmployee}>Find Employee</button>&nbsp;
                <button onClick={this.findAllEmployee}>Find All Employees</button>
                <br />

                <b>{this.state.result}</b>
                {
                    this.state.flag &&

                    <table border="1" cellPadding="10">

                        <thead>
                            <tr>
                                <th>Employee ID</th>
                                <th>Employee Name</th>
                                <th>Salary</th>
                                <th>Department No</th>
                            </tr>
                        </thead>

                        <tbody>

                            {
                                this.state.employees.map((emp) => (

                                    <tr key={emp.eid}>
                                        <td>{emp.eid}</td>
                                        <td>{emp.ename}</td>
                                        <td>{emp.esalary}</td>
                                        <td>{emp.dno}</td>
                                    </tr>

                                ))
                            }

                        </tbody>

                    </table>

                }


            </>
        );
    }
}
export default EmployeeHome;