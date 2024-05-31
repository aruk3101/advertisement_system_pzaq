import { useState } from "react";
import { toast } from "react-toastify";
import AlertList from "components/common/AlertList/AlertList";
import { AddResponsibility } from "services/api/ResponsibilityService";
export default function useAddResponsibility() {
  const [errorAlerts, setErrorAlerts] = useState([]);
  const [isLoading, setIsLoading] = useState(false);

  const handleSubmit = (event, data, forceClose, refreshMethod = null) => {
    event.preventDefault();
    setIsLoading(true);
    AddResponsibility(data).then((res) => {
      handle(res, forceClose, refreshMethod);
    });
  };

  const handle = (res, forceClose, refreshMethod) => {
    setIsLoading(false);
    if (!res.isSuccesfull) {
      if (res.status == 400) {
        let violations = res.violations;
        setErrorAlerts(
          violations.map((value) => {
            return value.reason;
          })
        );
      } else {
        setErrorAlerts([res.message]);
      }
      return;
    }
    if (refreshMethod != null) refreshMethod();
    forceClose();
    toast.success("Pomyślnie zmieniono ogłoszenie.", {
      position: toast.POSITION.BOTTOM_RIGHT,
    });
  };

  const Alerts = () => {
    return <AlertList errorAlerts={errorAlerts} />;
  };
  return { handleSubmit, Alerts, isLoading };
}
