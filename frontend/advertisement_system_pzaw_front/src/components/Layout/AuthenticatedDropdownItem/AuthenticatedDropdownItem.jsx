import { Link } from "react-router-dom";
import { useAuth } from "hooks/useAuth";
import { useNavigate } from "react-router-dom";
import {toast} from "react-toastify";

export default function AuthenticaedDropdownItem(){
    const {setToken} = useAuth();
    const navigate = useNavigate();
    return (
        <>
            <li><a className="dropdown-item" href="#">Profil Użytkownika</a></li>
            <li><a className="dropdown-item" href="#">Ulubione</a></li>
            <li><a className="dropdown-item" href="#">Aplikacje</a></li>
            <li><hr className="dropdown-divider"/></li>
            <li><Link className="dropdown-item"onClick={()=>{
                toast.success("Pomyślnie wylogowano",{
                    position: toast.POSITION.BOTTOM_RIGHT
                });
                setToken(null);
                navigate("../");
            }}>Wyloguj</Link></li>
        </>
    )
}