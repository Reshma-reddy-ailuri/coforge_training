import { Component } from "react";

class Calculator extends Component{
    constructor(props) {
    super(props);
    this.state =  { 
        n1 : 0,
        n2 : 0,
        result : ""
    }
    }
    //defining anonymus arrow function 
    addition = () => {
        this.setState ( {
            result : "Addition : " + (parseInt(this.state.n1) + parseInt(this.state.n2))
        });
    }
    subtraction = () => {
        this.setState ( {
            result : "Subtraction : " + (parseInt(this.state.n1) - parseInt(this.state.n2))
        });
    }
    multiplication = () => {
        this.setState ( {
            result : "Multiplication : " + (parseInt(this.state.n1) * parseInt(this.state.n2))
        })
    }
    division = () => {
        this.setState ( {
            result : "division : " + (parseInt(this.state.n1) / parseInt(this.state.n2))  
        })
    }
    render(){
        return(
            <>
                <h1>Calculator Application</h1>
                Enter Number 1 : <input type = "text" value = {this.state.n1} onChange={(event) => this.setState({n1:event.target.value})}></input>
                {/*setState is a method to change or  update the  state  values*/} 
                <br></br>
                Enter Number 2 : <input type = "text" value = {this.state.n2}  onChange={(event) => this.setState({n2:event.target.value})}></input>
                <br></br>
                <button onClick={this.addition}>Addition</button>
                <button onClick={this.subtraction}>Subtraction</button>
                <button onClick = {this.multiplication}>Multiplication</button>
                <button onClick={this.division} >Division</button>
                <br></br>
                <p> {this.state.result}</p>
            </>
        );
    }
}
export default Calculator;