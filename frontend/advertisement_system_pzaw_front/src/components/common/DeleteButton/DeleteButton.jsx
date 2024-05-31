import editIcon from "assets/images/edit-icon.svg";
import { DeleteOpportunity } from "services/api/OpportunityService";
import { DeleteRequirement } from "services/api/RequirementService";
import { DeleteResponsiblity } from "services/api/ResponsibilityService";
export function DeleteButton({ variant, className, uuid, refreshMethod }) {
  const onclick = (event) => {
    switch (variant) {
      case "Responsibility":
        DeleteResponsiblity(uuid).then(() => {
          if (refreshMethod != null) {
            refreshMethod();
          }
        });
        break;
      case "Requirement":
        DeleteRequirement(uuid).then(() => {
          if (refreshMethod != null) {
            refreshMethod();
          }
        });
        break;
      case "Opportunity":
        DeleteOpportunity(uuid).then(() => {
          if (refreshMethod != null) {
            refreshMethod();
          }
        });
        break;
    }
  };

  return (
    <button
      type="button"
      className={"btn btn-danger " + className}
      style={{
        width: "50px",
        height: "50px",
      }}
      variant={variant}
      onClick={onclick}
    >
      <img src={editIcon} alt="Usuń" />
    </button>
  );
}
