import { useNavigate } from "react-router";
import { useState } from "react";
import { toast } from "react-toastify";
import AlertList from "components/common/AlertList/AlertList";
import { useUser } from "./useUser";
import { AddUserLink, EditUserLink } from "services/api/UserLinksService";
export default function useAddEditUserLink() {
  const [errorAlerts, setErrorAlerts] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const { refresh } = useUser();
  const navigate = useNavigate();

  const handleSubmit = (event, data, forceClose, element) => {
    event.preventDefault();
    setIsLoading(true);
    if (element == null) {
      AddUserLink(data).then((res) => {
        handle(res, forceClose);
      });
    } else {
      EditUserLink(data, element.uuid).then((res) => {
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
