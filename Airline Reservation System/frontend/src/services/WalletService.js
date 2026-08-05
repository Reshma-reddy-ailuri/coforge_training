import axios from "axios";

const BASE_URL = "http://localhost:1515/api/v1/customer/wallets";

class WalletService {

    saveWallet(wallet) {
        return axios.post(BASE_URL, wallet);
    }

    findAllWallets() {
        return axios.get(BASE_URL);
    }

    findWalletById(id) {
        return axios.get(BASE_URL + "/" + id);
    }

    updateWallet(id, wallet) {
        return axios.put(BASE_URL + "/" + id, wallet);
    }

    deleteWallet(id) {
        return axios.delete(BASE_URL + "/" + id);
    }

    addMoney(customerId, amount) {
        return axios.put(
            "http://localhost:1515/api/v1/customer/wallets/addmoney/" +
            customerId + "/" + amount
        );
    }

    checkBalance(customerId) {
        return axios.get(
            "http://localhost:1515/api/v1/customer/wallets/balance/" +
            customerId
        );
    }

}

export default new WalletService();