import { toHaveAccessibleDescription } from "@testing-library/jest-dom/matchers";
import Card from "components/common/Card/Card";
import InputGroup from "components/common/InputGroup/InputGroup";
import { useUser } from "hooks/useUser";

export default function Languages() {
  const { user } = useUser();
  const { accountLanguages } = user.account;
  return (
    <Card
      header="Języki"
      bootstrapFontsize="fs-5"
      headerCenter="text-center"
      id="jezyki"
    >
      {accountLanguages.map((value, index) => {
        return (
          <InputGroup
            id={"language-addon-" + index}
            firstElement={value.languageLevel.name}
            aria_label={"language-addon-" + index}
            value={value.language}
          />
        );
      })}
    </Card>
  );
}
