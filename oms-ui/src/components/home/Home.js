import React from "react";
import "./Home.css"
const Home = () => {
  return (
    <div className="home_screen">
      <div className="home_screen__content">
          <div className="home_heading">
            <h1>
              Welcome to Order Management System !!</h1>
          </div>
        <div className="home_image_content">
          <div className="home_image">
            <img
              src="https://designingkeeda.com/images/service/e-commerce-website-design.png"
              alt="Image"
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;