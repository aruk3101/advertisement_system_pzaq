import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "components/Layout/Layout/Layout";
import Profile from "pages/Profile/Profile";
import AdvertisementList from "pages/AdvertisementsList/AdvertisementsList";
import Home from "pages/Home/Home";
import NotFoundPage from "pages/NotFoundPage/NotFoundPage";
import Advertisement from "pages/Advertisement/Advertisement";
import LoginPage from "pages/LoginPage/LoginPage";
import AuthProvider from "services/contexts/providers/AuthProvider";
import RegisterPage from "pages/RegisterPage/RegisterPage";
import RegisterVerify from "pages/RegisterVerify/RegisterVierify";

function App() {
  return (
    <div className="container-fluid m-0 p-0">
      <AuthProvider>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Layout />}>
              <Route index element={<Home />} />
              <Route path="user/profile" element={<Profile />} />
              <Route path="advertisements" element={<AdvertisementList />} />
              <Route
                path="advertisement/:id"
                element={<Advertisement />}
              />{" "}
              {/* To będzie zamienione na UUID z javy */}
              <Route path="login" element={<LoginPage />} />
              <Route path="register" element={<RegisterPage />} />
              <Route
                path="register/verify/:token"
                element={<RegisterVerify />}
              />
              <Route path="*" element={<NotFoundPage />} />
            </Route>
          </Routes>
        </BrowserRouter>
      </AuthProvider>
    </div>
  );
}

export default App;
