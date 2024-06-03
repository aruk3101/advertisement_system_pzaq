import Card from "components/common/Card/Card";
import SvgButton from "components/common/SvgButton/SvgButton";
import defaultCompanyIcon from "assets/images/defaultCompanyPfp.png";
import { useAuth } from "hooks/useAuth";
import { EditPopupTrigger } from "components/EditPopup/EditPopup";

export default function Info({ company, refreshMethod = null }) {
  const { roles } = useAuth();
  return (
    <Card
      header={company.name}
      id="stanowisko"
      customMargin="mb-3 mt-5"
      beforeContent={
        <div className="banner position-relative bg-custom rounded-top">
          <div className="banner-icons m-2 position-absolute">
            <SvgButton
              href="#"
              svg={
                <svg
                  width="30px"
                  height="30px"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    fill-rule="evenodd"
                    clip-rule="evenodd"
                    d="M13.803 5.33333C13.803 3.49238 15.3022 2 17.1515 2C19.0008 2 20.5 3.49238 20.5 5.33333C20.5 7.17428 19.0008 8.66667 17.1515 8.66667C16.2177 8.66667 15.3738 8.28596 14.7671 7.67347L10.1317 10.8295C10.1745 11.0425 10.197 11.2625 10.197 11.4872C10.197 11.9322 10.109 12.3576 9.94959 12.7464L15.0323 16.0858C15.6092 15.6161 16.3473 15.3333 17.1515 15.3333C19.0008 15.3333 20.5 16.8257 20.5 18.6667C20.5 20.5076 19.0008 22 17.1515 22C15.3022 22 13.803 20.5076 13.803 18.6667C13.803 18.1845 13.9062 17.7255 14.0917 17.3111L9.05007 13.9987C8.46196 14.5098 7.6916 14.8205 6.84848 14.8205C4.99917 14.8205 3.5 13.3281 3.5 11.4872C3.5 9.64623 4.99917 8.15385 6.84848 8.15385C7.9119 8.15385 8.85853 8.64725 9.47145 9.41518L13.9639 6.35642C13.8594 6.03359 13.803 5.6896 13.803 5.33333Z"
                    fill="var(--custom_color_dark)"
                  />
                </svg>
              }
              variant="pill"
              border="custom-dark"
            />
            <SvgButton
              href="#"
              svg={
                <svg
                  width="30px"
                  height="30px"
                  viewBox="0 0 24 24"
                  xmlns="http://www.w3.org/2000/svg"
                  stroke="var(--custom_color_dark)"
                  stroke-width="2"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  fill="none"
                >
                  <path d="M12,21 L10.55,19.7051771 C5.4,15.1242507 2,12.1029973 2,8.39509537 C2,5.37384196 4.42,3 7.5,3 C9.24,3 10.91,3.79455041 12,5.05013624 C13.09,3.79455041 14.76,3 16.5,3 C19.58,3 22,5.37384196 22,8.39509537 C22,12.1029973 18.6,15.1242507 13.45,19.7149864 L12,21 Z" />
                </svg>
              }
              variant="pill"
              border="custom-dark"
            />
          </div>
          <img
            src={defaultCompanyIcon}
            className="object-fit-cover rounded-circle border border-5 border-custom-dark position-absolute pfp bg-custom"
            width={200}
            height={200}
          />
        </div>
      }
    >
      <hr />
      <span>
        {company.address.city} , {company.address.postalCode}{" "}
        {company.address.postalName}, &nbsp;
      </span>
      <span>{company.address.country}</span>
      <br />
      <span>
        {company.address.street} {company.address.streetNumber}/
        {company.address.apartmentNumber ?? company.address.apartmentNumber}
      </span>

      {roles != null && roles.includes("ROLE_ADMIN") ? (
        <EditPopupTrigger
          variant="company"
          element={company}
          refreshMethod={refreshMethod}
        />
      ) : (
        ""
      )}
    </Card>
  );
}
