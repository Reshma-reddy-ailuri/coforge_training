import { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import Navbar from "../../component/Navbar";
import Footer from "../../component/Footer";
import BookingService from "../../services/BookingService";
import FlightService from "../../services/FlightService";

function Booking() {

    const location = useLocation();

    const user = JSON.parse(localStorage.getItem("user"));

    const selectedFlight = location.state?.flight;

    const [booking, setBooking] = useState({

        bookingId: "",

        customerId: user?.userId || "",

        flightId: selectedFlight?.flightId || "",

        seatClass: "",

        passengerCount: 1,

        totalAmount: 0,

        bookingDate: "",

        bookingStatus: "BOOKED"

    });

    const [bookings, setBookings] = useState([]);

    const [flights, setFlights] = useState([]);

    const [flightIdError, setFlightIdError] = useState("");

    const [seatClassError, setSeatClassError] = useState("");

    const [passengerCountError, setPassengerCountError] = useState("");

    const [totalAmountError, setTotalAmountError] = useState("");

    const [isEdit, setIsEdit] = useState(false);

    useEffect(() => {

        getAllBookings();

        getAllFlights();

    }, []);

    const getAllBookings = () => {

        if (user.role === "ADMIN") {

            BookingService.findAllBookings()

                .then((response) => {

                    setBookings(response.data);

                })

                .catch(() => {

                    setBookings([]);

                });

        }
        else {

            BookingService.findBookingsByCustomerId(user.userId)

                .then((response) => {

                    setBookings(response.data);

                })

                .catch(() => {

                    setBookings([]);

                });

        }

    };

    const getAllFlights = () => {

        FlightService.findAllFlights()

            .then((response) => {

                setFlights(response.data);

            });

    };

    const calculateAmount = (seatClass, passengerCount) => {

        if (!selectedFlight) return 0;

        let fare = 0;

        switch (seatClass) {

            case "ECONOMY":
                fare = selectedFlight.economyFare;
                break;

            case "BUSINESS":
                fare = selectedFlight.businessFare;
                break;

            case "FIRST_CLASS":
                fare = selectedFlight.firstClassFare;
                break;

            default:
                fare = 0;

        }

        return fare * Number(passengerCount);

    };

    const clearForm = () => {

        setBooking({

            bookingId: "",

            customerId: user?.userId || "",

            flightId: selectedFlight?.flightId || "",

            seatClass: "",

            passengerCount: 1,

            totalAmount: 0,

            bookingDate: "",

            bookingStatus: "BOOKED"

        });

        setFlightIdError("");

        setSeatClassError("");

        setPassengerCountError("");

        setTotalAmountError("");

    };

    const validate = () => {

        let flag = true;

        setFlightIdError("");

        setSeatClassError("");

        setPassengerCountError("");

        setTotalAmountError("");

        if (booking.flightId === "") {

            setFlightIdError("Select Flight");

            flag = false;

        }

        if (booking.seatClass === "") {

            setSeatClassError("Select Seat Class");

            flag = false;

        }

        if (booking.passengerCount <= 0) {

            setPassengerCountError("Enter Valid Passenger Count");

            flag = false;

        }

        if (booking.totalAmount <= 0) {

            setTotalAmountError("Invalid Total Amount");

            flag = false;

        }

        return flag;

    };
    const saveBooking = () => {

        if (!validate()) {
            return;
        }

        BookingService.saveBooking(booking)

            .then(() => {

                alert("Booking Added Successfully");

                clearForm();

                getAllBookings();

            })
            .catch((error) => {

                if (error.response) {

                    alert(error.response.data);

                } else {

                    alert("Server is not responding.");

                }

            });


    };

    const editBooking = (booking) => {

        setBooking({

            bookingId: booking.bookingId,

            customerId: booking.customerId,

            flightId: booking.flightId,

            seatClass: booking.seatClass,

            passengerCount: booking.passengerCount,

            totalAmount: booking.totalAmount,

            bookingDate: booking.bookingDate,

            bookingStatus: booking.bookingStatus

        });

        setIsEdit(true);

    };

    const updateBooking = () => {

        if (!validate()) {
            return;
        }

        BookingService.updateBooking(

            booking.bookingId,

            booking

        )

            .then(() => {

                alert("Booking Updated Successfully");

                clearForm();

                setIsEdit(false);

                getAllBookings();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Update Booking");

            });

    };

    const deleteBooking = (bookingId) => {

        if (!window.confirm("Are you sure you want to delete this Booking?")) {
            return;
        }

        BookingService.deleteBooking(bookingId)

            .then(() => {

                alert("Booking Deleted Successfully");

                getAllBookings();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Delete Booking");

            });

    };
    const downloadTicket = (bookingId) => {

        BookingService.downloadTicket(bookingId)

            .then((response) => {

                const url = window.URL.createObjectURL(
                    new Blob([response.data])
                );

                const link = document.createElement("a");

                link.href = url;

                link.setAttribute(
                    "download",
                    "Ticket_" + bookingId + ".pdf"
                );

                document.body.appendChild(link);

                link.click();

                link.remove();

            })

            .catch(() => {

                alert("Unable to Download Ticket");

            });

    };

    return (

        <>
            <Navbar />

            <div className="container mt-5">

                <div className="card shadow p-4">

                    <h2 className="text-center text-primary mb-4">

                        Booking Management

                    </h2>

                    <div className="row">

                        {/* Selected Flight */}

                        <div className="col-md-6 mb-3">

                            <label className="form-label fw-bold">

                                Selected Flight

                            </label>

                            <input
                                className="form-control"
                                value={
                                    selectedFlight
                                        ? `Flight #${selectedFlight.flightId} - ${selectedFlight.departureAirport.airportName} ➜ ${selectedFlight.arrivalAirport.airportName}`
                                        : ""
                                }
                                readOnly
                            />

                            <div className="text-danger">

                                {flightIdError}

                            </div>

                        </div>

                        {/* Seat Class */}

                        <div className="col-md-6 mb-3">

                            <label className="form-label fw-bold">

                                Seat Class

                            </label>

                            <select
                                className="form-select"
                                value={booking.seatClass}
                                onChange={(e) => {

                                    const seatClass = e.target.value;

                                    setBooking({

                                        ...booking,

                                        seatClass,

                                        totalAmount: calculateAmount(
                                            seatClass,
                                            booking.passengerCount
                                        )

                                    });

                                }}
                            >

                                <option value="">Select Seat Class</option>

                                <option value="ECONOMY">ECONOMY</option>

                                <option value="BUSINESS">BUSINESS</option>

                                <option value="FIRST_CLASS">FIRST CLASS</option>

                            </select>

                            <div className="text-danger">

                                {seatClassError}

                            </div>

                        </div>

                        {/* Passenger Count */}

                        <div className="col-md-6 mb-3">

                            <label className="form-label fw-bold">

                                Passenger Count

                            </label>

                            <input
                                type="number"
                                min="1"
                                className="form-control"
                                value={booking.passengerCount}
                                onChange={(e) => {

                                    const count = Number(e.target.value);

                                    setBooking({

                                        ...booking,

                                        passengerCount: count,

                                        totalAmount: calculateAmount(
                                            booking.seatClass,
                                            count
                                        )

                                    });

                                }}
                            />

                            <div className="text-danger">

                                {passengerCountError}

                            </div>

                        </div>

                        {/* Total Amount */}

                        <div className="col-md-6 mb-3">

                            <label className="form-label fw-bold">

                                Total Amount

                            </label>

                            <input
                                type="number"
                                className="form-control bg-light"
                                value={booking.totalAmount}
                                readOnly
                            />

                            <div className="text-danger">

                                {totalAmountError}

                            </div>

                        </div>
                        {/* Booking Status */}

                        <div className="col-md-6 mb-3">

                            <label className="form-label fw-bold">

                                Booking Status

                            </label>

                            <input
                                type="text"
                                className="form-control bg-light"
                                value={booking.bookingStatus}
                                readOnly
                            />

                        </div>

                    </div>

                    <div className="text-center mt-3">

                        {
                            isEdit ?

                                <button
                                    className="btn btn-warning px-5"
                                    onClick={updateBooking}
                                >
                                    Update Booking
                                </button>

                                :

                                <button
                                    className="btn btn-success px-5"
                                    onClick={saveBooking}
                                >
                                    Save Booking
                                </button>

                        }

                    </div>

                </div>

                <hr />

                <h3 className="text-center text-primary mb-3">

                    Booking List

                </h3>

                <table className="table table-bordered table-hover table-striped">

                    <thead className="table-dark">

                        <tr>

                            <th>ID</th>

                            <th>Customer</th>

                            <th>Flight</th>

                            <th>Seat Class</th>

                            <th>Passengers</th>

                            <th>Total Amount</th>

                            <th>Booking Date</th>

                            <th>Status</th>

                            <th>Ticket</th>

                            {
                                user.role === "ADMIN" &&

                                <>

                                    <th>Edit</th>

                                    <th>Delete</th>

                                </>

                            }

                        </tr>

                    </thead>

                    <tbody>

                        {
                            bookings.length === 0 ?

                                <tr>

                                    <td
                                        colSpan={user.role === "ADMIN" ? 10 : 8}
                                        className="text-center fw-bold text-secondary"
                                    >

                                        No Bookings Found

                                    </td>

                                </tr>

                                :

                                bookings.map((booking) => (

                                    <tr key={booking.bookingId}>

                                        <td>{booking.bookingId}</td>

                                        <td>{booking.customerId}</td>

                                        <td>{booking.flightId}</td>

                                        <td>{booking.seatClass}</td>

                                        <td>{booking.passengerCount}</td>

                                        <td>₹ {booking.totalAmount}</td>

                                        <td>{booking.bookingDate}</td>

                                        <td>

                                            <span
                                                className={
                                                    booking.bookingStatus === "BOOKED"
                                                        ? "badge bg-success"
                                                        : "badge bg-danger"
                                                }
                                            >

                                                {booking.bookingStatus}

                                            </span>

                                        </td>

                                        <td>

                                            <button
                                                className="btn btn-primary btn-sm"
                                                onClick={() => downloadTicket(booking.bookingId)}
                                            >
                                                📄 Download
                                            </button>

                                        </td>

                                        {
                                            user.role === "ADMIN" &&

                                            <>

                                                <td>

                                                    <button
                                                        className="btn btn-warning btn-sm"
                                                        onClick={() => editBooking(booking)}
                                                    >

                                                        Edit

                                                    </button>

                                                </td>

                                                <td>

                                                    <button
                                                        className="btn btn-danger btn-sm"
                                                        onClick={() => deleteBooking(booking.bookingId)}
                                                    >

                                                        Delete

                                                    </button>

                                                </td>

                                            </>

                                        }

                                    </tr>

                                ))

                        }

                    </tbody>

                </table>

            </div>

            <Footer />

        </>

    );

}

export default Booking;