import './App.css';
import Footer from './components/footer/Footer';
import Header from './components/header/Header';
import Home from './components/home/Home';
import Storesearch from './components/store/Storesearch';
import Products from './components/product/Product';
import LoginForm from './form/LoginForm';
import OrderItems from './components/order/Orderdetails';
import Ordersearch from './components/order/Ordersearch';
import Signin from './form/Signin';
import Welcome from './form/Form';
import Form from './form/LoginForm';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

function App() {
  return (
    <Router>
      <div>
        <Header />
        <Routes>
          <Route exact path="/" element={<Home />} /> */
          <Route exact path="/store" element={<Storesearch />} />
          <Route exact path="/order" element={<Ordersearch />} />
          <Route path="/store/product/:id" element={<Products />} />
          <Route path="/order/item/:id" element={<OrderItems />} />
          <Route exact path="/signup" element={<LoginForm />} />
          <Route path="/welcome" element={<Welcome />} />
          <Route path="/signin" element={<Signin />} />

        </Routes>
        <Footer />
      </div>
    </Router>
  );
}
export default App;
