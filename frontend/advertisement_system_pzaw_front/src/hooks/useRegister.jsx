import { useNavigate } from "react-router";
import { useState } from "react";
import Alert from "components/common/Alert/Alert";
import {toast} from "react-toastify";
import { Register } from "services/api/AuthService";
import AlertList from "components/common/AlertList/AlertList";
export default function useRegister(){
    const [errorAlerts, setErrorAlerts] = useState([]);
    const [isLoading, setIsLoading] = useState(false);
    const navigate = useNavigate();

    const handleSubmit = (event, data) => {
        event.preventDefault();
        setIsLoading(true);
        Register(data.username, data.password, data.confirmPassword).then((res)=>{
            setIsLoading(false);
            if(!res.isSuccesfull){
                if(res.status == 400){
                    let violations = res.violations;
                    setErrorAlerts(violations.map((value)=>{
                        return value.reason;
                    }));
                }
                else {
                    setErrorAlerts([res.message]);
                }
                return;
            }
            navigate("/", { replace: true });
            toast.success("Pomyślnie zarejestrowano, Na podanego maila wysłano link weryfikacyjny.",{
                position: toast.POSITION.BOTTOM_RIGHT
            });
        })
    }

    const Alerts = ()=>{
        return <AlertList errorAlerts={errorAlerts}/>
    }
    return {handleSubmit, Alerts, isLoading};
}