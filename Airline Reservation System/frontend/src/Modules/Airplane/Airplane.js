import { useEffect, useState } from "react";
import Navbar from "../../component/Navbar";
import Footer from "../../component/Footer";
import AirplaneService from "../../services/AirplaneService";

function Airplane() {

    const [airplane, setAirplane] = useState({
        airplaneId: "",
        airplaneName: "",
        airplaneRegistrationNo: "",
        airplaneDescription: "",
        totalSeat: "",
        totalEconomySeat: "",
        totalBusinessSeat: "",
        totalFirstClassSeat: ""
    });

    const [airplanes, setAirplanes] = useState([]);

    const [airplaneNameError, setAirplaneNameError] = useState("");
    const [registrationError, setRegistrationError] = useState("");
    const [descriptionError, setDescriptionError] = useState("");
    const [totalSeatError, setTotalSeatError] = useState("");
    const [economySeatError, setEconomySeatError] = useState("");
    const [businessSeatError, setBusinessSeatError] = useState("");
    const [firstClassSeatError, setFirstClassSeatError] = useState("");

    const [isEdit, setIsEdit] = useState(false);

    useEffect(() => {

        getAllAirplanes();

    }, []);

    const getAllAirplanes = () => {

        AirplaneService.findAllAirplanes()

            .then((response) => {

                setAirplanes(response.data);

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Fetch Airplanes");

            });

    };

    const clearForm = () => {

        setAirplane({

            airplaneId: "",
            airplaneName: "",
            airplaneRegistrationNo: "",
            airplaneDescription: "",
            totalSeat: "",
            totalEconomySeat: "",
            totalBusinessSeat: "",
            totalFirstClassSeat: ""

        });

        setAirplaneNameError("");
        setRegistrationError("");
        setDescriptionError("");
        setTotalSeatError("");
        setEconomySeatError("");
        setBusinessSeatError("");
        setFirstClassSeatError("");

    };

    const validate = () => {

        let flag = true;

        setAirplaneNameError("");
        setRegistrationError("");
        setDescriptionError("");
        setTotalSeatError("");
        setEconomySeatError("");
        setBusinessSeatError("");
        setFirstClassSeatError("");

        if (airplane.airplaneName.trim() === "") {

            setAirplaneNameError("Airplane Name is Required");
            flag = false;

        }

        if (airplane.airplaneRegistrationNo.trim() === "") {

            setRegistrationError("Registration Number is Required");
            flag = false;

        }

        if (airplane.airplaneDescription.trim() === "") {

            setDescriptionError("Description is Required");
            flag = false;

        }

        if (airplane.totalSeat === "" || airplane.totalSeat <= 0) {

            setTotalSeatError("Total Seats should be greater than 0");
            flag = false;

        }

        if (airplane.totalEconomySeat === "" || airplane.totalEconomySeat <= 0) {

            setEconomySeatError("Economy Seats should be greater than 0");
            flag = false;

        }

        if (airplane.totalBusinessSeat === "" || airplane.totalBusinessSeat <= 0) {

            setBusinessSeatError("Business Seats should be greater than 0");
            flag = false;

        }

        if (airplane.totalFirstClassSeat === "" || airplane.totalFirstClassSeat <= 0) {

            setFirstClassSeatError("First Class Seats should be greater than 0");
            flag = false;

        }

        return flag;

    };
    const saveAirplane = () => {

        if (!validate()) {
            return;
        }

        AirplaneService.saveAirplane(airplane)

            .then(() => {

                alert("Airplane Added Successfully");

                clearForm();

                getAllAirplanes();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Save Airplane");

            });

    };

    const editAirplane = (airplane) => {

        setAirplane({

            airplaneId: airplane.airplaneId,
            airplaneName: airplane.airplaneName,
            airplaneRegistrationNo: airplane.airplaneRegistrationNo,
            airplaneDescription: airplane.airplaneDescription,
            totalSeat: airplane.totalSeat,
            totalEconomySeat: airplane.totalEconomySeat,
            totalBusinessSeat: airplane.totalBusinessSeat,
            totalFirstClassSeat: airplane.totalFirstClassSeat

        });

        setIsEdit(true);

    };

    const updateAirplane = () => {

        if (!validate()) {
            return;
        }

        AirplaneService.updateAirplane(
            airplane.airplaneId,
            airplane
        )

            .then(() => {

                alert("Airplane Updated Successfully");

                clearForm();

                setIsEdit(false);

                getAllAirplanes();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Update Airplane");

            });

    };

    const deleteAirplane = (airplaneId) => {

        if (!window.confirm("Are you sure you want to delete this airplane?")) {
            return;
        }

        AirplaneService.deleteAirplane(airplaneId)

            .then(() => {

                alert("Airplane Deleted Successfully");

                getAllAirplanes();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Delete Airplane");

            });

    };
    return (
        <>
            <Navbar />

            <div className="container mt-5">

                <div className="card shadow p-4">

                    <h2 className="text-center text-primary mb-4">
                        Airplane Management
                    </h2>

                    <div className="row">

                        <div className="col-md-6 mb-3">

                            <label className="form-label">
                                Airplane Name
                            </label>

                            <input
                                type="text"
                                className="form-control"
                                value={airplane.airplaneName}
                                onChange={(e) =>
                                    setAirplane({
                                        ...airplane,
                                        airplaneName: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {airplaneNameError}
                            </div>

                        </div>

                        <div className="col-md-6 mb-3">

                            <label className="form-label">
                                Registration Number
                            </label>

                            <input
                                type="text"
                                className="form-control"
                                value={airplane.airplaneRegistrationNo}
                                onChange={(e) =>
                                    setAirplane({
                                        ...airplane,
                                        airplaneRegistrationNo: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {registrationError}
                            </div>

                        </div>

                        <div className="col-md-12 mb-3">

                            <label className="form-label">
                                Description
                            </label>

                            <textarea
                                className="form-control"
                                rows="3"
                                value={airplane.airplaneDescription}
                                onChange={(e) =>
                                    setAirplane({
                                        ...airplane,
                                        airplaneDescription: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {descriptionError}
                            </div>

                        </div>

                        <div className="col-md-3 mb-3">

                            <label className="form-label">
                                Total Seats
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={airplane.totalSeat}
                                onChange={(e) =>
                                    setAirplane({
                                        ...airplane,
                                        totalSeat: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {totalSeatError}
                            </div>

                        </div>

                        <div className="col-md-3 mb-3">

                            <label className="form-label">
                                Economy Seats
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={airplane.totalEconomySeat}
                                onChange={(e) =>
                                    setAirplane({
                                        ...airplane,
                                        totalEconomySeat: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {economySeatError}
                            </div>

                        </div>

                        <div className="col-md-3 mb-3">

                            <label className="form-label">
                                Business Seats
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={airplane.totalBusinessSeat}
                                onChange={(e) =>
                                    setAirplane({
                                        ...airplane,
                                        totalBusinessSeat: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {businessSeatError}
                            </div>

                        </div>

                        <div className="col-md-3 mb-3">

                            <label className="form-label">
                                First Class Seats
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={airplane.totalFirstClassSeat}
                                onChange={(e) =>
                                    setAirplane({
                                        ...airplane,
                                        totalFirstClassSeat: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {firstClassSeatError}
                            </div>

                        </div>

                    </div>

                    {
                        isEdit ?

                            <button
                                className="btn btn-warning"
                                onClick={updateAirplane}
                            >
                                Update Airplane
                            </button>

                            :

                            <button
                                className="btn btn-success"
                                onClick={saveAirplane}
                            >
                                Save Airplane
                            </button>

                    }

                    <hr />

                    <h3 className="text-center text-primary">
                        Airplane List
                    </h3>
                    <table className="table table-bordered table-hover mt-3">

                        <thead className="table-dark">

                            <tr>

                                <th>ID</th>
                                <th>Name</th>
                                <th>Registration No</th>
                                <th>Description</th>
                                <th>Total Seats</th>
                                <th>Economy</th>
                                <th>Business</th>
                                <th>First Class</th>
                                <th>Edit</th>
                                <th>Delete</th>

                            </tr>

                        </thead>

                        <tbody>

                            {

                                airplanes.map((airplane) => (

                                    <tr key={airplane.airplaneId}>

                                        <td>{airplane.airplaneId}</td>

                                        <td>{airplane.airplaneName}</td>

                                        <td>{airplane.airplaneRegistrationNo}</td>

                                        <td>{airplane.airplaneDescription}</td>

                                        <td>{airplane.totalSeat}</td>

                                        <td>{airplane.totalEconomySeat}</td>

                                        <td>{airplane.totalBusinessSeat}</td>

                                        <td>{airplane.totalFirstClassSeat}</td>

                                        <td>

                                            <button
                                                className="btn btn-warning btn-sm"
                                                onClick={() =>
                                                    editAirplane(airplane)
                                                }
                                            >
                                                Edit
                                            </button>

                                        </td>

                                        <td>

                                            <button
                                                className="btn btn-danger btn-sm"
                                                onClick={() =>
                                                    deleteAirplane(airplane.airplaneId)
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

export default Airplane;