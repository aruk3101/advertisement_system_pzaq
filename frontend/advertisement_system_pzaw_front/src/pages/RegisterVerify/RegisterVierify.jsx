import SpinnerView from "components/common/SpinnerView/SpinnerView";
import { useEffect } from "react";
import { useNavigate, useParams } from "react-router";
import { Activate } from "services/api/AuthService";
import { toast } from "react-toastify";

export default function RegisterVerify() {
  const { token } = useParams();
  const navigate = useNavigate();
  useEffect(() => {
    Activate(token).then((res) => {
      if (!res.isSuccesfull) {
        toast.error(
          "Wystąpił błąd, spróbuj ponownie lub skontaktuj się z administratorem.",
          {
            position: toast.POSITION.BOTTOM_RIGHT,
          }
        );
      } else {
        toast.success("Pomyślnie zweryfikowano. Teraz możesz się zalogować.", {
          position: toast.POSITION.BOTTOM_RIGHT,
        });
      }
      navigate("/");
    });
  }, [token]);

  return (
    <>
      <div className="container-md">
        <SpinnerView isLoading={true}>
          <div className="row"></div>
        </SpinnerView>
      </div>
    </>
  );
}
