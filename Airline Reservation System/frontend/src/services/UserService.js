import axios from "axios";

const BASE_URL = "http://localhost:1515/api/v1/users";

class UserService {

    login(user) {
        return axios.post(BASE_URL + "/login", user);
    }

    register(user) {
        return axios.post(BASE_URL + "/register", user);
    }

}

export default new UserService();