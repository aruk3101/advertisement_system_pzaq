import { Link } from 'react-router-dom';
import './Header.css';
import logoNoBackground from "assets/images/logo/logo-no-background.svg"
import SearchBar from 'components/common/SearchBar/SearchBar';

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
          <ul className="navbar-nav">
            <li className="nav-item dropdown">
              <a className="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                Moje konto
              </a>
              <ul class="dropdown-menu mb-2 mb-lg-0">
                <li><a className="dropdown-item" href="#">Profil Użytkownika</a></li>
                <li><a className="dropdown-item" href="#">Ulubione</a></li>
                <li><a className="dropdown-item" href="#">Aplikacje</a></li>
                <li><hr className="dropdown-divider"/></li>
                <li><a className="dropdown-item" href="#">Wyloguj</a></li>
              </ul>
            </li> 
          </ul>
        </div>
      </div>
       {/* <div className={"bg-primary p-2 " + props.className}>
      <div className='container-md'>
      
      </div>
    </div> */}
    </nav>
   
  );
}

export default Header;
