import Card from "components/common/Card/Card";
import { useUser } from "hooks/useUser";

export default function CurrentPosition() {
  const { user } = useUser();
  return (
    <Card header="Aktualne Stanowisko Pracy" id="stanowisko">
      {user.account.currentPosition}
    </Card>
  );
}
