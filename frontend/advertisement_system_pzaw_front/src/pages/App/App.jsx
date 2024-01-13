import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "components/Layout/Layout/Layout";
import Profile from "pages/Profile/Profile"
import AdvertisementList from "pages/AdvertisementsList/AdvertisementsList"
import Home from "pages/Home/Home"
import NotFoundPage from "pages/NotFoundPage/NotFoundPage"
import Advertisement from "pages/Advertisement/Advertisement"

function App() {
  return (
    <div className='container-fluid m-0 p-0'>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout/>}>
            <Route index element={<Home />} />
            <Route path="user/profile" element={<Profile />} />
            <Route path="advertisements" element={<AdvertisementList />} />
            <Route path="advertisement/:id" element={<Advertisement />} /> {/* To będzie zamienione na UUID z javy */}
            <Route path="*" element={<NotFoundPage />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
