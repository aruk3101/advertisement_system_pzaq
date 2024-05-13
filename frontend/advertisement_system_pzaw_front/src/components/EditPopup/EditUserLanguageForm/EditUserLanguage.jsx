import EmptyGridSpace from "components/common/EmptyGridSpace/EmptyGridSpace";
import useForm from "hooks/useForm";
import Form from "components/common/Form/Form";
import Input from "components/common/Input/Input";
import Submit from "components/common/Submit/Submit";
import SpinnerView from "components/common/SpinnerView/SpinnerView";
import Select from "components/common/Select/Select";
import useAddEditUserLanguage from "hooks/useAddEditUserLanguage";

export default function EditUserLanguageForm({ forceClose, element }) {
  const { handleSubmit, Alerts, isLoading } = useAddEditUserLanguage();
  var dto = {
    language: "",
    languageLevelUuid: "",
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
              placeholder="Język"
              name="language"
              type="text"
              id="language"
              value={data["language"]}
              handleChange={handleChange}
              required="required"
            />
            <Select
              placeholder="Poziom"
              name="languageLevelUuid"
              id="languageLevelUuid"
              value={data["languageLevelUuid"]}
              handleChange={handleChange}
              required="required"
              options={[
                {
                  value: "13e2e17c-87e0-4dec-ac9f-8f743aae6c4f",
                  name: "A1",
                },
                {
                  value: "cc2234bb-c55e-49d7-853e-b552bb908900",
                  name: "A2",
                },
              ]}
            ></Select>
            <Submit value="Prześlij" />
            <Alerts />
          </Form>
          <EmptyGridSpace xs="0" md="1" />
        </div>
      </SpinnerView>
    </div>
  );
}
