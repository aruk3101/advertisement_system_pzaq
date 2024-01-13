import './Layout.css';
import {Outlet} from "react-router-dom";
import Header from "components/Layout/Header/Header";
import Footer from "components/Layout/Footer/Footer";

function Layout(props) {
  return (
    <div className={'d-flex flex-column min-vh-100 ' + (props.className ?? "")}>
      <Header/>
      <div className="flex-grow-1">
        <Outlet />  
      </div>
      <Footer/>
    </div>
  );
}

export default Layout;
