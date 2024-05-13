import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace";
import useForm from "hooks/useForm";
import Form from "components/common/Form/Form";
import Input from "components/common/Input/Input";
import Submit from "components/common/Submit/Submit";
import SpinnerView from "components/common/SpinnerView/SpinnerView";
import Select from "components/common/Select/Select";
import useAddEditUserEducation from "hooks/useAddEditUserEducation";

export default function EditUserEducationForm({ forceClose, element }) {
  const { handleSubmit, Alerts, isLoading } = useAddEditUserEducation();
  var dto = {
    schoolName: "",
    schoolLocation: "",
    educationLevelUuid: "",
    specialization: "",
    periodStart: "",
    periodEnd: "",
    version: 0,
  };
  if (element != null) {
    dto = element;
  }
  const { data, handleChange } = useForm(dto);

  return (
    <div className="container-md">
      <SpinnerView isLoading={isLoading}>
        <div className="row">
          <EmptyGridSpace xs="0" md="1" />
          <Form
            className="col"
            method="post"
            onSubmit={(event) => handleSubmit(event, data, forceClose, element)}
          >
            <Input
              placeholder="Nazwa szkoły"
              name="schoolName"
              type="text"
              id="schoolName"
              value={data["schoolName"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Adres"
              name="schoolLocation"
              type="text"
              id="schoolLocation"
              value={data["schoolLocation"]}
              handleChange={handleChange}
              required="required"
            />
            <Select
              placeholder="Adres"
              name="educationLevelUuid"
              id="educationLevelUuid"
              value={data["educationLevelUuid"]}
              handleChange={handleChange}
              required="required"
              options={[
                {
                  value: "70d532aa-94d6-45bb-bf79-6236d21c36b0",
                  name: "Podstawowe",
                },
                {
                  value: "4dde0ae4-c4b0-4739-8980-e6a933038af9",
                  name: "Średnie",
                },
              ]}
            ></Select>
            <Input
              placeholder="Specjalizacja"
              name="specialization"
              type="text"
              id="specialization"
              value={data["specialization"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Początek"
              name="periodStart"
              type="date"
              id="periodStart"
              value={data["periodStart"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Koniec"
              name="periodEnd"
              type="date"
              id="periodEnd"
              value={data["periodEnd"]}
              handleChange={handleChange}
              required="required"
            />
            <Submit value="Prześlij" />
            <Alerts />
          </Form>
          <EmptyGridSpace xs="0" md="1" />
        </div>
      </SpinnerView>
    </div>
  );
}
