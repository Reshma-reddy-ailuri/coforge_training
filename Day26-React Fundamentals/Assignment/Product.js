function Product(props) {
    return (
        <div className="card m-3 shadow" style={{ width: "18rem" }}>

            <div className="card-header bg-success text-white">
                Product Details
            </div>

            <div className="card-body">

                <h4>{props.name}</h4>

                <p><b>Brand :</b> {props.brand}</p>

                <p><b>Price :</b> ${props.price}</p>

                <p><b>Rating :</b> ⭐ {props.rating}</p>

                <p>
                    <b>Stock :</b>{" "}
                    {props.stock ? (
                        <span className="text-success">Available</span>
                    ) : (
                        <span className="text-danger">Out of Stock</span>
                    )}
                </p>

            </div>

        </div>
    );
}

export default Product;