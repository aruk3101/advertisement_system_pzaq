import Card from "components/common/Card/Card";
import ListElement from "../ListElement/ListElement";
import { useUser } from "hooks/useUser";

export default function Courses() {
  const { user } = useUser();
  const { accountCertificates } = user.account;
  return (
    <Card header="Kursy, szkolenia itp." id="kursy">
      <ul class="list-group list-group-flush">
        {accountCertificates.map((value) => {
          return (
            <ListElement
              h1={value.name}
              h2={value.host}
              date={value.date.slice(0, 10)}
            />
          );
        })}
      </ul>
    </Card>
  );
}
