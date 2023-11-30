import { Link } from 'react-router-dom';
import './Header.css';

function Header(props) {
  return (
    <nav className={"navbar navbar-expand-lg bg-primary p-2 " + (props.className ?? "")}>
      <div className="container-md">
          <Link to={"/"} className='navbar-brand'>
            <img src="img/logo/logo-no-background.svg" height="50"/>
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
          <form className="d-flex me-auto ms-auto" role="search">
            <input className="form-control rounded-0" type="search" placeholder="Search" aria-label="Search"/>
            <button className="btn bg-white rounded-0" type="submit">
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
              </svg>
            </button>
          </form>
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
