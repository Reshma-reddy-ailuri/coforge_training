function Child1({location="Pune",country = "India"}) { //default values in case of functional Component
    //we can also use destructuring const{location="hyd",country="india"} = props;
    return (
        <>
        <h1>Child</h1>
        <b>I am a child component</b>
        <br></br>
        <p>Location : {location} </p>
        <br></br>
        <p>Country : {country}</p>
        </>
    );
}
export default Child1;