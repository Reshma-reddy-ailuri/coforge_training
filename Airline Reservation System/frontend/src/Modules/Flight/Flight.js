import { useEffect, useState } from "react";
import Navbar from "../../component/Navbar";
import Footer from "../../component/Footer";

import FlightService from "../../services/FlightService";
import AirportService from "../../services/AirportService";
import AirplaneService from "../../services/AirplaneService";

function Flight() {

    const [flight, setFlight] = useState({
        flightId: "",
        airplane: {
            airplaneId: ""
        },
        departureAirport: {
            airportId: ""
        },
        arrivalAirport: {
            airportId: ""
        },
        departureTime: "",
        arrivalTime: "",
        flightStatus: "SCHEDULED",
        economyFare: "",
        businessFare: "",
        firstClassFare: ""
    });

    const [flights, setFlights] = useState([]);
    const [airports, setAirports] = useState([]);
    const [airplanes, setAirplanes] = useState([]);

    const [departureAirportError, setDepartureAirportError] = useState("");
    const [arrivalAirportError, setArrivalAirportError] = useState("");
    const [airplaneError, setAirplaneError] = useState("");
    const [departureTimeError, setDepartureTimeError] = useState("");
    const [arrivalTimeError, setArrivalTimeError] = useState("");
    const [economyFareError, setEconomyFareError] = useState("");
    const [businessFareError, setBusinessFareError] = useState("");
    const [firstClassFareError, setFirstClassFareError] = useState("");

    const [isEdit, setIsEdit] = useState(false);

    useEffect(() => {

        getAllFlights();
        getAllAirports();
        getAllAirplanes();

    }, []);

    const getAllFlights = () => {

        FlightService.findAllFlights()

            .then((response) => {

                setFlights(response.data);

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Load Flights");

            });

    };

    const getAllAirports = () => {

        AirportService.findAllAirports()

            .then((response) => {

                setAirports(response.data);

            });

    };

    const getAllAirplanes = () => {

        AirplaneService.findAllAirplanes()

            .then((response) => {

                setAirplanes(response.data);

            });

    };

    const clearForm = () => {

        setFlight({

            flightId: "",

            airplane: {
                airplaneId: ""
            },

            departureAirport: {
                airportId: ""
            },

            arrivalAirport: {
                airportId: ""
            },

            departureTime: "",

            arrivalTime: "",

            flightStatus: "SCHEDULED",

            economyFare: "",

            businessFare: "",

            firstClassFare: ""

        });

        setDepartureAirportError("");
        setArrivalAirportError("");
        setAirplaneError("");
        setDepartureTimeError("");
        setArrivalTimeError("");
        setEconomyFareError("");
        setBusinessFareError("");
        setFirstClassFareError("");

    };

    const validate = () => {

        let flag = true;

        setDepartureAirportError("");
        setArrivalAirportError("");
        setAirplaneError("");
        setDepartureTimeError("");
        setArrivalTimeError("");
        setEconomyFareError("");
        setBusinessFareError("");
        setFirstClassFareError("");

        if (flight.airplane.airplaneId === "") {

            setAirplaneError("Select Airplane");

            flag = false;

        }

        if (flight.departureAirport.airportId === "") {

            setDepartureAirportError("Select Departure Airport");

            flag = false;

        }

        if (flight.arrivalAirport.airportId === "") {

            setArrivalAirportError("Select Arrival Airport");

            flag = false;

        }

        if (flight.departureTime === "") {

            setDepartureTimeError("Departure Time is Required");

            flag = false;

        }

        if (flight.arrivalTime === "") {

            setArrivalTimeError("Arrival Time is Required");

            flag = false;

        }

        if (flight.economyFare <= 0 || flight.economyFare === "") {

            setEconomyFareError("Enter Valid Economy Fare");

            flag = false;

        }

        if (flight.businessFare <= 0 || flight.businessFare === "") {

            setBusinessFareError("Enter Valid Business Fare");

            flag = false;

        }

        if (flight.firstClassFare <= 0 || flight.firstClassFare === "") {

            setFirstClassFareError("Enter Valid First Class Fare");

            flag = false;

        }

        return flag;

    };
    const saveFlight = () => {

        if (!validate()) {
            return;
        }

        FlightService.saveFlight(flight)

            .then(() => {

                alert("Flight Added Successfully");

                clearForm();

                getAllFlights();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Save Flight");

            });

    };

    const editFlight = (flight) => {

        setFlight({

            flightId: flight.flightId,

            airplane: {
                airplaneId: flight.airplane.airplaneId
            },

            departureAirport: {
                airportId: flight.departureAirport.airportId
            },

            arrivalAirport: {
                airportId: flight.arrivalAirport.airportId
            },

            departureTime: flight.departureTime,

            arrivalTime: flight.arrivalTime,

            flightStatus: flight.flightStatus,

            economyFare: flight.economyFare,

            businessFare: flight.businessFare,

            firstClassFare: flight.firstClassFare

        });

        setIsEdit(true);

    };

    const updateFlight = () => {

        if (!validate()) {
            return;
        }

        FlightService.updateFlight(

            flight.flightId,
            flight

        )

            .then(() => {

                alert("Flight Updated Successfully");

                clearForm();

                setIsEdit(false);

                getAllFlights();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Update Flight");

            });

    };

    const deleteFlight = (flightId) => {

        if (!window.confirm("Are you sure you want to delete this Flight?")) {
            return;
        }

        FlightService.deleteFlight(flightId)

            .then(() => {

                alert("Flight Deleted Successfully");

                getAllFlights();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Delete Flight");

            });

    };
    return (
        <>
            <Navbar />

            <div className="container mt-5">

                <div className="card shadow p-4">

                    <h2 className="text-center text-primary mb-4">
                        Flight Management
                    </h2>

                    <div className="row">

                        {/* Airplane */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Airplane
                            </label>

                            <select
                                className="form-select"
                                value={flight.airplane.airplaneId}
                                onChange={(e) =>
                                    setFlight({
                                        ...flight,
                                        airplane: {
                                            airplaneId: e.target.value
                                        }
                                    })
                                }
                            >

                                <option value="">
                                    Select Airplane
                                </option>

                                {
                                    airplanes.map((airplane) => (

                                        <option
                                            key={airplane.airplaneId}
                                            value={airplane.airplaneId}
                                        >
                                            {airplane.airplaneName}
                                        </option>

                                    ))
                                }

                            </select>

                            <div className="text-danger">
                                {airplaneError}
                            </div>

                        </div>

                        {/* Departure Airport */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Departure Airport
                            </label>

                            <select
                                className="form-select"
                                value={flight.departureAirport.airportId}
                                onChange={(e) =>
                                    setFlight({
                                        ...flight,
                                        departureAirport: {
                                            airportId: e.target.value
                                        }
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
                                            {airport.airportName}
                                        </option>

                                    ))
                                }

                            </select>

                            <div className="text-danger">
                                {departureAirportError}
                            </div>

                        </div>

                        {/* Arrival Airport */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Arrival Airport
                            </label>

                            <select
                                className="form-select"
                                value={flight.arrivalAirport.airportId}
                                onChange={(e) =>
                                    setFlight({
                                        ...flight,
                                        arrivalAirport: {
                                            airportId: e.target.value
                                        }
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
                                            {airport.airportName}
                                        </option>

                                    ))
                                }

                            </select>

                            <div className="text-danger">
                                {arrivalAirportError}
                            </div>

                        </div>

                        {/* Departure Time */}

                        <div className="col-md-6 mb-3">

                            <label className="form-label">
                                Departure Time
                            </label>

                            <input
                                type="datetime-local"
                                className="form-control"
                                value={flight.departureTime}
                                onChange={(e) =>
                                    setFlight({
                                        ...flight,
                                        departureTime: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {departureTimeError}
                            </div>

                        </div>

                        {/* Arrival Time */}

                        <div className="col-md-6 mb-3">

                            <label className="form-label">
                                Arrival Time
                            </label>

                            <input
                                type="datetime-local"
                                className="form-control"
                                value={flight.arrivalTime}
                                onChange={(e) =>
                                    setFlight({
                                        ...flight,
                                        arrivalTime: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {arrivalTimeError}
                            </div>

                        </div>

                        {/* Flight Status */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Flight Status
                            </label>

                            <select
                                className="form-select"
                                value={flight.flightStatus}
                                onChange={(e) =>
                                    setFlight({
                                        ...flight,
                                        flightStatus: e.target.value
                                    })
                                }
                            >

                                <option value="SCHEDULED">SCHEDULED</option>
                                <option value="DELAYED">DELAYED</option>
                                <option value="COMPLETED">COMPLETED</option>
                                <option value="CANCELLED">CANCELLED</option>

                            </select>

                        </div>

                        {/* Economy Fare */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Economy Fare
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={flight.economyFare}
                                onChange={(e) =>
                                    setFlight({
                                        ...flight,
                                        economyFare: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {economyFareError}
                            </div>

                        </div>

                        {/* Business Fare */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Business Fare
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={flight.businessFare}
                                onChange={(e) =>
                                    setFlight({
                                        ...flight,
                                        businessFare: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {businessFareError}
                            </div>

                        </div>

                        {/* First Class Fare */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                First Class Fare
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={flight.firstClassFare}
                                onChange={(e) =>
                                    setFlight({
                                        ...flight,
                                        firstClassFare: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {firstClassFareError}
                            </div>

                        </div>

                    </div>

                    {
                        isEdit ?

                            <button
                                className="btn btn-warning"
                                onClick={updateFlight}
                            >
                                Update Flight
                            </button>

                            :

                            <button
                                className="btn btn-success"
                                onClick={saveFlight}
                            >
                                Save Flight
                            </button>

                    }

                    <hr />

                    <h3 className="text-center text-primary">
                        Flight List
                    </h3>
                    <table className="table table-bordered table-hover mt-3">

                        <thead className="table-dark">

                            <tr>

                                <th>ID</th>
                                <th>Airplane</th>
                                <th>Departure</th>
                                <th>Arrival</th>
                                <th>Departure Time</th>
                                <th>Arrival Time</th>
                                <th>Status</th>
                                <th>Economy</th>
                                <th>Business</th>
                                <th>First Class</th>
                                <th>Edit</th>
                                <th>Delete</th>

                            </tr>

                        </thead>

                        <tbody>

                            {

                                flights.map((flight) => (

                                    <tr key={flight.flightId}>

                                        <td>
                                            {flight.flightId}
                                        </td>

                                        <td>
                                            {flight.airplane.airplaneName}
                                        </td>

                                        <td>
                                            {flight.departureAirport.airportName}
                                        </td>

                                        <td>
                                            {flight.arrivalAirport.airportName}
                                        </td>

                                        <td>
                                            {flight.departureTime}
                                        </td>

                                        <td>
                                            {flight.arrivalTime}
                                        </td>

                                        <td>
                                            {flight.flightStatus}
                                        </td>

                                        <td>
                                            ₹ {flight.economyFare}
                                        </td>

                                        <td>
                                            ₹ {flight.businessFare}
                                        </td>

                                        <td>
                                            ₹ {flight.firstClassFare}
                                        </td>

                                        <td>

                                            <button
                                                className="btn btn-warning btn-sm"
                                                onClick={() =>
                                                    editFlight(flight)
                                                }
                                            >
                                                Edit
                                            </button>

                                        </td>

                                        <td>

                                            <button
                                                className="btn btn-danger btn-sm"
                                                onClick={() =>
                                                    deleteFlight(flight.flightId)
                                                }
                                            >
                                                Delete
                                            </button>

                                        </td>

                                    </tr>

                                ))

                            }

                        </tbody>

                    </table>

                </div>

            </div>

            <Footer />

        </>

    );

}

export default Flight;