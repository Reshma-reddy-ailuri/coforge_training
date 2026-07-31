import { Component } from "react";

class Employee extends Component{
    constructor(props) {
        super(props);
        this.state = {
            eid : 101,
            ename : "Reshma",
            esalary : 80000,
            dno : 5
        };
    }
    render() {
        return(
            <>
                <h1>React Props and States</h1>
                <p>Organization name : {this.props.org}</p>
                <p>ID: {this.state.eid}</p>
                <p>NAME : {this.state.ename}</p>
                <p>SALARY : {this.state.esalary}</p>
                <p>DNO : {this.state.dno}</p>
            </>
        );

    }
}
export default Employee;