import { Component } from "react";

class Child2 extends Component {
    render() {
        return (
            <>
                <p>Welcome to Child2</p>
                <br></br>
                <p>Name : {this.props.name}</p> {/*Data Binding*/ }
                <br></br>
                <p>Email : {this.props.mail}</p>
            </>
        );
    }

}
//way to pass default values for class component
Child2.defaultProps = {
    name : "Sweety",
    mail : "reshma@gmail.com"
};
export default Child2;
 // if email is coming take it,else give default