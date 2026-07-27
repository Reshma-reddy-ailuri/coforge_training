import { Component } from '@angular/core';

@Component({
  selector: 'app-registration-form',
  standalone: false,
  templateUrl: './registration-form.html',
  styleUrl: './registration-form.css',
})
export class RegistrationForm {
    name: string;
  email: string;
  course: string;

  constructor() {
    this.name = "";
    this.email = "";
    this.course = "";
  }

  register() {
    console.log("Registration Successful");
    console.log("Name : " + this.name);
    console.log("Email : " + this.email);
    console.log("Course : " + this.course);

    alert("Registration Successful");
  }

  reset() {
    this.name = "";
    this.email = "";
    this.course = "";
  }

}  