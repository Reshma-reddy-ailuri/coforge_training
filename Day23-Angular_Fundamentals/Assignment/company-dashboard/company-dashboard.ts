import { Component } from '@angular/core';

@Component({
  selector: 'app-company-dashboard',
  standalone: false,
  templateUrl: './company-dashboard.html',
  styleUrl: './company-dashboard.css',
})
export class CompanyDashboard {
  companyName : string;
  ceo :string;
  location : string;
  employeesCount : number;
  revenue : number;

  constructor() {
    this.companyName = "";
    this.ceo = "";
    this.location = "";
    this.employeesCount = 0;
    this.revenue = 0;
  }
}