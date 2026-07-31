import { useState } from "react";

function EmployeeRegistration() {

    const [employee, setEmployee] = useState({
        eid: "",
        ename: "",
        dno: "",
        salary: ""
    });

    const [error, setError] = useState("");
    const [submitted, setSubmitted] = useState(false);

    const validate = () => {

        if (
            employee.eid === "" ||
            employee.ename === "" ||
            employee.dno === "" ||
            employee.salary === ""
        ) {
            setError("All fields are mandatory");
            setSubmitted(false);
        }
        else {
            setError("");
            setSubmitted(true);
        }

    };

    return (
        <>
            <h1>Employee Registration</h1>

            Employee Id

            <input
                type="number"
                value={employee.eid}
                onChange={(e) =>
                    setEmployee({ ...employee, eid: e.target.value })
                }
            />

            <br /><br />

            Employee Name

            <input
                type="text"
                value={employee.ename}
                onChange={(e) =>
                    setEmployee({ ...employee, ename: e.target.value })
                }
            />

            <br /><br />

            Department No

            <input
                type="number"
                value={employee.dno}
                onChange={(e) =>
                    setEmployee({ ...employee, dno: e.target.value })
                }
            />

            <br /><br />

            Salary

            <input
                type="number"
                value={employee.salary}
                onChange={(e) =>
                    setEmployee({ ...employee, salary: e.target.value })
                }
            />

            <br /><br />

            <button onClick={validate}>
                Submit
            </button>

            <br /><br />

            <span style={{ color: "red" }}>
                {error}
            </span>

            <hr />

            {
                submitted &&
                <>
                    <h2>Employee Details</h2>

                    <p>Employee Id : {employee.eid}</p>
                    <p>Employee Name : {employee.ename}</p>
                    <p>Department No : {employee.dno}</p>
                    <p>Salary : {employee.salary}</p>
                </>
            }

        </>
    );
}

export default EmployeeRegistration;