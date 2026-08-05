import Navbar from "../component/Navbar";
import Footer from "../component/Footer";
import { Link } from "react-router-dom";

function AdminDashboard() {

    return (

        <>

            <Navbar />

            <div className="container mt-5">

                <h2 className="text-center text-primary fw-bold mb-5">

                    Welcome Admin

                </h2>

                <div className="row justify-content-center g-4">

                    {/* Airport */}

                    <div className="col-md-4">

                        <Link
                            to="/admin/airports"
                            className="text-decoration-none"
                        >

                            <div className="card shadow text-center p-4">

                                <h1>🛫</h1>

                                <h4>Airport Management</h4>

                            </div>

                        </Link>

                    </div>

                    {/* Airplane */}

                    <div className="col-md-4">

                        <Link
                            to="/admin/airplanes"
                            className="text-decoration-none"
                        >

                            <div className="card shadow text-center p-4">

                                <h1>✈️</h1>

                                <h4>Airplane Management</h4>

                            </div>

                        </Link>

                    </div>

                    {/* Flight */}

                    <div className="col-md-4">

                        <Link
                            to="/admin/flights"
                            className="text-decoration-none"
                        >

                            <div className="card shadow text-center p-4">

                                <h1>🛩️</h1>

                                <h4>Flight Management</h4>

                            </div>

                        </Link>

                    </div>

                </div>

            </div>

            <Footer />

        </>

    );
}

export default AdminDashboard;