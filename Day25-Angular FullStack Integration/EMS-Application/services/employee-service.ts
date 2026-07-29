import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../models/Employee';

@Injectable()
export class EmployeeService {

    emsurl: string = "http://localhost:1111/api/v1/ems";
    constructor(private httpClient: HttpClient) {

    }

    saveEmployee(employee: Employee): Observable<string> {
        return this.httpClient.post(this.emsurl + "/employees", employee, {
            responseType: 'text'
        });
    }

    updateEmployee(employee: Employee): Observable<string> {
        return this.httpClient.put(this.emsurl + "/employees/" + employee.eid, employee, {
            responseType: 'text'
        });
    }

    deleteEmployee(eid: number): Observable<string> {
        return this.httpClient.delete(this.emsurl + "/employees/" + eid, {
            responseType: 'text'
        });
    }

    findEmployee(eid: number): Observable<Employee> {
        return this.httpClient.get<Employee>(this.emsurl + "/employees/" + eid);
    }

    findAllEmployees(): Observable<Employee[]> {
        return this.httpClient.get<Employee[]>(this.emsurl + "/employees");
    }


}