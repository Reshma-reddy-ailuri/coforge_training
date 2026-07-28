import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { EmployeeProfile } from './employee-profile/employee-profile';
import { StudentComponent } from './student-component/student-component';
import { ProductCatalog } from './product-catalog/product-catalog';
import { RegistrationForm } from './registration-form/registration-form';
import { CompanyDashboard } from './company-dashboard/company-dashboard';
import { FormsModule } from '@angular/forms';
import { CounterApplication } from './counter-application/counter-application';
import { EmployeeComponent } from './employee-component/employee-component';
import { StudentMarksComponent } from './student-marks-component/student-marks-component';
import { EmployeeRegistrationFormComponent } from './employee-registration-form-component/employee-registration-form-component';

@NgModule({
  declarations: [
    App,
    EmployeeProfile,
    StudentComponent,
    ProductCatalog,
    RegistrationForm,
    CompanyDashboard,
    CounterApplication,
    EmployeeComponent,
    StudentMarksComponent,
    EmployeeRegistrationFormComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideBrowserGlobalErrorListeners()],
  bootstrap: [App],
})
export class AppModule {}
