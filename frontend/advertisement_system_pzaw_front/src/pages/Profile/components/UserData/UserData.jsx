import defaultPfpIcon from "assets/images/defaultPfp.webp";
import Card from "components/common/Card/Card";
import { useUser } from "hooks/useUser";

export default function UserData() {
  const { user } = useUser();
  console.log(user);
  return (
    <Card
      header={`${user.account.firstName} ${user.account.lastName}`}
      beforeContent={
        <div className=" banner position-relative bg-info rounded-top">
          <img
            src={defaultPfpIcon}
            className="object-fit-cover rounded-circle border border-5 border-info position-absolute pfp"
            width={200}
            height={200}
          />
        </div>
      }
    >
      <span>34-600 Limanowa, &nbsp;</span>
      <span>PL</span>
    </Card>
  );
}
