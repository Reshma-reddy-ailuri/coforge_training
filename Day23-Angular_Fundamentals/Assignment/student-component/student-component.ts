import { Component } from '@angular/core';

@Component({
  selector: 'app-student-component',
  standalone: false,
  templateUrl: './student-component.html',
  styleUrl: './student-component.css',
})
export class StudentComponent {
  photo="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpfNIfHfaN2MP2WC2egu0Xf08hQkKLGZ4sE1Yt0mnYXw&s=10";
  name = "Akhila";
  course = "CSE-Data Science"
  college="VNR VJIET";
}