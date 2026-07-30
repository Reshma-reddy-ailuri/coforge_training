import './App.css';
import Calculator from './Calculator';
import Calculator1 from './Calculator1';
import Child2 from './Child2';
import Child1 from './Child1';
import Counter from './Counter';
import Employee from './Employee';
import Even from './Even';
import Odd from './Odd';
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import Home from './Home';
import About from './About';
import Contact from './Contact';
function App(props) {
  return(
    <>
    <BrowserRouter>
      <nav>
        <Link to="/">Home</Link> |{" "}
        <Link to="/about">About</Link> |{" "}
        <Link to="/contact">Contact</Link>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />} />
      </Routes>
    </BrowserRouter>
    </>

  );
}
  {/*let n = props.n;
  return (
    <>
    {n % 2 ==0 ? <Even n = {n}></Even> : <Odd n = {n}></Odd>}
    </>
  );
} */}
  {/* return (
    <>
    {n % 2 == 0 && <Even n = {n}></Even>}
    {n % 2 !== 0 && <Odd n = {n}></Odd>}
    </>
  );
} */}
     {/* if (n%2 == 0)
      return<Even n = {n}></Even> 
    else 
      return <Odd n = {n}></Odd> */}
  {/* return (
   <> 
     <h1>Welcome to react</h1>
     <b>Akhila</b>
     <br></br>
     <Children1 location="Hyderabad"></Children1>
     <br></br>
     <Child2 name="Akhila"></Child2>
     <p>college:{props.college}</p>
     <Employee org = "Coforge"></Employee>
     <Calculator></Calculator>
     <Counter></Counter>
     <Calculator1></Calculator1>
     </>
  );
}*/}
export default App;