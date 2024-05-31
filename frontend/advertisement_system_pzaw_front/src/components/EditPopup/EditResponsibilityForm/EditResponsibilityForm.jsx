import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace";
import useForm from "hooks/useForm";
import Form from "components/common/Form/Form";
import Input from "components/common/Input/Input";
import Submit from "components/common/Submit/Submit";
import SpinnerView from "components/common/SpinnerView/SpinnerView";
import useAddResponsibility from "hooks/useAddResponsibility";

export default function EditResponsibilityForm({
  forceClose,
  uuid,
  refreshMethod = null,
}) {
  const { handleSubmit, Alerts, isLoading } = useAddResponsibility();
  var dto = {
    advertisementUuid: uuid,
    name: "",
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
            onSubmit={(event) =>
              handleSubmit(event, data, forceClose, refreshMethod)
            }
          >
            <Input
              placeholder="Nazwa"
              name="name"
              type="text"
              id="name"
              value={data["name"]}
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
