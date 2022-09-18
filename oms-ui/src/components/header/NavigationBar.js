import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import './NavigationBar.css';

const Navbar = () => {
	return (
		<nav className="navbar">
			<ul className='links'>
				<li className="display-item">
					<Link to="/" className="link">
						Home
					</Link>
				</li>
				<li className="display-item">
					<Link to="/store" className="link">
						Store
					</Link>
				</li>
				<li><Link to="/welcome">Login</Link></li>

				<li className="display-item">
					<Link to="/order" className="link">
						Order
					</Link>
				</li>
				{/* <li className="display-item">
					<Link to="/account" className="link" >
						Account
					</Link>
				</li> */}
			</ul>
		</nav>
	);
};

export default Navbar;