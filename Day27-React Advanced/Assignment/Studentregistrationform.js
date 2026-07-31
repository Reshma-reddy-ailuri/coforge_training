import { useState } from "react";

function Studentregistrationform () {
    const[student,setStudent] = useState({
        name : "",
        age : "",
        gender : "",
        course : "",
        city : ""
    });
    const [submitted,setSubmitted] = useState(false);
    return (
        <>
        Name : 
        <input type= "text" value={student.name} onChange={(event) => setStudent({...student ,name : event.target.value})}></input>
        <br></br>
        Age:
        <input type= "number" value={student.age} onChange={(event) => setStudent({...student ,age : event.target.value})}></input>
        <br></br>
        Gender :
        <input
            type="radio"
            name="gender"
            value="Male"
            checked={student.gender === "Male"}
            onChange={(event) =>
            setStudent({...student,gender: event.target.value})
        }
        />
        Male

        <input
            type="radio"
            name="gender"
            value="Female"
            checked={student.gender === "Female"}
            onChange={(event) =>
            setStudent({...student,gender: event.target.value
        })
    }
        />
        Female

        <br /><br />
        <br></br>
        Course : 
        <select value={student.course} onChange={(event) => setStudent({...student ,course : event.target.value})}>
        <option value="">Select</option>
        <option>B.Tech</option>
        <option>M.Tech</option>
        <option>MCA</option>
        </select>
        <br></br>
        City: 
        <input type= "text" value={student.city} onChange={(event) => setStudent({...student ,city : event.target.value})}></input>

        <button onClick={() => setSubmitted(true)}>Submit</button>
        <br></br>
        {
            
            submitted &&
            <>
            <p>Name : {student.name}</p>
            <p>Age : {student.age}</p>
            <p>Gender : {student.gender}</p>
            <p>Course : {student.course}</p>
            <p>City : {student.city}</p>
            </>
        }
    </>
    );
}
export default Studentregistrationform;