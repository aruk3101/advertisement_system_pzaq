import defaultPfpIcon from "assets/images/defaultPfp.webp";
import Card from "components/common/Card/Card";
import { useUser } from "hooks/useUser";
import { BASE_URL } from "services/api/AxiosService";
import { EditPopupTrigger } from "components/EditPopup/EditPopup";

export default function UserData() {
  const { user } = useUser();
  return (
    <Card
      header={`${user.account.firstName} ${user.account.lastName}`}
      beforeContent={
        <div className=" banner position-relative bg-info rounded-top">
          <img
            src={
              user.account.profilePictureSource != null
                ? BASE_URL() + user.account.profilePictureSource
                : defaultPfpIcon
            }
            className="object-fit-cover rounded-circle border border-5 border-info position-absolute pfp"
            width={200}
            height={200}
          />
        </div>
      }
    >
      <div className="d-flex align-items-center">
        {user.account.address !== null ? (
          <>
            <span>
              {user.account.address.city} , {user.account.address.postalCode}{" "}
              {user.account.address.postalName}, &nbsp;
            </span>
            <span>{user.account.address.country}</span>
          </>
        ) : (
          ""
        )}
        <div className="flex-grow-1 d-flex justify-content-end">
          <EditPopupTrigger variant={"UserData"} />
        </div>
      </div>
    </Card>
  );
}
