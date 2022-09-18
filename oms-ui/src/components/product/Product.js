import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom"
import axios from "axios";
import "./Product.css"

function Products() {
    const { id } = useParams()
    const [users, setUsers] = useState([])

    useEffect (() => {
        axios.get(`http://localhost:8082/store/product/${id}`)
            .then((res) => {
                console.log(res)
                setUsers(res.data)
            })
            .catch((err) => {
                console.log(err)
            })
    },[id])
    
    const displayData = (items) => {
        return ( 
            <tr>
            <td>
                {items.product.productName}
            </td>
            <td>
                {items.product.mdate}
            </td>
            <td>
                {items.product.edate}
            </td>
            <td>
                {items.product.cost}
            </td>
        </tr>
        )
    }


    return (
        <div>
            <div className="container1">
                <h1>PRODUCTS FROM STORE </h1>
            </div>
            <div className="container1">
                <table className="table">
                    <thead>
                        <tr>
                            <td scope="col"><strong>Product Name</strong></td>
                            <td scope="col"><strong>Mnf Date</strong></td>
                            <td scope="col"><strong>Exp Date</strong></td>
                            <td scope="col"><strong>Price</strong></td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            users.map(displayData)
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default Products