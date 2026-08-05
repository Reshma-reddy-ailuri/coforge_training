import axios from "axios";

const BASE_URL = "http://localhost:1515/api/v1/bookings";

class BookingService {

    saveBooking(booking) {
        return axios.post(BASE_URL, booking);
    }

    findAllBookings() {
        return axios.get(BASE_URL);
    }

    findBookingById(id) {
        return axios.get(BASE_URL + "/" + id);
    }

    updateBooking(id, booking) {
        return axios.put(BASE_URL + "/" + id, booking);
    }

    deleteBooking(id) {
        return axios.delete(BASE_URL + "/" + id);
    }

    findBookingsByCustomerId(customerId) {
        return axios.get(BASE_URL + "/customer/" + customerId);
    }

    downloadTicket(bookingId) {
        return axios.get(
            BASE_URL + "/" + bookingId + "/ticket",
            {
                responseType: "blob"
            }
        );
    }

}

export default new BookingService();