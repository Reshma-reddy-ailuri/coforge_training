import { Component } from '@angular/core';

@Component({
  selector: 'app-employee-component',
  standalone: false,
  templateUrl: './employee-component.html',
  styleUrl: './employee-component.css',
})
export class EmployeeComponent {
  showEmployee = true;

  employee = {
    id: 101,
    name: 'Reshma',
    department: 'IT',
    salary: 95000
  };

  toggleEmployee() {
    this.showEmployee = !this.showEmployee;
  }
}
