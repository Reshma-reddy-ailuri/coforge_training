import { useEffect, useState } from "react";
import Navbar from "../../component/Navbar";
import Footer from "../../component/Footer";
import PassengerService from "../../services/PassengerService";
import BookingService from "../../services/BookingService";

function Passenger() {

    const [passenger, setPassenger] = useState({

        passengerId: "",

        bookingId: "",

        passengerName: "",

        age: "",

        gender: "",

        seatNumber: ""

    });

    const [passengers, setPassengers] = useState([]);

    const [bookings, setBookings] = useState([]);

    const [bookingIdError, setBookingIdError] = useState("");

    const [passengerNameError, setPassengerNameError] = useState("");

    const [ageError, setAgeError] = useState("");

    const [genderError, setGenderError] = useState("");

    const [seatNumberError, setSeatNumberError] = useState("");

    const [isEdit, setIsEdit] = useState(false);

    useEffect(() => {

        getAllPassengers();

        getAllBookings();

    }, []);

    const getAllPassengers = () => {

        PassengerService.findAllPassengers()

            .then((response) => {

                setPassengers(response.data);

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Load Passengers");

            });

    };

    const getAllBookings = () => {

        BookingService.findAllBookings()

            .then((response) => {

                setBookings(response.data);

            });

    };

    const clearForm = () => {

        setPassenger({

            passengerId: "",

            bookingId: "",

            passengerName: "",

            age: "",

            gender: "",

            seatNumber: ""

        });

        setBookingIdError("");

        setPassengerNameError("");

        setAgeError("");

        setGenderError("");

        setSeatNumberError("");

    };

    const validate = () => {

        let flag = true;

        setBookingIdError("");

        setPassengerNameError("");

        setAgeError("");

        setGenderError("");

        setSeatNumberError("");

        if (passenger.bookingId === "") {

            setBookingIdError("Select Booking");

            flag = false;

        }

        if (passenger.passengerName.trim() === "") {

            setPassengerNameError("Passenger Name is Required");

            flag = false;

        }

        if (passenger.age <= 0 || passenger.age === "") {

            setAgeError("Enter Valid Age");

            flag = false;

        }

        if (passenger.gender === "") {

            setGenderError("Select Gender");

            flag = false;

        }

        if (passenger.seatNumber.trim() === "") {

            setSeatNumberError("Seat Number is Required");

            flag = false;

        }

        return flag;

    };
    const savePassenger = () => {

        if (!validate()) {
            return;
        }

        PassengerService.savePassenger(passenger)

            .then(() => {

                alert("Passenger Added Successfully");

                clearForm();

                getAllPassengers();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Save Passenger");

            });

    };

    const editPassenger = (passenger) => {

        setPassenger({

            passengerId: passenger.passengerId,

            bookingId: passenger.bookingId,

            passengerName: passenger.passengerName,

            age: passenger.age,

            gender: passenger.gender,

            seatNumber: passenger.seatNumber

        });

        setIsEdit(true);

    };

    const updatePassenger = () => {

        if (!validate()) {
            return;
        }

        PassengerService.updatePassenger(

            passenger.passengerId,

            passenger

        )

            .then(() => {

                alert("Passenger Updated Successfully");

                clearForm();

                setIsEdit(false);

                getAllPassengers();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Update Passenger");

            });

    };

    const deletePassenger = (passengerId) => {

        if (!window.confirm("Are you sure you want to delete this Passenger?")) {
            return;
        }

        PassengerService.deletePassenger(passengerId)

            .then(() => {

                alert("Passenger Deleted Successfully");

                getAllPassengers();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Delete Passenger");

            });

    };
    return (
        <>
            <Navbar />

            <div className="container mt-5">

                <div className="card shadow p-4">

                    <h2 className="text-center text-primary mb-4">
                        Passenger Management
                    </h2>

                    <div className="row">

                        {/* Booking */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Booking
                            </label>

                            <select
                                className="form-select"
                                value={passenger.bookingId}
                                onChange={(e) =>
                                    setPassenger({
                                        ...passenger,
                                        bookingId: e.target.value
                                    })
                                }
                            >

                                <option value="">
                                    Select Booking
                                </option>

                                {
                                    bookings.map((booking) => (

                                        <option
                                            key={booking.bookingId}
                                            value={booking.bookingId}
                                        >
                                            Booking #{booking.bookingId}
                                        </option>

                                    ))
                                }

                            </select>

                            <div className="text-danger">
                                {bookingIdError}
                            </div>

                        </div>

                        {/* Passenger Name */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Passenger Name
                            </label>

                            <input
                                type="text"
                                className="form-control"
                                value={passenger.passengerName}
                                onChange={(e) =>
                                    setPassenger({
                                        ...passenger,
                                        passengerName: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {passengerNameError}
                            </div>

                        </div>

                        {/* Age */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Age
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={passenger.age}
                                onChange={(e) =>
                                    setPassenger({
                                        ...passenger,
                                        age: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {ageError}
                            </div>

                        </div>

                        {/* Gender */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Gender
                            </label>

                            <select
                                className="form-select"
                                value={passenger.gender}
                                onChange={(e) =>
                                    setPassenger({
                                        ...passenger,
                                        gender: e.target.value
                                    })
                                }
                            >

                                <option value="">
                                    Select Gender
                                </option>

                                <option value="MALE">
                                    MALE
                                </option>

                                <option value="FEMALE">
                                    FEMALE
                                </option>

                                <option value="OTHER">
                                    OTHER
                                </option>

                            </select>

                            <div className="text-danger">
                                {genderError}
                            </div>

                        </div>

                        {/* Seat Number */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Seat Number
                            </label>

                            <input
                                type="text"
                                className="form-control"
                                value={passenger.seatNumber}
                                onChange={(e) =>
                                    setPassenger({
                                        ...passenger,
                                        seatNumber: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {seatNumberError}
                            </div>

                        </div>

                    </div>

                    {
                        isEdit ?

                            <button
                                className="btn btn-warning"
                                onClick={updatePassenger}
                            >
                                Update Passenger
                            </button>

                            :

                            <button
                                className="btn btn-success"
                                onClick={savePassenger}
                            >
                                Save Passenger
                            </button>

                    }

                    <hr />

                    <h3 className="text-center text-primary">
                        Passenger List
                    </h3>
                    <table className="table table-bordered table-hover mt-3">

                        <thead className="table-dark">

                            <tr>

                                <th>ID</th>
                                <th>Booking ID</th>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Gender</th>
                                <th>Seat Number</th>
                                <th>Edit</th>
                                <th>Delete</th>

                            </tr>

                        </thead>

                        <tbody>

                            {

                                passengers.map((passenger) => (

                                    <tr key={passenger.passengerId}>

                                        <td>{passenger.passengerId}</td>

                                        <td>{passenger.bookingId}</td>

                                        <td>{passenger.passengerName}</td>

                                        <td>{passenger.age}</td>

                                        <td>{passenger.gender}</td>

                                        <td>{passenger.seatNumber}</td>

                                        <td>

                                            <button
                                                className="btn btn-warning btn-sm"
                                                onClick={() =>
                                                    editPassenger(passenger)
                                                }
                                            >
                                                Edit
                                            </button>

                                        </td>

                                        <td>

                                            <button
                                                className="btn btn-danger btn-sm"
                                                onClick={() =>
                                                    deletePassenger(passenger.passengerId)
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

export default Passenger;