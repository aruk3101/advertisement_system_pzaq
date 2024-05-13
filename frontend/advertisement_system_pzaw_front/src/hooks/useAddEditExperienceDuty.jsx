import { useState } from "react";
import { toast } from "react-toastify";
import AlertList from "components/common/AlertList/AlertList";
import { useUser } from "./useUser";
import {
  AddUserExperience,
  AddUserExperienceDuty,
  EditUserExperience,
} from "services/api/UserExperienceService";
export default function useAddEditUserExperienceDuty() {
  const [errorAlerts, setErrorAlerts] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const { refresh } = useUser();

  const handleSubmit = (event, data, forceClose) => {
    event.preventDefault();
    setIsLoading(true);
    AddUserExperienceDuty(data).then((res) => {
      handle(res, forceClose);
    });
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
    refresh();
    forceClose();
    toast.success("Pomyślnie zmieniono dane użytkownika.", {
      position: toast.POSITION.BOTTOM_RIGHT,
    });
  };

  const Alerts = () => {
    return <AlertList errorAlerts={errorAlerts} />;
  };
  return { handleSubmit, Alerts, isLoading };
}
