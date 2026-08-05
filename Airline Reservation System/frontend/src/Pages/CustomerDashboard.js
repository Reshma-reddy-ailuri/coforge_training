import Navbar from "../component/Navbar";
import Footer from "../component/Footer";
import { Link } from "react-router-dom";

function CustomerDashboard() {

    return (

        <>

            <Navbar />

            <div className="container mt-5">

                <h2 className="text-center text-success fw-bold mb-5">

                    Welcome Customer

                </h2>

                <div className="row justify-content-center g-4">

                    {/* Search Flights */}

                    <div className="col-md-4">

                        <Link
                            to="/"
                            className="text-decoration-none"
                        >

                            <div className="card shadow text-center p-4">

                                <h1>🔍</h1>

                                <h4>Search Flights</h4>

                            </div>

                        </Link>

                    </div>

                    {/* Booking */}

                    <div className="col-md-4">

                        <Link
                            to="/customer/booking"
                            className="text-decoration-none"
                        >

                            <div className="card shadow text-center p-4">

                                <h1>🎫</h1>

                                <h4>Booking</h4>

                            </div>

                        </Link>

                    </div>

                    {/* Passenger */}

                    <div className="col-md-4">

                        <Link
                            to="/customer/passenger"
                            className="text-decoration-none"
                        >

                            <div className="card shadow text-center p-4">

                                <h1>👤</h1>

                                <h4>Passenger</h4>

                            </div>

                        </Link>

                    </div>

                    {/* Wallet */}

                    <div className="col-md-4">

                        <Link
                            to="/customer/wallet"
                            className="text-decoration-none"
                        >

                            <div className="card shadow text-center p-4">

                                <h1>💳</h1>

                                <h4>Wallet</h4>

                            </div>

                        </Link>

                    </div>

                    {/* Waiting List */}

                    <div className="col-md-4">

                        <Link
                            to="/customer/waitinglist"
                            className="text-decoration-none"
                        >

                            <div className="card shadow text-center p-4">

                                <h1>⏳</h1>

                                <h4>Waiting List</h4>

                            </div>

                        </Link>

                    </div>

                </div>

            </div>

            <Footer />

        </>

    );
}

export default CustomerDashboard;