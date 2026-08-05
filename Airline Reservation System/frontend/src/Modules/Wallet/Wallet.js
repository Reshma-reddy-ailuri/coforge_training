import { useEffect, useState } from "react";
import Navbar from "../../component/Navbar";
import Footer from "../../component/Footer";
import WalletService from "../../services/WalletService";

function Wallet() {

    const [wallet, setWallet] = useState({

        walletId: "",

        customerId: "",

        balance: ""

    });

    const [wallets, setWallets] = useState([]);

    const [customerIdError, setCustomerIdError] = useState("");

    const [balanceError, setBalanceError] = useState("");

    const [isEdit, setIsEdit] = useState(false);

    useEffect(() => {

        getAllWallets();

    }, []);

    const getAllWallets = () => {

        WalletService.findAllWallets()

            .then((response) => {

                setWallets(response.data);

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Load Wallets");

            });

    };

    const clearForm = () => {

        setWallet({

            walletId: "",

            customerId: "",

            balance: ""

        });

        setCustomerIdError("");

        setBalanceError("");

    };

    const validate = () => {

        let flag = true;

        setCustomerIdError("");

        setBalanceError("");

        if (wallet.customerId === "") {

            setCustomerIdError("Customer Id is Required");

            flag = false;

        }

        if (wallet.balance === "" || wallet.balance < 0) {

            setBalanceError("Enter Valid Balance");

            flag = false;

        }

        return flag;

    };
    const saveWallet = () => {

        if (!validate()) {
            return;
        }

        WalletService.saveWallet(wallet)

            .then(() => {

                alert("Wallet Added Successfully");

                clearForm();

                getAllWallets();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Save Wallet");

            });

    };

    const editWallet = (wallet) => {

        setWallet({

            walletId: wallet.walletId,

            customerId: wallet.customerId,

            balance: wallet.balance

        });

        setIsEdit(true);

    };

    const updateWallet = () => {

        if (!validate()) {
            return;
        }

        WalletService.updateWallet(

            wallet.walletId,

            wallet

        )

            .then(() => {

                alert("Wallet Updated Successfully");

                clearForm();

                setIsEdit(false);

                getAllWallets();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Update Wallet");

            });

    };

    const deleteWallet = (walletId) => {

        if (!window.confirm("Are you sure you want to delete this Wallet?")) {
            return;
        }

        WalletService.deleteWallet(walletId)

            .then(() => {

                alert("Wallet Deleted Successfully");

                getAllWallets();

            })

            .catch((error) => {

                alert(error.response?.data || "Unable to Delete Wallet");

            });

    };
    return (
        <>
            <Navbar />

            <div className="container mt-5">

                <div className="card shadow p-4">

                    <h2 className="text-center text-primary mb-4">
                        Wallet Management
                    </h2>

                    <div className="row">

                        {/* Customer ID */}

                        <div className="col-md-6 mb-3">

                            <label className="form-label">
                                Customer ID
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={wallet.customerId}
                                onChange={(e) =>
                                    setWallet({
                                        ...wallet,
                                        customerId: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {customerIdError}
                            </div>

                        </div>

                        {/* Balance */}

                        <div className="col-md-6 mb-3">

                            <label className="form-label">
                                Balance
                            </label>

                            <input
                                type="number"
                                className="form-control"
                                value={wallet.balance}
                                onChange={(e) =>
                                    setWallet({
                                        ...wallet,
                                        balance: e.target.value
                                    })
                                }
                            />

                            <div className="text-danger">
                                {balanceError}
                            </div>

                        </div>

                    </div>

                    {
                        isEdit ?

                            <button
                                className="btn btn-warning me-2"
                                onClick={updateWallet}
                            >
                                Update Wallet
                            </button>

                            :

                            <button
                                className="btn btn-success me-2"
                                onClick={saveWallet}
                            >
                                Save Wallet
                            </button>

                    }

                    <button
                        className="btn btn-info"
                        onClick={() => {

                            if (wallet.customerId === "" || wallet.balance === "") {

                                alert("Enter Customer ID and Amount");

                                return;

                            }

                            WalletService.addMoney(
                                wallet.customerId,
                                wallet.balance
                            )

                                .then(() => {

                                    alert("Money Added Successfully");

                                    getAllWallets();

                                    clearForm();

                                })

                                .catch((error) => {

                                    alert(error.response?.data || "Unable to Add Money");

                                });

                        }}
                    >
                        Add Money
                    </button>

                    <hr />

                    <h3 className="text-center text-primary">
                        Wallet List
                    </h3>
                    <table className="table table-bordered table-hover mt-3">

                        <thead className="table-dark">

                            <tr>

                                <th>Wallet ID</th>
                                <th>Customer ID</th>
                                <th>Balance</th>
                                <th>Check Balance</th>
                                <th>Edit</th>
                                <th>Delete</th>

                            </tr>

                        </thead>

                        <tbody>

                            {

                                wallets.map((wallet) => (

                                    <tr key={wallet.walletId}>

                                        <td>{wallet.walletId}</td>

                                        <td>{wallet.customerId}</td>

                                        <td>₹ {wallet.balance}</td>

                                        <td>

                                            <button
                                                className="btn btn-primary btn-sm"
                                                onClick={() => {

                                                    WalletService.checkBalance(wallet.customerId)

                                                        .then((response) => {

                                                            alert(
                                                                "Current Balance : ₹ " +
                                                                response.data
                                                            );

                                                        })

                                                        .catch((error) => {

                                                            alert(
                                                                error.response?.data ||
                                                                "Unable to Fetch Balance"
                                                            );

                                                        });

                                                }}
                                            >
                                                Check Balance
                                            </button>

                                        </td>

                                        <td>

                                            <button
                                                className="btn btn-warning btn-sm"
                                                onClick={() =>
                                                    editWallet(wallet)
                                                }
                                            >
                                                Edit
                                            </button>

                                        </td>

                                        <td>

                                            <button
                                                className="btn btn-danger btn-sm"
                                                onClick={() =>
                                                    deleteWallet(wallet.walletId)
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

export default Wallet;