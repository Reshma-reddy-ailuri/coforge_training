import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { MyChild1 } from './my-child-1/my-child-1';
import { MyChild2 } from './my-child-2/my-child-2';
import { FormsModule } from '@angular/forms';
import { StructuralComponent } from './structural-component/structural-component';
import { CalculatorService } from './calculator-service';
import { AdditionComponent } from './addition-component/addition-component';
import { SubtractionComponent } from './subtraction-component/subtraction-component';
import { EmployeeComponent } from './employee-component/employee-component';
import { HomeComponent } from './home-component/home-component';
import { AboutComponent } from './about-component/about-component';
import { ContactComponent } from './contact-component/contact-component';

@NgModule({
  declarations: [
    App,
    MyChild1,
    MyChild2,
    StructuralComponent,
    AdditionComponent,
    SubtractionComponent,
    EmployeeComponent,
    HomeComponent,
    AboutComponent,
    ContactComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule],
  providers: [provideBrowserGlobalErrorListeners(), CalculatorService],
  bootstrap: [App],
})
export class AppModule {}
