import "./Layout.css";
import { Outlet } from "react-router-dom";
import Header from "components/Layout/Header/Header";
import Footer from "components/Layout/Footer/Footer";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function Layout(props) {
  return (
    <div className={"d-flex flex-column min-vh-100 " + (props.className ?? "")}>
      <Header />
      <div className="flex-grow-1">
        <Outlet />
      </div>
      <Footer />
      <ToastContainer />
    </div>
  );
}

export default Layout;
