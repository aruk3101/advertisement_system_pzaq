import { useNavigate } from "react-router";
import { useState } from "react";
import { toast } from "react-toastify";
import { EditUserData } from "services/api/UserDataService";
import AlertList from "components/common/AlertList/AlertList";
import { useUser } from "./useUser";
export default function useEditUserData() {
  const [errorAlerts, setErrorAlerts] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  const { setUser } = useUser();
  const navigate = useNavigate();

  const handleSubmit = (event, data, forceClose) => {
    event.preventDefault();
    setIsLoading(true);
    var dto = {
      firstName: data.firstName,
      lastName: data.lastName,
      birthDate: data.birthDate,
      phoneNumber: data.phoneNumber,
      updateAddressDto: {
        city: data.city,
        postalName: data.postalName,
        postalCode: data.postalCode,
        street: data.street,
        streetNumber: data.streetNumber,
        apartmentNumber: data.apartmentNumber,
        country: data.country,
        version: data.addressVersion,
      },
      careerSummary: data.careerSummary,
      currentPosition: data.currentPosition,
      version: data.version,
    };

    EditUserData(dto).then((res) => {
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
      setUser(res.data);
      forceClose();
      toast.success("Pomyślnie zmieniono dane użytkownika.", {
        position: toast.POSITION.BOTTOM_RIGHT,
      });
    });
  };

  const Alerts = () => {
    return <AlertList errorAlerts={errorAlerts} />;
  };
  return { handleSubmit, Alerts, isLoading };
}
