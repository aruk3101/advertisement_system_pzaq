import { EditPopup, EditPopupTrigger } from "components/EditPopup/EditPopup";
import { useAuth } from "hooks/useAuth";
import Companies from "./components/Companies/Companies";
import Advertisements from "./components/Advertisements/Advertisements";

function AdminPanel() {
  const { roles } = useAuth();
  if (roles == null || !roles.includes("ROLE_ADMIN")) {
    return <p>Access denied.</p>;
  }
  return (
    <div>
      <EditPopup />
      <Companies></Companies>
      <br />
      <Advertisements></Advertisements>
    </div>
  );
}

export default AdminPanel;
