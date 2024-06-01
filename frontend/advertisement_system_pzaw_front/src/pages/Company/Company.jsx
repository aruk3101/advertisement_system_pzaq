import useCompany from "hooks/useCompany";
import { useParams } from "react-router";
import { useAuth } from "hooks/useAuth";
import { EditPopup, EditPopupTrigger } from "components/EditPopup/EditPopup";
import SpinnerView from "components/common/SpinnerView/SpinnerView";
import Info from "./Info/Info";
import Localization from "pages/Advertisement/components/Localization/Localization";

function Company() {
  const { roles } = useAuth();
  let { id } = useParams();
  const { company, loading, setLoading, error, setError, fetchItems } =
    useCompany(id);

  return (
    <div>
      <EditPopup />
      <SpinnerView isLoading={loading}>
        <div className="bg-primary-subtle">
          <EditPopup />
          <div className="container gx-5 gy-2 p-1 p-sm-2 p-md-4">
            <div className="row">
              <div className="col-12 col-xl-9">
                <Info company={company} refreshMethod={fetchItems}></Info>
                <Localization company={company} />
              </div>
            </div>
          </div>
        </div>
      </SpinnerView>
    </div>
  );
}
export default Company;
