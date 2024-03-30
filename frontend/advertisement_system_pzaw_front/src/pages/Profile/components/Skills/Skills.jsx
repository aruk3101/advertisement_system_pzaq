import Card from "components/common/Card/Card";
import { useUser } from "hooks/useUser";

export default function Skills() {
  const { user } = useUser();
  const { accountSkills } = user.account;
  return (
    <Card header="Umiejętności" id="umiejetnosci">
      <ul class="list-group list-group-flush">
        {accountSkills.map((value) => {
          return <li className="list-group-item">{value.skillName}</li>;
        })}
      </ul>
    </Card>
  );
}
