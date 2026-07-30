import './App.css';
import Counter from './Counter';
import Employee from './Employee';
import EmployeeRegistration from './EmployeeRegistration';
import Livename from './Livename';
import Loginform from './Loginform';
import Product from './Product';
import Student from './Student';
import Studentregistrationform from './Studentregistrationform';
import Welcome from './Welcome';

function App() {
  return (
    <>
      <Welcome/>
      <Student
      name = "Reshma"
      course = "AI"
      age = "21"
      city = "Hyderabad"
      />
      <Employee 
        id="101"
        name="Reshma"
        department="IT"
        designation="Software Engineer"
        salary="65000"
      />
      
      <div className="container">

            <div className="row">

                <div className="col-md-4">
                    <Product
                        name="Laptop"
                        brand="Dell"
                        price="850"
                        rating="4.8"
                        stock={true}
                    />
                </div>

                <div className="col-md-4">
                    <Product
                        name="Mobile"
                        brand="Samsung"
                        price="500"
                        rating="4.5"
                        stock={false}
                    />
                </div>

                <div className="col-md-4">
                    <Product
                        name="Headphones"
                        brand="Sony"
                        price="150"
                        rating="4.7"
                        stock={true}
                    />
                </div>

            </div>

        </div>

    <br></br>
    <Counter></Counter>
    <Livename></Livename>
    <Studentregistrationform></Studentregistrationform>
    <Loginform></Loginform>
    <EmployeeRegistration></EmployeeRegistration>
    </>    
  );
}

export default App;
