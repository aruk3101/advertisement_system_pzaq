import { Link } from 'react-router-dom';
import './Header.css';
import logoNoBackground from "assets/images/logo/logo-no-background.svg"
import SearchBar from 'components/common/SearchBar/SearchBar';
import MyAccountDrodown from '../MyAccountDropdown/MyAccountDropdown';

function Header(props) {
  return (
    <nav className={"navbar navbar-expand-lg bg-primary p-2 " + (props.className ?? "")}>
      <div className="container-md">
          <Link to={"/"} className='navbar-brand'>
            <img src={logoNoBackground} height="50"/>
          </Link>
        <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav mb-2 mb-lg-0">
            <li class="nav-item">
              <Link to={"/"} className='nav-link text-white'>
                Ogłoszenia
              </Link>
            </li>
            <li class="nav-item">
              <Link to={"/"} className='nav-link text-white'>
                Dla Firm
              </Link>
            </li>
          </ul>
          <SearchBar/>
          <MyAccountDrodown/>
        </div>
      </div>
    </nav>
   
  );
}

export default Header;
