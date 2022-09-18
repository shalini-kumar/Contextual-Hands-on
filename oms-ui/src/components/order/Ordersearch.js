import React, { useState, useEffect } from "react"
import axios from "axios"
import "./Ordersearch.css"
import { Link } from "react-router-dom"

function Ordersearch() {
    const [users, setUsers] = useState([{}])
    const [id, setId] = useState("")
    const [sortType, setSortType] = useState('OrderId');

    const handle = () => {
        axios.get(`http://localhost:8082/order/orderStatus/${id}`)
            .then((res) => {
                console.log(res)
                setUsers(res.data)
            })
            .catch((err) => {
                console.log(err)
            })
    }

    const handleall = () => {
        axios.get(`http://localhost:8082/order/ALL/${id}`)
            .then((res) => {
                console.log(res)
                setUsers(res.data)
            })
            .catch((err) => {
                console.log(err)
            })
    }

    useEffect(() => {
        const sortArray = type => {
            const types = {
                id: 'id',
                orderedDate: 'orderedDate',
                price: 'price',
                orderStatus: 'orderStatus',
            };
            const sortProperty = types[type];
            var sorted = []
            if (sortProperty === 'orderedDate') {
                sorted = [...users].sort((a, b) => {
                    const [date, month, year] = a.orderedDate.split('/');

                    const isoStr = `${year}-${month}-${date}`

                    const [d, m, y] = b.orderedDate.split('/');

                    const isoStr1 = `${y}-${m}-${d}`

                    return new Date(isoStr1) - new Date(isoStr)
                    
                });
            }
            else if (sortProperty === 'orderStatus') {
                sorted = [...users].sort((a, b) => b.orderStatus.localeCompare(a.orderStatus))
            }
            else if (sortProperty === 'id') {
                sorted = [...users].sort((a, b) => a.id - b.id)
            }
            else {
                sorted = [...users].sort((a, b) => b[sortProperty] - a[sortProperty]);
            }
            setUsers(sorted);
            // setData(sorted);
        };
        sortArray(sortType);
    }, [sortType]);

    const displayData = (items) => {
        return (
            <tr>
                <td><Link to={`/order/item/${items.id}`}>
                    {items.id}
                </Link>
                </td>
                <td>
                    {items.orderStatus}
                </td>
                <td>
                    {items.orderedDate}
                </td>
                <td>
                    {items.deliveryDate}
                </td>
                <td>
                    {items.price}
                </td>
            </tr>
        )
    }

    return (
        <div>
            <div className="all">
                {<button onClick={handleall}>ALL ORDERS</button>}
            </div>
            <br></br>
            <div className="container">
                <b>Enter Order Status&nbsp;</b><input id="input" type="text" value={id} onChange={e => setId(e.target.value)}></input>
                {(id.trim() && isNaN(+id)) ? <button onClick={handle}>Search</button> : <button disabled>Search</button>}&nbsp;
                <select onChange={(e) => setSortType(e.target.value)}>
                    <option value="id">Order ID</option>
                    <option value="orderedDate">Order Date</option>
                    <option value="price">Price</option>
                    <option value="orderStatus">Order Status</option>
                </select>
            </div>
            <div className="table">
                <table className="t">
                    <thead>
                        <tr>
                            <td scope="col"><strong>Order ID</strong></td>
                            <td scope="col"><strong>Order Status</strong></td>
                            <td scope="col"><strong>Ordered Date</strong></td>
                            <td scope="col"><strong>Delivery Date</strong></td>
                            <td scope="col"><strong>Total Amount</strong></td>
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

export default Ordersearch;