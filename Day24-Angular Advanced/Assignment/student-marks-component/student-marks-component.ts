import { Component } from '@angular/core';

@Component({
  selector: 'app-student-marks-component',
  standalone: false,
  templateUrl: './student-marks-component.html',
  styleUrl: './student-marks-component.css',
})
export class StudentMarksComponent {
  students=[

{name:'Amit',marks:89},
{name:'Ravi',marks:22},
{name:'Priya',marks:75},
{name:'Rahul',marks:31},
{name:'Kiran',marks:55},
{name:'Divya',marks:95},
{name:'Suresh',marks:42},
{name:'Neha',marks:12},
{name:'Anil',marks:66},
{name:'Pooja',marks:30}

];

get passCount(){

return this.students.filter(s=>s.marks>=35).length;

}

get failCount(){

return this.students.filter(s=>s.marks<35).length;

}
}
