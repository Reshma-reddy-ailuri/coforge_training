import { useEffect, useState } from "react";
import Navbar from "../../component/Navbar";
import Footer from "../../component/Footer";
import AirportService from "../../services/AirportService";

function Airport() {

    const [airport, setAirport] = useState({
        airportId: "",
        airportName: "",
        city: "",
        airportCode: ""
    });

    const [airports, setAirports] = useState([]);

    const [airportNameError, setAirportNameError] = useState("");
    const [cityError, setCityError] = useState("");
    const [airportCodeError, setAirportCodeError] = useState("");

    const [isEdit, setIsEdit] = useState(false);

    useEffect(() => {
        getAllAirports();
    }, []);

    const getAllAirports = () => {

        AirportService.findAllAirports()
            .then((response) => {

                setAirports(response.data);

            })
            .catch(() => {

                alert("Unable to Fetch Airports");

            });

    };

    const validate = () => {

        let flag = true;

        setAirportNameError("");
        setCityError("");
        setAirportCodeError("");

        if (airport.airportName.trim() === "") {

            setAirportNameError("Airport Name is Required");
            flag = false;

        }

        if (airport.city.trim() === "") {

            setCityError("City is Required");
            flag = false;

        }

        if (airport.airportCode.trim() === "") {

            setAirportCodeError("Airport Code is Required");
            flag = false;

        }

        return flag;

    };

    const saveAirport = () => {

        if (!validate()) {
            return;
        }

        AirportService.saveAirport(airport)

            .then(() => {

                alert("Airport Added Successfully");

                clearForm();

                getAllAirports();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Save");

            });

    };

    const updateAirport = () => {

        if (!validate()) {
            return;
        }

        AirportService.updateAirport(
            airport.airportId,
            airport
        )

            .then(() => {

                alert("Airport Updated Successfully");

                clearForm();

                getAllAirports();

                setIsEdit(false);

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Update");

            });

    };

    const editAirport = (airport) => {

        setAirport(airport);

        setIsEdit(true);

    };

    const deleteAirport = (id) => {

        if (!window.confirm("Delete Airport?")) {
            return;
        }

        AirportService.deleteAirport(id)

            .then(() => {

                alert("Airport Deleted Successfully");

                getAllAirports();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Delete");

            });

    };

    const clearForm = () => {

        setAirport({

            airportId: "",
            airportName: "",
            city: "",
            airportCode: ""

        });

    };

    return (

        <>

            <Navbar />

            <div className="container mt-5">

                <div className="card shadow p-4">

                    <h2 className="text-center text-primary mb-4">

                        Airport Management

                    </h2>

                    <div className="mb-3">

                        <label className="form-label">

                            Airport Name

                        </label>

                        <input
                            className="form-control"
                            value={airport.airportName}
                            onChange={(e) =>
                                setAirport({
                                    ...airport,
                                    airportName: e.target.value
                                })
                            }
                        />

                        <div className="text-danger">

                            {airportNameError}

                        </div>

                    </div>

                    <div className="mb-3">

                        <label className="form-label">

                            City

                        </label>

                        <input
                            className="form-control"
                            value={airport.city}
                            onChange={(e) =>
                                setAirport({
                                    ...airport,
                                    city: e.target.value
                                })
                            }
                        />

                        <div className="text-danger">

                            {cityError}

                        </div>

                    </div>

                    <div className="mb-3">

                        <label className="form-label">

                            Airport Code

                        </label>

                        <input
                            className="form-control"
                            value={airport.airportCode}
                            onChange={(e) =>
                                setAirport({
                                    ...airport,
                                    airportCode: e.target.value
                                })
                            }
                        />

                        <div className="text-danger">

                            {airportCodeError}

                        </div>

                    </div>

                    {
                        isEdit ?

                            <button
                                className="btn btn-warning"
                                onClick={updateAirport}
                            >

                                Update Airport

                            </button>

                            :

                            <button
                                className="btn btn-success"
                                onClick={saveAirport}
                            >

                                Save Airport

                            </button>
                    }

                    <hr />

                    <h3 className="text-center text-primary">

                        Airport List

                    </h3>

                    <table className="table table-bordered table-hover">

                        <thead className="table-dark">

                            <tr>

                                <th>ID</th>
                                <th>Name</th>
                                <th>City</th>
                                <th>Code</th>
                                <th>Edit</th>
                                <th>Delete</th>

                            </tr>

                        </thead>

                        <tbody>

                            {

                                airports.map((airport) => (

                                    <tr key={airport.airportId}>

                                        <td>{airport.airportId}</td>

                                        <td>{airport.airportName}</td>

                                        <td>{airport.city}</td>

                                        <td>{airport.airportCode}</td>

                                        <td>

                                            <button
                                                className="btn btn-warning btn-sm"
                                                onClick={() =>
                                                    editAirport(airport)
                                                }
                                            >

                                                Edit

                                            </button>

                                        </td>

                                        <td>

                                            <button
                                                className="btn btn-danger btn-sm"
                                                onClick={() =>
                                                    deleteAirport(airport.airportId)
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

export default Airport;