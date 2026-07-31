import { useState } from "react";

function Calculator1 () {
    const [n1,setN1] = useState(0);
    const[n2,setN2] = useState(0);
    const[result,setResult] = useState("");

    const addition = () => {
        setResult ("Addition : " + (parseInt(n1) + parseInt(n2)))
    } 
    const subtraction = () => {
        setResult ("Subtraction : " + (parseInt(n1) - parseInt(n2)))
    } 
    const multiplication = () => {
        setResult ("Multiplication : " + (parseInt(n1) * parseInt(n2)))
    } 
    const division = () => {
        setResult ("Division : " + (parseInt(n1) / parseInt(n2)))
    } 
    return(
        <>
        <input type = "text" value = {n1} onChange={(event) => setN1(event.target.value)}></input>
        <br></br>
        <input type = "text" value = {n2} onChange={(event) => setN2(event.target.value)}></input>
        <br></br>

        <button onClick={addition}>Addition</button>
        <button onClick={subtraction}>Subtraction</button>
        <button onClick={multiplication}>Multiplication</button>
        <button onClick={division}>Division</button>
        <br></br>
        <p>{result}</p>
        </>
    )
}
export default Calculator1;