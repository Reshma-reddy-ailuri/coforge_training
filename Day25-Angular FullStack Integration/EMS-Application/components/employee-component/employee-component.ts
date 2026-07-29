import { Component } from '@angular/core';
import { EmployeeService } from '../../services/employee-service';
import { Employee } from '../../models/Employee';

@Component({
  selector: 'app-employee-component',
  standalone: false,
  templateUrl: './employee-component.html',
  styleUrl: './employee-component.css',
})
export class EmployeeComponent {

  employee: Employee;
  result!: string;
  employees : Employee[] = [];
  constructor(private employeeService: EmployeeService) {
    this.employee = new Employee();
  }

  saveEmployee(data: Employee) {
    this.setEmployee(data);
    this.employeeService.saveEmployee(this.employee).subscribe({
      next: (response) => this.result = response,
      error: (error) => this.result = error.error || 'Unable to save employee.'
    });
  }

  updateEmployee(data: Employee) {
    this.setEmployee(data);
    this.employeeService.updateEmployee(this.employee).subscribe({
      next: (response) => this.result = response,
      error: (error) => this.result = error.error || 'Unable to update employee.'
    });
  }

  deleteEmployee(eid: number) {
    this.employeeService.deleteEmployee(eid).subscribe({
      next: (response) => this.result = response,
      error: (error) => this.result = error.error || 'Unable to delete employee.'
    });
  }

  findEmployee(eid: number) {
    this.employeeService.findEmployee(eid).subscribe({
      next: (employee) => {
        this.employee = employee;
        this.result = `Employee found: ${employee.ename} (ID: ${employee.eid}, Salary: ${employee.esalary}, Department: ${employee.dno})`;
      },
      error: (error) => this.result = error.error || 'Employee not found.'
    });
  }

  findAllEmployees() {
    this.employeeService.findAllEmployees().subscribe({
      next: (employees) => {
        this.employees = employees;
        this.result = employees.length ? '' : 'No employees found.';
      },
      error: (error) => {
        this.employees = [];
        this.result = error.error || 'Unable to retrieve employees.';
      },
    });
  }

  private setEmployee(data: Employee) {
    this.employee.eid = data.eid;
    this.employee.ename = data.ename;
    this.employee.esalary = data.esalary;
    this.employee.dno = data.dno;
  }

}