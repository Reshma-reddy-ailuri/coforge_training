import axios from "axios";

const BASE_URL = "http://localhost:1515/api/v1/waitinglists";

class WaitingListService {

    saveWaitingList(waitingList) {
        return axios.post(BASE_URL, waitingList);
    }

    findAllWaitingLists() {
        return axios.get(BASE_URL);
    }

    findWaitingListById(id) {
        return axios.get(BASE_URL + "/" + id);
    }

    updateWaitingList(id, waitingList) {
        return axios.put(BASE_URL + "/" + id, waitingList);
    }

    deleteWaitingList(id) {
        return axios.delete(BASE_URL + "/" + id);
    }

}

export default new WaitingListService();