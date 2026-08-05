import { Link } from "react-router-dom";

function Navbar() {

    const user = JSON.parse(localStorage.getItem("user") || "null");

    const logout = () => {

        localStorage.removeItem("user");

        window.location.replace("/");

    };

    return (

        <nav className="navbar navbar-expand-lg navbar-dark bg-primary shadow">

            <div className="container">

                <Link
                    className="navbar-brand fw-bold fs-2"
                    to="/">

                    ✈ Airline Reservation System

                </Link>

                <div className="ms-auto">

                    {
                        user == null ?

                            <>

                                <Link
                                    to="/login"
                                    className="btn btn-light me-2">

                                    Login

                                </Link>

                                <Link
                                    to="/register"
                                    className="btn btn-outline-light">

                                    Register

                                </Link>

                            </>

                            :

                            <>

                                <span className="text-white fw-bold me-3">

                                    Welcome, {user.fullName}

                                </span>

                                <button
                                    className="btn btn-danger"
                                    onClick={logout}>

                                    Logout

                                </button>

                            </>

                    }

                </div>

            </div>

        </nav>

    );
}

export default Navbar;