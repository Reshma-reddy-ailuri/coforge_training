import { Component, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  standalone: false,
  styleUrl: './app.css'
})
export class App {
  name : string; //declaring variables
  age : number;
  email : string;
  imagePath :string;
  width : number;
  height : number;
  myStyle = {};
  myClass : string;
  fName : string = "";
  date  = new Date();
  //Initializing 
  constructor () {
    this.name = "Reshma";
    this.age = 20;
    this.email = "Reshma@gmail.com";
    this.imagePath = "https://i.pinimg.com/736x/2d/95/e5/2d95e5886fc4c65a6778b5fee94a7d59.jpg";
    this.height = 200;
    this.width=200;
    this.myStyle = {"color" : "green", "font-size":"5px"};
    this.myClass="ZoomIn";
  }

  getAddition (a: number , b:number) : number {
    return a + b;

  }

  changeName() {
    if(this.name === "Reshma")
      this.name="Reshma Reddy";
    else
      this.name = "Reshma";  
  }

  zoomInOut() {
  if (this.myClass === "ZoomIn")
    this.myClass = "ZoomOut";
  else
    this.myClass = "ZoomIn";
}


  
}
