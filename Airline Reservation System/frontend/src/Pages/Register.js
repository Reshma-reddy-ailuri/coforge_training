import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import Navbar from "../component/Navbar";
import Footer from "../component/Footer";
import airplaneImage from "../assets/images/airplane.jpg";
import UserService from "../services/UserService";

function Register() {

    const navigate = useNavigate();

    const [user, setUser] = useState({
        fullName: "",
        email: "",
        password: "",
        phoneNumber: "",
        role: "CUSTOMER",
        isActive: true
    });
    const [confirmPassword, setConfirmPassword] = useState("");

    const [fullNameError, setFullNameError] = useState("");
    const [emailError, setEmailError] = useState("");
    const [passwordError, setPasswordError] = useState("");
    const [confirmPasswordError, setConfirmPasswordError] = useState("");
    const [phoneError, setPhoneError] = useState("");

    const register = () => {

        let flag = true;

        setFullNameError("");
        setEmailError("");
        setPasswordError("");
        setConfirmPasswordError("");
        setPhoneError("");

        if (user.fullName.trim() === "") {
            setFullNameError("Full Name is Required");
            flag = false;
        }

        if (user.email.trim() === "") {
            setEmailError("Email is Required");
            flag = false;
        }

        if (user.phoneNumber.trim() === "") {
            setPhoneError("Phone Number is Required");
            flag = false;
        }
        else if (!/^[0-9]{10}$/.test(user.phoneNumber)) {
            setPhoneError("Phone Number should contain 10 digits");
            flag = false;
        }

        if (user.password.trim() === "") {
            setPasswordError("Password is Required");
            flag = false;
        }
        else if (user.password.length < 6) {
            setPasswordError("Password should contain at least 6 characters");
            flag = false;
        }

        if (confirmPassword.trim() === "") {
            setConfirmPasswordError("Confirm Password is Required");
            flag = false;
        }
        else if (confirmPassword !== user.password) {
            setConfirmPasswordError("Passwords do not match");
            flag = false;
        }

        if (!flag) {
            return;
        }

        UserService.register(user)

            .then(() => {

                alert("Registration Successfull . please login");

                navigate("/login");

            })

            .catch((error) => {

                alert(error.response?.data || "Registration Failed");

            });

    };

    return (
        <>
            <Navbar />

            <div
                className="d-flex justify-content-center align-items-center"
                style={{
                    backgroundImage: `linear-gradient(rgba(0,0,0,0.60),rgba(0,0,0,0.60)), url(${airplaneImage})`,
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                    minHeight: "90vh"
                }}
            >

                <div
                    className="card shadow-lg border-0 p-5"
                    style={{
                        width: "500px",
                        borderRadius: "15px"
                    }}
                >

                    <h2 className="text-center text-primary fw-bold mb-4">
                        Register
                    </h2>

                    <div className="mb-3">

                        <label className="form-label fw-bold">
                            Full Name
                        </label>

                        <input
                            type="text"
                            className="form-control"
                            placeholder="Enter Full Name"
                            value={user.fullName}
                            onChange={(e) =>
                                setUser({
                                    ...user,
                                    fullName: e.target.value
                                })
                            }
                        />

                        <div className="text-danger">
                            {fullNameError}
                        </div>

                    </div>

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

                    <div className="mb-3">

                        <label className="form-label fw-bold">
                            Phone Number
                        </label>

                        <input
                            type="text"
                            className="form-control"
                            placeholder="Enter Phone Number"
                            value={user.phoneNumber}
                            onChange={(e) =>
                                setUser({
                                    ...user,
                                    phoneNumber: e.target.value
                                })
                            }
                        />

                        <div className="text-danger">
                            {phoneError}
                        </div>

                    </div>

                    <div className="mb-3">

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

                    <div className="mb-4">

                        <label className="form-label fw-bold">
                            Confirm Password
                        </label>

                        <input
                            type="password"
                            className="form-control"
                            placeholder="Confirm Password"
                            value={confirmPassword}
                            onChange={(e) =>
                                setConfirmPassword(e.target.value)
                            }
                        />

                        <div className="text-danger">
                            {confirmPasswordError}
                        </div>

                    </div>

                    <button
                        className="btn btn-success w-100"
                        onClick={register}
                    >
                        Register
                    </button>

                    <div className="text-center mt-3">

                        Already have an account?

                        <Link
                            to="/login"
                            className="text-decoration-none ms-2"
                        >
                            Login
                        </Link>

                    </div>

                </div>

            </div>

            <Footer />

        </>
    );
}

export default Register;