import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "../Layout/Layout";
import Profile from "../Profile/Profile"
import AdvertisementList from "../AdvertisementsList/AdvertisementsList"
import Home from "../Home/Home"
import NotFoundPage from "../NotFoundPage/NotFoundPage"

function App() {
  return (
    <div className='container-fluid m-0 p-0'>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout/>}>
            <Route index element={<Home />} />
            <Route path="user/profile" element={<Profile />} />
            <Route path="advertisements" element={<AdvertisementList />} />
            <Route path="*" element={<NotFoundPage />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
