import { Component } from "react";

class Counter extends Component {

    state = {
        n: 0,
        count: 0
    };

    increment = () => {
        this.setState({
            count: parseInt(this.state.n) + 1
        });
    };

    decrement = () => {
        this.setState({
            count: parseInt(this.state.n) - 1
        });
    };

    render() {
        return (
            <>
                <h2>Counter Application</h2>

                Enter Number :
                <input
                    type="text"
                    value={this.state.n}
                    onChange={(event) =>
                        this.setState({
                            n: event.target.value
                        })
                    }
                />

                <br /><br />

                <button onClick={this.increment}>Increment</button>

                <button onClick={this.decrement}>Decrement</button>

                <h2>Count : {this.state.count}</h2>
            </>
        );
    }
}

export default Counter;