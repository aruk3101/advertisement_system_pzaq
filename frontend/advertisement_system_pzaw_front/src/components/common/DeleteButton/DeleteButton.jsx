import { useUser } from "hooks/useUser";
import { DeleteUserEducation } from "services/api/UserEducationService";
import editIcon from "assets/images/edit-icon.svg";
import { DeleteUserSkill } from "services/api/UserSkillsService";
import { DeleteUserCourse } from "services/api/UserCoursesService";
import { DeleteUserLink } from "services/api/UserLinksService";
import { DeleteUserLanguage } from "services/api/UserLanguagesService";
import {
  DeleteUserExperience,
  DeleteUserExperienceDuty,
} from "services/api/UserExperienceService";

export function DeleteButton({ variant, className, uuid }) {
  const { refresh } = useUser();
  const onclick = (event) => {
    switch (variant) {
      case "Education":
        DeleteUserEducation(uuid).then(() => {
          refresh();
        });
        break;
      case "Skill":
        DeleteUserSkill(uuid).then(() => {
          refresh();
        });
        break;
      case "Course":
        DeleteUserCourse(uuid).then(() => {
          refresh();
        });
        break;
      case "Link":
        DeleteUserLink(uuid).then(() => {
          refresh();
        });
        break;
      case "Language":
        DeleteUserLanguage(uuid).then(() => {
          refresh();
        });
        break;
      case "Experience":
        DeleteUserExperience(uuid).then(() => {
          refresh();
        });
        break;
      case "Duty":
        DeleteUserExperienceDuty(uuid).then(() => {
          refresh();
        });
        break;
    }
  };

  return (
    <button
      type="button"
      className={"btn btn-primary " + className}
      style={{
        width: "50px",
        height: "50px",
      }}
      variant={variant}
      onClick={onclick}
    >
      <img src={editIcon} alt="Edytuj" />
    </button>
  );
}
