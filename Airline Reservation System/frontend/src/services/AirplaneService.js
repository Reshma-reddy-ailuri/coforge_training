import axios from "axios";

const BASE_URL = "http://localhost:1515/api/v1/airplanes";

class AirplaneService {

    saveAirplane(airplane) {
        return axios.post(BASE_URL, airplane);
    }

    findAllAirplanes() {
        return axios.get(BASE_URL);
    }

    findAirplaneById(id) {
        return axios.get(BASE_URL + "/" + id);
    }

    updateAirplane(id, airplane) {
        return axios.put(BASE_URL + "/" + id, airplane);
    }

    deleteAirplane(id) {
        return axios.delete(BASE_URL + "/" + id);
    }

}

export default new AirplaneService();