import Card from "components/common/Card/Card";
import { useUser } from "hooks/useUser";

export default function CareerSummary() {
  const { user } = useUser();
  return (
    <Card header="Podsumowanie zawodowe" id="podsumowanie">
      {user.account.careerSummary}
    </Card>
  );
}
