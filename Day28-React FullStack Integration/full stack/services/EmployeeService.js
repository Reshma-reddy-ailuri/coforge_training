import axios from "axios";

class EmployeeService {

    constructor() {
        this.BASE_URL = "http://localhost:1111/api/v1/ems";
    }

    saveEmployee(employee) {
        return axios.post(this.BASE_URL + "/employees", employee);
    }

    updateEmployee(employee) {
        return axios.put(this.BASE_URL + "/employees/" + employee.eid, employee);
    }

    deleteEmployee(eid) {
        return axios.delete(this.BASE_URL + "/employees/" + eid);
    }

    findEmployee(eid) {
        return axios.get(this.BASE_URL + "/employees/" + eid);
    }

    findAllEmployees() {
        return axios.get(this.BASE_URL + "/employees");
    }
}

export default EmployeeService;