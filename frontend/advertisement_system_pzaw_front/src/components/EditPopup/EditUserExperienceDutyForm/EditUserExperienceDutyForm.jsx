import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace";
import useForm from "hooks/useForm";
import Form from "components/common/Form/Form";
import Input from "components/common/Input/Input";
import Submit from "components/common/Submit/Submit";
import SpinnerView from "components/common/SpinnerView/SpinnerView";
import useAddEditUserExperienceDuty from "hooks/useAddEditExperienceDuty";

export default function EditUserExperienceDutyForm({
  forceClose,
  secondaryUuid,
}) {
  const { handleSubmit, Alerts, isLoading } = useAddEditUserExperienceDuty();
  var dto = {
    accountExperienceUuid: secondaryUuid,
    duty: "",
  };
  const { data, handleChange } = useForm(dto);

  return (
    <div className="container-md">
      <SpinnerView isLoading={isLoading}>
        <div className="row">
          <EmptyGridSpace xs="0" md="1" />
          <Form
            className="col"
            method="post"
            onSubmit={(event) => handleSubmit(event, data, forceClose)}
          >
            <Input
              placeholder="Obowiązek"
              name="duty"
              type="text"
              id="duty"
              value={data["duty"]}
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
