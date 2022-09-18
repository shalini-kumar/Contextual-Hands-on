import React, { useState, useEffect } from "react"
import axios from "axios"
import { Link } from "react-router-dom"
import "./Storesearch.css"

function Storesearch() {
    const [users, setUsers] = useState({})
    const [id, setId] = useState()
    const [idFrom, setIdFrom] = useState()

    const handle = () => {
        setIdFrom(id)
    }
    useEffect(() => {
        axios.get(`http://localhost:8082/store/id/${idFrom}`)
            .then((res) => {
                console.log(res)
                setUsers(res.data)
            })
            .catch((err) => {
                console.log(err)
            })
    }, [idFrom])

    return (
        <div>
            <div className="container">
                <h5>Enter Store ID:</h5>
                <input id="input" type="text" value={id} onChange={e => setId(e.target.value)}></input>
                <button onClick={handle}>Search</button>
            </div>

            <div className="result">
                <table class="table">
                    <thead>
                        <tr>
                            {/* <th scope="col">#</th> */}
                            <th scope="col">shop Name</th>
                            <th scope="col">Contact</th>
                            <th scope="col">EmailId</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            (Object.keys(users).length != 0 && users.shopName != null) ?
                            <tr>
                                <td><Link to={`/store/product/${users.id}`}>{users.shopName}</Link></td>
                                <td>{users.contactNumber}</td>
                                <td>{users.emailId}</td>
                            </tr>
                            :
                            ((users.id==0) ?  <td colSpan="3" align="center">Store Not Found</td>:null)
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default Storesearch;