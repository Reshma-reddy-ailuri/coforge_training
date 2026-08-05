import axios from "axios";

const BASE_URL = "http://localhost:1515/api/v1/passengers";

class PassengerService {

    savePassenger(passenger) {
        return axios.post(BASE_URL, passenger);
    }

    findAllPassengers() {
        return axios.get(BASE_URL);
    }

    findPassengerById(id) {
        return axios.get(BASE_URL + "/" + id);
    }

    updatePassenger(id, passenger) {
        return axios.put(BASE_URL + "/" + id, passenger);
    }

    deletePassenger(id) {
        return axios.delete(BASE_URL + "/" + id);
    }

}

export default new PassengerService();