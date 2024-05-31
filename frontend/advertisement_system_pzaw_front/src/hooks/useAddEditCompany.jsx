import { useNavigate } from "react-router";
import { useState } from "react";
import { toast } from "react-toastify";
import AlertList from "components/common/AlertList/AlertList";
import { AddCompany, EditCompany } from "services/api/CompanyService";
export default function useAddEditCompany() {
  const [errorAlerts, setErrorAlerts] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const navigate = useNavigate();

  const handleSubmit = (event, data, forceClose, element, refreshMethod) => {
    event.preventDefault();
    setIsLoading(true);
    if (element == null) {
      AddCompany(data).then((res) => {
        refreshMethod();
        handle(res, forceClose);
      });
    } else {
      EditCompany(data, element.uuid).then((res) => {
        refreshMethod();
        handle(res, forceClose);
      });
    }
  };

  const handle = (res, forceClose) => {
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
    forceClose();
    toast.success("Operacja przebiegła pomyślnie.", {
      position: toast.POSITION.BOTTOM_RIGHT,
    });
  };

  const Alerts = () => {
    return <AlertList errorAlerts={errorAlerts} />;
  };
  return { handleSubmit, Alerts, isLoading };
}
