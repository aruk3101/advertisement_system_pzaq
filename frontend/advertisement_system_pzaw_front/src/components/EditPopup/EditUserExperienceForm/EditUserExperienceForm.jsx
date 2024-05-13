import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace";
import useForm from "hooks/useForm";
import Form from "components/common/Form/Form";
import Input from "components/common/Input/Input";
import Submit from "components/common/Submit/Submit";
import SpinnerView from "components/common/SpinnerView/SpinnerView";
import Select from "components/common/Select/Select";
import useAddEditUserExperience from "hooks/useAddEditUserExperience";

export default function EditUserExperienceForm({ forceClose, element }) {
  const { handleSubmit, Alerts, isLoading } = useAddEditUserExperience();
  var dto = {
    position: "",
    companyName: "",
    location: "",
    periodStart: "",
    periodEnd: "",
    createAccountExperienceDutyDtos: [],
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
              placeholder="Stanowisko"
              name="position"
              type="text"
              id="position"
              value={data["position"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Przedsiębiorstwo"
              name="companyName"
              type="text"
              id="companyName"
              value={data["companyName"]}
              handleChange={handleChange}
              required="required"
            />
            <Input
              placeholder="Adres przedsiębiorstwa"
              name="location"
              type="text"
              id="location"
              value={data["location"]}
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
