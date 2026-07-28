import { Injectable, Service } from '@angular/core';

@Injectable() //to inject service and rest api
export class CalculatorService {
    add(a: number , b:number) : number { 
        return a + b;
    }
    subtract(a: number , b:number) : number { 
        return a - b;
    }
    multiply(a: number , b:number) : number { 
        return a * b;
    }
    divide(a: number , b:number) : number { 
        return a / b;
    }
}
