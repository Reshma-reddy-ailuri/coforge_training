import { Component } from '@angular/core';

@Component({
  selector: 'app-structural-component',
  standalone: false,
  templateUrl: './structural-component.html',
  styleUrl: './structural-component.css',
})
export class StructuralComponent {
  myDivStyle : string;
  myButtonStyle = {};
  message : string;
  flag : boolean;
  vehicles : string[]; //declaring vehicle array as string array
  selectedVehicle :string;

  constructor() {
    this.myDivStyle = "MyDiv";
    this.myButtonStyle = {backgroundColor : 'blue' , color:'white', padding : '10px',border: '20px' };
    this.message = "Angular Structural Directive";
    this.flag = true;
    this.vehicles = ['Car','Bike','Bus','Truck'];
    this.selectedVehicle = "";
  }
  showHideDiv() { 
    this.flag = !this.flag;
  }

  setSelectedVehicle(vehicle : string) {
    this.selectedVehicle = vehicle ;
  }
  
}
