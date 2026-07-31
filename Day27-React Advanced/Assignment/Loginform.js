import { useState } from "react";

function Loginform() {

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const [emailError, setEmailError] = useState("");
    const [passwordError, setPasswordError] = useState("");

    const validate = () => {

        let valid = true;

        if (email === "") {
            setEmailError("Email cannot be empty");
            valid = false;
        }
        else {
            setEmailError("");
        }

        if (password.length < 6) {
            setPasswordError("Password must contain at least 6 characters");
            valid = false;
        }
        else {
            setPasswordError("");
        }

        if (valid) {
            alert("Login Successful");
        }

    };

    return (
        <>
            <h1>Login Form</h1>

            Email :

            <input
                type="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />

            <br />

            <span style={{ color: "red" }}>
                {emailError}
            </span>

            <br /><br />

            Password :

            <input
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />

            <br />

            <span style={{ color: "red" }}>
                {passwordError}
            </span>

            <br /><br />

            <button onClick={validate}>
                Login
            </button>

        </>
    );
}

export default Loginform;