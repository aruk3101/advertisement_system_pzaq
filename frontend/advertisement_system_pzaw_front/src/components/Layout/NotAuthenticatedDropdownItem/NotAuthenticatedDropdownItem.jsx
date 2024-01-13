import { Link } from "react-router-dom";

export default function NotAuthenticatedDrodownItem(){
    return (
        <>
            <li><Link className="dropdown-item" to="/login">Zaloguj się</Link></li>
            <li><Link className="dropdown-item" to="/register">Zarejestruj się</Link></li>
        </>
    )
}