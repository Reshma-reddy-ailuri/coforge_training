import { useEffect, useState } from "react";
import Navbar from "../component/Navbar";
import Footer from "../component/Footer";
import FlightCard from "../component/FlightCard";
import airplaneImage from "../assets/images/airplane.jpg";
import AirportService from "../services/AirportService";
import FlightService from "../services/FlightService";

function Home() {

    const [airports, setAirports] = useState([]);
    const [flights, setFlights] = useState([]);

    const [search, setSearch] = useState({
        departureAirportId: "",
        arrivalAirportId: "",
        journeyDate: ""
    });

    useEffect(() => {

        AirportService.findAllAirports()
            .then((response) => {
                setAirports(response.data);
            })
            .catch(() => {
                alert("Unable to Load Airports");
            });

    }, []);

    const searchFlights = () => {

        if (
            search.departureAirportId === "" ||
            search.arrivalAirportId === "" ||
            search.journeyDate === ""
        ) {

            alert("Please Select From, To and Journey Date");
            return;

        }

        FlightService.searchFlights(
            search.departureAirportId,
            search.arrivalAirportId,
            search.journeyDate + "T00:00:00"
        )
            .then((response) => {

                setFlights(response.data);

                if (response.data.length === 0) {
                    alert("No Flights Found");
                }

            })
            .catch((error) => {

                alert(error.response?.data || "Unable to Search Flights");

            });

    };

    return (

        <>

            <Navbar />

            {/* Hero Section */}

            <div
                className="d-flex justify-content-center align-items-center text-center"
                style={{
                    backgroundImage: `linear-gradient(rgba(0,0,0,0.60), rgba(0,0,0,0.60)), url(${airplaneImage})`,
                    backgroundSize: "cover",
                    backgroundPosition: "center",
                    height: "450px"
                }}
            >

                <div>

                    <h1 className="display-4 fw-bold text-white">
                        ✈ Airline Reservation System
                    </h1>

                    <p className="lead text-white">
                        Book Flights Across the World
                    </p>

                </div>

            </div>

            {/* Search Card */}

            <div className="container">

                <div
                    className="card shadow-lg border-0 p-5"
                    style={{
                        marginTop: "-60px",
                        borderRadius: "15px"
                    }}
                >

                    <h2 className="text-center text-primary fw-bold mb-4">
                        ✈ Find Your Flight
                    </h2>

                    <div className="row">

                        <div className="col-md-3">

                            <label className="form-label fw-bold">
                                From
                            </label>

                            <select
                                className="form-select"
                                value={search.departureAirportId}
                                onChange={(e) =>
                                    setSearch({
                                        ...search,
                                        departureAirportId: e.target.value
                                    })
                                }
                            >

                                <option value="">
                                    Select Airport
                                </option>

                                {
                                    airports.map((airport) => (

                                        <option
                                            key={airport.airportId}
                                            value={airport.airportId}
                                        >
                                            {airport.airportName} ({airport.airportCode})
                                        </option>

                                    ))
                                }

                            </select>

                        </div>

                        <div className="col-md-3">

                            <label className="form-label fw-bold">
                                To
                            </label>

                            <select
                                className="form-select"
                                value={search.arrivalAirportId}
                                onChange={(e) =>
                                    setSearch({
                                        ...search,
                                        arrivalAirportId: e.target.value
                                    })
                                }
                            >

                                <option value="">
                                    Select Airport
                                </option>

                                {
                                    airports.map((airport) => (

                                        <option
                                            key={airport.airportId}
                                            value={airport.airportId}
                                        >
                                            {airport.airportName} ({airport.airportCode})
                                        </option>

                                    ))
                                }

                            </select>

                        </div>

                        <div className="col-md-3">

                            <label className="form-label fw-bold">
                                Journey Date
                            </label>

                            <input
                                type="date"
                                className="form-control"
                                value={search.journeyDate}
                                onChange={(e) =>
                                    setSearch({
                                        ...search,
                                        journeyDate: e.target.value
                                    })
                                }
                            />

                        </div>

                        <div className="col-md-3 d-flex align-items-end">

                            <button
                                className="btn btn-primary w-100"
                                onClick={searchFlights}
                            >
                                🔍 Search Flights
                            </button>

                        </div>

                    </div>

                </div>

            </div>

            {/* Flight List */}

            <div className="container mt-5">

                <h2 className="text-center text-primary fw-bold mb-4">
                    Available Flights
                </h2>

                {
                    flights.length > 0 ?

                        flights.map((flight) => (

                            <FlightCard
                                key={flight.flightId}
                                flight={flight}
                            />

                        ))

                        :

                        <div className="alert alert-info text-center">
                            Search flights to view available flights.
                        </div>
                }

            </div>

            <Footer />

        </>

    );

}

export default Home;