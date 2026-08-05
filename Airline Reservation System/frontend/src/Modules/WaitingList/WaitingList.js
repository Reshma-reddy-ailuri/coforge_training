import { useEffect, useState } from "react";
import Navbar from "../../component/Navbar";
import Footer from "../../component/Footer";
import WaitingListService from "../../services/WaitingListService";
import BookingService from "../../services/BookingService";

function WaitingList() {

    const [waitingList, setWaitingList] = useState({
        waitingId: "",
        bookingId: "",
        waitingPosition: "",
        waitingStatus: ""
    });

    const [waitingLists, setWaitingLists] = useState([]);
    const [bookings, setBookings] = useState([]);

    const [bookingIdError, setBookingIdError] = useState("");
    const [waitingPositionError, setWaitingPositionError] = useState("");
    const [waitingStatusError, setWaitingStatusError] = useState("");

    const [isEdit, setIsEdit] = useState(false);

    useEffect(() => {

        getAllWaitingLists();
        getAllBookings();

    }, []);

    const getAllWaitingLists = () => {

        WaitingListService.findAllWaitingLists()

            .then((response) => {

                setWaitingLists(response.data);

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Load Waiting List");

            });

    };

    const getAllBookings = () => {

        BookingService.findAllBookings()

            .then((response) => {

                setBookings(response.data);

            });

    };

    const clearForm = () => {

        setWaitingList({
            waitingId: "",
            bookingId: "",
            waitingPosition: "",
            waitingStatus: ""
        });

        setBookingIdError("");
        setWaitingPositionError("");
        setWaitingStatusError("");

    };

    const validate = () => {

        let flag = true;

        setBookingIdError("");
        setWaitingPositionError("");
        setWaitingStatusError("");

        if (waitingList.bookingId === "") {
            setBookingIdError("Select Booking");
            flag = false;
        }

        if (waitingList.waitingPosition === "" || waitingList.waitingPosition <= 0) {
            setWaitingPositionError("Enter Valid Waiting Position");
            flag = false;
        }

        if (waitingList.waitingStatus === "") {
            setWaitingStatusError("Select Waiting Status");
            flag = false;
        }

        return flag;

    };
    const saveWaitingList = () => {

        if (!validate()) {
            return;
        }

        WaitingListService.saveWaitingList(waitingList)

            .then(() => {

                alert("Waiting List Added Successfully");

                clearForm();

                getAllWaitingLists();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Save Waiting List");

            });

    };

    const editWaitingList = (waiting) => {

        setWaitingList({

            waitingId: waiting.waitingId,

            bookingId: waiting.bookingId,

            waitingPosition: waiting.waitingPosition,

            waitingStatus: waiting.waitingStatus

        });

        setIsEdit(true);

    };

    const updateWaitingList = () => {

        if (!validate()) {
            return;
        }

        WaitingListService.updateWaitingList(

            waitingList.waitingId,

            waitingList

        )

            .then(() => {

                alert("Waiting List Updated Successfully");

                clearForm();

                setIsEdit(false);

                getAllWaitingLists();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Update Waiting List");

            });

    };

    const deleteWaitingList = (waitingId) => {

        if (!window.confirm("Are you sure you want to delete this Waiting List?")) {
            return;
        }

        WaitingListService.deleteWaitingList(waitingId)

            .then(() => {

                alert("Waiting List Deleted Successfully");

                getAllWaitingLists();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Delete Waiting List");

            });

    };
    return (
        <>
            <Navbar />

            <div className="container mt-5">

                <div className="card shadow p-4">

                    <h2 className="text-center text-primary mb-4">
                        Waiting List Management
                    </h2>

                    <div className="row">

                        {/* Booking */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Booking
                            </label>

                            <select
                                className="form-select"
                                value={waitingList.bookingId}
                                onChange={(e) =>
                                    setWaitingList({
                                        ...waitingList,
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

                        {/* Waiting Position */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Waiting Position
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={waitingList.waitingPosition}
                                onChange={(e) =>
                                    setWaitingList({
                                        ...waitingList,
                                        waitingPosition: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {waitingPositionError}
                            </div>

                        </div>

                        {/* Waiting Status */}

                        <div className="col-md-4 mb-3">

                            <label className="form-label">
                                Waiting Status
                            </label>

                            <select
                                className="form-select"
                                value={waitingList.waitingStatus}
                                onChange={(e) =>
                                    setWaitingList({
                                        ...waitingList,
                                        waitingStatus: e.target.value
                                    })
                                }
                            >

                                <option value="">
                                    Select Status
                                </option>

                                <option value="WAITING">
                                    WAITING
                                </option>

                                <option value="CONFIRMED">
                                    CONFIRMED
                                </option>

                                <option value="CANCELLED">
                                    CANCELLED
                                </option>

                            </select>

                            <div className="text-danger">
                                {waitingStatusError}
                            </div>

                        </div>

                    </div>

                    {
                        isEdit ?

                            <button
                                className="btn btn-warning"
                                onClick={updateWaitingList}
                            >
                                Update Waiting List
                            </button>

                            :

                            <button
                                className="btn btn-success"
                                onClick={saveWaitingList}
                            >
                                Save Waiting List
                            </button>

                    }

                    <hr />

                    <h3 className="text-center text-primary">
                        Waiting List
                    </h3>
                    <table className="table table-bordered table-hover mt-3">

                        <thead className="table-dark">

                            <tr>

                                <th>ID</th>
                                <th>Booking ID</th>
                                <th>Waiting Position</th>
                                <th>Status</th>
                                <th>Edit</th>
                                <th>Delete</th>

                            </tr>

                        </thead>

                        <tbody>

                            {

                                waitingLists.map((waiting) => (

                                    <tr key={waiting.waitingId}>

                                        <td>{waiting.waitingId}</td>

                                        <td>{waiting.bookingId}</td>

                                        <td>{waiting.waitingPosition}</td>

                                        <td>{waiting.waitingStatus}</td>

                                        <td>

                                            <button
                                                className="btn btn-warning btn-sm"
                                                onClick={() =>
                                                    editWaitingList(waiting)
                                                }
                                            >
                                                Edit
                                            </button>

                                        </td>

                                        <td>

                                            <button
                                                className="btn btn-danger btn-sm"
                                                onClick={() =>
                                                    deleteWaitingList(waiting.waitingId)
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

export default WaitingList;