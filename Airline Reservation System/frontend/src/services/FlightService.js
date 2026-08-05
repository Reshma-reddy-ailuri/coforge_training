import axios from "axios";

const BASE_URL = "http://localhost:1515/api/v1/flights";

class FlightService {

    saveFlight(flight) {
        return axios.post(BASE_URL, flight);
    }

    findAllFlights() {
        return axios.get(BASE_URL);
    }

    findFlightById(id) {
        return axios.get(BASE_URL + "/" + id);
    }

    updateFlight(id, flight) {
        return axios.put(BASE_URL + "/" + id, flight);
    }

    deleteFlight(id) {
        return axios.delete(BASE_URL + "/" + id);
    }

    updateFlightStatus(id, status) {
        return axios.put(BASE_URL + "/" + id + "/status/" + status);
    }

    searchFlights(departureAirportId, arrivalAirportId, journeyDate) {
        return axios.get(
            BASE_URL +
            "/search?departureAirportId=" + departureAirportId +
            "&arrivalAirportId=" + arrivalAirportId +
            "&journeyDate=" + journeyDate
        );
    }

}

export default new FlightService();