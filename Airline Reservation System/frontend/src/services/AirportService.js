import axios from "axios";

const BASE_URL = "http://localhost:1515/api/v1/airports";

class AirportService {

    saveAirport(airport) {
        return axios.post(BASE_URL, airport);
    }

    findAllAirports() {
        return axios.get(BASE_URL);
    }

    findAirportById(id) {
        return axios.get(BASE_URL + "/" + id);
    }

    updateAirport(id, airport) {
        return axios.put(BASE_URL + "/" + id, airport);
    }

    deleteAirport(id) {
        return axios.delete(BASE_URL + "/" + id);
    }

}

export default new AirportService();