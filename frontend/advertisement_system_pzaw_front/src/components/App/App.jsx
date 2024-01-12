import './App.css';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "components/Layout/Layout";
import Profile from "components/Profile/Profile"
import AdvertisementList from "components/AdvertisementsList/AdvertisementsList"
import Home from "components/Home/Home"
import NotFoundPage from "components/NotFoundPage/NotFoundPage"
import Advertisement from "components/Advertisement/Advertisement"

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
