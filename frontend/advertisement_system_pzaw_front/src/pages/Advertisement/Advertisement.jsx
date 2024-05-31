import "./Advertisement.css";
import { useParams } from "react-router-dom";
import "assets/css/fonts.css";
import "assets/css/profilePicture.css";
import NavigationCard from "components/NavigationCard/NavigationCard";
import Position from "./components/Position/Position";
import Localization from "./components/Localization/Localization";
import Responsibilities from "./components/Responsibilities/Responsibilites";
import Requirements from "./components/Requirements/Requirements";
import Opportunities from "./components/Opportunities/Opportunities";
import AdvertisementUuid from "./components/AdvertisementUuid/AdvertisementUuid";
import ApplyButton from "./components/ApplyButton/ApplyButton";
import SimiliarOffersCard from "./components/SimiliarOffersCard/SimiliarOffersCard";
import { shadeColor } from "utils/color";
import useAdvertisement from "hooks/useAdvertisement";
import { EditPopup } from "components/EditPopup/EditPopup";

function Advertisement() {
  let { id } = useParams();
  const { advertisement, loading, setLoading, error, setError, fetchItems } =
    useAdvertisement(id);
  let color;
  if (color == null) {
    color = "#0dccf2";
  }
  // kolor będzie można wybrać przy tworzeniu ogłoszenia i przekazywny tutaj z api
  document.documentElement.style.setProperty("--custom_color", color);
  document.documentElement.style.setProperty(
    "--custom_color_dark",
    shadeColor(color, -40)
  );
  if (error != null) return error;
  if (loading == true) return "Loading...";

  console.log(advertisement);

  return (
    <div className="bg-primary-subtle">
      <EditPopup />
      <div className="container gx-5 gy-2 p-1 p-sm-2 p-md-4">
        <div className="row">
          <div className="col-12 col-xl-9">
            <Position
              advertisement={advertisement}
              refreshMethod={fetchItems}
            />
            <NavigationCard
              data={[
                { href: "#stanowisko", header: "Stanowisko" },
                { href: "#lokalizacja", header: "Lokalizacja" },
                { href: "#obowiazki", header: "Obowiązki" },
                { href: "#wymagania", header: "Wymagania" },
                { href: "#benefity", header: "Benefity, możliwości" },
              ]}
            />
            <Localization iframeLink={advertisement.company.iframeHyperlink} />
            <Responsibilities
              responsibilites={advertisement.advertisementResponsibilities}
              refreshMethod={fetchItems}
              advertisementUuid={advertisement.uuid}
            />
            <Requirements
              requirements={advertisement.advertisementRequirements}
              refreshMethod={fetchItems}
              advertisementUuid={advertisement.uuid}
            />
            <Opportunities
              opportunities={advertisement.advertisementOpportunities}
              refreshMethod={fetchItems}
              advertisementUuid={advertisement.uuid}
            />
            <AdvertisementUuid id={id} />
          </div>
          <div className="col-12 col-xl-3 position-relative">
            <ApplyButton />
            <SimiliarOffersCard />
          </div>
        </div>
      </div>
    </div>
  );
}

export default Advertisement;
