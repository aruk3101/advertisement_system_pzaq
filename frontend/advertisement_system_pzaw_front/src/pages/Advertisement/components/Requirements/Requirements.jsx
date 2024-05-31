import Card from "components/common/Card/Card";
import ListItem from "../ListItem/ListItem";
import { useAuth } from "hooks/useAuth";
import { EditPopupTrigger } from "components/EditPopup/EditPopup";

export default function Requirements({
  requirements,
  refreshMethod = null,
  advertisementUuid = null,
}) {
  const { roles } = useAuth();
  return (
    <Card header="Wymagania" id="wymagania" bootstrapFontsize="fs-3">
      {requirements.map((value) => {
        return (
          <ListItem
            variant="Requirement"
            uuid={value.uuid}
            text={value.name}
            refreshMethod={refreshMethod}
            svg={
              <svg
                fill="var(--custom_color_dark)"
                version="1.1"
                id="Capa_1"
                xmlns="http://www.w3.org/2000/svg"
                width="30px"
                height="30px"
                viewBox="0 0 47 47"
              >
                <g>
                  <g id="Layer_1_22_">
                    <g>
                      <path
                        d="M6.12,38.52V5.136h26.962v28.037l5.137-4.243V2.568C38.219,1.15,37.07,0,35.652,0h-32.1C2.134,0,0.985,1.15,0.985,2.568
                      v38.519c0,1.418,1.149,2.568,2.567,2.568h22.408L22.33,38.52H6.12z"
                      />
                      <path
                        d="M45.613,27.609c-0.473-0.446-1.2-0.467-1.698-0.057l-11.778,9.734l-7.849-4.709c-0.521-0.312-1.188-0.219-1.603,0.229
                      c-0.412,0.444-0.457,1.117-0.106,1.613l8.506,12.037c0.238,0.337,0.625,0.539,1.037,0.543c0.004,0,0.008,0,0.012,0
                      c0.408,0,0.793-0.193,1.035-0.525l12.6-17.173C46.149,28.78,46.084,28.055,45.613,27.609z"
                      />
                      <path
                        d="M27.306,8.988H11.897c-1.418,0-2.567,1.15-2.567,2.568s1.149,2.568,2.567,2.568h15.408c1.418,0,2.566-1.15,2.566-2.568
                      S28.724,8.988,27.306,8.988z"
                      />
                      <path
                        d="M27.306,16.691H11.897c-1.418,0-2.567,1.15-2.567,2.568s1.149,2.568,2.567,2.568h15.408c1.418,0,2.566-1.149,2.566-2.568
                      C29.874,17.841,28.724,16.691,27.306,16.691z"
                      />
                      <path
                        d="M27.306,24.395H11.897c-1.418,0-2.567,1.15-2.567,2.568s1.149,2.568,2.567,2.568h15.408c1.418,0,2.566-1.15,2.566-2.568
                      C29.874,25.545,28.724,24.395,27.306,24.395z"
                      />
                    </g>
                  </g>
                </g>
              </svg>
            }
          />
        );
      })}
      {roles.includes("ROLE_ADMIN") ? (
        <EditPopupTrigger
          variant="requirement"
          secondaryUuid={advertisementUuid}
          refreshMethod={refreshMethod}
        ></EditPopupTrigger>
      ) : (
        ""
      )}
    </Card>
  );
}
