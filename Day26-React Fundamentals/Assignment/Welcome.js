function Welcome() {
    const today = new Date ().toLocaleDateString();
    return (
        <>
            <p>Welcome to React</p>
            <p>Name : Reshma</p>
            <p>Today's Date : {today}</p>
        </>
    );
}
export default Welcome;