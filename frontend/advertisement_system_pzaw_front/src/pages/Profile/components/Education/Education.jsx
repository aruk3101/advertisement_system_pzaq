import Card from "components/common/Card/Card";
import ListElement from "../ListElement/ListElement";
import { useUser } from "hooks/useUser";

export default function Education() {
  const { user } = useUser();
  const { accountEducations } = user.account;
  return (
    <Card header="Wykształcenie" id="wyksztalcenie">
      <ul class="list-group list-group-flush">
        {accountEducations.map((value) => {
          return (
            <ListElement
              h1={value.schoolName}
              h2={value.specialization}
              location={value.schoolLocation}
              period_start={value.periodStart}
              period_end={value.periodEnd}
              level={value.educationLevel.name}
            />
          );
        })}
      </ul>
    </Card>
  );
}
