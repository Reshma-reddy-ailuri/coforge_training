const { useState } = require("react");

function Counter() {
    const[count,setCount] = useState(0);

    const increment =() => {
        setCount ( count  +  1)
    } 
    const decrement = () => {
        setCount (count - 1)
    }
    const reset = () => {
        setCount (count-count)
    }
    return(
        <>
        <p>count : {count}</p>
        <button onClick={increment} >Increment</button>
        <button onClick={decrement} >Decrement</button>
        <button onClick={reset}>Reset</button>
        <p></p>
        </>
    );
}
export default Counter;