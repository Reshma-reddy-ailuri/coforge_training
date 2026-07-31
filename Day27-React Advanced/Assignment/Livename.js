import { useState } from "react";

function Livename () {
    const [name,setName] = useState("");
    return(
        <>
        <h1>Live Name Preview</h1>
        <input type="text" placeholder="Enter Your Name" value = {name} onChange={(event)=>setName(event.target.value)}></input>
        <br></br>
        <h2>Welcome :  {name || "Guest"}</h2>
        </>
    );
}
export default Livename;