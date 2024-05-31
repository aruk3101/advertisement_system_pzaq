import Card from "components/common/Card/Card";
import ListItem from "../ListItem/ListItem";
import { useAuth } from "hooks/useAuth";
import { EditPopupTrigger } from "components/EditPopup/EditPopup";

export default function Opportunities({
  opportunities,
  refreshMethod = null,
  advertisementUuid = null,
}) {
  const { roles } = useAuth();
  return (
    <Card header="Benefity, możliwości" id="benefity" bootstrapFontsize="fs-3">
      {opportunities.map((value) => {
        return (
          <ListItem
            variant="Opportunity"
            uuid={value.uuid}
            text={value.name}
            refreshMethod={refreshMethod}
            svg={
              <svg
                width="30px"
                height="30px"
                viewBox="0 0 24 24"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
              >
                <circle
                  cx="12"
                  cy="12"
                  r="10"
                  stroke="var(--custom_color_dark)"
                  stroke-width="2"
                />
                <path
                  d="M15 9.94728C14.5 9.3 13.8 8.5 12 8.5C10.2 8.5 9 9.51393 9 9.94728C9 10.3806 9.06786 10.9277 10 11.5C10.7522 11.9618 12.6684 12.0439 13.5 12.5C14.679 13.1467 14.8497 13.8202 14.8497 14.0522C14.8497 14.6837 13.4175 15.4852 12 15.5C10.536 15.5153 9.5 14.7 9 14.0522"
                  stroke="var(--custom_color_dark)"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
                <path
                  d="M12 7V17"
                  stroke="var(--custom_color_dark)"
                  stroke-width="1.5"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
            }
          />
        );
      })}
      {roles.includes("ROLE_ADMIN") ? (
        <EditPopupTrigger
          variant="opportunity"
          secondaryUuid={advertisementUuid}
          refreshMethod={refreshMethod}
        ></EditPopupTrigger>
      ) : (
        ""
      )}
    </Card>
  );
}
