import { EditPopupTrigger } from "components/EditPopup/EditPopup";
import Card from "components/common/Card/Card";
import { useUser } from "hooks/useUser";
import { DeleteButtonUser } from "components/common/DeleteButtonUser/DeleteButtonUser";

export default function Skills() {
  const { user } = useUser();
  const { accountSkills } = user.account;
  return (
    <Card header="Umiejętności" id="umiejetnosci">
      <ul class="list-group list-group-flush">
        {accountSkills.map((value) => {
          return (
            <li className="list-group-item">
              {value.skillName}
              <DeleteButtonUser variant="Skill" uuid={value.uuid} />
              <EditPopupTrigger variant="Skill" element={value} />
            </li>
          );
        })}
      </ul>
      <EditPopupTrigger variant="Skill" />
    </Card>
  );
}
