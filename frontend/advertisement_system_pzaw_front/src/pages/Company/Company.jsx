import useCompany from "hooks/useCompany";
import { useParams } from "react-router";
import { useAuth } from "hooks/useAuth";
import { EditPopup, EditPopupTrigger } from "components/EditPopup/EditPopup";
import { useEffect } from "react";

function Company() {
  const { roles } = useAuth();
  let { id } = useParams();
  const { company, loading, setLoading, error, setError, fetchItems } =
    useCompany(id);

  useEffect(() => {
    console.log(company);
  }, [company]);

  return (
    <div>
      <EditPopup />
      <p>{JSON.stringify(company)}</p>
      {roles.includes("ROLE_ADMIN") ? (
        <EditPopupTrigger
          variant="company"
          element={company}
          refreshMethod={fetchItems}
        />
      ) : (
        ""
      )}
    </div>
  );
}
export default Company;
