import Card from "components/common/Card/Card";
import { Link } from "react-router-dom";
import { useUser } from "hooks/useUser";
import { EditPopupTrigger } from "components/EditPopup/EditPopup";
import { DeleteButtonUser } from "components/common/DeleteButtonUser/DeleteButtonUser";

export default function Links() {
  const { user } = useUser();
  const { accountLinks } = user.account;
  return (
    <Card
      header="Linki"
      bootstrapFontsize="fs-5"
      headerCenter="text-center"
      id="linki"
    >
      <ul className="list-group list-group-flush">
        {accountLinks.map((value) => {
          return (
            <li className="list-group-item">
              <Link
                className="text-decoration-none text-center"
                to={value.hyperlink}
              >
                {value.name}
              </Link>
              <DeleteButtonUser variant="Link" uuid={value.uuid} />
              <EditPopupTrigger variant="Link" element={value} />
            </li>
          );
        })}
      </ul>
      <EditPopupTrigger variant="Link" />
    </Card>
  );
}
