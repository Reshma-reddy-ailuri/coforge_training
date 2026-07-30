function Employee(props) {
    return (
        <div className="card m-3 shadow" style={{ width: "22rem" }}>
            <div className="card-header bg-primary text-white">
                Employee Details
            </div>

            <div className="card-body">

                <p><b>Employee ID :</b> {props.id}</p>

                <p><b>Employee Name :</b> {props.name}</p>

                <p><b>Department :</b> {props.department}</p>

                <p><b>Designation :</b> {props.designation}</p>

                <p><b>Salary :</b> ${props.salary}</p>

            </div>
        </div>
    );
}

export default Employee;