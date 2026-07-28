import { Component } from '@angular/core';

@Component({
  selector: 'app-employee-registration-form-component',
  standalone: false,
  templateUrl: './employee-registration-form-component.html',
  styleUrl: './employee-registration-form-component.css',
})
export class EmployeeRegistrationFormComponent {
  employee={

id:'',
name:'',
email:'',
mobile:'',
department:'',
gender:'',
doj:'',
salary:''

};

submit(){

alert("Employee Registered Successfully");

console.log(this.employee);

}

}
