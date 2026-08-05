import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Navbar from "../component/Navbar";
import Footer from "../component/Footer";
import airplaneImage from "../assets/images/airplane.jpg";
import UserService from "../services/UserService";

function Login() {

    const navigate = useNavigate();

    const [user, setUser] = useState({
        email: "",
        password: ""
    });

    const [emailError, setEmailError] = useState("");
    const [passwordError, setPasswordError] = useState("");

    const login = () => {

        let flag = true;

        setEmailError("");
        setPasswordError("");

        if (user.email.trim() === "") {
            setEmailError("Email is Required");
            flag = false;
        }

        if (user.password.trim() === "") {
            setPasswordError("Password is Required");
            flag = false;
        }

        if (!flag) {
            return;
        }

        UserService.login(user)

            .then((response) => {

                // Store Logged In User
                localStorage.setItem(
                    "user",
                    JSON.stringify(response.data)
                );

                if (response.data.role === "ADMIN") {

                    navigate("/admin");

                }
                else {

                    navigate("/customer");

                }

            })

            .catch(() => {

                alert("Invalid Email or Password");

            });

    };

    return (
        <>

            <Navbar />

            <div
                className="d-flex justify-content-center align-items-center"
                style={{
                    backgroundImage: `linear-gradient(rgba(0,0,0,0.60), rgba(0,0,0,0.60)), url(${airplaneImage})`,
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                    minHeight: "90vh"
                }}
            >

                <div
                    className="card shadow-lg border-0 p-5"
                    style={{
                        width: "420px",
                        borderRadius: "15px"
                    }}
                >

                    <h2 className="text-center text-primary fw-bold mb-4">
                        Login
                    </h2>

                    <div className="mb-3">

                        <label className="form-label fw-bold">
                            Email
                        </label>

                        <input
                            type="email"
                            className="form-control"
                            placeholder="Enter Email"
                            value={user.email}
                            onChange={(e) =>
                                setUser({
                                    ...user,
                                    email: e.target.value
                                })
                            }
                        />

                        <div className="text-danger">
                            {emailError}
                        </div>

                    </div>

                    <div className="mb-4">

                        <label className="form-label fw-bold">
                            Password
                        </label>

                        <input
                            type="password"
                            className="form-control"
                            placeholder="Enter Password"
                            value={user.password}
                            onChange={(e) =>
                                setUser({
                                    ...user,
                                    password: e.target.value
                                })
                            }
                        />

                        <div className="text-danger">
                            {passwordError}
                        </div>

                    </div>

                    <button
                        className="btn btn-primary w-100"
                        onClick={login}
                    >
                        Login
                    </button>

                    <div className="text-center mt-3">

                        Don't have an account?

                        <Link
                            to="/register"
                            className="text-decoration-none ms-2"
                        >
                            Register
                        </Link>

                    </div>

                </div>

            </div>

            <Footer />

        </>
    );
}

export default Login;