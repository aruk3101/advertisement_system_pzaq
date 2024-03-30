import ListElement from "../ListElement/ListElement";
import Card from "components/common/Card/Card";
import { useUser } from "hooks/useUser";

export default function Experience() {
  const { user } = useUser();
  const { accountExperiences } = user.account;
  return (
    <Card header="Doświadczenie" id="doswiadczenie">
      <ul class="list-group list-group-flush">
        {accountExperiences.map((value) => {
          return (
            <ListElement
              h1={value.companyName}
              h2={value.position}
              location={value.location}
              period_start={value.periodStart}
              period_end={value.periodEnd}
              duties={value.accountExperienceDuties.map((value) => {
                return value.duty;
              })}
            />
          );
        })}
      </ul>
    </Card>
  );
}
