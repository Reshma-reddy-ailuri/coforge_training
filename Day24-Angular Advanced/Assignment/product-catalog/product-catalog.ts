import { Component } from '@angular/core';

@Component({
  selector: 'app-product-catalog',
  standalone: false,
  templateUrl: './product-catalog.html',
  styleUrl: './product-catalog.css',
})
export class ProductCatalog {
pid : number;
pname : string;
price : number;
category : string;
brand : string;
img:string;
width:number;
height:number;
available:string;
  constructor(){
  this.pid =101;
  this.pname = "LapTop";
  this.price = 70000;
  this.category = "Electronics";
  this.brand = "DELL";
  this.img="https://5.imimg.com/data5/DS/EU/MY-38697753/dell-laptops.jpeg";
  this.available="In-Stock";
  this.width=200;
  this.height=200;
  } 

  products = [
    { pid: 101, pname: 'Laptop', category: 'Electronics', price: 70000 },
    { pid: 102, pname: 'Mobile', category: 'Electronics', price: 30000 },
    { pid: 103, pname: 'Keyboard', category: 'Accessories', price: 1200 },
    { pid: 104, pname: 'Mouse', category: 'Accessories', price: 800 },
    { pid: 105, pname: 'Printer', category: 'Electronics', price: 15000 },
    { pid: 106, pname: 'Monitor', category: 'Electronics', price: 18000 },
    { pid: 107, pname: 'Headphones', category: 'Accessories', price: 2500 },
    { pid: 108, pname: 'Speaker', category: 'Electronics', price: 4500 },
    { pid: 109, pname: 'Smart Watch', category: 'Wearables', price: 12000 },
    { pid: 110, pname: 'Tablet', category: 'Electronics', price: 35000 }
  ];

}