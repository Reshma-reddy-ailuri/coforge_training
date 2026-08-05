import { useNavigate } from "react-router-dom";

function FlightCard({ flight }) {

    const navigate = useNavigate();

    const bookFlight = () => {

        const user = JSON.parse(localStorage.getItem("user"));

        // Guest User
        if (user == null) {

            alert("Please Login to Book Flight");

            navigate("/login");

            return;
        }

        // Admin User
        if (user.role === "ADMIN") {

            alert("Admin cannot book flights");

            return;
        }

        // Customer User
        navigate("/customer/booking", {
            state: { flight }
        });

    };

    return (

        <div className="card shadow-lg border-0 mb-4">

            <div className="card-body">

                <div className="row align-items-center">

                    <div className="col-md-2">

                        <h5 className="fw-bold">

                            Flight #{flight.flightId}

                        </h5>

                    </div>

                    <div className="col-md-2">

                        <b>From</b>

                        <br />

                        {flight.departureAirport.airportName}

                    </div>

                    <div className="col-md-2">

                        <b>To</b>

                        <br />

                        {flight.arrivalAirport.airportName}

                    </div>

                    <div className="col-md-2">

                        <b>Departure</b>

                        <br />

                        {flight.departureTime}

                    </div>

                    <div className="col-md-2">

                        <b>Economy Fare</b>

                        <br />

                        ₹ {flight.economyFare}

                    </div>

                    <div className="col-md-2 text-center">

                        <div className="mb-2">

                            <span className="badge bg-success">

                                {flight.flightStatus}

                            </span>

                        </div>

                        <button
                            className="btn btn-primary"
                            onClick={bookFlight}
                        >
                            Book Now
                        </button>

                    </div>

                </div>

            </div>

        </div>

    );

}

export default FlightCard;