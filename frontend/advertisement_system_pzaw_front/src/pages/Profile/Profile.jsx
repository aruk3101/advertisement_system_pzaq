import "./Profile.css";
import "assets/css/fonts.css";
import "assets/css/profilePicture.css";
import Navigation from "./components/Navigation/Navigation";
import CurrentPosition from "./components/CurrentPosition/CurrentPosition";
import CareerSummary from "./components/CareerSummary/CareerSummary";
import Education from "./components/Education/Education";
import Experience from "./components/Experience/Experience";
import Skills from "./components/Skills/Skills";
import Courses from "./components/Courses/Courses";
import UserData from "./components/UserData/UserData";
import ContactData from "./components/ContactData/ContactData";
import PersonalData from "./components/PersonalData/PersonalData";
import Languages from "./components/Languages/Languages";
import Links from "./components/Links/Links";

function Profile() {
  return (
    <div className="bg-primary-subtle">
      <div className="container gx-5 gy-2 p-1 p-sm-2 p-md-4">
        <div className="row">
          <div className="col-12 col-xl-9">
            <UserData />
            <Navigation />
            <CurrentPosition />
            <CareerSummary />
            <Education />
            <Experience />
            <Skills />
            <Courses />
          </div>
          <div className="col-12 col-xl-3 position-relative">
            <ContactData />
            <PersonalData />
            <Languages />
            <Links />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Profile;
