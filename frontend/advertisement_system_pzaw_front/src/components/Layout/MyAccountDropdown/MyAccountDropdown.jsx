import { useAuth } from "hooks/useAuth";
import MyAccount from "../AuthenticatedDropdownItem/AuthenticatedDropdownItem";
import NotAuthenticatedDrodownItem from "../NotAuthenticatedDropdownItem/NotAuthenticatedDropdownItem";

export default function MyAccountDrodown() {
  const { token } = useAuth();

  return (
    <ul className="navbar-nav">
      <li className="nav-item dropdown">
        <a
          className="nav-link dropdown-toggle text-white"
          href="#"
          role="button"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          Moje konto
        </a>
        <ul class="dropdown-menu mb-2 mb-lg-0">
          {token ? <MyAccount /> : <NotAuthenticatedDrodownItem />}
        </ul>
      </li>
    </ul>
  );
}
