import { Component } from '@angular/core';

@Component({
  selector: 'app-employee-profile',
  standalone: false,
  templateUrl: './employee-profile.html',
  styleUrl: './employee-profile.css',
})
export class EmployeeProfile {
  EmployeeId : number;
  Name : string;
  Department : string;
  Salary : number;
  flag : boolean = true;

  constructor() {
    this.EmployeeId = 101;
    this.Name = "Reshma";
    this.Department = "Development";
    this.Salary = 65000; 
  }
  
  toggle () {
    this.flag = !this.flag;
  }

}

