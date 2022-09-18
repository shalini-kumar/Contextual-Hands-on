import React from 'react'
import "./Footer.css";

function Footer() {
    return (
        <div id="footer">
            <footer>
                <div className="copyright"> &copy; Copyright {new Date().getFullYear()}<strong> Shalini OMS Contextual Project</strong></div>
            </footer>
        </div>
    )
}
export default Footer
