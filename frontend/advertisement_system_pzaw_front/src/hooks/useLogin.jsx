import { useAuth } from "./useAuth";
import { Login } from "services/api/AuthService";
import { useNavigate } from "react-router";
import { useState } from "react";
import { toast } from "react-toastify";
import AlertList from "components/common/AlertList/AlertList";

export default function () {
  const { setToken, setRoles } = useAuth();
  const navigate = useNavigate();
  const [errorAlerts, setErrorAlerts] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  const handleSubmit = (event, data) => {
    event.preventDefault();
    setIsLoading(true);
    Login(data.username, data.password).then((res) => {
      setIsLoading(false);
      if (!res.isSuccesfull) {
        if (res.status == 404) {
          let violations = res.data.violations;
        } else {
          setErrorAlerts([res.message]);
        }
        return;
      }
      setToken(res.data.token);
      setRoles(res.data.roles);
      navigate("/", { replace: true });
      toast.success("Pomyślnie zalogowano", {
        position: toast.POSITION.BOTTOM_RIGHT,
      });
    });
  };
  function Alerts() {
    return <AlertList errorAlerts={errorAlerts} />;
  }
  return { handleSubmit, Alerts, isLoading };
}
