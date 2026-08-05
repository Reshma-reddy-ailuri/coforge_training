import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './Pages/Home';
import Login from './Pages/Login';
import Register from './Pages/Register';
import AdminDashboard from './Pages/AdminDashboard';
import CustomerDashboard from './Pages/CustomerDashboard';
import Airport from "./Modules/Airport/Airport";
import Airplane from "./Modules/Airplane/Airplane";
import Flight from "./Modules/Flight/Flight";
import Booking from "./Modules/Booking/Booking";
import Passenger from "./Modules/Passenger/Passenger";
import Wallet from "./Modules/Wallet/Wallet";
import WaitingList from "./Modules/WaitingList/WaitingList";

function App() {
  return (
    <BrowserRouter>
      <Routes>

        <Route path="/" element={<Home />} />

        <Route path="/login" element={<Login />} />

        <Route path="/register" element={<Register />} />

        <Route path="/admin" element={<AdminDashboard />} />

        <Route path="/customer" element={<CustomerDashboard />} />

        <Route path="/admin/airports" element={<Airport />} />

        <Route path="/admin/airplanes" element={<Airplane />} />

        <Route path="/admin/flights" element={<Flight />} />

        <Route path="/customer/booking" element={<Booking />} />

        <Route path="/customer/passenger" element={<Passenger />} />

        <Route path="/customer/wallet" element={<Wallet />} />

        <Route path="/customer/waitinglist" element={<WaitingList />} />

      </Routes>
    </BrowserRouter>
  );
}

export default App;