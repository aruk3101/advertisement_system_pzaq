import Card from "components/common/Card/Card";
import Attribute from "components/common/Attribute/Attribute";
import SvgButton from "components/common/SvgButton/SvgButton";
import defaultCompanyIcon from "assets/images/defaultCompanyPfp.png";
import { useAuth } from "hooks/useAuth";
import { EditPopupTrigger } from "components/EditPopup/EditPopup";

export default function Position({ advertisement, refreshMethod = null }) {
  const { roles } = useAuth();
  return (
    <Card
      header={advertisement.position}
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
      <a href={"http://localhost:3000/company/" + advertisement.company.uuid}>
        {advertisement.company.name}
      </a>
      <hr />
      <div className="container-flex">
        <div className="row">
          <div className="col-12 col-sm-6">
            <Attribute
              header={advertisement.contractType.name}
              svgIcon={
                <svg
                  width="30px"
                  height="30px"
                  viewBox="0 0 1024 1024"
                  class="icon"
                  version="1.1"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M182.52 146.2h585.14v256h73.15V73.06H109.38v877.71h256v-73.14H182.52z"
                    fill="var(--custom_color_dark)"
                  />
                  <path
                    d="M255.67 219.34h438.86v73.14H255.67zM255.67 365.63h365.71v73.14H255.67zM255.67 511.91H475.1v73.14H255.67zM775.22 458.24L439.04 794.42l-0.52 154.64 155.68 0.52L930.38 613.4 775.22 458.24z m51.72 155.16l-25.43 25.43-51.73-51.72 25.44-25.44 51.72 51.73z m-77.14 77.15L620.58 819.77l-51.72-51.72 129.22-129.22 51.72 51.72zM511.91 876.16l0.17-51.34 5.06-5.06 51.72 51.72-4.85 4.85-52.1-0.17z"
                    fill="var(--custom_color_dark)"
                  />
                </svg>
              }
            />
          </div>
          <div className="col-12 col-sm-6">
            <Attribute
              header="Ważna jeszcze x dni"
              subHeader={"do " + advertisement.expirationDate}
              svgIcon={
                <svg
                  width="30px"
                  height="30px"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M12 21C16.9706 21 21 16.9706 21 12C21 7.02944 16.9706 3 12 3C7.02944 3 3 7.02944 3 12C3 16.9706 7.02944 21 12 21Z"
                    stroke="var(--custom_color_dark)"
                    stroke-width="1.5"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                  <path
                    d="M12 6V12"
                    stroke="var(--custom_color_dark)"
                    stroke-width="1.5"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                  <path
                    d="M16.24 16.24L12 12"
                    stroke="var(--custom_color_dark)"
                    stroke-width="1.5"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                </svg>
              }
            />
          </div>
          <div className="col-12 col-sm-6">
            <Attribute
              header={advertisement.workingTimeType.name}
              svgIcon={
                <svg
                  width="30px"
                  height="30px"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M12 6.5C12 6.26077 12 6.14115 12.0807 6.06687C12.1615 5.99259 12.2741 6.002 12.4994 6.02082C13.3784 6.09424 14.2326 6.36078 15 6.80385C15.9121 7.33046 16.6695 8.08788 17.1962 9C17.7228 9.91212 18 10.9468 18 12C18 13.0532 17.7228 14.0879 17.1962 15C16.6695 15.9121 15.9121 16.6695 15 17.1962C14.0879 17.7228 13.0532 18 12 18C10.9468 18 9.91211 17.7228 9 17.1962C8.23258 16.7531 7.57467 16.1466 7.07159 15.4221C6.94265 15.2364 6.87817 15.1435 6.90213 15.0365C6.92608 14.9294 7.02968 14.8696 7.23686 14.75L11.75 12.1443C11.872 12.0739 11.933 12.0387 11.9665 11.9807C12 11.9226 12 11.8522 12 11.7113V6.5Z"
                    fill="var(--custom_color_dark)"
                  />
                  <circle
                    cx="12"
                    cy="12"
                    r="9"
                    stroke="var(--custom_color_dark)"
                    stroke-width="2"
                  />
                </svg>
              }
            />
          </div>
          <div className="col-12 col-sm-6">
            <Attribute
              header={advertisement.positionLevel.name}
              svgIcon={
                <svg
                  width="30px"
                  height="30px"
                  viewBox="0 0 24 24"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M5.08884 9.2945C5.26942 9.72155 5.69482 10 6.16669 10H9V21C9 21.5523 9.44772 22 10 22H14C14.5523 22 15 21.5523 15 21V10H17.8333C18.3052 10 18.7306 9.72155 18.9112 9.2945C19.0917 8.86744 18.9919 8.37588 18.6583 8.04902L12.825 2.33474C12.3693 1.88842 11.6307 1.88842 11.175 2.33474L5.34174 8.04902C5.00808 8.37588 4.90826 8.86744 5.08884 9.2945Z"
                    fill="var(--custom_color_dark)"
                  />
                </svg>
              }
            />
          </div>
          <div className="col-12 col-sm-6">
            <Attribute
              header={advertisement.jobType.name}
              svgIcon={
                <svg
                  fill="var(--custom_color_dark)"
                  height="30px"
                  width="30px"
                  version="1.1"
                  id="Layer_1"
                  xmlns="http://www.w3.org/2000/svg"
                  viewBox="0 0 508 508"
                >
                  <g>
                    <g>
                      <path
                        d="M493.9,150.5H281.1c-14-64.3-56.5-111.3-106.6-111.3c-50.1,0-92.6,46.9-106.6,111.3H14.1c-7.8,0-14.1,6.3-14.1,14.1v290.1
                              c0,7.8,6.3,14.1,14.1,14.1c7.8,0,14.1-6.3,14.1-14.1v-276h35.5c-0.5,5.9-0.7,11.9-0.7,17.9c0,36.5,8.9,71.2,24.7,98.9h-9.9
                              c-7.8,0-14.1,6.3-14.1,14.1s6.3,14.1,14.1,14.1h82.6v72.7h-41.8c-5,0-9.7,2.7-12.2,7l-18.5,31.9c-3.9,6.7-1.6,15.4,5.1,19.3
                              c6.8,3.9,15.4,1.6,19.3-5.1l14.4-24.8h33.7v17.7c0,7.8,6.3,14.1,14.1,14.1s14.1-6.3,14.1-14.1v-17.7h33.7l14.4,24.8
                              c3.9,6.6,13.9,8.2,19.3,5.1c6.8-3.8,9-12.6,5.1-19.3l-18.5-31.9c-2.5-4.3-7.2-7-12.2-7h-41.8v-72.7h82.6c7.8,0,14.1-6.3,14.1-14.1
                              c0-7.8-6.3-14.1-14.1-14.1h-9.9c15.8-27.7,24.7-62.4,24.7-98.9c0-6.1-0.3-12-0.7-17.9h35.5v235.8c0,7.8,6.3,14.1,14.1,14.1h144.9
                              v26c0,7.8,6.3,14.1,14.1,14.1c7.8,0,14.1-6.3,14.1-14.1v-290C508,156.8,501.7,150.5,493.9,150.5z M228.3,294.6H120.7
                              c-18.8-24.8-29.5-60.1-29.5-98c0-71.2,37.4-129.2,83.3-129.2c45.9,0,83.3,58,83.3,129.2C257.8,234.6,247.1,269.9,228.3,294.6z
                              M479.8,400.4H349V272.8h130.8V400.4z M479.8,244.6H349v-65.9h130.8V244.6z"
                      />
                    </g>
                  </g>
                  <g>
                    <g>
                      <path d="M388.2,307c-7.8,0-14.1,6.3-14.1,14.1V352c0,7.8,6.3,14.1,14.1,14.1s14.1-6.3,14.1-14.1v-30.9 C402.3,313.3,396,307,388.2,307z" />
                    </g>
                  </g>
                  <g>
                    <g>
                      <path d="M429.8,197.5h-30.9c-7.8,0-14.1,6.3-14.1,14.1s6.3,14.1,14.1,14.1h30.9c7.8,0,14.1-6.3,14.1-14.1S437.6,197.5,429.8,197.5z" />
                    </g>
                  </g>
                </svg>
              }
            />
          </div>
        </div>
        <hr />
        <div className="row">
          <div className="col-12 col-sm-6">
            <Attribute
              header={advertisement.workingDays}
              svgIcon={
                <svg
                  width="30px"
                  height="30px"
                  viewBox="-0.5 0 25 25"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M12 21.5C17.1086 21.5 21.25 17.3586 21.25 12.25C21.25 7.14137 17.1086 3 12 3C6.89137 3 2.75 7.14137 2.75 12.25C2.75 17.3586 6.89137 21.5 12 21.5Z"
                    stroke="var(--custom_color_dark)"
                    stroke-width="1.5"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                  <path
                    d="M12.9309 8.15005C12.9256 8.39231 12.825 8.62272 12.6509 8.79123C12.4767 8.95974 12.2431 9.05271 12.0008 9.05002C11.8242 9.04413 11.6533 8.98641 11.5093 8.884C11.3652 8.7816 11.2546 8.63903 11.1911 8.47415C11.1275 8.30927 11.1139 8.12932 11.152 7.95675C11.19 7.78419 11.278 7.6267 11.405 7.50381C11.532 7.38093 11.6923 7.29814 11.866 7.26578C12.0397 7.23341 12.2192 7.25289 12.3819 7.32181C12.5446 7.39072 12.6834 7.506 12.781 7.65329C12.8787 7.80057 12.9308 7.97335 12.9309 8.15005ZM11.2909 16.5301V11.1501C11.2882 11.0556 11.3046 10.9615 11.3392 10.8736C11.3738 10.7857 11.4258 10.7057 11.4922 10.6385C11.5585 10.5712 11.6378 10.518 11.7252 10.4822C11.8126 10.4464 11.9064 10.4286 12.0008 10.43C12.094 10.4299 12.1863 10.4487 12.272 10.4853C12.3577 10.5218 12.4352 10.5753 12.4997 10.6426C12.5642 10.7099 12.6143 10.7895 12.6472 10.8767C12.6801 10.9639 12.6949 11.0569 12.6908 11.1501V16.5301C12.6908 16.622 12.6727 16.713 12.6376 16.7979C12.6024 16.8828 12.5508 16.96 12.4858 17.025C12.4208 17.09 12.3437 17.1415 12.2588 17.1767C12.1738 17.2119 12.0828 17.23 11.9909 17.23C11.899 17.23 11.8079 17.2119 11.723 17.1767C11.6381 17.1415 11.5609 17.09 11.4959 17.025C11.4309 16.96 11.3793 16.8828 11.3442 16.7979C11.309 16.713 11.2909 16.622 11.2909 16.5301Z"
                    fill="var(--custom_color_dark)"
                  />
                </svg>
              }
            />
          </div>
          <div className="col-12 col-sm-6">
            <Attribute
              header={advertisement.workingHours}
              svgIcon={
                <svg
                  width="30px"
                  height="30px"
                  viewBox="-0.5 0 25 25"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M12 21.5C17.1086 21.5 21.25 17.3586 21.25 12.25C21.25 7.14137 17.1086 3 12 3C6.89137 3 2.75 7.14137 2.75 12.25C2.75 17.3586 6.89137 21.5 12 21.5Z"
                    stroke="var(--custom_color_dark)"
                    stroke-width="1.5"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                  <path
                    d="M12.9309 8.15005C12.9256 8.39231 12.825 8.62272 12.6509 8.79123C12.4767 8.95974 12.2431 9.05271 12.0008 9.05002C11.8242 9.04413 11.6533 8.98641 11.5093 8.884C11.3652 8.7816 11.2546 8.63903 11.1911 8.47415C11.1275 8.30927 11.1139 8.12932 11.152 7.95675C11.19 7.78419 11.278 7.6267 11.405 7.50381C11.532 7.38093 11.6923 7.29814 11.866 7.26578C12.0397 7.23341 12.2192 7.25289 12.3819 7.32181C12.5446 7.39072 12.6834 7.506 12.781 7.65329C12.8787 7.80057 12.9308 7.97335 12.9309 8.15005ZM11.2909 16.5301V11.1501C11.2882 11.0556 11.3046 10.9615 11.3392 10.8736C11.3738 10.7857 11.4258 10.7057 11.4922 10.6385C11.5585 10.5712 11.6378 10.518 11.7252 10.4822C11.8126 10.4464 11.9064 10.4286 12.0008 10.43C12.094 10.4299 12.1863 10.4487 12.272 10.4853C12.3577 10.5218 12.4352 10.5753 12.4997 10.6426C12.5642 10.7099 12.6143 10.7895 12.6472 10.8767C12.6801 10.9639 12.6949 11.0569 12.6908 11.1501V16.5301C12.6908 16.622 12.6727 16.713 12.6376 16.7979C12.6024 16.8828 12.5508 16.96 12.4858 17.025C12.4208 17.09 12.3437 17.1415 12.2588 17.1767C12.1738 17.2119 12.0828 17.23 11.9909 17.23C11.899 17.23 11.8079 17.2119 11.723 17.1767C11.6381 17.1415 11.5609 17.09 11.4959 17.025C11.4309 16.96 11.3793 16.8828 11.3442 16.7979C11.309 16.713 11.2909 16.622 11.2909 16.5301Z"
                    fill="var(--custom_color_dark)"
                  />
                </svg>
              }
            />
          </div>
        </div>
        <hr />
        <div className="row">
          <div className="col-12 col-sm-6">
            <Attribute
              header={advertisement.advertisementCategory.name}
              svgIcon={
                <svg
                  width="30px"
                  height="30px"
                  viewBox="-0.5 0 25 25"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M12 21.5C17.1086 21.5 21.25 17.3586 21.25 12.25C21.25 7.14137 17.1086 3 12 3C6.89137 3 2.75 7.14137 2.75 12.25C2.75 17.3586 6.89137 21.5 12 21.5Z"
                    stroke="var(--custom_color_dark)"
                    stroke-width="1.5"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                  <path
                    d="M12.9309 8.15005C12.9256 8.39231 12.825 8.62272 12.6509 8.79123C12.4767 8.95974 12.2431 9.05271 12.0008 9.05002C11.8242 9.04413 11.6533 8.98641 11.5093 8.884C11.3652 8.7816 11.2546 8.63903 11.1911 8.47415C11.1275 8.30927 11.1139 8.12932 11.152 7.95675C11.19 7.78419 11.278 7.6267 11.405 7.50381C11.532 7.38093 11.6923 7.29814 11.866 7.26578C12.0397 7.23341 12.2192 7.25289 12.3819 7.32181C12.5446 7.39072 12.6834 7.506 12.781 7.65329C12.8787 7.80057 12.9308 7.97335 12.9309 8.15005ZM11.2909 16.5301V11.1501C11.2882 11.0556 11.3046 10.9615 11.3392 10.8736C11.3738 10.7857 11.4258 10.7057 11.4922 10.6385C11.5585 10.5712 11.6378 10.518 11.7252 10.4822C11.8126 10.4464 11.9064 10.4286 12.0008 10.43C12.094 10.4299 12.1863 10.4487 12.272 10.4853C12.3577 10.5218 12.4352 10.5753 12.4997 10.6426C12.5642 10.7099 12.6143 10.7895 12.6472 10.8767C12.6801 10.9639 12.6949 11.0569 12.6908 11.1501V16.5301C12.6908 16.622 12.6727 16.713 12.6376 16.7979C12.6024 16.8828 12.5508 16.96 12.4858 17.025C12.4208 17.09 12.3437 17.1415 12.2588 17.1767C12.1738 17.2119 12.0828 17.23 11.9909 17.23C11.899 17.23 11.8079 17.2119 11.723 17.1767C11.6381 17.1415 11.5609 17.09 11.4959 17.025C11.4309 16.96 11.3793 16.8828 11.3442 16.7979C11.309 16.713 11.2909 16.622 11.2909 16.5301Z"
                    fill="var(--custom_color_dark)"
                  />
                </svg>
              }
            />
          </div>
        </div>
        <hr />
        <div className="row">
          <div className="col-12 col-sm-6">
            <Attribute
              header={advertisement.salaryFrom}
              svgIcon={
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  height="24px"
                  viewBox="0 -960 960 960"
                  width="24px"
                  fill="#000000"
                >
                  <path d="M480-200 240-440l56-56 184 183 184-183 56 56-240 240Zm0-240L240-680l56-56 184 183 184-183 56 56-240 240Z" />
                </svg>
              }
            />
          </div>
          <div className="col-12 col-sm-6">
            <Attribute
              header={advertisement.salaryTo}
              svgIcon={
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  height="24px"
                  viewBox="0 -960 960 960"
                  width="24px"
                  fill="#000000"
                >
                  <path d="m296-224-56-56 240-240 240 240-56 56-184-183-184 183Zm0-240-56-56 240-240 240 240-56 56-184-183-184 183Z" />
                </svg>
              }
            />
          </div>
        </div>
        {roles.includes("ROLE_ADMIN") ? (
          <div className="row">
            <EditPopupTrigger
              variant="advertisement"
              element={advertisement}
              refreshMethod={refreshMethod}
            />
          </div>
        ) : (
          ""
        )}
      </div>
    </Card>
  );
}
