import { DeleteButton } from "components/common/DeleteButton/DeleteButton";
import { useAuth } from "hooks/useAuth";

export default function ListItem({
  text,
  svg,
  variant,
  uuid,
  refreshMethod = null,
}) {
  const { roles } = useAuth();
  return (
    <div className="d-flex m-2 align-items-center container">
      <div className="row w-100">
        <div className="col-10">
          <span className="me-2 m-1">{svg}</span>
          <span className="text-black">{text}</span>
        </div>
        <div className="col-2">
          {roles != null && roles.includes("ROLE_ADMIN") ? (
            <DeleteButton
              variant={variant}
              uuid={uuid}
              refreshMethod={refreshMethod}
            />
          ) : (
            ""
          )}
        </div>
      </div>
    </div>
  );
}
