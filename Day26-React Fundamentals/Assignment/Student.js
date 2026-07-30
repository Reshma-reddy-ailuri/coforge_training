function Student(props) {
    return(
        <>
            <p>Name : {props.name}</p>
            <p>Course : {props.course}</p>
            <p>Age : {props.age}</p>
            <p>City : {props.city}</p>
        </>

    );
}
export default Student;