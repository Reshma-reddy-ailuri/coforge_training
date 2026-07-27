import { Component } from '@angular/core';

@Component({
  selector: 'app-counter-application',
  standalone: false,
  templateUrl: './counter-application.html',
  styleUrl: './counter-application.css',
})
export class CounterApplication {
  count : number;

  constructor() {
    this.count = 0;
  }

  increment() {
    this.count++;
  }

  decrement() {
    this.count--;
  }
  reset() {
    this.count = 0;
  }

}
